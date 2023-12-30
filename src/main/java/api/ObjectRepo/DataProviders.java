package api.ObjectRepo;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders
{

	 @DataProvider(name="data")
	    public String [] [] getalldata() throws IOException
	    {
	   String path="C:\\Users\\ssuggu\\Downloads\\untitled (1)\\untitled\\src\\test\\java\\utilities\\Bookdata.xlsx";
	   ExcelData ex= new ExcelData(path);

	   int rownum=ex.totalrows("Sheet1");
	   int colcount=ex.totalcolumn("Sheet1",0);

	   String apidata[][]=new String[rownum][colcount];

	   for(int i=1;i<=rownum;i++)
	   {
	       for(int j=0;j<colcount;j++)
	       {
	           apidata[i-1][j]= ex.ReadDataFromExcel("Sheet1",i,j);
	       }
	   }

	  return apidata;


	    }


	   @DataProvider(name="Id")
	   public String[] getid() throws IOException {
	       String path="C:\\Users\\ssuggu\\Downloads\\untitled (1)\\untitled\\src\\test\\java\\utilities\\Bookdata.xlsx";
	       ExcelData ex= new ExcelData(path);

	       int rownum=ex.totalrows("Sheet1");

	       String[]api= new String[rownum];

	       for(int i=1;i<=rownum;i++)
	       {
	           api[i-1]=ex.ReadDataFromExcel("Sheet1",i,0);
	       }
	       return  api;
	   }



	
	
	
}
