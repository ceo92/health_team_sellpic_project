package webapp.user.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginController {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("🌈Money Flow WMS🌈");
    System.out.println("=".repeat(20)+"로그인 화면"+"=".repeat(20));
    System.out.print("이메일 입력 : ");
    String loginEmailId = br.readLine();
    System.out.print("비밀번호 입력 : ");
    String password = br.readLine();
    if (loginEmailId.equals())

    br.readLine();
  }

}
