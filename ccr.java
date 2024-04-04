package secondeProve;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ccr extends Application{
	Timeline tempo = new Timeline(new KeyFrame(Duration.seconds(0.02), x->aggiorna()));
	Image car = new Image("secondeProve/car.png");
	ImageView carW[] = new ImageView[3];
	ImageView carW1[] = new ImageView[3];
	ImageView carW2[] = new ImageView[3];
	ImageView carW3[] = new ImageView[3];
	ImageView carW4[] = new ImageView[3];
	Rectangle giocatore = new Rectangle(40,40);
	
	int posX[] = new int[5];
	int y=-400;
	int y1=-400;
	int y2=-400;
	int y3=-400;
	int y4=-400;
	
	public void start(Stage finestra) {
		Pane griglia = new Pane();
		Scene scena = new Scene(griglia, 500, 600);
		
		griglia.getChildren().add(giocatore);
		giocatore.setX(230);
		giocatore.setY(530);
		
//		posizione X
		posX[0]=35;
		posX[1]=135;
		posX[2]=235;
		posX[3]=335;
		posX[4]=435;
		
		for(int i=0;i<carW.length;i++) {
			carW[i] = new ImageView(car);
			carW[i].setFitHeight(89);
			carW[i].setFitWidth(45);
			carW1[i] = new ImageView(car);
			carW1[i].setFitHeight(89);
			carW1[i].setFitWidth(45);
			carW2[i] = new ImageView(car);
			carW2[i].setFitHeight(89);
			carW2[i].setFitWidth(45);
			carW3[i] = new ImageView(car);
			carW3[i].setFitHeight(89);
			carW3[i].setFitWidth(45);
			carW4[i] = new ImageView(car);
			carW4[i].setFitHeight(89);
			carW4[i].setFitWidth(45);
			carW[i].setX(posX[0]);
			carW1[i].setX(posX[1]);
			carW2[i].setX(posX[2]);
			carW3[i].setX(posX[3]);
			carW4[i].setX(posX[4]);
			griglia.getChildren().add(carW[i]);
			griglia.getChildren().add(carW1[i]);
			griglia.getChildren().add(carW2[i]);
			griglia.getChildren().add(carW3[i]);
			griglia.getChildren().add(carW4[i]);
		}
		
		for(int i=0;i<carW.length;i++) {
			int r = random(100, 1000);
			int r2 = random(1100, 2000);
			int r3 = random(2100, 3000);
			r=r-(r*2);
			r2=r2-(r2*2);
			r3=r3-(r3*2);
			if(i==0) {
				carW[i].setY(r);
			}
			if(i==1) {
				carW[i].setY(r2);
			}
			if(i==2) {
				carW[i].setY(r3);
			}
		}
		
		for(int i=0;i<carW.length;i++) {
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
		
		for(int i=0;i<carW.length;i++) {
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
		
		for(int i=0;i<carW.length;i++) {
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
		
		for(int i=0;i<carW.length;i++) {
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
		
		tempo.setCycleCount(Timeline.INDEFINITE);
		tempo.play();
		
		finestra.setScene(scena);
		finestra.setTitle("test: ccr");
		finestra.show();
	}
	
	public void aggiorna() {
		for(int i=0;i<carW.length;i++) {
			y=(int) carW[i].getY()+5;
			y1=(int) carW1[i].getY()+5;
			y2=(int) carW2[i].getY()+5;
			y3=(int) carW3[i].getY()+5;
			y4=(int) carW4[i].getY()+5;
			
			carW[i].setY(y);
			carW1[i].setY(y1);
			carW2[i].setY(y2);
			carW3[i].setY(y3);
			carW4[i].setY(y4);
		}
		
		if(y>=650) {
			for(int i=0;i<carW.length;i++) {
				int r = random(100, 1000);
				int r2 = random(1100, 2000);
				int r3 = random(2100, 3000);
				r=r-(r*2);
				r2=r2-(r2*2);
				r3=r3-(r3*2);
				if(i==0) {
					carW[i].setY(r);
				}
				if(i==1) {
					carW[i].setY(r2);
				}
				if(i==2) {
					carW[i].setY(r3);
				}
			}
		}
		if(y1>=650) {
			for(int i=0;i<carW.length;i++) {
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
			for(int i=0;i<carW.length;i++) {
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
			for(int i=0;i<carW.length;i++) {
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
			for(int i=0;i<carW.length;i++) {
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
		
		Bounds b1 = giocatore.getBoundsInParent();
		
		for(int i=0;i<carW.length;i++) {
			if(carW[i].getBoundsInParent().intersects(b1)) {
				tempo.stop();
			}
			if(carW1[i].getBoundsInParent().intersects(b1)) {
				tempo.stop();
			}
			if(carW2[i].getBoundsInParent().intersects(b1)) {
				tempo.stop();
			}
			if(carW3[i].getBoundsInParent().intersects(b1)) {
				tempo.stop();
			}
			if(carW4[i].getBoundsInParent().intersects(b1)) {
				tempo.stop();
			}
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