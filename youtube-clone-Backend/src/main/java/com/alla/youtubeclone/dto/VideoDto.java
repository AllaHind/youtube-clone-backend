package com.alla.youtubeclone.dto;


import com.alla.youtubeclone.models.VideoStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor @AllArgsConstructor
public class VideoDto {
    private String id;
    private String description;
    private String title;
    private Set<String> tags;
    private VideoStatus videoStatus;
    private String thumbnailUrl;
    private String videoUrl;
}
