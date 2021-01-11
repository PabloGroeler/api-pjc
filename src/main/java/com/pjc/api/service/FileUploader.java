package com.pjc.api.service;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.UploadObjectArgs;
import io.minio.errors.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class FileUploader {

    public void upload() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {

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

            // Upload '/home/user/Photos/asiaphotos.zip' as object name 'asiaphotos-2015.zip' to bucket
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("teste-pjc")
                            .object("teste-pjc-2021.zip")
                            .filename("/home/user/Photos/asiaphotos.zip")
                            .build());
            System.out.println(
                    "'/home/user/Photos/asiaphotos.zip' is successfully uploaded as "
                            + "object 'asiaphotos-2015.zip' to bucket 'asiatrip'.");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}
