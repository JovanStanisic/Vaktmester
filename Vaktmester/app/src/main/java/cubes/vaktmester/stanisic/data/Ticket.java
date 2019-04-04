package cubes.vaktmester.stanisic.data;

public class Ticket {

    // fildovi koje unosim su na osnovu recyclerview podataka sa 10-og ekrana u invisionu
    public String id;
    public String ticketName;
    public String ticketCreated;
    public String ticketStarted;
    public String ticketStatus;
    public String ticketPriority;

    public Ticket(){
        id = "1";
        ticketName = "Popravka ulaznih vrata";
        ticketCreated = "23.01.2019";
        ticketStarted = "1.03.2019";
        ticketStatus = "In progress";
        ticketPriority = "High";
    }

}
