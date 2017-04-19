import lejos.nxt.*;
import lejos.util.Stopwatch;

public class Robozart {

	private static Stopwatch stopwatch = new Stopwatch();
	
	public static int rythmTime; // in ms
	public static int sostenidoTime; // in ms

	public static void Calibrar()
	{
		LightSensor light = new LightSensor(SensorPort.S2);
		
		while (light.getLightValue() < 40 && !Button.ESCAPE.isDown()) {
			Motor.B.rotate(1);
		}
		
		Motor.B.resetTachoCount();
	}
	
	public static void EsperarBoton() {
		Button.waitForAnyPress();
	}
	
	public static void DosBeeps() {
		Sound.twoBeeps();
	}
	
	public static void Beep() {
		Sound.beep();
	}
	
	public static void Tocar(String nota) {
		
		Motor.B.setSpeed(10000);
		
		char n = nota.charAt(0);
		boolean sostenido;
		if(nota.length() > 1)
			sostenido = nota.charAt(1) == 's';
		else
			sostenido = false;
		int fix = -10;
		
		switch (n) {
		
			case ' ':
				while(stopwatch.elapsed() < rythmTime) { }
				stopwatch.reset();
				break;
			
			case 'c':
				Motor.B.rotateTo(-63 + fix);
				Press(sostenido);
				break;

			case 'd':
				Motor.B.rotateTo(-105 + fix);
				Press(sostenido);
				break;

			case 'e':
				Motor.B.rotateTo(-150 + fix);
				Press(sostenido);
				break;

			case 'f':
				Motor.B.rotateTo(-193 + fix);
				Press(sostenido);
				break;

			case 'g':
				Motor.B.rotateTo(-234 + fix);
				Press(sostenido);
				break;

			case 'a':
				Motor.B.rotateTo(-277 + fix);
				Press(sostenido);
				break;

			case 'b':
				Motor.B.rotateTo(-317 + fix);
				Press(sostenido);
				break;

			case 'C':
				Motor.B.rotateTo(-362 + fix);
				Press(sostenido);
				break;

			case 'x':
				Motor.B.rotateTo(-20);
				break;

			default:
				break;
		}
	}
	
    // Test del light sensor
	public static void SensorTest()
	{
		LightSensor light = new LightSensor(SensorPort.S2);

	    while (true && !Button.ESCAPE.isDown()) {
	      LCD.drawInt(light.getLightValue(), 4, 0, 0);
	      LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1);
	      LCD.drawInt(SensorPort.S2.readRawValue(), 4, 0, 2);
	      LCD.drawInt(SensorPort.S2.readValue(), 4, 0, 3);
	    }
	}
	
	public static void TocarNotas(String[] notas)
	{
		for(int i = 0; i < notas.length && !Button.ESCAPE.isDown(); i++)
			Tocar(notas[i]);
		Tocar("x");
	}

	private static void Press(boolean sostenido) {
		TouchSensor touch = new TouchSensor(SensorPort.S1);
		
		while(stopwatch.elapsed() < rythmTime) { }
		stopwatch.reset();
		
		Motor.A.setSpeed(200);
		Motor.A.forward();
		while (!touch.isPressed()) { }
		Motor.A.rotate(9);
		if(sostenido) {
			while(stopwatch.elapsed() < sostenidoTime) { }
			stopwatch.reset();
		}
		Motor.A.rotate(-28, true);
	}
	
	public static void Vacio() {
		Robozart.DosBeeps();
	}
	
	public static void Lleno() {
		Robozart.Tocar("c");
		Robozart.Tocar("d");
		Robozart.Tocar("e");
		Robozart.DosBeeps();
		Robozart.Tocar("x");
	}
	
	public static void Padrino() {
		Cancion c = new Cancion("El Padrino");
		Robozart.TocarNotas(c.notasCancion);
	}

	public static void Escala() {
		Cancion c = new Cancion("Escala");
		Robozart.TocarNotas(c.notasCancion);
	}
	
	public static void Himno() {
		Cancion c = new Cancion("Himno");
		Robozart.TocarNotas(c.notasCancion);
	}

}
