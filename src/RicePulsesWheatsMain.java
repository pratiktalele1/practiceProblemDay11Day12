import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import netscape.javascript.JSObject;

public class RicePulsesWheatsMain {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		JSONObject completeRecord = new JSONObject();
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("name", "basmati");
		jsonObject.put("weight", "1200");
		jsonObject.put("price", "12000");

		JSONObject jsonObject1 = new JSONObject();

		jsonObject1.put("name", "rajwadi");
		jsonObject1.put("weight", "1000");
		jsonObject1.put("price", "10000");

		JSONObject jsonObject2 = new JSONObject();

		jsonObject2.put("name", "rajaRani");
		jsonObject2.put("weight", "3000");
		jsonObject2.put("price", "30000");

		JSONArray insert = new JSONArray();
		insert.add(jsonObject);
		insert.add(jsonObject1);
		insert.add(jsonObject2);
		
		completeRecord.put("rice", insert);

		FileWriter fw = new FileWriter("./src/getAllDetails.json");
		fw.write(completeRecord.toJSONString());
		fw.flush();
		fw.close();

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject3 = (JSONObject) jsonParser.parse(new FileReader("./src/getAllDetails.json"));

		JSONArray array = (JSONArray) jsonObject3.get("rice");

		for (int i = 0; i < array.size(); i++) {
			JSONObject book = (JSONObject) array.get(i);
			String str1 = (String) book.get("name");
			String str2 = (String) book.get("weight");
			String str3 = (String) book.get("price");
			System.out.println(str1+" "+str2+" "+str3);
		}

	}

}
