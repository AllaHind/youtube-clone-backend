package com.alla.youtubeclone.services;

import com.alla.youtubeclone.models.Video;
import com.alla.youtubeclone.repositories.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class VideoService {
@Autowired
private final S3Service s3Service;
@Autowired
private final VideoRepository videoRepository;
    public void uploadVideo(MultipartFile file)
    {
        //Upload video to AWS
        //save video data to database

        String videoUrl=s3Service.uploadFile(file);
        var video =new Video();
        video.setVideoUrl(videoUrl);
        videoRepository.save(video);
    }
}
