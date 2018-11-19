package kz.tele2.excelreader;

import java.io.File;
import java.util.ArrayList;

public interface IExcelReader {

    ArrayList<ArrayList> read(File file) throws Exception;

}
