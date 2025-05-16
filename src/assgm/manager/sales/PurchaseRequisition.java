package assgm.manager.sales;
import assgm.LoginPage;
import assgm.document.GeneralFunction;
import java.io.IOException;
import javax.swing.DefaultListModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class PurchaseRequisition extends javax.swing.JFrame {
    private LoginPage lp;
    private GeneralFunction gf = new GeneralFunction();
    
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private DefaultListModel PRListModel = new DefaultListModel();
    private DefaultListModel ItemListModel = new DefaultListModel();
    private DefaultTableModel PRTableModel = new DefaultTableModel();
    
    private DefaultComboBoxModel<String> yearModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> monthModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> dayModel = new DefaultComboBoxModel<>();
    
    private String [] Column = {"SupplierCode","ItemCode","ItemName","ItemPrice","RequiredNumbers"};
    private int row =-1;
    
    public PurchaseRequisition(LoginPage lp) {
        this.lp = lp;
        PRTableModel.setColumnIdentifiers(Column);
        initComponents();
        SearchItemTF.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                gf.SearchItem(SearchItemTF, ItemListModel, ItemList);
            }

            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                gf.SearchItem(SearchItemTF, ItemListModel, ItemList);
            }

            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                gf.SearchItem(SearchItemTF, ItemListModel, ItemList);
            }
        });
        gf.GetItemsInList(ItemListModel);
        gf.ListloadFiles(PRListModel,"^PONotCreated.*", PRListModel, "^PONotCreated.*");
        gf.CheckListSelectedBeforeShowTable(gf, PRList, PRTableModel);
        gf.GetDSDate(PRListModel, yearModel, monthModel, dayModel);
        YearCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, PRListModel, PRList));
        MonthCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, PRListModel, PRList));
        DayCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, PRListModel, PRList));
        gf.SearchItem(SearchItemTF, ItemListModel, ItemList);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        CreateBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        PRTable = new javax.swing.JTable();
        ICTF = new javax.swing.JTextField();
        INTF = new javax.swing.JTextField();
        RNTF = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        ItemList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        PRList = new javax.swing.JList<>();
        YearCB = new javax.swing.JComboBox<>();
        MonthCB = new javax.swing.JComboBox<>();
        DayCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        SaveBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        SearchItemTF = new javax.swing.JTextField();
        CancelBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        SCTF = new javax.swing.JTextField();
        AddBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        IPTF = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CreateBtn.setText("or create a new one? ");
        CreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateBtnActionPerformed(evt);
            }
        });

        PRTable.setModel(PRTableModel);
        PRTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PRTableMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(PRTable);

        ICTF.setText("ItemCode");
        ICTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ICTFActionPerformed(evt);
            }
        });

        INTF.setText("ItemName");
        INTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INTFActionPerformed(evt);
            }
        });

        RNTF.setText("RequiredNumber");

        ItemList.setModel(ItemListModel);
        ItemList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                ItemListMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(ItemList);

        jLabel1.setText("Choose Item");

        PRList.setModel(PRListModel);
        PRList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PRListMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(PRList);

        YearCB.setModel(yearModel);

        MonthCB.setModel(monthModel);

        DayCB.setModel(dayModel);

        jLabel2.setText("Search PR to Edit");

        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        SearchItemTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchItemTFActionPerformed(evt);
            }
        });

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        SCTF.setText("SupplierCode");
        SCTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SCTFActionPerformed(evt);
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

        jLabel3.setText("Search Item");

        IPTF.setText("ItemPrice");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BackBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RefreshBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(INTF, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ICTF, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(SCTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(RNTF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IPTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(CreateBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SearchItemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddBtn)
                        .addGap(18, 18, 18)
                        .addComponent(EditBtn)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveBtn)
                        .addGap(18, 18, 18)
                        .addComponent(CancelBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(YearCB, 0, 56, Short.MAX_VALUE)
                                    .addComponent(DayCB, 0, 56, Short.MAX_VALUE)
                                    .addComponent(MonthCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(YearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(CreateBtn)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RefreshBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(SCTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ICTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(INTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(IPTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RNTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchItemTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddBtn)
                    .addComponent(EditBtn)
                    .addComponent(DeleteBtn)
                    .addComponent(CancelBtn)
                    .addComponent(SaveBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateBtnActionPerformed
        try {
            GeneralFunction gf2 = new GeneralFunction(lp);
            gf2.createFile("PurchaseRequisition", "PONotCreated");
            JOptionPane.showMessageDialog(this,"Document created sucessfully.");
        } catch (IOException ex) {
            Logger.getLogger(PurchaseRequisition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_CreateBtnActionPerformed

    private void INTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_INTFActionPerformed

    private void ICTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ICTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ICTFActionPerformed

    private void SearchItemTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchItemTFActionPerformed
        
    }//GEN-LAST:event_SearchItemTFActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        Object ob = ItemList.getSelectedValue();
        if(!(ob == null)){
           
        try {
            GeneralFunction gf2 = new GeneralFunction(lp);
            gf2.updateFileInfo("",PRList);
            JOptionPane.showMessageDialog(this,"Document saved sucessfully.");
        } catch (IOException ex) {
            Logger.getLogger(PurchaseRequisition.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            JOptionPane.showMessageDialog(this,"Please choose list first.");
        }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        gf.GetDSDate(PRListModel, yearModel, monthModel, dayModel);
        YearCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, PRListModel, PRList));
        MonthCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, PRListModel, PRList));
        DayCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, DayCB, PRListModel, PRList));
        
        gf.ListloadFiles(PRListModel,"^PONotCreated.*", PRListModel, "^PONotCreated.*");
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void PRListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRListMouseReleased
        PRTableModel.setRowCount(0);
        gf.loadorsaveTableData("Load", "", PRList, PRTableModel);
    }//GEN-LAST:event_PRListMouseReleased

    private void ItemListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ItemListMouseReleased
        gf.ShowSelectedItem("ItemEntry.txt",SCTF,ItemList,3,0);
        gf.ShowSelectedItem("ItemEntry.txt",ICTF,ItemList,0,0);
        gf.ShowSelectedItem("ItemEntry.txt",INTF,ItemList,1,0);
        gf.ShowSelectedItem("ItemEntry.txt",IPTF,ItemList,2,0);
    }//GEN-LAST:event_ItemListMouseReleased

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        
        try {
            GeneralFunction gf2 = new GeneralFunction(lp);
            gf2.updateFileInfo("",PRList);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(PurchaseRequisition.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        Object ob = ItemList.getSelectedValue();
        if(!(ob == null)){
            if (gf.IntegerInput(RNTF)){
                String SC = SCTF.getText();
                String IC = ICTF.getText();
                String IN = INTF.getText();
                String RN = RNTF.getText();
                String IP = IPTF.getText();
                if(row==-1){
                    JOptionPane.showMessageDialog(this,"Select a row");
                }else{
                    PRTableModel.setValueAt(SC, row, 0);
                    PRTableModel.setValueAt(IC, row, 1);
                    PRTableModel.setValueAt(IN, row, 2);
                    PRTableModel.setValueAt(RN, row, 4);
                    PRTableModel.setValueAt(IP, row, 3);
                    row=-1;
                }        
                gf.ClearTextField(SCTF,ICTF,INTF,RNTF);
                gf.loadorsaveTableData("Save", "", PRList, PRTableModel);
            }else{
            JOptionPane.showMessageDialog(this,"Only Integer accepted.");
            }
        }else{
            JOptionPane.showMessageDialog(this,"Please choose list first.");
        }
        
        
        
    }//GEN-LAST:event_EditBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        Object ob = PRList.getSelectedValue();
        Object ob2 = ItemList.getSelectedValue();
        if(!(ob == null)){
            if(!(ob2 == null)){

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
                    PRTableModel.removeRow(row);

                    // Clear the text fields
                    gf.ClearTextField(SCTF,ICTF,INTF,RNTF);

                    // Save the updated table to the file
                    gf.loadorsaveTableData("Save", "", PRList, PRTableModel);

                    // Reset the row index
                    row = -1;
                } else if (n == JOptionPane.NO_OPTION) {
                    // Optionally handle the "No" case (if needed)
                    JOptionPane.showMessageDialog(this, "Deletion canceled.");
                }
                gf.loadorsaveTableData("Save", "", PRList, PRTableModel);
                }
            }else{
                JOptionPane.showMessageDialog(this,"Please choose ite, first.");
            }
        }else{
            JOptionPane.showMessageDialog(this,"Please choose list first.");
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        Object ob = PRList.getSelectedValue();
        Object ob2 = ItemList.getSelectedValue();
        if(!(ob == null)){
            if (!(ob2 == null)){
                if (gf.IntegerInput(RNTF)){
                String SC = SCTF.getText();
                String IC = ICTF.getText();
                String IN = INTF.getText();
                String RN = RNTF.getText();
                String IP = IPTF.getText();

                String newRow[] = {SC,IC,IN,IP,RN};
                PRTableModel.addRow(newRow);

                gf.ClearTextField(SCTF,ICTF,INTF,RNTF);

                gf.loadorsaveTableData("Save", "", PRList, PRTableModel);
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

    private void SCTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SCTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SCTFActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

    private void PRTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PRTableMouseReleased
        row=PRTable.getSelectedRow();
        if (row != -1){
            String SC = String.valueOf(PRTableModel.getValueAt(row, 0));
            String IC = String.valueOf(PRTableModel.getValueAt(row, 1));
            String IN = String.valueOf(PRTableModel.getValueAt(row, 2));
            String IP = String.valueOf(PRTableModel.getValueAt(row, 3));
            String RN = String.valueOf(PRTableModel.getValueAt(row, 4));
            SCTF.setText(SC);
            ICTF.setText(IC);
            INTF.setText(IN);
            IPTF.setText(IP);
            RNTF.setText(RN);
            }
    }//GEN-LAST:event_PRTableMouseReleased

    
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
    private javax.swing.JComboBox<String> DayCB;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JTextField ICTF;
    private javax.swing.JTextField INTF;
    private javax.swing.JTextField IPTF;
    private javax.swing.JList<String> ItemList;
    private javax.swing.JComboBox<String> MonthCB;
    private javax.swing.JList<String> PRList;
    private javax.swing.JTable PRTable;
    private javax.swing.JTextField RNTF;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JTextField SCTF;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTextField SearchItemTF;
    private javax.swing.JComboBox<String> YearCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
