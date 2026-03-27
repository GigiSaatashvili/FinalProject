package api.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import ui.utils.ConfigReader;

public class ApiBaseTest {

    // API ტესტების დაწყებამდე ვაყენებთ base URL-ს
    @BeforeClass
    public void setUpApi() {
        RestAssured.baseURI = ConfigReader.get("apiBaseUrl");
    }
}