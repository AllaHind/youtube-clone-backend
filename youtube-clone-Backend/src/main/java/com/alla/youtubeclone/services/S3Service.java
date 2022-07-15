package com.alla.youtubeclone.services;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
@RequiredArgsConstructor
@Service
public class S3Service implements FileService {

    public static final String BUCKET = "ytb-clone-bucket";
    private final AmazonS3Client amazonS3Client;

    @Override
    public String uploadFile(MultipartFile file) { //upload file to AWS
        //prepareKey
        var fileNameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        var key = UUID.randomUUID().toString() +"."+ fileNameExtension;

        var metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());
        try {
            amazonS3Client.putObject(BUCKET, key, file.getInputStream(), metadata);
        } catch (IOException e) {
            e.printStackTrace();
        }
        amazonS3Client.setObjectAcl(BUCKET,key,CannedAccessControlList.PublicRead);

        return amazonS3Client.getResourceUrl(BUCKET,key);
    }
}
