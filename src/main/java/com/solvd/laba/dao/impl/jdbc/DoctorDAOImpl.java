package com.solvd.laba.dao.impl.jdbc;

import com.solvd.laba.binary.Doctor;
import com.solvd.laba.dao.interfaces.IDoctorDAO;
import com.solvd.laba.dao.abstractClasses.AbstractDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class DoctorDAOImpl extends AbstractDAO implements IDoctorDAO {
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Doctors";
    private static final String SELECT_ALL_WITH_CONDITION_QUERY = "SELECT * FROM Doctors WHERE ";
    private static final String SELECT_ALL_BY_ID_QUERY = "SELECT * FROM Doctors WHERE idDoctor = ?";
    private static final String INSERT_NEW_DOCTOR_QUERY = "INSERT INTO Doctors(idDoctor, doctorName, doctorSurname, doctorDateOfBirth, idWorkPosition, idSpeciality, idNumberOfContract , idWorkExp) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String INSERT_AUTO_INCR_NEW_DOCTOR_QUERY = "INSERT INTO Doctors(doctorName, doctorSurname, doctorDateOfBirth, idWorkPosition, idSpeciality, idNumberOfContract , idWorkExp) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_DOCTOR_QUERY = "UPDATE Doctors SET doctorName = ?, doctorSurname = ?, doctorDateOfBirth = ?, idWorkPosition = ?, idSpeciality = ?, idNumberOfContract = ?, idWorkExp = ? WHERE idDoctor = ?";
    private static final String DELETE_DOCTOR_BY_ID_QUERY = "DELETE FROM Doctors WHERE idDoctor = ?";
    private static final String DELETE_DOCTOR_WITH_CONDITION_QUERY = "DELETE FROM Doctors WHERE ";
    Connection connection = getConnection();

    private static final Logger LOGGER = LogManager.getLogger(DoctorDAOImpl.class);

    @Override
    public void printAll() {
        ResultSet resultSet = null;

        try (PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();
            LOGGER.info("Doctors:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idDoctor");
                String doctorName = resultSet.getString("doctorName");
                String doctorSurname = resultSet.getString("doctorSurname");
                Date doctorDateOfBirth = resultSet.getDate("doctorDateOfBirth");
                int idWorkPosition = resultSet.getInt("idWorkPosition");
                int idSpeciality = resultSet.getInt("idSpeciality");
                int idNumberOfContract = resultSet.getInt("idNumberOfContract");
                int idWorkExp = resultSet.getInt("idWorkExp");
                LOGGER.info("id -> " + id +
                        ", doctor name -> " + doctorName +
                        ", doctor surname -> " + doctorSurname +
                        ", doctor birthday -> " + doctorDateOfBirth +
                        ", id work position -> " + idWorkPosition +
                        ", id speciality -> " + idSpeciality +
                        ", id number of contract -> " + idNumberOfContract +
                        ", id work exp -> " + idWorkExp);
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
    }

    @Override
    public void printByFilter(String pastWhereOperatorCondition) {
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            resultSet = prepStatement.executeQuery();
            LOGGER.info("Doctors:");

            while (resultSet.next()) {
                int id = resultSet.getInt("idDoctor");
                String doctorName = resultSet.getString("doctorName");
                String doctorSurname = resultSet.getString("doctorSurname");
                Date doctorDateOfBirth = resultSet.getDate("doctorDateOfBirth");
                int idWorkPosition = resultSet.getInt("idWorkPosition");
                int idSpeciality = resultSet.getInt("idSpeciality");
                int idNumberOfContract = resultSet.getInt("idNumberOfContract");
                int idWorkExp = resultSet.getInt("idWorkExp");
                LOGGER.info("id -> " + id +
                        ", doctor name -> " + doctorName +
                        ", doctor surname -> " + doctorSurname +
                        ", doctor birthday -> " + doctorDateOfBirth +
                        ", id work position -> " + idWorkPosition +
                        ", id speciality -> " + idSpeciality +
                        ", id number of contract -> " + idNumberOfContract +
                        ", id work exp -> " + idWorkExp);
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
    }

    @Override
    public ArrayList<Doctor> getAll() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idDoctor");
                String doctorName = resultSet.getString("doctorName");
                String doctorSurname = resultSet.getString("doctorSurname");
                Date doctorDateOfBirth = resultSet.getDate("doctorDateOfBirth");
                int idWorkPosition = resultSet.getInt("idWorkPosition");
                int idSpeciality = resultSet.getInt("idSpeciality");
                int idNumberOfContract = resultSet.getInt("idNumberOfContract");
                int idWorkExp = resultSet.getInt("idWorkExp");
                Doctor doctor = new Doctor(id, doctorName, doctorSurname, doctorDateOfBirth, idWorkPosition, idSpeciality, idNumberOfContract, idWorkExp);
                doctors.add(doctor);
                LOGGER.debug(doctor + "\n is selected and received.");
            }
            LOGGER.info("Total amount of values: " + doctors.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return doctors;
    }

    @Override
    public ArrayList<Doctor> getAllWithFilter(String pastWhereOperatorCondition) {
        ArrayList<Doctor> doctors = new ArrayList<>();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            resultSet = prepStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("idDoctor");
                String doctorName = resultSet.getString("doctorName");
                String doctorSurname = resultSet.getString("doctorSurname");
                Date doctorDateOfBirth = resultSet.getDate("doctorDateOfBirth");
                int idWorkPosition = resultSet.getInt("idWorkPosition");
                int idSpeciality = resultSet.getInt("idSpeciality");
                int idNumberOfContract = resultSet.getInt("idNumberOfContract");
                int idWorkExp = resultSet.getInt("idWorkExp");
                Doctor doctor = new Doctor(id, doctorName, doctorSurname, doctorDateOfBirth, idWorkPosition, idSpeciality, idNumberOfContract, idWorkExp);
                doctors.add(doctor);
                LOGGER.debug(doctor + "\n is selected and received.");
            }
            LOGGER.info("Found values by condition: " + doctors.size());

        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return doctors;
    }

    @Override
    public Doctor getById(Integer id) {
        Doctor doctor = new Doctor();
        ResultSet resultSet = null;

        try(PreparedStatement prepStatement = connection.prepareStatement(SELECT_ALL_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();
            if (resultSet.next()) {
                doctor.setId(resultSet.getInt("idDoctor"));
                doctor.setName(resultSet.getString("doctorName"));
                doctor.setSurname(resultSet.getString("doctorSurname"));
                doctor.setBirthday(resultSet.getDate("doctorDateOfBirth"));
                doctor.setIdWorkPosition(resultSet.getInt("idWorkPosition"));
                doctor.setIdSpeciality(resultSet.getInt("idSpeciality"));
                doctor.setIdNumberOdContract(resultSet.getInt("idNumberOfContract"));
                doctor.setIdWorkExp(resultSet.getInt("idWorkExp"));
                LOGGER.debug(doctor + "\n is selected and received.");
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            closeResource(resultSet);
            releaseConnection(connection);
        }
        return doctor;
    }

    @Override
    public void insertToTable(Doctor entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_NEW_DOCTOR_QUERY)) {
            prepStatement.setInt(1, entity.getId());
            prepStatement.setString(2, entity.getName());
            prepStatement.setString(3, entity.getSurname());
            prepStatement.setDate(4, entity.getBirthday());
            prepStatement.setInt(5, entity.getIdWorkPosition());
            prepStatement.setInt(6, entity.getIdSpeciality());
            prepStatement.setInt(7, entity.getIdNumberOfContract());
            prepStatement.setInt(8, entity.getIdWorkExp());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into Doctors table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    public void insertToTable(String doctorName, String doctorSurname, Date doctorDateOfBirth, int idWorkPosition, int idSpeciality, int idNumberOfContract, int idWorkExp) {
        try(PreparedStatement prepStatement = connection.prepareStatement(INSERT_AUTO_INCR_NEW_DOCTOR_QUERY)) {
            prepStatement.setString(1, doctorName);
            prepStatement.setString(2, doctorSurname);
            prepStatement.setDate(3, doctorDateOfBirth);
            prepStatement.setInt(4, idWorkPosition);
            prepStatement.setInt(5, idSpeciality);
            prepStatement.setInt(6, idNumberOfContract);
            prepStatement.setInt(7, idWorkExp);
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is added into Doctors table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void updateEntityRow(Doctor entity) {
        try(PreparedStatement prepStatement = connection.prepareStatement(UPDATE_DOCTOR_QUERY)) {
            prepStatement.setString(1, entity.getName());
            prepStatement.setString(2, entity.getSurname());
            prepStatement.setDate(3, entity.getBirthday());
            prepStatement.setInt(4, entity.getIdWorkPosition());
            prepStatement.setInt(5, entity.getIdSpeciality());
            prepStatement.setInt(6, entity.getIdNumberOfContract());
            prepStatement.setInt(7, entity.getIdWorkExp());
            prepStatement.setInt(8, entity.getId());
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is updated in Doctors table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_DOCTOR_BY_ID_QUERY)) {
            prepStatement.setInt(1, id);
            int row = prepStatement.executeUpdate();
            if (row > 0) {
                LOGGER.debug(row + " row is deleted in Doctors table.");
            } else {
                LOGGER.info("There is no doctor with id " + id);
            }
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }

    @Override
    public void deleteByFilter(String pastWhereOperatorCondition) {
        try(PreparedStatement prepStatement = connection.prepareStatement(DELETE_DOCTOR_WITH_CONDITION_QUERY + pastWhereOperatorCondition)) {
            int row = prepStatement.executeUpdate();
            LOGGER.debug(row + " row is deleted in Doctors table.");
        } catch (SQLException e) {
            LOGGER.error("Connection failed!");
            LOGGER.error(e);
        } finally {
            releaseConnection(connection);
        }
    }
}
