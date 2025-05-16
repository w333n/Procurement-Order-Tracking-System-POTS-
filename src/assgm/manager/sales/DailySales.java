package assgm.manager.sales;

import assgm.LoginPage;
import assgm.document.GeneralFunction;
import assgm.document.OverrideGeneralFunction;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DailySales extends javax.swing.JFrame {
    private LoginPage lp;
    private GeneralFunction gf = new GeneralFunction();
    private DailySalesFunctions ds = new DailySalesFunctions();
    
    private DefaultListModel DailySalesListModel = new DefaultListModel<String>();
    private DefaultListModel ItemListModel= new DefaultListModel<String>();
    private DefaultListModel listModel = new DefaultListModel<>();
    private DefaultTableModel tableModel = new DefaultTableModel();
    
    private DefaultComboBoxModel<String> yearModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> monthModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> dayModel = new DefaultComboBoxModel<>();
    
    private String [] Column = {"ItemCode","ItemName","ItemPrice","TodaySalesNumber"};
    private int row =-1;
    
    public DailySales(LoginPage lp) {
        this.lp = lp;
        tableModel.setColumnIdentifiers(Column);
        
        initComponents(); 
        SearchItemTF.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                gf.SearchItem(SearchItemTF, listModel, ItemList);
            }

            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                gf.SearchItem(SearchItemTF, listModel, ItemList);
            }

            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                gf.SearchItem(SearchItemTF, listModel, ItemList);
            }
        });
        gf.GetItemsInList(ItemListModel);
        gf.ListloadFiles(DailySalesListModel,"^Daily-Sales.*", DailySalesListModel, "^Daily-Sales.*");
        gf.GetDSDate(DailySalesListModel, yearModel, monthModel, dayModel);
        YearCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, DailySalesListModel, DailySalesList));
        MonthCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, DailySalesListModel, DailySalesList));
        DayCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, DailySalesListModel, DailySalesList));
        gf.SearchItem(SearchItemTF, listModel, ItemList);
        
    }

private class DailySalesFunctions extends OverrideGeneralFunction{
    
    @Override
    protected void CreateReport() {
        String month = new SimpleDateFormat("MM").format(new Date()); 
        String year = new SimpleDateFormat("yyyy").format(new Date()); 

        File folder = new File("documents/");
        if (!folder.exists()) {
            folder.mkdirs(); 
        }

        String reportFileName = "SalesReport" + year + month + ".txt";
        File reportFile = new File(folder, reportFileName);

        if (reportFile.exists()) {
            System.out.println("Sales Report already exists: " + reportFileName);
        } else {
            
            try {
                reportFile.createNewFile();
                System.out.println("Sales Report created: " + reportFileName);
            } catch (IOException ex) {
                Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        INTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TNTF = new javax.swing.JTextField();
        SaveBtn = new javax.swing.JButton();
        CreateBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        DailySalesList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        ItemList = new javax.swing.JList<>();
        YearCB = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DSTable = new javax.swing.JTable();
        MonthCB = new javax.swing.JComboBox<>();
        DayCB = new javax.swing.JComboBox<>();
        ICTF = new javax.swing.JTextField();
        IPTF = new javax.swing.JTextField();
        DeleteBtn = new javax.swing.JButton();
        SearchItemTF = new javax.swing.JTextField();
        CancelBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        INTF.setText("ItemName");
        INTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INTFActionPerformed(evt);
            }
        });

        jLabel2.setText("Search Sales to Edit");

        TNTF.setText("Today Sales Number");
        TNTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNTFActionPerformed(evt);
            }
        });

        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        CreateBtn.setText("or create a new one? ");
        CreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateBtnActionPerformed(evt);
            }
        });

        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        DailySalesList.setModel(DailySalesListModel);
        DailySalesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DailySalesListMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(DailySalesList);

        ItemList.setModel(ItemListModel);
        ItemList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ItemListMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(ItemList);

        YearCB.setModel(yearModel);

        jLabel1.setText("Choose Item");

        DSTable.setModel(tableModel);
        DSTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DSTableMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(DSTable);

        MonthCB.setModel(monthModel);

        DayCB.setModel(dayModel);

        ICTF.setText("ItemCode");
        ICTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ICTFActionPerformed(evt);
            }
        });

        IPTF.setText("ItemPrice");
        IPTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IPTFActionPerformed(evt);
            }
        });

        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        RefreshBtn.setText("Refresh");
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Search Items");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RefreshBtn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(AddBtn)
                                    .addGap(18, 18, 18)
                                    .addComponent(EditBtn)
                                    .addGap(18, 18, 18)
                                    .addComponent(DeleteBtn)
                                    .addGap(83, 83, 83)
                                    .addComponent(SaveBtn)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CancelBtn))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(IPTF, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(INTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(ICTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TNTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(SearchItemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3)))))))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(DayCB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(YearCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(MonthCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(CreateBtn))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BackBtn)))
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
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(YearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(CreateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RefreshBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SearchItemTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ICTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(INTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IPTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TNTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn)
                    .addComponent(EditBtn)
                    .addComponent(DeleteBtn)
                    .addComponent(SaveBtn)
                    .addComponent(CancelBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void INTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_INTFActionPerformed

    private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
        try {
            GeneralFunction gf2 = new GeneralFunction(lp);
            gf2.createFile("Daily-Sales", "");
            JOptionPane.showMessageDialog(this,"Document created sucessfully.");
        } catch (IOException ex) {
            Logger.getLogger(PurchaseRequisition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_CreateBtnActionPerformed

    private void ICTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ICTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ICTFActionPerformed

    private void TNTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNTFActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        Object ob = ItemList.getSelectedValue();
        if(!(ob == null)){
            
        try {
            GeneralFunction gf2 = new GeneralFunction(lp);
            gf2.updateFileInfo("",DailySalesList);
            JOptionPane.showMessageDialog(this,"Document saved sucessfully.");
        } catch (IOException ex) {
            Logger.getLogger(DailySales.class.getName()).log(Level.SEVERE, null, ex);
        }
        ds.CreateReport();
        }else{
            JOptionPane.showMessageDialog(this,"Please choose list first.");
        }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        gf.ListloadFiles(DailySalesListModel,"", DailySalesListModel, "^Daily-Sales.*");
        gf.GetDSDate(DailySalesListModel, yearModel, monthModel, dayModel);
        YearCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, DailySalesListModel, DailySalesList));
        MonthCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, DailySalesListModel, DailySalesList));
        DayCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, DailySalesListModel, DailySalesList));
        
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        Object ob = DailySalesList.getSelectedValue();
        Object ob2 = ItemList.getSelectedValue();
        if(!(ob == null)){
            if(!(ob2 == null)){
                if (gf.IntegerInput(TNTF)){
                    String IP = IPTF.getText();
                    String IC = ICTF.getText();
                    String IN = INTF.getText();
                    String TN = TNTF.getText();
                    if(row==-1){
                        JOptionPane.showMessageDialog(this,"Select a row");
                    }
                    else{
                        tableModel.setValueAt(IC, row, 0);
                        tableModel.setValueAt(IN, row, 1);
                        tableModel.setValueAt(IP, row, 2);
                        tableModel.setValueAt(TN, row, 3);
                        row=-1;
                    }        
                    gf.ClearTextField(IPTF, ICTF, INTF, TNTF);

                    gf.loadorsaveTableData("Save", "", DailySalesList, tableModel);
                    }else{
                        JOptionPane.showMessageDialog(this,"Only Integer accepted.");
                    }
            }else{
                JOptionPane.showMessageDialog(this,"Please choose item first.");
            }
        
        }else{
            JOptionPane.showMessageDialog(this,"Please choose list first.");
        }
    }//GEN-LAST:event_EditBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        
        Object ob = ItemList.getSelectedValue();
        if(!(ob == null)){
            
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a row");
        } else {
        // Show confirmation dialog
        int n = JOptionPane.showConfirmDialog(
            null,
            "Do you want to delete this record?",
            "Confirm Deletion",
            JOptionPane.YES_NO_OPTION
        );

        // Check the user's choice
        if (n == JOptionPane.YES_OPTION) {
            // Remove the selected row from the table
            tableModel.removeRow(row);

            // Clear the text fields
            gf.ClearTextField(IPTF, ICTF, INTF, TNTF);

            // Save the updated table to the file
            gf.loadorsaveTableData("Save", "", DailySalesList, tableModel);

            // Reset the row index
            row = -1;
        } else if (n == JOptionPane.NO_OPTION) {
            // Optionally handle the "No" case (if needed)
            JOptionPane.showMessageDialog(this, "Deletion canceled.");
        }
        }
        gf.loadorsaveTableData("Save", "", DailySalesList, tableModel);
        }else{
            JOptionPane.showMessageDialog(this,"Please choose list first.");
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        try {
            GeneralFunction gf2 = new GeneralFunction(lp);
            gf2.updateFileInfo("",DailySalesList); 
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(DailySales.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        Object ob = DailySalesList.getSelectedValue();
        Object ob2 = ItemList.getSelectedValue();
        if(!(ob == null)){
            if(!(ob2 == null)){
                
                if (gf.IntegerInput(TNTF)){
                    String IP = IPTF.getText();
                    String IC = ICTF.getText();
                    String IN = INTF.getText();
                    String TN = TNTF.getText();

                    String newRow[] = {IC,IN,IP,TN};
                    tableModel.addRow(newRow);

                    gf.ClearTextField(IPTF, ICTF, INTF, TNTF);

                    gf.loadorsaveTableData("Save", "", DailySalesList, tableModel);
                    }else{
                        JOptionPane.showMessageDialog(this,"Only Integer accepted.");
                    }
            }else{
                JOptionPane.showMessageDialog(this,"Please choose item first.");
            }
        
        }else{
            JOptionPane.showMessageDialog(this,"Please choose list first.");
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void ItemListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemListMouseReleased
        gf.ShowSelectedItem("ItemEntry.txt",ICTF,ItemList,0,0);
        gf.ShowSelectedItem("ItemEntry.txt",INTF,ItemList,1,0);
        gf.ShowSelectedItem("ItemEntry.txt",IPTF,ItemList,2,0);
    }//GEN-LAST:event_ItemListMouseReleased

    private void IPTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IPTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IPTFActionPerformed

    private void DailySalesListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DailySalesListMouseReleased
        tableModel.setRowCount(0);
        gf.loadorsaveTableData("Load", "", DailySalesList, tableModel);
    }//GEN-LAST:event_DailySalesListMouseReleased

    private void DSTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DSTableMouseReleased
        row=DSTable.getSelectedRow();
        if (row != -1){
            String IC = String.valueOf(tableModel.getValueAt(row, 0));
            String IN = String.valueOf(tableModel.getValueAt(row, 1));
            String IP = String.valueOf(tableModel.getValueAt(row, 2));
            String TN = String.valueOf(tableModel.getValueAt(row, 3));
            ICTF.setText(IC);
            INTF.setText(IN);
            IPTF.setText(IP);
            TNTF.setText(TN);
            }
    }//GEN-LAST:event_DSTableMouseReleased

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
    private javax.swing.JButton AddBtn;
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JButton CreateBtn;
    private javax.swing.JTable DSTable;
    private javax.swing.JList<String> DailySalesList;
    private javax.swing.JComboBox<String> DayCB;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JTextField ICTF;
    private javax.swing.JTextField INTF;
    private javax.swing.JTextField IPTF;
    private javax.swing.JList<String> ItemList;
    private javax.swing.JComboBox<String> MonthCB;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTextField SearchItemTF;
    private javax.swing.JTextField TNTF;
    private javax.swing.JComboBox<String> YearCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
