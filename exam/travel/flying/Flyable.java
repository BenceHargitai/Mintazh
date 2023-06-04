package exam.travel.flying;
import exam.travel.*;

//make an interface
public interface Flyable {
    //make a method
    int estimatedArrivalTime(int departHour, Destination dest);
    double getPrice(double discountRate);
}