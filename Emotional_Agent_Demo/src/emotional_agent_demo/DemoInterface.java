/*
Interface class.
 */
package emotional_agent_demo;

import jade.gui.GuiEvent;

/**
 *
 * @author Mara Pudane
 */
public class DemoInterface extends javax.swing.JFrame {
private GUIAgentDemo myAgent;
    /**
     * Creates new form GUIAgent
     */
    public DemoInterface(GUIAgentDemo a) {
        
         myAgent = a;
       
        initComponents();
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
        jTextField3 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        AngerButt = new javax.swing.JButton();
        DisgustButt = new javax.swing.JButton();
        FearButt = new javax.swing.JButton();
        JoyButt = new javax.swing.JButton();
        SadnessButt = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ImpactField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        RelationshipField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        StatusField = new javax.swing.JTextField();
        AngerImp = new javax.swing.JButton();
        DisgustImp = new javax.swing.JButton();
        FearImp = new javax.swing.JButton();
        JoyImp = new javax.swing.JButton();
        SadnessImp = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jTextField3.setText("jTextField3");

        jTextField8.setText("jTextField8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Emociju skaitļošanas modeļa demonstrācija");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Primārais līmenis"));

        jLabel6.setText("Objektīvais novērtējums:");

        jTextField7.setText("0");

        jButton5.setText("Nolasīt objektīvo novērtējumu!");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Sekundārais līmenis"));

        jLabel7.setText("Objektīvais novērtējums:");

        jTextField10.setText("0");

        AngerButt.setText("Dusmas");
        AngerButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AngerButtActionPerformed(evt);
            }
        });

        DisgustButt.setText("Pretīgums");
        DisgustButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisgustButtActionPerformed(evt);
            }
        });

        FearButt.setText("Bailes");
        FearButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FearButtActionPerformed(evt);
            }
        });

        JoyButt.setText("Prieks");
        JoyButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoyButtActionPerformed(evt);
            }
        });

        SadnessButt.setText("Skumjas");
        SadnessButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SadnessButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AngerButt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DisgustButt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FearButt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JoyButt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SadnessButt)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AngerButt)
                    .addComponent(DisgustButt)
                    .addComponent(FearButt)
                    .addComponent(JoyButt)
                    .addComponent(SadnessButt))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Terciārais līmenis"));

        jLabel4.setText("Objektīvais novērtējums:");

        ImpactField.setText("0.5");

        jLabel8.setText("Attiecību vērtība:");

        RelationshipField.setText("1");
        RelationshipField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelationshipFieldActionPerformed(evt);
            }
        });

        jLabel9.setText("Statusa vērtība:");

        StatusField.setText("1");

        AngerImp.setText("Dusmas");
        AngerImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AngerImpActionPerformed(evt);
            }
        });

        DisgustImp.setText("Pretīgums");
        DisgustImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisgustImpActionPerformed(evt);
            }
        });

        FearImp.setText("Bailes");
        FearImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FearImpActionPerformed(evt);
            }
        });

        JoyImp.setText("Prieks");
        JoyImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoyImpActionPerformed(evt);
            }
        });

        SadnessImp.setText("Skumjas");
        SadnessImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SadnessImpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ImpactField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RelationshipField, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(StatusField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(AngerImp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DisgustImp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(FearImp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JoyImp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SadnessImp)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ImpactField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(RelationshipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(StatusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AngerImp)
                    .addComponent(DisgustImp)
                    .addComponent(FearImp)
                    .addComponent(JoyImp)
                    .addComponent(SadnessImp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AngerButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AngerButtActionPerformed
         GuiEvent ge = new GuiEvent(this, 1);
        String Emo = "anger";
        Double Reeval = Double.parseDouble(jTextField10.getText());
        ge.addParameter((Object) Reeval);
        ge.addParameter((Object) Emo);
        myAgent.postGuiEvent(ge);
   
    }//GEN-LAST:event_AngerButtActionPerformed

    private void JoyButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoyButtActionPerformed
        
         GuiEvent ge = new GuiEvent(this, 1);
        String Emo = "joy";
        Double Reeval = Double.parseDouble(jTextField10.getText());
        ge.addParameter((Object) Reeval);
        ge.addParameter((Object) Emo);
        myAgent.postGuiEvent(ge);
       
    }//GEN-LAST:event_JoyButtActionPerformed

    private void RelationshipFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelationshipFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RelationshipFieldActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        GuiEvent ge = new GuiEvent(this, 0);
        Double Primitive = Double.parseDouble(jTextField7.getText());
        ge.addParameter((Object) Primitive);
        myAgent.postGuiEvent(ge);      
   
    }//GEN-LAST:event_jButton5ActionPerformed

    private void DisgustButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisgustButtActionPerformed
         GuiEvent ge = new GuiEvent(this, 1);
        String Emo = "disgust";
        Double Reeval = Double.parseDouble(jTextField10.getText());
        ge.addParameter((Object) Reeval);
        ge.addParameter((Object) Emo);
        myAgent.postGuiEvent(ge);
          
    }//GEN-LAST:event_DisgustButtActionPerformed

    private void FearButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FearButtActionPerformed
         GuiEvent ge = new GuiEvent(this, 1);
        
        Double Reeval = Double.parseDouble(jTextField10.getText());
        String Emo = "fear";
        ge.addParameter((Object) Reeval);
        ge.addParameter((Object) Emo);
        myAgent.postGuiEvent(ge);
    }//GEN-LAST:event_FearButtActionPerformed

    private void SadnessButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SadnessButtActionPerformed
      GuiEvent ge = new GuiEvent(this, 1);
        Double Reeval = Double.parseDouble(jTextField10.getText());
        String Emo = "sadness";
        ge.addParameter((Object) Reeval);
        ge.addParameter((Object) Emo);
        myAgent.postGuiEvent(ge);    
    }//GEN-LAST:event_SadnessButtActionPerformed

    private void JoyImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoyImpActionPerformed
        GuiEvent ge = new GuiEvent(this, 2);
        String TEmo = "joy";
        Double Impact = Double.parseDouble(ImpactField.getText());
        Double Relationship = Double.parseDouble(RelationshipField.getText());
        Double Status = Double.parseDouble(StatusField.getText());
        ge.addParameter((Object) Impact);
        ge.addParameter((Object) Relationship);
        ge.addParameter((Object) Status);
        ge.addParameter((Object) TEmo);
        myAgent.postGuiEvent(ge);    
    
    }//GEN-LAST:event_JoyImpActionPerformed

    private void AngerImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AngerImpActionPerformed
                GuiEvent ge = new GuiEvent(this, 2);
        String TEmo = "anger";
        Double Impact = Double.parseDouble(ImpactField.getText());
        Double Relationship = Double.parseDouble(RelationshipField.getText());
        Double Status = Double.parseDouble(StatusField.getText());
        ge.addParameter((Object) Impact);
        ge.addParameter((Object) Relationship);
        ge.addParameter((Object) Status);
        ge.addParameter((Object) TEmo);
        myAgent.postGuiEvent(ge);    
    }//GEN-LAST:event_AngerImpActionPerformed

    private void FearImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FearImpActionPerformed
        GuiEvent ge = new GuiEvent(this, 2);
        String TEmo = "fear";
        Double Impact = Double.parseDouble(ImpactField.getText());
        Double Relationship = Double.parseDouble(RelationshipField.getText());
        Double Status = Double.parseDouble(StatusField.getText());
        ge.addParameter((Object) Impact);
        ge.addParameter((Object) Relationship);
        ge.addParameter((Object) Status);
        ge.addParameter((Object) TEmo);
        myAgent.postGuiEvent(ge);            // TODO add your handling code here:
    }//GEN-LAST:event_FearImpActionPerformed

    private void DisgustImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisgustImpActionPerformed
        GuiEvent ge = new GuiEvent(this, 2);
        String TEmo = "disgust";
        Double Impact = Double.parseDouble(ImpactField.getText());
        Double Relationship = Double.parseDouble(RelationshipField.getText());
        Double Status = Double.parseDouble(StatusField.getText());
        ge.addParameter((Object) Impact);
        ge.addParameter((Object) Relationship);
        ge.addParameter((Object) Status);
        ge.addParameter((Object) TEmo);
        myAgent.postGuiEvent(ge);            // TODO add your handling code here:
    }//GEN-LAST:event_DisgustImpActionPerformed

    private void SadnessImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SadnessImpActionPerformed
                GuiEvent ge = new GuiEvent(this, 2);
        String TEmo = "sadness";
        Double Impact = Double.parseDouble(ImpactField.getText());
        Double Relationship = Double.parseDouble(RelationshipField.getText());
        Double Status = Double.parseDouble(StatusField.getText());
        ge.addParameter((Object) Impact);
        ge.addParameter((Object) Relationship);
        ge.addParameter((Object) Status);
        ge.addParameter((Object) TEmo);
        myAgent.postGuiEvent(ge);    
        // TODO add your handling code here:
    }//GEN-LAST:event_SadnessImpActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DemoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DemoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DemoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DemoInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new DemoInterface(myAgent).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AngerButt;
    private javax.swing.JButton AngerImp;
    private javax.swing.JButton DisgustButt;
    private javax.swing.JButton DisgustImp;
    private javax.swing.JButton FearButt;
    private javax.swing.JButton FearImp;
    private javax.swing.JTextField ImpactField;
    private javax.swing.JButton JoyButt;
    private javax.swing.JButton JoyImp;
    private javax.swing.JTextField RelationshipField;
    private javax.swing.JButton SadnessButt;
    private javax.swing.JButton SadnessImp;
    private javax.swing.JTextField StatusField;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
