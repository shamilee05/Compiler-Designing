import java.util.*;

class RDP
{
	public static int i=0;
	public static int count=0;
	public static int in_count=0;
	public static void main(String args[])
	{
		//Taking a string as input
		String input;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the input string:");
		input=sc.nextLine();
		
		//Concatenating the input string with the sentinel
		input=input.concat("$");
		boolean flag=S(input);
		
		if(flag)
		{
			System.out.println("The input string is valid");
		}
		else
		{
			System.out.println("The input string is invalid");
		}
	}
	
	public static boolean S(String input)
	{
		if(input.charAt(i)=='a')
		{
			i++;
			if(A(input))
			{
				i++;
				if(input.charAt(i)=='c' || input.charAt(i)=='b')
				{
					i++;
					if(input.charAt(i)=='$')
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public static boolean A(String input)
	{
		in_count++;
		if(input.charAt(i)=='b')
		{
			i++;
			if(A(input))
			{	
				if(count==(in_count-1))
				{
					return true;
				}
				i++;
				if(input.charAt(i)=='b')
				{	
					count++;
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else if(input.charAt(i)=='a')
		{
			i++;
			if(input.charAt(i)=='b')
			{
				count++;
				return true;
			}
			else
			{
				i--;
				count++;
				return true;
			}
		}
		else
		{
			return false;
		}
	}
}