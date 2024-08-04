package webapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardInputEx {

  public static void main(String[] args){
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("이름을 입력하세요");
      String name = br.readLine();
      System.out.println("입력한 이름 확인 : " + name);
    }catch (IOException e){
      throw new RuntimeException(e);
    }
  }

}
