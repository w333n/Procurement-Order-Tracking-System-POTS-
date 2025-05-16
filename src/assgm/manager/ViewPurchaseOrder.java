package assgm.manager;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import assgm.document.GeneralFunction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;

public class ViewPurchaseOrder extends javax.swing.JFrame {

    private GeneralFunction gf = new GeneralFunction();
    private DefaultTableModel Table = new DefaultTableModel();
    private DefaultListModel List = new DefaultListModel();
    private DefaultComboBoxModel<String> yearModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel<String> monthModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel<String> dayModel = new DefaultComboBoxModel();
    private String[]Column = {"SupplierCode","ItemCode","ItemName","ItemPrice","RequiredNumbers","AmountPrice"};
    
    public ViewPurchaseOrder() {
        Table.setColumnIdentifiers(Column);
        initComponents();
        gf.ListloadFiles(List, "^(?=.*PurchaseOrder).*", List, "^(?=.*PurchaseOrder).*");
        Object ob = POList.getSelectedValue();
        if(!(ob == null)){
            gf.loadorsaveTableData("Load", "", POList, Table);
        }
        gf.GetDSDate(List, yearModel, monthModel, dayModel);
        YearCB.addActionListener(e -> gf.ShowSelectedList(YearCB, MonthCB, DayCB, List, POList));
        MonthCB.addActionListener(e -> gf.ShowSelectedList(YearCB, MonthCB, DayCB, List, POList));
        DayCB.addActionListener(e -> gf.ShowSelectedList(YearCB, MonthCB, DayCB, List, POList));
    }
    
    public ViewPurchaseOrder(String selectedFilePath,JList<String> list) {
        // Initialize table columns
        Table.setColumnIdentifiers(Column);
        initComponents();

        // Load file information into the table
        if (selectedFilePath != null && !selectedFilePath.isEmpty()) {
            gf.loadorsaveTableData("Load", selectedFilePath, list, Table);
            gf.ListloadFiles(List, "^(?=.*PurchaseOrder).*", List, "^(?=.*PurchaseOrder).*");
            gf.GetDSDate(List, yearModel, monthModel, dayModel);
            YearCB.addActionListener(e -> gf.ShowSelectedList(YearCB, MonthCB, DayCB, List, POList));
            MonthCB.addActionListener(e -> gf.ShowSelectedList(YearCB, MonthCB, DayCB, List, POList));
            DayCB.addActionListener(e -> gf.ShowSelectedList(YearCB, MonthCB, DayCB, List, POList));
        } else {
            System.err.println("Invalid file path.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        POTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        POList = new javax.swing.JList<>();
        DayCB = new javax.swing.JComboBox<>();
        YearCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MonthCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        BackBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        POTable.setModel(Table);
        jScrollPane1.setViewportView(POTable);

        POList.setModel(List);
        POList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                POListMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(POList);

        DayCB.setModel(dayModel);

        YearCB.setModel(yearModel);
        YearCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearCBActionPerformed(evt);
            }
        });

        jLabel2.setText("Year");

        jLabel3.setText("Month");

        MonthCB.setModel(monthModel);

        jLabel4.setText("Day");

        BackBtn1.setText("Back");
        BackBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BackBtn1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(YearCB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(MonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(DayCB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonthCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BackBtn1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YearCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearCBActionPerformed

    private void POListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_POListMouseReleased
        Table.setRowCount(0); 
        gf.loadorsaveTableData("Load", "", POList, Table);
    }//GEN-LAST:event_POListMouseReleased

    private void BackBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtn1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BackBtn1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn1;
    private javax.swing.JComboBox<String> DayCB;
    private javax.swing.JComboBox<String> MonthCB;
    private javax.swing.JList<String> POList;
    private javax.swing.JTable POTable;
    private javax.swing.JComboBox<String> YearCB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
