package FACTORY;

import java.sql.SQLException;
import java.util.Scanner;

import model.Carro;
import model.CarroDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Contrato;
import model.ContratoDAO;
import model.Funcionario;
import model.FuncionarioDAO;


public class StartDAO {
    public static void main(String[] args) throws SQLException {
        // Fazendo a Conexão
        ConexaoMYSQL conex = new ConexaoMYSQL();
        conex.startConexao();

        // Instanciando
        CarroDAO _c = new CarroDAO();
        Carro c = new Carro();

        ClienteDAO _cli = new ClienteDAO();
        Cliente cli = new Cliente();

        ContratoDAO _contr = new ContratoDAO();
        Contrato contr = new Contrato();

        FuncionarioDAO _fun = new FuncionarioDAO();
        Funcionario fun = new Funcionario();

        // Scanner
        Scanner scan = new Scanner(System.in);

        System.out.println("---Menu CRUD--- \n1-Create \n2-Read \n3-Update \n4-Delete");
        int opcrud = scan.nextInt();

        if(opcrud == 1){
            System.out.println("----Menu---- \n1-Carro \n2-Cliente \n3-Contrato \n4-Funcionario");
            int op = scan.nextInt();

            if(op == 1){
                System.out.println("Digite a Placa: ");
                String placa = scan.next();

                System.out.println("Digite a Marca: ");
                String marca = scan.next();

                System.out.println("Digite o Modelo: ");
                String modelo = scan.next();

                c.setPlaca(placa);
                c.setMarca(marca);
                c.setModelo(modelo);
                _c.insert(c);
            } else if(op == 2){
                System.out.println("Digite o Nome: ");
                String nomecli = scan.next();

                System.out.println("Digite o N° da CNH: ");
                String cnh = scan.next();

                System.out.println("Digite a Data de Nascimento YYYY/MM/DD: ");
                String dtcli = scan.next();

                System.out.println("Digite o Sexo M-Masculino | F-Feminino");
                String sexo = scan.next();

                cli.setNome(nomecli);
                cli.setCnh(cnh);
                cli.setDt_nasc(dtcli);
                cli.setSexo(sexo);
                _cli.insert(cli);
            } else if(op == 3){
                System.out.println("Digite a data: ");
                String datacontra = scan.next();

                System.out.println("Digite a hora: ");
                String horacontra = scan.next();

                System.out.println("Digite o id do funcionario");
                int idfun = scan.nextInt();

                System.out.println("Digite o id do cliente");
                int idclie = scan.nextInt();

                System.out.println("Digite o id do carro");
                int idcar = scan.nextInt();

                contr.setData(datacontra);
                contr.setHora(horacontra);
                contr.setId_func(idfun);
                contr.setId_clie(idclie);
                contr.setId_car(idcar);
                _contr.insert(contr);
            } else if(op == 4){
                System.out.println("Digite o Nome: ");
                String namefun = scan.next();

                System.out.println("Digite a Data de Nascimento: ");
                String dtfun = scan.next();

                fun.setNome(namefun);
                fun.setDt_nasc(dtfun);
                _fun.insert(fun);
            }
        } else if(opcrud == 2){
            // for(Carro c1 : _c.select()){
            //     System.out.println("ID: " + c1.getId_carro() + "\nPlaca: " + c1.getPlaca() + "\nMarca: " + c1.getMarca() + "\nModelo: " + c1.getModelo() + "\n----------");
            // }

            for(Cliente clie : _cli.select()){
                System.out.println("ID: " + clie.getId_cliente() + "\nNome: " + clie.getNome() + "\nN° CNH: " + clie.getCnh() + "\nData Nasc: " + clie.getDt_nasc() + "\n----------");
            }
        } else if(opcrud == 3){
            // c.setPlaca("XXX111");
            // c.setMarca("Fiat");
            // c.setModelo("Sedan");
            // _c.update(c, 2);

            cli.setNome("Wirysson");
            cli.setCnh("987654321");
            cli.setDt_nasc("20010101");
            _cli.update(cli);
        } else if(opcrud == 4){
            _cli.delete(3);
        }
        scan.close();
    }
}
