package serializationDemo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class EmpSerialization {

	@Test(priority=1)
	public void createEmp(){
		
		Employee emp=new Employee();
		
		emp.setName("Nilesh");
		emp.setJob("QA");
		
		given()
			.contentType(ContentType.JSON)
			.body(emp)
			.log().all()	
		.when()
			//.get("https://reqres.in/api/users")
			.post("http://reqres.in/api/users")
		
		.then()
			.statusCode(200)
			.assertThat()
			.body("name",equalTo("Nilesh"))
			.log().all();		
		
	}
}
