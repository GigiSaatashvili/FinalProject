package api.tests;

import api.base.ApiBaseTest;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProductsApiTest extends ApiBaseTest {

    // ვამოწმებთ რომ პროდუქტების ჩეკი აბრუნებს 200 სტატუს კოდს
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
    // ვამოწმებთ რომ კონკრეტული პროდუქტის წამოღება ID-ით წარმატებით მუშაობს
 /*  @Test
    public void verifySingleProductReturns200() {

        int statusCode =
                given()
                        .accept(ContentType.JSON)
                        .when()
                        .get("/products/1")
                        .then()
                        .extract()
                        .statusCode();

        Assert.assertEquals(statusCode, 200,
                "კონკრეტული პროდუქტის მოთხოვნაზე უნდა დაბრუნდეს 200 სტატუს კოდი");
    } */

    // ვამოწმებთ რომ არასწორი ან არარსებული პროდუქტის მოთხოვნაზე 400 სტატუს კოდი ბრუნდება. აქ 404 მეგონა და მაგრად ვიწვალე.
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

    // ვამოწმებთ რომ კონკრეტული პროდუქტის პასუხში title ველი არ არის ცარიელი
  /*  @Test
    public void verifySingleProductTitleIsNotEmpty() {

        String productTitle =
                given()
                        .accept(ContentType.JSON)
                        .when()
                        .get("/products/1")
                        .then()
                        .extract()
                        .jsonPath()
                        .getString("title");

        Assert.assertTrue(productTitle != null && !productTitle.isBlank(),
                "პროდუქტის title ველი ცარიელი არ უნდა იყოს");
    }  */

    // ვამოწმებთ რომ კონკრეტული პროდუქტის price ველი არსებობს და ცარიელი არ არის
  /*  @Test
    public void verifySingleProductPriceIsNotNull() {

        Integer productPrice =
                given()
                        .accept(ContentType.JSON)
                        .when()
                        .get("/products/1")
                        .then()
                        .extract()
                        .jsonPath()
                        .getInt("price");

        Assert.assertNotNull(productPrice,
                "პროდუქტის price ველი null არ უნდა იყოს");
    } */

    // ვამოწმებთ რომ კონკრეტული პროდუქტის id ველი 0-ზე მეტი მნიშვნელობისაა
  /*  @Test
    public void verifySingleProductIdIsGreaterThanZero() {

        int productId =
                given()
                        .accept(ContentType.JSON)
                        .when()
                        .get("/products/1")
                        .then()
                        .extract()
                        .jsonPath()
                        .getInt("id");

        Assert.assertTrue(productId > 0,
                "პროდუქტის id ველი 0-ზე დიდი უნდა იყოს");
    } */
}