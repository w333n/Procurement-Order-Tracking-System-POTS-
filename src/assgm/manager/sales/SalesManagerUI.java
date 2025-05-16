package assgm.manager.sales;

import assgm.LoginPage;
import assgm.manager.General;
import assgm.manager.ViewPurchaseRequisitions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class SalesManagerUI extends javax.swing.JFrame {
    private LoginPage lp;
    
    public SalesManagerUI(LoginPage lp) {
        initComponents();
        this.lp = lp;
    } 

    public SalesManagerUI() {
    }
     
    public void GetItemsInList(DefaultListModel List) {
        File file = new File("documents/ItemEntry.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if(line.startsWith("UserID") || line.startsWith("Role") || line.startsWith("Created At" )|| line.startsWith("Updated") || line.trim().isEmpty()){
                        continue;
                    }

                    String[] columns = line.split(","); 
                    if (columns.length > 0) { 
                        String itemCode = columns[0];
                        List.addElement(itemCode);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(SalesManagerUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("File does not exist: " + file.getAbsolutePath());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        DSUI = new javax.swing.JButton();
        SalesReportUI = new javax.swing.JButton();
        PRUI = new javax.swing.JButton();
        MoreBtn = new javax.swing.JButton();
        ViewPR = new javax.swing.JButton();
        LogOutBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DSUI.setText("Daily Sales UI");
        DSUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DSUIActionPerformed(evt);
            }
        });

        SalesReportUI.setText("Sales Report UI");
        SalesReportUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesReportUIActionPerformed(evt);
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

        ViewPR.setText("View PR");
        ViewPR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewPRActionPerformed(evt);
            }
        });

        LogOutBtn.setText("LogOut");
        LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBtnActionPerformed(evt);
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
                        .addComponent(PRUI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(ViewPR))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SalesReportUI)
                            .addComponent(DSUI))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MoreBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LogOutBtn, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PRUI)
                    .addComponent(ViewPR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MoreBtn)
                .addGap(13, 13, 13)
                .addComponent(DSUI)
                .addGap(18, 18, 18)
                .addComponent(SalesReportUI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogOutBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DSUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DSUIActionPerformed
        DailySales ds = new DailySales(lp);
        ds.setVisible(true);
    }//GEN-LAST:event_DSUIActionPerformed

    private void SalesReportUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesReportUIActionPerformed
        SalesReport sr = new SalesReport();
        sr.setVisible(true);
    }//GEN-LAST:event_SalesReportUIActionPerformed

    private void PRUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRUIActionPerformed
        PurchaseRequisition pr = new PurchaseRequisition(lp);
        pr.setVisible(true);
    }//GEN-LAST:event_PRUIActionPerformed

    private void MoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoreBtnActionPerformed
        General n = new General(lp);
        n.setVisible(true);
    }//GEN-LAST:event_MoreBtnActionPerformed

    private void ViewPRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewPRActionPerformed
        ViewPurchaseRequisitions vpr = new ViewPurchaseRequisitions();
        vpr.setVisible(true);
    }//GEN-LAST:event_ViewPRActionPerformed

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
    private javax.swing.JButton DSUI;
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JButton MoreBtn;
    private javax.swing.JButton PRUI;
    private javax.swing.JButton SalesReportUI;
    private javax.swing.JButton ViewPR;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
