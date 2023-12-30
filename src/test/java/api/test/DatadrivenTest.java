package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.ObjectRepo.DataProviders;
import api.payload.Books;
import apiendpoints.Bookendpoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DatadrivenTest 
{

	Books book= new Books();
	@Test(priority=1,dataProvider="data",dataProviderClass=DataProviders.class)
	public void createbookdata(String id, String title,String description, String pagecount, String excerpt)
	{
		
		
		book.setId((int) Double.parseDouble(id));
		book.setTitle(title);
		book.setDescription(description);
		book.setPagecount((int) Double.parseDouble(pagecount));
		book.setExcerpt(excerpt);
		
		Response response= Bookendpoints.CreateBook(book);
		Assert.assertEquals(response.getStatusCode(), 200 );
	}
	
	/*
	@Test(priority=2,dataProvider="Id",dataProviderClass=DataProviders.class)
	public void getallbooksdata()
	{
		Response response=Bookendpoints.GetallBooks();
		response.body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	*/
	
	
	@Test(priority=3,dataProvider="Id",dataProviderClass=DataProviders.class)
	public void getsinglebooksdata(String id)
	{
		Response response=Bookendpoints.GetBook((int)Double.parseDouble(id));
		response.body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=4,dataProvider="Id",dataProviderClass=DataProviders.class)
	public void updateallbooks(String id)
	{  
		
		Response response= Bookendpoints.UpdateBooks((int)Double.parseDouble(id), book);
		
		Assert.assertEquals(response.getStatusCode(), 200 );
	}
	
	
	@Test(priority=5,dependsOnMethods ="createbookdata",dataProvider ="Id",dataProviderClass=DataProviders.class)
	public void deleteallbooksdata(String id)
	{
		Response response=Bookendpoints.DeleteBooks((int)Double.parseDouble(id));
		response.body();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
}
