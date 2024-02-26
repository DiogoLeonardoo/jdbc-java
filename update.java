import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UPDATE {

    public static void main(String[] args) {
        
        //Declaracao de variaveis de conexao, instrucao
        // e conjunto de resultados
        
       Connection conn = null; 
       PreparedStatement st = null;

        try {
            conn = db.getConnection();


            st = conn.prepareStatement(
            
                "UPDATE seller "
                + "SET BaseSalary = BaseSalary + ? "
                + "WHERE "
                + "(DepartmentId = ?)");

            st.setDouble(1, 200.0);
            st.setInt(2,2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Pronto, tudo certo! Linhas afetadas:" + rowsAffected);
       
        } 
       catch (SQLException e) {
            e.printStackTrace();
       }
       finally {
            db.closeStatement(st);
            db.closeConnection();
       }
    }
}