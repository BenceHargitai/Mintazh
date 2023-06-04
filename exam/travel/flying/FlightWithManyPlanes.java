package exam.travel.flying;

import exam.travel.*;
import java.util.List;
import java.io.*;


public class FlightWithManyPlanes extends Flight{

    public List<Plane> planes;

    public FlightWithManyPlanes(String name, Destination destinationCity, int numberOfTravellers, DateAndTime flightDateAndTime, List<Plane> planes) {
        super(name, destinationCity, numberOfTravellers, flightDateAndTime);
        this.planes = planes;
    }

    public void save(String filename) throws IOException
    {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename)))
        {
            pw.println(getName());
            pw.println(getDestinationCity());
            pw.println(getNumberOfTravellers());
            pw.println(getFlightDateAndTime());

            for (Plane plane : planes)
            {
                pw.println(plane.toString());
            }
        }
        catch (IOException e)
        {
            System.out.println("Error writing to file: " + e);
        }
    }
    public void load(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            setDestinationCity(Destination.valueOf(reader.readLine()));
            setNumberOfTravellers(Integer.parseInt(reader.readLine()));
            setName(reader.readLine());

            String line = reader.readLine();

            planes.clear();


            while ((line = reader.readLine()) != null) {
                Plane plane = Plane.make(line);
                planes.add(plane);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public Plane getCheapestPlane(double DiscountRateIncrease)
    {
        if (planes.size() == 0)
            throw new IllegalStateException("No planes in the flight.");

        Plane cheapestPlane = planes.get(0);
        int cheapestPrice = cheapestPlane.getTicketPrice();

        int i = 1;

        for (Plane plane : planes)
        {

            if (plane.getPrice(1.0) < cheapestPrice)
            {
                cheapestPlane = plane;
                cheapestPrice = plane.getPrice(1.0);
            }
            i++;
        }
        return cheapestPlane;
    }
}