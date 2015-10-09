package com.epam.cdpdb;

import com.epam.cdpdb.tasks.SubTasks;


/**
 * @author Savostytskyi Anton on 07.10.2015.
 */
public class MainDB {

  public static void main(String[] args) {

    SubTasks.getDataUsingJdbc();
    System.out.println(SubTasks.getDataUsingJdbcPool());
    System.out.println(SubTasks.getDataUsingEmbeddedDB());
    System.out.println(SubTasks.getDataUsingMultiThreads());
  }


}
