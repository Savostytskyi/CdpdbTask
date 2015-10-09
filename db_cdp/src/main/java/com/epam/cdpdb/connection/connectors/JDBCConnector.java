package com.epam.cdpdb.connection.connectors;

import com.epam.cdpdb.connection.AbstractConnection;
import com.epam.cdpdb.constants.Constants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import static com.epam.cdpdb.beans.DBTypeData.getDbType;

/**
 * @author  Savostytskyi Anton on 06.10.2015.
 */

public class JDBCConnector extends AbstractConnection {

    public static ResourceBundle resource;
    public static String url;
    public static String user;
    public static String pass;

    static  {
        resource= ResourceBundle.getBundle(Constants.RESOURCE_BUNDLE_NAME);
        url= getDbType().url;
        user=resource.getString("db.user");
        pass=resource.getString("db.password");
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

}
