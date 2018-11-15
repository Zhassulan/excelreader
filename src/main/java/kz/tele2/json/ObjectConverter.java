package kz.tele2.json;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.tele2.json.models.Payment;
import kz.tele2.json.models.Header;
import kz.tele2.json.models.Item;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ObjectConverter {

    private ArrayList <ArrayList> content;
    private Payment payment;

    public ArrayList<ArrayList> getContent() {
        return content;
    }

    public void setContent(ArrayList<ArrayList> content) {
        this.content = content;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public ObjectConverter(ArrayList<ArrayList> content) {
        this.content = content;
    }

    public void processContent()    {
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

        //System.out.println(payment);
    }

}
