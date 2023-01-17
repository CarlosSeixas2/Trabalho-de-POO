package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import  java.util.List;

import FACTORY.ConexaoMYSQL;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CarroDAO extends ConexaoMYSQL{

//    Função de Create do arquivos no Banco de Dados
    public void insert(Carro car) throws SQLException {
        Connection conect = startConexao();
        String sql = "insert into carro (placa,marca,modelo) values (?,?,?)";
        PreparedStatement ptst = conect.prepareStatement(sql);

        try {
            //Resgatando os dados
            ptst.setString(1, car.getPlaca());
            ptst.setString(2, car.getMarca());
            ptst.setString(3, car.getModelo());
            System.out.println("Inserido com Sucesso!");
            ptst.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Função de Read dos arquivos no Banco de Dados
    public List<Carro> select() throws SQLException{
        String sql = "SELECT * FROM carro";

        List<Carro> carro = new ArrayList<Carro>();

        Connection conect = null;
        PreparedStatement ptst = null;

        // Classe que vai recuperar os dados do Banco. ***SELECT ***
        ResultSet rset = null;

        try {
            conect = startConexao();
            ptst = conect.prepareStatement(sql);
            rset = ptst.executeQuery();

            while(rset.next()){
                Carro _car = new Carro();

                //Recuperando O id
                _car.setId_carro(rset.getInt("id_carro"));
                //Recuperar a Placa
                _car.setPlaca(rset.getString("placa"));
                //Recuperar a Marca
                _car.setMarca(rset.getString("marca"));
                //Recuperar o Modelo
                _car.setModelo(rset.getString("modelo"));

                carro.add(_car);
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
        return carro;
    }

    //Função de Update dos arquivos no Banco de Dados
    public void update(Carro car){
        String sql = "UPDATE carro SET placa = ?, marca = ?, modelo = ? " + "WHERE id_carro = ?";

        Connection conect = null;
        PreparedStatement ptst = null;

        try {
            // Criando conexao com o Banco de Dados
            conect = startConexao();

            ptst = conect.prepareStatement(sql);

            //Resgatando os dados
            ptst.setString(1, car.getPlaca());
            ptst.setString(2, car.getMarca());
            ptst.setString(3, car.getModelo());
            ptst.setInt(4, car.getId_carro());

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

    //Função de Deletar dos arquivos no Banco de Dados
    public void delete(int id){
        String sql = "DELETE FROM carro WHERE id_carro = ?";
        Connection conect = null;
        PreparedStatement ptst = null;
        
        try {
            //Realizando a Conexão com o BD
            conect = startConexao();
            ptst = conect.prepareStatement(sql);

            //Pegando o ID
            ptst.setInt(1, id);
            ptst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
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