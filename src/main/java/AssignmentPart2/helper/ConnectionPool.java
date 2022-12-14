package AssignmentPart2.helper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
/**
 *
 * @author 02
 */

public class ConnectionPool {
    private static ConnectionPool pool = null;
    private DataSource dataSource = null;
   
    private ConnectionPool() {
        try {
            /*InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/MyDB");
            ic.close();*/
            /*Properties properties = new Properties();

            properties.put("java.naming.factory.initial", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            */
            InitialContext ic = new InitialContext();

            DataSource ds = (DataSource)ic.lookup("java:comp/env/jdbc/myDB");



        } catch (NamingException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static synchronized ConnectionPool getInstance() {
        if (pool == null)
            pool = new ConnectionPool();
        return pool;
    }
   
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    public void freeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}