package com.epam.cdpdb.tasks;


import com.epam.cdpdb.beans.DBTypeData;
import com.epam.cdpdb.enums.ConnectionTypes;
import com.epam.cdpdb.enums.DataBaseTypes;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Anton_Savostytskyi on 10/7/2015.
 */
public class SubTasksTests {

  @Test
  public void checkGetDataUsingJdbc() {
    Assert.assertTrue(SubTasks.getDataUsingJdbc().size() > 0, "FAILED: Can't get data from db.");
  }

  @Test
  public void isJdbcPoolConnectionCorrect() {
   SubTasks.getDataUsingJdbcPool();
    Assert.assertEquals(DBTypeData.getDbConnectionType(), ConnectionTypes.DBCP, "FAILED: Incorrect connection type appeared.");
  }

  @Test
  public void isEmbeddedDBTypeSelected() {
    SubTasks.getDataUsingEmbeddedDB();
    Assert.assertEquals(DBTypeData.getDbType(), DataBaseTypes.EMBEDDED, "FAILED: DB type is incorrect.");
  }

  @Test
  public void isExecutionTimePresent() {
    int time = Integer.parseInt(SubTasks.getDataUsingMultiThreads().replaceAll("\\D",""));
    Assert.assertTrue(time > 0, "FAILED: Time value is incorrect");
  }

}
