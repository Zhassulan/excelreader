package kz.tele2.excelreader;

import kz.tele2.excelreader.interfaces.IExcelReader;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import static org.apache.poi.ss.usermodel.CellType.*;

/**
 *  Класс для чтения файла в формате Excel версий XLS и XLSX
 */
public class ExcelReader implements IExcelReader {

    /**
     *  Метод чтения Excel файла
     * @param file объекти типа File
     * @return  Массив (строки) массивов (ячейки)
     * @throws Exception
     */
    public ArrayList<ArrayList> read(File file) throws Exception {
        ArrayList<ArrayList> arrRows = new ArrayList<ArrayList>();
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            ArrayList arrCols = new ArrayList();
            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (cell.getCellType() == FORMULA) {
                    arrCols.add(getFormulaValue(cell));
                } else {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    arrCols.add(cellValue);
                }
            }
            arrRows.add(arrCols);
        }
        workbook.close();
        return arrRows;
    }

    /**
     *  Метод получения значения из ячейки типа формула, например SUM[A1:A9]
     * @param cell  Ячейка типа Cell
     * @return  Объект Double, либо String
     */
    private Object getFormulaValue(Cell cell) {
        switch (cell.getCachedFormulaResultType()) {
            case NUMERIC:
                return cell.getNumericCellValue();
            case STRING:
                return cell.getRichStringCellValue();
        }
        return null;
    }

    /**
     *  Распечатка значения ячейки
     * @param cell
     */
    private void printCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case STRING:
                System.out.print(cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue());
                } else {
                    System.out.print(cell.getNumericCellValue());
                }
                break;
            case FORMULA:
                System.out.println(getFormulaValue(cell));
                break;
            case BLANK:
                System.out.print("");
                break;
            default:
                System.out.print("");
        }
        System.out.print("\t");
    }

}
