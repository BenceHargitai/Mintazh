package exam.travel;

import java.util.HashMap;

public class DestinationUtils {

    
    public static Destination getDestination(String ido)
    {
        
        HashMap<String,Destination> destinations = new HashMap<String,Destination>();
        destinations.put("01:34",Destination.BERLIN);
        destinations.put("01:45",Destination.ROME);
        destinations.put("02:05",Destination.AMSTERDAM);
        destinations.put("02:20",Destination.PARIS);
        destinations.put("02:43",Destination.HELSINKI);
        return(destinations.get(ido)==null ? null : destinations.get(ido));
    }
    public static String getDestinationDuration(Destination dest)
    {
        HashMap<Destination,String> destinations = new HashMap<Destination,String>();
        destinations.put(Destination.BERLIN,"01:34");
        destinations.put(Destination.ROME,"01:45");
        destinations.put(Destination.AMSTERDAM,"02:05");
        destinations.put(Destination.PARIS,"02:20");
        destinations.put(Destination.HELSINKI,"02:43");

        return destinations.get(dest).toString();
    }

    public static String getRoundedHours(Destination dest)
    {
        String ido = getDestinationDuration(dest);
        if (Integer.parseInt(ido.split(":")[1]) >= 30)
        {
            int ora = Integer.parseInt(ido.split(":")[0])+1;
            return (ora+"").toString();
        }
        return ido.split(":")[0];

    }


}
