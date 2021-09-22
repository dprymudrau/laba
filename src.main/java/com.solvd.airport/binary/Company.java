package com.solvd.airport.binary;

import java.util.Objects;

public class Company {
    private long idCompany;
    private String companyName;
    private String description;

    public long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(long idCompany) {
        this.idCompany = idCompany;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return idCompany == company.idCompany && companyName.equals(company.companyName) && Objects.equals(description, company.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompany, companyName, description);
    }

    @Override
    public String toString() {
        return "Company{" +
                "idCompany=" + idCompany +
                ", companyName='" + companyName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
