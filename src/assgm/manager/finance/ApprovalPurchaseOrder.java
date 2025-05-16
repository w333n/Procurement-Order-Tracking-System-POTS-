package assgm.manager.finance;

import assgm.LoginPage;
import assgm.document.GeneralFunction;
import assgm.manager.ViewPurchaseOrder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ApprovalPurchaseOrder extends javax.swing.JFrame {
    private LoginPage lp;
    private GeneralFunction gf;
    private DefaultListModel<String> ApprovedListModel = new DefaultListModel();
    private DefaultListModel<String> WaitingListModel = new DefaultListModel();
    private DefaultListModel<String> RejectedListModel = new DefaultListModel();
    
    public ApprovalPurchaseOrder(LoginPage lp) {
        this.lp = lp;
        this.gf = new GeneralFunction();
        initComponents();
        gf.ListloadFiles(ApprovedListModel, "^Approved.*", WaitingListModel, "^Waiting.*");
        gf.ListloadFiles(RejectedListModel, "^Rejected.*", RejectedListModel, "^Rejected.*");
        // Add double-click functionality
        addDoubleClickListener(ApprovedList);
        addDoubleClickListener(WaitingList);
        addDoubleClickListener(RejectedList);
    }
    
    private void addDoubleClickListener(JList<String> list) {
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
                    viewSelectedFile(list);
                }
            }
        });
    }
    
    //view file function
    private void viewSelectedFile(JList<String> list) {
         String selectedItem = list.getSelectedValue();
        if (selectedItem != null) {
            new ViewPurchaseOrder(selectedItem,list).setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "No item selected.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ApprovalStatusCB = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UpdateBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        WaitingList = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        ApprovedList = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        RejectedList = new javax.swing.JList<>();
        RefreshBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ApprovalStatusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Approve", "Reject", "Waiting" }));

        jLabel1.setText("PO - Approved");

        jLabel2.setText("PO - Waiting");

        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("PO - Rejected");

        WaitingList.setModel(WaitingListModel);
        jScrollPane4.setViewportView(WaitingList);

        ApprovedList.setModel(ApprovedListModel);
        jScrollPane5.setViewportView(ApprovedList);

        RejectedList.setModel(RejectedListModel);
        jScrollPane6.setViewportView(RejectedList);

        RefreshBtn.setText("Refresh");
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(ApprovalStatusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(UpdateBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CancelBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(156, 156, 156)
                                .addComponent(jLabel2)))
                        .addGap(94, 94, 94)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RefreshBtn))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApprovalStatusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateBtn)
                    .addComponent(CancelBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RefreshBtn)
                        .addGap(136, 136, 136))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        int index2 = WaitingList.getSelectedIndex();
        Object obApprovalStatus = ApprovalStatusCB.getSelectedItem();
        String ApprovalStatus = obApprovalStatus.toString();
        if (index2 != -1 && "Approve".equals(ApprovalStatus)) { 
            try {
                GeneralFunction gf2 = new GeneralFunction(lp);
                gf2.updateFileInfo("", WaitingList);
                JOptionPane.showMessageDialog(this,"Document updated sucessfully.");
            } catch (IOException ex) {
                Logger.getLogger(ApprovalPurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
            gf.updateFileName(WaitingList, "Waiting", "Approved");   
        }else if (index2 != -1 && "Reject".equals(ApprovalStatus)) { 
            try {
                GeneralFunction gf2 = new GeneralFunction();
                gf2.updateFileInfo("", WaitingList);
                JOptionPane.showMessageDialog(this,"Document updated sucessfully.");
            } catch (IOException ex) {
                Logger.getLogger(PurchaseOrderPaymentStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
            gf.updateFileName(WaitingList, "Waiting", "Rejected");   
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        gf.ListloadFiles(ApprovedListModel, "^Approved.*", WaitingListModel, "^Waiting.*");
        gf.ListloadFiles(RejectedListModel, "^Rejected.*", RejectedListModel, "^Rejected.*");
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_CancelBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ApprovalStatusCB;
    private javax.swing.JList<String> ApprovedList;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JList<String> RejectedList;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JList<String> WaitingList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
