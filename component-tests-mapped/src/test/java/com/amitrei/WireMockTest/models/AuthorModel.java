package com.amitrei.WireMockTest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorModel {

    @NonNull
    private String authorName;
    @NonNull
    private int age;
}
