package apiendpoints;
import api.ObjectRepo.keyvalue;
import api.payload.Books;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class Bookpropendpoints {

  static keyvalue fu=new keyvalue();

  public static Response CreateBook(Books payload) throws IOException {
      String post=fu.readdatafromkeyvalue("post_url");

      Response response = given()
              .contentType(ContentType.JSON)
              .accept(ContentType.JSON)
              .body(payload)
              .when().post(post);

      return response;
  }

    public static Response GetBook(int id) throws IOException {
        String get=fu.readdatafromkeyvalue("get_url");

        Response response = given()
                .pathParam("id", id)
                .when().get(get);

        return response;


    }
    public static Response GetallBooks() throws IOException {
        String getall=fu.readdatafromkeyvalue("get_all_url");

        Response response = given()

                .when().get(getall);

        return response;


    }

    public static Response UpdateBooks(int id, Books payload) throws IOException {
        String put=fu.readdatafromkeyvalue("put_url");

        Response response = given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id", id).
                body(payload).
                when().put(put);

        return response;


    }

    public static Response DeleteBooks(int id) throws IOException {
        String delete=fu.readdatafromkeyvalue("delete_url");

        Response response = given()
                .pathParam("id", id)
                .when().delete(delete);

        return response;


    }
}
