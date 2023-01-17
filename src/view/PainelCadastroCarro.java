/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Carro;
import model.CarroDAO;

/**
 *
 * @author cadup
 */
public class PainelCadastroCarro extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form PainelCadastroCarro
     */
    public PainelCadastroCarro() {
        initComponents();
        Atualizatable();
    }
    
    public void Atualizatable(){
        DefaultTableModel tabela = (DefaultTableModel) roldados.getModel();
        CarroDAO _car = new CarroDAO();
        tabela.setNumRows(0);
        
        try {
            for(Carro car: _car.select()){
                tabela.addRow(new Object[]{
                    car.getId_carro(),
                    car.getPlaca(),
                    car.getMarca(),
                    car.getModelo()
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(PainelCadastroCarro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        placa = new javax.swing.JLabel();
        inputplaca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        roldados = new javax.swing.JTable();
        marca = new javax.swing.JLabel();
        inputmodelo = new javax.swing.JTextField();
        modelo = new javax.swing.JLabel();
        inputmarca = new javax.swing.JTextField();
        buttoncadastrar = new javax.swing.JButton();
        ID = new javax.swing.JLabel();
        inputid = new javax.swing.JTextField();
        buttonatualizar = new javax.swing.JButton();
        placa2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttondelete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        placa.setText("Placa    Ex: TAFC123");

        inputplaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputplacaActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Carro");
        jLabel1.setToolTipText("");

        roldados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Placa", "Marca", "Modelo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roldados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roldadosMouseClicked(evt);
            }
        });
        roldados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                roldadosKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(roldados);

        marca.setText("Marca");

        inputmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputmodeloActionPerformed(evt);
            }
        });

        modelo.setText("Modelo");

        inputmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputmarcaActionPerformed(evt);
            }
        });

        buttoncadastrar.setText("Cadastrar");
        buttoncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttoncadastrarActionPerformed(evt);
            }
        });

        ID.setText("ID");

        inputid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputidActionPerformed(evt);
            }
        });

        buttonatualizar.setText("Update");
        buttonatualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonatualizarActionPerformed(evt);
            }
        });

        placa2.setText("OU");

        jLabel2.setText("Para realizar o Update Click no Objeto e mude");

        buttondelete.setText("Deletar");
        buttondelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttondeleteActionPerformed(evt);
            }
        });

        jLabel3.setText("Atenção Não coloque o ID para Cadastro ou Atualização");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(placa)
                                            .addComponent(inputplaca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inputid, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(ID)
                                                .addGap(50, 50, 50)))
                                        .addGap(44, 44, 44))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inputmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(modelo))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(marca)
                                            .addComponent(inputmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttondelete)
                                        .addGap(61, 61, 61))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(placa2))
                                    .addComponent(buttonatualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttoncadastrar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(122, 122, 122))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(351, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(2, 2, 2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(placa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(inputplaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ID)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(inputid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(marca)
                                .addGap(13, 13, 13)
                                .addComponent(inputmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(buttondelete)))
                        .addGap(12, 12, 12)
                        .addComponent(modelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttoncadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(placa2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonatualizar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(301, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputplacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputplacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputplacaActionPerformed

    private void inputmodeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputmodeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputmodeloActionPerformed

    private void inputmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputmarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputmarcaActionPerformed

    private void buttoncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttoncadastrarActionPerformed
        CarroDAO _car = new CarroDAO();
        Carro car = new Carro();
        
        car.setPlaca(inputplaca.getText());
        car.setMarca(inputmarca.getText());
        car.setModelo(inputmodelo.getText());
        
        if(inputplaca.getText().isEmpty() || inputmarca.getText().isEmpty() || inputmodelo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Confira se algo não está faltando");
        }else{
        
            DefaultTableModel tabela = (DefaultTableModel) roldados.getModel();

            Object[] dados = {
                car.getId_carro(),
                car.getPlaca(),
                car.getMarca(),
                car.getModelo()
            };
            tabela.addRow(dados);

            try {
                _car.insert(car);
                Atualizatable();
                inputplaca.setText("");
                inputmarca.setText("");
                inputmodelo.setText("");

                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            } catch (SQLException ex) {
                Logger.getLogger(PainelCadastroCarro.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Eroo ao Cadastrar!");

            }
        }
    }//GEN-LAST:event_buttoncadastrarActionPerformed

    private void inputidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputidActionPerformed

    private void buttonatualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonatualizarActionPerformed
        
        if(roldados.getSelectedRow() != -1){
            CarroDAO _car = new CarroDAO();
            Carro car = new Carro();

            car.setPlaca(inputplaca.getText());
            car.setMarca(inputmarca.getText());
            car.setModelo(inputmodelo.getText());
            car.setId_carro((int)roldados.getValueAt(roldados.getSelectedRow(), 0));
            
            _car.update(car);
            
            inputplaca.setText("");
            inputmarca.setText("");
            inputmodelo.setText("");
            
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!");

            
            Atualizatable();
        } 
    }//GEN-LAST:event_buttonatualizarActionPerformed

    private void buttondeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttondeleteActionPerformed
        CarroDAO _car = new CarroDAO();
        Carro car = new Carro();

        _car.delete(Integer.parseInt(inputid.getText()));
        Atualizatable();
        inputid.setText("");
    }//GEN-LAST:event_buttondeleteActionPerformed

    private void roldadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roldadosMouseClicked
        if(roldados.getSelectedRow() != -1){
            inputplaca.setText(roldados.getValueAt(roldados.getSelectedRow(), 1).toString());
            inputmarca.setText(roldados.getValueAt(roldados.getSelectedRow(), 2).toString());
            inputmodelo.setText(roldados.getValueAt(roldados.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_roldadosMouseClicked

    private void roldadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_roldadosKeyReleased
        if(roldados.getSelectedRow() != -1){
            inputplaca.setText(roldados.getValueAt(roldados.getSelectedRow(), 1).toString());
            inputmarca.setText(roldados.getValueAt(roldados.getSelectedRow(), 2).toString());
            inputmodelo.setText(roldados.getValueAt(roldados.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_roldadosKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JButton buttonatualizar;
    private javax.swing.JButton buttoncadastrar;
    private javax.swing.JButton buttondelete;
    private javax.swing.JTextField inputid;
    private javax.swing.JTextField inputmarca;
    private javax.swing.JTextField inputmodelo;
    private javax.swing.JTextField inputplaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel marca;
    private javax.swing.JLabel modelo;
    private javax.swing.JLabel placa;
    private javax.swing.JLabel placa2;
    private javax.swing.JTable roldados;
    // End of variables declaration//GEN-END:variables
}