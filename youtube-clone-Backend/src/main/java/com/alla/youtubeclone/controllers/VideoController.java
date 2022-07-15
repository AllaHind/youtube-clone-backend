package com.alla.youtubeclone.controllers;

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
    public void uploadVideo(@RequestParam("file") MultipartFile file)
    {
          videoService.uploadVideo(file);
    }

}
