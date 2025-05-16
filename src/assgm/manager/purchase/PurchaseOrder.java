package assgm.manager.purchase;

import assgm.LoginPage;
import assgm.document.GeneralFunction;
import assgm.document.OverrideGeneralFunction;
import assgm.manager.sales.PurchaseRequisition;
import java.io.IOException;
import javax.swing.DefaultListModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PurchaseOrder extends javax.swing.JFrame {
    private LoginPage lp;
    private GeneralFunction gf = new GeneralFunction();
    private POFunctions po = new POFunctions();
    
    private DefaultListModel CreatedModel = new DefaultListModel<>();
    private DefaultListModel NotCreatedModel = new DefaultListModel<>();
    private DefaultTableModel POtableModel = new DefaultTableModel();
    
    private DefaultComboBoxModel<String> yearModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> monthModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> dayModel = new DefaultComboBoxModel<>();
    
    private String [] Column = {"SupplierCode","ItemCode","ItemName","ItemPrice","RequiredNumbers","AmountPrice"};
    private int row =-1;
    public PurchaseOrder(LoginPage lp) {
        this.lp = lp;
        POtableModel.setColumnIdentifiers(Column);
        initComponents();        
        gf.ListloadFiles(CreatedModel,"^POCreated.*", NotCreatedModel, "^PONotCreated.*");
        gf.GetDSDate(NotCreatedModel, yearModel, monthModel, dayModel);
        YearCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, NotCreatedModel, notwithPOList));
        MonthCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, NotCreatedModel, notwithPOList));
        DayCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, NotCreatedModel, notwithPOList));
    }

private class POFunctions extends OverrideGeneralFunction{
    @Override
    protected void CalculateAmountofPrice(DefaultTableModel TableModel){
        for (int row = 0; row < TableModel.getRowCount(); row++){
            double ItemPrice = 0.0; 
            int RequiredNumber = 0; 

            Object priceValue = TableModel.getValueAt(row, 3);
            if (priceValue != null) {
                try {
                    ItemPrice = Double.parseDouble(priceValue.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price at row " + row + ", setting to 0.");
                }
            }

            Object amountValue = TableModel.getValueAt(row, 4);
            if (amountValue != null) {
                try {
                    RequiredNumber = Integer.parseInt(amountValue.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid sales number at row " + row + ", setting to 0.");
                }
            }
            
            double AmountPrice = RequiredNumber * ItemPrice;
            TableModel.setValueAt(AmountPrice, row, 5);
        }
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        CreateBtn = new javax.swing.JButton();
        createPRBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        withPOList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        notwithPOList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        POTable = new javax.swing.JTable();
        BackBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        MonthCB = new javax.swing.JComboBox<>();
        YearCB = new javax.swing.JComboBox<>();
        DayCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("PR (PO have created)");

        CreateBtn.setText("Create");
        CreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateBtnActionPerformed(evt);
            }
        });

        createPRBtn.setText("or create a new one? (jump to PR UI)");
        createPRBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPRBtnActionPerformed(evt);
            }
        });

        withPOList.setModel(CreatedModel);
        jScrollPane5.setViewportView(withPOList);

        notwithPOList.setModel(NotCreatedModel);
        notwithPOList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                notwithPOListMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(notwithPOList);

        jLabel1.setText("PR (Needed to create PO)");

        POTable.setModel(POtableModel);
        jScrollPane3.setViewportView(POTable);

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        RefreshBtn.setText("Refresh");
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });

        MonthCB.setModel(monthModel);

        YearCB.setModel(yearModel);

        DayCB.setModel(dayModel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CreateBtn)
                            .addComponent(RefreshBtn))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(YearCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(DayCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(MonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BackBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(createPRBtn)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(BackBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createPRBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RefreshBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(YearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addComponent(CreateBtn)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createPRBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPRBtnActionPerformed
        PurchaseRequisition pr = new PurchaseRequisition(lp);
        pr.setVisible(true);
    }//GEN-LAST:event_createPRBtnActionPerformed

    private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
        Object ob = notwithPOList.getSelectedValue();
        if(!(ob == null)){
            
        try {
            Object PR = notwithPOList.getSelectedValue();
            if (PR != null){
                GeneralFunction gf2 = new GeneralFunction(lp);
                gf2.createFile("PurchaseOrder", "Waiting");
                String fileName = gf2.createFile("PurchaseOrder", "Waiting");
                gf.loadorsaveTableData("Save",fileName , notwithPOList, POtableModel);
                gf2.updateFileInfo("",notwithPOList);
                gf.updateFileName(notwithPOList, "PONotCreated", "POCreated");
                JOptionPane.showMessageDialog(this,"Document created sucessfully.");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(PurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            JOptionPane.showMessageDialog(this,"Please choose list first.");
        }
        
        
    }//GEN-LAST:event_CreateBtnActionPerformed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        gf.GetDSDate(NotCreatedModel, yearModel, monthModel, dayModel);
        YearCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, NotCreatedModel, notwithPOList));
        MonthCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, NotCreatedModel, notwithPOList));
        DayCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, NotCreatedModel, notwithPOList));
        gf.ListloadFiles(CreatedModel,"^POCreated.*", NotCreatedModel, "^PONotCreated.*");
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void notwithPOListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notwithPOListMouseReleased
        gf.ClearTabletoLoadTxT(POtableModel);
        gf.loadorsaveTableData("Load", "", notwithPOList, POtableModel);
        po.CalculateAmountofPrice(POtableModel);
    }//GEN-LAST:event_notwithPOListMouseReleased

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton CreateBtn;
    private javax.swing.JComboBox<String> DayCB;
    private javax.swing.JComboBox<String> MonthCB;
    private javax.swing.JTable POTable;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JComboBox<String> YearCB;
    private javax.swing.JButton createPRBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> notwithPOList;
    private javax.swing.JList<String> withPOList;
    // End of variables declaration//GEN-END:variables
}
