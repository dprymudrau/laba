package com.solvd.laba.jaxb;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlJavaTypeAdapter(DateAdapter.class)
@XmlRootElement(name = "dateAdapter")
public class DateAdapter extends XmlAdapter<String, Date> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public Date unmarshal(String str) throws Exception {
        synchronized (dateFormat) {
            return dateFormat.parse(str);
        }
    }

    @Override
    public String marshal(Date date) throws Exception {
        synchronized (dateFormat) {
            return dateFormat.format(date);
        }
    }
}
