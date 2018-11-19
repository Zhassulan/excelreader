package kz.tele2.excelreader;

import kz.tele2.excelreader.interfaces.IConverter;
import kz.tele2.excelreader.models.Payment;
import kz.tele2.excelreader.models.Header;
import kz.tele2.excelreader.models.Item;

import java.util.ArrayList;

public class ObjectConverter implements IConverter {

    private ArrayList <ArrayList> content;
    private Payment payment;

    public ObjectConverter(ArrayList<ArrayList> content) {
        this.content = content;
    }

    @Override
    public ArrayList<ArrayList> getContent() {
        return content;
    }

    @Override
    public Object getPayment() {
        return payment;
    }

    @Override
    public void setPayment(Object payment) {
        this.payment = (Payment) payment;
    }

    @Override
    public void setContent(ArrayList content) {
        this.content = content;
    }

    @Override
    public void processContent() {
        payment = new Payment();
        Header header = new Header();
        header.setName_sender(content.get(1).get(0).toString());
        header.setIin_bin_sender(content.get(2).get(0).toString());
        header.setPayment_docnum(content.get(4).get(0).toString());
        header.setPayment_date(content.get(5).get(0).toString());
        payment.setHeader(header);
        content.forEach(row -> {
            if (content.indexOf(row) > 7 && row.size() == 6) {
                Item item = new Item();
                item.setNum(row.get(0).toString());
                item.setNomenclature(row.get(1).toString());
                item.setMsisdn(row.get(2).toString());
                item.setIcc(row.get(3).toString());
                item.setAccount(row.get(4).toString());
                item.setSum(row.get(5).toString());
                payment.addItem(item);
            }
        });
    }

}