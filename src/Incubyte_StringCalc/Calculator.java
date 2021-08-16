package Incubyte_StringCalc;

public class Calculator {
	//Add Function
		public static int addition(String content){
			
			//condition for emptyString
			if(content.equals("")){
				return 0;
			}
			else{
				
				//Condition for delimiters
				String delimiters = ",";
				if(content.matches("//(.*)\n(.*)")){
					delimiters = Character.toString(content.charAt(2));
					content = content.substring(4);
				}
				String NumLine[] = Seperate_numericals(content, delimiters + "|\n");
				return Tally_Num(NumLine);
			}
		}

		//function to convert string to integer data type
		private static int conversionToInteger(String value){
			return Integer.parseInt(value);
		}

		//function to split string
		private static String[] Seperate_numericals(String numericals, String divider){
		    return numericals.split(divider);
		}

		// function to check negative value, greater then 1000, and doing aggregate
		private static int Tally_Num(String[] numericals){
	 	    int aggregate = 0;
	 	    String Negate_String = "";

	        for(String value : numericals){
	        	
	        	//logic of checking negative value
	        	if(conversionToInteger(value) < 0){
	        		if(Negate_String.equals(""))
	        			Negate_String = value;
	        		else
	        			Negate_String += ("," + value);
	        	}
	        	
	        	//logic to check for 100
	        	if(conversionToInteger(value) < 1000)
			    	aggregate += conversionToInteger(value);
			}
	        
	        //Exception if negative function found
			if(!Negate_String.equals("")){
				throw new IllegalArgumentException("Negatives not allowed: " + Negate_String);
			}
			return aggregate;//aggregate means total of number. 
		}
}
