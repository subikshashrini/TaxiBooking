import java.util.*;
public class Booking {
    public static List<Taxi> createTaxi(int n){
        List<Taxi> taxis = new ArrayList<Taxi>();

        for(int i=1;i<=n;i++){
            Taxi t = new Taxi();
            taxis.add(t);
        }
        return taxis;
    }

    public static List<Taxi> getfreetaxis(List<Taxi> taxis,int pickuptime,char pickuppoint){
        List<Taxi> freetaxis = new ArrayList<Taxi>();

        for(Taxi t : taxis){
            if(t.freetime<=pickuptime && (Math.abs((t.currentspot-'0')-(pickuppoint-'0'))<= pickuptime-t.freetime)){
                freetaxis.add(t);
            }

        }
        return freetaxis;
    }

    public static void Booktaxi(int custid, char pickup, char drop, int picktime, List<Taxi> freetaxi){
        int min=999;
        int distbtwpickanddrop =0;
        int earnings=0;
        int nextfreetime=0;
        char nextspot='Z';
        Taxi bookedtaxi=null;
        String tripdetails=" ";
        for(Taxi t:freetaxi)
        {
            int distbtwcustomerandtaxi = (Math.abs(t.currentspot-'0')-(pickup-'0'))*15;
            if(distbtwcustomerandtaxi<min)
            {
                bookedtaxi=t;
                distbtwpickanddrop=(Math.abs(pickup-'0')-(drop-'0'))*15;
                earnings=(distbtwpickanddrop-5)*10+100;
                int droptime = picktime +  (Math.abs(t.currentspot-'0')-(pickup-'0'));
                nextfreetime=droptime;
                nextspot=drop;

                tripdetails=(   custid+ "               " +custid+ "          " + pickup+  "      " + drop + "       " + picktime + "          " +droptime + "           " + earnings);
                min=distbtwcustomerandtaxi;
            }
        }

        bookedtaxi.setdetails(true,nextspot,nextfreetime,bookedtaxi.totalearnings+earnings,tripdetails);

        System.out.println("BOOKED SUCCESSFULLY");
        System.out.println("Taxi"+" "+bookedtaxi.id+" booked");
    }
}
