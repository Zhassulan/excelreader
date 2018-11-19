package kz.tele2.excelreader.interfaces;

import java.io.File;
import java.util.ArrayList;

public interface IExcelReader {

    ArrayList<ArrayList> read(File file) throws Exception;

}
