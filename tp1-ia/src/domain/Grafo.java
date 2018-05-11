package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Grafo {
	public HashMap<String,ArrayList<Transicion>> transiciones;
	public HashMap<String,Nodo> nodos;
	public int nodeSize = 25; //Tamaño del nodo en px
	
	
	public Grafo(){
		nodos = new HashMap<String,Nodo>();
		transiciones = new HashMap<String,ArrayList<Transicion>>();
		
		//System.out.println("Creando nodos");
		crearNodos();
		//System.out.println("Creando transiciones");
		crearTransiciones();
		//System.out.println("Creando paredes");
		crearParedes();
		
	
	}
	
	
	private void modificarCosto(String idOrigen, String idDestino, int nuevoCosto, boolean bidireccional){
		Nodo origen = nodos.get(idOrigen);
		Nodo destino = nodos.get(idDestino);
		ArrayList<Transicion> transOrigen = transiciones.get(origen.Id);
		ArrayList<Transicion> transDestino = transiciones.get(destino.Id);
		
		
		for(Transicion t : transOrigen){
			if(t.destino == destino){
				t.costo = nuevoCosto;
				break;
			}
		}
		
		if(bidireccional){
			for(Transicion t : transDestino){
				if(t.destino == origen){
					t.costo = nuevoCosto;
					break;
				}
			}
		}
		
		
		
	}
	
	
	public void crearTerrenos(){
		//Modifica costos de transiciones para representar cambios en los terrenos
		
		//Pasto IZQ
		
		modificarCosto("A1","B1",20,true);
		modificarCosto("A2","B2",20,true);
		modificarCosto("A3","B3",20,true);
		modificarCosto("A4","B4",20,true);
		modificarCosto("A5","B5",20,true);
		modificarCosto("A6","B6",20,true);
		modificarCosto("A7","B7",20,true);
		modificarCosto("A8","B8",20,true);
		modificarCosto("A9","B9",20,true);
		modificarCosto("A10","B10",20,true);
		modificarCosto("A11","B11",20,true);
		modificarCosto("A12","B12",20,true);
		modificarCosto("A13","B13",20,true);
		modificarCosto("A14","B14",20,true);
		modificarCosto("A15","B15",20,true);
		modificarCosto("A16","B16",20,true);
		modificarCosto("A17","B17",20,true);
		modificarCosto("A18","B18",20,true);
		modificarCosto("A19","B19",20,true);
		modificarCosto("A20","B20",20,true);
		modificarCosto("A21","B21",20,true);
		modificarCosto("A22","B22",20,true);
		modificarCosto("A23","B23",20,true);
		modificarCosto("A24","B24",20,true);
		modificarCosto("A25","B25",20,true);
		modificarCosto("A26","B26",20,true);
		modificarCosto("A27","B27",20,true);
		modificarCosto("A28","B28",20,true);
		modificarCosto("A29","B29",20,true);
		modificarCosto("A30","B30",20,true);
		modificarCosto("A31","B31",20,true);
		modificarCosto("A32","B32",20,true);
		modificarCosto("A33","B33",20,true);
		
		
		modificarCosto("A2","A1",20,true);
		modificarCosto("A3","A2",20,true);
		modificarCosto("A4","A3",20,true);
		modificarCosto("A5","A4",20,true);
		modificarCosto("A6","A5",20,true);
		modificarCosto("A7","A6",20,true);
		modificarCosto("A8","A7",20,true);
		modificarCosto("A9","A8",20,true);
		modificarCosto("A10","A9",20,true);
		modificarCosto("A11","A10",20,true);
		modificarCosto("A12","A11",20,true);
		modificarCosto("A13","A12",20,true);
		modificarCosto("A14","A13",20,true);
		modificarCosto("A15","A14",20,true);
		modificarCosto("A16","A15",20,true);
		modificarCosto("A17","A16",20,true);
		modificarCosto("A18","A17",20,true);
		modificarCosto("A19","A18",20,true);
		modificarCosto("A20","A19",20,true);
		modificarCosto("A21","A20",20,true);
		modificarCosto("A22","A21",20,true);
		modificarCosto("A23","A22",20,true);
		modificarCosto("A24","A23",20,true);
		modificarCosto("A25","A24",20,true);
		modificarCosto("A26","A25",20,true);
		modificarCosto("A27","A26",20,true);
		modificarCosto("A28","A27",20,true);
		modificarCosto("A29","A28",20,true);
		modificarCosto("A30","A29",20,true);
		modificarCosto("A31","A30",20,true);
		modificarCosto("A32","A31",20,true);
		modificarCosto("A33","A32",20,true);
		
		
		modificarCosto("B2","B1",20,true);
		modificarCosto("B3","B2",20,true);
		modificarCosto("B4","B3",20,true);
		modificarCosto("B5","B4",20,true);
		modificarCosto("B6","B5",20,true);
		modificarCosto("B7","B6",20,true);
		modificarCosto("B8","B7",20,true);
		modificarCosto("B9","B8",20,true);
		modificarCosto("B10","B9",20,true);
		modificarCosto("B11","B10",20,true);
		modificarCosto("B12","B11",20,true);
		modificarCosto("B13","B12",20,true);
		modificarCosto("B14","B13",20,true);
		modificarCosto("B15","B14",20,true);
		modificarCosto("B16","B15",20,true);
		modificarCosto("B17","B16",20,true);
		modificarCosto("B18","B17",20,true);
		modificarCosto("B19","B18",20,true);
		modificarCosto("B20","B19",20,true);
		modificarCosto("B21","B20",20,true);
		modificarCosto("B22","B21",20,true);
		modificarCosto("B23","B22",20,true);
		modificarCosto("B24","B23",20,true);
		modificarCosto("B25","B24",20,true);
		modificarCosto("B26","B25",20,true);
		modificarCosto("B27","B26",20,true);
		modificarCosto("B28","B27",20,true);
		modificarCosto("B29","B28",20,true);
		modificarCosto("B30","B29",20,true);
		modificarCosto("B31","B30",20,true);
		modificarCosto("B32","B31",20,true);
		modificarCosto("B33","B32",20,true);
		
		
		
		//Pasto DER
		modificarCosto("Z1","AA1",20,true);
		modificarCosto("Z2","AA2",20,true);
		modificarCosto("Z3","AA3",20,true);
		modificarCosto("Z4","AA4",20,true);
		modificarCosto("Z5","AA5",20,true);
		modificarCosto("Z6","AA6",20,true);
		modificarCosto("Z7","AA7",20,true);
		modificarCosto("Z8","AA8",20,true);
		modificarCosto("Z9","AA9",20,true);
		modificarCosto("Z10","AA10",20,true);
		modificarCosto("Z11","AA11",20,true);
		modificarCosto("Z12","AA12",20,true);
		modificarCosto("Z13","AA13",20,true);
		modificarCosto("Z14","AA14",20,true);
		modificarCosto("Z15","AA15",20,true);
		modificarCosto("Z16","AA16",20,true);
		modificarCosto("Z17","AA17",20,true);
		modificarCosto("Z18","AA18",20,true);
		modificarCosto("Z19","AA19",20,true);
		modificarCosto("Z20","AA20",20,true);
		modificarCosto("Z21","AA21",20,true);
		modificarCosto("Z22","AA22",20,true);
		modificarCosto("Z23","AA23",20,true);
		modificarCosto("Z24","AA24",20,true);
		modificarCosto("Z25","AA25",20,true);
		modificarCosto("Z26","AA26",20,true);
		modificarCosto("Z27","AA27",20,true);
		modificarCosto("Z28","AA28",20,true);
		modificarCosto("Z29","AA29",20,true);
		modificarCosto("Z30","AA30",20,true);
		modificarCosto("Z31","AA31",20,true);
		modificarCosto("Z32","AA32",20,true);
		modificarCosto("Z33","AA33",20,true);
		
		
		
		modificarCosto("Z2","Z1",20,true);
		modificarCosto("Z3","Z2",20,true);
		modificarCosto("Z4","Z3",20,true);
		modificarCosto("Z5","Z4",20,true);
		modificarCosto("Z6","Z5",20,true);
		modificarCosto("Z7","Z6",20,true);
		modificarCosto("Z8","Z7",20,true);
		modificarCosto("Z9","Z8",20,true);
		modificarCosto("Z10","Z9",20,true);
		modificarCosto("Z11","Z10",20,true);
		modificarCosto("Z12","Z11",20,true);
		modificarCosto("Z13","Z12",20,true);
		modificarCosto("Z14","Z13",20,true);
		modificarCosto("Z15","Z14",20,true);
		modificarCosto("Z16","Z15",20,true);
		modificarCosto("Z17","Z16",20,true);
		modificarCosto("Z18","Z17",20,true);
		modificarCosto("Z19","Z18",20,true);
		modificarCosto("Z20","Z19",20,true);
		modificarCosto("Z21","Z20",20,true);
		modificarCosto("Z22","Z21",20,true);
		modificarCosto("Z23","Z22",20,true);
		modificarCosto("Z24","Z23",20,true);
		modificarCosto("Z25","Z24",20,true);
		modificarCosto("Z26","Z25",20,true);
		modificarCosto("Z27","Z26",20,true);
		modificarCosto("Z28","Z27",20,true);
		modificarCosto("Z29","Z28",20,true);
		modificarCosto("Z30","Z29",20,true);
		modificarCosto("Z31","Z30",20,true);
		modificarCosto("Z32","Z31",20,true);
		modificarCosto("Z33","Z32",20,true);
		
		
		modificarCosto("AA2","AA1",20,true);
		modificarCosto("AA3","AA2",20,true);
		modificarCosto("AA4","AA3",20,true);
		modificarCosto("AA5","AA4",20,true);
		modificarCosto("AA6","AA5",20,true);
		modificarCosto("AA7","AA6",20,true);
		modificarCosto("AA8","AA7",20,true);
		modificarCosto("AA9","AA8",20,true);
		modificarCosto("AA10","AA9",20,true);
		modificarCosto("AA11","AA10",20,true);
		modificarCosto("AA12","AA11",20,true);
		modificarCosto("AA13","AA12",20,true);
		modificarCosto("AA14","AA13",20,true);
		modificarCosto("AA15","AA14",20,true);
		modificarCosto("AA16","AA15",20,true);
		modificarCosto("AA17","AA16",20,true);
		modificarCosto("AA18","AA17",20,true);
		modificarCosto("AA19","AA18",20,true);
		modificarCosto("AA20","AA19",20,true);
		modificarCosto("AA21","AA20",20,true);
		modificarCosto("AA22","AA21",20,true);
		modificarCosto("AA23","AA22",20,true);
		modificarCosto("AA24","AA23",20,true);
		modificarCosto("AA25","AA24",20,true);
		modificarCosto("AA26","AA25",20,true);
		modificarCosto("AA27","AA26",20,true);
		modificarCosto("AA28","AA27",20,true);
		modificarCosto("AA29","AA28",20,true);
		modificarCosto("AA30","AA29",20,true);
		modificarCosto("AA31","AA30",20,true);
		modificarCosto("AA32","AA31",20,true);
		modificarCosto("AA33","AA32",20,true);
		
		
		
	}
	
	
	private void paredEntre(String idOrigen, String idDestino){
		//Las paredes impiden el paso entre un nodo y otro, por lo cual se implementa borrando las transiciones entre dichos nodos
		Nodo origen = nodos.get(idOrigen);
		Nodo destino = nodos.get(idDestino);
		
		ArrayList<Transicion> transicionesDeOrigen = transiciones.get(origen.Id);
		
		for(int i = 0; i < transicionesDeOrigen.size(); i++){
			Transicion t = transicionesDeOrigen.get(i);
			
			if(t.destino == destino){
				transicionesDeOrigen.remove(t);
				break;
			}
		}
		
		ArrayList<Transicion> transicionesDeDestino = transiciones.get(destino.Id);
		
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
		
		
		//Pasto Arriba
		
		modificarCosto("B1","C1",20,true);
		modificarCosto("C1","D1",20,true);
		modificarCosto("D1","E1",20,true);
		modificarCosto("E1","F1",20,true);
		modificarCosto("F1","G1",20,true);
		modificarCosto("G1","H1",20,true);
		modificarCosto("H1","I1",20,true);
		modificarCosto("I1","J1",20,true);
		modificarCosto("J1","K1",20,true);
		modificarCosto("K1","L1",20,true);
		modificarCosto("L1","M1",20,true);
		modificarCosto("M1","N1",20,true);
		modificarCosto("N1","O1",20,true);
		modificarCosto("O1","P1",20,true);
		modificarCosto("P1","Q1",20,true);
		modificarCosto("Q1","R1",20,true);
		modificarCosto("R1","S1",20,true);
		modificarCosto("S1","T1",20,true);
		modificarCosto("T1","U1",20,true);
		modificarCosto("U1","V1",20,true);
		modificarCosto("V1","W1",20,true);
		modificarCosto("W1","X1",20,true);
		modificarCosto("X1","Y1",20,true);
		modificarCosto("Y1","Z1",20,true);
		modificarCosto("Z1","AA1",20,true);
		
		
		modificarCosto("B2","C2",20,true);
		modificarCosto("F2","G2",20,true);
		modificarCosto("G2","H2",20,true);
		modificarCosto("H2","I2",20,true);
		modificarCosto("I2","J2",20,true);
		modificarCosto("J2","K2",20,true);
		modificarCosto("K2","L2",20,true);
		modificarCosto("L2","M2",20,true);
		modificarCosto("M2","N2",20,true);
		modificarCosto("N2","O2",20,true);
		modificarCosto("O2","P2",20,true);
		modificarCosto("P2","Q2",20,true);
		modificarCosto("Q2","R2",20,true);
		modificarCosto("R2","S2",20,true);
		modificarCosto("S2","T2",20,true);
		modificarCosto("T2","U2",20,true);
		modificarCosto("U2","V2",20,true);
		modificarCosto("V2","W2",20,true);
		modificarCosto("W2","X2",20,true);
		modificarCosto("X2","Y2",20,true);
		modificarCosto("Y2","Z2",20,true);
		modificarCosto("Z2","AA2",20,true);

		
		
		
		//Pasto abajo
		modificarCosto("B32","C32",20,true);
		modificarCosto("C32","D32",20,true);
		modificarCosto("D32","E32",20,true);
		modificarCosto("E32","F32",20,true);
		modificarCosto("F32","G32",20,true);
		modificarCosto("G32","H32",20,true);
		modificarCosto("H32","I32",20,true);
		modificarCosto("I32","J32",20,true);
		modificarCosto("J32","K32",20,true);
		modificarCosto("K32","L32",20,true);
		modificarCosto("L32","M32",20,true);
		modificarCosto("M32","N32",20,true);
		modificarCosto("N32","O32",20,true);
		modificarCosto("O32","P32",20,true);
		modificarCosto("P32","Q32",20,true);
		modificarCosto("Q32","R32",20,true);
		modificarCosto("R32","S32",20,true);
		modificarCosto("S32","T32",20,true);
		modificarCosto("T32","U32",20,true);
		modificarCosto("U32","V32",20,true);
		modificarCosto("V32","W32",20,true);
		modificarCosto("W32","X32",20,true);
		modificarCosto("X32","Y32",20,true);
		modificarCosto("Y32","Z32",20,true);
		modificarCosto("Z32","AA32",20,true);
		
		
		modificarCosto("B33","C33",20,true);
		modificarCosto("C33","D33",20,true);
		modificarCosto("D33","E33",20,true);
		modificarCosto("E33","F33",20,true);
		modificarCosto("F33","G33",20,true);
		modificarCosto("G33","H33",20,true);
		modificarCosto("H33","I33",20,true);
		modificarCosto("I33","J33",20,true);
		modificarCosto("J33","K33",20,true);
		modificarCosto("K33","L33",20,true);
		modificarCosto("L33","M33",20,true);
		modificarCosto("M33","N33",20,true);
		modificarCosto("N33","O33",20,true);
		modificarCosto("O33","P33",20,true);
		modificarCosto("P33","Q33",20,true);
		modificarCosto("Q33","R33",20,true);
		modificarCosto("R33","S33",20,true);
		modificarCosto("S33","T33",20,true);
		modificarCosto("T33","U33",20,true);
		modificarCosto("U33","V33",20,true);
		modificarCosto("V33","W33",20,true);
		modificarCosto("W33","X33",20,true);
		modificarCosto("X33","Y33",20,true);
		modificarCosto("Y33","Z33",20,true);
		modificarCosto("Z33","AA33",20,true);


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
		//Genera nodos con su ID y su posicion en pixels
		for(int col = 1; col <= 27; col++){
			String letra = generarLetra(col);
			
			for(int fila = 1; fila<= 33; fila++){
				String idNodo = letra + Integer.toString(fila);
				
				int posX = nodeSize * (col - 1);
				int posY = nodeSize * fila;
				

				 nodos.put(idNodo,new Nodo(idNodo,posX,posY));
				
			}
		}
		
	}
	
	
	private void crearTransicion(Nodo origen, Nodo destino){
		//Genera transiciones entre nodos
		Transicion t = new Transicion(origen,destino,10); 
		ArrayList<Transicion> salientes;
		if (!transiciones.containsKey(origen.Id)) {
			 salientes = new ArrayList<Transicion>();
			 salientes.add(t);
			 transiciones.put(origen.Id, salientes);
			 
		 }
		else {
			salientes = transiciones.get(origen.Id);
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
	
	
	public static String getDireccion(Nodo origen, Nodo destino){
		String letrasOrigen = "";
		String numerosOrigen = "";
		
		String letrasDestino = "";
		String numerosDestino = "";
		
		
		
		for(char c: origen.Id.toCharArray()){
			if(!Character.isDigit(c))
				letrasOrigen += Character.toString(c);
			else
				numerosOrigen += Character.toString(c);
		}
		
		for(char c: destino.Id.toCharArray()){
			if(!Character.isDigit(c))
				letrasDestino += Character.toString(c);
			else
				numerosDestino += Character.toString(c);
		}
		
		Integer numOrigen = Integer.parseInt(numerosOrigen);
		Integer numDestino = Integer.parseInt(numerosDestino);
		
		if(numDestino > numOrigen){
			return "abajo";
		}
		else if(numDestino < numOrigen)
			return "arriba";
		
		if(letrasDestino.length() > letrasOrigen.length() || (letrasDestino.compareTo(letrasOrigen) > 0)){
				return "derecha";
		}
			else{
				return "izquierda";
			}
		
		
	}

	public Transicion getTransicion(Nodo origen, String direccion) {
		ArrayList<Transicion> _transiciones = transiciones.get(origen.Id);
			for(Transicion t : _transiciones){
				if(Grafo.getDireccion(origen, t.destino) == direccion)
					return t;
			}

		return null;
	}


	//Actualiza la data recibida desde la percepcion
	public void update(Transicion nuevaTransicion) {
		if(nuevaTransicion != null){
			Nodo nuevoNodo = nuevaTransicion.destino;
			
			//Actualiza si el niño esta o no en el nodo destino
			Nodo nodoActual = nodos.get(nuevoNodo.Id);
			nodoActual.hayNinio = nuevoNodo.hayNinio; 
			
			
			//Actualiza costo de la transicion (terreno)
			Nodo origen = nuevaTransicion.origen;
			ArrayList<Transicion> transicionesDeOrigen = transiciones.get(origen.Id);
			
			
			for(Transicion t : transicionesDeOrigen){
				if(t.destino.Id == nuevoNodo.Id)
					t.costo = nuevaTransicion.costo;
			}
			
			
		}
	}
	
	
	
	public Grafo clone(){
		Grafo g = new Grafo();
		
		for(Nodo n : nodos.values()){
			ArrayList<Transicion> transicionesDeN = transiciones.get(n.Id);
			
			for(Transicion t :  transicionesDeN){
				Nodo nuevoOrigen = g.nodos.get(n.Id);
				Nodo nuevoDestino = g.nodos.get(t.destino.Id);
				
				Transicion nuevaTrans = g.getTransicion(nuevoOrigen.Id,nuevoDestino.Id);
				if(nuevaTrans != null)
					nuevaTrans.costo = t.costo;
			}
		}
		
		return g;
	  
		
	}


	public Transicion getTransicion(String idOrigen, String idDestino) {
		ArrayList<Transicion> transDeOrigen = transiciones.get(idOrigen);
		
		for(Transicion t : transDeOrigen){
			if(t.destino.Id == idDestino)
				return t;
		}
		return null;
	}
	
}
