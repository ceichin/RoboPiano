
public class Cancion {
	
	public String[] notasCancion;
    
	private int contador = 0;
	
	public Cancion(String cancion) {
		this.cargarCancion(cancion); 
	}
	
	public void resetearCancion() {
		contador = 0;
	}
	
	public String proximaNota() {
		return notasCancion[contador++ % notasCancion.length];
	}
	
	public void cargarCancion(String nombre) {
			
		switch (nombre) {
		
			case "Escala":
				notasCancion = new String[] {
	                "c", "d", "e", "f", "g", "a", "b", "C",
	                "C", "b", "a", "g", "f", "e", "d", "c"
	            };
				break;
			
			case "Senor de los Anillos":
				notasCancion = new String[] {
	                "c", "d", "e", "g", "e", "d", "c"
	            };
				break;
				
			case "El Padrino":
				notasCancion = new String[] {
	                "es", "a", "C", "b", "a", "C", "a", "b", "a", "f", "g", "es",
					"es", "a", "C", "b", "a", "C", "a", "b", "a", "f", "e", "ds",
					"d", "f", "a", "bs", "c", "e", "g", "a"
	            };
				break;
				  
			case "Himno":
				notasCancion = new String[] {
	                "e", "e", "e", "c", "a", "g", "e", "b", "a", "as",
	                "C", "C", "C", "b", "a", "g", "a", "g", "fs",
	                "e", "e", "e", "c", "a", "g", "e", "b", "a", "as",
	                "C", "C", "C", "b", "a", "g", "a", "g", "fs"
	            };
				break;
			
			case "Mary had a little lamp":
				notasCancion = new String[] {
	                "e", "d", "c", "d", "e", "e", "e",
	                "d", "d", "d", "e", "e", "e", "e",
	                "e", "d", "c", "d", "e", "e", "e",
	                "e", "d", "d", "e", "d", "c"
	            };
				break;
				
	                
			case "One Love":
				notasCancion = new String[] {
	                "e", "es", "d", "ds",
	                "f", "e", "d", "c", "d", "c", " ", "e", "d", "c"
	            };
				break;
				
	                
			case "Old Macdonald":
				notasCancion = new String[] {
	                "c", "c", "c", "g", "a", "a", "g",
	                "e", "e", "d", "d", "c",
	                "g", "c", "c", "c", "g", "a", "a", "g",
	                "e", "e", "d", "d", "c",
	                "g", "g", "c", "c", "c",
	                "g", "g", "c", "c", "c",
	                "c", "c", "c", "c", "c", "c",
	                "c", "c", "c", "c", "c", "c", "c",
	                "c", "c", "c", "g", "a", "a", "g",
	                "e", "e", "d", "d", "c"
	            };
				break;
				
			case "Amazing Grace":
				notasCancion = new String[] {
	                "g", "c", "e", "c", "e", "d", "c", "a", "g",
	                "g", "c", "e", "c", "e", "d", "g",
	                "e", "g", "e", "c", "g", "a", "c", "a", "g",
	                "g", "c", "e", "c", "e", "d", "c"
	            };
				break;

			default:
				break;
		}
	}
	
	
}
