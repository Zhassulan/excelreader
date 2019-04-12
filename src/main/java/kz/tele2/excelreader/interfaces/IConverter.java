package kz.tele2.excelreader.interfaces;

import kz.tele2.excelreader.models.FilePayment;

import java.util.ArrayList;

public interface IConverter <T> {

    public FilePayment process();

}
