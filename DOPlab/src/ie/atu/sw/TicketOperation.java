package ie.atu.sw;

import java.util.Collection;
import java.util.function.Predicate;

public sealed interface TicketOperation 
{
	record purchase(Attendee attendee, Concert concert, double price) implements TicketOperation{};
	record search(Collection<Concert> concerts, Predicate<Concert> criteria) implements TicketOperation{};
	record advisory(Venue venue) implements TicketOperation{};
}
