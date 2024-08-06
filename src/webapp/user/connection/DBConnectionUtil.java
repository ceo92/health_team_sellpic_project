package webapp.user.connection;



import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionUtil {

  private static final DBConnectionUtil dbConnectionUtil = new DBConnectionUtil();

  private static String dbUrl;
  private static String dbUsername;
  private static String dbPassword;
  private DBConnectionUtil(){
    Properties properties = new Properties();

    // application.properties 파일 경로를 지정합니다.
    String propertiesFilePath = "src/application.properties";
    Connection con = null;
    try (InputStream input = new FileInputStream(propertiesFilePath)) {
      // properties 파일을 로드합니다.
      properties.load(input);

      // properties 값을 가져옵니다.
      dbUrl = properties.getProperty("database.url");
      dbUsername = properties.getProperty("database.username");
      dbPassword = properties.getProperty("database.password");

      con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }
  public static Connection getConnection() {
    Connection con = null;
    try {
      con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return con;

  }

}
