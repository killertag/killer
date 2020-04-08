package it.unipv.po.application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	/* 
	 * Contiene il primo elemento stage, che a sua volta contiene il scene e tutti gli elemente
	 * grafici secondo una scala gerarchica.
	 * L'uso di borderpane mi è ancora ignoto.
	 * Le finestre grafiche scritte in XML sono presenti in application.view
	 */
	private Stage primaryStage;
	private BorderPane rootView;
	private AnchorPane gestioneView;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Cinema Application");
		
		
		rootInit();
		
		try {
			  // Create a new root lauyot
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/GestioneView.fxml"));
			this.gestioneView = (AnchorPane) loader.load();
        
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//aggiungo gestione a root
		rootView.setCenter(gestioneView);
            
           /* Initializing rootLayout BorderPane
            * Importante: il primo elemente che carico deve essere dello stesso tipo
            * per cui è stata creato il file xml al root
            * come fatto sopra
            */
		Scene scene = new Scene(rootView, 800, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
			
	}
	
	/* Inizializzo lo stage tramite l'elemnto di root
	 * 
	 */
	private void rootInit() {
		
		try {
			  // Create a new root lauyot
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/ManagerView.fxml"));
			this.rootView = (BorderPane) loader.load();
          
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
