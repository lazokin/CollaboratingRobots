// Author: See Ping Lim
// Student Number: s3338291

package programmer;

import java.util.StringTokenizer;

public class ProgramTokenizer {
	private char delimiter;
	private String[] tokens;
	
	public ProgramTokenizer(){
		this.delimiter = ',';
	}
	
	public String[] tokenProgram(String input){
		//clear all the String stored in tokens while using Tokenized class the last time
		tokens = null;
		StringTokenizer st = new StringTokenizer(input, Character.toString(delimiter));
		int n = st.countTokens(); 
		tokens = new String[n];
		for (int i=0; i<n; i++) 
			tokens[i] = st.nextToken();
		return tokens;
	}
	
	public void changeDelimiter(char newDelimiter){
		this.delimiter = newDelimiter;
	}

}
