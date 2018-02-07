import java.sql.*;

/**
 * Created by sunil on 1/19/18.
 */
public class jdbc_sample {
    public static void main(String[] args){
        test_db();
        //test_db2();
    }
    //JDBC tester
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/new_schema";
    static final String user = "root";
    static final String pass = "everyday";
    static Connection conn = null;
    static Statement stmt = null;
    public static void test_db() {
        try {
            //Register JDBC class
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Open connection
            conn = DriverManager.getConnection(DB_URL,user, pass);
            //Execute query
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("show databases");
            //Extract data from query result
            System.out.println("Databases in the db:");
            while(rs.next()){
                String databases = rs.getString("Database");
                System.out.println(""+databases);
            }
            String query = "SELECT name, country_name FROM name n INNER JOIN country c " +
                    "WHERE n.country_id=c.country_id ORDER BY name";
            rs = stmt.executeQuery(query);
            System.out.println("\n\nName\tCountry");
            while(rs.next()){
                String name= rs.getString("name");
                String country = rs.getString("country_name");
                System.out.println(name+" \t "+country);
            }
            //to connect to an excel
            /*
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection conn = DriverManager.getConnection("jdbcodbcSampleExcel","","");
                stmt = conn.createStatement();
                sql = "select * from [Sheet1$]";
                rs=stmt.executeQuery(sql);
            * */

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }finally {
            try {
                if(conn!=null)
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("\n\nClosing Connection, Goodbye!");
        }

    }
    public static void test_db2() {
        try {
            //Register JDBC class
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            //Open connection
            conn = DriverManager.getConnection("jdbc:sqlite://home/sunil/database.db");
            System.out.println("Connection to SQLite has been established.");

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select name from country");
            System.out.println("\nselect name from country::");
            while(rs.next()){
                String name = rs.getString("name");
                String name1 = rs.getString(1);

                System.out.println(name);
                //rs.updateString(1,"America");
                //String name2 = rs.getString(1);

                //System.out.println(name2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("\n\nClosing Connection, Goodbye!");
        }

    }
}
