package com.epam.cdpdb.enums;

/**
 * @author Anton_Savostytskyi on 10/7/2015.
 */
public enum DataBaseTypes {

  EMBEDDED("jdbc:h2:~/test"), SERVER("jdbc:h2:tcp://localhost/~/test");

  public String url;

  private DataBaseTypes(String url) {
    this.url = url;
  }
}
