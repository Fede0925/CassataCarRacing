package it.edu.iisgubbio.gioco;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class cassataCarRacing extends Application{
	Image macchina = new Image("it/edu/iisgubbio/gioco/car.png");
	ImageView macchinaW = new ImageView(macchina);
	
	Image strada = new Image("it/edu/iisgubbio/gioco/strada.png");
	ImageView stradaW = new ImageView(strada);
	
	Button apri = new Button("GIOCA");
	
	public void start(Stage finestra) {
		GridPane griglia = new GridPane();
		Scene scena = new Scene(griglia, 900, 506);
		scena.getStylesheets().add("it/edu/iisgubbio/gioco/style.css");
		
		griglia.setId("pagina");
		griglia.setAlignment(Pos.CENTER);
		griglia.setPadding(new Insets(10));
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.add(apri, 0, 0);
		apri.setOnAction(e->apri());
		apri.setId("gioca");
		
		finestra.setScene(scena);
		finestra.setTitle("Cassata Car Racing");
		finestra.show();
	}
	
	private void apri() {
		SecondaFinestra finestra2 = new SecondaFinestra();
		finestra2.show();
	}

	public class SecondaFinestra extends Stage{
		  public SecondaFinestra(){
			GridPane griglia2 = new GridPane();
			Scene scene = new Scene(griglia2 , 200, 100);
			Label testo = new Label("finestra aperta");
			
			griglia2.setAlignment(Pos.CENTER);
			griglia2.setPadding(new Insets(10));
			griglia2.setHgap(10);
			griglia2.setVgap(10);
			griglia2.add(testo, 0, 0);
			
		    setTitle("Seconda finestra!"); 
		    setScene(scene); 
		  }
		}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
