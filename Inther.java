import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Inther
{
	// Metoda ce verifica daca 2 string'uri sunt anagrame
	public static boolean esteAnagrama(String str1, String str2)
	{
		if ( str1.length() != str2.length() ) 
		{
            		return false;
        	}

        	str1=str1.toLowerCase();
        	str2=str2.toLowerCase();

        	char[] c1 = str1.toCharArray();
        	char[] c2 = str2.toCharArray();

        	Arrays.sort(c1);
        	Arrays.sort(c2);

        	String sc1 = new String(c1);
        	String sc2 = new String(c2);

        	return sc1.equals(sc2);
	}
	
	// Metoda main
	public static void main(String args[])
	{
		// Variabila ce va contine toate cuvintele citite din fisier
		ArrayList<String> docStr = new ArrayList<String>();
		/* Variabila currentS va contine toate cuvintele ce au anagrame
		 * Variabila alternateS va contine toate cuvintele anagrame dintr-o grupa
		 */
		String currentS = "", alternateS = "";

		if (args.length == 1 )
		{
			String FILENAME = args[0];
			try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) 
			{
				String sCurrentLine;
				while ((sCurrentLine = br.readLine()) != null) docStr.add(sCurrentLine);
			} 
			catch (IOException e) 
			{
				System.err.println("\nSpecificati corect calea catre fisier, " +
						"este primita ca primul argument.");
				System.exit(1);
			}
		}
		

		for (int i = 0; i < docStr.size(); i++)
		{
			for (int j = i+1; j < docStr.size(); j++)
			{
				if (esteAnagrama(docStr.get(i),docStr.get(j)))
				{
					if (!currentS.contains(docStr.get(i)))
					{
						currentS += docStr.get(i) + " ";
						alternateS += docStr.get(i) + " ";
					} 
					if (!currentS.contains(docStr.get(j)))
					{
						currentS += docStr.get(j) + " ";
						alternateS += docStr.get(j) + " ";
					}
				}
			}
			if (!alternateS.isEmpty())
			{
				System.out.println(alternateS);
				alternateS = "";
			}
		}
		currentS = null;
		docStr = null;		
	}
}
