package domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PRIVATE)
public class RegionChild {

  private Integer id;
  private String code;
  private String name;
  private RegionParent regionParent;



}
