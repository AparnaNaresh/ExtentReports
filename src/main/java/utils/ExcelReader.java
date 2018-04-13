package utils;

import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; //New imports to read XLSX format
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet; //New imports to read XLSX format
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;


public class ExcelReader  {

	 XSSFWorkbook wb = null;
	 FileInputStream fis=null;
	 XSSFSheet sh = null;
	 
	 String data[][]=null;
	 File f = new File(System.getProperty("user.dir")+"\\DataSheets\\TestData.xlsx");
	 
	 @Test(dataProvider="testData")
	 public void test(String data[][])
	 {
		String username = data[0][0];
		System.out.println(username);
	 }

	@DataProvider(name ="testData")
	public String[][] readExcel() throws IOException, InvalidFormatException
	{
		
		
		FileInputStream fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		int row = sh.getLastRowNum();
		int column = sh.getRow(0).getLastCellNum();
		
		data = new String[row][column];
		Iterator<Row> rows = sh.iterator();
		int i=0;
		while(rows.hasNext())
		{
			i++;
			Row row1 = rows.next();
			String runMode = sh.getRow(i).getCell(4).getStringCellValue();
			if(runMode.equalsIgnoreCase("Yes"))
			{
			Iterator<Cell> cells = row1.cellIterator();
			while(cells.hasNext())
			{
				int j=0;
				Cell cellvalue = cells.next();
//				if(cellvalue.getStringCellValue().contains("TestCase"))
//				{
//					break;
//				}
				
				switch(cellvalue.getCellType())
				{
				case Cell.CELL_TYPE_NUMERIC:
				data[i][j++]= cellvalue.getStringCellValue();
				System.out.println(cellvalue.getNumericCellValue());
				break;
				case Cell.CELL_TYPE_STRING:
					data[i][j++]=cellvalue.getStringCellValue();
					System.out.println(cellvalue);
				}//switch
					
			}// while cells
			
			
			}// if runmode
		}// while rows
		return data;
//		System.out.println(data);
//		
//		for(int k =1;k<=row;k++)
//		{
//			sh.getRow(k).createCell(3).setCellValue("PASS");
//			
//			
//		}
//		FileOutputStream fos = new FileOutputStream(f);
//		wb.write(fos);
//		fos.close();
	}

}
