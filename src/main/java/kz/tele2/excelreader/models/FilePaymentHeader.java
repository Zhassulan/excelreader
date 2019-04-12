package kz.tele2.excelreader.models;

/**
 *  Класс шапки файла платежа
 */
public class FilePaymentHeader {

    private String name_sender;
    private String iin_bin_sender;
    private String payment_docnum;
    private String payment_date;

    public String getName_sender() {
        return name_sender;
    }

    public void setName_sender(String name_sender) {
        this.name_sender = name_sender;
    }

    public String getIin_bin_sender() {
        return iin_bin_sender;
    }

    public void setIin_bin_sender(String iin_bin_sender) {
        this.iin_bin_sender = iin_bin_sender;
    }

    public String getPayment_docnum() {
        return payment_docnum;
    }

    public void setPayment_docnum(String payment_docnum) {
        this.payment_docnum = payment_docnum;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

}
