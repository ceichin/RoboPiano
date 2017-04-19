import java.util.Timer;
import java.util.TimerTask;

public class Inicio {

	public static void main(String[] args) {

		Robozart.rythmTime = 700;
		Robozart.sostenidoTime = 1200;
		
		Robozart.Calibrar();
	
		//Robozart.SensorTest();
		
		//Robozart.Escala();
		//Robozart.Vacio();
		//Robozart.Lleno();
		//Robozart.Padrino();
		Robozart.Himno();
	}

}
