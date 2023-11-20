package org.example;

import jakarta.persistence.Entity;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.example.database.FlywayConfig;
import org.example.database.entities.Client;
import org.example.database.entities.Planet;
import org.example.database.repositories.ClientCrud;
import org.example.database.repositories.PlanetCrud;

import java.util.Scanner;


@Entity
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    private static final String MESSAGE = "Enter any number";

    public static void main(String[] args) {
        logger.setLevel(Level.INFO);
        System.out.println("Hello world!");
        logger.info("Hello world");
        FlywayConfig.fwMigration();
        Scanner scanner = new Scanner(System.in);

        ClientCrud clientCrud = new ClientCrud();

        Client newClient = new Client();
        newClient.setName("Пантелеймон");
        clientCrud.persist(newClient);

        Client client;
        client = clientCrud.getByID(2L);
        logger.info(client);
        client.setName("Орест");
        clientCrud.merge(client);

        int temp = 0;

        while (temp == 0) {
            logger.info(MESSAGE);
            temp = scanner.nextInt();
        }
        clientCrud.remove(client);

        PlanetCrud planetCrud = new PlanetCrud();

        Planet newPlanet = new Planet();
        newPlanet.setId("ANDR");
        newPlanet.setName("Андромеда");
        planetCrud.persist(newPlanet);

        Planet newPlanet2 = new Planet();
        newPlanet2.setId("TEST");
        newPlanet2.setName("Тест");
        planetCrud.persist(newPlanet2);
        int temp2 = 0;
        while (temp2 == 0) {
            logger.info(MESSAGE);
            temp2 = scanner.nextInt();
        }
        planetCrud.remove(newPlanet2);

        int temp1 = 0;
        while (temp1 == 0) {
            logger.info(MESSAGE);
            temp1 = scanner.nextInt();
        }
        scanner.close();

        Planet planetToMerge = planetCrud.getByID("ANDR");
        planetToMerge.setName("Андромеда1");
        planetCrud.merge(planetToMerge);

        Planet newPlanet3 = new Planet();
        try {
            newPlanet3.setId("Test");
            newPlanet3.setName("Тест");
            planetCrud.persist(newPlanet3);
        }catch (IllegalArgumentException e){
            logger.info(e.getMessage());
        }

    }
}