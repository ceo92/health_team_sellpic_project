package webapp.user.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import webapp.user.dto.DeliveryManDto;
import webapp.user.dto.LoginDto;
import webapp.user.dto.MemberDto;
import webapp.user.dto.WarehouseManagerDto;
import webapp.user.service.UserService;

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

      } else if (inputLoginOrJoin == 2) {
        System.out.println("=".repeat(20)+"회원가입 화면"+"=".repeat(20));
        System.out.println();
        System.out.println("어느 권한의 회원으로 가입하시겠습니까?");
        System.out.println("1. 사업자 (Member)");
        System.out.println("2. 창고 관리자(WarehouseManager)");
        System.out.println("3. 배송 기사(WarehouseManager)");
        int inputRoleType = Integer.parseInt(br.readLine());
        switch (inputRoleType){
          case 1:
            System.out.print("사업자 번호 입력 : ");
            String businessNum = br.readLine();
            System.out.print("상호명 입력 : ");
            String businessName = br.readLine();
            System.out.print("이름 : ");
            String memberName = br.readLine();
            System.out.print("핸드폰 번호 : ");
            String memberPhoneNumber = br.readLine();
            System.out.print("이메일 아이디 : ");
            String memberLoginEmail = br.readLine();
            System.out.print("비밀번호 : ");
            String memberPassword = br.readLine();
            MemberDto memberDto = new MemberDto(businessNum , businessName , memberName , memberPhoneNumber , memberLoginEmail , memberPassword);

          case 2:
            System.out.print("이름 : ");
            String whmName = br.readLine();
            System.out.print("핸드폰 번호 : ");
            String whmPhoneNumber = br.readLine();
            System.out.print("이메일 아이디 : ");
            String whmLoginEmail = br.readLine();
            System.out.print("비밀번호 : ");
            String whmPassword = br.readLine();
            WarehouseManagerDto warehouseManagerDto = new WarehouseManagerDto(whmName , whmPhoneNumber , whmLoginEmail , whmPassword);

          case 3:
            System.out.println("배송기사 번호 : ");
            String dmNum = br.readLine();
            System.out.print("이름 : ");
            String dmName = br.readLine();
            System.out.print("핸드폰 번호 : ");
            String dmPhoneNumber = br.readLine();
            System.out.print("이메일 아이디 : ");
            String dmLoginEmail = br.readLine();
            System.out.print("비밀번호 : ");
            String dmPassword = br.readLine();
            DeliveryManDto deliveryManDto = new DeliveryManDto(dmNum , dmName , dmPhoneNumber , dmLoginEmail , dmPassword);

          default:
            System.out.println("잘못 입력하였습니다 처음부터 다시 입력해주세요"); //검증 로직
            break;
        }
      }
      else{
        System.out.println("잘못된 입력입니다.");
      }
    }



  }

}
