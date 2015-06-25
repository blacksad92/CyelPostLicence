/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Client.ClientResponsable;
import CyelPostLicence.Note;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cy
 */
public class ConsulterNotesCandidat extends javax.swing.JFrame {

    private ClientResponsable client;
    
    /**
     * Creates new form ConsulterNotesCandidat
     */
    public ConsulterNotesCandidat(ClientResponsable client,int INE) {
        initComponents();
        this.client = client;
        
        System.out.println("Affichage des notes de "+INE);
        
        Note[] notes = client.recupererNotesCandidat(INE);
        
        initTableauNotes(notes);
        
        lb_nomCandidat.setText(Integer.toString(INE));
    }
    
    private void initTableauNotes(Note[] notes) {
        jTable_notes.removeAll();
        if(notes != null)
        {
            DefaultTableModel model = new DefaultTableModel();
            //On renseigne les identifiants des colonnes dans le modèle
            model.setColumnIdentifiers(new String[]{ "Semestre","Obtention","Moyenne","Positionnement" });

            //On ajoute les ligne contenant les données dans le modèle
            for (Note n : notes) {
                model.addRow(new Object[]{ n.semestre, n.obtention, n.moyenne, n.position });
            }

            //On ajoute le modèle dans la Jtable
            jTable_notes.setModel(model);
            jTable_notes.setEnabled(true);
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
        lb_nomCandidat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_notes = new javax.swing.JTable();
        bt_fermer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Notes du candidat :");

        lb_nomCandidat.setText("<NOM>");

        jTable_notes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Semestre", "Obtention", "Moyenne", "Positionnnement"
            }
        ));
        jScrollPane1.setViewportView(jTable_notes);

        bt_fermer.setText("Fermer");
        bt_fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_fermerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lb_nomCandidat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bt_fermer)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lb_nomCandidat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_fermer)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_fermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_fermerActionPerformed
        AccueilResponsableFormation accueil = new AccueilResponsableFormation(client);
        accueil.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_fermerActionPerformed

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
            java.util.logging.Logger.getLogger(ConsulterNotesCandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsulterNotesCandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsulterNotesCandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsulterNotesCandidat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsulterNotesCandidat(null,0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_fermer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_notes;
    private javax.swing.JLabel lb_nomCandidat;
    // End of variables declaration//GEN-END:variables
}
