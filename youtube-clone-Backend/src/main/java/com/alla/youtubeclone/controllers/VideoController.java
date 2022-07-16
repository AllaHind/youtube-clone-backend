package com.alla.youtubeclone.controllers;

import com.alla.youtubeclone.dto.VideoDto;
import com.alla.youtubeclone.services.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin("*")
@RequiredArgsConstructor
public class VideoController {

    @Autowired
    private final VideoService videoService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String uploadVideo(@RequestParam("file") MultipartFile file)
    {
       return   videoService.uploadVideo(file);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public VideoDto editVideoMetaData(@RequestBody VideoDto videodto){
        return videoService.editVideo(videodto);
    }

    @PostMapping("/Thumbnail")
    @ResponseStatus(HttpStatus.OK)
    public String uploadThumbnail(@RequestParam("file") MultipartFile file,String videoId)
    {
        return  videoService.uploadThumbnail(file,videoId);
    }
}
