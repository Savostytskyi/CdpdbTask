package com.epam.cdpdb.dao;

import com.epam.cdpdb.beans.DBTypeData;
import com.epam.cdpdb.enums.ConnectionTypes;
import com.epam.cdpdb.enums.DataBaseTypes;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * @author Anton_Savostytskyi on 10/7/2015.
 */
public class StationDaoTest {

  @Test(dataProvider = "dbSettings")
  public void checkFindAllUsingConnections(DataBaseTypes dataBaseTypes, ConnectionTypes connectionTypes) {
    DBTypeData.setDbConnectionAndType(dataBaseTypes, connectionTypes);
    Assert.assertTrue(new StationDao().findAll().size() > 0, "FAILED: Connection failed, no data present.");
  }

  @DataProvider(name = "dbSettings")
  public static Object[][] dbSettings() {
    return new Object[][]{{DataBaseTypes.SERVER, ConnectionTypes.DBCP}, {DataBaseTypes.EMBEDDED, ConnectionTypes.DBCP},
                          {DataBaseTypes.SERVER, ConnectionTypes.JDBC}, {DataBaseTypes.EMBEDDED, ConnectionTypes.JDBC}};
  }

}
