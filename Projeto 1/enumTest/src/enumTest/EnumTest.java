package enumTest;

import enums.Day;

public class EnumTest {
	Day day;
	
	// Constructor
	public EnumTest(Day day) {
		this.day = day;
	}
	
	// Metodo que recebe o campo day, da 
	// instancia do teste
	public void tellIt() {
		switch (this.day) {
		case MONDAY:
			System.out.println("Legal segunda feira");
			break;
		case FRIDAY:
			System.out.println("Sexta feira rotineira");
			break;
		case SATURDAY: case SUNDAY:
			System.out.println("FDS rapazeada");
			break;
		default:
			System.out.println("Sinceramnete to nem ai");
			break;
		}
	}
	
	public static void main(String[] args) {
		// CRIA um objeto do tipo enumtest, que e uma classe
		// que o unico atributo e uma variavel do tipo Day
		// que recebe valores limitados.
		EnumTest firstDay = new EnumTest(Day.MONDAY);
		firstDay.tellIt();
	}
}

