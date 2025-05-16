package assgm.manager.finance;

import assgm.LoginPage;
import assgm.document.GeneralFunction;
import java.io.*;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class SupplierPaymentHistory extends javax.swing.JFrame {
    
    private LoginPage lp;
    private GeneralFunction gf;
    private DefaultListModel List = new DefaultListModel();
    private DefaultListModel<String> PaidListModel = new DefaultListModel<>();
    private DefaultTableModel model = new DefaultTableModel();//create model obj
    private String[] colname={"Paid Purchase File","Total Amount","Date Time"};//column name array SupplierCode,ItemCode,ItemName
    private String filepath="documents/";
   
    public SupplierPaymentHistory(LoginPage lp) {
        model.setColumnIdentifiers(colname);
        this.gf = new GeneralFunction();
        this.PaidListModel = new DefaultListModel<>(); 
        initComponents(); 
        HistoryTable.setModel(model);
        ListloadFiles(List,"^UpdatedtoStockLevel_PaidPurchase.*", List, "^Paid.*");
        
    }
    
    
    public SupplierPaymentHistory(){
        model.setColumnIdentifiers(colname);
        this.gf = new GeneralFunction();
        this.PaidListModel = new DefaultListModel<>(); 
        initComponents(); 
        HistoryTable.setModel(model);
        ListloadFiles(List,"^Paid.*", List, "^Paid.*");
        
    }
    
    public void ListloadFiles(DefaultListModel<String> listModel1,String Filter1, DefaultListModel<String> listModel2, String Filter2) {
        listModel1.clear();
        listModel2.clear();
        File folder = new File("documents/");
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().matches(Filter1)) {
                        listModel1.addElement(file.getName());
                    } else if (file.getName().matches(Filter2)) {
                        listModel2.addElement(file.getName());}
                    
                    if (file.getName().matches(Filter1) || file.getName().matches(Filter2)) {
                    try {
                        double totalAmount = extractAmount(file); // Sum up amounts
                        String updatedDate = extractUpdatedDate(file); // Get the last updated date
                        String formattedAmount = String.format("RM %.2f", totalAmount);
                        // Add file details to the table
                        model.addRow(new Object[]{file.getName(), formattedAmount, updatedDate});
                    } catch (IOException e) {
                        System.err.println("Error processing file: " + file.getName() + " - " + e.getMessage());
                    }
                    }
                }
            }
        } else {
            System.out.println("Folder does not exist or is not a directory.");
        }
    }
    
    private double extractAmount(File file) throws IOException {
    double totalAmount = 0.0;
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String [] data=line.split(",");
            if(data.length>5){
                try {
                    totalAmount += Double.parseDouble(data[5]); // Parse and sum the amount
                } catch (NumberFormatException e) {
                    System.err.println("Invalid amount format in file: " + file.getName() + " - Line: " + line);
                }
            }
            
        }
    }
    return totalAmount; // Return the total sum of amounts
    }

    private String extractUpdatedDate(File file) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Updated Time:")) {
                return line.substring("Updated Time:".length()).trim(); // Extract date after "Updated Date:"
            }
        }
    }
    return "N/A"; // Return "N/A" if the updated date is not found
    }
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        HistoryTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HistoryTable.setModel(model);
        jScrollPane1.setViewportView(HistoryTable);

        jLabel1.setText("Payment History");

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
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BackBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BackBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierPaymentHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JTable HistoryTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
