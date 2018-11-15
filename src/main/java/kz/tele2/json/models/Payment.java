package kz.tele2.json.models;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
