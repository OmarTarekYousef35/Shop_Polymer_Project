package TesrCases;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.*;


public class Tests {

    private static final Logger logger = LoggerFactory.getLogger(Tests.class);

    RequestSpecification request;

    @BeforeClass
            public void beforeClass(){
        request = given()
                .baseUri("https://shop.polymer-project.org");
    }

    @Test
    public void EnterToProductsPage() {

        given()
                .spec(request)
        .when()
                .get("/list/mens_outerwear")
        .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void GetProduct1() {

        given()
                .spec(request)
        .when()
                .get("/detail/mens_outerwear/Android+Colorblock+Hooded+Pullover")
        .then()
                .assertThat().statusCode(200);
    }


    @Test
    public void AddProduct1() {

        File body1 = new File("src/test/resources/Product1.json");

        given()
                .spec(request)
                .body(body1)
                .contentType(ContentType.JSON)
        .when()
                .post("/cart")
        .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void GetProduct2() {

        given()
                .spec(request)
        .when()
                .get("/detail/mens_outerwear/Anvil+L+S+Crew+Neck+-+Grey")
        .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void AddProduct2() {

        File body2 = new File("src/test/resources/Product2.json");

        given()
                .spec(request)
                .body(body2)
                .contentType(ContentType.JSON)
        .when()
                .post("/cart")
        .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void GetCartPage() {

        given()
                .spec(request)
       .when()
                .get("/cart")
       .then()
                .assertThat().statusCode(200);
    }


    @Test
    public void Updateproduct2() {

        File body2 = new File("src/test/resources/UpdateProduct2.json");

        given()
                .spec(request)
                .body(body2)
                .contentType(ContentType.JSON)
        .when()
                .put("/cart")
        .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void DeleteProduct2() {

        given()
                .spec(request)
        .when()
                .delete("/detail/mens_outerwear/Anvil+L+S+Crew+Neck+-+Grey")
        .then()
                .assertThat().statusCode(200);

    }

    @Test
    public void GetCartPageAfterDeleteProducts() {

        given()
                .spec(request)
        .when()
                .get("/cart")
        .then()
                .assertThat().statusCode(200);
    }



}