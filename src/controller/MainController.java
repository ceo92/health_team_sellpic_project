package controller;

import dto.PasswordResetDto;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import domain.User;
import dto.savedto.DeliveryManSaveDto;
import dto.savedto.BusinessManSaveDto;
import dto.savedto.WarehouseManagerSaveDto;
import java.util.HashMap;
import java.util.Map;
import service.UserService;

public class MainController {


  private static final UserService userService = new UserService();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Welcome to Money Flow WMS");
    Integer loginUserId = null; //로그인 여부 판별용 id
    Map<Integer, String> passwordQuestionsMap = initPasswordQuestions();

    while (true) {
      /**
       * 로그인 여부에 따른 시작 로직(로그인)
       */
      if (loginUserId !=null){
        authenticate(loginUserId, br);
      }
      else{
        System.out.println("★★★★★ 원하시는 번호를 입력해주세요 ★★★★★");
        System.out.println("1. 로그인 페이지 이동 2. 회원가입 페이지 이동 3. Q&A 페이지 이동");
        int guestInputNum = Integer.parseInt(br.readLine());
        if (guestInputNum == 1) {
          System.out.println("=".repeat(20) + "로그인 페이지" + "=".repeat(20));
          System.out.println("1. 로그인 2. 아이디 찾기 3. 비밀번호 찾기");
          switch (Integer.parseInt(br.readLine())){
            case 1:
              System.out.print("로그인 이메일 입력 : ");
              String loginEmail = br.readLine();
              System.out.print("비밀번호 입력 : ");
              String password = br.readLine();
              User loginUser = userService.login(loginEmail, password);
              authenticate(loginUser.getId(), br);
              break;
            case 2:
              System.out.println("이름 입력");
              String name = br.readLine();
              System.out.println("휴대폰 번호 입력");
              String phoneNumber = br.readLine();
              userService.checkLoginEmailExists(name, phoneNumber);
              break;

            case 3:
              System.out.println("로그인 이메일 입력");
              String loginEmailFindPassword = br.readLine();
              System.out.println("이름 입력");
              String nameFindPassword = br.readLine();
              System.out.println("휴대폰 번호 입력");
              String phoneNumberFindPassword = br.readLine();
              System.out.println("비밀번호 찾기 위해 설정한 질문에 대해 대답해주세요");
              String passwordAnswer = br.readLine();
              PasswordResetDto passwordResetDto = new PasswordResetDto(loginEmailFindPassword , nameFindPassword , phoneNumberFindPassword , passwordAnswer);


              br.readLine();

          }






        } else if (guestInputNum == 2) {
          System.out.println("=".repeat(20) + "회원가입 화면" + "=".repeat(20));
          System.out.println();
          System.out.println("어느 권한의 회원으로 가입하시겠습니까?");
          System.out.println("1. 사업자 (BusinessMan)");
          System.out.println("2. 창고 관리자(WarehouseManager)");
          System.out.println("3. 배송 기사(DeliveryMan)");
          int inputRoleType = Integer.parseInt(br.readLine());
          switch (inputRoleType) {
            case 1:
              System.out.print("사업자 번호 입력 : ");
              String businessNum = br.readLine();
              System.out.print("상호명 입력 : ");
              String businessName = br.readLine();
              System.out.print("이름 입력 : ");
              String businessManName = br.readLine();
              System.out.print("핸드폰 번호 입력 : ");
              String businessManPhoneNumber = br.readLine();
              System.out.print("이메일 아이디 입력 : ");
              String businessManLoginEmail = br.readLine();
              System.out.print("비밀번호 입력 : ");
              String businessManPassword = br.readLine();
              System.out.print("비밀번호 재입력 ");
              String businessManRePassword = br.readLine();
              
              System.out.println("비밀번호 확인 질문 중 하나 번호로 선택");
              System.out.println("====================");
              for (Integer i : passwordQuestionsMap.keySet()) {
                System.out.println(i+". "+passwordQuestionsMap.get(i));
              }
              System.out.println("====================");

              int bmPasswordQuestionNum = Integer.parseInt(br.readLine());
              System.out.print("답변을 입력하시오 : ");
              String bmPasswordAnswer = br.readLine();

              BusinessManSaveDto businessManSaveDto = new BusinessManSaveDto(businessManName,
                  businessManPhoneNumber, businessManLoginEmail, businessManPassword,
                  businessManRePassword, passwordQuestionsMap.get(bmPasswordQuestionNum), bmPasswordAnswer, businessNum, businessName);
              //사업자 id 리턴
              loginUserId = userService.businessManJoin(businessManSaveDto);//회원가입 성공하면 다시 초기 화면으로 돌아가서 로그인 되게끔
              //사업자 id를 통해 조회
              break;

            case 2:
              System.out.print("이름 입력 : ");
              String whmName = br.readLine();
              System.out.print("핸드폰 번호 입력 : ");
              String whmPhoneNumber = br.readLine();
              System.out.print("이메일 아이디 입력 : ");
              String whmLoginEmail = br.readLine();
              System.out.print("비밀번호 입력 : ");
              String whmPassword = br.readLine();
              System.out.print("비밀번호 재입력 ");
              String whmRePassword = br.readLine();

              System.out.println("비밀번호 확인 질문 중 하나 번호로 선택");
              System.out.println("====================");
              for (Integer i : passwordQuestionsMap.keySet()) {
                System.out.println(i+". "+passwordQuestionsMap.get(i));
              }
              System.out.println("====================");

              int wmPasswordQuestionNum = Integer.parseInt(br.readLine());
              System.out.print("답변을 입력하시오 : ");
              String wmPasswordAnswer = br.readLine();

              WarehouseManagerSaveDto warehouseManagerSaveDto = new WarehouseManagerSaveDto(whmName,
                  whmPhoneNumber, whmLoginEmail, whmPassword, whmRePassword , passwordQuestionsMap.get(wmPasswordQuestionNum) , wmPasswordAnswer);
              loginUserId = userService.warehouseManagerJoin(warehouseManagerSaveDto);
              break;

            case 3:
              System.out.println("배송기사 번호 입력 : ");
              String dmNum = br.readLine();
              System.out.println("차량 번호 입력 : ");
              String dmCarNum = br.readLine();
              System.out.print("이름 : ");
              String dmName = br.readLine();
              System.out.print("핸드폰 번호 : ");
              String dmPhoneNumber = br.readLine();
              System.out.print("이메일 아이디 : ");
              String dmLoginEmail = br.readLine();
              System.out.print("비밀번호 : ");
              String dmPassword = br.readLine();
              System.out.print("비밀번호 재입력 ");
              String dmRePassword = br.readLine();

              System.out.println("비밀번호 확인 질문 중 하나 번호로 선택");
              System.out.println("====================");
              for (Integer i : passwordQuestionsMap.keySet()) {
                System.out.println(i+". "+passwordQuestionsMap.get(i));
              }
              System.out.println("====================");

              int dmPasswordQuestionNum = Integer.parseInt(br.readLine());
              System.out.print("답변을 입력하시오 : ");
              String dmPasswordAnswer = br.readLine();

              DeliveryManSaveDto deliveryManSaveDto = new DeliveryManSaveDto(dmName, dmPhoneNumber,
                  dmLoginEmail, dmPassword, dmRePassword, passwordQuestionsMap.get(dmPasswordQuestionNum),  dmPasswordAnswer ,dmNum, dmCarNum);
              loginUserId = userService.deliveryManJoin(deliveryManSaveDto);
              break;

            default:
              System.out.println("잘못 입력하였습니다 처음부터 다시 입력해주세요"); //검증 로직
              break;
          }
        } else if (guestInputNum == 3) {
          //q&a 작성
          System.out.println("잘못된 입력입니다.");
        }
      }
    }


  }

  private static Map<Integer, String> initPasswordQuestions() {
    Map<Integer, String> passwordQuestions = new HashMap<>();
    passwordQuestions.put(1 , "가장 좋아하는 회사는?");
    passwordQuestions.put(2 , "가장 존경하는 인물은?");
    passwordQuestions.put(3 , "당신의 보물 1호는?");
    passwordQuestions.put(4 , "다시 태어나면 되고싶은 것은?");
    passwordQuestions.put(5 , "읽은 책 중에서 좋아하는 구절은?");
    passwordQuestions.put(6 , "당신의 좌우명은?");
    passwordQuestions.put(7 , "자주 방문하는 카페 이름은?");
    passwordQuestions.put(8 , "당신의 첫사랑 이름은?");
    passwordQuestions.put(9 , "태어난 병원 이름은?");
    passwordQuestions.put(10 , "당신의 콤플렉스는?");
    passwordQuestions.put(11 , "학창시절 친했던 친구 3명의 이름은?");
    passwordQuestions.put(12 , "가장 좋아하는 색깔은?");
    return passwordQuestions;
  }

  private static void authenticate(Integer loginId, BufferedReader br) throws Exception{
    User user = userService.findUser(loginId);
    switch (user.getRoleType()) {
      case ADMIN:
        System.out.println("어떤 시스템에 접속하시겠습니까?");
        System.out.println("1. 입고 관리");
        System.out.println("2. 출고 관리");
        System.out.println("3. 재고 관리");
        System.out.println("4. 고객센터");
        System.out.println("5. 재무 관리");
        System.out.println("6. 내 정보 조회");
        int adminNum = Integer.parseInt(br.readLine());


      case WAREHOUSE_MANAGER:
        System.out.println("어떤 시스템에 접속하시겠습니까?");
        System.out.println("1. 입고 관리");
        System.out.println("2. 출고 관리");
        System.out.println("3. 재고 관리");
        System.out.println("4. 고객센터");
        System.out.println("5. 재무 관리");
        System.out.println("6. 내 정보 조회");
        int whmNum = Integer.parseInt(br.readLine());

      case DELIVERY_MAN:
        System.out.println("어떤 시스템에 접속하시겠습니까?");
        System.out.println("1. 운송장 조회");
        System.out.println("2. 요금안내 조회");
        System.out.println("3. 창고별 검색 ");
        System.out.println("4. 공지사항 조회");
        System.out.println("5. 문의게시판 조회");
        System.out.println("6. 내 정보 조회");
        int dmNum = Integer.parseInt(br.readLine());

      case BUSINESS_MAN:
        System.out.println("어떤 시스템에 접속하시겠습니까?");
        System.out.println("1. 입고 관리");
        System.out.println("2. 출고 관리");
        System.out.println("3. 재고 관리");
        System.out.println("4. 고객센터");
        System.out.println("5. 재무 관리");
        int busNum = Integer.parseInt(br.readLine());

    }
  }
}
