package assgm.manager;


import assgm.document.GeneralFunction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class ViewSalesReport extends javax.swing.JFrame {

    private DefaultListModel SalesReportListModel = new DefaultListModel();
    private DefaultTableModel SalesReportTableModel = new DefaultTableModel();
    private DefaultComboBoxModel yearModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel monthModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel dayModel = new DefaultComboBoxModel<>();
    
    private GeneralFunction gf = new GeneralFunction();
    
    private String[]Column = {"ItemCode","ItemName","ItemPrice","AmountSalesNumber","AmountSalesPrice"};
    int row = -1;
    public ViewSalesReport() {
        SalesReportTableModel.setColumnIdentifiers(Column);
        initComponents();
        Object ob = SalesReportList.getSelectedValue();
        if(!(ob == null)){
            gf.loadorsaveTableData("Load", "", SalesReportList, SalesReportTableModel);
        }
        gf.ListloadFiles(SalesReportListModel,"^SalesReport.*", SalesReportListModel, "^SalesReport.*");
        gf.GetDSDate(SalesReportListModel, yearModel, monthModel);
        YearCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, SalesReportListModel, SalesReportList));
        MonthCB.addActionListener(e ->gf.ShowSelectedList(YearCB, MonthCB, SalesReportListModel, SalesReportList));
        
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(YearCB, 0, 56, Short.MAX_VALUE)
                                    .addComponent(MonthCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(DayCB, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
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
                        .addGap(88, 88, 88)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_BackBtnActionPerformed

    private void SalesReportListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesReportListMouseReleased
      SalesReportTableModel.setRowCount(0); 
      gf.loadorsaveTableData("Load", "", SalesReportList, SalesReportTableModel);
    }//GEN-LAST:event_SalesReportListMouseReleased

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
    private javax.swing.JComboBox<String> YearCB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
