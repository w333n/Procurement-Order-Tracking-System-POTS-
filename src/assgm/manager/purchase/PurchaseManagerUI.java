package assgm.manager.purchase;

import assgm.LoginPage;
import assgm.manager.General;
import assgm.manager.ViewPurchaseOrder;
import assgm.manager.sales.PurchaseRequisition;

public class PurchaseManagerUI extends javax.swing.JFrame {
    private LoginPage lp;
    public PurchaseManagerUI(LoginPage lp) {
        initComponents();
        this.lp = lp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        POUI = new javax.swing.JButton();
        PRUI = new javax.swing.JButton();
        MoreBtn = new javax.swing.JButton();
        LogOutBtn = new javax.swing.JButton();
        VPOBtn = new javax.swing.JButton();

        jLabel1.setText("这边有一个more...button是用来show general function的不要动它哈 :3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        POUI.setText("Purchase Order UI");
        POUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POUIActionPerformed(evt);
            }
        });

        PRUI.setText("Purchase Requisition UI");
        PRUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRUIActionPerformed(evt);
            }
        });

        MoreBtn.setText("More...");
        MoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoreBtnActionPerformed(evt);
            }
        });

        LogOutBtn.setText("LogOut");
        LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBtnActionPerformed(evt);
            }
        });

        VPOBtn.setText("View Purchase Orders");
        VPOBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VPOBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MoreBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LogOutBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VPOBtn)
                    .addComponent(PRUI))
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(POUI)
                    .addContainerGap(167, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MoreBtn)
                .addGap(49, 49, 49)
                .addComponent(PRUI)
                .addGap(18, 18, 18)
                .addComponent(VPOBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogOutBtn)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addComponent(POUI)
                    .addContainerGap(133, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void POUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_POUIActionPerformed
        PurchaseOrder po = new PurchaseOrder(lp);
        po.setVisible(true);         
    }//GEN-LAST:event_POUIActionPerformed

    private void PRUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRUIActionPerformed
        PurchaseRequisition pr = new PurchaseRequisition(lp);
        pr.setVisible(true);
    }//GEN-LAST:event_PRUIActionPerformed

    private void VPOBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VPOBtnActionPerformed
        ViewPurchaseOrder vpo = new ViewPurchaseOrder();
        vpo.setVisible(true);
    }//GEN-LAST:event_VPOBtnActionPerformed

    private void MoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoreBtnActionPerformed
        General n = new General(lp);
        n.setVisible(true);
    }//GEN-LAST:event_MoreBtnActionPerformed

    private void LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_LogOutBtnActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JButton MoreBtn;
    private javax.swing.JButton POUI;
    private javax.swing.JButton PRUI;
    private javax.swing.JButton VPOBtn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
