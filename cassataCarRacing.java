package it.edu.iisgubbio.gioco;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class cassataCarRacing extends Application{
	Image gatto = new Image("it/edu/iisgubbio/gioco/giphy.gif");
	ImageView gattoW = new ImageView(gatto);
	
	Image giamma = new Image("it/edu/iisgubbio/gioco/giamma.jpeg");
	ImageView giammaW = new ImageView(giamma);
	
	Image rana = new Image("it/edu/iisgubbio/gioco/rana.jpg");
	ImageView ranaW = new ImageView(rana);
	
	Image rock = new Image("it/edu/iisgubbio/gioco/rock.gif");
	ImageView rockW = new ImageView(rock);
	
	Image homer = new Image("it/edu/iisgubbio/gioco/homer.gif");
	ImageView homerW = new ImageView(homer);
	
	Image shrek = new Image("it/edu/iisgubbio/gioco/shrek.jpg");
	ImageView shrekW = new ImageView(shrek);
	
	Image bugs = new Image("it/edu/iisgubbio/gioco/bugs.gif");
	ImageView bugsW = new ImageView(bugs);
	
	Image macchina = new Image("it/edu/iisgubbio/gioco/car.png");
	ImageView macchinaW = new ImageView(macchina);
	
	Image titolo = new Image("it/edu/iisgubbio/gioco/titolo.png");
	ImageView titoloW = new ImageView(titolo);
	
	Image mBlu = new Image("it/edu/iisgubbio/gioco/mBlu.png");
	ImageView mBluW = new ImageView(mBlu);
	
	Image mGialla = new Image("it/edu/iisgubbio/gioco/mGialla.png");
	ImageView mGiallaW = new ImageView(mGialla);
	
	Image mRossa = new Image("it/edu/iisgubbio/gioco/mRossa.png");
	ImageView mRossaW = new ImageView(mRossa);
	
	Image vespa = new Image("it/edu/iisgubbio/gioco/vespa.png");
	ImageView vespaW = new ImageView(vespa);
	
	Image moto1 = new Image("it/edu/iisgubbio/gioco/moto01.png");
	ImageView moto1W = new ImageView(moto1);
	
	Image moto2 = new Image("it/edu/iisgubbio/gioco/moto02.png");
	ImageView moto2W = new ImageView(moto2);
	
	Image strada = new Image("it/edu/iisgubbio/gioco/strada.png");
	ImageView stradaW = new ImageView(strada);
	
	Button apri = new Button("GIOCA");
	Button giocatore = new Button("Seleziona veicolo");
	Button difficolta = new Button("Seleziona difficolta");
	
	public void start(Stage finestra) {
		Pane griglia = new Pane();
		Scene scena = new Scene(griglia, 900, 506);
		scena.getStylesheets().add("it/edu/iisgubbio/gioco/style.css");
		
		griglia.setId("pagina");
		griglia.setPadding(new Insets(10));
		griglia.getChildren().add(titoloW);
		griglia.getChildren().add(apri);
		griglia.getChildren().add(giocatore);
		griglia.getChildren().add(difficolta);
		
		mGiallaW.setFitWidth(41);
		mGiallaW.setFitHeight(89);
		
		mRossaW.setFitWidth(41);
		mRossaW.setFitHeight(89);
		
		vespaW.setFitWidth(41);
		vespaW.setFitHeight(89);
		
		moto1W.setFitWidth(41);
		moto1W.setFitHeight(89);
		
		moto2W.setFitWidth(41);
		moto2W.setFitHeight(89);
		
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
		giocatore.setOnAction(e->veicolo());
		
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

	private void veicolo() {
		FinestraVeicolo finestra2 = new FinestraVeicolo();
		finestra2.show();
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
			griglia2.getChildren().add(bugsW);
			stradaW.setY(y);
			mBluW.setX(x);
			mBluW.setY(520);
			bugsW.setX(290);
			bugsW.setY(700);
			bugsW.setFitHeight(100);
			bugsW.setFitWidth(100);
			
			scene.setOnKeyPressed(e->muovi(e));
			
			addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, e->ciao());
			getIcons().add(new Image("it/edu/iisgubbio/gioco/icona.png"));
		    setTitle("CCR: Cassata Car Racing");
		    setScene(scene);
		    setResizable(false);
		  }
		  
		  private void ciao() {
			  tempo.stop();
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
				
				if(e.getCode() != KeyCode.RIGHT && e.getCode() != KeyCode.LEFT) {
					bugsW.setX(95);
					bugsW.setY(100);
				}
				
				mBluW.setRotate(rotazione);
			}
		  
		public void aggiorna() {
//			movimento strada
			stradaW.setY(y);
			y = y + 10;
			if(y>=0) {
				bugsW.setX(290);
				bugsW.setY(700);
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
			Scene scene = new Scene(griglia2 , 1210, 444);
		
			griglia2.setPadding(new Insets(10));
			griglia2.getChildren().add(gattoW);
			griglia2.getChildren().add(giammaW);
			griglia2.getChildren().add(ranaW);
			griglia2.getChildren().add(rockW);
			griglia2.getChildren().add(homerW);
			griglia2.getChildren().add(shrekW);
			
			giammaW.setX(0);
			giammaW.setY(152);
			giammaW.setFitHeight(140);
			giammaW.setFitWidth(240);
			ranaW.setX(0);
			ranaW.setY(292);
			ranaW.setFitHeight(152);
			ranaW.setFitWidth(240);
			rockW.setX(970);
			rockW.setY(0);
			rockW.setFitHeight(140);
			rockW.setFitWidth(240);
			homerW.setX(970);
			homerW.setY(140);
			homerW.setFitHeight(152);
			homerW.setFitWidth(240);
			shrekW.setX(970);
			shrekW.setY(292);
			shrekW.setFitHeight(152);
			shrekW.setFitWidth(240);
			
			getIcons().add(new Image("it/edu/iisgubbio/gioco/icona.png"));
		    setTitle("CCR: Cassata Car Racing");
		    setScene(scene);
		    setResizable(false);
		  }
		}
	
	public class FinestraVeicolo extends Stage{
		ToggleGroup veicoli = new ToggleGroup();
		RadioButton macchina1 = new RadioButton();
		RadioButton macchina2 = new RadioButton();
		RadioButton macchina3 = new RadioButton();
		RadioButton moto1 = new RadioButton();
		RadioButton moto2 = new RadioButton();
		RadioButton moto3 = new RadioButton();
		
		  public FinestraVeicolo(){
			Pane griglia2 = new Pane();
			Scene scene = new Scene(griglia2 , 900, 506);
			scene.getStylesheets().add("it/edu/iisgubbio/gioco/style.css");
			
			griglia2.setId("paginaVeicoli");
			griglia2.setPadding(new Insets(10));
			griglia2.getChildren().add(macchina1);
			griglia2.getChildren().add(macchina2);
			griglia2.getChildren().add(macchina3);
			griglia2.getChildren().add(moto1);
			griglia2.getChildren().add(moto2);
			griglia2.getChildren().add(moto3);
			griglia2.getChildren().add(mBluW);
			griglia2.getChildren().add(mRossaW);
			griglia2.getChildren().add(mGiallaW);
			griglia2.getChildren().add(vespaW);
			griglia2.getChildren().add(moto1W);
			griglia2.getChildren().add(moto2W);
			
			mBluW.setX(190);
			mRossaW.setX(440);
			mGiallaW.setX(690);
			mBluW.setY(80);
			mRossaW.setY(80);
			mGiallaW.setY(80);
			vespaW.setX(190);
			moto1W.setX(440);
			moto2W.setX(690);
			vespaW.setY(300);
			moto1W.setY(300);
			moto2W.setY(300);
			
//			macchina 1
			macchina1.setToggleGroup(veicoli);
			macchina1.setLayoutX(200);
			macchina1.setLayoutY(180);
//			macchina 2
			macchina2.setToggleGroup(veicoli);
			macchina2.setLayoutX(450);
			macchina2.setLayoutY(180);
//			macchina 3
			macchina3.setToggleGroup(veicoli);
			macchina3.setLayoutX(700);
			macchina3.setLayoutY(180);
			
			macchina1.setId("m1");
			macchina2.setId("m2");
			macchina3.setId("m3");
			
			moto1.setId("m1");
			moto2.setId("m2");
			moto3.setId("m3");
			
			moto1.setToggleGroup(veicoli);
			moto1.setLayoutX(200);
			moto1.setLayoutY(400);
			
			moto2.setToggleGroup(veicoli);
			moto2.setLayoutX(450);
			moto2.setLayoutY(400);
			
			moto3.setToggleGroup(veicoli);
			moto3.setLayoutX(700);
			moto3.setLayoutY(400);
			
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