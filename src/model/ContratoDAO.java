package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import FACTORY.ConexaoMYSQL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ContratoDAO extends ConexaoMYSQL{
    
    //Função de Create dos arquivos no BD
    public void insert(Contrato cont) throws SQLException{
        //Realizando a Conexão
        Connection conect = startConexao();
        String sql = "insert into contrato (data,hora,id_func,id_cliente,id_carro) values (?,?,?,?,?)";
        PreparedStatement ptst = conect.prepareStatement(sql);
        try {
            //Pegando os Dados
            ptst.setString(1, cont.getData());
            ptst.setString(2, cont.getHora());
            ptst.setInt(3, cont.getId_func());
            ptst.setInt(4, cont.getId_clie());
            ptst.setInt(5, cont.getId_car());
            ptst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Função de Read dos arquivos no Banco de Dados
    public List<Contrato> select() throws SQLException{
        String sql = "SELECT * FROM contrato";

        List<Contrato> contrato = new ArrayList<Contrato>();

        Connection conect = null;
        PreparedStatement ptst = null;

        // Classe que vai recuperar os dados do Banco. ***SELECT ***
        ResultSet rset = null;

        try {
            //Realizando a Conexao
            conect = startConexao();
            ptst = conect.prepareStatement(sql);
            rset = ptst.executeQuery();

            while(rset.next()){
                Contrato _con = new Contrato();

                //Recuperar o ID
                _con.setId(rset.getInt("id_contrato"));
                //Recuperar a Data
                _con.setData(rset.getString("data"));
                //Recuperar a Hora
                _con.setHora(rset.getString("hora"));
                //Recuperar o ID do Funcionario
                _con.setId_func(rset.getInt("id_func"));
                //Recuperar o ID do Cliente
                _con.setId_clie(rset.getInt("id_cliente"));
                //Recuperar o ID do carro
                _con.setId_car(rset.getInt("id_carro"));

                contrato.add(_con);
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
        return contrato;
    }

    //Função de Update do arquivos no BD
    public void update(Contrato fun){
        String sql = "UPDATE contrato SET data = ?, hora = ?, id_func = ?, id_cliente = ?, id_carro = ? " + "WHERE id_contrato = ?";

        Connection conect = null;
        PreparedStatement ptst = null;

        try {
            // Criando conexao com o Banco de Dados
            conect = startConexao();

            ptst = conect.prepareStatement(sql);

            //Pegando os dados
            ptst.setString(1, fun.getData());
            ptst.setString(2, fun.getHora());
            ptst.setInt(3, fun.getId_func());
            ptst.setInt(4, fun.getId_clie());
            ptst.setInt(5, fun.getId_car());
            ptst.setInt(6, fun.getId());

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
        String sql = "DELETE FROM contrato WHERE id_contrato = ?";
        Connection conect = null;
        PreparedStatement ptst = null;
        
        try {
            conect = startConexao();
            ptst = conect.prepareStatement(sql);

            //Pegando o ID
            ptst.setInt(1, id);
            ptst.execute();
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
