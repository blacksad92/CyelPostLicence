/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Client.ClientResponsable;

/**
 *
 * @author Cy
 */
public class AccueilResponsableFormation extends javax.swing.JFrame {
    
    private ClientResponsable client;
    private int periode;
    private int clik = 0;

    /**
     * Creates new form AccueilResponsableFormation
     */
    public AccueilResponsableFormation() {
        initComponents();
    }

    AccueilResponsableFormation(ClientResponsable client) {
        initComponents();
        this.client = client;
        periode = this.client.getPeriode();
        if(periode == 1 || periode > 2 || clik == 1)
        {
            this.bt_recupererLesCandidatures.setEnabled(false);
        }
        if(periode == 2)
        {
            this.bt_recupererLesCandidatures.setEnabled(true);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_candidatures = new javax.swing.JTable();
        bt_consulterNotes = new javax.swing.JButton();
        bt_choixCandidat = new javax.swing.JButton();
        bt_classerListeAttente = new javax.swing.JButton();
        bt_recupererLesCandidatures = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Accueil Responsable Formation");

        jLabel3.setText("Liste des demandes du Master");

        jTable_candidatures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nom Prenom", "Licence provenance", "Universite provenance", "Etat"
            }
        ));
        jScrollPane1.setViewportView(jTable_candidatures);

        bt_consulterNotes.setText("Consulter Notes Candidat");

        bt_choixCandidat.setText("Admission candidat");

        bt_classerListeAttente.setText("Classer la liste d'attente");

        bt_recupererLesCandidatures.setText("Récupérer les candidatures");
        bt_recupererLesCandidatures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_recupererLesCandidaturesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bt_consulterNotes)
                                .addGap(34, 34, 34)
                                .addComponent(bt_choixCandidat)
                                .addGap(28, 28, 28)
                                .addComponent(bt_classerListeAttente)))
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bt_recupererLesCandidatures, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(bt_recupererLesCandidatures)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_consulterNotes)
                    .addComponent(bt_choixCandidat)
                    .addComponent(bt_classerListeAttente))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_recupererLesCandidaturesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_recupererLesCandidaturesActionPerformed
        clik = 1;
        client.recupererLesCandidatures();
    }//GEN-LAST:event_bt_recupererLesCandidaturesActionPerformed

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
            java.util.logging.Logger.getLogger(AccueilResponsableFormation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccueilResponsableFormation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccueilResponsableFormation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccueilResponsableFormation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccueilResponsableFormation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_choixCandidat;
    private javax.swing.JButton bt_classerListeAttente;
    private javax.swing.JButton bt_consulterNotes;
    private javax.swing.JButton bt_recupererLesCandidatures;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_candidatures;
    // End of variables declaration//GEN-END:variables
}
