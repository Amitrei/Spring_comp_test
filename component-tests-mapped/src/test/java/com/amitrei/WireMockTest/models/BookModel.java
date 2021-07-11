package com.amitrei.WireMockTest.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {


    @NonNull
    private String name;
    @NonNull
    private int sales;
    @NonNull
    private List<AuthorModel> authorList;
}

