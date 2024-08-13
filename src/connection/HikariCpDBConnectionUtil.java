package connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class HikariCpDBConnectionUtil {

  public static Connection getConnection(){
    Properties properties = new Properties();
    String propertiesFilePath = "src/application.properties";
    Connection con = null;
    try(InputStream input = new FileInputStream(propertiesFilePath)) {
      properties.load(input);
      String dbUrl = properties.getProperty("database.url");
      String dbUsername = properties.getProperty("database.username");
      String dbPassword = properties.getProperty("database.password");



    }catch (IOException e){
      e.printStackTrace();
    }catch (SQLException e){
      e.printStackTrace();
    }
    return con;
  }



}
