import java.util.*;
public class Taxi {
    static int taxicount =0;
    int id;
    boolean booked;
    char currentspot;
    int freetime;
    int totalearnings;
    List<String> trips;

    Taxi(){
        booked = false;
        currentspot='A';
        freetime=6;
        totalearnings=0;
        trips=new ArrayList<String>();
        taxicount=taxicount+1;
        id = taxicount;

    }

    public void setdetails(boolean booked,char currentspot,int freetime,int totalearnings,String tripdetail){
        this.booked=booked;
        this.currentspot=currentspot;
        this.freetime=freetime;
        this.totalearnings=totalearnings;
        this.trips.add(tripdetail);
    }

    public void printdetails(){
        System.out.println("Taxi--"+this.id+" "+"Total Earnings---"+" "+this.totalearnings);
        System.out.println(" TaxiID BookingID CustomerID From TO Pickuptime Droptime Amount");
        for(String trip:trips){
            System.out.println(id+"    "+trip);
        }
        System.out.println("-------------------------------------------------------------------");
    }

    public void printTaxidetails(){
        System.out.println("TAXI- "+this.id+"Total earnings"+this.totalearnings+"currentspot"+this.currentspot+"Free time"+
                this.freetime);
    }

}

