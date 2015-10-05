import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameConverter {

	public static String [] endings = {
		"?",
		"?",
		"?",
		"?",
		"??",
		"?",
		"?",
	"?", "?", "?"};
	
	public static String [] dump =  {"?", "?" ,"?", "?" ,"?", "?" ,"?", "?", 
		"??" ,"?", "?","?", "?", "?" ,
		"?","?" ,"?" ,"?"," ?" ,"?",
		"?", "?", "?","?", "?", "?", "?", "?", "?", "?", "?" , "?", "?" , "?" };
	
	public static List<String> alphabets = Arrays.asList(dump);
	
	
	public static Map<String, String> values = new HashMap<>();
	
	static {
		values.put("Ye", "??"); values.put("??", "Ye");
		values.put("Kyaw", "?????"); values.put("?????", "Kyaw");
		values.put("Htoo", "???"); values.put("???", "Htoo");
		values.put("Aung", "?????"); 	values.put("?????", "Aung");
		values.put("San", "????"); values.put("????", "San");
		values.put("Suu", "??"); values.put("??", "Suu");
		values.put("Kyi", "????"); values.put("????", "Kyi");
		values.put("??????", "Nyein");
		values.put("?????", "Chan");
		values.put("????", "Win");
		values.put("????", "Win");
		values.put("????", "Wint");
		values.put("????", "Chen");
		values.put("????", "Wint");
		values.put("?", "Ra");
		values.put("??", "Thu");
		values.put("??", "Thu");
	}
	
	public static String getName(String myName) {
		List<String> names = new ArrayList<>();
		
		for(char n: myName.toCharArray()) {
			names.add(n+"");
		}
		
		StringBuilder name = new StringBuilder();
		
		StringBuilder nameFinal = new StringBuilder();
		
		for(int i = 0; i < names.size(); i++) {
			String n = names.get(i);
			name.append(n);
			String foreWord = null;
			String ending = null;
			String endingPlus = null;
			
			try {

				if (i > 0) {
					 foreWord = names.get(i-1);
				} else {
					foreWord = names.get(i);
				}
				ending = names.get(i+1);
				endingPlus = names.get(i+2);
			} catch (IndexOutOfBoundsException e) {
				ending = "";
			}
			
			
			if((!foreWord.equals("?")) && ((! (Arrays.asList(endings).contains(ending))) && alphabets.contains(names.get(i)))) {
				nameFinal.append(values.get(name.toString()) + " ");
				name = new StringBuilder(); // for later search if clause
			
			} else
				
				if(values.get(name.toString()) != null && Arrays.asList(endings).contains(n)) {
				nameFinal.append(values.get(name.toString()) + " ");
				name = new StringBuilder(); // for later search if clause
			}                
		}
		
		
		return nameFinal.toString();
	}
	
	public static void main(String[] args) {
	System.out.println(getName("??????????????"));
	System.out.println(getName("?????????"));
		
	}
	
}
