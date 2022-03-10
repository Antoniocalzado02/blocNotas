package Main;

import java.util.Scanner;

import BlockDeNotas.Nota;
import BlockDeNotas.NotaAlarma;
import BlockDeNotas.NotaAlarmaExcep;

public class MainAppBloc {
	Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		Nota[] bloc=new Nota[5];
		for(int i=0;i<bloc.length;i++){
		bloc[i]= crearNota();
		}
		Nota n1= new Nota("Alberto");
		
		Nota n2= new Nota("Alberto");
		System.out.println(n1.equals(n2));
		try {
			NotaAlarma notaAlarma=null;
		}catch(Exception e){
			throw new NotaAlarmaExcep("Se ha producido un error", e, false, false);
		}
		
		System.out.println(bloc);

	}

	private static Nota crearNota() {
		System.out.println("Introduce un mensaje para la nota: ");
		String texto= new Scanner(System.in).nextLine();
		return new Nota(texto);
	}
	
	

	
	

}
