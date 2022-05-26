import java.util.HashMap;

public class SEARCHmethod {
    

	String check;
    person p1 = new person();
	HashMap<Integer,person> filteredemployee = new HashMap<Integer,person>();
	int j;
	HashMap<Integer,person> searchforstring(HashMap<Integer,person> mapperson, String letter, int letterselect, int nameselect)
	{   
		if (letterselect == 1)
		{
			for (Integer key: mapperson.keySet())
			{
				if (nameselect == 1)
				{
					check = mapperson.get(key).get_FirstName();

				}
				else
				{
					check = mapperson.get(key).get_LastName();

				}

				if (check.startsWith(letter) )
				{
					filteredemployee.put(mapperson.get(key).get_PersonalID(), mapperson.get(key));
				}
			}
		}
		else if (letterselect == 2)
		{
			for (Integer key: mapperson.keySet())
			{
				if (nameselect == 1)
				{
					check = mapperson.get(key).get_FirstName();

				}
				else if (nameselect == 2)
				{
					check = mapperson.get(key).get_LastName();

				}  
				if (check.endsWith(letter))
				{
					filteredemployee.put(mapperson.get(key).get_PersonalID(), mapperson.get(key));
				}
			}
		}
		else
		{
			for (Integer key: mapperson.keySet())
			{
				if (nameselect == 1)
				{
					check = mapperson.get(key).get_FirstName();

				}
				else
				{
					check = mapperson.get(key).get_LastName();

				}

				// bool found = haystack.find(needle) != std::string::npos;
				if (check.contains(letter))
				{
					filteredemployee.put(mapperson.get(key).get_PersonalID(), mapperson.get(key));
				}
			}
		}

		return filteredemployee;
	}

	HashMap<Integer,person> searchfordouble(HashMap<Integer,person> mapperson, double limit1, double limit2, int option)
	{ 
        int k;
		for (Integer key: mapperson.keySet())
		{
            k = key;
			if (option == 1)
			{
                
				if (mapperson.get(k).get_Salary() == limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 2)
			{
				if (mapperson.get(k).get_Salary() > limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 3)
			{
				if (mapperson.get(k).get_Salary() < limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 4)
			{
				if (mapperson.get(k).get_Salary() <= limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 5)
			{
				if (mapperson.get(k).get_Salary() >= limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 6)
			{
				if (mapperson.get(k).get_Salary() != limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 7)
			{
				if (mapperson.get(k).get_Salary() >= limit1 && mapperson.get(k).get_Salary() <= limit2)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
		}

		return filteredemployee;

	}

	HashMap<Integer,person> searchforinteger(HashMap<Integer,person> mapperson, int limit1, int limit2, int option)
	{
		// vector<person>::iterator it;
		// it=find(vectorperson.begin(),vectorperson.end(),personID);
		// fvectorperson.push_back(*it);  
		// return fvectorperson;
        int k;
		for (Integer key: mapperson.keySet())
		{
            k = key;
			if (option == 1)
			{
				if (mapperson.get(k).get_PersonalID() == limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 2)
			{
				if (mapperson.get(k).get_PersonalID()  > limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 3)
			{
				if (mapperson.get(k).get_PersonalID()  < limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 4)
			{
				if (mapperson.get(k).get_PersonalID()  <= limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 5)
			{
				if (mapperson.get(k).get_PersonalID()  >= limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 6)
			{
				if (mapperson.get(k).get_PersonalID()  != limit1)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
			else if (option == 7)
			{
				if (mapperson.get(k).get_PersonalID()  >= limit1 && mapperson.get(k).get_PersonalID()  <= limit2)
				{
					filteredemployee.put(mapperson.get(k).get_PersonalID(), mapperson.get(k));
				}
			}
		}

		return filteredemployee;
	}
    
}
