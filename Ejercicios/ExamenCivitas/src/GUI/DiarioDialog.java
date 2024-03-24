/**
 * @file DiarioDialog.java
 * @author Yeray Lopez Ramirez
 * @author Jaime Castillo Ucles
 * @date Diciembre de 2021
 */
package GUI;

import civitas.Diario;

/**
 *
 * @author yerasito
 */
public class DiarioDialog extends javax.swing.JDialog {
    Diario diario = Diario.getInstance();
    /**
     * Creates new form DiarioDialog
     * @param parent
     */
    public DiarioDialog(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(null);
        String eventosP = "";
        while(diario.eventosPendientes())
            eventosP += diario.leerEvento() + "\n";
        eventos.setText(String.join("\n.",eventosP));
        setVisible(true);
        
        repaint();
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eventosLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventos = new javax.swing.JTextArea();
        okBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eventosLabel.setText("Eventos:");
        getContentPane().add(eventosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        eventos.setEditable(false);
        eventos.setColumns(20);
        eventos.setRows(5);
        jScrollPane1.setViewportView(eventos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 41, 620, 200));

        okBoton.setText("OK");
        okBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBotonActionPerformed(evt);
            }
        });
        getContentPane().add(okBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBotonActionPerformed
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_okBotonActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiarioDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DiarioDialog dialog = new DiarioDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea eventos;
    private javax.swing.JLabel eventosLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okBoton;
    // End of variables declaration//GEN-END:variables
}
