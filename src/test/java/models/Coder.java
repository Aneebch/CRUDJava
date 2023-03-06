package models;

import java.util.UUID;

public class Coder {
    private UUID id;
    private String name;

    public Coder(String name){
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public Coder() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}

