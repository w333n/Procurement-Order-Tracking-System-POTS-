package assgm.manager;

public class ViewFile extends javax.swing.JFrame {

    public ViewFile() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton8 = new javax.swing.JButton();
        VPR = new javax.swing.JButton();
        VPOBtn = new javax.swing.JButton();
        VSL = new javax.swing.JButton();
        VIE = new javax.swing.JButton();
        VSE = new javax.swing.JButton();
        VDSBtn = new javax.swing.JButton();
        ViewSalesReportBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();

        jButton8.setText("View Sales Report");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VPR.setText("View Purchase Requisitions");
        VPR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VPRActionPerformed(evt);
            }
        });

        VPOBtn.setText("View Purchase Orders");
        VPOBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VPOBtnActionPerformed(evt);
            }
        });

        VSL.setText("View Stock Levels");
        VSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VSLActionPerformed(evt);
            }
        });

        VIE.setText("View Item Entry");
        VIE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEActionPerformed(evt);
            }
        });

        VSE.setText("View Supplier Entry");
        VSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VSEActionPerformed(evt);
            }
        });

        VDSBtn.setText("View Daily Sales");
        VDSBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VDSBtnActionPerformed(evt);
            }
        });

        ViewSalesReportBtn.setText("View Sales Report");
        ViewSalesReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewSalesReportBtnActionPerformed(evt);
            }
        });

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ViewSalesReportBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                        .addComponent(BackBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VPR)
                            .addComponent(VPOBtn)
                            .addComponent(VSL)
                            .addComponent(VIE)
                            .addComponent(VSE)
                            .addComponent(VDSBtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VPR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VPOBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VSL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VIE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VSE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VDSBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewSalesReportBtn)
                    .addComponent(BackBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VDSBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VDSBtnActionPerformed
        ViewDailySales vds = new ViewDailySales();
        vds.setVisible(true);
    }//GEN-LAST:event_VDSBtnActionPerformed

    private void ViewSalesReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewSalesReportBtnActionPerformed
        ViewSalesReport vsr = new ViewSalesReport();
        vsr.setVisible(true);
    }//GEN-LAST:event_ViewSalesReportBtnActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void VIEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEActionPerformed
        ViewItemEntry vie = new ViewItemEntry();
        vie.setVisible(true);
    }//GEN-LAST:event_VIEActionPerformed

    private void VSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VSLActionPerformed
        ViewStockLevels vst = new ViewStockLevels();
        vst.setVisible(true);
    }//GEN-LAST:event_VSLActionPerformed

    private void VSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VSEActionPerformed
        ViewSupplierEntry vie = new ViewSupplierEntry();
        vie.setVisible(true);
    }//GEN-LAST:event_VSEActionPerformed

    private void VPRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VPRActionPerformed
        ViewPurchaseRequisitions vpr = new ViewPurchaseRequisitions();
        vpr.setVisible(true);
    }//GEN-LAST:event_VPRActionPerformed

    private void VPOBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VPOBtnActionPerformed
        ViewPurchaseOrder vpo = new ViewPurchaseOrder();
        vpo.setVisible(true);
    }//GEN-LAST:event_VPOBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton VDSBtn;
    private javax.swing.JButton VIE;
    private javax.swing.JButton VPOBtn;
    private javax.swing.JButton VPR;
    private javax.swing.JButton VSE;
    private javax.swing.JButton VSL;
    private javax.swing.JButton ViewSalesReportBtn;
    private javax.swing.JButton jButton8;
    // End of variables declaration//GEN-END:variables
}
