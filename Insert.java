import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;


public class Program {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = db.getConnection();

            
            
            st = conn.prepareStatement(
                "INSERT INTO seller "
                + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                + "VALUES "
                + "(?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);

           
           
            st.setString(1, "Diogo Leonardo");
            st.setString(2, "diogoleo57@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("09/02/2004").getTime()));
            st.setDouble(4,3000);
            st.setInt(5, 4);

           
           
            int rowsAffected = st.executeUpdate();
           
            if (rowsAffected > 0) {

                ResultSet rs = st.getGeneratedKeys();

                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Tudo certo! Id = " + id);
                }

            }
            else {
                System.out.println("Sem linhas afetadas!");
            }
       
       
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
       
        catch (java.text.ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            db.closeConnection();
            db.closeConnection();
        }
        
    }
}