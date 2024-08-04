package webapp.user.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 추후 JDBC로 마이그레이션
 */

public class UserRepository {

  private static final Map<Integer, User> store = new HashMap<>();
  private static Integer sequence = 0;
  public Integer save(User user){
    user.setId(++sequence);
    store.put(user.getId(), user);
    return user.getId();
  }


  public User findById(Integer id){
    return store.get(id);
  }

  public List<User> findAll(){
    return new ArrayList<>(store.values());
  }

  public void removeUser(User user){
    store.remove(user.getId(), user);
  }

}
