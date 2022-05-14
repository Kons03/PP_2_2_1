package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import javax.persistence.*;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Sergey", "Nemchinkiy", "serega@foxminded.com");
      User user2 = new User("Galileo", "Galiley", "galik@science.com");
      User user3 = new User("Dmitro", "Gordon", "gordon@barakobama.com");
      User user4 = new User("Sid", "Vicious", "sid@sexpistols.com");

      Car car1 = new Car("BMW", 1390);
      Car car2 = new Car("Lada", 2107);
      Car car3 = new Car("Audi", 4388);
      Car car4 = new Car("Tesla", 1233);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

      // List of all users with cars
      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
         System.out.println("1. _____________________________________________");
      }

      // User who owns a car by its model and series
      System.out.println(userService.getUserByCar("BMW", 1390));
      System.out.println("2. _____________________________________________");

      context.close();
   }
}