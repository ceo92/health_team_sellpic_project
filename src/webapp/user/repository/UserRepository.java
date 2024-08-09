package webapp.user.repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import webapp.user.domain.User;
import webapp.user.dto.LoginDto;

/**
 * 추후 JDBC로 마이그레이션
 */

public class UserRepository {

  private static final Map<Integer, User> store = new HashMap<>();
  private static Integer sequence = 0;
  public Integer save(User user , Connection con){
    /*String superSql = "insert into user from values(null , ? , ? , ? , ? , ? , ?)";
    //if ()
    String subSql = "insert into user from values(null , ? , )";

    con.prepareStatement();*/
    return null;
  }






  public Optional<User> findById(Integer id){
    return Optional.ofNullable(store.get(id));
  }

  public Optional<User> findByLoginEmail(String loginEmail , Connection con){
    return store.values().stream().filter(user -> user.getLoginEmail().equals(loginEmail)).findFirst();
  }

  public List<User> findAll(){
    return new ArrayList<>(store.values());
  }

  public void removeUser(User user){
    store.remove(user.getId(), user);
  }

}
