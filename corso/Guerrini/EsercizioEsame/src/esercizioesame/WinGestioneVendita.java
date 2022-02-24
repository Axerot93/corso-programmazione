/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizioesame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tss
 */
public class WinGestioneVendita extends javax.swing.JDialog {

    Prodotto prodottovendita;
    float iva = 0.2f;
    float prezzofinale;
    LocalDate data;
    
    /**
     * Creates new form WinGestioneVendita
     */
    public WinGestioneVendita(java.awt.Frame parent, boolean modal, Prodotto prodotto) {
        super(parent, modal);
        initComponents();
        
        prodottovendita = prodotto;
        lblprodotto1.setText(prodottovendita.getNome());
        lblIva1.setText(String.valueOf(iva));
        DateTimeFormatter ddmmaa= DateTimeFormatter.ofPattern("dd/MM/yy");
        lblData1.setText(LocalDateTime.now().format(ddmmaa));
        lblPrezzoFinale1.setText(String.valueOf(prezzofinale));
        txQuantitaVenduta.setText(String.valueOf(prodottovendita.getQuantitaProdotto()));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProdotto = new javax.swing.JLabel();
        lblIva = new javax.swing.JLabel();
        lblPrezzoFinale = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblQuantitaVenduta = new javax.swing.JLabel();
        lblprodotto1 = new javax.swing.JLabel();
        lblIva1 = new javax.swing.JLabel();
        lblPrezzoFinale1 = new javax.swing.JLabel();
        lblData1 = new javax.swing.JLabel();
        btnVendi = new javax.swing.JButton();
        txQuantitaVenduta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblProdotto.setText("Prodotto:");

        lblIva.setText("Iva:");

        lblPrezzoFinale.setText("Prezzo finale:");

        lblData.setText("Data:");

        lblQuantitaVenduta.setText("Quantità venduta:");

        lblprodotto1.setText("jLabel1");

        lblIva1.setText("jLabel1");

        lblPrezzoFinale1.setText("jLabel1");

        lblData1.setText("jLabel1");

        btnVendi.setText("VENDI");
        btnVendi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPrezzoFinale, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblData)
                                .addGap(141, 141, 141)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                        .addComponent(btnVendi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProdotto)
                                .addGap(69, 69, 69)
                                .addComponent(lblprodotto1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txQuantitaVenduta, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblQuantitaVenduta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblData1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblIva)
                                    .addGap(107, 107, 107)
                                    .addComponent(lblIva1))
                                .addComponent(lblPrezzoFinale1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblProdotto)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblprodotto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVendi, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblIva1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblData)
                            .addComponent(lblData1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPrezzoFinale)
                            .addComponent(lblPrezzoFinale1))))
                .addGap(47, 47, 47)
                .addComponent(lblQuantitaVenduta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txQuantitaVenduta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVendiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendiActionPerformed
        //Prendere tutti info dell frame per creare un prodotto
        //Prodotto a= new Prodotto(WIDTH, nome, TOP_ALIGNMENT, WIDTH)
        //usare prodottovendita
        
        //prendere valore piu iva per calcolare valore finale
        
        //Scontrino scontrino= new Scontrino(prodotto, TOP_ALIGNMENT, TOP_ALIGNMENT, LocalDateTime.MAX, WIDTH);
        
    }//GEN-LAST:event_btnVendiActionPerformed

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
            java.util.logging.Logger.getLogger(WinGestioneVendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WinGestioneVendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WinGestioneVendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WinGestioneVendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WinGestioneVendita dialog = new WinGestioneVendita(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnVendi;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblData1;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblIva1;
    private javax.swing.JLabel lblPrezzoFinale;
    private javax.swing.JLabel lblPrezzoFinale1;
    private javax.swing.JLabel lblProdotto;
    private javax.swing.JLabel lblQuantitaVenduta;
    private javax.swing.JLabel lblprodotto1;
    private javax.swing.JTextField txQuantitaVenduta;
    // End of variables declaration//GEN-END:variables
}
