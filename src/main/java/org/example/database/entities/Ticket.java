package org.example.database.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Table(name = "tickets")
@Entity
public class Ticket {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    Client client;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "created")
    private Instant created;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_planet_id", referencedColumnName = "id")
    private Planet fromPlanet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_planet_id", referencedColumnName = "id")
    private Planet toPlanet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Planet getFromPlanet() {
        return fromPlanet;
    }

    public void setFromPlanet(Planet fromPlanet) {
        this.fromPlanet = fromPlanet;
    }

    public Planet getToPlanet() {
        return toPlanet;
    }

    public void setToPlanet(Planet toPlanet) {
        this.toPlanet = toPlanet;
    }
}
