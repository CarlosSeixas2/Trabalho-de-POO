package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import FACTORY.ConexaoMYSQL;

public class ClienteDAO extends ConexaoMYSQL{

    //Função de Create dos arquivos no BD
    public void insert(Cliente cli) throws SQLException{
        Connection cone = startConexao();
        String sql = "insert into cliente (nome,cnh,dt_nasc,sexo) values (?,?,?,?)";
        PreparedStatement ptst = cone.prepareStatement(sql);
        try {
            //Pegando os dados
            ptst.setString(1, cli.getNome());
            ptst.setString(2, cli.getCnh());
            ptst.setString(3, cli.getDt_nasc());
            ptst.setString(4, cli.getSexo());
            ptst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    //Função de Read dos arquivos no Banco de Dados
    public List<Cliente> select() throws SQLException{
        String sql = "SELECT * FROM cliente";

        List<Cliente> cliente = new ArrayList<Cliente>();

        Connection conect = null;
        PreparedStatement ptst = null;

        // Classe que vai recuperar os dados do Banco. ***SELECT ***
        ResultSet rset = null;

        try {
            //Realizando a Conexão com o BD
            conect = startConexao();
            ptst = conect.prepareStatement(sql);
            rset = ptst.executeQuery();

            while(rset.next()){
                Cliente _cli = new Cliente();

                //Recuperar o ID
                _cli.setId_cliente(rset.getInt("id_cliente"));
                //Recuperar a Placa
                _cli.setNome(rset.getString("nome"));
                //Recuperar a Marca
                _cli.setCnh(rset.getString("cnh"));
                //Recuperar o Modelo
                _cli.setDt_nasc(rset.getString("dt_nasc"));
                _cli.setSexo(rset.getString("sexo"));

                cliente.add(_cli);
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
        return cliente;
    }

    //Função de Update do arquivos no BD
    public void update(Cliente cli){
        String sql = "UPDATE cliente SET nome = ?, cnh = ?, dt_nasc = ?, sexo = ? " + "WHERE id_cliente = ?";

        Connection conect = null;
        PreparedStatement ptst = null;

        try {
            // Criando conexao com o Banco de Dados
            conect = startConexao();

            ptst = conect.prepareStatement(sql);

            //Pegando os dados
            ptst.setString(1, cli.getNome());
            ptst.setString(2, cli.getCnh());
            ptst.setString(3, cli.getDt_nasc());
            ptst.setString(4, cli.getSexo());
            ptst.setInt(5, cli.getId_cliente());

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
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        Connection conect = null;
        PreparedStatement ptst = null;
        
        try {
            //Realizando Conexão
            conect = startConexao();
            ptst = conect.prepareStatement(sql);

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
