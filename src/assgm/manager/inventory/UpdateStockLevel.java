package assgm.manager.inventory;

import assgm.LoginPage;
import assgm.document.GeneralFunction;
import assgm.document.OverrideGeneralFunction;
import assgm.manager.sales.SalesReport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UpdateStockLevel extends javax.swing.JFrame {

    private LoginPage lp;
    private GeneralFunction gf = new GeneralFunction();
    private SetControlFunctions sc = new SetControlFunctions();
    private DecreaseStockLevelsFunctions ds = new DecreaseStockLevelsFunctions();
    private IncreaseStockLevelsFunctions is = new IncreaseStockLevelsFunctions();
    
    private DefaultListModel DSListModel = new DefaultListModel();
    private DefaultListModel POListModel = new DefaultListModel();
    private DefaultTableModel StockLevelsTableModel = new DefaultTableModel();
    private String[]column = {"ItemCode","ItmName","ItemPrice","SupplierCode","CurrentNumbers","CurrentStockLevels"};
    int row=-1;
    public UpdateStockLevel(LoginPage lp) {
        this.lp=lp;
        StockLevelsTableModel.setColumnIdentifiers(column);
        initComponents();
        gf.loadorsaveTableData("Load", "ItemEntry.txt", POList, StockLevelsTableModel);
        gf.ListloadFiles(POListModel, "^Paid.*",DSListModel,"^Daily-Sales.*");
        sc.SetTable(StockLevelsTableModel);
        gf.replaceNullWithZero(StockLevelsTableModel);
        sc.updateAllStockColumns();
    }

private class SetControlFunctions extends OverrideGeneralFunction{
    @Override
    protected void SetTable(DefaultTableModel TableModel){
        File file = new File("documents/StockLevels.txt");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if(line.startsWith("UserID") || line.startsWith("Role") || line.startsWith("Created At" )
                            || line.startsWith("Updated") || line.trim().isEmpty()){
                        continue; 
                    }

                    String[] rowData = line.split(","); 
                    if (rowData.length > 4) { 
                        String fileItemCode = rowData[0].trim(); 
                        int fileValue = Integer.parseInt(rowData[4].trim()); 

                        for (int i = 0; i < StockLevelsTableModel.getRowCount(); i++) {
                            String tableItemCode = StockLevelsTableModel.getValueAt(i, 0).toString(); 
                            if (tableItemCode.equals(fileItemCode)) {
                                StockLevelsTableModel.setValueAt(fileValue, i, 4); 
                            }
                        }
                    }
                }
                System.out.println("Table data loaded successfully.");
            } catch (IOException ex) {
                Logger.getLogger(GeneralFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    protected void updateAllStockColumns() {
        for (int row = 0; row < StockLevelsTableModel.getRowCount(); row++) { 
            String StockLevel;
            Object stockNumbersObj = StockLevelsTableModel.getValueAt(row, 4); 

            if (stockNumbersObj == null) {
                StockLevel = "Minimum Level"; 
            } else {
                try {
                    int StockNumbers = Integer.parseInt(stockNumbersObj.toString()); 
                    if (StockNumbers >= 5000) {
                        StockLevel = "Maximum Level";
                    } else if (StockNumbers >= 4000) {
                        StockLevel = "Buffer Stock";
                    } else if (StockNumbers >= 3800) {
                        StockLevel = "Safety Stock";
                    } else if (StockNumbers >= 3500) {
                        StockLevel = "Re-order Level";
                    } else if (StockNumbers >= 3000) {
                        StockLevel = "Danger Level";
                    } else {
                        StockLevel = "Minimum Level";
                    }
                } catch (NumberFormatException e) {
                    StockLevel = "Invalid Number"; 
                    System.out.println("Invalid StockNumbers at row " + row);
                }
            }

            StockLevelsTableModel.setValueAt(StockLevel, row, 5);
        }
        System.out.println("All StockNumbers updated successfully!");
    }

} 
    
private class DecreaseStockLevelsFunctions extends OverrideGeneralFunction{
    @Override
    protected void CreateReport(){
        File file = new File("documents/StockLevels.txt");
        if (file.exists()) {
            System.out.println("Stock Levels txt already exists.");
        } else {
            try {
                GeneralFunction gf2 = new GeneralFunction(lp);
                gf2.createFile("StockLevels.txt", "StockLevels.txt");
                System.out.println("Stock Levels txt created.");
            } catch (IOException ex) {
                Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    protected void FillTheTablewithSelectedList(GeneralFunction gf, DefaultTableModel TableModel, JList List){
        gf.ClearTabletoLoadTxT(TableModel);
        gf.loadorsaveTableData("Load", "ItemEntry.txt", List, TableModel);
        sc.SetTable(StockLevelsTableModel);
        gf.replaceNullWithZero(TableModel);
        Object selectedDS = List.getSelectedValue();
        if (selectedDS != null) {
            String selectedDSFile = selectedDS.toString();
            File file = new File("documents/" + selectedDSFile);

            if (file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        
                        if (line.startsWith("UserID") || line.startsWith("Role") || line.startsWith("Created") || line.startsWith("Updated") || line.trim().isEmpty()) {
                            continue;
                        }
                        String[] dsData = line.split(","); 
                        String dsItemCode = dsData[0];     
                        String SalesNumber = dsData[3]; 


                        for (int i = 0; i < TableModel.getRowCount(); i++) {
                            String tableItemCode = TableModel.getValueAt(i, 0).toString(); 
                            if (dsItemCode.equals(tableItemCode)) {
                                Object value = TableModel.getValueAt(i, 4);
                                int BeforeCurrentNumbers = 0;
                                if (value != null) {
                                    try {
                                        BeforeCurrentNumbers = Integer.parseInt(value.toString());
                                    } catch (NumberFormatException e) {
                                        System.out.println("Invalid value in row " + i + ": " + value);
                                    }
                                }
                                System.out.println("Row " + i + ", BeforeCurrentNumbers: " + BeforeCurrentNumbers);
                                int RequiredNumber = Integer.parseInt(SalesNumber);
                                TableModel.setValueAt(BeforeCurrentNumbers - RequiredNumber, i, 4);
                            }
                        }
                    }
                    System.out.println("TodaySalesNumbers matched and updated successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Selected Daily-Sales file not found.");
            }
        }
    }
    }

private class IncreaseStockLevelsFunctions extends OverrideGeneralFunction{
    @Override
    public void FillTheTablewithSelectedList(GeneralFunction gf, DefaultTableModel TableModel, JList List){
        gf.ClearTabletoLoadTxT(TableModel);
        gf.loadorsaveTableData("Load", "ItemEntry.txt", List, TableModel);
        sc.SetTable(StockLevelsTableModel);
        gf.replaceNullWithZero(TableModel);
        Object selectedPO = List.getSelectedValue();
            if (selectedPO != null) {
                String selectedPOFile = selectedPO.toString();
                File file = new File("documents/" + selectedPOFile);

                if (file.exists()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                           
                            if (line.startsWith("UserID") || line.startsWith("Role") || line.startsWith("Created") || line.startsWith("Updated") || line.trim().isEmpty()) {
                                continue;
                            }
                            String[] poData = line.split(","); 
                            String poItemCode = poData[1];     
                            String RequireedNumber = poData[4]; 

                            
                            for (int i = 0; i < TableModel.getRowCount(); i++) {
                                String tableItemCode = TableModel.getValueAt(i, 0).toString(); 
                                if (poItemCode.equals(tableItemCode)) {
                                    Object value = TableModel.getValueAt(i, 4);
                                    int BeforeCurrentNumbers = 0;
                                    if (value != null) {
                                        try {
                                            BeforeCurrentNumbers = Integer.parseInt(value.toString());
                                        } catch (NumberFormatException e) {
                                            System.out.println("Invalid value in row " + i + ": " + value);
                                        }
                                    }
                                    System.out.println("Row " + i + ", BeforeCurrentNumbers: " + BeforeCurrentNumbers);
                                    int RequiredNumber = Integer.parseInt(RequireedNumber);
                                    TableModel.setValueAt(BeforeCurrentNumbers + RequiredNumber, i, 4);
                                }
                            }
                        }
                        System.out.println("TodaySalesNumbers matched and updated successfully.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Selected Daily-Sales file not found.");
                }
            }
    }
        
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        StockLevelsTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        POList = new javax.swing.JList<>();
        DecreaseBtn = new javax.swing.JButton();
        IncreaseBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DSList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StockLevelsTable.setModel(StockLevelsTableModel);
        jScrollPane1.setViewportView(StockLevelsTable);

        POList.setModel(POListModel);
        POList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                POListMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(POList);

        DecreaseBtn.setText("Update to Decrease");
        DecreaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecreaseBtnActionPerformed(evt);
            }
        });

        IncreaseBtn.setText("Update to Increase");
        IncreaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncreaseBtnActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Update Stock Levels");

        DSList.setModel(DSListModel);
        DSList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DSListMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(DSList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BackBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DecreaseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 330, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(IncreaseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addComponent(RefreshBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BackBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DecreaseBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IncreaseBtn)
                    .addComponent(RefreshBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void POListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POListMouseReleased
        is.FillTheTablewithSelectedList(gf, StockLevelsTableModel, POList);
        sc.updateAllStockColumns();
    }//GEN-LAST:event_POListMouseReleased

    private void DecreaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecreaseBtnActionPerformed
        Object ob = DSList.getSelectedValue();
        if (!(ob == null)){
            ds.CreateReport();
            gf.loadorsaveTableData("Save", "StockLevels.txt", DSList, StockLevelsTableModel);
            try {
                GeneralFunction gf2 = new GeneralFunction(lp);
                gf2.updateFileInfo("StockLevels.txt", DSList);
            } catch (IOException ex) {
                Logger.getLogger(UpdateStockLevel.class.getName()).log(Level.SEVERE, null, ex);
            }
            gf.updateFileName(DSList, "Daily-Sales", "UpdatedtoStockLevel_Daily-Sales");
        }else{
            JOptionPane.showMessageDialog(this,"Please select a DS first.");
        }
        
        
    }//GEN-LAST:event_DecreaseBtnActionPerformed

    private void IncreaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncreaseBtnActionPerformed

        Object ob = POList.getSelectedValue();
        if (!(ob == null)){
            ds.CreateReport();
            gf.loadorsaveTableData("Save", "StockLevels.txt", DSList, StockLevelsTableModel);
            try {
                GeneralFunction gf2 = new GeneralFunction(lp);
                gf2.updateFileInfo("StockLevels.txt", DSList);
            } catch (IOException ex) {
                Logger.getLogger(UpdateStockLevel.class.getName()).log(Level.SEVERE, null, ex);
            }
            gf.updateFileName(POList, "Paid", "UpdatedtoStockLevel_Paid");
        }else{
            JOptionPane.showMessageDialog(this,"Please select a PO first.");
        }
        
        
    }//GEN-LAST:event_IncreaseBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        gf.ClearTabletoLoadTxT(StockLevelsTableModel);
        gf.loadorsaveTableData("Load", "ItemEntry.txt", DSList, StockLevelsTableModel);
        sc.SetTable(StockLevelsTableModel);
        sc.updateAllStockColumns();
        gf.replaceNullWithZero(StockLevelsTableModel);
        gf.ListloadFiles(DSListModel, "^Daily-Sales.*", POListModel, "^Paid.*");
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void DSListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DSListMouseReleased
        ds.FillTheTablewithSelectedList(gf, StockLevelsTableModel, DSList);
        sc.updateAllStockColumns();
    }//GEN-LAST:event_DSListMouseReleased

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JList<String> DSList;
    private javax.swing.JButton DecreaseBtn;
    private javax.swing.JButton IncreaseBtn;
    private javax.swing.JList<String> POList;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JTable StockLevelsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
