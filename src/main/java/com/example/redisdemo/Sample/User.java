package com.example.redisdemo.Sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    @Id
    private int userId;
    private String name;
}
