package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import entities.Contract;
import entities.Worker;
import entities.enums.Departament;
import entities.enums.WorkerLevel;
public class Test {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		DateTimeFormatter formatoDataReal = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Bem vindo ao teste de aplicação.\n");
		Worker worker = createWorker();
		System.out.println("Quantos contratos você quer adicionar?");
		int n = scan.nextInt();
		
		
		for(int i = 0; i<n; i++) {
			
			System.out.println("\n\n\n--------------------------------------");
			
			System.out.printf("\nContrato #%d de #%d", i+1, n);
			System.out.println("\nData [dd/MM/yyyy]: ");
			
			LocalDate date = LocalDate.parse(scan.next(), formatoDataReal);
			
			System.out.println("Valor da Hora: ");
			double valor = scan.nextDouble();
			
			System.out.println("Horas trabalhadas: ");
			double horas = scan.nextDouble();
			
			worker.addContract(new Contract(date, valor, horas));
		}
		
		System.out.println("\n\nDigite a data para ver o income (mm/YYYY): ");
		String inputDate = scan.next();
		
		int inputMonth = Integer.parseInt(inputDate.substring(0, 2));
		int inputYear = Integer.parseInt(inputDate.substring(3));
		
		double income = worker.getIncome(inputYear, inputMonth);
		
		System.out.printf("Salario em %d/%d: R$ %.2f", inputMonth, inputYear, income);
	}
	
	private static Worker createWorker() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Nome do trabalhador: ");
		String nome = scan.next();
		
		System.out.println("Salario Base: ");
		double baseSalary = scan.nextDouble();
		
		System.out.println("Qual nivel do trabalhador? (");
		System.out.println(Arrays.toString(WorkerLevel.values()) + "): ");
		
		WorkerLevel level = WorkerLevel.valueOf(scan.next());
		scan.nextLine();
		
		System.out.println("A qual departamento ele pertence? (");
		System.out.println(Arrays.toString(Departament.values()) + "): ");
		Departament departament = Departament.valueOf(scan.next());
		
		
		return new Worker(nome, baseSalary, level, departament);
	}
	
}
 