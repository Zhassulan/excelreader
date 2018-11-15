package kz.tele2.excelparser;

import kz.tele2.json.ObjectConverter;
import kz.tele2.json.PaymentService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTests {

    @Test
    public void testAllFormats() {
        String SAMPLE_XLS_FILE_PATH = "C:\\Users\\zhassulan.tokbayev\\Documents\\ncp\\equipment_distribution_template.xls";
        String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\zhassulan.tokbayev\\Documents\\ncp\\equipment_distribution_template.xlsx";
        ExcelReader reader = new ExcelReader();
        try {
            ArrayList <ArrayList> arr = reader.read(new File(SAMPLE_XLS_FILE_PATH));
            /*arrRows.forEach(arrayList -> {
                System.out.println(arrayList);
            }); */
            ObjectConverter oc = new ObjectConverter(arr);
            oc.processContent();
            PaymentService ps = new PaymentService();
            ps.toFile(oc.getPayment());
            System.out.println(ps.toJsonPrettyPrint(oc.getPayment()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
