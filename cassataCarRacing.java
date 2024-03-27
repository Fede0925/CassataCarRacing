package it.edu.iisgubbio.gioco;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class cassataCarRacing extends Application{
	Image macchina = new Image("it/edu/iisgubbio/gioco/car.png");
	ImageView macchinaW = new ImageView(macchina);
	
	Image titolo = new Image("it/edu/iisgubbio/gioco/titolo.png");
	ImageView titoloW = new ImageView(titolo);
	
	Image strada = new Image("it/edu/iisgubbio/gioco/strada.png");
	Image strada1 = new Image("it/edu/iisgubbio/gioco/strada1.png");
	ImageView stradaW = new ImageView(strada);
	ImageView stradaW1 = new ImageView(strada1);
	
	RadioButton macchina1 = new RadioButton("macchina 1");
	RadioButton macchina2 = new RadioButton("macchina 2");
	RadioButton macchina3 = new RadioButton("macchina 3");
	
	Button apri = new Button("GIOCA");
	Button giocatore = new Button("Seleziona veicolo");
	Button difficolta = new Button("Seleziona difficolta");
	
	public void start(Stage finestra) {
		Pane griglia = new Pane();
		Scene scena = new Scene(griglia, 900, 506);
		ToggleGroup veicoli = new ToggleGroup();
		scena.getStylesheets().add("it/edu/iisgubbio/gioco/style.css");
		
		macchina1.setToggleGroup(veicoli);
		macchina2.setToggleGroup(veicoli);
		macchina3.setToggleGroup(veicoli);
		
		griglia.setId("pagina");
		griglia.setPadding(new Insets(10));
		griglia.getChildren().add(titoloW);
		griglia.getChildren().add(apri);
		griglia.getChildren().add(giocatore);
		griglia.getChildren().add(difficolta);
//		griglia.getChildren().add(macchina1);
//		griglia.getChildren().add(macchina2);
//		griglia.getChildren().add(macchina3);
		titoloW.setX(200);
		titoloW.setY(25);
		apri.setLayoutX(350);
		apri.setLayoutY(435);
		giocatore.setLayoutX(115);
		giocatore.setLayoutY(115);
		difficolta.setLayoutX(500);
		difficolta.setLayoutY(115);
		
		apri.setOnAction(e->apri());
		
		apri.setId("gioca");
		titoloW.setId("titolo");
		giocatore.setId("player");
		difficolta.setId("difficolta");
		titoloW.setFitWidth(500);
		titoloW.setFitHeight(40);
		
		finestra.getIcons().add(new Image("it/edu/iisgubbio/gioco/icona.png"));
		finestra.setScene(scena);
		finestra.setTitle("CCR: Cassata Car Racing");
		finestra.setResizable(false);
		finestra.show();
	}

	private void apri() {
		SecondaFinestra finestra2 = new SecondaFinestra();
		finestra2.show();
	}

	public class SecondaFinestra extends Stage{
		Timeline tempo = new Timeline(new KeyFrame(Duration.seconds(0.02), x->aggiorna()));
		int y = -278;
		  public SecondaFinestra(){
			Pane griglia2 = new Pane();
			Scene scene = new Scene(griglia2 , 290, 700);
			
			tempo.setCycleCount(Timeline.INDEFINITE);
			tempo.play();
			
			griglia2.setPadding(new Insets(10));
			griglia2.getChildren().add(stradaW);
			griglia2.getChildren().add(stradaW1);
			stradaW1.setX(145);
			stradaW1.setY(y);
			stradaW.setY(y);
			
			getIcons().add(new Image("it/edu/iisgubbio/gioco/icona.png"));
		    setTitle("CCR: Cassata Car Racing");
		    setScene(scene);
		    setResizable(false);
		  }
		public void aggiorna() {
			stradaW1.setY(y);
			stradaW.setY(y);
			y = y + 9;
			if(y>=0) {
				y=-278;
			}
		}
		}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
