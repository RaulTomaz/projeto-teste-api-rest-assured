import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class testAPI {

    @Test
    public void testingApi() {
        try {
            RestAssured rest = new RestAssured();
            String cityName = "United States";
            String cityCountry = "US";
            Response resp = rest.get("https://samples.openweathermap.org/data/2.5/weather?q=" + cityName + "," + cityCountry + "&appid=b6907d289e10d714a6e88b30761fae22");
            System.out.println("Status code: " + resp.getStatusCode());
            String responseJson = resp.asString();
            JsonObject json = new Gson().fromJson(responseJson, JsonObject.class);
            System.out.println(json.get("id"));
            Assert.assertEquals(resp.getStatusCode(), 200);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
