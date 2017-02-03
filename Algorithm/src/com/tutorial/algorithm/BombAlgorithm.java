package com.tutorial.algorithm;

public class BombAlgorithm {

	
	public static void main(String[] args)
	{
		BombAlgorithm algorithm=new BombAlgorithm();
		algorithm.bomb("abbbacaaadehfhh");
	}
	
	public void bomb(String input)
	{
		int j=0;
		StringBuffer str=new StringBuffer(input);
		for(int i=1;i<=str.length()-1;i++)
		{
			while(i < str.length() && j >= 0 && (str.charAt(j)==str.charAt(i)))
			{
				i++;
				continue;
			}
			if(i-j>1)
			{
				str.delete(j, i);
				j--;
				i=j;
			}
			else
			{
				j++;
			}
		}
		System.out.println("-----------------"+str);
		
		/* String str2 = "";
		 int j=0;
		    for (int i = 1; i < str.length(); i++) {
		        while (str.charAt(j) == str.charAt(i) && i != 0) {
		        	
		            i++;
		        	continue;
		        }
		        str2 = str2 + str.charAt(j);
		        j++;
		    }
		    System.out.println("string="+str2);*/
		
		
		/*StringBuffer sf=new StringBuffer(input);
		int i=0;

        while( i<sf.length())
        {
            int j=1+i;
            while(j<sf.length())
            {   

                if(sf.charAt(i)==sf.charAt(j))
                {
                    sf.deleteCharAt(j);
                }
                else
                {
                    j=j+1;
                }
            }
            i=i+1;
        }

        System.out.println("string="+sf);*/
	}
}
