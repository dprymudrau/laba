package com.solvd.laba.binary;

import com.solvd.laba.utils.XmlAndJsonParse.DateAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "DepartmentName") //for Jaxb
public class DepartmentName extends BaseEntityID {
    private static final Logger LOGGER = LogManager.getLogger(DepartmentName.class);
    private String departmentName;
    private int itCompaniesId;
    private Date date;

    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public int getItCompaniesId() {
        return itCompaniesId;
    }
    public void setItCompaniesId(int itCompaniesId) {
        this.itCompaniesId = itCompaniesId;
    }

    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDate(Date date){
        this.date = date;
    }
    public Date getDate(){
        return this.date;
    }
    @Override
    public String toString() {
        String id = super.toString();
        return "DepartmentName{" + id +
                ", departmentName='" + departmentName + '\'' +
                ", itCompaniesId=" + itCompaniesId +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        DepartmentName guest = (DepartmentName) obj;
        boolean b = super.equals(obj)&& (guest.departmentName == this.departmentName) && (guest.itCompaniesId == this.itCompaniesId);
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), departmentName, itCompaniesId);
    }

}
