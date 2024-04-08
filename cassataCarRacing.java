package it.edu.iisgubbio.gioco;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
	Boolean blu = false;
	
	Image mGialla = new Image("it/edu/iisgubbio/gioco/mGialla.png");
	ImageView mGiallaW = new ImageView(mGialla);
	Boolean gialla = false;
	
	Image mRossa = new Image("it/edu/iisgubbio/gioco/mRossa.png");
	ImageView mRossaW = new ImageView(mRossa);
	Boolean rossa = false;
	
	Image vespa = new Image("it/edu/iisgubbio/gioco/vespa.png");
	ImageView vespaW = new ImageView(vespa);
	Boolean bVespa = false;
	
	Image moto1 = new Image("it/edu/iisgubbio/gioco/moto01.png");
	ImageView moto1W = new ImageView(moto1);
	Boolean bMoto1 = false;
	
	Image moto2 = new Image("it/edu/iisgubbio/gioco/moto02.png");
	ImageView moto2W = new ImageView(moto2);
	Boolean bMoto2 = false;
	
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
		Boolean veicolo = false;
		ImageView carW1[] = new ImageView[3];
		ImageView carW2[] = new ImageView[3];
		ImageView carW3[] = new ImageView[3];
		ImageView carW4[] = new ImageView[3];
		ImageView carW5[] = new ImageView[3];
		ImageView carW6[] = new ImageView[3];
		
		int posX[] = new int[6];
		int y1=-400;
		int y2=-400;
		int y3=-400;
		int y4=-400;
		int y5=-400;
		int y6=-400;
		
		  public FinestraGioco(){
			Pane griglia2 = new Pane();
			Scene scene = new Scene(griglia2 , 290, 700);
			scene.getStylesheets().add("it/edu/iisgubbio/gioco/style.css");
			
			stradaW.setId("strada");
			
//			posizione X
			posX[0]=35;
			posX[1]=135;
			posX[2]=235;
			posX[3]=335;
			posX[4]=435;
			posX[5]=535;
			
			griglia2.getChildren().add(stradaW);
			for(int i=0;i<carW1.length;i++) {
				carW1[i] = new ImageView(macchina);
				carW1[i].setFitHeight(89);
				carW1[i].setFitWidth(45);
				carW2[i] = new ImageView(macchina);
				carW2[i].setFitHeight(89);
				carW2[i].setFitWidth(45);
				carW3[i] = new ImageView(macchina);
				carW3[i].setFitHeight(89);
				carW3[i].setFitWidth(45);
				carW4[i] = new ImageView(macchina);
				carW4[i].setFitHeight(89);
				carW4[i].setFitWidth(45);
				carW5[i] = new ImageView(macchina);
				carW5[i].setFitHeight(89);
				carW5[i].setFitWidth(45);
				carW6[i] = new ImageView(macchina);
				carW6[i].setFitHeight(89);
				carW6[i].setFitWidth(45);
				carW1[i].setX(posX[0]);
				carW2[i].setX(posX[1]);
				carW3[i].setX(posX[2]);
				carW4[i].setX(posX[3]);
				carW5[i].setX(posX[4]);
				carW6[i].setX(posX[5]);
				griglia2.getChildren().add(carW1[i]);
				griglia2.getChildren().add(carW2[i]);
				griglia2.getChildren().add(carW3[i]);
				griglia2.getChildren().add(carW4[i]);
				griglia2.getChildren().add(carW5[i]);
				griglia2.getChildren().add(carW6[i]);
				carW1[i].getStyleClass().add("traffico");
				carW2[i].getStyleClass().add("traffico");
				carW3[i].getStyleClass().add("traffico");
				carW4[i].getStyleClass().add("traffico");
				carW5[i].getStyleClass().add("traffico");
				carW6[i].getStyleClass().add("traffico");
				
			}
			
			for(int i=0;i<carW1.length;i++) {
				int r = random(100, 1000);
				int r2 = random(1100, 2000);
				int r3 = random(2100, 3000);
				r=r-(r*2);
				r2=r2-(r2*2);
				r3=r3-(r3*2);
				if(i==0) {
					carW1[i].setY(r);
				}
				if(i==1) {
					carW1[i].setY(r2);
				}
				if(i==2) {
					carW1[i].setY(r3);
				}
			}
			
			for(int i=0;i<carW1.length;i++) {
				int r = random(100, 1000);
				int r2 = random(1100, 2000);
				int r3 = random(2100, 3000);
				r=r-(r*2);
				r2=r2-(r2*2);
				r3=r3-(r3*2);
				if(i==0) {
					carW2[i].setY(r);
				}
				if(i==1) {
					carW2[i].setY(r2);
				}
				if(i==2) {
					carW2[i].setY(r3);
				}
			}
			
			for(int i=0;i<carW1.length;i++) {
				int r = random(100, 1000);
				int r2 = random(1100, 2000);
				int r3 = random(2100, 3000);
				r=r-(r*2);
				r2=r2-(r2*2);
				r3=r3-(r3*2);
				if(i==0) {
					carW3[i].setY(r);
				}
				if(i==1) {
					carW3[i].setY(r2);
				}
				if(i==2) {
					carW3[i].setY(r3);
				}
			}
			
			for(int i=0;i<carW1.length;i++) {
				int r = random(100, 1000);
				int r2 = random(1100, 2000);
				int r3 = random(2100, 3000);
				r=r-(r*2);
				r2=r2-(r2*2);
				r3=r3-(r3*2);
				if(i==0) {
					carW4[i].setY(r);
				}
				if(i==1) {
					carW4[i].setY(r2);
				}
				if(i==2) {
					carW4[i].setY(r3);
				}
			}
			
			for(int i=0;i<carW1.length;i++) {
				int r = random(100, 1000);
				int r2 = random(1100, 2000);
				int r3 = random(2100, 3000);
				r=r-(r*2);
				r2=r2-(r2*2);
				r3=r3-(r3*2);
				if(i==0) {
					carW5[i].setY(r);
				}
				if(i==1) {
					carW5[i].setY(r2);
				}
				if(i==2) {
					carW5[i].setY(r3);
				}
			}
			
			for(int i=0;i<carW1.length;i++) {
				int r = random(100, 1000);
				int r2 = random(1100, 2000);
				int r3 = random(2100, 3000);
				r=r-(r*2);
				r2=r2-(r2*2);
				r3=r3-(r3*2);
				if(i==0) {
					carW6[i].setY(r);
				}
				if(i==1) {
					carW6[i].setY(r2);
				}
				if(i==2) {
					carW6[i].setY(r3);
				}
			}
			
			tempo.setCycleCount(Timeline.INDEFINITE);
			tempo.play();
			
			griglia2.setPadding(new Insets(10));
			griglia2.getChildren().add(bugsW);
			stradaW.setY(y);
			bugsW.setX(290);
			bugsW.setY(700);
			bugsW.setFitHeight(100);
			bugsW.setFitWidth(100);
			
			if(blu) {
				griglia2.getChildren().add(mBluW);
				mBluW.setX(x);
				mBluW.setY(520);
				veicolo = true;
			}
			if(rossa) {
				griglia2.getChildren().add(mRossaW);
				mRossaW.setX(x);
				mRossaW.setY(520);
				veicolo = true;
			}
			if(gialla) {
				griglia2.getChildren().add(mGiallaW);
				mGiallaW.setX(x);
				mGiallaW.setY(520);
				veicolo = true;
			}
			if(bVespa) {
				griglia2.getChildren().add(vespaW);
				vespaW.setX(x);
				vespaW.setY(520);
				veicolo = true;
			}
			if(bMoto1) {
				griglia2.getChildren().add(moto1W);
				moto1W.setX(x);
				moto1W.setY(520);
				veicolo = true;
			}
			if(bMoto2) {
				griglia2.getChildren().add(moto2W);
				moto2W.setX(x);
				moto2W.setY(520);
				veicolo = true;
			}
			if(!veicolo) {
				griglia2.getChildren().add(mBluW);
				mBluW.setX(x);
				mBluW.setY(520);
			}
			
			scene.setOnKeyPressed(e->muovi(e));
			
			addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, e->{
				griglia2.getChildren().remove(mBluW);
				blu=false;
				griglia2.getChildren().remove(mRossaW);
				rossa=false;
				griglia2.getChildren().remove(mGiallaW);
				gialla=false;
				griglia2.getChildren().remove(vespaW);
				bVespa=false;
				griglia2.getChildren().remove(moto1W);
				bMoto1=false;
				griglia2.getChildren().remove(moto2W);
				bMoto2=false;
				
				tempo.stop();
			});
			getIcons().add(new Image("it/edu/iisgubbio/gioco/icona.png"));
		    setTitle("CCR: Cassata Car Racing");
		    setScene(scene);
		    setResizable(true);
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
				
				if(blu) {
					mBluW.setRotate(rotazione);
				}
				if(rossa) {
					mRossaW.setRotate(rotazione);
				}
				if(gialla) {
					mGiallaW.setRotate(rotazione);
				}
				if(bVespa) {
					vespaW.setRotate(rotazione);
				}
				if(bMoto1) {
					moto1W.setRotate(rotazione);
				}
				if(bMoto2) {
					moto2W.setRotate(rotazione);
				}
				if(!veicolo) {
					mBluW.setRotate(rotazione);
				}
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
			
			if(blu) {
				mBluW.setRotate(rotazione);
				mBluW.setX(x);
			}
			if(rossa) {
				mRossaW.setRotate(rotazione);
				mRossaW.setX(x);
			}
			if(gialla) {
				mGiallaW.setRotate(rotazione);
				mGiallaW.setX(x);
			}
			if(bVespa) {
				vespaW.setRotate(rotazione);
				vespaW.setX(x);
			}
			if(bMoto1) {
				moto1W.setRotate(rotazione);
				moto1W.setX(x);
			}
			if(bMoto2) {
				moto2W.setRotate(rotazione);
				moto2W.setX(x);
			}
			if(!veicolo) {
				mBluW.setRotate(rotazione);
				mBluW.setX(x);
			}
			
			for(int i=0;i<carW1.length;i++) {
				y1=(int) carW1[i].getY()+5;
				y2=(int) carW2[i].getY()+5;
				y3=(int) carW3[i].getY()+5;
				y4=(int) carW4[i].getY()+5;
				y5=(int) carW5[i].getY()+5;
				y6=(int) carW6[i].getY()+5;
				
				carW1[i].setY(y1);
				carW2[i].setY(y2);
				carW3[i].setY(y3);
				carW4[i].setY(y4);
				carW5[i].setY(y5);
				carW6[i].setY(y6);
			}
			
			if(y1>=650) {
				for(int i=0;i<carW1.length;i++) {
					int r = random(100, 1000);
					int r2 = random(1100, 2000);
					int r3 = random(2100, 3000);
					r=r-(r*2);
					r2=r2-(r2*2);
					r3=r3-(r3*2);
					if(i==0) {
						carW1[i].setY(r);
					}
					if(i==1) {
						carW1[i].setY(r2);
					}
					if(i==2) {
						carW1[i].setY(r3);
					}
				}
			}
			if(y2>=650) {
				for(int i=0;i<carW1.length;i++) {
					int r = random(100, 1000);
					int r2 = random(1100, 2000);
					int r3 = random(2100, 3000);
					r=r-(r*2);
					r2=r2-(r2*2);
					r3=r3-(r3*2);
					if(i==0) {
						carW2[i].setY(r);
					}
					if(i==1) {
						carW2[i].setY(r2);
					}
					if(i==2) {
						carW2[i].setY(r3);
					}
				}
			}
			if(y3>=650) {
				for(int i=0;i<carW1.length;i++) {
					int r = random(100, 1000);
					int r2 = random(1100, 2000);
					int r3 = random(2100, 3000);
					r=r-(r*2);
					r2=r2-(r2*2);
					r3=r3-(r3*2);
					if(i==0) {
						carW3[i].setY(r);
					}
					if(i==1) {
						carW3[i].setY(r2);
					}
					if(i==2) {
						carW3[i].setY(r3);
					}
				}
			}
			if(y4>=650) {
				for(int i=0;i<carW1.length;i++) {
					int r = random(100, 1000);
					int r2 = random(1100, 2000);
					int r3 = random(2100, 3000);
					r=r-(r*2);
					r2=r2-(r2*2);
					r3=r3-(r3*2);
					if(i==0) {
						carW4[i].setY(r);
					}
					if(i==1) {
						carW4[i].setY(r2);
					}
					if(i==2) {
						carW4[i].setY(r3);
					}
				}
			}
			if(y5>=650) {
				for(int i=0;i<carW1.length;i++) {
					int r = random(100, 1000);
					int r2 = random(1100, 2000);
					int r3 = random(2100, 3000);
					r=r-(r*2);
					r2=r2-(r2*2);
					r3=r3-(r3*2);
					if(i==0) {
						carW5[i].setY(r);
					}
					if(i==1) {
						carW5[i].setY(r2);
					}
					if(i==2) {
						carW5[i].setY(r3);
					}
				}
			}
			if(y6>=650) {
				for(int i=0;i<carW1.length;i++) {
					int r = random(100, 1000);
					int r2 = random(1100, 2000);
					int r3 = random(2100, 3000);
					r=r-(r*2);
					r2=r2-(r2*2);
					r3=r3-(r3*2);
					if(i==0) {
						carW6[i].setY(r);
					}
					if(i==1) {
						carW6[i].setY(r2);
					}
					if(i==2) {
						carW6[i].setY(r3);
					}
				}
			}
			
		}
		
		public int random(int min, int max) {
		    Random random = new Random();
		    return random.nextInt(max - min) + min;
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
		RadioButton macchinaBlu = new RadioButton();
		RadioButton macchinaRossa = new RadioButton();
		RadioButton macchinaGialla = new RadioButton();
		RadioButton vespaRb = new RadioButton();
		RadioButton moto2 = new RadioButton();
		RadioButton moto3 = new RadioButton();
		
		  public FinestraVeicolo(){
			Pane griglia2 = new Pane();
			Scene scene = new Scene(griglia2 , 900, 506);
			scene.getStylesheets().add("it/edu/iisgubbio/gioco/style.css");
			
			blu=false;
			rossa=false;
			gialla=false;
			bVespa=false;
			bMoto1=false;
			bMoto2=false;
			
			mBluW.setRotate(0);
			mRossaW.setRotate(0);
			mGiallaW.setRotate(0);
			vespaW.setRotate(0);
			moto1W.setRotate(0);
			moto2W.setRotate(0);
			
	        Button btn = new Button();
	        
			griglia2.setId("paginaVeicoli");
			griglia2.setPadding(new Insets(10));
			griglia2.getChildren().add(macchinaBlu);
			griglia2.getChildren().add(macchinaRossa);
			griglia2.getChildren().add(macchinaGialla);
			griglia2.getChildren().add(vespaRb);
			griglia2.getChildren().add(moto2);
			griglia2.getChildren().add(moto3);
			griglia2.getChildren().add(mBluW);
			griglia2.getChildren().add(mRossaW);
			griglia2.getChildren().add(mGiallaW);
			griglia2.getChildren().add(vespaW);
			griglia2.getChildren().add(moto1W);
			griglia2.getChildren().add(moto2W);
			griglia2.getChildren().add(btn);
			
			mBluW.setX(190);
			mRossaW.setX(440);
			mGiallaW.setX(690);
			mBluW.setY(60);
			mRossaW.setY(60);
			mGiallaW.setY(60);
			vespaW.setX(190);
			moto1W.setX(440);
			moto2W.setX(690);
			vespaW.setY(280);
			moto1W.setY(280);
			moto2W.setY(280);
			
//			macchina 1
			macchinaBlu.setToggleGroup(veicoli);
			macchinaBlu.setLayoutX(200);
			macchinaBlu.setLayoutY(160);
//			macchina 2
			macchinaRossa.setToggleGroup(veicoli);
			macchinaRossa.setLayoutX(450);
			macchinaRossa.setLayoutY(160);
//			macchina 3
			macchinaGialla.setToggleGroup(veicoli);
			macchinaGialla.setLayoutX(700);
			macchinaGialla.setLayoutY(160);
			
			macchinaBlu.setId("m1");
			macchinaRossa.setId("m2");
			macchinaGialla.setId("m3");
			
			vespaRb.setId("m1");
			moto2.setId("m2");
			moto3.setId("m3");
			
			vespaRb.setToggleGroup(veicoli);
			vespaRb.setLayoutX(200);
			vespaRb.setLayoutY(380);
			
			moto2.setToggleGroup(veicoli);
			moto2.setLayoutX(450);
			moto2.setLayoutY(380);
			
			moto3.setToggleGroup(veicoli);
			moto3.setLayoutX(700);
			moto3.setLayoutY(380);
			
	        btn.setText("Salva ed Esci");
	        btn.setId("save");
	        btn.setOnAction((ActionEvent event) -> {
	        	if(macchinaBlu.isSelected()) {
	        		blu=true;
	        	}
	        	if(macchinaGialla.isSelected()) {
	        		gialla=true;
	        	}
	        	if(macchinaRossa.isSelected()) {
	        		rossa=true;
	        	}
	        	if(vespaRb.isSelected()) {
	        		bVespa=true;
	        	}
	        	if(moto2.isSelected()) {
	        		bMoto1=true;
	        	}
	        	if(moto3.isSelected()) {
	        		bMoto2=true;
	        	}
	        	
	            hide();
	        });
			btn.setLayoutX(330);
			btn.setLayoutY(440);
			
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