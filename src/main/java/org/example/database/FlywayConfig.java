package org.example.database;


import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;


public class FlywayConfig {
    public static final String jdbcUrl = "jdbc:mysql://localhost:3306/space_travel";
    public static final String username = "root";
    public static final String password = "5A31BFCE9005A14572383C98F462BA2F";
    private static final Logger logger = Logger.getLogger(FlywayConfig.class);

    private FlywayConfig() {
    }

    public static void fwMigration() {
        logger.debug("Migrated successfully");

        Flyway.configure()
                .dataSource(jdbcUrl, username, password)
                .locations("classpath:flyway.scripts")
                .load()
                .migrate();

    }
}
