package test;

import org.junit.jupiter.api.Test;
import service.RegionService;

public class TestClass {

  RegionService regionService = new RegionService();
  @Test
  void aa(){
    regionService.findAllRegions().stream().map(region -> region.getName().substring(0 , region.getName().indexOf(" "))).forEach(System.out::println);

  }

}
