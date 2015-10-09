package com.epam.cdpdb.beans;

import com.epam.cdpdb.enums.ConnectionTypes;
import com.epam.cdpdb.enums.DataBaseTypes;

/**
 * @author Anton_Savostytskyi on 10/7/2015.
 */
public class DBTypeData {

  private static DataBaseTypes dbType;
  private static ConnectionTypes dbConnection;

  public static DataBaseTypes getDbType() {
    return dbType;
  }

  public static ConnectionTypes getDbConnectionType() {
    return dbConnection;
  }

  public static void setDbConnectionAndType(DataBaseTypes dbType, ConnectionTypes dbConnection) {
    DBTypeData.dbType = dbType;
    DBTypeData.dbConnection = dbConnection;
  }

}
