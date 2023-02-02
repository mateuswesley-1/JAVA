package entities;
import java.util.ArrayList;

import entities.enums.Departament;
import entities.enums.WorkerLevel;

public class Worker{
	
	private String name;
	private double baseSalary;
	private WorkerLevel level;
	private Departament departament;
	private ArrayList<Contract> allContracts = new ArrayList <Contract>();
	
	// criar valores padroes [e boa pratica
	public  Worker(){
		name = "new worker";
		baseSalary = 1300;
		level = WorkerLevel.JUNIOR;
		departament = Departament.IT;
	}

	
	public Worker(String name, double baseSalary, WorkerLevel level, Departament departament) {
		this.name = name;
		this.baseSalary = baseSalary;
		this.level = level;
		this.departament = departament;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public WorkerLevel getWorkerLevel() {
		return this.level;
	}
	public void setWorkerLevel(WorkerLevel level) {
		this.level = level;
	}
	
	public double getBaseSalary() {
		return this.baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public Departament getDepartament() {
		return this.departament;
		}
	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
	
	public ArrayList<Contract> getContracts(){
		return this.allContracts;
	}
	
	public void addContract(Contract contract) {
		this.allContracts.add(contract);
	}
	
	public void removeContract(Contract contract) {
		this.allContracts.remove(contract);
	}
	
	public double getIncome(int inputYear, int inputMonth) {

		double income = 0;
		double salary = getBaseSalary();
		ArrayList <Contract> contratos = getContracts();
		
		for(int i = 0; i<contratos.size(); i++) {
			// para cada contrato pegamos o mes e o ano do contrato
			int contractYear = contratos.get(i).getDate().getYear();
			int contractMonth = contratos.get(i).getDate().getMonthValue();
			
			if(contractYear == inputYear && contractMonth == inputMonth) {
				income += (contratos.get(i).totalValue() + salary);
			}
		}
		return income;
	}
}
