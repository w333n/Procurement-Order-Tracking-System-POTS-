
package assgm.manager;

import assgm.LoginPage;
import java.io.*;
import javax.swing.JOptionPane;


public class UpdateProfile extends javax.swing.JFrame {
File f = new File("documents/Account.txt");
private LoginPage lp;
private String userID;

public UpdateProfile(LoginPage lp) {
        this.lp=lp;
        this.userID = lp.getUserID();
        initComponents();
        load();
    }
    
    public void load(){
    
    try(BufferedReader br=new BufferedReader(new FileReader(f))){
    String user;
    while((user=br.readLine())!=null){
    String[] info=user.split(",");
    if(info[0].equals(userID)){//found user data
                UserIDTF.setText(info[0]);
                UsernameTF.setText(info[1]);
                UserroleTF.setText(info[2]);
                ContactNumberTF.setText(info[3]);
                EmailAddressTF.setText(info[4]);
                passTF.setText(info[5]);
                return;
    }
    }
    JOptionPane.showMessageDialog(this,"User ID not found","Error",JOptionPane.ERROR_MESSAGE);
    
    }
    catch(IOException e){
    
        JOptionPane.showMessageDialog(this,"Error loading data: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
    }
    
    int du=0,e=0;
    private int isDuplicateUserID(String name, String email) {
    try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] userDetails = line.split(",");
            
            // Check if the line has at least 5 elements
            if (userDetails.length > 4) {
                if (userDetails[1].equals(name)) {
                    du++; // Duplicate Username found
                }
                if (userDetails[4].equals(email)) {
                    e++; // Duplicate Email found
                }
            }
        }
        
        if (du > 1 || e > 1) {
            if (du > 1 && e > 1)
                return 4;
            else if (du > 1)
                return 2;
            else if (e > 1)
                return 3;
        }
        
    } catch (IOException e) {
        jLabel9.setText("Error: Unable to read file.");
    }
    return 0;
}

    
    private boolean validation() {
    String userName = UserIDTF.getText().trim();
    String contactNumber = ContactNumberTF.getText().trim();
    String password = passTF.getText().trim();
    String email=EmailAddressTF.getText();
    
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
    
    private void edit(){
        if(!validation()){}else{
    
        String userID=UserIDTF.getText();
        String name=UsernameTF.getText();
        String role= UserroleTF.getText();
        String contact=ContactNumberTF.getText();
        String email=EmailAddressTF.getText();
        String password=passTF.getText();
        String confirmPassword=passTF2.getText();
        File temp=new File("Update.txt");
        
        if (password.equals(confirmPassword)) {
            if (isDuplicateUserID(name,email)==0) {
                //save
                try{
                    BufferedReader brf = new BufferedReader(new FileReader(f));
                    BufferedWriter wrt = new BufferedWriter(new FileWriter(temp));
                    String line;
                    boolean update=false;

                    while((line=brf.readLine())!=null){
                    String[] data=line.split(",");
                    if(data[0].equals(userID)){
                        wrt.write(userID + ","+name+","+role+","+contact+ ","+email+ "," + password);
                        wrt.newLine();
                        update=true;
                    }else{
                        wrt.write(line);
                        wrt.newLine();
                    }
                    }
                    
                    if (!update) {
                        JOptionPane.showMessageDialog(this, "User ID not found. Cannot update.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Profile updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        f.delete();
                        temp.renameTo(f);
                    }
        
                }catch(IOException e){
                    JOptionPane.showMessageDialog(this, "Error updating profile.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
         
                
            } else if(isDuplicateUserID(name,email)==2){
                jLabel9.setText("Error: Duplicate UserName.");
            }else if(isDuplicateUserID(name,email)==3){
                jLabel9.setText("Error: Duplicate Email Address.");
            }else if(isDuplicateUserID(name,email)==4){
                jLabel9.setText("Error: Duplicate UserName and Email Address.");
            }else{
                jLabel9.setText("Error: Invalid input.");
            }
        } else {
            jLabel9.setText("Error: Passwords do not match.");
        }
        
        
    } 
    }
   
    public UpdateProfile() {
        initComponents();
        load();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserroleTF = new javax.swing.JTextField();
        UserIDTF = new javax.swing.JTextField();
        SaveBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        UsernameTF = new javax.swing.JTextField();
        ContactNumberTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        EmailAddressTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ResetBtn = new javax.swing.JButton();
        passTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        passTF2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        BackBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UserroleTF.setEditable(false);
        UserroleTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserroleTFActionPerformed(evt);
            }
        });

        UserIDTF.setEditable(false);
        UserIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserIDTFActionPerformed(evt);
            }
        });

        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("User Role");

        jLabel2.setText("User ID");

        jLabel3.setText("Update Your Profile");

        jLabel4.setText("Username");

        jLabel5.setText("Contact Number");

        jLabel6.setText("Email Address");

        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Password");

        jLabel8.setText("Confirm Password");

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
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(SaveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ResetBtn)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(passTF2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(passTF, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UserroleTF, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(UserIDTF)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ContactNumberTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailAddressTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(114, 114, 114))
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(345, Short.MAX_VALUE)
                    .addComponent(BackBtn1)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserroleTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContactNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveBtn)
                    .addComponent(ResetBtn))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(BackBtn1)
                    .addContainerGap(264, Short.MAX_VALUE)))
        );

        passTF.getAccessibleContext().setAccessibleName("pass");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserroleTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserroleTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserroleTFActionPerformed

    private void UserIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserIDTFActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        edit();
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        load();
    }//GEN-LAST:event_ResetBtnActionPerformed

    private void BackBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtn1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_BackBtn1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(UpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn1;
    private javax.swing.JTextField ContactNumberTF;
    private javax.swing.JTextField EmailAddressTF;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JTextField UserIDTF;
    private javax.swing.JTextField UsernameTF;
    private javax.swing.JTextField UserroleTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField passTF;
    private javax.swing.JTextField passTF2;
    // End of variables declaration//GEN-END:variables
}
