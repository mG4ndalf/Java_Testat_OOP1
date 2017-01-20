import java.util.*;
public class TerminKalender {
	
	public static void MainSetMenu(TerminManag Management){ //Gets the TerminManager;
		
		Scanner keyboardInput = new Scanner(System.in);	//Distributes the tasks based on the keyboardInput input;
		System.out.println("\nBitte Operation waehlen: ");
		System.out.println("------------------------");
		System.out.println("n: Neuen Termin anlegen");
		System.out.println("b: Termin bearbeiten");
		System.out.println("x: Termin loeschen");
		System.out.println("l: Alle Termine ausgeben");
		String operation = keyboardInput.nextLine();
		
		if(operation.equals("n")){
			choiceN(Management); 
		}
		if(operation.equals("l")){
			choiceL(Management); 
		}
		if(operation.equals("x")){
			choiceX(Management);
		}
		if(operation.equals("b")){
			choiceB(Management);
		}
		else{
			System.out.println("\n[Fehler]: Diese Auswahl existiert nicht, bitte waehlen Sie aus den vorgegebenen Moeglichkeiten! \n");
			MainSetMenu(Management); //If the choice is not either "n" or "l" or "x" or "b", the user can repeat the input;
		}
	}
		
	public static void choiceN(TerminManag Management){
		Scanner keyboardInput = new Scanner(System.in);
		try{
		System.out.printf("Bitte Betreff eingeben: \n");
		String Subject = keyboardInput.nextLine();
		System.out.println("Bitte Ort angeben: ");
		String Place = keyboardInput.nextLine();
		System.out.println("Bitte Namen der Teilnehmer angeben:");
		String Attende = keyboardInput.nextLine();
		System.out.println("Bitte Beginnzeit eingeben: (erst Stunden dann Minuten; jeweils durch Eingabetaste bestaetigen)");
		int beginH = keyboardInput.nextInt();
		int beginMin = keyboardInput.nextInt();	
		System.out.println("Bitte Beginndatum eingeben: (erst Tag dann Monat dann Jahr; jeweils durch Eingabetaste bestaetigen)");
		int beginD = keyboardInput.nextInt();
		int beginM = keyboardInput.nextInt();
		int beginY = keyboardInput.nextInt();
		System.out.println("Bitte Endzeit eingeben: (erst Stunden dann Minuten; jeweils durch Eingabetaste bestaetigen)");
		int endH = keyboardInput.nextInt();
		int endMin = keyboardInput.nextInt();
		System.out.println("Bitte Enddatum eingeben: (erst Tag dann Monat dann Jahr; jeweils durch Eingabetaste bestaetigen)");
		int endD = keyboardInput.nextInt();	
		int endM = keyboardInput.nextInt();
		int endY = keyboardInput.nextInt();
		if(((beginM==1) && (beginD>31))||((beginM==2) && (beginD>28))||((beginM==3) && (beginD>31))||((beginM==4) && (beginD>30))||((beginM==5) && (beginD>31))||((beginM==6) && (beginD>30))||((beginM==7) && (beginD>31))||((beginM==8) && (beginD>31))||((beginM==9) && (beginD>30))||((beginM==10) && (beginD>31))||((beginM==11) && (beginD>30))||((beginM==12) && (beginD>31))||(beginMin>59)||(beginM>12)||(beginH>24)){
			System.out.println("[Fehler]: Datum oder Uhrzeit fehlerhaft, bitte wiederholen!");
			choiceN(Management);
		}
		
		Termin Eintrag = new Termin(Subject, Place, Attende, beginMin, beginH, beginD, beginM, beginY, endMin, endH, endD, endM, endY);
		Management.addTermin(Eintrag);
		}
		catch(InputMismatchException e){
			System.out.println("\n[Fehler]: Ungueltige Eingabe, bitte wiederholen!\n");
			choiceN(Management);
		}
		 
		/*System.out.printf("Betreff: %s;  Name der Teilnehmer: %s; Ort: %s; Beginnzeit: %d:%d Uhr; am %d.%d.%d; Endzeit: %d:%d Uhr; am %d.%d.%d \n",Subject, Attende, Place, beginH, beginMin, beginD, beginM, beginY, endH, endMin, endD, endM, endY);// Check*/
		Management.sort();
		Management.printEvent();
		MainSetMenu(Management);			

	}
	public static void choiceL(TerminManag Management){
		Management.printEvent();
		MainSetMenu(Management);
	}
	public static void choiceX(TerminManag Management){
		if(Management.sizeOfList()<1){
			System.out.println("\n[Fehler]:Keine Termine vorhanden!");
			MainSetMenu(Management);
		}
		System.out.println("\nTerminNR zum Loeschen auswaehlen: ");
		System.out.println("---------------------------------");
		Management.printEvent();
		Scanner keyboardInput = new Scanner(System.in);
		int x = keyboardInput.nextInt();
		if(Management.sizeOfList()<x){
			System.out.println("\n[Fehler]Dieser Termin existiert nicht!\nBearbeitung fortsetzen?\n[j] = ja  [n] = nein");
			String cleanInputStream = keyboardInput.nextLine();
			String Operation = keyboardInput.nextLine();
			if(Operation.equals("j")){
				choiceX(Management);
			}
			else{
				MainSetMenu(Management);
			}
		}
		Management.deleteEvent(x);
		System.out.println("\nTermin erfolgreich geloescht!");
		System.out.println("-----------------------------");
		Management.printEvent();
		MainSetMenu(Management);
		
	}
	public static void choiceB(TerminManag Management){
		if(Management.sizeOfList()<1){
			System.out.println("[Fehler]: Keine Termine vorhanden!");
			MainSetMenu(Management);
		}
		else{
			System.out.println("\nTerminNR zur Bearbeitung auswaehlen: ");
			System.out.println("-------------------------------------");
			Management.printEvent();
			try{
			Scanner keyboardInput = new Scanner(System.in);
			int choice = keyboardInput.nextInt();
			System.out.println("\nBitte zu bearbeitende Position auswaehlen: \n[1]Betreff bearbeiten\n[2]Ort bearbeiten\n[3]Teilnehmer bearbeiten\n[4]Beginnzeit bearbeiten\n[5]Endzeit bearbeiten");
			int feature = keyboardInput.nextInt();
		
		
		
			String cleanInputStream = keyboardInput.nextLine();
			if(choice > Management.sizeOfList()){
				System.out.println("\n[Fehler]Dieser Termin existiert nicht bitte legen Sie einen an oder waehlen sie einen anderen!\n");
				System.out.println("Druecken Sie[m] um ins Hauptmenue zu gelangen.\nDruecken Sie[n] um einen neuen Termin anzulegen\nDruecken sie [b] um einen anderen Termin zu waehlen.");
				String operation = keyboardInput.nextLine();
				if(operation.equals("m")){
					MainSetMenu(Management);
				}
				else if(operation.equals("n")){
					choiceN(Management);
				}
				else if(operation.equals("b")){
					choiceB(Management);
				}
				else{
					System.out.println("Keine gueltige Eingabe, Sie gelangen nun ins Hauptmenue!");
					MainSetMenu(Management);
				}
			}
		/*Checks wheather the chosen Event exists or not;
		  Checks wheather the input is correct;
		  Distributes the tasks, if the input is not correct;
		  Asks the user, wheather he wants to go back to the MainSetMenu;
		  If the Input is not correct the user automatically goes back to MainSetMenu;*/
		else{
			
		
		Management.editEvent(feature, choice);
		Management.printEvent();
		
		MainSetMenu(Management);
		}
		}
		catch(InputMismatchException e){
			System.out.println("[Fehler]: Fehlerhafte Eingabe bitte wiederholen!");
			choiceB(Management);
	}
		}
	}
	/*Checks the input;
	  If the input is not correct the user gets a new chance to make a correct input;
	  If the input is correct the user now can make a new Event which will be saved over the old one;
	  At least all events will be printed out to check wheather they´re right or not;*/
	
	public static void main (String[] args){
	
	Scanner keyboardInput = new Scanner(System.in);	
	
	TerminManag a = new TerminManag();
	
	MainSetMenu(a);
	}
}