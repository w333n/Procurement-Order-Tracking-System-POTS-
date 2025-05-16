package assgm.document;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import assgm.LoginPage;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GeneralFunction {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String UserID;
    private String Role;

    public GeneralFunction(LoginPage lp) throws IOException {
        this.UserID = lp.getUserID();
        this.Role = lp.getRole();
    }

    public GeneralFunction() {
    }

    public String createFile(String TxTName,String Status) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = Status + TxTName + timestamp + ".txt";
        if (Status == "ItemEntry.txt"){
            fileName = "ItemEntry.txt";
        }else if (Status == "SupplierEntry.txt"){
            fileName = "SupplierEntry.txt";
        }else if (Status == "StockLevels.txt"){
            fileName = "StockLevels.txt";
        }
        File file = new File("documents/" + fileName);
        file.getParentFile().mkdirs();
        file.createNewFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("UserID: " + UserID);
            writer.newLine();
            writer.write("Role: " + Role);
            writer.newLine();
            writer.write("Created At: " + DATE_FORMAT.format(new Date()));
            writer.newLine();
        }
        
        return fileName;
    }
 
    public void updateFileName(JList ListName, String NameBefore, String NameAfter ){
        Object object = ListName.getSelectedValue();
            String objectStr = object.toString(); 
            String newFileName = objectStr.replace(NameBefore,NameAfter);
            File oldFile = new File("documents/" + objectStr);
            File newFile = new File("documents/" + newFileName);
                
            if (oldFile.renameTo(newFile)) {
                System.out.println("File renamed successfully: " + newFileName);
                objectStr = newFileName; 
            } else {
               System.out.println("Failed to rename file.");
            }
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
                }
            }
        } else {
            System.out.println("Folder does not exist or is not a directory.");
        }
    }
    
    public void updateFileInfo(String TxTName, JList<String> ListName) throws IOException {
        String updateTime = DATE_FORMAT.format(new Date());
        String updateBy = UserID;
        String FileName = TxTName;
        if(TxTName == ""){
           Object SelectedTxT = ListName.getSelectedValue();
           String SelectedTxTStr = SelectedTxT.toString();
           System.out.println(SelectedTxTStr);
           FileName = SelectedTxTStr;        }
        File file = new File("documents/" + FileName);        
        StringBuilder fileContent = new StringBuilder();// Read existing content except for previous update records
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;     
            while ((line = reader.readLine()) != null) {                
                if (line.startsWith("Updated")) {
                    continue;                }
                fileContent.append(line).append(System.lineSeparator());            }        }        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {// Write the file content back with the new update record
            if (fileContent.length() > 0) {
                writer.write(fileContent.toString().trim());
                writer.newLine();            }
            writer.newLine();
            writer.write("Updated Time: " + updateTime);
            writer.newLine();
            writer.write("Updated By: " + updateBy + "-" + Role);
            writer.newLine();        }
        System.out.println("File updated successfully: " + FileName);
    }
    
    public void LoadTxTtoTable(File file,DefaultTableModel TableName){
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                if(line.startsWith("UserID") || line.startsWith("Role") || line.startsWith("Created At" )
                        || line.startsWith("Updated") || line.trim().isEmpty()){
                    continue;
                }  
                String[] rowData = line.split(",");
                TableName.addRow(rowData);
            }
            System.out.println("Table data loaded successfully.");
        } catch (IOException ex) {
            Logger.getLogger(GeneralFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SaveTabletoTxT(File file, DefaultTableModel TableName){
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;     
            while ((line = reader.readLine()) != null) { 
                if (line.startsWith("Updated")||line.startsWith("UserID")||line.startsWith("Role")||line.startsWith("Created")) {
                    fileContent.append(line).append(System.lineSeparator());                }            }
        } catch (IOException ex) {
            Logger.getLogger(GeneralFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            if (fileContent.length() > 0) {
                writer.write(fileContent.toString().trim());
                writer.newLine();            }
            writer.newLine();
            for(int i = 0; i < TableName.getRowCount(); i++){
                StringBuilder row = new StringBuilder();
                for(int j = 0; j < TableName.getColumnCount(); j++){
                    row.append(TableName.getValueAt(i, j));
                    if(j < TableName.getColumnCount() - 1){
                        row.append(",");                    }                }
                writer.write(row.toString());
                writer.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(GeneralFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadorsaveTableData(String LoadOrSave, String TxTName, JList<String> ListName, DefaultTableModel TableName ){
        if (TxTName == ""){
            Object SelectedTxT = ListName.getSelectedValue();
            String SelectedTxTStr = SelectedTxT.toString();
            File file = new File("documents/" + SelectedTxTStr);
            if (file.exists()) {
                if (LoadOrSave == "Load"){
                    LoadTxTtoTable(file, TableName);
                }else if(LoadOrSave == "Save"){
                    SaveTabletoTxT(file,TableName);
                }
            } 
        }else{
            File file = new File("documents/" + TxTName);
            if (file.exists()){
                if(LoadOrSave == "Load"){
                    LoadTxTtoTable(file, TableName);
                }else if (LoadOrSave == "Save"){
                    SaveTabletoTxT(file,TableName);
                }
            }
        }
    }
    
    public void ClearTabletoLoadTxT(DefaultTableModel TableModel){
        int rowCount = TableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) { // 倒序删除所有行
            TableModel.removeRow(i);
        }
    }
    
    public void replaceNullWithZero(DefaultTableModel tableModel) {
        for (int i = 0; i < tableModel.getRowCount(); i++) { // 遍历行
            for (int j = 0; j < tableModel.getColumnCount(); j++) { // 遍历列
                if (tableModel.getValueAt(i, j) == null || tableModel.getValueAt(i, j).toString().trim().isEmpty()) {
                    tableModel.setValueAt(0, i, j); // 将 null 或空字符串替换为 0
                }
            }
        }
        System.out.println("Null cells replaced with 0.");
    }
    
    //Overloading
    public void ShowSelectedList(JComboBox<String> YearCB, JComboBox<String> MonthCB, DefaultListModel<String> DSListModel, JList<String> DSList) {
        DefaultListModel<String> filteredModel = new DefaultListModel<>();

        String year = (String) YearCB.getSelectedItem();      
        String month = (String) MonthCB.getSelectedItem();    

        StringBuilder regexBuilder = new StringBuilder();
        regexBuilder.append("^.*"); 
        if (year != null && !year.isEmpty()) {
            regexBuilder.append(year);
        }
        if (month != null && !month.isEmpty()) {
            regexBuilder.append(String.format("%02d", Integer.parseInt(month))); 
        }
        regexBuilder.append("\\d{6}\\.txt$");

        String regex = regexBuilder.toString();

        for (int i = 0; i < DSListModel.size(); i++) {
            String fileName = DSListModel.getElementAt(i);

            if (fileName.matches(regex)) {
                filteredModel.addElement(fileName);
            }
        }

        DSList.setModel(filteredModel);

        System.out.println("Filtered files updated successfully.");
    }
    
    //Overloading
    public void ShowSelectedList(JComboBox<String> YearCB, JComboBox<String> MonthCB, JComboBox<String> DayCB, 
            DefaultListModel<String> DSListModel, JList<String> DSList) {
        DefaultListModel<String> filteredModel = new DefaultListModel<>();
        String year = (String) YearCB.getSelectedItem();      
        String month = (String) MonthCB.getSelectedItem();    
        String day = (String) DayCB.getSelectedItem();        

        StringBuilder regexBuilder = new StringBuilder();
        regexBuilder.append("^.*"); 
        if (year != null && !year.isEmpty()) {
            regexBuilder.append(year); 
        }
        if (month != null && !month.isEmpty()) {
            regexBuilder.append(String.format("%02d", Integer.parseInt(month))); 
        }
        if (day != null && !day.isEmpty()) {
            regexBuilder.append(String.format("%02d", Integer.parseInt(day))); 
        }
        regexBuilder.append("\\d{6}\\.txt$");
        String regex = regexBuilder.toString();
        for (int i = 0; i < DSListModel.size(); i++) {
            String fileName = DSListModel.getElementAt(i);
            if (fileName.matches(regex)) {
                filteredModel.addElement(fileName);
            }
        }
        DSList.setModel(filteredModel);
        System.out.println("Filtered files updated successfully.");
    }

    //Overloading
    public void GetDSDate(DefaultListModel<String> listModel, DefaultComboBoxModel<String> yearCB, 
            DefaultComboBoxModel<String> monthCB, DefaultComboBoxModel<String> dayCB) {
        Map<String, Map<String, Set<String>>> dateMap = new TreeMap<>();
        String regex = "\\d{14}(?=\\.txt$)";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < listModel.size(); i++) {
            String fileName = listModel.get(i);
            Matcher matcher = pattern.matcher(fileName);
            if (matcher.find()) {
                String timestamp = matcher.group(); 
                String year = timestamp.substring(0, 4);  
                String month = timestamp.substring(4, 6);  
                String day = timestamp.substring(6, 8); 
                dateMap.putIfAbsent(year, new TreeMap<>());
                dateMap.get(year).putIfAbsent(month, new TreeSet<>());
                dateMap.get(year).get(month).add(day);
            }        }
        yearCB.removeAllElements();
        monthCB.removeAllElements();
        dayCB.removeAllElements();
        for (String year : dateMap.keySet()) {
            yearCB.addElement(year); 
            Map<String, Set<String>> months = dateMap.get(year);
            for (String month : months.keySet()) {
                monthCB.addElement(month); 
                Set<String> days = months.get(month);
                for (String day : days) {
                    dayCB.addElement(day); 
                }
            }
        }
    }
    
    //Overloading
    public void GetDSDate(DefaultListModel<String> listModel, DefaultComboBoxModel<String> yearCB, 
            DefaultComboBoxModel<String> monthCB) {
        Map<String, Map<String, Set<String>>> dateMap = new TreeMap<>();

        String regex = "\\d{6}(?=\\.txt$)";
        Pattern pattern = Pattern.compile(regex);
        
        for (int i = 0; i < listModel.size(); i++) {
            String fileName = listModel.get(i);
            Matcher matcher = pattern.matcher(fileName);

            if (matcher.find()) {
                String timestamp = matcher.group(); 
                String year = timestamp.substring(0, 4);   
                String month = timestamp.substring(4, 6);  

                dateMap.putIfAbsent(year, new TreeMap<>());
                dateMap.get(year).putIfAbsent(month, new TreeSet<>());
                dateMap.get(year).get(month);
            }
        }
        
        yearCB.removeAllElements();
        monthCB.removeAllElements();
        
        for (String year : dateMap.keySet()) {
            yearCB.addElement(year);
            Map<String, Set<String>> months = dateMap.get(year);
            for (String month : months.keySet()) {
                monthCB.addElement(month);
                }
        }

    }
    
    public void GetItemsInList(DefaultListModel List) {
        File file = new File("documents/ItemEntry.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if(line.startsWith("UserID") || line.startsWith("Role") || line.startsWith("Created At" )|| line.startsWith("Updated") || line.trim().isEmpty()){
                        continue;
                    }

                    String[] columns = line.split(","); 
                    if (columns.length > 0) { 
                        String itemCode = columns[0];
                        List.addElement(itemCode);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(GeneralFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("File does not exist: " + file.getAbsolutePath());
        }
    }
    //Overloading
    public void ClearTextField(JTextField TF1, JTextField TF2, JTextField TF3, JTextField TF4){
        TF1.setText("");
        TF2.setText("");
        TF3.setText("");
        TF4.setText("");
    }
    //Overloading
    public void clearTextField(JTextField TF1, JTextField TF2, JTextField TF3){
        TF1.setText("");
        TF2.setText("");
        TF3.setText("");
    }

    public void CheckListSelectedBeforeShowTable(GeneralFunction gf, JList List, DefaultTableModel TableName){
        Object ob = List.getSelectedValue();
        if(!(ob == null)){
            gf.loadorsaveTableData("Load", "", List, TableName);
        }
    }
    
    public void SearchItem(JTextField TF, DefaultListModel ListModel, JList List) {
        String ItemCode = TF.getText().trim(); 
        File file = new File("documents/ItemEntry.txt");
        ListModel.clear(); 

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length > 0) {
                    String Code = columns[0].trim();
                    if(line.startsWith("UserID") || line.startsWith("Role") || 
                            line.startsWith("Created At" )|| line.startsWith("Updated") || line.trim().isEmpty()){
                            continue;
                    }
                    if (ItemCode.isEmpty() || Code.startsWith(ItemCode)) { 
                        
                        ListModel.addElement(Code);
                    }
                }
            }
            List.setModel(ListModel); 
        } catch (IOException ex) {
            Logger.getLogger(GeneralFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ShowSelectedItem(String TxTName,JTextField TF,JList List,int tablec,int listc){
        Object ob = List.getSelectedValue();

        if (ob != null) {
            String selectedItemCode = ob.toString(); 
            String value = ""; 

            File file = new File("documents/"+TxTName);
            if (file.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if(line.startsWith("UserID") || line.startsWith("Role") || line.startsWith("Created At" )|| line.startsWith("Updated") || line.trim().isEmpty()) {
                            continue;
                        }

                        String[] columns = line.split(",");
                        if (columns.length > 1 && columns[listc].trim().equals(selectedItemCode)) {
                            value = columns[tablec].trim();
                            break; 
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File does not exist: " + file.getAbsolutePath());
            }

            TF.setText(value);
            TF.setEditable(false);
        } else {
            System.out.println("No item selected in the list.");
        }
    }
    
    public boolean IntegerInput(JTextField TF){
        String input = TF.getText(); 
        try {
            Integer.parseInt(input); 
            return true; 
        } catch (NumberFormatException e) {
            return false;
        }
    }
}


