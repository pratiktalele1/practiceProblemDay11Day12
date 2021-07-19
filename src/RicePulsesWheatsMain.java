import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import netscape.javascript.JSObject;

public class RicePulsesWheatsMain {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		JSONObject jsObject=new JSONObject();
		Map<String, JSONArray> addElement=new HashMap<String, JSONArray>();
		JSONArray array=new JSONArray();
		JSONObject jo=new JSONObject();
		jo.put("weight", "1230");
		jo.put("price", "123000");
		array.add(jo);
		addElement.put("rice", array);
		
		JSONArray array2=new JSONArray();
		JSONObject jo1=new JSONObject();
		jo1.put("weight", "785");
		jo1.put("price", "759");
		array2.add(jo1);
		addElement.put("wheat", array2);
		jsObject.putAll(addElement);
		
		JSONArray array3=new JSONArray();
		JSONObject jo2=new JSONObject();
		jo2.put("weight", "78596");
		jo2.put("price", "456321");
		array3.add(jo2);
		addElement.put("pulses", array3);
		
		jsObject.putAll(addElement);
		
		FileWriter fw = new FileWriter("./src/getAllDetails.json");
		fw.write(jsObject.toJSONString());
		fw.flush();
		fw.close();
		
		JSONParser jsonParser=new JSONParser();
		JSONObject jsonObject=(JSONObject) jsonParser.parse(new FileReader("./src/getAllDetails.json"));
		for(int i=0;i<jsonObject.size()-1;i++) {
			System.out.println(jsonObject);
			break;
		}
	}	
}
