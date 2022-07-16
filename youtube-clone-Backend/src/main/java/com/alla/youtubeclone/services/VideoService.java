package com.alla.youtubeclone.services;

import com.alla.youtubeclone.dto.VideoDto;
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


    public String uploadVideo(MultipartFile file)
    {
        //Upload video to AWS
        //save video data to database

        String videoUrl=s3Service.uploadFile(file);
        var video =new Video();
        video.setVideoUrl(videoUrl);
        videoRepository.save(video);
        return  videoUrl;

    }

    public VideoDto editVideo(VideoDto videodto) {
        // Find the video by VideoId
     Video savedVideo= videoRepository.findById(videodto.getId()).orElseThrow(()
              ->new IllegalArgumentException("Cannot find the Id"+videodto.getId()));
        // Map the Videodto fields to Video

        savedVideo.setTitle(videodto.getTitle());
        savedVideo.setDescription(videodto.getDescription());
        savedVideo.setTags(videodto.getTags());
        savedVideo.setVideoUrl(videodto.getVideoUrl());
        savedVideo.setThumbnailUrl(videodto.getThumbnailUrl());
        savedVideo.setVideoStatus(videodto.getVideoStatus());

        //Save the video to Database
        videoRepository.save(savedVideo);
        return videodto;
    }

    public String uploadThumbnail(MultipartFile file, String videoId) {

        Video savedVideo= videoRepository.findById(videoId).orElseThrow(()
                ->new IllegalArgumentException("Cannot find the Id"+videoId));

        String thumbnailUrl=s3Service.uploadFile(file);
        savedVideo.setThumbnailUrl(thumbnailUrl);
        videoRepository.save(savedVideo);
        return thumbnailUrl;

    }
}
