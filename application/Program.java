import java.sql.Connection; 
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.plaf.nimbus.State;
public class Program {

    public static void main(String[] args) {
        
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = db.getConnection();
            
            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while(rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }
}