package it.unipv.po.model.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.unipv.po.model.booking.Booking;

public class Cinema {
	
	
	// attributi
	private String cinemaName;
	private int idCinema;
	private String address;
	private HashMap<String, Theater> theaterList;
	private List<Booking> bookingList;  
	private HashMap<String, Movie> movieList;
	
	public Cinema(String name, String address) {
		this.address = address;
		this.cinemaName = name;
		this.idCinema = 0;
		
		theaterList = new HashMap<String, Theater>();
		bookingList = new ArrayList<Booking>();
		movieList = new HashMap<String, Movie>();
		
		
	}
	
	//metodi 
	
	/*
	 * aggiunta delle sale
	 */
	
	public void addTheater(String name, int openhour, int closehour, int capienza) {
		
		Theater room = new Theater(name, openhour, closehour, capienza);
		theaterList.put(name, room);
		
	}
	
	/*
	 * aggiunta di film alla lista   
	 */
	
	public void addMovie(String name, double duration, double date, MovieCategory type, boolean underage, double price ) {
		Movie film = new Movie(name, duration, date, type, underage, price);
		movieList.put(name, film);
	}
	
	public Movie getMovie(String name) {
		try {
			return movieList.get(name);
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	
	
	//recupera la sala dal nome della sala
		public Theater getTheater(String name) {
			try {
				return theaterList.get(name);
			}
			catch(NullPointerException e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		
		public int getIsAvailableSeatsTheatre(String name) {
			try {
				return theaterList.get(name).getAvailabilitySeats();
			}
			catch(NullPointerException e) {
				System.out.println(e.getMessage());
				return -1;
			}
		}
	
	
	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public int getIdCinema() {
		return idCinema;
	}

	public void setIdCinema(int idCinema) {
		this.idCinema = idCinema;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
