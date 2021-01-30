package com.pjc.api.service;

import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class FileManager {

    private static final String BUCKET_NAME = "teste-pjc";
    private static final String BASE_IMAGES = System.getProperty("user.dir") + "\\imagem\\";

    public MinioClient createMinioClient() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        MinioClient minioClient = MinioClient.builder()
                .endpoint("https://play.min.io")
                .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                .build();

        boolean found =
                minioClient.bucketExists(BucketExistsArgs.builder().bucket(BUCKET_NAME).build());
        if (!found) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(BUCKET_NAME).build());
        } else {
            System.out.println("Bucket 'testepjc' já existe.");
        }

        return minioClient;
    }

    public void upload(List<MultipartFile> files) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {

        try {
            MinioClient minioClient = createMinioClient();

            for (MultipartFile file : files) {
                minioClient.uploadObject(
                        UploadObjectArgs.builder()
                                .bucket(BUCKET_NAME)
                                .object(file.getOriginalFilename())
                                .filename(BASE_IMAGES + file.getOriginalFilename())
                                .build());
            }
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }

    public ResponseEntity getImage() throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, ServerException, ErrorResponseException, XmlParserException, InsufficientDataException, InternalException {
        MinioClient minioClient = createMinioClient();
        return ResponseEntity.ok(
                minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .method(Method.GET)
                        .bucket(BUCKET_NAME)
                        .object("album-1.jpg")
                        .expiry(1, TimeUnit.DAYS)
                        .build()));
    }
}
