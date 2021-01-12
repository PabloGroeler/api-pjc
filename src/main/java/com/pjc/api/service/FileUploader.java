package com.pjc.api.service;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class FileUploader {

    public void upload(List<MultipartFile> files) throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {

        try {
            MinioClient minioClient =
                    MinioClient.builder()
                            .endpoint("https://play.min.io")
                            .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                            .build();

            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket("teste-pjc").build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(" // Montar 'teste-pjc' bucket se não existir.\n").build());
            } else {
                System.out.println("Bucket 'teste-pjc' já existe.");
            }

            MultipartFile multipartFile = files.get(1);
            String nome = multipartFile.getOriginalFilename();
            for (MultipartFile file : files) {
                minioClient.uploadObject(
                        UploadObjectArgs.builder()
                                .bucket("teste-pjc")
                                .object(file.getOriginalFilename()) /// FIX
                                .filename("C:\\images\\" + file.getOriginalFilename())
                                .build());
            }
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
