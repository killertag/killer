package it.unipv.po.controllers;

import it.unipv.po.application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class SaleControll {

    @FXML
    private TextField nameLabel;

    @FXML
    private TextField openLabel;

    @FXML
    private TextField closeLabel;

    @FXML
    private TextField capacityLabel;

    @FXML
    private Label InfText;

    @FXML
    private Button confirmButton;

    
    /* Al click del bottone aggiungi, tramite blocco try catch si verifica la 
     * correttezza dei dati aggiunti, ed in caso contrario ritorna un errore.
     * Se tutto va a buon fine si aggiunge la sala al cinema ritornando
     * un messaggio di conferma
     */
    @FXML
    public void addTheaterClick(ActionEvent event) {
    	
    	String name;
    	int openHour;
    	int closeHour;
    	int capienza;
    	
    	try {
    		
    		name = nameLabel.getText();
    		openHour = Integer.parseInt(openLabel.getText());
    		closeHour = Integer.parseInt(closeLabel.getText());
    		capienza = Integer.parseInt(capacityLabel.getText());	
    	}
    	catch (Exception e) {
    		InfText.setText("Argomenti inseriti non corretti");
    		InfText.setTextFill(Color.RED);
    		return;
    	}
    	
    	//se tutto prosegue correttamente aggiungo la sala
    	Main.myCinema.addTheater(name, openHour, closeHour, capienza);
    	InfText.setText("Aggiunto con successo");
		InfText.setTextFill(Color.BLACK);
		return;
    	
    }

    }

