import java.util.*;
import java.io.*;

class Lexical_Analyser
{
	public static void main(String args[]) throws Exception
  	{
  		//Pre-defined tables
  		Vector keyword=new Vector();
  		Vector function=new Vector();
  		Vector special_symbol=new Vector();
  		Vector operator=new Vector();
  		Vector header=new Vector();
  		Vector literal=new Vector();
  		Vector symbol=new Vector();
  		Vector error=new Vector();
  	
    	keyword.add("include");
  		keyword.add("void");
    	keyword.add("int");
		keyword.add("float");
		keyword.add("double");
		keyword.add("char");
		keyword.add("if");
		keyword.add("else");
		keyword.add("for");
		keyword.add("while");
		keyword.add("do");
	
	    operator.add('+');
	    operator.add('-');
	    operator.add('*');
	    operator.add('/');
	    operator.add('%');
	    operator.add('=');
	    operator.add('(');
	    operator.add(')');
	    operator.add('<');
	    operator.add('>');

	    function.add("main");
		function.add("printf");
	    function.add("scanf");

	    special_symbol.add('{');
	    special_symbol.add('}');
	    special_symbol.add(';');
	    special_symbol.add('#');

		header.add("stdio.h");
		header.add("conio.h");
		header.add("math.h");
		
		//Declarations
		int i,j,delim_size=operator.size()+special_symbol.size()+2; 	//1 for the space character and 1 for comma
		String file_name; 										 		//Will store the name of the input file
		String line;	  												//Will store each line of the file in each pass
		char delimiters[]=new char[delim_size];							//Will store all the delimiters
		
		//Storing all the operators in the delimiters array
		i=0;
		while(i<operator.size())
		{
			delimiters[i]=(Character)operator.elementAt(i);
			i++;
		}
		
		//Storing all the special symbols in the delimiters array
		j=0;
		while(j<special_symbol.size())
		{
			delimiters[i]=(Character)special_symbol.elementAt(j);
			j++; i++;
		}
		
		//Storing the space and comma characters in the delimiters array
		delimiters[i]=' '; i++;
		delimiters[i]=',';
		
		//Get a string ready for the delimiters to pass as parameter later
		String final_delim=new String(delimiters);
		
		//Reading the name of the input file from the user
		System.out.println("Enter the name of the input file:");
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		file_name=br.readLine();

		File new_file=new File(file_name); 
        FileInputStream fileStream=new FileInputStream(new_file); 
        InputStreamReader input=new InputStreamReader(fileStream); 
        BufferedReader reader=new BufferedReader(input);
        
        //Creating a StringTokenizer object for creating tokens line-by-line
        StringTokenizer st;
        
        System.out.println("Tokens generated are as below:");
        
        //Reading the input file line-by-line
        while((line=reader.readLine())!=null) 
        { 
        	//Create tokens, consider delimiters as tokens as well
        	st=new StringTokenizer(line,final_delim,true);
        	while(st.hasMoreTokens())
        	{  
        		String token=st.nextToken();
        		
         		if(keyword.contains(token))
         		{
         			System.out.print("<key#"+(keyword.indexOf(token)+1)+">");
         		}
         		
         		else if(function.contains(token))
         		{
         			System.out.print("<func#"+(function.indexOf(token)+1)+">");
         		}
         		
         		else if(header.contains(token))
         		{
         			System.out.print("<head#"+(header.indexOf(token)+1)+">");
         		}
         		
         		else if(operator.contains(new Character(token.charAt(0))))
         		{
         			System.out.print("<op#"+(operator.indexOf(new Character(token.charAt(0)))+1)+">");
         		}
         		
         		else if(special_symbol.contains(new Character(token.charAt(0))))
         		{
         			System.out.print("<spsym#"+(special_symbol.indexOf(new Character(token.charAt(0)))+1)+">");
         		}
         		
         		//If the first character is an alphabet or an underscore, it is a symbol
         		else if(token.charAt(0)>='a' && token.charAt(0)<='z' || token.charAt(0)>='A' && token.charAt(0)<='Z' || token.charAt(0)=='_')
         		{
         			//Checking validity of symbol
         			int flag=1;
         			
         			for(i=1;i<token.length();i++)
         			{
         				if(token.charAt(i)>='a' && token.charAt(i)<='z' || token.charAt(i)>='A' && token.charAt(i)<='Z' || token.charAt(i)=='_' || token.charAt(i)>='0' && token.charAt(i)<='9')
         				{
         					flag=1;			//Truly a symbol
         				}
         				else
         				{
         					flag=0;			//Not a symbol, hence error
         					break;
         				}
         			}
         			
         			if(flag==1)
         			{
         				if(!symbol.contains(token))
         				{
         					symbol.add(token);
         				}
         				System.out.print("<sym#"+(symbol.indexOf(token)+1)+">");
         			}
         			
         			else if(flag==0)
         		    {
         				if(!error.contains("invalid_var_declare"))
         				{
         					String error_tag="invalid_var_declare";
         					error.add(error_tag);
         				}
         			}
         		}
         		
         		else if((token.charAt(0)=='"' && token.charAt(token.length()-1)=='"'))		//Character literals
         		{
         			if(!literal.contains(token))
         			{
         				literal.add(token);
         			}
         			System.out.print("<lit#"+(literal.indexOf(token)+1)+">");
    			}
         		
         		else			//Numeric literals
         		{
         			boolean numeric=true;
         			try 
         			{ 
         				int n=Integer.parseInt(token); 
         			}
         	        catch(Exception e)
         	        {	
         	        	numeric=false;
         	        	if(!error.contains("invalid_var_declare"))
         				{
         					String error_tag="invalid_var_declare";
         					error.add(error_tag);
         				}
         	        }
         		
         			if(numeric==true)
         			{
         				if(!literal.contains(token))
         				{
         					literal.add(token);	
         				}
         				System.out.print("<lit#"+(literal.indexOf(token)+1)+">");
         			}
         		}
     		}
     		System.out.println();
       	}
       	
       	//Displaying everything
       	
       	System.out.println("\nAll the tables are as below:");
       	
       	System.out.println("Keyword Table:");
       	System.out.println("Index\tToken");
       	for(i=0;i<keyword.size();i++)
       	{
       		System.out.println((i+1)+"\t"+keyword.elementAt(i));
       	}

		System.out.println();
		       	
       	System.out.println("Function Table:");
       	System.out.println("Index\tToken");
       	for(i=0;i<function.size();i++)
       	{
       		System.out.println((i+1)+"\t"+function.elementAt(i));
       	}
       	
       	System.out.println();
       	
       	System.out.println("Special Symbol Table:");
       	System.out.println("Index\tToken");
       	for(i=0;i<special_symbol.size();i++)
       	{
       		System.out.println((i+1)+"\t"+special_symbol.elementAt(i));
       	}
       	
       	System.out.println();
       	
       	System.out.println("Operator Table:");
       	System.out.println("Index\tToken");
       	for(i=0;i<operator.size();i++)
       	{
       		System.out.println((i+1)+"\t"+operator.elementAt(i));
       	}
       	
       	System.out.println();
       	
       	System.out.println("Literal Table:");
       	System.out.println("Index\tToken");
       	for(i=0;i<literal.size();i++)
       	{
       		System.out.println((i+1)+"\t"+literal.elementAt(i));
       	}
       	
       	System.out.println();
       	
       	System.out.println("Symbol Table:");
       	System.out.println("Index\tToken");
       	for(i=0;i<symbol.size();i++)
       	{
       		System.out.println((i+1)+"\t"+symbol.elementAt(i));
       	}
       	
       	System.out.println();
       	
       	System.out.println("Error Table:");
       	System.out.println("Index\tToken");
       	for(i=0;i<error.size();i++)
       	{
       		System.out.println((i+1)+"\t"+error.elementAt(i));
       	}
	}
}

