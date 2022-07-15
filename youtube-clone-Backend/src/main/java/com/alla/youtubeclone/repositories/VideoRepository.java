package com.alla.youtubeclone.repositories;

import com.alla.youtubeclone.models.Video;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<Video,String> {
}
