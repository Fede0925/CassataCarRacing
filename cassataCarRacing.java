package it.edu.iisgubbio.gioco;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
	
	Image game = new Image("it/edu/iisgubbio/gioco/gameOver.png");
	ImageView gameW = new ImageView(game);
	
	Boolean vivo = true;
	int posX[] = new int[6];
	int velS = 11;
	int velocita = 6;
	int best = 0;
	
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
		
		mBluW.setFitWidth(35);
		mBluW.setFitHeight(70);
		
		mGiallaW.setFitWidth(35);
		mGiallaW.setFitHeight(70);
		
		mRossaW.setFitWidth(35);
		mRossaW.setFitHeight(70);
		
		vespaW.setFitWidth(35);
		vespaW.setFitHeight(70);
		
		moto1W.setFitWidth(35);
		moto1W.setFitHeight(70);
		
		moto2W.setFitWidth(35);
		moto2W.setFitHeight(70);
		
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
		Timeline tempo2 = new Timeline(new KeyFrame(Duration.seconds(0.1), x->aggiorna2()));
		int y = -278;
		int rotazione = 0;
		double x = 10;
		int punteggio = 0;
		Label punti = new Label("punti: " + punteggio);
		Label lBest = new Label("Best Score: " + best);
		Boolean veicolo = false;
		ImageView carW1[] = new ImageView[3];
		ImageView carW2[] = new ImageView[3];
		ImageView carW3[] = new ImageView[3];
		ImageView carW4[] = new ImageView[3];
		ImageView carW5[] = new ImageView[3];
		ImageView carW6[] = new ImageView[3];
		Label riavvia = new Label("-PREMI SPAZIO-");
		
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
			
			lBest.setLayoutX(15);
			lBest.setLayoutY(40);
			lBest.setId("best");
			
			punti.setLayoutY(20);
			punti.setLayoutX(15);
			punti.setId("punti");
//			posizione X
			posX[0]=16;
			posX[1]=61;
			posX[2]=107;
			posX[3]=149;
			posX[4]=193;
			posX[5]=239;
			
			gameW.setX(700);
			gameW.setY(700);
			
			griglia2.getChildren().add(stradaW);
			
			crea(carW1,griglia2);
			crea(carW2,griglia2);
			crea(carW3,griglia2);
			crea(carW4,griglia2);
			crea(carW5,griglia2);
			crea(carW6,griglia2);
			
			for(int i=0;i<carW1.length;i++) {
				carW1[i].setX(posX[0]);
				carW2[i].setX(posX[1]);
				carW3[i].setX(posX[2]);
				carW4[i].setX(posX[3]);
				carW5[i].setX(posX[4]);
				carW6[i].setX(posX[5]);
			}
			
			genera(carW1);
			genera2(carW2);
			genera(carW3);
			genera2(carW4);
			genera(carW5);
			genera2(carW6);
			
			tempo.setCycleCount(Timeline.INDEFINITE);
			tempo.play();
			tempo2.setCycleCount(Timeline.INDEFINITE);
			tempo2.play();
			
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
				
				vivo=true;
				
				tempo.stop();
				tempo2.stop();
			});
			
			gameW.setFitHeight(210);
			gameW.setFitWidth(200);
			riavvia.setLayoutX(700);
			riavvia.setLayoutY(700);
			riavvia.setId("riavvia");
			griglia2.getChildren().add(gameW);
			griglia2.getChildren().add(punti);
			griglia2.getChildren().add(lBest);
			griglia2.getChildren().add(riavvia);
			getIcons().add(new Image("it/edu/iisgubbio/gioco/icona.png"));
		    setTitle("CCR: Cassata Car Racing");
		    setScene(scene);
		    setResizable(true);
		  }

		private void aggiorna2() {
			if(vivo) {
				punteggio+=1;
				punti.setText("punti: " + punteggio);
			}
			
			if(punteggio>best) {
				best=punteggio;
				lBest.setText("Best Score: " + best);
			}
		}

		private void muovi(KeyEvent e) {
//			  rotazione macchina
				int yGame = (int) gameW.getY();
				int xGame = (int) gameW.getX();
				if(e.getCode() == KeyCode.LEFT && yGame == 700 && xGame==700) {
					rotazione-=5;
				}
				
				if(e.getCode() == KeyCode.RIGHT && yGame == 700 && xGame==700) {
					rotazione+=5;
				}
				
				if(!vivo) {
					if(e.getCode() == KeyCode.SPACE) {
						bugsW.setX(290);
						bugsW.setY(700);
						riavvia.setLayoutX(700);
						riavvia.setLayoutY(700);
						gameW.setX(700);
						gameW.setY(700);
						punteggio = 0;
						rotazione=0;
						x=0; 
						
						genera(carW1);
						genera2(carW2);
						genera(carW3);
						genera2(carW4);
						genera(carW5);
						genera2(carW6);
						
						tempo.play();
						vivo=true;
					}
				}
				
				if(rotazione>10) {
					rotazione-=5;
				}
				
				if(rotazione<-10) {
					rotazione+=5;
				}
				
				if(e.getCode() != KeyCode.RIGHT && e.getCode() != KeyCode.LEFT && yGame == 700 && xGame==700) {
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
			y = y + velS;
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
//			impostazione della rotazione della macchina
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
				y1=(int) carW1[i].getY()+velocita;
				y2=(int) carW2[i].getY()+velocita;
				y3=(int) carW3[i].getY()+velocita;
				y4=(int) carW4[i].getY()+velocita;
				y5=(int) carW5[i].getY()+velocita;
				y6=(int) carW6[i].getY()+velocita;
				
				carW1[i].setY(y1);
				carW2[i].setY(y2);
				carW3[i].setY(y3);
				carW4[i].setY(y4);
				carW5[i].setY(y5);
				carW6[i].setY(y6);
			}
			
			if(y1>=700) {
				genera(carW1);
			}
			if(y2>=700) {
				genera2(carW2);
			}
			if(y3>=700) {
				genera(carW3);
			}
			if(y4>=700) {
				genera2(carW4);
			}
			if(y5>=700) {
				genera(carW5);
			}
			if(y6>=700) {
				genera2(carW6);
			}
			
			if(gialla) {
				collisioni(carW1,carW2,carW3,carW4,carW5,carW6,mGiallaW);
			}
			if(rossa) {
				collisioni(carW1,carW2,carW3,carW4,carW5,carW6,mRossaW);
			}
			if(blu || !veicolo) {
				collisioni(carW1,carW2,carW3,carW4,carW5,carW6,mBluW);
			}
			if(bVespa) {
				collisioni(carW1,carW2,carW3,carW4,carW5,carW6,vespaW);
			}
			if(bMoto1) {
				collisioni(carW1,carW2,carW3,carW4,carW5,carW6,moto1W);
			}
			if(bMoto2) {
				collisioni(carW1,carW2,carW3,carW4,carW5,carW6,moto2W);
			}
			
			if(!vivo) {
				tempo.stop();
				riavvia.setLayoutX(35);
				riavvia.setLayoutY(400);
			}
		}
		
		}
	
	public class FinestraDifficolta extends Stage{
		Button bFacile = new Button("FACILE");
		Button bMedio = new Button("MEDIO");
		Button bDifficile = new Button("DIFFICILE");
		Button bEsci = new Button("SALVA ED ESCI");
		Label lDifficolta = new Label();
		
		  public FinestraDifficolta(){
			Pane griglia2 = new Pane();
			Scene scene = new Scene(griglia2 , 890, 444);
			scene.getStylesheets().add("it/edu/iisgubbio/gioco/style.css");
			griglia2.setId("fDiff");
			
			griglia2.setPadding(new Insets(10));
			griglia2.getChildren().add(gattoW);
			griglia2.getChildren().add(giammaW);
			griglia2.getChildren().add(ranaW);
			griglia2.getChildren().add(rockW);
			griglia2.getChildren().add(homerW);
			griglia2.getChildren().add(shrekW);
			griglia2.getChildren().add(bFacile);
			griglia2.getChildren().add(bMedio);
			griglia2.getChildren().add(bDifficile);
			griglia2.getChildren().add(bEsci);
			griglia2.getChildren().add(lDifficolta);
			
			if(velocita == 6) {lDifficolta.setText("Difficolta: FACILE");}
			if(velocita == 8) {lDifficolta.setText("Difficolta: MEDIO");}
			if(velocita == 10) {lDifficolta.setText("Difficolta: DIFFICILE");}
			
			lDifficolta.setLayoutX(290);
			lDifficolta.setLayoutY(70);
			lDifficolta.setId("lDiff");
			
			bFacile.setId("facile");
			bMedio.setId("medio");
			bDifficile.setId("difficile");
			
			bFacile.setLayoutX(335);
			bMedio.setLayoutX(335);
			bDifficile.setLayoutX(335);
			
			bFacile.setLayoutY(150);
			bMedio.setLayoutY(200);
			bDifficile.setLayoutY(250);
			
			bFacile.setOnAction(e->falcie());
			bMedio.setOnAction(e->medio());
			bDifficile.setOnAction(e->difficile());
			
			bEsci.setOnAction(e->esci());
			bEsci.setLayoutX(300);
			bEsci.setLayoutY(340);
			bEsci.setId("esci");
			
			giammaW.setX(0);
			giammaW.setY(152);
			giammaW.setFitHeight(140);
			giammaW.setFitWidth(240);
			ranaW.setX(0);
			ranaW.setY(292);
			ranaW.setFitHeight(152);
			ranaW.setFitWidth(240);
			rockW.setX(650);
			rockW.setY(0);
			rockW.setFitHeight(140);
			rockW.setFitWidth(240);
			homerW.setX(650);
			homerW.setY(140);
			homerW.setFitHeight(152);
			homerW.setFitWidth(240);
			shrekW.setX(650);
			shrekW.setY(292);
			shrekW.setFitHeight(152);
			shrekW.setFitWidth(240);
			
			getIcons().add(new Image("it/edu/iisgubbio/gioco/icona.png"));
		    setTitle("CCR: Cassata Car Racing");
		    setScene(scene);
		    setResizable(false);
		  }

		private void esci() {
			hide();
		}

		private void difficile() {
			velocita = 10;
			lDifficolta.setText("Difficolta: DIFFICILE");
			velS = 13;
		}

		private void medio() {
			velocita = 8;
			lDifficolta.setText("Difficolta: MEDIO");
			velS = 11;
		}

		private void falcie() {
			velocita = 6;
			lDifficolta.setText("Difficolta: FACILE");
			velS = 11;
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
		Label macc1 = new Label("Macchina Blu");
		Label macc2 = new Label("Macchina Rossa");
		Label macc3 = new Label("Macchina Gialla");
		Label lMoto1 = new Label("Vaspa di Effe");
		Label lMoto2 = new Label("Moto Rossa");
		Label lMoto3 = new Label("Moto Blu");
		
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
			
			macc1.getStyleClass().add("lNomi");
			macc2.getStyleClass().add("lNomi");
			macc3.getStyleClass().add("lNomi");
			lMoto1.getStyleClass().add("lNomi");
			lMoto2.getStyleClass().add("lNomi");
			lMoto3.getStyleClass().add("lNomi");
			
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
			griglia2.getChildren().add(macc1);
			griglia2.getChildren().add(macc2);
			griglia2.getChildren().add(macc3);
			griglia2.getChildren().add(lMoto1);
			griglia2.getChildren().add(lMoto2);
			griglia2.getChildren().add(lMoto3);
			
			macc1.setLayoutX(145);
			macc1.setLayoutY(135);
			
			macc2.setLayoutX(380);
			macc2.setLayoutY(135);
			
			macc3.setLayoutX(625);
			macc3.setLayoutY(135);
			
			lMoto1.setLayoutX(140);
			lMoto1.setLayoutY(355);
			
			lMoto3.setLayoutX(415);
			lMoto3.setLayoutY(355);
			
			lMoto2.setLayoutX(650);
			lMoto2.setLayoutY(355);
			
			mBluW.setX(195);
			mRossaW.setX(445);
			mGiallaW.setX(695);
			mBluW.setY(50);
			mRossaW.setY(50);
			mGiallaW.setY(50);
			vespaW.setX(195);
			moto1W.setX(445);
			moto2W.setX(695);
			vespaW.setY(270);
			moto1W.setY(270);
			moto2W.setY(270);
			
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
			moto3.setLayoutX(698);
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
		    setResizable(true);
		  }
		}
	
	public void collisioni(ImageView traffico1[], ImageView traffico2[], ImageView traffico3[], ImageView traffico4[], ImageView traffico5[], ImageView traffico6[], ImageView macchina) {
		for(int i=0;i<traffico1.length;i++) {
			if(traffico1[i].getBoundsInParent().intersects(macchina.getBoundsInParent())) {
				gameW.setX(45);
				gameW.setY(200);
				vivo=false;
				bugsW.setX(290);
				bugsW.setY(700);
			}
			if(traffico2[i].getBoundsInParent().intersects(macchina.getBoundsInParent())) {
				gameW.setX(45);
				gameW.setY(200);
				vivo=false;
				bugsW.setX(290);
				bugsW.setY(700);
			}
			if(traffico3[i].getBoundsInParent().intersects(macchina.getBoundsInParent())) {
				gameW.setX(45);
				gameW.setY(200);
				vivo=false;
				bugsW.setX(290);
				bugsW.setY(700);
			}
			if(traffico4[i].getBoundsInParent().intersects(macchina.getBoundsInParent())) {
				gameW.setX(45);
				gameW.setY(200);
				vivo=false;
				bugsW.setX(290);
				bugsW.setY(700);
			}
			if(traffico5[i].getBoundsInParent().intersects(macchina.getBoundsInParent())) {
				gameW.setX(45);
				gameW.setY(200);
				vivo=false;
				bugsW.setX(290);
				bugsW.setY(700);
			}
			if(traffico6[i].getBoundsInParent().intersects(macchina.getBoundsInParent())) {
				gameW.setX(45);
				gameW.setY(200);
				vivo=false;
				bugsW.setX(290);
				bugsW.setY(700);
			}
		}
	}
	
	public void genera(ImageView traffico[]) {
		for(int i=0;i<traffico.length;i++) {
			int r = random(100, 1000);
			int r2 = random(1100, 2000);
			int r3 = random(2100, 3000);
			r=r-(r*2);
			r2=r2-(r2*2);
			r3=r3-(r3*2);
			if(i==0) {
				traffico[i].setY(r);
			}
			if(i==1) {
				traffico[i].setY(r2);
			}
			if(i==2) {
				traffico[i].setY(r3);
			}
		}
	}
	
	public void genera2(ImageView traffico[]) {
		for(int i=0;i<traffico.length;i++) {
			int r = random(3100, 4000);
			int r2 = random(4100, 5000);
			int r3 = random(5100, 6000);
			r=r-(r*2);
			r2=r2-(r2*2);
			r3=r3-(r3*2);
			if(i==0) {
				traffico[i].setY(r);
			}
			if(i==1) {
				traffico[i].setY(r2);
			}
			if(i==2) {
				traffico[i].setY(r3);
			}
		}
	}
	
	public void crea(ImageView traffico[],Pane pannello) {
		for(int i=0;i<traffico.length;i++) {
			traffico[i] = new ImageView(macchina);
			traffico[i].setFitHeight(70);
			traffico[i].setFitWidth(35);
			pannello.getChildren().add(traffico[i]);
			traffico[i].getStyleClass().add("traffico");
		}
	}
	
	public int random(int min, int max) {
	    Random random = new Random();
	    return random.nextInt(max - min) + min;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}