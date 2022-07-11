package com.alla.youtubeclone.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(value = "User")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private  String fullName;
    private  String emailAddress;
    private Set<String> SubscribedToUsers;
    private Set<String> Subscribers;
    private List<String> videoHistory;
    private  Set<String> likedVideos;
    private  Set<String> dislikedVideos ;
}
