// Author: See Ping Lim
// Student Number: s3338291

package programmer.language;

import programmer.language.LanguageTypes;

public class LanguageType {
	
	private LanguageTypes languageType;
	
	public LanguageType(){
	}
	
	public LanguageTypes changeLanguage(LanguageTypes type){
		languageType = type;
		
		return languageType;
	}
	
	public LanguageTypes getLanguageType(){
		return languageType;
	}

}
