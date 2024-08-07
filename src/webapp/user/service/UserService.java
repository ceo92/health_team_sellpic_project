package webapp.user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Pattern;
import webapp.user.connection.DBConnectionUtil;
import webapp.user.domain.BusinessMan;
import webapp.user.domain.DeliveryMan;
import webapp.user.domain.User;
import webapp.user.domain.WarehouseManager;
import webapp.user.dto.DeliveryManDto;
import webapp.user.dto.LoginDto;
import webapp.user.dto.BusinessManDto;
import webapp.user.dto.WarehouseManagerDto;
import webapp.user.repository.UserRepository;

public class UserService {

  private static final UserRepository userRepository = new UserRepository(); //DI , 하지만 스프링 없으니 불가능 , OCP DIP 위배 ㅜㅜ

  /**
   * -- 회원가입 검증 --
   * 1. 로그인 아이디 중복 아닌지 검증
   * 2. 비밀번호 , 비밀번호 재확인 검증
   */

  /**
   * User
   */

  public void businessManJoin(BusinessManDto businessManDto) throws SQLException {
    Connection con = null;
    try {
      con = getConnection();
      con.setAutoCommit(false);

      String businessName = businessManDto.getBusinessName();
      String businessNum = businessManDto.getBusinessNum();
      int warehouseArea = businessManDto.getWarehouseArea();
      String name = businessManDto.getName();
      String phoneNumber = businessManDto.getPhoneNumber();
      String loginEmail = businessManDto.getLoginEmail();
      String password = businessManDto.getPassword();
      String rePassword = businessManDto.getRePassword();
      validateBeforeJoin(loginEmail, password, rePassword);

      User user = new BusinessMan(businessName, businessNum, warehouseArea, name, phoneNumber, loginEmail, password);
      userRepository.save(user);
      con.commit();
    }catch (Exception e){
      System.out.println();
      System.out.println("=====ERROR=====");
      System.out.println(e.getMessage());
      System.out.println();
      con.rollback();
    }
    finally {
      closeConnection(con);
    }
  }



  public void deliveryManJoin(DeliveryManDto deliveryManDto) throws SQLException {
    Connection con = null;
    try {
      con = getConnection();
      con.setAutoCommit(false);

      String deliveryManNum = deliveryManDto.getDeliveryManNum();
      String carNum = deliveryManDto.getCarNum();
      String name = deliveryManDto.getName();
      String phoneNumber = deliveryManDto.getPhoneNumber();
      String loginEmail = deliveryManDto.getLoginEmail();
      String password = deliveryManDto.getPassword();
      String rePassword = deliveryManDto.getRePassword();
      validateBeforeJoin(loginEmail, password, rePassword);

      User user = new DeliveryMan(deliveryManNum ,carNum , name, phoneNumber, loginEmail, password);
      userRepository.save(user);
      con.commit();
    }catch (Exception e){
      System.out.println();
      System.out.println("=====ERROR=====");
      System.out.println(e.getMessage());
      System.out.println();
      con.rollback();
    } finally {
      closeConnection(con);
    }
  }

  public void warehouseManagerJoin(WarehouseManagerDto warehouseManagerDto) throws SQLException {
    Connection con = null;
    try {
      con = getConnection();
      con.setAutoCommit(false);

      String name = warehouseManagerDto.getName();
      String phoneNumber = warehouseManagerDto.getPhoneNumber();
      String loginEmail = warehouseManagerDto.getLoginEmail();
      String password = warehouseManagerDto.getPassword();
      String rePassword = warehouseManagerDto.getRePassword();
      validateBeforeJoin(loginEmail, password, rePassword);

      User user = new WarehouseManager(name, phoneNumber, loginEmail, password);
      userRepository.save(user);
      con.commit();
    }catch (Exception e){
      System.out.println();
      System.out.println("=====ERROR=====");
      System.out.println(e.getMessage());
      System.out.println();
      con.rollback();
    }
    finally {
      closeConnection(con);
    }
  }

  /**
   * 회원가입 전 검증
   */
  private static void validateBeforeJoin(String loginEmail, String password, String rePassword) {
    userRepository.findByLoginEmail(loginEmail).ifPresent(a -> {
      throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
    });

    //2.이메일 형식 검증
    if (!Pattern.matches("^[a-z0-9A-Z._-]*@[a-z0-9A-Z]*.[a-zA-Z.]*$", loginEmail)){
      throw new IllegalArgumentException("이메일 형식을 다시 한 번 확인해주세요 ");
    }

    //3. 8자리 이상비밀번호 영문 , 특수문자 , 숫자 검증
    if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$" ,
        password)){
      throw new IllegalArgumentException("비밀번호는 특수문자 , 영문 , 숫자의 조합이어야합니다.");
    }

    // 4. 비밀번호 더블체크
    if (!password.equals(rePassword)) {
      throw new IllegalArgumentException("비밀번호를 다시 한 번 확인해주세요");
    }
  }

  /**
   * -- 로그인 검증 --
   * 1. 로그인 아이디 일치하는지
   * 2. 로그인 아이디 일치하면 비밀번호 일치한지
   */





  public void validateAuthorize(User user , LoginDto loginDto){
    switch (user.getRoleType()){
      case ADMIN :


      case WAREHOUSE_MANAGER:

      case DELIVERY_MAN:

      case MEMBER:

      case GUEST:
    }
  }

  private static Connection getConnection() {
    return DBConnectionUtil.getConnection();
  }

  private static void closeConnection(Connection con){
    if (con != null) {
      try {
        con.setAutoCommit(true); //종료 시에는 자동 커밋 모드로 ! , 커넥션 풀 쓸 경우
        con.close(); //Connection 닫기
      } catch (SQLException e) {
        System.out.println("error = " + e.getMessage());
      }
    }
  }
}
