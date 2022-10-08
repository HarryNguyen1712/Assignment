package AssignmentPart2.Configuration;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;

public class DBconfig {

    public static Connection conn = null;
    public static SQLServerDataSource ds;

    public DBconfig() {
        ds = new SQLServerDataSource();
        ds.setUser("admin");
        ds.setPortNumber(1433);
        ds.setPassword("admin");
        ds.setServerName("localhost");
        ds.setDatabaseName("ASSIGNMENT");
    }

    public Connection getInstance() throws SQLServerException {

        if (conn == null)
            conn = ds.getConnection();
        return conn;
    }
}
