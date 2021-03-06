/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizioesame;

import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tss
 */
public class WinGestioneNegozio extends javax.swing.JFrame {

    private static ArrayList<Prodotto> listaprodotti = new ArrayList<Prodotto>();

    /**
     * Creates new form WinGestioneNegozio
     */
    public WinGestioneNegozio() {
        initComponents();
        caricaProdotto();
        refreshListaProdotti();

    }

    public static void addProdotto(Prodotto a) {
        listaprodotti.add(a);
    }

    public static void salvaProdotto() {
        String testoDisplay = "idProdotto;nome;prezzo;quantitaProdotto\n";
        for (int i = 0; i < listaprodotti.size(); i++) {
            // recupero un corso per volta
            Prodotto a = listaprodotti.get(i);
            String info = a.getCSV();
            testoDisplay = testoDisplay + info;
        }
        try {
            // creo file corsi.txt
            FileWriter myWriter = new FileWriter("/home/tss/Negozio/prodotti.csv");
            //ci scrivo dentro testoDisplay
            myWriter.write(testoDisplay);
            // lo chiude se no si blocca
            myWriter.close();

        } catch (Exception e) {

        }
    }

    public void caricaProdotto() {
        try {

            File filecsv = new File("/home/tss/Negozio/prodotti.csv");
            //creo scanner per lelggere una riga per volta
            Scanner lettore = new Scanner(filecsv);
            //estrarre una riga per volta
            int n = 1;
            while (lettore.hasNextLine()) {
                String riga = lettore.nextLine();
                if (n > 1) {
                    String[] dati = riga.split(";");

                    int idProdotto = Integer.parseInt(dati[0]);
                    String nome = dati[1];
                    float prezzo = Float.parseFloat(dati[2]);
                    int quantitaProdotto = Integer.parseInt(dati[3]);
                    Prodotto a = new Prodotto(idProdotto, nome, prezzo, quantitaProdotto);

                    listaprodotti.add(a);

                }
                n++;
            }

            //la riga la taglio in tanti pezzi col ; in un array
            // elmento per lelemnto dell'array lo imposto ad un corso
            //il corso lo aggiungo alla lista 
            //e cosi' via per le altre righe del file'
            //alla fine chiudo il file se no si blocca
        } catch (Exception e) {

        }

    }

    public static int getNewIdProdotto() {
        int newId = 1;
        if (listaprodotti.size() > 0) {
            newId = listaprodotti.size() + 1;
        }

        return newId;
    }

    public void refreshListaProdotti() {
        //recuperare la struttura dati della mia tabella come model
        DefaultTableModel model = (DefaultTableModel) tblProdotti.getModel();
        //pulire la tabella dai dati precedenti, setto la dimensione row a 0 
        model.setRowCount(0);
        int ncol = model.getColumnCount();
        Object[] rowData = new Object[4];
        for (Prodotto a : listaprodotti) {
            //assegno ai 3 elementi dell'array il contenuto equivalente di colonne
            rowData[0] = a.getIdProdotto();
            rowData[1] = a.getNome();
            rowData[2] = a.getPrezzo();
            rowData[3] = a.getQuantitaProdotto();
            model.addRow(rowData);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdotti = new javax.swing.JTable();
        btnProdotti = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnVendita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tblProdotti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "PREZZO", "QUANTIT??"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProdotti);

        btnProdotti.setText("Prodotti");
        btnProdotti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdottiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("DejaVu Serif", 1, 36)); // NOI18N
        jLabel1.setText("GESTIONE NEGOZIO");

        btnVendita.setText("Vendita");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProdotti, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(btnVendita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnProdotti, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVendita, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProdottiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdottiActionPerformed
        new WinGestioneProdotto(this, true).setVisible(true);
    }//GEN-LAST:event_btnProdottiActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        refreshListaProdotti();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(WinGestioneNegozio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WinGestioneNegozio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WinGestioneNegozio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WinGestioneNegozio.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WinGestioneNegozio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProdotti;
    private javax.swing.JButton btnVendita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdotti;
    // End of variables declaration//GEN-END:variables
}
