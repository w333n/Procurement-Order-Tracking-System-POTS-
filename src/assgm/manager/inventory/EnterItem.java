package assgm.manager.inventory;

import assgm.LoginPage;
import assgm.document.GeneralFunction;
import assgm.document.OverrideGeneralFunction;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnterItem extends javax.swing.JFrame {
    private LoginPage lp;
    private GeneralFunction gf = new GeneralFunction();
    private ItemFunctions it = new ItemFunctions();
    
    private DefaultTableModel EnterItemTable=new DefaultTableModel();
    private String [] Column = {"Item Code","Item Name","Item Price","Supplier Code"};
    private int row =-1;

    public DefaultTableModel getEnterItemTable() {
        return EnterItemTable;
    }

    public EnterItem() {
        EnterItemTable.setColumnIdentifiers(Column);
        initComponents();
        gf.loadorsaveTableData("Load", "ItemEntry.txt", jList1, EnterItemTable );
        
    }
    
    public EnterItem(LoginPage lp) {
        this.lp = lp;
        EnterItemTable.setColumnIdentifiers(Column);
        initComponents();
        gf.loadorsaveTableData("Load", "ItemEntry.txt", jList1, EnterItemTable );
        it.CheckIsTxTExisted();
        
    }
    
private class ItemFunctions extends OverrideGeneralFunction{
    protected void CheckIsTxTExisted(){
        File folder = new File("documents/");
        if (folder.exists() && folder.isDirectory()) {
            // List all files in the directory
            File[] files = folder.listFiles();
            boolean fileExists = false;
            if (files != null) {
                for (File f : files) {
                    // Check if the file name starts with "SupplierEntry"
                    if (f.getName().startsWith("ItemEntry")) {
                        fileExists = true;
                        break;
                    }
                }
            }
        if (!fileExists) {
            try {
                GeneralFunction gf2 = new GeneralFunction(lp);
                gf2.createFile("ItemEntry.txt", "ItemEntry.txt");
                System.out.println("File created successfully: ItemEntry");
            } catch (IOException ex) {
                Logger.getLogger(EnterSupplier.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("A file starting with 'ItemEntry' already exists.");
        }
        } else {
            System.out.println("The 'documents' folder does not exist.");
        }
    }
}
    
    private boolean DoubleInput(){
        String input = ItemPriceTF.getText(); 
        try {
            Double.parseDouble(input); 
            return true; 
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ItemCodeTF = new javax.swing.JTextField();
        ItemNameTF = new javax.swing.JTextField();
        SupplierCodeTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        EnterItemTb = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        ItemPriceTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SaveBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        BackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ItemCodeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCodeTFActionPerformed(evt);
            }
        });

        ItemNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemNameTFActionPerformed(evt);
            }
        });

        SupplierCodeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierCodeTFActionPerformed(evt);
            }
        });

        jLabel1.setText("Item Code");

        jLabel2.setText("Item Name");

        jLabel3.setText("Supplier Code");

        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        EnterItemTb.setModel(EnterItemTable);
        EnterItemTb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                EnterItemTbMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(EnterItemTb);

        jLabel8.setText("Update Item");

        ItemPriceTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemPriceTFActionPerformed(evt);
            }
        });

        jLabel4.setText("Item Price");

        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ItemPriceTF)
                            .addComponent(SupplierCodeTF)
                            .addComponent(ItemNameTF)
                            .addComponent(ItemCodeTF, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AddBtn)
                                .addGap(33, 33, 33)
                                .addComponent(DeleteBtn)
                                .addGap(29, 29, 29)
                                .addComponent(EditBtn)
                                .addGap(27, 27, 27)
                                .addComponent(SaveBtn))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BackBtn)
                            .addComponent(CancelBtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ItemCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(ItemNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SupplierCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn)
                    .addComponent(DeleteBtn)
                    .addComponent(EditBtn)
                    .addComponent(SaveBtn)
                    .addComponent(CancelBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        String ItemCode=ItemCodeTF.getText();
            String ItemName=ItemNameTF.getText();
            String ItemPrice=ItemPriceTF.getText();
            String SupplierCode=SupplierCodeTF.getText();
            
        if (!(ItemCode.isEmpty() || ItemName.isEmpty() || SupplierCode.isEmpty())){
            if (DoubleInput()){
            
            String newRow[] = {ItemCode,ItemName,ItemPrice,SupplierCode};
            EnterItemTable.addRow(newRow);

            clearTextField();
            gf.loadorsaveTableData("Save", "ItemEntry.txt", jList1, EnterItemTable );

        }else{
            JOptionPane.showMessageDialog(this,"Please insert numeric data in ItemPrice TF.");
        }
        }else{
            JOptionPane.showMessageDialog(this,"Please fill up all TextField.");
        } 
            
        
        
    }//GEN-LAST:event_AddBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        
        if (DoubleInput()){
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
            EnterItemTable.removeRow(row);

            // Clear the text fields
            clearTextField();

            // Save the updated table to the file
            gf.loadorsaveTableData("Save", "ItemEntry.txt", jList1, EnterItemTable);

            // Reset the row index
            row = -1;
        } else if (n == JOptionPane.NO_OPTION) {
            // Optionally handle the "No" case (if needed)
            JOptionPane.showMessageDialog(this, "Deletion canceled.");
        }
    }
        }else{
            JOptionPane.showMessageDialog(this,"Please insert numeric data in ItemPrice TF.");
        }
        

    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void EnterItemTbMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EnterItemTbMouseReleased
        row=EnterItemTb.getSelectedRow();
        String ItemCode = String.valueOf(EnterItemTable.getValueAt(row, 0));
        String ItemName = String.valueOf(EnterItemTable.getValueAt(row, 1));
        String ItemPrice = String.valueOf(EnterItemTable.getValueAt(row, 2));
        String SupplierCode = String.valueOf(EnterItemTable.getValueAt(row, 3));
        
        ItemCodeTF.setText(ItemCode);
        ItemNameTF.setText(ItemName);
        ItemPriceTF.setText(ItemPrice);
        SupplierCodeTF.setText(SupplierCode);
    }//GEN-LAST:event_EnterItemTbMouseReleased

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        
        String ItemCode=ItemCodeTF.getText();
        String ItemName=ItemNameTF.getText();
        String ItemPrice=ItemPriceTF.getText();
        String SupplierCode=SupplierCodeTF.getText();
        
        if (!(ItemCode.isEmpty() || ItemName.isEmpty() || SupplierCode.isEmpty())){
            if (DoubleInput()){
        
        if(row==-1){
            JOptionPane.showMessageDialog(this,"Select a row");
        }
        else{
            EnterItemTable.setValueAt(ItemCode, row, 0);
            EnterItemTable.setValueAt(ItemName, row, 1);
            EnterItemTable.setValueAt(ItemPrice, row, 2);
            EnterItemTable.setValueAt(SupplierCode, row, 3);
            row=-1;
        }        
        clearTextField();
        gf.loadorsaveTableData("Save", "ItemEntry.txt", jList1, EnterItemTable );
        JOptionPane.showMessageDialog(this,"Document saved sucessfully.");
        }else{
            JOptionPane.showMessageDialog(this,"Please insert numeric data in ItemPrice TF.");
        }
        }else{
            JOptionPane.showMessageDialog(this,"Please fill up all TextField.");
        } 
        
    }//GEN-LAST:event_EditBtnActionPerformed

    private void ItemPriceTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemPriceTFActionPerformed
        
    }//GEN-LAST:event_ItemPriceTFActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        try {
            GeneralFunction gf2 = new GeneralFunction(lp);
            gf2.updateFileInfo("ItemEntry.txt",jList1);
        } catch (IOException ex) {
            Logger.getLogger(EnterItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void ItemCodeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCodeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemCodeTFActionPerformed

    private void ItemNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemNameTFActionPerformed

    private void SupplierCodeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierCodeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupplierCodeTFActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        try {
            GeneralFunction gf2 = new GeneralFunction(lp);
            gf2.updateFileInfo("ItemEntry.txt",jList1);
        } catch (IOException ex) {
            Logger.getLogger(EnterItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(false);
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

    public void clearTextField(){
        ItemCodeTF.setText("");
        ItemNameTF.setText("");
        ItemPriceTF.setText("");
        SupplierCodeTF.setText("");
    }
    
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
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JTable EnterItemTb;
    private javax.swing.JTextField ItemCodeTF;
    private javax.swing.JTextField ItemNameTF;
    private javax.swing.JTextField ItemPriceTF;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTextField SupplierCodeTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
