package webapp.user.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.AllArgsConstructor;
import lombok.Data;

public class UserController {


  private static final UserService userService = new UserService();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      System.out.println("😈 Money Flow WMS 👹 ");
      System.out.println("로그인 : 1 , 회원가입 : 2 입력");
      int inputLoginOrJoin = Integer.parseInt(br.readLine());
      if (inputLoginOrJoin == 1) {
        System.out.println("=".repeat(20)+"로그인 화면"+"=".repeat(20));
        System.out.print("이메일 입력 : ");
        String loginEmailId = br.readLine();
        System.out.print("비밀번호 입력 : ");
        String password = br.readLine();
        LoginDto loginDto = new LoginDto(loginEmailId , password);
        userService.findUserByLoginEmail(loginDto);
        br.readLine();

      } else if (inputLoginOrJoin == 2) {
        System.out.println("=".repeat(20)+"회원가입 화면"+"=".repeat(20));
        System.out.println("어느 권한의 회원으로 가입하시겠습니까?");
        System.out.println("1. 사업자 (Member)");
        System.out.println("2. 창고 관리자(WarehouseManager)");
        System.out.println("3. 배송 기사(WarehouseManager)");
        int inputRoleType = Integer.parseInt(br.readLine());
        switch (inputRoleType){
          case 1:

          case 2:

          case 3:

          default:

        }
      }
      else{
        System.out.println("잘못된 입력입니다.");
      }
    }
    
    

  }

  @Data
  @AllArgsConstructor
  static class LoginDto{
    private String loginEmailId;
    private String password;

  }

}
