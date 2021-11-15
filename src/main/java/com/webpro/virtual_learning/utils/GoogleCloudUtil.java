package com.webpro.virtual_learning.utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.common.collect.Lists;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class GoogleCloudUtil {
    public static Boolean upFileToGoogleCloud(String fileName, byte[] data) {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("google_cloud");

            String projectId = rb.getString("project.id");
            String bucketName = rb.getString("bucket.name");
            String authFilePath = rb.getString("auth.file.path");
            String platformLink = rb.getString("platform.link");

            File authFile = ResourceUtils.getFile(authFilePath);
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(authFile.toPath().toString()))
                    .createScoped(Lists.newArrayList(platformLink));
            Storage storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(credentials).build().getService();
            BlobId blobId = BlobId.of(bucketName, fileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
//            File file = ResourceUtils.getFile("classpath:test_object.txt");
//            byte[] sendFile = Files.readAllBytes(file.toPath());
            storage.create(blobInfo, data);

            System.out.println(
                    "File " + fileName + " uploaded to bucket " + bucketName);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public static byte[] getFileFromGoogleCloud(String fileName){
        try {
            ResourceBundle rb = ResourceBundle.getBundle("google_cloud");
            String projectId = rb.getString("project.id");
            String bucketName = rb.getString("bucket.name");
            String authFilePath = rb.getString("auth.file.path");
            String platformLink = rb.getString("platform.link");
            String anchorPath = rb.getString("anchor.path");

            File authFile = ResourceUtils.getFile(authFilePath);
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(authFile.toPath().toString()))
                    .createScoped(Lists.newArrayList(platformLink));
            Storage storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(credentials).build().getService();

            Blob blob = storage.get(BlobId.of(bucketName, fileName));
            File fileTmp = ResourceUtils.getFile(anchorPath);
            String downloadedPath = fileTmp.getAbsolutePath().split("anchor.file")[0];
            blob.downloadTo(ResourceUtils.getFile(downloadedPath + fileName).toPath());

            System.out.println(
                    "Downloaded object "
                            + fileName
                            + " from bucket name "
                            + bucketName
                            + " to "
                            + downloadedPath + fileName);

            return Files.readAllBytes(Paths.get(downloadedPath + fileName));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
