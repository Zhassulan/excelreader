package kz.tele2.excelreader;

import kz.tele2.excelreader.models.FilePayment;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTests {

    @Test
    public void testAllFormats() {
        String SAMPLE_XLS_FILE_PATH = "C:\\Users\\zhassulan.tokbayev\\Documents\\ncp\\Реестр по разнесению ЕЖИК.xls";
        String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\zhassulan.tokbayev\\Documents\\ncp\\equipment_distribution_template.xlsx";
        ExcelReader reader = new ExcelReader();
        try {
            ArrayList <ArrayList> arr = reader.read(new File(SAMPLE_XLS_FILE_PATH));
            ContentConveter oc = new ContentConveter(arr);
            //oc.printArray(arr);
            FilePayment filePayment = oc.process();
            FilePaymentService ps = new FilePaymentService();
            ps.toFile(filePayment, "d:\\temp\\sample.json");
            System.out.println(ps.toJsonPrettyPrint(filePayment));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
