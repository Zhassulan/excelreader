package kz.tele2.excelreader;

import kz.tele2.excelreader.interfaces.IConverter;
import kz.tele2.excelreader.models.FilePayment;
import kz.tele2.excelreader.models.FilePaymentHeader;
import kz.tele2.excelreader.models.FilePaymentItem;

import java.util.ArrayList;

public class ContentConveter implements IConverter {

    private ArrayList <ArrayList> content;

    public ContentConveter(ArrayList<ArrayList> content) {
        this.content = content;
    }

    @Override
    public FilePayment process() {
        FilePayment filePayment = new FilePayment();
        FilePaymentHeader filePaymentHeader = new FilePaymentHeader();
        filePaymentHeader.setName_sender(content.get(1).get(1).toString());
        filePaymentHeader.setIin_bin_sender(content.get(2).get(1).toString());
        filePaymentHeader.setPayment_docnum(content.get(4).get(1).toString());
        filePaymentHeader.setPayment_date(content.get(5).get(1).toString());
        filePayment.setFilePaymentHeader(filePaymentHeader);
        content.forEach(row -> {
            if (content.indexOf(row) > 7 && row.size() == 6) {
                FilePaymentItem filePaymentItem = new FilePaymentItem();
                filePaymentItem.setNum(row.get(0).toString());
                filePaymentItem.setNomenclature(row.get(1).toString());
                filePaymentItem.setMsisdn(row.get(2).toString());
                filePaymentItem.setIcc(row.get(3).toString());
                filePaymentItem.setAccount(row.get(4).toString());
                filePaymentItem.setSum(row.get(5).toString());
                filePayment.addItem(filePaymentItem);
            }
        });
        return filePayment;
    }

    public void printArray(ArrayList <ArrayList> arr)    {
        arr.forEach(row -> {
            row.forEach( item -> {
                System.out.println(item);
            });
        });
    }

}