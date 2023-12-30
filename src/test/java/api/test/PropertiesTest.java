package api.test;

import api.payload.Books;
import apiendpoints.Bookendpoints;
import apiendpoints.Bookpropendpoints;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners(api.ObjectRepo.ExtentReportForAPI.class)
public class PropertiesTest {

    Faker faker;
    Books bookpayload;

    public Logger log;

    @BeforeClass
    public void setupdata(){
        faker=new Faker();
        bookpayload= new Books();

        bookpayload.setId(faker.idNumber().hashCode());
        bookpayload.setTitle(faker.name().title());
        bookpayload.setDescription(faker.address().cityName());
        bookpayload.setPagecount(faker.idNumber().hashCode());
        bookpayload.setExcerpt(faker.animal().name());

        log= LogManager.getLogger(this.getClass());
    }
    @Test(priority = 1)
    public void testpostbooks() throws IOException {

        log.info("*******************Creating the Book************************");
        Response response = Bookpropendpoints.CreateBook(bookpayload);

        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority = 2)
    public void testgetbooks() throws IOException {
        log.info("*******************Get All the Books*********************");
        //Response response= Activitiesendpoints.getactivities(this.activitiespayload.getId());
        Response response= Bookpropendpoints.GetallBooks();
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority=3)
    public void testputbooks() throws IOException {
        log.info("*******************Modifying the Required Book*********************");
        Response response= Bookpropendpoints.UpdateBooks(this.bookpayload.getId(), bookpayload);
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority=4)
    public void testdeletebooks() throws IOException {
        log.info("*******************Deleting the Required Book*********************");
        Response response= Bookpropendpoints.DeleteBooks(this.bookpayload.getId());
        response.then().log().body();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

}


