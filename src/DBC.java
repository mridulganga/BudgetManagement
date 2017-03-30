import java.sql.*;

/*
 * The Database Connectivity Class
 * Made By - Mridul Ganga
 *
 * Usage - 
 * Add this class to the desired project and rename the database
 * and other required fields.
 * Whenever required Make a connection and use that connection to perform
 * various operations.
 * Reuired Import :-
 * import java.sql.*;
 */

public class DBC {
    
    public static String currentUser="";
    

    
    public static Connection ConnectDB() 
    {
        //Register the JDBC Driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //Open a Connection
        try{
            Connection Con=DriverManager.getConnection("jdbc:mysql://localhost/budget","root","1234");
            return Con;     //return the conneciton object to the user
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       return null;
    } // End of ConnectDB
    
    
    public static void DisconnectDB(Connection Con)
    {
        try {
            Con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    } // End of DisconnectDB
    
    public static void ExecuteSQL(Connection Con,String SQL)
    {
        Statement S;
        try {
            S = Con.createStatement();
            int R = S.executeUpdate(SQL);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    } //End of ExecuteSQL
    public static ResultSet getTable(Connection Con,String SQL)
    {
        Statement S;
        try {
            S = Con.createStatement();
            ResultSet R = S.executeQuery(SQL);
            return R;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    } //End of getTable
    public static void firstRun()
    {
        Connection con = DBC.ConnectDB();
        String sql="create table if not exists members (mid int(10) primary key, name varchar(100)," +
                   "roomno int(4), mob char(11), note varchar(500), password varchar(20));";
        DBC.ExecuteSQL(con, sql);
        
        sql="create table if not exists transaction (id int(10) primary key, name varchar(100),ttype int(2),"+
            "remark varchar(500), date varchar(10), amount int(5), shared varchar(300));";
        DBC.ExecuteSQL(con, sql);
        
        sql="create table if not exists dues (id int(20) primary key, payee varchar(20), tpay varchar(20), amount int(5));";
        DBC.ExecuteSQL(con, sql);
        
        DBC.DisconnectDB(con);
    }
}
