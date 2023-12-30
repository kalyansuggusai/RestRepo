package api.ObjectRepo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData
{

	Workbook wb;
    FileInputStream fis;
    FileOutputStream fos;
    String path;

    public ExcelData(String path)

    {
        this.path=path;
    }
  public String ReadDataFromExcel(String Sheetname,int row, int cell) throws IOException
  {
      fis= new FileInputStream("C:\\Users\\ssuggu\\Downloads\\untitled (1)\\untitled\\src\\test\\java\\utilities\\Bookdata.xlsx");
      Workbook wb = WorkbookFactory.create(fis);
      String data= wb.getSheet(Sheetname).getRow(row).getCell(cell).toString();
      return data;

  }
 
  
 
 
  public void WriteDataIntoExcel(String Sheetname,int row,int cell, String data) throws IOException {
      fis= new FileInputStream("C:\\Users\\Mukesh\\Desktop\\API Framework\\untitled\\src\\test\\java\\utilities\\Bookdata.xlsx");
      Workbook wb = WorkbookFactory.create(fis);
      wb.getSheet(Sheetname).getRow(row).createCell(cell).setCellValue(data);
      fos=new FileOutputStream("C:\\Users\\ssuggu\\Downloads\\untitled (1)\\untitled\\src\\test\\java\\utilities\\Bookdata.xlsx");
      wb.write(fos);

  }
  public int totalrows(String Sheetname) throws IOException
  {
      fis= new FileInputStream("C:\\Users\\ssuggu\\Downloads\\untitled (1)\\untitled\\src\\test\\java\\utilities\\Bookdata.xlsx");
      wb = WorkbookFactory.create(fis);
      int datavalue= wb.getSheet(Sheetname).getLastRowNum();
      return datavalue;

  }

    public int totalcolumn(String Sheetname,int row) throws IOException {
        fis = new FileInputStream("C:\\Users\\ssuggu\\Downloads\\untitled (1)\\untitled\\src\\test\\java\\utilities\\Bookdata.xlsx");
        wb = WorkbookFactory.create(fis);
        int datavalue = wb.getSheet(Sheetname).getRow(row).getLastCellNum();
        return datavalue;

    }
	
	
	
	
}
