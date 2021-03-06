/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.gestionescuola;

import com.mycompany.gestionescuola.entity.Anagrafica;
import com.mycompany.gestionescuola.entity.Corso;
import com.mycompany.gestionescuola.entity.Provincia;
import com.mycompany.gestionescuola.services.AnagraficaService;
import com.mycompany.gestionescuola.services.IscrizioneService;
import java.io.FileWriter;
import java.util.List;
import java.util.Optional;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class WinDialogAnagrafica extends javax.swing.JDialog {

    private AnagraficaService anagraficaService;
    private List<Anagrafica> anagrafiche;
    private IscrizioneService iscrService;
    
    /**
     * Creates new form WinGestioneAnagrafica
     */
    public WinDialogAnagrafica(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.anagraficaService = new AnagraficaService();
        this.iscrService = new IscrizioneService();
        this.setLocationRelativeTo(null);
        refreshLista();
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
        btnClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstAnagrafica = new javax.swing.JList<>();
        lblID = new javax.swing.JLabel();
        txNome = new javax.swing.JTextField();
        txCognome = new javax.swing.JTextField();
        txPv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnConferma = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();
        btnDel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestione Anagrafica");

        btnClose.setText("Chiudi");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lstAnagrafica.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstAnagrafica.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAnagraficaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstAnagrafica);

        jLabel2.setText("Cognome:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Pv:");

        btnConferma.setText("Conferma");
        btnConferma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfermaActionPerformed(evt);
            }
        });

        btnNew.setText("Nuova Anagrafica");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDel.setText("Elimina");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txNome)
                                .addComponent(txCognome, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                .addComponent(txPv))
                            .addContainerGap()))
                    .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnConferma, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txPv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew)
                    .addComponent(btnConferma))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnDel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
                .addComponent(btnClose)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        pulisci();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnConfermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfermaActionPerformed
        // TODO add your handling code here:
        String c = txCognome.getText();
        String n = txNome.getText();
        String pv = txPv.getText();
        Optional<Provincia> optProvincia = anagraficaService.findProvinciaByName(pv);
        if(optProvincia.isEmpty()){
            JOptionPane.showMessageDialog(null, "Provincia non trovata!");
            return;
        }
        Provincia prov = optProvincia.get();
        if (lblID.getText().equals("")) { //caso no id e quindi nuova aggiunta
            Anagrafica a = new Anagrafica(c, n);
            a.setPv(prov);
            anagraficaService.save(a);
        } else { //caso id presente, quindi modifica
            long id = Long.parseLong(lblID.getText());
            Anagrafica toupdate = anagraficaService.find(id);
            toupdate.setCognome(c);
            toupdate.setNome(n);
            toupdate.setPv(prov);
            anagraficaService.save(toupdate);
            //cerco l'indice dell'elemento selezionato in lista che sto modificando
        }
        refreshLista();
        pulisci();
    }//GEN-LAST:event_btnConfermaActionPerformed

    private void lstAnagraficaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAnagraficaValueChanged
        // TODO add your handling code here:
        int index = lstAnagrafica.getSelectedIndex();
        if (index == -1) { //niente di selezionato
            pulisci();
            refreshLista();
            return;
        }
        Anagrafica a = this.anagrafiche.get(index);
        lblID.setText("" + a.getId());
        txCognome.setText(a.getCognome());
        txNome.setText(a.getNome());
        txPv.setText(a.getPv().getPv());
    }//GEN-LAST:event_lstAnagraficaValueChanged

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        // TODO add your handling code here:
        int index = lstAnagrafica.getSelectedIndex();
        if (index == -1) { //niente di selezionato
            return;
        }
        Anagrafica selected = this.anagrafiche.get(index);
        
        boolean ok = iscrService.findByAnagrafica(selected.getId()).isEmpty();

        if (ok) {
            int input = JOptionPane.showConfirmDialog(null,
                    "Confermi l'eliminazione?", "ELIMINA Anagrafica", JOptionPane.OK_CANCEL_OPTION);
            if (input == 0) {
                anagraficaService.remove(selected.getId());
                refreshLista();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Alunno iscritto al corso, impossibile cancellare!");
        }
    }//GEN-LAST:event_btnDelActionPerformed

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
            java.util.logging.Logger.getLogger(WinDialogAnagrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WinDialogAnagrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WinDialogAnagrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WinDialogAnagrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WinDialogAnagrafica dialog = new WinDialogAnagrafica(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnConferma;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JList<String> lstAnagrafica;
    private javax.swing.JTextField txCognome;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txPv;
    // End of variables declaration//GEN-END:variables

    private void pulisci() {
        txCognome.setText("");
        txNome.setText("");
        txPv.setText("");
        lblID.setText("");
    }

    private void refreshLista() {
        DefaultListModel model = new DefaultListModel();
        this.anagrafiche = anagraficaService.all();
        this.anagrafiche.forEach(model::addElement);
        lstAnagrafica.setModel(model);
    }
}
