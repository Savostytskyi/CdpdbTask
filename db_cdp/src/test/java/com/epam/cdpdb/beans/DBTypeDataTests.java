package com.epam.cdpdb.beans;

import com.epam.cdpdb.enums.ConnectionTypes;
import com.epam.cdpdb.enums.DataBaseTypes;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.cdpdb.beans.DBTypeData.getDbType;

/**
 * @author Anton_Savostytskyi on 10/7/2015.
 */
public class DBTypeDataTests {

  @BeforeMethod
  public void setUp() {
    DBTypeData.setDbConnectionAndType(DataBaseTypes.SERVER, ConnectionTypes.DBCP);
  }

  @Test
  public void checkDBDataSetUp() {
    Assert.assertEquals(DBTypeData.getDbConnectionType(), ConnectionTypes.DBCP, "FAILED: Database connection type set up incorrect.");
    Assert.assertEquals(DBTypeData.getDbType(), DataBaseTypes.SERVER, "FAILED: Database type set up incorrect.");
  }

  @Test
  public void checkIsUrlCorrect() {
    Assert.assertEquals(getDbType().url, "jdbc:h2:tcp://localhost/~/test", "FAILED: Server url is incorrect.");
    DBTypeData.setDbConnectionAndType(DataBaseTypes.EMBEDDED, ConnectionTypes.DBCP);
    Assert.assertEquals(getDbType().url, "jdbc:h2:~/test", "FAILED: Embedded url is incorrect.");
  }

}
