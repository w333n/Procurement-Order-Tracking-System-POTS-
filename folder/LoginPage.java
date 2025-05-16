package assgm;
import assgm.manager.finance.FinanceManagerUI;
import assgm.manager.inventory.InventoryManagerUI;
import assgm.manager.purchase.PurchaseManagerUI;
import assgm.manager.sales.SalesManagerUI;
import assgm.manager.admin.AdminUI;
import java.io.*;

public class LoginPage extends javax.swing.JFrame {
    private String UserID,Pass;  
    private String Role;
    File file =new File("documents/Account.txt");
    private String [] data;
//    private String Password;

    public String getUserID() {
        return UserID;
    }

    public String getRole() {
        return Role;
    } 
    
    public String getPass(){
    return Pass;
    }

    public LoginPage() {
        initComponents();
        clearTF();
        jLabel3.setText("");
    }  
    
    public void clearTF(){ 
    UserIDTF.setText("");
    passTF.setText("");
    
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserIDTF = new javax.swing.JTextField();
        LoginBtn = new javax.swing.JButton();
        passTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UserIDTF.setText("UserID");
        UserIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserIDTFActionPerformed(evt);
            }
        });

        LoginBtn.setText("Login");
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        passTF.setText("Password");

        jLabel1.setText("UserID");

        jLabel2.setText("Password");

        jLabel3.setText("jLabel3");

        jButton1.setText("Leave");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LoginBtn)
                                    .addComponent(UserIDTF)
                                    .addComponent(passTF, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginBtn)
                    .addComponent(jButton1))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public boolean LoginSuccess(){
    UserID=UserIDTF.getText().trim();
    Pass=passTF.getText().trim();
    try{
    BufferedReader br = new BufferedReader (new FileReader (file));
    String line;
    while((line=br.readLine())!=null){
    data=line.split(",");
    if(UserID.equals(data[0])&&Pass.equals(data[5])){
        return true;
    }
    
    }
    
    }catch(IOException e){
    jLabel3.setText("Folder does not exist or is not a directory.");
    }
    
    return false;
    
    }
    
    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        if(LoginSuccess()){
        UserID = UserIDTF.getText();
        
        Object role = data[2];
        
        
        Role = role.toString();
        if(Role.equals("IM")){
            InventoryManagerUI imui = new InventoryManagerUI(this);
            imui.setVisible(true);
//            this.setVisible(false);
        }
        else if(Role.equals("SM")){
            SalesManagerUI smui = new SalesManagerUI(this);
            smui.setVisible(true);
//            this.setVisible(false);
        }
        else if(Role.equals("PM")){
            PurchaseManagerUI pmui = new PurchaseManagerUI(this);
            pmui.setVisible(true);
//            this.setVisible(false);
        }
        else if(Role.equals("FM")){
            FinanceManagerUI fmui = new FinanceManagerUI(this);
            fmui.setVisible(true);
//            this.setVisible(false);
        }
        else if(Role.equals("Admin")){
            AdminUI adui = new AdminUI(this);
            adui.setVisible(true);
//            this.setVisible(false);
        }
        }else{
        jLabel3.setText("UserID or password Incorrect.");
        }       
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void UserIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserIDTFActionPerformed
        
    }//GEN-LAST:event_UserIDTFActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginPage lp = new LoginPage();
                lp.setVisible(true);                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginBtn;
    private javax.swing.JTextField UserIDTF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField passTF;
    // End of variables declaration//GEN-END:variables
}
