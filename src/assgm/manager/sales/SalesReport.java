package assgm.manager.sales;

import assgm.document.GeneralFunction;
import assgm.document.OverrideGeneralFunction;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SalesReport extends javax.swing.JFrame {

    private DefaultListModel SalesReportListModel = new DefaultListModel();
    private DefaultTableModel SalesReportTableModel = new DefaultTableModel();
    private DefaultComboBoxModel yearModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel monthModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel dayModel = new DefaultComboBoxModel<>();
    
    private GeneralFunction gf = new GeneralFunction();
    private SalesReportFunctions sr = new SalesReportFunctions();
    
    private String[]Column = {"ItemCode","ItemName","ItemPrice","AmountSalesNumber","AmountSalesPrice"};
    int row = -1;
    public SalesReport() {
        SalesReportTableModel.setColumnIdentifiers(Column);
        initComponents();
        SalesReportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                row = SalesReportTable.getSelectedRow();
            }
        });
        gf.ListloadFiles(SalesReportListModel,"^SalesReport.*", SalesReportListModel, "^SalesReport.*");
        gf.GetDSDate(SalesReportListModel, yearModel, monthModel);
        YearCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, SalesReportListModel, SalesReportList));
        MonthCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, SalesReportListModel, SalesReportList));
        sr.SetTable(SalesReportTableModel);
        gf.CheckListSelectedBeforeShowTable(gf, SalesReportList, SalesReportTableModel);
    }
    
private class SalesReportFunctions extends OverrideGeneralFunction{
    @Override
    protected void SetTable(DefaultTableModel TableModel){
        File file = new File("documents/ItemEntry.txt");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if(line.startsWith("UserID") || line.startsWith("Role") || line.startsWith("Created At" )|| 
                            line.startsWith("Updated") || line.trim().isEmpty()){
                        continue; 
                    }

                    String[] rowData = line.split(","); 
                    TableModel.addRow(new Object[]{rowData[0], rowData[1], rowData[2]});
                }
                System.out.println("Table data loaded successfully.");
            } catch (IOException ex) {
                Logger.getLogger(GeneralFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    @Override
    protected void CalculateAmountofPrice(DefaultTableModel TableModel) {
        
        for (int row = 0; row < TableModel.getRowCount(); row++) {
            double ItemPrice = 0.0; 
            int AmountSalesNumber = 0; 

            Object priceValue = TableModel.getValueAt(row, 2);
            if (priceValue != null) {
                try {
                    ItemPrice = Double.parseDouble(priceValue.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price at row " + row + ", setting to 0.");
                }
            }

            Object amountValue = TableModel.getValueAt(row, 3);
            if (amountValue != null) {
                try {
                    AmountSalesNumber = Integer.parseInt(amountValue.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid sales number at row " + row + ", setting to 0.");
                }
            }

            double AmountSalesPrice = AmountSalesNumber * ItemPrice;

            TableModel.setValueAt(AmountSalesPrice, row, 4);
        }
    }
    @Override
    protected void CalculateAmountNumber() {
        String year = (String) YearCB.getSelectedItem();   
        String month = (String) MonthCB.getSelectedItem(); 
        String yearMonth = year + month;                  

        File folder = new File("documents/");
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.getName().startsWith("Daily-Sales") && file.getName().contains(yearMonth)) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                String[] columns = line.split(","); 

                                if (columns.length > 3) { 
                                    String fileItemCode = columns[0].trim();  
                                    int fileValue = Integer.parseInt(columns[3].trim());

                                    for (int i = 0; i < SalesReportTableModel.getRowCount(); i++) {
                                        String tableItemCode = SalesReportTableModel.getValueAt(i, 0).toString();

                                        if (tableItemCode.equals(fileItemCode)) {
                                            Object value = SalesReportTableModel.getValueAt(i, 3); 
                                            int currentValue = 0;
                                            if (value != null) {
                                                try {
                                                    currentValue = Integer.parseInt(value.toString());
                                                } catch (NumberFormatException e) {
                                                    currentValue = 0; 
                                                }
                                            }else{
                                                currentValue = 0;
                                            }
                                            SalesReportTableModel.setValueAt(currentValue + fileValue, i, 3);
                                        }
                                    }
                                }
                            }
                        } catch (IOException | NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            
        } else {
            System.out.println("Folder not found: documents/");
        }
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        SalesReportTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        SalesReportList = new javax.swing.JList<>();
        YearCB = new javax.swing.JComboBox<>();
        MonthCB = new javax.swing.JComboBox<>();
        BackBtn = new javax.swing.JButton();
        DayCB = new javax.swing.JComboBox<>();
        UpdateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SalesReportTable.setModel(SalesReportTableModel);
        jScrollPane1.setViewportView(SalesReportTable);

        jLabel2.setText("Search Sales Report");

        SalesReportList.setModel(SalesReportListModel);
        SalesReportList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                SalesReportListMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(SalesReportList);

        YearCB.setModel(yearModel);

        MonthCB.setModel(monthModel);

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        DayCB.setModel(dayModel);

        UpdateBtn.setText("Update to newest");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(YearCB, 0, 56, Short.MAX_VALUE)
                                            .addComponent(MonthCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(DayCB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(UpdateBtn))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BackBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(BackBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(YearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(DayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addComponent(UpdateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

    private void SalesReportListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesReportListMouseReleased
        
        sr.CalculateAmountNumber();
        sr.CalculateAmountofPrice(SalesReportTableModel);
        gf.replaceNullWithZero(SalesReportTableModel);

    }//GEN-LAST:event_SalesReportListMouseReleased

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        Object ob = SalesReportList.getSelectedValue();
        if(!(ob == null)){
            gf.loadorsaveTableData("Save", "", SalesReportList, SalesReportTableModel);
            JOptionPane.showMessageDialog(this,"Document updated sucessfully.");
        }else{
            JOptionPane.showMessageDialog(this,"Please choose list first.");
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JComboBox<String> DayCB;
    private javax.swing.JComboBox<String> MonthCB;
    private javax.swing.JList<String> SalesReportList;
    private javax.swing.JTable SalesReportTable;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JComboBox<String> YearCB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
