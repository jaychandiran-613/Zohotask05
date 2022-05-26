public class person {

    private String FirstName;
	private String LastName;
	private static int PersonalID = 8921000;
	private int personalid;
	private double salary;
	private double WorkingHours;
	private double CostPerHour;

    public person(String fname, String lname, int hrs, int cost){
            FirstName = fname;
			LastName = lname;
			WorkingHours = hrs;
			CostPerHour = cost;
			salary = (WorkingHours *CostPerHour);
			personalid = ++PersonalID;
    }

    public person()
    {
        
    }

    public void set_FirstName(String fname){
		FirstName = fname;
	}

	public String get_FirstName(){
		return FirstName;
	}

	public void set_LastName(String lname){
		LastName = lname;
	}

	public void set_WorkingHours(int hrs){
		WorkingHours = hrs;
		salary = (WorkingHours *CostPerHour);
	}

	public void set_CostperHour(int cost){
		CostPerHour = cost;
		salary = (WorkingHours *CostPerHour);
	}

	public void set_salary(int cost){
		salary = cost;
	}

	public String get_LastName(){
		return LastName;
	}

	public double get_Salary(){
		return salary;
	}

	public int get_PersonalID(){
		return personalid;
	}
    
}
