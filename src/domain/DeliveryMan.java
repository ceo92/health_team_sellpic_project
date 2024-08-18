package domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter(AccessLevel.PRIVATE)
public class DeliveryMan extends User{
  private String deliveryManNum; //배송기사번호
  private String carNum;
  public DeliveryMan(Integer id , String name, String phoneNumber, String loginEmail, String password, RoleType roleType,
      String passwordQuestion , String passwordAnswer, String deliveryManNum, String carNum) {
    super(id, name, phoneNumber, loginEmail, password  ,roleType , passwordQuestion , passwordAnswer);
    this.carNum = carNum;
    this.deliveryManNum = deliveryManNum;
  }


  public DeliveryMan(String name, String phoneNumber, String loginEmail, String password, RoleType roleType,
      String passwordQuestion , String passwordAnswer, String deliveryManNum, String carNum) {
    super(name, phoneNumber, loginEmail, password  ,roleType , passwordQuestion , passwordAnswer);
    this.carNum = carNum;
    this.deliveryManNum = deliveryManNum;
  }





  public void changeBasicInformation(String name, String phoneNumber , String deliveryManNum , String carNum) {
    setName(name);
    setPhoneNumber(phoneNumber);
    setDeliveryManNum(deliveryManNum);
    setCarNum(carNum);
  }
}
