package assgm.manager.finance;

import assgm.LoginPage;
import assgm.manager.General;


public class FinanceManagerUI extends javax.swing.JFrame {
    private LoginPage lp;
    public FinanceManagerUI(LoginPage lp) {
        initComponents();
        this.lp=lp;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ApproveBtn = new javax.swing.JButton();
        PaymentBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        HistoryBtn = new javax.swing.JButton();
        LogOutBtn = new javax.swing.JButton();
        MoreBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ApproveBtn.setText("Approve PO UI");
        ApproveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveBtnActionPerformed(evt);
            }
        });

        PaymentBtn.setText("Update PO Payment Status UI");
        PaymentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentBtnActionPerformed(evt);
            }
        });

        HistoryBtn.setText("Supplier Payment History");
        HistoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryBtnActionPerformed(evt);
            }
        });

        LogOutBtn.setText("LogOut");
        LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBtnActionPerformed(evt);
            }
        });

        MoreBtn.setText("More...");
        MoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoreBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PaymentBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ApproveBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LogOutBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HistoryBtn)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addComponent(MoreBtn)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ApproveBtn)
                        .addGap(28, 28, 28)
                        .addComponent(PaymentBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(HistoryBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LogOutBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MoreBtn)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HistoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryBtnActionPerformed
        SupplierPaymentHistory sph = new SupplierPaymentHistory(lp);
        sph.setVisible(true);
    }//GEN-LAST:event_HistoryBtnActionPerformed

    private void ApproveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApproveBtnActionPerformed
        ApprovalPurchaseOrder app = new ApprovalPurchaseOrder(lp);
        app.setVisible(true);
    }//GEN-LAST:event_ApproveBtnActionPerformed

    private void PaymentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentBtnActionPerformed
        PurchaseOrderPaymentStatus ps = new PurchaseOrderPaymentStatus(lp);
        ps.setVisible(true);
    }//GEN-LAST:event_PaymentBtnActionPerformed

    private void LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_LogOutBtnActionPerformed

    private void MoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoreBtnActionPerformed
        General more = new General (lp);
        more.setVisible(true);
    }//GEN-LAST:event_MoreBtnActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApproveBtn;
    private javax.swing.JButton HistoryBtn;
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JButton MoreBtn;
    private javax.swing.JButton PaymentBtn;
    private javax.swing.JLabel jLabel11;
    // End of variables declaration//GEN-END:variables
}
