
package assgm.manager.admin;

import assgm.LoginPage;
import java.io.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ManageUser extends javax.swing.JFrame {

    private DefaultTableModel usertable = new DefaultTableModel();//create model obj
    private String[] colname={"User ID","User Name","Role","Contact Number","Email Address","Password"};//column name array
    String filePath="documents/Account.txt ";
    int row=-1;
    private LoginPage lp;
    public ManageUser() {
        initComponents();
        usertable.setColumnIdentifiers(colname);
        loadDataFromFile();
        clearTextField();
    }
    
    public ManageUser(LoginPage lp) {
        initComponents();
        usertable.setColumnIdentifiers(colname);    
        loadDataFromFile();
        this.lp=lp;
        clearTextField();
    }

    private void loadDataFromFile() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                usertable.addRow(data);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading file: " + e.getMessage());
        }
    }
    
    public void clearTextField(){
        UserIDTF.setText("");
        UserNameTF.setText("");
        RoleTF.setText("");
        ContactNumberTF.setText("");
        PasswordTF.setText("");
        SearchTF.setText("");
        ConfirmedPasswordTF.setText("");
        EmailTF.setText("");
        Tips.setText("");
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        UserTable = new javax.swing.JTable();
        UserIDTF = new javax.swing.JTextField();
        UserNameTF = new javax.swing.JTextField();
        RoleTF = new javax.swing.JTextField();
        ContactNumberTF = new javax.swing.JTextField();
        PasswordTF = new javax.swing.JTextField();
        AddUserBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        SearchTF = new javax.swing.JTextField();
        ConfirmedPasswordTF = new javax.swing.JTextField();
        SearchBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        SaveBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Tips = new javax.swing.JLabel();
        EmailTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UserTable.setModel(usertable);
        UserTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                UserTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(UserTable);

        UserIDTF.setEditable(false);
        UserIDTF.setText("UserID");

        UserNameTF.setText("UserName");

        RoleTF.setEditable(false);
        RoleTF.setText("Role");

        ContactNumberTF.setText("ContactNumber");

        PasswordTF.setText("Password");

        AddUserBtn.setText("Add User");
        AddUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserBtnActionPerformed(evt);
            }
        });

        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
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

        SearchTF.setText("Search User");
        SearchTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchTFActionPerformed(evt);
            }
        });

        ConfirmedPasswordTF.setText("Confirmed Password");

        SearchBtn.setText("Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("User ID:");

        jLabel3.setText("User Name:");

        jLabel4.setText("Role:");

        jLabel5.setText("Cont.Number:");

        jLabel6.setText("Password:");

        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Confirm Password:");

        jLabel8.setText("Search User ID :");

        Tips.setText("jLabel9");

        EmailTF.setText("Email");

        jLabel10.setText("Email:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RoleTF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UserIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ContactNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(145, 145, 145)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ConfirmedPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(SearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(SearchBtn))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(304, 304, 304)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(EditBtn)
                                            .addComponent(DeleteBtn)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(EmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CancelBtn)))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AddUserBtn)
                                    .addComponent(SaveBtn)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(Tips, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EditBtn)
                            .addComponent(AddUserBtn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DeleteBtn)
                            .addComponent(SaveBtn))
                        .addGap(18, 18, 18)
                        .addComponent(CancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(UserIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SearchBtn)
                                    .addComponent(jLabel8))
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UserNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RoleTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ContactNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ConfirmedPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(Tips)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTFActionPerformed

    private void UserTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserTableMouseReleased
        row=UserTable.getSelectedRow();
        
        String id=String.valueOf(usertable.getValueAt(row, 0));
        String name=String.valueOf(usertable.getValueAt(row, 1));
        String role=String.valueOf(usertable.getValueAt(row, 2));
        String contact=String.valueOf(usertable.getValueAt(row, 3));
        String email=String.valueOf(usertable.getValueAt(row, 4));
        String pass=String.valueOf(usertable.getValueAt(row, 5));
        
        ConfirmedPasswordTF.setText("");
        UserIDTF.setText(id);
        UserNameTF.setText(name);
        RoleTF.setText(role);
        ContactNumberTF.setText(contact);
        PasswordTF.setText(pass);
        EmailTF.setText(email); 
        
    }//GEN-LAST:event_UserTableMouseReleased

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        if(row==-1){
        JOptionPane.showMessageDialog(this,"Please select a row to delete");
        }else{
        usertable.removeRow(row);
        clearTextField();
        row=-1;}
    }//GEN-LAST:event_DeleteBtnActionPerformed
    
    int du=0,e=0;
    private int isDuplicateUserID(String name, String email) {
    du = 0;
    e = 0;

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;

        while ((line = reader.readLine()) != null) {
            // Skip empty lines
            if (line.trim().isEmpty()) {
                continue;
            }

            String[] userDetails = line.split(",");

            // Check if userDetails has enough elements before accessing
            if (userDetails.length > 1 && userDetails[1].equals(name)) {
                du++; // Duplicate Username found
            }

            if (userDetails.length > 4 && userDetails[4].equals(email)) {
                e++; // Duplicate Email found
            }
        }

        if (du > 1 || e > 1) {
            if (du > 1 && e > 1) {
                return 4; // Both username and email are duplicates
            } else if (du > 1) {
                return 2; // Username is duplicate
            } else if (e > 1) {
                return 3; // Email is duplicate
            }
        }
    } catch (IOException ex) {
        Tips.setText("Error: Unable to read file.");
    }

    return 0; // No duplicates found
}

    
    private boolean validation() {
    String userName = UserNameTF.getText().trim();
    String contactNumber = ContactNumberTF.getText().trim();
    String password = PasswordTF.getText().trim();
    String email = EmailTF.getText().trim();
    
    
    // Validate User ID
    if (userName.isEmpty()||password.isEmpty()||email.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all the information.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Validate Contact Number (must be numeric and have a specific length, e.g., 10 digits)
    if (!contactNumber.matches("\\d{10}")) {
        JOptionPane.showMessageDialog(this, "Contact Number must be 10 digits and in numeric.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
        JOptionPane.showMessageDialog(this, "Invalid Email Address format.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // All validations passed
    return true;
}
    
    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        if(!validation()){}else{
            
        String password=PasswordTF.getText();
        String confirmPassword=ConfirmedPasswordTF.getText();
        String userID=UserIDTF.getText();
        String name=UserNameTF.getText();
        String email=EmailTF.getText();
        
        
        if (password.equals(confirmPassword)) {
            if (isDuplicateUserID(name,email)==0) {
                usertable.setValueAt(userID, row, 0);
                usertable.setValueAt(name, row, 1);
                usertable.setValueAt(RoleTF.getText(), row, 2);
                usertable.setValueAt(ContactNumberTF.getText(), row, 3);
                usertable.setValueAt(email, row, 4);
                usertable.setValueAt(password, row, 5);
                row=-1;
                clearTextField();
                Tips.setText("User edited successfully.");
            } else if(isDuplicateUserID(name,email)==2){
                Tips.setText("Error: Duplicate UserName.");
            }else if(isDuplicateUserID(name,email)==3){
                Tips.setText("Error: Duplicate Email Address.");
            }else if(isDuplicateUserID(name,email)==4){
                Tips.setText("Error: Duplicate UserName and Email Address.");
            }else{
                Tips.setText("Error: Invalid input.");
            }
        } else {
            Tips.setText("Error: Passwords do not match.");
        }
        }
        
        
    }//GEN-LAST:event_EditBtnActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        saveToFile();
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        searchUserID();
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void AddUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserBtnActionPerformed
        CreateUser cs = new CreateUser(lp);
        cs.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_AddUserBtnActionPerformed

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < usertable.getRowCount(); i++) {
                Vector row = usertable.getDataVector().get(i);
                writer.write(String.join(",", (String[]) row.toArray(new String[0])));
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "File saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + e.getMessage());
        }
    }
    
    private void searchUserID() {
    String searchUserID = SearchTF.getText().trim(); // Get input from the search field
    boolean found = false;

    for (int i = 0; i < usertable.getRowCount(); i++) {
        String tableUserID = usertable.getValueAt(i, 0).toString(); // Get UserID from the table
        if (tableUserID.equalsIgnoreCase(searchUserID)) { // Check for a match
            // Highlight the matching row
            UserTable.setRowSelectionInterval(i, i); 
            
            // Scroll to make the selected row visible
            UserTable.scrollRectToVisible(UserTable.getCellRect(i, 0, true)); 
            
            found = true;
            break;
        }
    }

    // If no matching UserID is found, display a message
    if (!found) {
        JOptionPane.showMessageDialog(this, "User ID not found.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        UserTable.clearSelection(); // Clear any existing selection
    }
    }

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUserBtn;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JTextField ConfirmedPasswordTF;
    private javax.swing.JTextField ContactNumberTF;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JTextField EmailTF;
    private javax.swing.JTextField PasswordTF;
    private javax.swing.JTextField RoleTF;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JTextField SearchTF;
    private javax.swing.JLabel Tips;
    private javax.swing.JTextField UserIDTF;
    private javax.swing.JTextField UserNameTF;
    private javax.swing.JTable UserTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
