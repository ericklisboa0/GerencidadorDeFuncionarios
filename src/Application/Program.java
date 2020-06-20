package Application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Entities.Departament;
import Entities.HourContract;
import Entities.Worker;
import Entities.Enum.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		SimpleDateFormat var = new SimpleDateFormat("dd/MM/yyyy"); 
		Scanner sc = new Scanner(System.in);
		System.out.print("Qual é o setor: ");
		String departament = sc.nextLine();
		
		Departament departamento = new Departament (departament);
		
		System.out.println("Entre com os dados do Funcionario");
		System.out.print("nome: ");
		String nome = sc.nextLine();
		String nivel;
		do {
			System.out.print("Nível: ");
			nivel = sc.nextLine();
		}while(! nivel.equals("JUNIOR") && ! nivel.equals("PLENO") && ! nivel.equals("SENIOR"));
			
		System.out.print("Salário base: ");
		Double SalarioBase = sc.nextDouble();
		
		Worker funcionario = new Worker (nome, WorkerLevel.valueOf(nivel), SalarioBase, departamento);
		
		System.out.println("Quantos contratos o funcionario possui?");
		Integer n = sc.nextInt();
		
		for(int i = 0; i<n; i++) {
			System.out.printf("Dados do Contrato %d \n", i+1);
			System.out.print("Data do Contrato: ");
			Date data = var.parse(sc.next());
			System.out.print("Valor recebido por hora: ");
			Double ValorHora = sc.nextDouble();
			System.out.println("horas trabalhadas: ");
			Integer horas = sc.nextInt();
			
			HourContract contrato = new HourContract(data, ValorHora, horas);
			
			funcionario.AddContract(contrato);
			
		}
		
		System.out.println();
		System.out.print("Mês e ano dos contratos desejados: ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome : " + funcionario.getName());
		System.out.println("Setor : " + funcionario.getDepartament().getName());
		System.out.println("Renda de: " + monthAndYear + ": " + String.format("%.2f", funcionario.income(year, month)));
		
		sc.close();
	}

}
