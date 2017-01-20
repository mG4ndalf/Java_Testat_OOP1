import java.util.*;

public class TerminManag{
	
	private ArrayList<String> TerminStr = new ArrayList<String> (200);
	private ArrayList<Termin> allEvents = new ArrayList<Termin> (200);
	/*Membervariables;
	  ArrayList with the Strings only for the output;*/
	
	private void feature4(int location){
		Scanner keyboardInput = new Scanner(System.in);
		System.out.println("Bitte neue Beginnzeit (Uhrzeit+Datum) eingeben(erst Stunden, dann Minuten, dann Beginn Tag, Beginn Monat, Beginn Jahr; jeweils durch Eingabetaste bestaetigen):");
			try{
			int newBeginH = keyboardInput.nextInt();
			int newBeginMin = keyboardInput.nextInt();
			int newBeginD = keyboardInput.nextInt();
			int newBeginM = keyboardInput.nextInt();
			int newBeginY = keyboardInput.nextInt();
			allEvents.get(location-1).setBeginH(newBeginH);
			allEvents.get(location-1).setBeginMin(newBeginMin);
			allEvents.get(location-1).setBeginD(newBeginD);
			allEvents.get(location-1).setBeginM(newBeginM);
			allEvents.get(location-1).setBeginY(newBeginY);
			TerminStr.set(location-1, allEvents.get(location-1).getAll());
			if(((newBeginM==1) && (newBeginD>31))||((newBeginM==2) && (newBeginD>28))||((newBeginM==3) && (newBeginD>31))||((newBeginM==4) && (newBeginD>30))||((newBeginM==5) && (newBeginD>31))||((newBeginM==6) && (newBeginD>30))||((newBeginM==7) && (newBeginD>31))||((newBeginM==8) && (newBeginD>31))||((newBeginM==9) && (newBeginD>30))||((newBeginM==10) && (newBeginD>31))||((newBeginM==11) && (newBeginD>30))||((newBeginM==12) && (newBeginD>31))||(newBeginMin>59)||(newBeginM>12)||(newBeginH>24)){
				System.out.println("[Fehler]: Datum oder Uhrzeit fehlerhaft, bitte wiederholen!");
				feature4(location);
			}
			}
			catch(InputMismatchException e){
				System.out.println("[Fehler]: Fehlerhafte Eingabe! Bitte Wiederholen!");
				feature4(location);
			}	
	}
	private void feature5(int location){
		Scanner keyboardInput = new Scanner(System.in);
		System.out.println("Bitte neue Endzeit (Uhrzeit+Datum) eingeben(erst Stunden, dann Minuten, dann End Tag, End Monat, End Jahr; jeweils durch Eingabetaste bestaetigen):");
		try{
			int newEndH = keyboardInput.nextInt();
			int newEndMin = keyboardInput.nextInt();
			int newEndD = keyboardInput.nextInt();
			int newEndM = keyboardInput.nextInt();
			int newEndY = keyboardInput.nextInt();
			allEvents.get(location-1).setEndH(newEndH);
			allEvents.get(location-1).setEndMin(newEndMin);
			allEvents.get(location-1).setEndD(newEndD);
			allEvents.get(location-1).setEndM(newEndM);
			allEvents.get(location-1).setEndY(newEndY);
			TerminStr.set(location-1, allEvents.get(location-1).getAll());
			if(((newEndM==1) && (newEndD>31))||((newEndM==2) && (newEndD>28))||((newEndM==3) && (newEndD>31))||((newEndM==4) && (newEndD>30))||((newEndM==5) && (newEndD>31))||((newEndM==6) && (newEndD>30))||((newEndM==7) && (newEndD>31))||((newEndM==8) && (newEndD>31))||((newEndM==9) && (newEndD>30))||((newEndM==10) && (newEndD>31))||((newEndM==11) && (newEndD>30))||((newEndM==12) && (newEndD>31))||(newEndMin>59)||(newEndM>12)||(newEndH>24)){
				System.out.println("[Fehler]: Datum oder Uhrzeit fehlerhaft, bitte wiederholen!");
				feature5(location);
			}
			}
			catch(InputMismatchException e){
				System.out.println("[Fehler]: Fehlerhafte Eingabe! Bitte Wiederholen!");
				feature5(location);
			}
	}
	/*Memberfunctions (only used for the editEvent-method);
	  Also check wheather the input is correct or not;*/
	
	TerminManag(){
	}
	public void addTermin(Termin aTermin){
		allEvents.add(aTermin);
		TerminStr.add(aTermin.getAll());
	}
	//Function for adding events to the ArrayList;
	
	public void Test(){
		System.out.println((allEvents.get(1)).getBeginD());
	}
	
	public void printEvent(){
		if(allEvents.size()<1){
			System.out.println("[Fehler] Keine Termine vorhanden!");
		}
		else{
			for(int i = 1; i<TerminStr.size()+1; i++){
				System.out.println("---------------------------------");
				System.out.println("NR.: "+i +" "+ TerminStr.get(i-1));
			}
		}
	}
	//prints out out the ArrayList with the events;
	
	public void deleteEvent(int choice){
		allEvents.remove(choice-1);
		TerminStr.remove(choice-1);
	}
	//Delete-function;
	
	public int sizeOfList(){
		return TerminStr.size();
	}
	
	public void editEvent(int feature, int position){
		Scanner keyboardInput = new Scanner(System.in);
		if(feature == 1){
			System.out.println("Bitte neuen Betreff eingeben:");
			String newSubject = keyboardInput.nextLine();
			allEvents.get(position-1).setSubject(newSubject);
			TerminStr.set(position-1, allEvents.get(position-1).getAll());
			//Creates a new subject and sets the new subject;
		}
		else if (feature == 2){
			System.out.println("Bitte neuen Ort eingeben:"); 
			String newPlace = keyboardInput.nextLine();
			allEvents.get(position-1).setPlace(newPlace);
			TerminStr.set(position-1, allEvents.get(position-1).getAll());
			//Creates a new place and sets the new place;
		}
		else if (feature == 3){
			System.out.println("Bitte neue Teilnehmernamen eingeben:");
			String newAttende = keyboardInput.nextLine();
			allEvents.get(position-1).setAttende(newAttende);
			TerminStr.set(position-1, allEvents.get(position-1).getAll());
		}
		else if (feature == 4){
			feature4(position);
		}
		else if (feature == 5){
			feature5(position);
		}
		else {
			System.out.println("Diese Position exisitiert nicht bitte erneut waehlen!");
			editEvent(feature, position);
		}
	}
	/*Distributes the tasks depending on the
	  input by the user;*/
	
	public void sort(){
		if(allEvents.size()>1){
			boolean sorted;
			do{
				sorted = false;
				for(int x = 0; x<allEvents.size()-1; x++){
					if(((allEvents.get(x)).getBeginY()) > ((allEvents.get(x+1)).getBeginY())){
						Termin Replace = new Termin (allEvents.get(x));
						allEvents.set(x, allEvents.get(x+1));
						allEvents.set(x+1, Replace);
						TerminStr.set(x, TerminStr.get(x+1));
						TerminStr.set(x+1, Replace.getAll());
						sorted = true;
					}
					if(((allEvents.get(x)).getBeginY()) == ((allEvents.get(x+1)).getBeginY())){
						if(((allEvents.get(x)).getBeginM()) > ((allEvents.get(x+1)).getBeginM())&&((allEvents.get(x)).getBeginM()) != ((allEvents.get(x+1)).getBeginM())){
							Termin Replace = new Termin (allEvents.get(x));
							allEvents.set(x, allEvents.get(x+1));
							allEvents.set(x+1, Replace);
							TerminStr.set(x, TerminStr.get(x+1));
							TerminStr.set(x+1, Replace.getAll());
							sorted = true;
						}
						else if(((allEvents.get(x)).getBeginM()) == ((allEvents.get(x+1)).getBeginM())){
							if(((allEvents.get(x)).getBeginD()) > ((allEvents.get(x+1)).getBeginD())){
								Termin Replace = new Termin (allEvents.get(x));
								allEvents.set(x, allEvents.get(x+1));
								allEvents.set(x+1, Replace);
								TerminStr.set(x, TerminStr.get(x+1));
								TerminStr.set(x+1, Replace.getAll());
								sorted = true;
							}
						}
					}
					else{
						sorted = true;
					}
				}
			}while(sorted == true);
			/*Simple sort-algorithm;
			  sorts the Events;
			  first year then month then day;
			  1. checks wheather the Events are in the right order;
			  2. if not the later one will be copied; 
			  3. the erlier one will be set on the position of the later one;
			  4. the copied event will be set on the position of the erlier one;*/
		}
	}
}