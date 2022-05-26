import java.util.Scanner;

class menu{
    

    public static void main(String[] args)
    {
		Scanner s = new Scanner(System.in);
        boolean game = true;
	    int input1;
	    String input2;

        HRM hrm1 = new HRM();

        while (game)
	{
	    System.out.println("1.Add new employee\n" + "2.delete employee information\n" + "3.Update employee information\n" + "4.Make reports based on specific field\n" + "5.search employee\n" + "6.display details.\n" + "7.Quit\n");
		System.out.println("Please enter the related number of your requested command?");
        input1 = Integer.parseInt(s.nextLine());
   
		switch (input1)
		{
			case 1:
			    
				char check;
				String fname, lname;
				int hrs, cost, option;
				option = 1;

				while (option != 0)
				{
		
					System.out.print("Please enter the first name of an employee? ");
					fname = s.nextLine();

					System.out.print("Please enter the last name of an employee? ");
					lname = s.nextLine();

					System.out.print("How many hours a week is his/her work? ");
					hrs = Integer.parseInt(s.nextLine());

					System.out.print("How many per hours is his/her salary? ");
					cost = Integer.parseInt(s.nextLine());

					hrm1.Addperson(fname,lname,hrs,cost);

					System.out.print("Do you want to add another employee(y/n) ");
					check = s.next().charAt(0);
					s.nextLine();

					if (check == 'n' || check == 'N')
					{
						option = 0;
						
					}
				}
				break;

			case 2:
				
	            int  personalIDcheck;
                option = 1;

	         	while (option != 0)
	         	{
                System.out.print("please enter the personal number of an employee? ");
                personalIDcheck = Integer.parseInt(s.nextLine());

				hrm1.deleteperson(personalIDcheck);

			    while (true)
			    {
                    System.out.print("Do you want to repeat delete by entering the new personal number(y/n)? ");
			     	check = s.next().charAt(0);
				    s.nextLine();

				    if (check == 'n' || check == 'N')
			    	{
					option = 0;
					break;
				    }

				    else if (check == 'y' || check == 'Y')
				    {
					break;
				    }
		     	}

		        }

				break;

			case 3:

	            int option1;
		        option1 = 1;
		        while (option1 != 0)
		        {
                  System.out.print("please enter the personal number of an employee? ");
                  personalIDcheck =  Integer.parseInt(s.nextLine());
				  hrm1.Updateperson(personalIDcheck);
			      while (true)
			      {
				    System.out.print( "Do you want to repeat update by entering the new personal number(y/n)? ");
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
        	    }     
				break;
				
			case 4:

				String c;
		
				System.out.print( "please enter the related number of the field which you would like to sort the list based on it.");
				System.out.print("\n(1.Family name, 2.salary? ");
				option = Integer.parseInt(s.nextLine());
				System.out.print("1.Accending order 2.Desending order \n");
				option1 = Integer.parseInt(s.nextLine());
				hrm1.reportlist(option, option1);
		
				System.out.print( "Please enter any key to come back to main menu. ");
				c = s.nextLine();
				 break;

			case 5:
				hrm1.searchperson();
				break;

			case 6:
				hrm1.displaydetails();
				break;

            case 7:
				game = false;
				break;    

			default:
                System.out.println("Enter correct options.");
                input2 = s.nextLine();
				break;

		}
	}
        hrm1 = null;

    }
}
