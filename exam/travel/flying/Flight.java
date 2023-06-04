package exam.travel.flying;

import exam.travel.*;

abstract class Flight {
    
    private String name;
    private Destination DestinationCity;
    private int numberOfTravellers;
    private DateAndTime flightDateAndTime;

    //#region getter
    public String getName(){
        return name;
    }
    public Destination getDestinationCity(){
        return DestinationCity;
    }
    public int getNumberOfTravellers(){
        return numberOfTravellers;
    }
    public String getFlightDateAndTime(){
        return flightDateAndTime.toString();
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setDestinationCity(Destination destinationCity){
        this.DestinationCity = destinationCity;
    }
    public void setNumberOfTravellers(int numberOfTravellers){
        this.numberOfTravellers = numberOfTravellers;
    }
    
    //#endregion


    public Flight(String name, Destination DestinationCity, int numberOfTravellers, DateAndTime flightDateAndTime)
    {
        this.name = name;
        this.DestinationCity = DestinationCity;
        if (numberOfTravellers >= 15 && numberOfTravellers <= 100)
            this.numberOfTravellers = numberOfTravellers;
        else
            throw new IllegalArgumentException();

        this.flightDateAndTime = flightDateAndTime;
    }
    public Flight()
    {
        this("AirBus",Destination.ROME,83,new DateAndTime());
    }
    public String getFlightDuration() {
        return DestinationUtils.getDestinationDuration(DestinationCity);
    }
    
    @Override
    public String toString() {
        return "Flying " + name + " with " + numberOfTravellers + " passengers to " +
               DestinationCity + " on " + flightDateAndTime.toString();
    }

    


}
