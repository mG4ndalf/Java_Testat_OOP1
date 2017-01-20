
public class Termin {
	
	private String mSubject;
	private String mPlace;
	private String mAttende;
	private int mBeginMin;
	private int mBeginH;
	private int mEndMin;
	private int mEndH;
	private int mBeginD;
	private int mBeginM;
	private int mBeginY;
	private int mEndD;
	private int mEndM;
	private int mEndY;
	
	
	Termin(String aSubject, String aPlace, String aAttende, int aBeginMin, int aBeginH, int aBeginD, int aBeginM, int aBeginY,
			int aEndMin, int aEndH, int aEndD, int aEndM, int aEndY){
		
		setSubject(aSubject);
		setPlace(aPlace);
		setAttende(aAttende);
		setBeginMin(aBeginMin);
		setBeginH(aBeginH);
		setBeginD(aBeginD);
		setBeginM(aBeginM);
		setBeginY(aBeginY);
		setEndMin(aEndMin);
		setEndH(aEndH);
		setEndD(aEndD);
		setEndM(aEndM);
		setEndY(aEndY);
	}
	Termin(Termin aTermin){
		setSubject(aTermin.getSubject());
		setPlace(aTermin.getPlace());
		setAttende(aTermin.getAttende());
		setBeginMin(aTermin.getBeginMin());
		setBeginH(aTermin.getBeginH());
		setBeginD(aTermin.getBeginD());
		setBeginM(aTermin.getBeginM());
		setBeginY(aTermin.getBeginY());
		setEndMin(aTermin.getEndMin());
		setEndH(aTermin.getEndH());
		setEndD(aTermin.getEndD());
		setEndM(aTermin.getEndM());
		setEndY(aTermin.getEndY());
		/*Copy constructor;
		  Important for the sort algorithm at the TerminManag;*/
	}
	
	public void setSubject(String aSubject){
		mSubject = aSubject;
	}
	public void setPlace(String aPlace){
		mPlace = aPlace;
	}
	public void setAttende(String aAttende){
		mAttende = aAttende;
	}
	public void setBeginMin(int aBeginMin){
		mBeginMin = aBeginMin;
	}
	public void setBeginH(int aBeginH){
		mBeginH = aBeginH;
	}
	public void setBeginD(int aBeginD){
		mBeginD = aBeginD;
	}
	public void setBeginM(int aBeginM){
		mBeginM = aBeginM;
	}
	public void setBeginY(int aBeginY){
		mBeginY = aBeginY;
	}
	public void setEndH(int aEndH){
		mEndH = aEndH;
	}
	public void setEndMin(int aEndMin){
		mEndMin = aEndMin;
	}
	public void setEndD(int aEndD){
		mEndD = aEndD;
	}
	public void setEndM(int aEndM){
		mEndM = aEndM;
	}
	public void setEndY(int aEndY){
		mEndY = aEndY;
	}
	
	public String getSubject(){
		return mSubject;
	}
	public String getPlace(){
		return mPlace;
	}
	public String getAttende(){
		return mAttende;
	}
	public int getBeginMin(){
		return mBeginMin;
	}
	public int getBeginH(){
		return mBeginH;
	}
	public int getBeginD(){
		return mBeginD;
	}
	public int getEndH(){
		return mEndH;
	}
	public int getEndMin(){
		return mEndMin;
	}
	public int getBeginM(){
		return mBeginM;
	}
	public int getBeginY(){
		return mBeginY;
	}
	public int getEndD(){
		return mEndD;
	}
	public int getEndM(){
		return mEndM;
	}
	public int getEndY(){
		return mEndY;
	}
	public String getAll(){ //Important for the output of the Event as a String;
		return "\nBetreff: \t\t"+mSubject+"\nOrt: \t\t\t"+ mPlace+ "\nTeilnhemer: \t\t"+mAttende+ "\nBeginn Uhrzeit:  \t"+mBeginH+":"+ mBeginMin+" Uhr "+"\nam: \t\t\t" + mBeginD+"."+ mBeginM+"."+ mBeginY+ "\nEnd Uhrzeit: \t\t"+ mEndH +":"+ mEndMin+" Uhr "+"\nam: \t\t\t"+ mEndD + "." + mEndM + "." + mEndY +"\n";
	}
}//Getter and Setter;