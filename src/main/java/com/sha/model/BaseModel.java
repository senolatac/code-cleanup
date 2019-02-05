package com.sha.model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
