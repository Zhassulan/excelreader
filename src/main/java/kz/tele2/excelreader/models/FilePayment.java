package kz.tele2.excelreader.models;

import java.util.ArrayList;
import java.util.List;

/**
 *  Класс файлового платёжа, состоит из шапки и таблицы платежей, пример шаблона в папке "docs\equipment_distribution_template.xls"
 */
public class FilePayment {

    private FilePaymentHeader filePaymentHeader;
    private List<FilePaymentItem> filePaymentItems;

    public FilePayment() {
        filePaymentItems = new ArrayList<FilePaymentItem>();
    }

    public FilePaymentHeader getFilePaymentHeader() {
        return filePaymentHeader;
    }

    public void setFilePaymentHeader(FilePaymentHeader filePaymentHeader) {
        this.filePaymentHeader = filePaymentHeader;
    }

    public List<FilePaymentItem> getFilePaymentItems() {
        return filePaymentItems;
    }

    public void setFilePaymentItems(List<FilePaymentItem> filePaymentItems) {
        this.filePaymentItems = filePaymentItems;
    }

    public void addItem(FilePaymentItem filePaymentItem) {
        filePaymentItems.add(filePaymentItem);
    }

    //вывод содержимого класса
    public String toString() {
        String prn = "HEADER:\n";
        prn += filePaymentHeader.getName_sender() + "\n";
        prn += filePaymentHeader.getIin_bin_sender() + "\n";
        prn += filePaymentHeader.getPayment_docnum() + "\n";
        prn += filePaymentHeader.getPayment_date() + "\n";
        prn += "ITEMS\n";
        for (FilePaymentItem filePaymentItem : filePaymentItems) {
            prn += filePaymentItem.getNum() + "\t" + filePaymentItem.getNomenclature() + "\t" + filePaymentItem.getMsisdn() + "\t" + filePaymentItem.getIcc() + "\t" + filePaymentItem.getAccount() + "\t" + filePaymentItem.getSum() + "\n";
        }
        return prn;
    }

}
