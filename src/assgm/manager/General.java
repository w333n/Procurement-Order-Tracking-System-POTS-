package assgm.manager;

import assgm.LoginPage;

public class General extends javax.swing.JFrame {

    private LoginPage lp;
    public General(LoginPage lp) {
        initComponents();
        this.lp = lp;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UpdateProfileBtn = new javax.swing.JButton();
        ViewFileBtn = new javax.swing.JButton();
        BackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UpdateProfileBtn.setText("UpdateProfile");
        UpdateProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateProfileBtnActionPerformed(evt);
            }
        });

        ViewFileBtn.setText("ViewFile");
        ViewFileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewFileBtnActionPerformed(evt);
            }
        });

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BackBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(UpdateProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ViewFileBtn))
                        .addGap(0, 135, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UpdateProfileBtn)
                .addGap(18, 18, 18)
                .addComponent(ViewFileBtn)
                .addGap(125, 125, 125)
                .addComponent(BackBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateProfileBtnActionPerformed
        UpdateProfile up = new UpdateProfile(lp);
        up.setVisible(true);
    }//GEN-LAST:event_UpdateProfileBtnActionPerformed

    private void ViewFileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewFileBtnActionPerformed
        ViewFile vf = new ViewFile();
        vf.setVisible(true);
    }//GEN-LAST:event_ViewFileBtnActionPerformed

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
    private javax.swing.JButton UpdateProfileBtn;
    private javax.swing.JButton ViewFileBtn;
    // End of variables declaration//GEN-END:variables
}
