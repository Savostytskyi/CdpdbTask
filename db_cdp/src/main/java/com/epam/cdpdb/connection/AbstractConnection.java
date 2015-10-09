package com.epam.cdpdb.connection;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Savostytskyi Anton on 07.10.2015.
 */
public abstract class AbstractConnection {

    public abstract Connection getConnection() throws URISyntaxException, SQLException;

}
