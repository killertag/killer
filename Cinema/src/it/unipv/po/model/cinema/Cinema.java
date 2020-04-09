package it.unipv.po.model.cinema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import it.unipv.po.model.booking.Booking;
import it.unipv.po.model.booking.BookingManager;



public class Cinema {
	
	/* Nell'eventualit� che venga creato pi� di un cinema, questa variabile
	 * statica verr� usata per assegnare automaticamente un id diverso ad ogni 
	 * istanza di cinema (Da valutarne l'effetiva utilit� di un id).
	 * (nel caso si voglia creare pi� di un cinema [e perch� mai??] , non va bene usare
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
	
	/* Aggiunta delle sale e dei film. � consigliato usare un nome ben preciso
	 * che identifica le sale ed i film in modo univoco nell'hashMap (ex: 'Sala 1')
	 */
	
	public boolean addTheater(String name, int openHour, int closeHour, int capienza) {
		
		if(theaterList.containsKey(name)) return false;
		
		Theater room = new Theater(name, openHour, closeHour, capienza);
		theaterList.put(name, room);
		return true;
		
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
	
	//da rimuovere il try-catch
	public Theater getTheater(String name) {
		try {
			return theaterList.get(name);
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	/* ritorna la lista delle chiavi dell'hashmap della listaSale
	 * utile nell'interfaccia grafica.
	 * uso un array di string per evitare di usare il set nei controllers
	 */
	
	public String[] getNameTheaterList() {
		
		String[] nameList = new String[theaterList.size()];
		nameList = theaterList.keySet().toArray(nameList);
		
		return nameList;
	}
	
	/* Restituisce quanti posti liberi ha una sala, dato il 
	 * nome di una sala (che deve essere contenuta nell'hashMap)
	 * (Lato grafico si potrebbe creare un menu a tendina che restituisce tutte le sale
	 * attualmente esistenti, usando un getter delle chiavi della lista).
	 */
	public int getIsAvailableSeatsTheatre(String name) {
		return theaterList.get(name).getAvailabilitySeats();
	}
	
	//da verificare implementazione di remove e change per le sale
	public void removeTheater(String name) {
		theaterList.remove(name);
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
