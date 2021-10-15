package com.solvd.laba.utils.pool;

import com.solvd.laba.utils.XmlParse.ConfigUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;


public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance = null;

    private static int MAX_CONNECTIONS = 5;
    private ArrayList<Connection> freeConnections = new ArrayList<>();
    private ArrayList<Connection> usedConnections = new ArrayList<>();


    public ConnectionPool(){
        try {
            Class.forName(ConfigUtils.getProperty("driver")).getDeclaredConstructor().newInstance();
            LOGGER.info("Driver add successfully");
            for(int i=0;i<5;i++){
                Connection con = DriverManager.getConnection(ConfigUtils.getProperty("url"), ConfigUtils.getProperty("username"), ConfigUtils.getProperty("password"));
                freeConnections.add(con);
            }
        } catch (Exception ex) {
            LOGGER.error("Driver connection error");
        }
    }

    public static ConnectionPool getInstance(){
        if (instance == null){
            instance = new ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() throws InterruptedException  {
        if(freeConnections.isEmpty()){
            wait(1000);
        }

        Connection connection = freeConnections.remove(freeConnections.size()-1);

        usedConnections.add(connection);
        return connection;
    }

    public void releaseConnection(Connection connection){
        freeConnections.add(connection);
        usedConnections.remove(connection);
    }

    public void shutdown() {
        usedConnections.forEach(this::releaseConnection);
        freeConnections.clear();
    }

    public boolean checkForConnections(){
        return !freeConnections.isEmpty();
    }


}
