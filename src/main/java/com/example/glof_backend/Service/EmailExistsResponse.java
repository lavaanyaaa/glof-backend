package com.example.glof_backend.Service;

public class EmailExistsResponse {

    private final boolean exists;

    public EmailExistsResponse(boolean exists) {
        this.exists = exists;
    }

    public boolean isExists() {
        return exists;
    }

}
