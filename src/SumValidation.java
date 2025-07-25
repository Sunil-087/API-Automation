import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	@Test
	public void sumOfCourses() {
		int sum =0;
		JsonPath js = new JsonPath(Payload.Courseprice());
		int count = js.getInt("courses.size()");
		for (int i = 0; i < count; i++) 
		{
			int price = js.get("courses[" + i + "].price");
			int copies = js.get("courses[" + i + "].copies");
			int amount = price * copies;
			System.out.println(amount);
			sum = sum + amount;
		}
		
		System.out.println("Total sum of all the amount: " +sum);
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
	}
}
