import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(Payload.Courseprice());

		// Print number of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);

		// Print the purchase amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);

		String title = js.getString("courses[0].title");
		System.out.println(title);

		// Print All the titles and their respective price

		for (int i = 0; i < count; i++) {

			String courseTitles = js.get("courses[" + i + "].title");
			System.out.println(courseTitles);
			System.out.println(js.get("courses[" + i + "].price").toString());

		}

		System.out.println("Print no of copies sold by RPA course");

		for (int i = 0; i < count; i++) {

			String courseTitles = js.get("courses[" + i + "].title");
			if (courseTitles.equalsIgnoreCase("RPA"))

			{
				// copies sold
				int copies = js.get("courses[" + i + "].copies");
				System.out.println(copies);
			}

		}
		
		System.out.println("Print no of copies sold by RPA Course");

		for (int i = 0; i < count; i++) {

			String courseTitles = js.get("courses[" + i + "].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
				int copies = js.get("courses[" + i + "].copies");
				System.out.println(copies);
				break;
			}

		}

	}
}
