package webapp.user;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

//VO
@Getter @EqualsAndHashCode
@AllArgsConstructor
public class Address {
  private String city; //도시
  private String distance; //도로명주소
  private String zipcode; //우편번호
}
