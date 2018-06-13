package com.example.stherokubackend.database;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBProperties {

    private String user;
    private int port;
    private String dbName;
    private String host;
    private String password;
}
