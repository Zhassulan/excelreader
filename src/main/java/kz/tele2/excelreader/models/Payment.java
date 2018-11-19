package kz.tele2.excelreader.models;

import java.util.ArrayList;
import java.util.List;

/**
 *  Класс файлового платёжа, состоит из шапки и таблицы платежей, пример шаблона в папке "docs\equipment_distribution_template.xls"
 */
public class Payment {

    private Header header;
    private List<Item> items;

    public Payment() {
        items = new ArrayList<Item>();
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    //вывод содержимого класса
    public String toString() {
        String prn = "HEADER:\n";
        prn += header.getName_sender() + "\n";
        prn += header.getIin_bin_sender() + "\n";
        prn += header.getPayment_docnum() + "\n";
        prn += header.getPayment_date() + "\n";
        prn += "ITEMS\n";
        for (Item item : items) {
            prn += item.getNum() + "\t" + item.getNomenclature() + "\t" + item.getMsisdn() + "\t" + item.getIcc() + "\t" + item.getAccount() + "\t" + item.getSum() + "\n";
        }
        return prn;
    }

}
