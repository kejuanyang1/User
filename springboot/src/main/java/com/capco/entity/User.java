package com.capco.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)

public class User {
    private Integer id;
    private String name;
    private String password;
    private Integer num;
    private String tel;
    private String job;

}
