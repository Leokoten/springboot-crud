package br.com.qtivate.server.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Student {
    private final UUID id;
    private final String ra;
    private final String name;


    public Student(@JsonProperty("id") UUID id,
                   @JsonProperty("ra") String ra,
                   @JsonProperty("name") String name) {
        this.id = id;
        this.ra = ra;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getRA() {
        return ra;
    }

    public String getName() {
        return name;
    }
}
