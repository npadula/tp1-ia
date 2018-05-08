package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Grafo {
	HashMap<Nodo,ArrayList<Transicion>> transiciones;
	HashMap<String,Nodo> nodos;
	int nodeSize = 25; //Tamaño del nodo en px
	
	
	public Grafo(){
		nodos = new HashMap<String,Nodo>();
		transiciones = new HashMap<Nodo,ArrayList<Transicion>>();
		
		crearNodos();
		crearTransiciones();
		crearParedes();
		
		
		for (Map.Entry<String, Nodo> entry : nodos.entrySet()) {
		    //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
		}
		
	}
	
	
	
	private void paredEntre(String idOrigen, String idDestino){
		Nodo origen = nodos.get(idOrigen);
		Nodo destino = nodos.get(idDestino);
		
		ArrayList<Transicion> transicionesDeOrigen = transiciones.get(origen);
		
		for(int i = 0; i < transicionesDeOrigen.size(); i++){
			Transicion t = transicionesDeOrigen.get(i);
			
			if(t.destino == destino){
				transicionesDeOrigen.remove(t);
				break;
			}
		}
		
		ArrayList<Transicion> transicionesDeDestino = transiciones.get(destino);
		
		for(int i = 0; i < transicionesDeDestino.size(); i++){
			Transicion t = transicionesDeDestino.get(i);
			
			if(t.destino == origen){
				transicionesDeDestino.remove(t);
				break;
			}
		}
		
		
	}
	
	private void crearParedes(){
		paredEntre("C2","C3");
		
		
		paredEntre("B3","C3");
		paredEntre("B4","C4");
		paredEntre("B5","C5");
		paredEntre("B6","C6");
		paredEntre("B7","C7");
		paredEntre("B8","C8");
		paredEntre("B9","C9");
		paredEntre("B10","C10");
		paredEntre("B11","C11");
		paredEntre("B12","C12");
		paredEntre("B13","C13");
		paredEntre("B14","C14");
		paredEntre("B15","C15");
		paredEntre("B16","C16");
		paredEntre("B17","C17");
		paredEntre("B18","C18");
		paredEntre("B19","C19");
		paredEntre("B20","C20");
		paredEntre("B21","C21");
		paredEntre("B22","C22");
		paredEntre("B23","C23");
		paredEntre("B24","C24");
		paredEntre("B25","C25");
		paredEntre("B26","C26");
		paredEntre("B27","C27");

		paredEntre("F28","G28");
		paredEntre("F29","G29");
		paredEntre("F30","G30");
		paredEntre("F31","G31");


		paredEntre("F2","F3");
		paredEntre("G2","G3");
		paredEntre("H2","H3");
		paredEntre("I2","I3");
		paredEntre("J2","J3");
		paredEntre("K2","K3");
		paredEntre("L2","L3");
		paredEntre("M2","M3");
		paredEntre("N2","N3");
		paredEntre("O2","O3");
		paredEntre("P2","P3");
		paredEntre("Q2","Q3");
		paredEntre("R2","R3");
		paredEntre("S2","S3");
		paredEntre("T2","T3");



		paredEntre("U4","U5");
		paredEntre("V4","V5");
		paredEntre("W4","W5");
		paredEntre("X4","X5");
		paredEntre("Y4","Y5");



		paredEntre("Y5","Z5");
		paredEntre("Y6","Z6");
		paredEntre("Y7","Z7");
		paredEntre("Y8","Z8");
		paredEntre("Y9","Z9");
		paredEntre("Y10","Z10");
		paredEntre("Y11","Z11");
		paredEntre("Y12","Z12");

		paredEntre("X13","Y13");
		paredEntre("X14","Y14");
		paredEntre("X15","Y15");
		paredEntre("X16","Y16");


		paredEntre("Y17","Z17");
		paredEntre("Y18","Z18");
		paredEntre("Y19","Z19");
		paredEntre("Y20","Z20");



		paredEntre("X21","Y21");
		paredEntre("X22","Y22");
		paredEntre("X23","Y23");


		paredEntre("Y24","Z24");
		paredEntre("Y25","Z25");
		paredEntre("Y26","Z26");
		paredEntre("Y27","Z27");
		paredEntre("Y28","Z28");
		paredEntre("Y29","Z29");
		paredEntre("Y30","Z30");
		paredEntre("Y31","Z31");


		paredEntre("G31","G32");
		paredEntre("H31","H32");
		paredEntre("I31","I32");
		paredEntre("J31","J32");
		paredEntre("K31","K32");
		paredEntre("L31","L32");
		paredEntre("M31","M32");
		paredEntre("N31","N32");
		paredEntre("O31","O32");
		paredEntre("P31","P32");
		paredEntre("Q31","Q32");
		paredEntre("R31","R32");
		paredEntre("S31","S32");
		paredEntre("T31","T32");
		paredEntre("U31","U32");
		paredEntre("V31","V32");
		paredEntre("W31","W32");
		paredEntre("X31","X32");
		paredEntre("Y31","Y32");


		paredEntre("F28","G28");
		paredEntre("F29","G29");
		paredEntre("F30","G30");
		paredEntre("F31","G31");
		

		paredEntre("T4","U4");
		paredEntre("T5","U5");
		paredEntre("T6","U6");
		paredEntre("T7","U7");
		paredEntre("T9","U9");
		paredEntre("T10","U10");
		paredEntre("T11","U11");
		paredEntre("T13","U13");
		paredEntre("T14","U14");
		paredEntre("T15","U15");
		paredEntre("T18","U18");
		paredEntre("T19","U19");
		paredEntre("T20","U20");
		paredEntre("T22","U22");
		paredEntre("T23","U23");

		paredEntre("U8","U9");
		paredEntre("V8","V9");
		paredEntre("W8","W9");
		paredEntre("X8","X9");
		paredEntre("Y8","Y9");


		paredEntre("U12","U13");
		paredEntre("V12","V13");
		paredEntre("W12","W13");
		paredEntre("X12","X13");

		paredEntre("U16","U17");
		paredEntre("V16","V17");
		paredEntre("W16","W17");
		paredEntre("X16","X17");

		paredEntre("U23","U24");
		paredEntre("V23","V24");
		paredEntre("W23","W24");
		paredEntre("X23","X24");

		paredEntre("C27","C28");
		paredEntre("D27","D28");
		paredEntre("E27","E28");
		paredEntre("F27","F28");

		paredEntre("U3","U3");
		paredEntre("V4","V4");

		paredEntre("Y12","Y13");
		paredEntre("Y16","Y17");
		paredEntre("Y20","Y21");
		paredEntre("Y23","Y24");

		paredEntre("L3","M3");
		paredEntre("L4","M4");
		paredEntre("L5","M5");
		paredEntre("L6","M6");
		paredEntre("L7","M7");
		paredEntre("L8","M8");

		paredEntre("G8","G9");
		paredEntre("H8","H9");
		paredEntre("I8","I9");
		paredEntre("J8","J9");
		paredEntre("K8","K9");
		paredEntre("L8","L9");
		paredEntre("M8","M9");
		paredEntre("N8","N9");
		paredEntre("O8","O9");
		paredEntre("P8","P9");
		paredEntre("Q8","Q9");


		paredEntre("F9","G9");
		paredEntre("F10","G10");
		paredEntre("F11","G11");
		paredEntre("F12","G12");
		paredEntre("F13","G13");
		paredEntre("F14","G14");
		paredEntre("F15","G15");
		paredEntre("F16","G16");
		paredEntre("F17","G17");
		paredEntre("F18","G18");
		paredEntre("F19","G19");
		paredEntre("F21","G21");
		paredEntre("F22","G22");
		paredEntre("F23","G23");

		paredEntre("Q9","R9");
		paredEntre("Q10","R10");
		paredEntre("Q11","R11");
		paredEntre("Q12","R12");
		paredEntre("Q13","R13");
		paredEntre("Q14","R14");
		paredEntre("Q15","R15");
		paredEntre("Q16","R16");
		paredEntre("Q17","R17");
		paredEntre("Q19","R19");
		paredEntre("Q20","R20");
		paredEntre("Q21","R21");
		paredEntre("Q22","R22");
		paredEntre("Q23","R23");


		paredEntre("C14","C15");
		paredEntre("D14","D15");
		paredEntre("E14","E15");
		paredEntre("F14","F15");
		paredEntre("I14","I15");
		paredEntre("J14","J15");
		paredEntre("K14","K15");
		paredEntre("L14","L15");
		paredEntre("M14","M15");
		paredEntre("N14","N15");
		paredEntre("O14","O15");
		paredEntre("P14","P15");
		paredEntre("Q14","R15");

		paredEntre("S8","S9");
		paredEntre("T8","T9");


		paredEntre("C23","C24");
		paredEntre("D23","D24");
		paredEntre("E23","E24");
		paredEntre("F23","G24");
		paredEntre("K23","K24");
		paredEntre("L23","L24");
		paredEntre("M23","M24");
		paredEntre("N23","N24");
		paredEntre("O23","O24");
		paredEntre("P23","P24");
		paredEntre("Q23","Q24");
		paredEntre("S23","S24");
		paredEntre("T23","T24");


		paredEntre("N24","O24");
		paredEntre("N25","O25");
		paredEntre("N26","O26");
		paredEntre("N27","O27");
		paredEntre("N28","O28");
		paredEntre("N29","O29");
		paredEntre("N30","O30");
		paredEntre("N31","O31");


		paredEntre("J24","K24");
		paredEntre("J25","K25");
		paredEntre("J26","K26");
		paredEntre("J28","K28");
		paredEntre("J29","K29");
		paredEntre("J30","K30");
		paredEntre("J31","K31");

		paredEntre("K26","K27");
		paredEntre("L26","L27");
		paredEntre("N26","N27");

		paredEntre("G27","G28");
		paredEntre("H27","H28");
		paredEntre("I27","I28");



	}
	
	private String generarLetra(int num){
		String letra = "";
		int codigoLetra = 64 + num;
		if(num > 26){
			codigoLetra -= 26;
			letra = "A" + Character.toString ((char) codigoLetra);
			
		}
		else
			letra = Character.toString ((char) codigoLetra);
		
		return letra;
	}
	
	
	private void crearNodos(){
		
		for(int col = 1; col <= 27; col++){
			String letra = generarLetra(col);
			
			for(int fila = 1; fila<= 33; fila++){
				String idNodo = letra + Integer.toString(fila);
				
				int posX = nodeSize * (col - 1);
				int posY = nodeSize * fila;
				
				System.out.print(idNodo);
				 nodos.put(idNodo,new Nodo(idNodo,posX,posY));
				
			}
		}
		
	}
	
	
	private void crearTransicion(Nodo origen, Nodo destino){
		Transicion t = new Transicion(origen,destino,1); 
		ArrayList<Transicion> salientes;
		if (!transiciones.containsKey(origen)) {
			 salientes = new ArrayList<Transicion>();
			 salientes.add(t);
			 transiciones.put(origen, salientes);
			 
		 }
		else {
			salientes = transiciones.get(origen);
			salientes.add(t);
		}
	}
	
	private void crearTransiciones(){
		
		String letraAnterior ="";
		
		for(int col = 1; col <= 27; col++){
			String letra = generarLetra(col);
			
			for(int fila = 1; fila<= 33; fila++){
				
				String idNodoActual = letra + Integer.toString(fila);
				String idNodoSuperior = letra + Integer.toString(fila-1);
				String idNodoIzq = letraAnterior + Integer.toString(fila);
				
				Nodo nodoActual = nodos.get(idNodoActual);
				
				if ((fila-1) >= 1) {			 
					 Nodo nodoSuperior= nodos.get(idNodoSuperior);
					 crearTransicion(nodoActual,nodoSuperior);
					 crearTransicion(nodoSuperior,nodoActual);
					
				}
				if((col - 1) >= 1 ){
					Nodo nodoIzquierda= nodos.get(idNodoIzq);
					crearTransicion(nodoActual,nodoIzquierda);
					crearTransicion(nodoIzquierda,nodoActual);
				}
				
				
				
			}
		
			letraAnterior = letra;
			
		}
		
		 
		

		
	}
	
	
}
