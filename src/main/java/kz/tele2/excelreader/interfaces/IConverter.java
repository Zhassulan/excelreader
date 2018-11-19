package kz.tele2.excelreader.interfaces;

import java.util.ArrayList;

public interface IConverter <T> {

    public ArrayList<ArrayList> getContent();
    public void setContent(ArrayList<ArrayList> content);
    public T getPayment();
    public void setPayment(T payment);
    public void processContent();

}
