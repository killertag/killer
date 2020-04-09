package it.unipv.po.model.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import it.unipv.po.model.booking.Booking;
import it.unipv.po.model.booking.BookingManager;

public class Cinema {
	
	/* Nell'eventualità che venga creato più di un cinema, questa variabile
	 * statica verrà usata per assegnare automaticamente un id diverso ad ogni 
	 * istanza di cinema (Da valutarne l'effetiva utilità di un id).
	 * (nel caso si voglia creare più di un cinema [e perchè mai??] , non va bene usare
	 * il singleton per il bookingManager)
	 */
	private static int idGeneral = 0;
	
	// attributi
	private String cinemaName;
	private int idCinema;
	private String address;
	private HashMap<String, Theater> theaterList;
	private HashMap<String, Movie> movieList;
	private BookingManager bookingManager;  //Una sola istanza per cinema
	
	public Cinema(String name, String address) {
		this.address = address;
		this.cinemaName = name;
		this.idCinema = idGeneral;
		
		//Ne esite solo uno (pattern Singleton)
		bookingManager = BookingManager.getInstance();
		
		theaterList = new HashMap<String, Theater>();
		movieList = new HashMap<String, Movie>();
		
		idGeneral++;
	}
	
	//metodi 
	
	/* Aggiunta delle sale e dei film. é consigliato usare un nome ben preciso
	 * che identifica le sale ed i film in modo univoco nell'hashMap (ex: 'Sala 1')
	 */
	
	public void addTheater(String name, int openHour, int closeHour, int capienza) {
		
		Theater room = new Theater(name, openHour, closeHour, capienza);
		theaterList.put(name, room);
		
	}

	public void addMovie(String name, double duration, double date, MovieCategory type, boolean underage, double price ) {
		Movie film = new Movie(name, duration, date, type, underage, price);
		movieList.put(name, film);
	}
	
	
	/* Funzioni che restitutiscono sale e film tramite ricerca della chiave 'name'
	 * nelle rispettive hashMap
	 */
	public Movie getMovie(String name) {
		try {
			return movieList.get(name);
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Theater getTheater(String name) {
		try {
			return theaterList.get(name);
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	/* Restituisce quanti posti liberi ha una sala, dato il 
	 * nome di una sala (che deve essere contenuta nell'hashMap)
	 * (Lato grafico si potrebbe creare un menu a tendina che restituisce tutte le sale
	 * attualmente esistenti, usando un getter delle chiavi della lista).
	 */
	public int getIsAvailableSeatsTheatre(String name) {
		return theaterList.get(name).getAvailabilitySeats();
	}
	
	
	// getters informativi
	public String getCinemaName() {
		return cinemaName;
	}

	public int getIdCinema() {
		return idCinema;
	}

	public String getAddress() {
		return address;
	}
	
}
