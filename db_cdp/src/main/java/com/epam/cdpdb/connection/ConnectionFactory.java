package com.epam.cdpdb.connection;

import com.epam.cdpdb.beans.DBTypeData;
import com.epam.cdpdb.connection.connectors.DBCPConnector;
import com.epam.cdpdb.connection.connectors.JDBCConnector;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Savostytskyi Anton on 07.10.2015.
 */
public class ConnectionFactory {

    public static Connection getConnection() throws URISyntaxException, SQLException {
        switch (DBTypeData.getDbConnectionType()) {
            case JDBC:
                return new JDBCConnector().getConnection();
            case DBCP:
                return new DBCPConnector().getConnection();
            default:
                return new JDBCConnector().getConnection();
        }
    }
}

