package it.edu.iisgubbio.gioco;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class cassataCarRacing extends Application{
	Image macchina = new Image("it/edu/iisgubbio/gioco/car.png");
	ImageView macchinaW = new ImageView(macchina);
	
	Image titolo = new Image("it/edu/iisgubbio/gioco/titolo.png");
	ImageView titoloW = new ImageView(titolo);
	
	Image mBlu = new Image("it/edu/iisgubbio/gioco/mBlu.png");
	ImageView mBluW = new ImageView(mBlu);
	
	Image strada = new Image("it/edu/iisgubbio/gioco/strada.png");
	ImageView stradaW = new ImageView(strada);
	
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
		difficolta.setOnAction(e->difficolta());
		
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

	private void difficolta() {
		FinestraDifficolta finestra2 = new FinestraDifficolta();
		finestra2.show();
	}

	private void apri() {
		FinestraGioco finestra2 = new FinestraGioco();
		finestra2.show();
	}

	public class FinestraGioco extends Stage{
		Timeline tempo = new Timeline(new KeyFrame(Duration.seconds(0.02), x->aggiorna()));
		int y = -278;
		int rotazione = 0;
		double x = 10;
		int velocita = 6;
		
		  public FinestraGioco(){
			Pane griglia2 = new Pane();
			Scene scene = new Scene(griglia2 , 290, 700);
			
			tempo.setCycleCount(Timeline.INDEFINITE);
			tempo.play();
			
			griglia2.setPadding(new Insets(10));
			griglia2.getChildren().add(stradaW);
			griglia2.getChildren().add(mBluW);
			stradaW.setY(y);
			mBluW.setX(x);
			mBluW.setY(520);
			
			scene.setOnKeyPressed(e->muovi(e));
			
			getIcons().add(new Image("it/edu/iisgubbio/gioco/icona.png"));
		    setTitle("CCR: Cassata Car Racing");
		    setScene(scene);
		    setResizable(false);
		  }
		  
		  private void muovi(KeyEvent e) {
//			  rotazione macchina
				if(e.getCode() == KeyCode.LEFT) {
					rotazione-=5;
				}
				
				if(e.getCode() == KeyCode.RIGHT) {
					rotazione+=5;
				}
				
				if(rotazione>10) {
					rotazione-=5;
				}
				
				if(rotazione<-10) {
					rotazione+=5;
				}
				
				mBluW.setRotate(rotazione);
			}
		  
		public void aggiorna() {
//			movimento strada
			stradaW.setY(y);
			y = y + 10;
			if(y>=0) {
				y=-278;
			}
//			movimento macchina
			if(x>9 && x<240) {
			if(rotazione>0) {
				x+=1.5;
			}
			if(rotazione<0) {
				x-=1.5;
			}
			if(rotazione>5) {
				x+=1.8;
			}
			if(rotazione<-5) {
				x-=1.8;
			}
			}
			if(x<=9) {
				x=10;
				rotazione=0;
			}
			if(x>=240) {
				x=239;
				rotazione=0;
			}
			
			mBluW.setX(x);
			mBluW.setRotate(rotazione);
		}
		}
	
	public class FinestraDifficolta extends Stage{
		  public FinestraDifficolta(){
			Pane griglia2 = new Pane();
			Scene scene = new Scene(griglia2 , 400, 300);
			Label scritta = new Label("finestra difficolta");
		
			griglia2.setPadding(new Insets(10));
			griglia2.getChildren().add(scritta);
			
			getIcons().add(new Image("it/edu/iisgubbio/gioco/icona.png"));
		    setTitle("CCR: Cassata Car Racing");
		    setScene(scene);
		    setResizable(false);
		  }
		}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
