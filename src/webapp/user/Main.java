package webapp.user;

import webapp.user.domain.BusinessMan;
import webapp.user.domain.DeliveryMan;
import webapp.user.domain.User;
import webapp.user.domain.WarehouseManager;

public class Main {

  public static void main(String[] args) {
    User user = new BusinessMan("123" , "미미" , "이경민" ,"01010-1010" , "dd@naver" , "Dd");
    if (user instanceof BusinessMan businessMan){
    System.out.println("businessMan = " + businessMan.getBusinessName());
    }




    System.out.println("warehouse_manager = " + ((DeliveryMan)user).getDeliveryManNum());
  }

}
