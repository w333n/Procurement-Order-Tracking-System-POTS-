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

public class PurchaseOrderPaymentStatus extends javax.swing.JFrame {
    private LoginPage lp;
    private GeneralFunction gf;
    private DefaultListModel<String> NotPaidListModel = new DefaultListModel();
    private DefaultListModel<String> PaidListModel = new DefaultListModel();
    private DefaultListModel<String> ProcessingListModel = new DefaultListModel();
    public PurchaseOrderPaymentStatus(LoginPage lp) {
        this.lp=lp;
        this.gf = new GeneralFunction();
        initComponents();
        gf.ListloadFiles(NotPaidListModel,"^Approved.*", PaidListModel, "^Paid.*");
        gf.ListloadFiles(ProcessingListModel,"^Processing.*", ProcessingListModel, "^Processing.*");
        // Add double-click functionality
        addDoubleClickListener(NotPaidList);
        addDoubleClickListener(PaidList);
        addDoubleClickListener(ProcessingList);
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

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        PaymentStatusCB = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UpdateBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ProcessingList = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        PaidList = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        NotPaidList = new javax.swing.JList<>();
        RefreshBtn = new javax.swing.JButton();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel3.setText("PO - Not Paid");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PaymentStatusCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid", "Not Paid", "Processing" }));
        PaymentStatusCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentStatusCBActionPerformed(evt);
            }
        });

        jLabel1.setText("PO - Not Paid (Just Approved)");

        jLabel2.setText("PO - Processing");

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

        jLabel4.setText("PO - Paid");

        ProcessingList.setModel(ProcessingListModel);
        jScrollPane5.setViewportView(ProcessingList);

        PaidList.setModel(PaidListModel);
        jScrollPane6.setViewportView(PaidList);

        NotPaidList.setModel(NotPaidListModel);
        NotPaidList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                NotPaidListMouseReleased(evt);
            }
        });
        jScrollPane7.setViewportView(NotPaidList);

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
                        .addGap(149, 149, 149)
                        .addComponent(PaymentStatusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(UpdateBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CancelBtn))))
                            .addComponent(RefreshBtn))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaymentStatusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateBtn)
                    .addComponent(CancelBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RefreshBtn)
                .addGap(84, 84, 84))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        int index1 = NotPaidList.getSelectedIndex();
        int index3 = ProcessingList.getSelectedIndex();
        Object obPaymentStatus = PaymentStatusCB.getSelectedItem();
        String PaymentStatus = obPaymentStatus.toString();
        if (index1 != -1 && "Processing".equals(PaymentStatus)) { 
            try {
                GeneralFunction gf2 = new GeneralFunction(lp);
                gf2.updateFileInfo("", NotPaidList);
                JOptionPane.showMessageDialog(this,"Document updated sucessfully.");
            } catch (IOException ex) {
                Logger.getLogger(PurchaseOrderPaymentStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
            gf.updateFileName(NotPaidList, "Approved", "Processing");   
        }else if (index1 != -1 && "Paid".equals(PaymentStatus)){
            try {
                GeneralFunction gf2 = new GeneralFunction(lp);
                gf2.updateFileInfo("", NotPaidList);
                JOptionPane.showMessageDialog(this,"Document updated sucessfully.");
            } catch (IOException ex) {
                Logger.getLogger(PurchaseOrderPaymentStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
            gf.updateFileName(NotPaidList, "Approved", "Paid");  
        }else  if (index3 != -1 && "Paid".equals(PaymentStatus)) { 
            try {
                GeneralFunction gf2 = new GeneralFunction(lp);
                gf2.updateFileInfo("", ProcessingList);
                JOptionPane.showMessageDialog(this,"Document updated sucessfully.");
            } catch (IOException ex) {
                Logger.getLogger(PurchaseOrderPaymentStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
            gf.updateFileName(ProcessingList, "Processing", "Paid");
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void PaymentStatusCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentStatusCBActionPerformed

    }//GEN-LAST:event_PaymentStatusCBActionPerformed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        gf.ListloadFiles(NotPaidListModel,"^NotPaid.*", PaidListModel, "^Paid.*");
        gf.ListloadFiles(ProcessingListModel,"^Processing.*", ProcessingListModel, "^Processing.*");
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void NotPaidListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotPaidListMouseReleased

    }//GEN-LAST:event_NotPaidListMouseReleased

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
    private javax.swing.JButton CancelBtn;
    private javax.swing.JList<String> NotPaidList;
    private javax.swing.JList<String> PaidList;
    private javax.swing.JComboBox<String> PaymentStatusCB;
    private javax.swing.JList<String> ProcessingList;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
