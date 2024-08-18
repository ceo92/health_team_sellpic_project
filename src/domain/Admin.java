package domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Admin extends User{
  public Admin(Integer id , String name ,String phoneNumber ,String loginEmail ,String password , RoleType roleType, String passwordQuestion , String passwordAnswer){
    super(id, name , phoneNumber , loginEmail , password ,roleType , passwordQuestion , passwordAnswer);
  }

  public Admin(String name ,String phoneNumber ,String loginEmail ,String password , RoleType roleType, String passwordQuestion , String passwordAnswer){
    super(name , phoneNumber , loginEmail , password ,roleType , passwordQuestion , passwordAnswer);
  }


}
