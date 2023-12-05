package com.bruno13palhano.model;

import java.time.OffsetDateTime;

public class DataVersion {
    private Long id;
    private String name;
    private OffsetDateTime timestamp;

    public DataVersion() {}

    public DataVersion(Long id, String name, OffsetDateTime timestamp) {
        this.id = id;
        this.name = name;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
