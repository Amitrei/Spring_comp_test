package com.amitrei.WireMockTest.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
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

    @JsonRawValue
    private Object authorList = "[\n" +
            "        {\n" +
            "            \"authorName\":\"finalmoshe\",\n" +
            "            \"age\":1132352\n" +
            "        }\n" +
            "    ]\n";
}

