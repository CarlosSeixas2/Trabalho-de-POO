package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import FACTORY.ConexaoMYSQL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class FuncionarioDAO extends ConexaoMYSQL{
    
    //Função de Create dos arquivos no BD
    public void insert(Funcionario fun) throws SQLException{
        Connection conect = startConexao();
        String sql = "insert into funcionario (nome,dt_nasc,sexo) values (?,?,?)";
        PreparedStatement ptst = conect.prepareStatement(sql);
        try {
            //Pegando dados
            ptst.setString(1, fun.getNome());
            ptst.setString(2, fun.getDt_nasc());
            ptst.setString(3, fun.getSexo());
            ptst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    //Função de Read dos arquivos no Banco de Dados
    public List<Funcionario> select() throws SQLException{
        String sql = "SELECT * FROM funcionario";

        List<Funcionario> func = new ArrayList<Funcionario>();

        Connection conect = null;
        PreparedStatement ptst = null;

        // Classe que vai recuperar os dados do Banco. ***SELECT ***
        ResultSet rset = null;

        try {
            //Realizando Conexão
            conect = startConexao();
            ptst = conect.prepareStatement(sql);
            rset = ptst.executeQuery();

            while(rset.next()){
                Funcionario _func = new Funcionario();

                //Recuperar ID
                _func.setId(rset.getInt("id_func"));
                //Recuperar a NOme
                _func.setNome(rset.getString("nome"));
                //Recuperar a Data
                _func.setDt_nasc(rset.getString("dt_nasc"));
                //Recuperar o Sexo
                _func.setSexo(rset.getString("sexo"));

                func.add(_func);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(rset != null){
                    rset.close();
                }
                if(ptst != null){
                    ptst.close();
                }
                if(conect != null){
                    conect.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return func;
    }
    
    //Função de Update do arquivos no BD
    public void update(Funcionario fun){
        String sql = "UPDATE funcionario SET nome = ?, dt_nasc = ?, sexo = ? " + "WHERE id_func = ?";

        Connection conect = null;
        PreparedStatement ptst = null;

        try {
            // Criando conexao com o Banco de Dados
            conect = startConexao();

            ptst = conect.prepareStatement(sql);

            //Pegando dados
            ptst.setString(1, fun.getNome());
            ptst.setString(2, fun.getDt_nasc());
            ptst.setString(3, fun.getSexo());
            ptst.setInt(4, fun.getId());

            ptst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(ptst != null){
                    ptst.close();
                }
                if(conect != null){
                    conect.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

     //Função de deletar dados no BD
    public void delete(int id){
        String sql = "DELETE FROM funcionario WHERE id_func = ?";
        Connection conect = null;
        PreparedStatement ptst = null;
        
        try {
            //Realizando a Conexão
            conect = startConexao();
            ptst = conect.prepareStatement(sql);

            ptst.setInt(1, id);
            ptst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(ptst != null){
                    ptst.close();
                }
                if(conect != null){
                    conect.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
