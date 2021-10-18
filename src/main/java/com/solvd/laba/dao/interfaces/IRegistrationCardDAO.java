package com.solvd.laba.dao.interfaces;

import com.solvd.laba.binary.RegistrationCard;

public interface IRegistrationCardDAO extends IEntityDAO<RegistrationCard, Integer> {
    void insertToTable(int idHospital, int idVisitor, int idVisitorAgeGroupCategory, int idVisitorCategory);
    RegistrationCard getByVisitorId(int idVisitor);
    void deleteByFilter(String condition);
    void printByFilter(String condition);
}
