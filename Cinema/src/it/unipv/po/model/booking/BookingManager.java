package it.unipv.po.model.booking;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class BookingManager {
	
	//use the Singleton pattern
	private static BookingManager instance;
	private HashMap<Integer, Booking> bookingList; 
	private Date data; //per il momento non gli sappiamo usareeeeeeeeeeeee
	private Calendar calendar; // anche questo non lo sappiamo usareeeeeeeeee
	// a che serve sto booking se non fa una minkiaaaaaaaa
	
	private BookingManager() {
		bookingList = new HashMap<Integer, Booking>();
	}
	
	public static BookingManager getInstance() {
		
		if(instance == null) {
			instance = new BookingManager();
		}
		return instance;
	}
	
	
	
	public Booking getBooking(int id) {
		return bookingList.get(id);
	}
	
	
	//metodo incompleto
	public Booking getBooking(Date d) {
		return null; 
	}
	
	public boolean removeBooking(int id) {
		if(bookingList.remove(id) == null) {
			return false;
		}
		return true;
	}
	
	public void addBooking(Date d) {
		Booking book = new Booking();
		bookingList.put(book.getIdBooking(), book);
	}
}
