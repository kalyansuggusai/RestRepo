package api.test;



import api.payload.Books;
import apiendpoints.Bookendpoints;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Bookstest
{
    Faker faker;
    Books bookpayload;
    
    @BeforeClass
    public void setupData()
    {
        faker=new Faker();
        bookpayload= new Books();
          
        bookpayload.setId(faker.idNumber().hashCode());
        bookpayload.setTitle(faker.name().title());
        bookpayload.setDescription(faker.address().cityName());
        bookpayload.setPagecount(faker.idNumber().hashCode());
       bookpayload.setExcerpt(faker.animal().name());
     
    }
    @Test(priority = 1)
    public void testpostbooks()
    {

    	System.out.println("*******************Creating the Book************************");
       Response response = Bookendpoints.CreateBook(bookpayload);

        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2)
    public void testgetbooks()
    {
    	System.out.println("*******************Get All the Books*********************");
       //Response response= Activitiesendpoints.getactivities(this.activitiespayload.getId());
        Response response= Bookendpoints.GetallBooks();
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);
    }
    
    @Test(priority=3)
    public void testputbooks()
    {
    	System.out.println("*******************Modifying the Required Book*********************");
    	 Response response= Bookendpoints.UpdateBooks(this.bookpayload.getId(), bookpayload);
         response.then().log().body();

         Assert.assertEquals(response.getStatusCode(), 200);
 
    }
    
   @Test(priority=4)   
    public void testdeletebooks()
    {
	   System.out.println("*******************Deleting the Required Book*********************");
	   Response response= Bookendpoints.DeleteBooks(this.bookpayload.getId());
       response.then().log().body();

       Assert.assertEquals(response.getStatusCode(), 200);
    }
    
}
