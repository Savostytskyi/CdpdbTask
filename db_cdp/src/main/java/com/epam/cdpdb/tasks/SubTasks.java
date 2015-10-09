package com.epam.cdpdb.tasks;

import com.epam.cdpdb.beans.DBTypeData;
import com.epam.cdpdb.dao.AbstractDao;
import com.epam.cdpdb.dao.StationDao;
import com.epam.cdpdb.enums.ConnectionTypes;
import com.epam.cdpdb.enums.DataBaseTypes;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author  Anton_Savostytskyi on 10/7/2015.
 */
public class SubTasks {

  public static AbstractDao station = new StationDao();

  /**
   * Part 2: JDBC.
   */
  public static List getDataUsingJdbc() {
    DBTypeData.setDbConnectionAndType(DataBaseTypes.SERVER, ConnectionTypes.JDBC);
    List stations = station.findAll();
    System.out.println(stations);
    return stations;
  }

  /**
   * Part 3: JDBC pool.
   */
  public static String getDataUsingJdbcPool() {
    DBTypeData.setDbConnectionAndType(DataBaseTypes.SERVER, ConnectionTypes.DBCP);
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 1000; i++) {
      station.findAll();
    }
    long endTime = System.currentTimeMillis();
    return "DBCP. Server connectin. Done after " + (endTime - startTime);
  }

  /**
   * Part 4: Embedded DB.
   */
  public static String getDataUsingEmbeddedDB() {
    DBTypeData.setDbConnectionAndType(DataBaseTypes.EMBEDDED, ConnectionTypes.DBCP);
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 1000; i++) {
      station.findAll();
    }
    long endTime = System.currentTimeMillis();
    return "DBCP. Embedded connection. Done after " + (endTime - startTime);
  }

  /**
   * Part 5: Advanced.
   */
  public static String getDataUsingMultiThreads() {
    DBTypeData.setDbConnectionAndType(DataBaseTypes.SERVER, ConnectionTypes.DBCP);
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    int queryCount = 100000;
    System.out.println("Wait for sending "+queryCount+" queries......");
    for (int i = 0; i < queryCount; i++) {
      executorService.execute(new Runnable() {
        public void run() {
          station.findAll();
        }
      });
    }
    long start = System.currentTimeMillis();
    executorService.shutdown();
    try {
      executorService.awaitTermination(5, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "DBCP. Server connection (multi thread). Done after " + (System.currentTimeMillis() - start);
  }

}
