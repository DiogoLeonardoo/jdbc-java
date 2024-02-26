import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.swing.plaf.nimbus.State;
public class Program {

    public static void main(String[] args) {
        
        //Declaracao de variaveis de conexao, instrucao
        // e conjunto de resultados
        
        Connection conn = null;
        PreparedStatement st = null;
      
       
        try {

            //Realizando Conexao com o DB
            
            conn = db.getConnection();

            
            //Objeto Statement utilizado para enviar consultas SQL

            st = conn.prepareStatement(
                "DELETE FROM seller "
                + "WHERE "
                + "Id = ?");

            st.setInt(1,10);
          
           
           


            int rowsAffected = st.executeUpdate();

            System.out.println(rowsAffected);


          
            
        }

        //Captura das excecoes que podem ser geradas

        catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
         }
        finally {
            db.closeStatement(st);
            db.closeConnection();
            
        }
    }
}