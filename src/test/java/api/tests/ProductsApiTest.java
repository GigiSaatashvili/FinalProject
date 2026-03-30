package api.tests;

import api.base.ApiBaseTest;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProductsApiTest extends ApiBaseTest {

    // ვამოწმებთ რომ პროდუქტების ენდფოინთი აბრუნებს 200 სტატუს კოდს
    @Test
    public void checkProductsStatusCode() {

        int statusCode =
                given()
                        .accept(ContentType.JSON)
                        .when()
                        .get("/products")
                        .then()
                        .extract()
                        .statusCode();

        Assert.assertEquals(statusCode, 200,
                "პროდუქტების ენდფოინთმა უნდა დააბრუნოს 200 სტატუს კოდი");
    }

    // ვამოწმებთ რომ პროდუქტების სია ცარიელი არ ბრუნდება
    @Test
    public void verifyProductsListIsNotEmpty() {

        int productsCount =
                given()
                        .accept(ContentType.JSON)
                        .when()
                        .get("/products")
                        .then()
                        .extract()
                        .jsonPath()
                        .getList("$")
                        .size();

        Assert.assertTrue(productsCount > 0,
                "პროდუქტების სია ცარიელი არ უნდა იყოს");
    }

    // ვამოწმებთ რომ არარსებული პროდუქტის მოთხოვნაზე 400 სტატუს კოდი ბრუნდება
    @Test
    public void verifyNonExistingProductReturns400() {

        int statusCode =
                given()
                        .accept(ContentType.JSON)
                        .when()
                        .get("/products/999999")
                        .then()
                        .extract()
                        .statusCode();

        Assert.assertEquals(statusCode, 400,
                "არარსებული პროდუქტის მოთხოვნაზე უნდა დაბრუნდეს 400 სტატუს კოდი");
    }

    // ვამოწმებთ რომ პროდუქტების პასუხის content type არის JSON
    @Test
    public void verifyProductsResponseContentTypeIsJson() {

        String contentType =
                given()
                        .accept(ContentType.JSON)
                        .when()
                        .get("/products")
                        .then()
                        .extract()
                        .contentType();

        Assert.assertTrue(contentType.contains("application/json"),
                "პროდუქტების პასუხის content type უნდა იყოს JSON");
    }

    // ვამოწმებთ რომ პირველი პროდუქტის title ველი ცარიელი არ არის
    @Test
    public void verifyFirstProductTitleIsNotEmpty() {

        String productTitle =
                given()
                        .accept(ContentType.JSON)
                        .when()
                        .get("/products")
                        .then()
                        .extract()
                        .jsonPath()
                        .getString("[0].title");

        Assert.assertTrue(productTitle != null && !productTitle.isBlank(),
                "პირველი პროდუქტის title ველი ცარიელი არ უნდა იყოს");
    }
}