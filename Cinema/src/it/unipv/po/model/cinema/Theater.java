package it.unipv.po.model.cinema;

import java.util.ArrayList;
import java.util.List;

public class Theater {
	
	//attributi
	private static int idGeneral = 0;
	
	private String theaterName; 
	private int idTheater;
	private int theaterOpeningHours;
	private int theaterClosingHours;
	private List<Movie> dailyMovies;
	private List<Seat> seatList;
	
	
	
	public Theater(String theaterName, int theaterOpeningHours,int theaterClosingHours, int capienza) {
		this.setTheaterName(theaterName);
		this.theaterOpeningHours = theaterOpeningHours;
		this.theaterClosingHours = theaterClosingHours;
		dailyMovies = new ArrayList<Movie>();
		seatList = new ArrayList<Seat>();
		
		createSeats(capienza);
		
		/* Assegnamento automatico dell'id della sala
		 * 
		 */
		idTheater = idGeneral;
		idGeneral++;
	}



	//metodi
	
	private void createSeats(int capienza) {
		
		//i corrisponde al numero della sedia nella sala
		for(int i = 0; i < capienza; i++) {
			seatList.add(new Seat(i));
		}
	}
	
	
	/*
	 * cerca numero disponibilita posti 
	 */
	public int getAvailabilitySeats() {
		
		int available = 0;
		
		for(Seat s: seatList) {
			if(s.isAvalaible()) {
				available+= 1;
			}
		}
		return available;
	}
	
	
	
	public boolean addMovie(Movie movie) {
		
		/* SE la lista dei filmo è gia piena, cioe ne contiene 3,
		 * allora ritorna 'un errore'
		 */
		if(dailyMovies.size() == 3) {
			return false;
		}
		
		if(dailyMovies.add(movie))
			return true;
		
		return false;
	}
	
	public void editMovieList(Movie movie, int fasciaOraria) {
		
		/* La variabile fascia orario ha i seguenti significati:
		 * 0: 18-20
		 * 1: 20-22
		 * 2: 22-24
		 */
		dailyMovies.add(fasciaOraria, movie);
	}
	
	// restituisce la sedia dato il numero
	public Seat getSeat(int numberSeat) {
		
		try {
			return seatList.get(numberSeat);
		} 
		catch(IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public int getCapacity() {
		return seatList.size();
	}
	
	//getter and setter
	
	public String getTheaterName() {
		return theaterName;
	}



	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}



	public int getTheaterOpeningHours() {
		return theaterOpeningHours;
	}



	public void setTheaterOpeningHours(int theaterOpeningHours) {
		this.theaterOpeningHours = theaterOpeningHours;
	}



	public int getTheaterClosingHours() {
		return theaterClosingHours;
	}



	public void setTheaterClosingHours(int theaterClosingHours) {
		this.theaterClosingHours = theaterClosingHours;
	}

}
