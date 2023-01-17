package FACTORY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ConexaoMYSQL {
//    Url do banco de dados;
    private String url = "jdbc:mysql://localhost:3306/locadora";
//    Usuario
    private String user = "root";
//    Senha do Banco
    private String pass = "";
    Statement sqlmgr;

//    Estabelecendo a Conexão com o Banco de Dados
    public Connection startConexao() throws SQLException{
        try {
            Connection conect = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado ao Banco de Dados!!!");
            return conect;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    Finalizado a Conexão
    
    
    
    
    
    
    
    
//    public int insert(String sql){
//        try {
//            return sqlmgr.executeUpdate(sql);
//        } catch (Exception e) {
//            System.out.println("Report: "+ e.getMessage());
//        }
//        return -1;
//    }
}
