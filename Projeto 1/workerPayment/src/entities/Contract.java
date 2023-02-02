package entities;

import java.time.LocalDate;

public class Contract {
	private LocalDate date;
	private double valueHour;
	private double hours;
	
	public Contract(){
		
	}
	
	public Contract(LocalDate date, double valueHour, double hours) {
		this.date = date;
		this.valueHour = valueHour;
		this.hours = hours;
	}
	
	public LocalDate getDate() {return this.date;}
	public double getValueHour(){return this.valueHour;}
	public double getHours(){return this.hours;}
	
	// Delegacao a unica classe que tem que saber o valor do contrato
	// e a propria classe contrato
	public double totalValue() {
		return valueHour*hours;
	}
}
