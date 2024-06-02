//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class Main {
    public static void main(String[] args) {
           List<Taxi> taxis = Booking.createTaxi(4);
           Scanner sc= new Scanner(System.in);
           int id=1;
           while(true){
               System.out.println("0----->Book taxi");
               System.out.println("1----->View Details");
               int choice =sc.nextInt();
               switch(choice)
               {
                   case 0: {

                       int customerid = id;
                       System.out.println("enter pickup point");
                       char pickuppoint = sc.next().charAt(0);
                       System.out.println("Enter drop point");
                       char droppoint = sc.next().charAt(0);
                       System.out.println("enter pickup time");
                       int time = sc.nextInt();

                       if (pickuppoint < 'A' || droppoint < 'A' || pickuppoint > 'F' || droppoint > 'F') {
                           System.out.println("Invalid point");
                           return;
                       }

                       List<Taxi> freetaxi = Booking.getfreetaxis(taxis, time, pickuppoint);

                       if (freetaxi.size() == 0) {
                           System.out.println("No freetaxi avilable");

                       }

                       Collections.sort(freetaxi, (a, b) -> a.totalearnings - b.totalearnings);

                       Booking.Booktaxi(id, pickuppoint, droppoint, time, freetaxi);
                       id++;
                       break;
                   }
                   case 1:
                   {
                       for(Taxi t:taxis){
                           t.printdetails();
                       }
                       for(Taxi t:taxis){
                           t.printTaxidetails();
                           break;
                       }
                   }
                   default:
                       return;
               }

           }
    }
}