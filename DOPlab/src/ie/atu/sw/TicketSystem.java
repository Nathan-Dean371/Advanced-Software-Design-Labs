package ie.atu.sw;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TicketSystem {
	
	public static Ticket purchase(TicketOperation.purchase pur)
	{
		return purchase(pur.attendee(), pur.concert(), pur.price());
	}
	
	public static Ticket purchase(Attendee attendee, Concert concert, double price)
	{
		var advisory = advisory(new TicketOperation.advisory(concert.venue()));
		return new Ticket(concert, attendee, price, advisory);
	}
	
	public static Collection<Concert>  search(TicketOperation.search sch)
	{
		return search(sch.concerts(), sch.criteria());
	}
	
	 public static Collection<Concert>  search(Collection<Concert> concerts, Predicate<Concert> criteria)
	 {
		 return concerts.stream()
				 .filter(criteria)
				 .collect(Collectors.toList());
	 }
	 
	 public static String advisory(TicketOperation.advisory adv)
	 {
		 var result = advisory(adv.venue());
		 return result.orElse("Enjoy the concert.");
	 }
	 
	 public static Advisory<String> advisory(Venue venue)
	 {
		 double lightClothingTemp = 13.00d;
		 var sb = new StringBuilder();
		 
		 if(!venue.country().isEUMember()) sb.append("Bring a passport if travelling. ");
		 if(venue.country().temperature() >= lightClothingTemp) sb.append("Wear light clothing.");
		 if(venue.country().precipitation() >= 1000) sb.append("Bring waterproof clothing. ");
		 if(venue.capacity() > 10000) sb.append("vertigo and enochlophobia warning. ");
		 
		 sb.append(
		 switch(venue.type())
		 {
		 	case AMPHITHEATER, ARENA, STADIUM -> "vertigo and enochlophobia warning. ";
		 	default -> "";
		 });
		 
		 return sb.length() > 0
				? new Advisory.Present<>(sb.toString())
		 		: new Advisory.Absent<>();
	 }

}
