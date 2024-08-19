package domain;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PRIVATE)
public class RegionParent {//서울 , 부산 , 인천 , 충청남도 , 충청북도 , 경상남도 , 경상북도 , 경기도 , 강원도 , 전라남도 , 전라북도 , 제주도

  private Integer id;
  private String code; //한 코드를 가짐 , 각 지역에 대한
  private String name;
  private List<RegionChild> regionChildList = new ArrayList<>(); //조회용 , 양방향 연관관계 mappedBy

}
