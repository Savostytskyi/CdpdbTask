package com.epam.cdpdb.connection.connectors;

import java.sql.*;
import java.util.ResourceBundle;
import com.epam.cdpdb.connection.AbstractConnection;
import com.epam.cdpdb.constants.Constants;
import org.apache.commons.dbcp2.BasicDataSource;
import static com.epam.cdpdb.beans.DBTypeData.getDbType;

/**
 * @author Savostytskyi Anton on 07.10.2015.
 */
public class DBCPConnector extends AbstractConnection {

  public static BasicDataSource connectionPool;
  public static ResourceBundle resource;

  static {
    resource = ResourceBundle.getBundle(Constants.RESOURCE_BUNDLE_NAME);
    connectionPool = new BasicDataSource();
    connectionPool.setUsername(resource.getString("db.user"));
    connectionPool.setPassword(resource.getString("db.password"));
    connectionPool.setDriverClassName(resource.getString("db.driver"));
    connectionPool.setUrl(getDbType().url);
    connectionPool.setMaxTotal(10);
    connectionPool.setMaxIdle(5);
    connectionPool.setInitialSize(1);
  }

  public Connection getConnection() throws SQLException {
    return connectionPool.getConnection();
  }
}
