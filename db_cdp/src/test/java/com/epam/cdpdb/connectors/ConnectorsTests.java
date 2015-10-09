package com.epam.cdpdb.connectors;

import com.epam.cdpdb.beans.DBTypeData;
import com.epam.cdpdb.connection.connectors.DBCPConnector;
import com.epam.cdpdb.connection.connectors.JDBCConnector;
import com.epam.cdpdb.enums.ConnectionTypes;
import com.epam.cdpdb.enums.DataBaseTypes;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Anton_Savostytskyi on 10/7/2015.
 */
public class ConnectorsTests {

  Connection connection;

  @BeforeMethod
  public void setUp() {
    DBTypeData.setDbConnectionAndType(DataBaseTypes.SERVER, ConnectionTypes.DBCP);
  }

  @Test
  public void checkIsJDBCConnectionOpen() throws SQLException {
    connection = new JDBCConnector().getConnection();
    Assert.assertFalse(connection.isClosed(), "FAILED: Connection closed.");
  }

  @Test
  public void checkIsDBCPConnectionOpen() throws SQLException {
    connection = new DBCPConnector().getConnection();
    Assert.assertFalse(connection.isClosed(), "FAILED: Connection closed.");
  }

  @AfterMethod
  public void tearDown() throws SQLException {
    connection.close();
  }
}
