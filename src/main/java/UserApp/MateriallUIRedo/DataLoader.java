package UserApp.MateriallUIRedo;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *  @author Adam Renak
 */

@Component
public class DataLoader implements CommandLineRunner {

	class UserList {
		List<User> list;

		public List<User> getList() {
			return list;
		}

		public void setList(List<User> list) {
			this.list = list;
		}
	}

	private final UserRepository repo;

	
	/** 
	 * @param repo
	 * @return 
	 */
	@Autowired
	public DataLoader(UserRepository repo) {
		this.repo = repo;
	}

	
	/** 
	 * @param strings
	 * @throws Exception
	 */
	@Override
	public void run(String... strings) throws Exception {
		List<User> userList = getUsersFromRandomMe(20);
		userList.forEach((user) -> repo.save(user));	
	}

	
	/** 
	 * @param inputStream
	 * @return String
	 */
	private static String streamToString(InputStream inputStream) {
		Scanner scan = new Scanner(inputStream, "UTF-8");
		scan.useDelimiter("\\Z");
		String text = scan.next();
		scan.close();
		return text;
	  }
	
	
	/** 
	 * @param howManyUsers
	 * @return String
	 */
	private static String jsonGetUsersRequest(int howManyUsers) {
		String json = null;
		try {
		  	URL url = new URL("https://randomuser.me/api/?results=" + howManyUsers);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("charset", "utf-8");
			connection.connect();
			InputStream inStream = connection.getInputStream();
			json = streamToString(inStream); // input stream to string
		} catch (IOException ex) {
		  	ex.printStackTrace();
		}
		return json;
	  }

	
	/** 
	 * @param howManyUsers
	 * @return List<User>
	 */
	public static List<User> getUsersFromRandomMe(int howManyUsers) {
		// Get all random users
		List<User> userList = new ArrayList<>();
		String results = jsonGetUsersRequest(howManyUsers);

		JSONObject jsonObject = new JSONObject(results);
		JSONArray jsonArray = jsonObject.getJSONArray("results");

		// Loop through array and get info for each user object		
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject forNewUser = jsonArray.getJSONObject(i);
		
			JSONObject namesForUser = (JSONObject) forNewUser.get("name");
			JSONObject locationForUser = (JSONObject) forNewUser.get("location");
			JSONObject addressInfoForUser = (JSONObject) locationForUser.get("street");
			String address = addressInfoForUser.get("number").toString() + " " + addressInfoForUser.get("name");
			JSONObject imagesForUser = (JSONObject) forNewUser.get("picture");

			User user = new User(
				(String) namesForUser.get("first"), (String) namesForUser.get("last"),
				(String) forNewUser.get("email"), (String) imagesForUser.get("medium"), 
				address, (String) locationForUser.get("city"), (String) locationForUser.get("state"), 
				(String) locationForUser.get("postcode").toString(), (String) locationForUser.get("country"),
				(String) forNewUser.get("phone"));

			userList.add(user);
		}
		return userList;
	}
}