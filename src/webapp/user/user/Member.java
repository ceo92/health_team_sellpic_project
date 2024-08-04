package webapp.user.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 사업자 엔티티
 */
@Getter @Setter //설정자 닫아놔야됨 , 무분별한 수정 안되게끔
public class Member extends User {

  private String businessNum; //사업자번호 , PK가 아님
}
