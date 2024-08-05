package webapp.user.user;

import webapp.user.user.UserController.LoginDto;

public class UserService {

  private static final UserRepository userRepository = new UserRepository(); //DI

  /**
   * -- 회원가입 검증 --
   * 1. 로그인 아이디 중복 아닌지 검증
   * 2. 비밀번호 , 비밀번호 재확인 검증
   */
  public void join(UserSaveDto userSaveDto){
    validateAuthorize()
  }

  /**
   * -- 로그인 검증 --
   * 1. 로그인 아이디 일치하는지
   * 2. 로그인 아이디 일치하면 비밀번호 일치한지
   */

  public User findUserByLoginEmail(LoginDto loginDto){
    return userRepository.findByLoginEmail(loginDto).orElse(null); //null 이면 예외 처리 해줘야됨 , try-catch 더러우니 null로 예외처리
  }


  private void validateLoginEmail(){

  }


  public void validateAuthorize(User user , LoginDto loginDto){
    switch (user.getRoleType()){
      case ADMIN :


      case WAREHOUSE_MANAGER:

      case DELIVERY_MAN:

      case MEMBER:

      case GUEST:
    }
  }

}
