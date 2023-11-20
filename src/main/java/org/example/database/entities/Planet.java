package org.example.database.entities;

import jakarta.persistence.*;

@Table(name = "planets")
@Entity
public class Planet {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        String pattern = "^[A-Z0-9]*$";
        if (id.matches(pattern)) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("It should contain only latin letter in uppercase and digits");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
