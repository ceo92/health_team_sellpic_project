package webapp.user.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 사업자 엔티티
 */
@Getter @Setter //설정자 닫아놔야됨 , 무분별한 수정 안되게끔
public class BusinessMan extends User {
  private String businessNum; //사업자번호 , PK가 아님
  private String businessName; //상호명
  private int warehouseArea; //창고 면적

  public BusinessMan(String businessNum , String businessName ,int warehouseArea, String name ,String phoneNumber ,String loginEmail ,String password){
    super(name , phoneNumber , loginEmail , password);
    this.businessNum = businessNum;
    this.businessName = businessName;
    this.warehouseArea = warehouseArea;
  }





}
