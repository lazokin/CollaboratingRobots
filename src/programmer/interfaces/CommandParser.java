// Author: See Ping Lim
// Student Number: s3338291

package programmer.interfaces;

import programmer.language.LanguageTypes;

public interface CommandParser {
	
	/*
	 * precondition: robotID != null && command != null 
	 * postcondition: cmdStack == null
	 */
	void parseCommand(String robotID, String command);
	
	/*
	 * precondition: type != null
	 * postcondition: language != null
	 */
	boolean setLanguage(LanguageTypes type);

	void getProgram(String robotID, String program);

}
