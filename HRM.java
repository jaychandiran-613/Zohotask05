import java.util.Scanner;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
public class HRM {
    static Scanner s = new Scanner(System.in);

    private static int number_staff = 0;
    public static int employeeid = 8921000;
    
    public HashMap<Integer, person> map = new HashMap<>();

	//-------------constructor------------
    public HRM()
	{
		person p1 = new person("jayachandiran", "jai", 12, 45);//540
		map.put(++employeeid, p1);
		person p2 = new person("Kalai mani", "mama", 89, 45);//4005
		map.put(++employeeid, p2);
		person p3 = new person("Hemanthponneri", "hema", 56, 12);//672
		map.put(++employeeid, p3);
		person p4 = new person("Ranganathan", "ranga", 03, 56);//168
		map.put(++employeeid, p4);
		person p5 = new person("Aathithiyan", "ash", 89, 99);//8811
		map.put(++employeeid, p5);
		person p6 = new person("RajarajanJ", "raja", 42, 26);//1092
		map.put(++employeeid, p6);
		person p7 = new person("Arjunsrinath", "arjun", 102, 120);//12240
		map.put(++employeeid, p7);
	}

	//--------------add person details------------

    public void Addperson(String fname, String lname, Integer hrs, Integer cost){

		number_staff++;
			person newperson = new person(fname, lname, hrs, cost);
			map.put(++employeeid, newperson);
            System.out.print("The employee with the following information has been added to the system:\n");
            System.out.print("FirstName  FamilyName  PersonalNumber  Salary(Euro)\n");
            System.out.print( "---------  ----------  --------------  ------------\n");
            System.out.print(newperson.get_FirstName() + "\t" + newperson.get_LastName() + "\t" + newperson.get_PersonalID() + "\t" + newperson.get_Salary() + "\n");
    }

	//-----------------Delete person details-------------

    public void deleteperson(int  personalIDcheck)
	{
		
		char check;
		if (map.get(personalIDcheck) == null)
			{
                System.out.print("Sorry,there is not any employee with requested personal number.\n");
			}
			else
			{
                person person1 = new person();
                person1 = map.get(personalIDcheck);
                System.out.print("Do you want to delete employee " + person1.get_FirstName() + "  " + person1.get_LastName() + "(y/n)?");
				check = s.next().charAt(0);
				if (check == 'Y' || check == 'y')
				{
                    System.out.print("The employee " + person1.get_FirstName() + "  " + person1.get_LastName() + " has been deleted.");
					map.remove(personalIDcheck);
					number_staff--;
				}

                person1 = null;
			}
	}

	//-----------------Update person details-----------------

    public void Updateperson(Integer personalIDcheck)
	{
		String fname,lname;
		int hrs,option;
		char check;

		if (map.get(personalIDcheck) == null)
			{
                System.out.print("Sorry,there is not any employee with requested personal number.\n");
			}
			else
			{
                person person1 = new person();
				while (true)
				{
                    
                    person1 = map.get(personalIDcheck);
                    System.out.print("(1.First name, 2.Family name, 3.WorkingHours, 4.payment for one hour)?");
					option = Integer.parseInt(s.nextLine());
					switch (option)
					{
						case 1:
                            System.out.print("Please enter new First name for " + person1.get_FirstName());
							fname = s.nextLine() ;
							person1.set_FirstName(fname);
							break;
						case 2:
                            System.out.print("Please enter new Family name for " + person1.get_FirstName());
                            s.nextLine();
							lname = s.nextLine();
							person1.set_LastName(lname);
							break;
						case 3:
                            System.out.print("Please enter new WorkingHours for " + person1.get_FirstName());
							hrs = Integer.parseInt(s.nextLine());
							person1.set_WorkingHours(hrs);
							break;
						case 4:
							System.out.print("Please enter new payment for one hour for " + person1.get_FirstName());
                            hrs = Integer.parseInt(s.nextLine());
							person1.set_CostperHour(hrs);
							break;
						default:
                            System.out.print("enter correct option next time\n");
					}

                    System.out.print("Do you want to update ant other field(y/n)? ");
					check = s.next().charAt(0);
					s.nextLine();
					if (check == 'n' || check == 'N')
					{
						break;
					}
				}
                map.put(personalIDcheck, person1);
                person1 = null;

			}
	}

	//-------------Sorting vector----------------


	void quicksort(Vector<person> vec, int L, int R, int U, int X)
	{
		if (X != 1 && X != 2)
		{
			return;
		}

		int i, j, mid, piv, u, x = X;
		i = L;
		j = R;
		u = U;
		mid = L + (R - L) / 2;
		piv = getsalaryorlname(vec, mid, U);
		while (i < R || j > L)
		{
			if (x == 1)
			{
				while (getsalaryorlname(vec, i, U) < piv)
					i++;
			}
			else if (x == 2)
			{
				while (getsalaryorlname(vec, i, U) > piv)
					i++;
			}

			if (x == 1)
			{
				while (getsalaryorlname(vec, j, U) > piv)
					j--;
			}
			else if (x == 2)
			{
				while (getsalaryorlname(vec, j, U) < piv)
					j--;
			}

			if (i <= j)
			{
                Collections.swap(vec, i, j);
				i++;
				j--;
			}
			else
			{
				if (i < R)
					quicksort(vec, i, R, u, x);
				if (j > L)
					quicksort(vec, L, j, u, x);
				return;
			}
		}
	}
    
	int getsalaryorlname(Vector<person> vec, int i, int j)
	{
		String faname;
		int piv;
		double piv1;
		if (j == 1)
		{
			faname = vec.get(i).get_LastName();
			piv = (int) faname.charAt(0);
			return piv;
		}
		else
		{
			piv1 = vec.get(i).get_Salary();
			piv = (int)piv1;
			return piv;
		}
	}

	public void reportlist(Integer option, Integer option1)
	{


		if (option == 2)
		{
			Vector<person> vectoremployee = new Vector<person>();
			for (Integer key: map.keySet())
			{
				vectoremployee.add(map.get(key));
			}

			System.out.print("Following is the result:\n");
			System.out.print("FirstName  FamilyName  PersonalNumber  Salary(Euro)\n");
			System.out.print("---------  ----------  --------------  ------------\n");

			if (option1 == 1)
			{
				quicksort(vectoremployee, 0, vectoremployee.size() - 1, 2, 1);

			}
			else if (option1 == 2)
			{
				quicksort(vectoremployee, 0, vectoremployee.size() - 1, 2, 2);
			}
			else
			{
				System.out.print("enter correct option.\n");
			}

			for (int i = 0; i < vectoremployee.size(); i++)
			{
				System.out.print(vectoremployee.get(i).get_FirstName() + "\t\t" + vectoremployee.get(i).get_LastName() + "\t\t" + vectoremployee.get(i).get_PersonalID() + "\t\t" + vectoremployee.get(i).get_Salary() + "\n");
			}

			vectoremployee = null;
		}
		else if (option == 1)
		{
			Vector<person> vectoremployee = new Vector<person>();
			for (Integer key: map.keySet())
			{
				vectoremployee.add(map.get(key));
			}
            
			if (option1 == 1)
			{
				quicksort(vectoremployee, 0, vectoremployee.size() - 1, 1, 1);

			}
			else if (option1 == 2)
			{
				quicksort(vectoremployee, 0, vectoremployee.size() - 1, 1, 2);
			}
			else
			{
				System.out.print("enter correct option.\n");
			}

			for (int i = 0; i < vectoremployee.size(); i++)
			{
				System.out.print(vectoremployee.get(i).get_FirstName() + "\t\t" + vectoremployee.get(i).get_LastName() + "\t\t" + vectoremployee.get(i).get_PersonalID() + "\t\t" + vectoremployee.get(i).get_Salary() + "\n");
			}

			vectoremployee = null;
		}
		else
		{
			System.out.print("enter correct option");
		}
	}

	//------------search details---------------

	void searchperson()
	{
		int option3,option1 = 1;
		char check;
		while (option1 != 0)
		{
			HashMap<Integer, person> employeefilter1 = new HashMap<>();
			HashMap<Integer, person> employeefilter2 = new HashMap<>();
			HashMap<Integer, person> employeefilter3 = new HashMap<>();
			employeefilter1=createquery();
			displaynamedetails(employeefilter1);
			while(true)
			{
                System.out.print("1.AND 2.OR 3.NOT Operation to perform, Please enter your option: \n Enter 4 for exit ");
				option3 = Integer.parseInt(s.nextLine());
				employeefilter2.clear();
				employeefilter3.clear();
				if(option3==1)
				{
					employeefilter2=createquery();
					displaynamedetails(employeefilter2);
					System.out.print("enter any key to show the result");
					option1 = Integer.parseInt(s.nextLine());
					for(Integer key: employeefilter1.keySet())
					{
						if(employeefilter2.get(key) != null)
						{
							employeefilter3.put(key,employeefilter1.get(key));
						}
					}
					System.out.print("After operation: The new query : \n");
					displaynamedetails(employeefilter3);
				}
				else if(option3==2)
				{
					employeefilter2=createquery();
					displaynamedetails(employeefilter2);
					System.out.print("enter any key to show the result");
					option1 = Integer.parseInt(s.nextLine());
					for(Integer key: employeefilter1.keySet())
					{
						employeefilter3.put(key, employeefilter1.get(key));
					}
					for(Integer key: employeefilter2.keySet())
					{
						employeefilter3.put(key, employeefilter2.get(key));
					}
					System.out.print("After operation: The new query : \n");
					displaynamedetails(employeefilter3);
				}
				else if(option3==3)
				{
					for(Integer key: map.keySet())
					{
						if(employeefilter1.get(key) == null)
						{
							employeefilter3.put(key, map.get(key));
						}
					}
					System.out.print("After operation: The new query  :  \n");
					displaynamedetails(employeefilter3);

				}
				else
				{
                    break;
				}
				employeefilter1.clear();
				employeefilter1.putAll(employeefilter3);				
			}

			while (true)
			{
				System.out.print("Do you want to do new search(y/n)? ");
				check = s.next().charAt(0);
				s.nextLine();
				if (check == 'n' || check == 'N')
				{
					option1 = 0;
					break;
				}
				else if (check == 'y' || check == 'Y')
				{
					break;
				}
			}
			employeefilter1 = null;
			employeefilter2 = null;
			employeefilter3 = null;
		}
	}

	public HashMap<Integer,person> createquery()
	{       int option2,option;
		    int S_max,S_min;
		    String letterstart, letterend;
		    String containing;
		    SEARCHmethod searchmethod = new SEARCHmethod();
			HashMap<Integer, person> employeefilter1 = new HashMap<Integer, person>();
			System.out.print("Search is based on four different fields(1.first name 2.family name, 3.Salary, 4.employeeID), Please enter your choice? ");
			option = Integer.parseInt(s.nextLine());
	
			if (option == 1 || option == 2)
			{
				System.out.print("Search by 1.starting letter   2.ending letter   3.containing ");
				option2 = Integer.parseInt(s.nextLine());
				if (option2 == 1)
				{
					System.out.print("enter the starting letter ");
					letterstart = s.nextLine();
					employeefilter1 = searchmethod.searchforstring(map, letterstart, 1, option);

				}
				else if (option2 == 2)
				{
					System.out.print("enter the ending letter ");
					letterend = s.nextLine();
					employeefilter1 = searchmethod.searchforstring(map, letterend, 2, option);

				}
				else if (option2 == 3)
				{
					System.out.print("enter the string containing ");
					containing = s.nextLine();
					employeefilter1 = searchmethod.searchforstring(map, containing, 3, option);

				}
				else
				{
					System.out.print("enter the correct option.\n");
				}
			}
			else if (option == 3)
			{
				System.out.print("Please define your search range for Salary of employees .\n");
				System.out.print("what is Salary limit1 for search? ");
				S_min = Integer.parseInt(s.nextLine());
				System.out.print("Please enter 1.== 2.> 3.< 4.<= 5.>= 6.!= 7.between\n");
				option2 = Integer.parseInt(s.nextLine());
				switch (option2)
				{
					case 1:
						employeefilter1 = searchmethod.searchfordouble(map, S_min, 0, 1);
						break;

					case 2:
						employeefilter1 = searchmethod.searchfordouble(map, S_min, 0, 2);
						break;

					case 3:
						employeefilter1 = searchmethod.searchfordouble(map, S_min, 0, 3);
						break;

					case 4:
						employeefilter1 = searchmethod.searchfordouble(map, S_min, 0, 4);
						break;

					case 5:
						employeefilter1 = searchmethod.searchfordouble(map, S_min, 0, 5);
						break;

					case 6:
						employeefilter1 = searchmethod.searchfordouble(map, S_min, 0, 6);
						break;

					case 7:
					    System.out.print("enter the second upper limit ");
						S_max = Integer.parseInt(s.nextLine());
						employeefilter1 = searchmethod.searchfordouble(map, S_min, S_max, 7);
						break;

					default:
					System.out.print("enter the correct option.\n");	
						break;

				}
			}
			else if (option == 4)
			{
				System.out.print("Please define your search range for personID of employees .\n");
				System.out.print("enter the personID limit1 for search? ");
				S_min = Integer.parseInt(s.nextLine());
				System.out.print("Please enter 1.== 2.> 3.< 4.<= 5.>= 6.!= 7.between\n");
				option2 = Integer.parseInt(s.nextLine());
				switch (option2)
				{
					case 1:
						employeefilter1 = searchmethod.searchforinteger(map, S_min, 0, 1);
						break;

					case 2:
						employeefilter1 = searchmethod.searchforinteger(map, S_min, 0, 2);
						break;

					case 3:
						employeefilter1 = searchmethod.searchforinteger(map, S_min, 0, 3);
						break;

					case 4:
						employeefilter1 = searchmethod.searchforinteger(map, S_min, 0, 4);
						break;

					case 5:
						employeefilter1 = searchmethod.searchforinteger(map, S_min, 0, 5);
						break;

					case 6:
						employeefilter1 = searchmethod.searchforinteger(map, S_min, 0, 6);
						break;

					case 7:
					System.out.print("enter the second upper limit ");	
						S_max = Integer.parseInt(s.nextLine());
						employeefilter1 = searchmethod.searchforinteger(map, S_min, S_max, 7);
						break;

					default:
					System.out.print("enter the correct option.\n");
						break;

				}

			}
			else
			{
				System.out.print("enter correct option\n");
			}
			searchmethod = null;
			return employeefilter1;	


	}

	void displaynamedetails(HashMap<Integer,person> employeefilter1)
	{
		System.out.print("Following is the list of employees for your defined search fields:\n" + "FirstName  FamilyName  PersonalNumber  Salary(Euro)\n" +  "---------  ----------  --------------  ------------\n" );

		for (Integer key: employeefilter1.keySet())
			{
				System.out.print(employeefilter1.get(key).get_FirstName() + "\t\t" + employeefilter1.get(key).get_LastName() + "\t\t" + employeefilter1.get(key).get_PersonalID() + "\t\t" + employeefilter1.get(key).get_Salary() + "\n");
			}

	}


    //-------------Display details-----------------


    public void displaydetails()
	{
        System.out.print("FirstName  FamilyName  PersonalNumber  Salary(Euro)\n" );
        System.out.print("---------  ----------  --------------  ------------\n" );
        
		for (Integer key: map.keySet())
		{
            System.out.print(map.get(key).get_FirstName() + "\t\t" + map.get(key).get_LastName() + "\t\t" + map.get(key).get_PersonalID() + "\t\t" + map.get(key).get_Salary() + "\n");
	
		}
        System.out.print("Please enter any key to come back to main menu. ");
		String check = s.nextLine();
	}
	



}
