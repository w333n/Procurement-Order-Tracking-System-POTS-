package assgm.manager;

import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import assgm.document.GeneralFunction;
import javax.swing.DefaultComboBoxModel;

public class ViewDailySales extends javax.swing.JFrame {

    private GeneralFunction gf = new GeneralFunction();
    private DefaultTableModel Table = new DefaultTableModel();
    private DefaultListModel List = new DefaultListModel();
    private DefaultComboBoxModel<String> yearModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel<String> monthModel = new DefaultComboBoxModel();
    private DefaultComboBoxModel<String> dayModel = new DefaultComboBoxModel();
    private String[]Column = {"ItemCode","ItemName","ItemPrice","TodaySalesNumber"};
    
    public ViewDailySales() {
        Table.setColumnIdentifiers(Column);
        initComponents();
        gf.ListloadFiles(List, "^(?=.*Daily-Sales).*", List, "^(?=.*Daily-Sales).*");
        Object ob = DailySalesList.getSelectedValue();
        if(!(ob == null)){
            gf.loadorsaveTableData("Load", "", DailySalesList, Table);
        }
        gf.GetDSDate(List, yearModel, monthModel, dayModel);
        YearCB.addActionListener(e -> gf.ShowSelectedList(YearCB, MonthCB, DayCB, List, DailySalesList));
        MonthCB.addActionListener(e -> gf.ShowSelectedList(YearCB, MonthCB, DayCB, List, DailySalesList));
        DayCB.addActionListener(e -> gf.ShowSelectedList(YearCB, MonthCB, DayCB, List, DailySalesList));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DailySalesTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        DailySalesList = new javax.swing.JList<>();
        DayCB = new javax.swing.JComboBox<>();
        YearCB = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MonthCB = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        BackBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DailySalesTable.setModel(Table);
        jScrollPane1.setViewportView(DailySalesTable);

        DailySalesList.setModel(List);
        DailySalesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DailySalesListMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(DailySalesList);

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
                    .addComponent(jScrollPane1)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DayCB, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(423, Short.MAX_VALUE)
                    .addComponent(BackBtn1)
                    .addContainerGap()))
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
                            .addComponent(DayCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(BackBtn1)
                    .addContainerGap(339, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void YearCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearCBActionPerformed

    private void DailySalesListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DailySalesListMouseReleased
        Table.setRowCount(0); 
        gf.loadorsaveTableData("Load", "", DailySalesList, Table);
    }//GEN-LAST:event_DailySalesListMouseReleased

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
    private javax.swing.JList<String> DailySalesList;
    private javax.swing.JTable DailySalesTable;
    private javax.swing.JComboBox<String> DayCB;
    private javax.swing.JComboBox<String> MonthCB;
    private javax.swing.JComboBox<String> YearCB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
