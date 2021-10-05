package com.solvd.laba.dao.impl.jdbc;

import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import com.solvd.laba.service.EntityDAO;
import com.solvd.laba.binary.Hospital;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class HospitalDAOImpl extends AbstractDAO implements EntityDAO<Hospital, Integer> {
    private ResultSet rs;

    private static final String MY_QUERY = "SELECT * FROM Hospitals";
    private static final Logger LOGGER = LogManager.getLogger(HospitalDAOImpl.class);

    @Override
    public Hospital getById(Integer id) {

        return null;
    }

    @Override
    public void printAll() {

    }

    @Override
    public void printByFilter(String condition) {

    }

    @Override
    public ArrayList<Hospital> getAll() {
        return null;
    }

    @Override
    public ArrayList<Hospital> getAllWithFilter(String condition) {
        return null;
    }

    @Override
    public void insertToTable(Hospital entity) {

    }

    @Override
    public void updateEntityRow(Hospital entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteAllByFilter(String condition) {

    }

    @Override
    public void executeQuery(String query) {

    }

    //    @Override
//    public void select(String fooSQL, String barSQL) {
//        try(PreparedStatement stmt = connections.retrieve().prepareStatement(MY_QUERY)) {
//            rs = stmt.executeQuery("SELECT " + fooSQL + " FROM " + barSQL);
//        } catch (SQLException | InterruptedException | TimeoutException e) {
//            LOGGER.info(e.getMessage() + e);
//        }
//    }

//    @Override
//    public void save(Hospital entity) {
//
//    }

//    @Override
//    public void delete(Hospital entity) {
//
//    }

//    @Override
//    public void update(Hospital entity) {
//
//    }

//    @Override
//    public void viewTable() {
//        try (Statement stmt = connections.retrieve().createStatement()) {
//            String query = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";
//        } catch (SQLException | InterruptedException | TimeoutException e) {
//            e.printStackTrace();
//        }
//    }
}
