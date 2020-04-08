package it.unipv.po.model.booking;

import java.util.Date;
import java.util.HashMap;

//import java.util.Date;

public class Booking {
	
	//attributi
	private static int generateIdBooking = 0;
	private int idBooking;
	private HashMap<Integer, Ticket> ticketList;
	private Date dateBooking;
	
	public Booking() {
		
		ticketList = new HashMap<>();
		
	}
	
	public boolean addTicket(Date dateTicket, double price, String movieTicket, String theaterName, int seatNumber) {
		try{
			Ticket ticket = new Ticket(dateTicket, price, movieTicket, theaterName, seatNumber);
			ticketList.put(ticket.getIdTicket(), ticket);
			return true;	
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public Ticket getTicket(int idTicket) {
		return ticketList.get(idTicket);
	}	
	
	public boolean removeTicket(int idTicket) {
		if(ticketList.remove(idTicket) == null) {
			return false;
		}
		return true;
	}

	
	//getter and setter utili
	public int getIdBooking() {
		return idBooking;
	}


	public Date getDateBooking() {
		return dateBooking;
	}
	
	
	
}
