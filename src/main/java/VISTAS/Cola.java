
package VISTAS;

import CONTROLADORES.C_Inicio;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Cola extends javax.swing.JFrame {
    private final ImageIcon error = new ImageIcon(getClass().getResource("/icon/error.png"));
    protected DefaultTableModel tb1;//EL MODELO POR DEFECTO DE LA TABLA -- este
    protected TableRowSorter<TableModel> rowSorter;//BUSCA EN LA TABLA-- este
    
    public Cola() {
        initComponents();
        this.setLocationRelativeTo(this);
        tb1 = (DefaultTableModel)TBL_AREA.getModel();//ASIGNA EL MODELO DE LA TABLA DEL JFRAME A TB1-- este
        rowSorter = new TableRowSorter<>(TBL_AREA.getModel());//ASIGNA EL MODELO DE LA TABLA DEL JFRAME A ROWSORTER-- este
        TBL_AREA.setRowSorter(rowSorter);//ASIGNA ROWSORTER A LA TABLA;-- este
        Clases.Cola_Pendientes.removeCancelados();
        this.RenderTable();//REFERIZA LA TABLA
        this.getContentPane().setBackground(new Color(0, 102, 102));
        this.createSearcher();//-este quede
    }
    
    /*   MÉTODO PARA BUSCAR EN LA TABLA   */
    public void createSearcher(){
        txtBuscar.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = txtBuscar.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtBuscar.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }//-- este
    
    private void RenderTable(){
        tb1.setRowCount(0);
        for (int i = 0; i <= Clases.Cola_Pendientes.size(); i++) {
            tb1.addRow(Clases.Cola_Pendientes.getData(i));
        }
    }
    
    private void editRow(int index, String estado){
        if(index>-1){
            String[] dato = Clases.Cola_Pendientes.getData(index);
            if(dato[6].equals("CANCELADO")){
                Clases.Cola_Pendientes.remove(index);
            }else{
                dato[6] = estado;
                Clases.Cola_Pendientes.setData(index, dato);
            }
            this.RenderTable();
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar un pendiente para cambiar su estado.", "¡Acción no valida!",WIDTH, error);
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

        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JToggleButton();
        btnCancelado = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_AREA = new javax.swing.JTable();
        btnVolver = new javax.swing.JToggleButton();
        btnTerminado = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabajos Pendientes [Cola]");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID DEL DATO A BUSCAR:");

        txtBuscar.setBackground(new java.awt.Color(0, 102, 102));
        txtBuscar.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnInsertar.setBackground(new java.awt.Color(0, 102, 102));
        btnInsertar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnInsertar.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertar.setText("INSERTAR");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnCancelado.setBackground(new java.awt.Color(0, 102, 102));
        btnCancelado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelado.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelado.setText("CANCELADO");
        btnCancelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanceladoActionPerformed(evt);
            }
        });

        TBL_AREA.setBackground(new java.awt.Color(204, 255, 255));
        TBL_AREA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descripción", "Prioridad", "Proveedor", "Costo", "Razon Social", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TBL_AREA);

        btnVolver.setBackground(new java.awt.Color(0, 102, 102));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnTerminado.setBackground(new java.awt.Color(0, 102, 102));
        btnTerminado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTerminado.setForeground(new java.awt.Color(255, 255, 255));
        btnTerminado.setText("TERMINADO");
        btnTerminado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminadoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MARCAR COMO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertar)
                        .addGap(309, 309, 309)))
                .addGap(0, 39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelado)
                        .addGap(18, 18, 18)
                        .addComponent(btnTerminado))
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(272, 272, 272))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelado)
                    .addComponent(btnTerminado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnInsertar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // Insertar a la Pila
        if(Clases.Cola_Pendientes.isFull())
            JOptionPane.showMessageDialog(null, "Ya se alcanzó el número máximo de pendientes...","Acción no válida", WIDTH, error);
        else{
            InsertarCola IC= new InsertarCola();
            IC.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Clases.data.updateElements(Clases.Cola_Pendientes.getTerminados());
        this.setVisible(false);
        Inicio view = new Inicio();
        C_Inicio ctrl = new C_Inicio(view);
        ctrl.Iniciar();
        view.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCanceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanceladoActionPerformed
        // Eliminar de la Pila
        final int index = TBL_AREA.getSelectedRow();
        System.out.println("FILA SELECCIONADA -> "+index);
        this.editRow(index, "CANCELADO");
        btnCancelado.setSelected(false);
    }//GEN-LAST:event_btnCanceladoActionPerformed

    private void btnTerminadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminadoActionPerformed
        //Mostrar los datos de la Pila
        final int index = TBL_AREA.getSelectedRow();
        System.out.println("FILA SELECCIONADA -> "+index);
        this.editRow(index, "TERMINADO");
        btnTerminado.setSelected(false);
    }//GEN-LAST:event_btnTerminadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Cola().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBL_AREA;
    private javax.swing.JToggleButton btnCancelado;
    private javax.swing.JToggleButton btnInsertar;
    private javax.swing.JToggleButton btnTerminado;
    private javax.swing.JToggleButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}