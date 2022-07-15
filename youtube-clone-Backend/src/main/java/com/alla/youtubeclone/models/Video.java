package com.alla.youtubeclone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value = "Video")
@AllArgsConstructor @NoArgsConstructor
@Data
public class Video {
    @Id
    private String id;
    private String description;
    private String title;
    private String userId;
    private Integer likes;
    private Integer dislikes;
    private Set<String> tags;
    private VideoStatus videoStatus;
    private Integer viewCount;
    private String thumbnailUrl;
    private String videoUrl;
    private List<Comment> comments;


}
