package kz.ugs.callisto.mis.loaders.sheet.reader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kz.ugs.callisto.mis.loaders.sheet.model.Indicator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** Класс читатель табличного файла
 * @author ZTokbayev
 * создан 22/11/2017
 */
public class Reader {

	 /**
	 * папка к табличным файлам 
	 */
	private String fileName;

	/** Конструктор
	 * @param fileName
	 */
	public Reader(String fileName) {
		super();
		this.fileName = fileName;
	}
	 
	public List <Indicator> getIndicatorsFromExcel() {
	List <Indicator> indicatorsList = new ArrayList();
	FileInputStream fis = null;
	try {
	    fis = new FileInputStream(fileName);
	    // Using XSSF for xlsx format, for xls use HSSF
	    Workbook workbook = new XSSFWorkbook(fis);
	    int numberOfSheets = workbook.getNumberOfSheets();
	    //looping over each workbook sheet
	    for (int i = 0; i < numberOfSheets; i++) {
	        Sheet sheet = workbook.getSheetAt(i);
	        Iterator <Row> rowIterator = sheet.iterator();
	        //iterating over each row
	        while (rowIterator.hasNext()) {
	            Indicator indicator = new Indicator();
	            Row row = rowIterator.next();
	            Iterator <Cell> cellIterator = row.cellIterator();
	            //Iterating over each cell (column wise)  in a particular row.
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                //The Cell Containing String will is name.
	                if (cell.getCellTypeEnum() == CellType.STRING) {
	                	indicator.setName(cell.getStringCellValue());
	                }
	            }
	            indicatorsList.add(indicator);
	            }
	        }
	    	workbook.close();
	        fis.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return indicatorsList;
	}
}
