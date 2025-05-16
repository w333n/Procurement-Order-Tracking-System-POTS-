package assgm.manager.inventory;
import assgm.LoginPage;
import assgm.manager.General;
import assgm.manager.ViewItemEntry;
import assgm.manager.ViewStockLevels;
import assgm.manager.ViewSupplierEntry;

public class InventoryManagerUI extends javax.swing.JFrame {
    private LoginPage lp;
    public InventoryManagerUI(LoginPage lp) {
        this.lp = lp;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MoreBtn = new javax.swing.JButton();
        EnterItemBtn = new javax.swing.JButton();
        EnterSupplierBtn = new javax.swing.JButton();
        UpdateStockLevels = new javax.swing.JButton();
        LogOutBtn = new javax.swing.JButton();
        VSE = new javax.swing.JButton();
        VIE = new javax.swing.JButton();
        VSL = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MoreBtn.setText("More...");
        MoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoreBtnActionPerformed(evt);
            }
        });

        EnterItemBtn.setText("Enter Item");
        EnterItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterItemBtnActionPerformed(evt);
            }
        });

        EnterSupplierBtn.setText("Enter Supplier");
        EnterSupplierBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterSupplierBtnActionPerformed(evt);
            }
        });

        UpdateStockLevels.setText("Update Stock Levels");
        UpdateStockLevels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateStockLevelsActionPerformed(evt);
            }
        });

        LogOutBtn.setText("LogOut");
        LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBtnActionPerformed(evt);
            }
        });

        VSE.setText("View Supplier Entry");
        VSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VSEActionPerformed(evt);
            }
        });

        VIE.setText("View Item Entry");
        VIE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VIEActionPerformed(evt);
            }
        });

        VSL.setText("View Stock Levels");
        VSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VSLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LogOutBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MoreBtn, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VSE)
                            .addComponent(UpdateStockLevels)
                            .addComponent(VIE)
                            .addComponent(EnterSupplierBtn)
                            .addComponent(EnterItemBtn)
                            .addComponent(VSL))
                        .addGap(0, 174, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogOutBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(MoreBtn)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EnterItemBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EnterSupplierBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UpdateStockLevels)
                        .addGap(31, 31, 31)
                        .addComponent(VIE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(VSE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(VSL)
                        .addGap(0, 49, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnterItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterItemBtnActionPerformed
        EnterItem eiui = new EnterItem(lp);
        eiui.setVisible(true);
    }//GEN-LAST:event_EnterItemBtnActionPerformed

    private void EnterSupplierBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterSupplierBtnActionPerformed
        EnterSupplier esui = new EnterSupplier(lp);
        esui.setVisible(true);
    }//GEN-LAST:event_EnterSupplierBtnActionPerformed

    private void MoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoreBtnActionPerformed
        General more = new General (lp);
        more.setVisible(true);
    }//GEN-LAST:event_MoreBtnActionPerformed

    private void UpdateStockLevelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateStockLevelsActionPerformed
        UpdateStockLevel usl = new UpdateStockLevel(lp);
        usl.setVisible(true);
    }//GEN-LAST:event_UpdateStockLevelsActionPerformed

    private void VSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VSEActionPerformed
        ViewSupplierEntry vie = new ViewSupplierEntry();
        vie.setVisible(true);
    }//GEN-LAST:event_VSEActionPerformed

    private void VIEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VIEActionPerformed
        ViewItemEntry vie = new ViewItemEntry();
        vie.setVisible(true);
    }//GEN-LAST:event_VIEActionPerformed

    private void VSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VSLActionPerformed
        ViewStockLevels vst = new ViewStockLevels();
        vst.setVisible(true);
    }//GEN-LAST:event_VSLActionPerformed

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
    private javax.swing.JButton EnterItemBtn;
    private javax.swing.JButton EnterSupplierBtn;
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JButton MoreBtn;
    private javax.swing.JButton UpdateStockLevels;
    private javax.swing.JButton VIE;
    private javax.swing.JButton VSE;
    private javax.swing.JButton VSL;
    // End of variables declaration//GEN-END:variables

    
}
