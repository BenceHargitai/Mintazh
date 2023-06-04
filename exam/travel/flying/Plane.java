package exam.travel.flying;

import exam.travel.*;


public class Plane extends Flight implements Flyable {
    
    private String name;
    private int id;
    private int ticketPrice;

    //#region getter
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getTicketPrice(){
        return ticketPrice;
    }
    public void setTicketPrice(int ticketPrice){
        this.ticketPrice = ticketPrice;
    }


    //#endregion

    private Plane(String name, int id, int ticketPrice, Destination destinationCity, int numberOfTravellers, DateAndTime flightDateAndTime) {
        
        super(name, destinationCity, numberOfTravellers, flightDateAndTime);
        if (name == null || ticketPrice < 10) {
            throw new IllegalArgumentException("Invalid name or ticket price.");
        }    
        this.name = name;
        this.id = id;
        this.ticketPrice = ticketPrice;

    }
    public static Plane make(String data) {
        String[] parts = data.split(",");
        String name = parts[0];
        int id = Integer.parseInt(parts[1]);
        int ticketPrice = Integer.parseInt(parts[2]);

        return new Plane(name, id, ticketPrice, Destination.ROME, 83, new DateAndTime());
    }

    public Boolean Equals(Plane other)
    {
        return (other.name == name && other.id == id && other.ticketPrice == ticketPrice);
    }

    @Override   
    public int hashCode()
    {
        int result = name.hashCode();
        result = 31 * result + id;
        result = 31 * result + ticketPrice;
        return result;
    }
    @Override
    public String toString()
    {
        return name+","+id+","+ticketPrice;
    }
    
    @Override
    public int estimatedArrivalTime(int departHour, Destination dest)
    {
        return departHour + Integer.parseInt(DestinationUtils.getRoundedHours(dest));  
    }

    @Override
    public double getPrice(double discountRate)
    {
        return ticketPrice-ticketPrice*discountRate;
    }


}