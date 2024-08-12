package webapp.user.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
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

      HikariConfig config = new HikariConfig();
      config.setJdbcUrl(dbUrl); // 데이터베이스 URL
      config.setUsername(dbUsername); // 데이터베이스 사용자 이름
      config.setPassword(dbPassword); // 데이터베이스 비밀번호

      // 추가 설정 (옵션)
      config.setMaximumPoolSize(10); // 커넥션 풀의 최대 커넥션 수
      config.setMinimumIdle(5); // 최소 아이들 커넥션 수
      config.setConnectionTimeout(30000); // 커넥션 타임아웃 (밀리초)

      HikariDataSource dataSource = new HikariDataSource(config);
      con = dataSource.getConnection();
    }catch (IOException e){
      e.printStackTrace();
    }catch (SQLException e){
      e.printStackTrace();
    }
    return con;
  }



}
