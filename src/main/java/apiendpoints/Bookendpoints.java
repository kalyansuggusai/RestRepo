package apiendpoints;

import static io.restassured.RestAssured.*;

import api.payload.Books;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Bookendpoints
{

	
	
	public static Response CreateBook(Books payload) {

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when().post(Routes.post_url);

        return response;


    }

    public static Response GetBook(int id) {

        Response response = given()
                .pathParam("id", id)
                .when().get(Routes.get_url);

        return response;


    }
    public static Response GetallBooks() {

        Response response = given()

                .when().get(Routes.get_all_url);

        return response;


    }

    public static Response UpdateBooks(int id, Books payload) {

        Response response = given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id", id).
                body(payload).
                when().put(Routes.put_url);

        return response;


    }

    public static Response DeleteBooks(int id) {

        Response response = given()
                .pathParam("id", id)
                .when().delete(Routes.delete_url);

        return response;


    }
	
	
}
