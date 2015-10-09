package com.epam.cdpdb.dao;

import com.epam.cdpdb.connection.ConnectionFactory;
import com.epam.cdpdb.entities.Entity;
import com.epam.cdpdb.entities.Stations;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Savostytskyi Anton on 07.10.2015.
 */

public class StationDao extends AbstractDao {

  public static final String SQL_SELECT_ALL_FROM_STATION = "SELECT * FROM STATION";

  @Override
  public List<Stations> findAll() {
    List<Stations> stations = new ArrayList<>();
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    Stations station;
    try {
      connection = ConnectionFactory.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_STATION);
      while (resultSet.next()) {
        station = new Stations();
        station.setId(resultSet.getInt(1));
        station.setCity(resultSet.getString(2));
        station.setState(resultSet.getString(3));
        station.setLatitude(resultSet.getDouble(4));
        station.setLongitude(resultSet.getDouble(5));
        stations.add(station);
      }
    } catch (SQLException e) {
      System.err.println("SQL Exception, request failed):" + e);
    } catch (URISyntaxException e) {
      e.printStackTrace();
    } finally {
      try {
        if (connection != null) {
          connection.close();
        }
        if (resultSet != null) {
          resultSet.close();
        }
        if (statement != null) {
          statement.close();
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return stations;
  }

  @Override
  public Entity findEntityById(Object Id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean delete(Entity entity) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean create(Entity entity) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Entity update(Entity entity) {
    throw new UnsupportedOperationException();
  }
}
