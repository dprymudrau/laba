package com.solvd.laba.dao.jdbc.impl;

import com.solvd.laba.binary.Companies;
import com.solvd.laba.dao.interfaces.CompaniesDAO;
import com.solvd.laba.dao.jdbc.AbstractDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompaniesDaoImpl extends AbstractDAO implements CompaniesDAO {

    private static Logger LOGGER = LogManager.getLogger(CompaniesDaoImpl.class);

    private static String GET_COMPANY_BY_ID_Q = "SELECT * FROM Company WHERE id = ?";


    @Override
    public void save(Companies companies) {

    }

    @Override
    public void delete(Companies companies) {

    }}
