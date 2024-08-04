package webapp.user;

import webapp.user.user.Admin;
import webapp.user.user.Member;
import webapp.user.user.User;

public class AuthControl {

  public void accessFeature(User user, String feature) {
    switch (user.getRoleType()) {
      case ADMIN:
        // 총관리자 모든 기능 접근 가능
        accessAdminFeatures(feature);
        break;
      case WAREHOUSE_MANAGER:
        // 창고관리자 기능 접근
        accessWarehouseManagerFeatures(feature);
        break;
      case DELIVERY_MAN:
        // 배송기사 기능 접근
        accessDeliveryPersonFeatures(feature);
        break;
      case MEMBER:
        // 회원 기능 접근
        accessMemberFeatures(feature);
        break;
      case GUEST:
        // 비회원 기능 접근
        accessGuestFeatures(feature);
        break;
      default:
        System.out.println("접근 권한이 없습니다.");
        break;
    }
  }
  private void accessAdminFeatures(String feature) {
    // 총관리자가 접근할 수 있는 기능 처리
    System.out.println("총관리자가 " + feature + " 기능에 접근합니다.");
  }

  private void accessWarehouseManagerFeatures(String feature) {
    // 창고관리자가 접근할 수 있는 기능 처리
    if (feature.equals("manageInventory") || feature.equals("viewReports")) {
      System.out.println("창고관리자가 " + feature + " 기능에 접근합니다.");
    } else {
      System.out.println("접근 권한이 없습니다.");
    }
  }

  private void accessDeliveryPersonFeatures(String feature) {
    // 배송기사가 접근할 수 있는 기능 처리
    if (feature.equals("viewDeliverySchedule") || feature.equals("updateDeliveryStatus")) {
      System.out.println("배송기사가 " + feature + " 기능에 접근합니다.");
    } else {
      System.out.println("접근 권한이 없습니다.");
    }
  }

  private void accessMemberFeatures(String feature) {
    // 회원이 접근할 수 있는 기능 처리
    if (feature.equals("placeOrder") || feature.equals("viewOrderStatus")) {
      System.out.println("회원이 " + feature + " 기능에 접근합니다.");
    } else {
      System.out.println("접근 권한이 없습니다.");
    }
  }

  private void accessGuestFeatures(String feature) {
    // 비회원이 접근할 수 있는 기능 처리
    if (feature.equals("browseProducts")) {
      System.out.println("비회원이 " + feature + " 기능에 접근합니다.");
    } else {
      System.out.println("접근 권한이 없습니다.");
    }
  }
}