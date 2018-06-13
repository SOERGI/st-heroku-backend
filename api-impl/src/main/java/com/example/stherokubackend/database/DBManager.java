package com.example.stherokubackend.database;

import com.example.stherokubackend.core.LoggerConstants;
import lombok.Getter;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

public class DBManager {

    private static final Logger LOGGER = Logger.getLogger(LoggerConstants.DB_LOG);

    @Getter
    private final DBProperties settings;

    private final Properties connectionProperties;
    private Connection connection;

    public DBManager(DBProperties settings) {
        this.settings = settings;
        connectionProperties = new Properties();
        connectionProperties.put("user", settings.getUser());
        connectionProperties.put("password", settings.getPassword());

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Error while initializing the driver", e);
        }
    }

    private Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(buildConnectionString(), connectionProperties);
            LOGGER.info("Established database connection");
        }
        return connection;
    }

    public DSLContext getDSLContext() throws SQLException {
        return DSL.using(getConnection(), SQLDialect.POSTGRES);
    }

    public String buildConnectionString() {
        return "jdbc:postgresql://" +
                settings.getHost() +
                ":" +
                settings.getPort() +
                "/" +
                settings.getDbName() +
                "?autoreconnect=true";
    }
}
