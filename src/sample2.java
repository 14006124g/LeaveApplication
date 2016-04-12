import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;




public class sample2 extends JFrame {
	private static final String Function = null;
	//  public  ArrayList<String> ArrListStaff = new ArrayList<String>();
    private JPanel cardPanel, panel1, panel2, buttonPanel;
    private CardLayout cardLayout = new CardLayout();
    private JTable table = new JTable();
    private JTable tableLeave = new JTable();
    private DefaultTableModel modelLeave = new DefaultTableModel();
    private DefaultTableModel modelTemp = new DefaultTableModel();
    public  JComboBox comboBoxStaff= new JComboBox();
    public  JComboBox comboBoxSuper= new JComboBox();
    //public  JComboBox comboBoxSuper= new JComboBox();
    //public  JComboBox comboBoxApprover = new JComboBox();
    //public  JComboBox comboBoxOwner = new JComboBox();
    public  JComboBox comboBoxStatus = new JComboBox();
    private JLabel labRole = new JLabel("Role: ");
    private static TableRowSorter<TableModel> sorter;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
            	sample2 frame = new sample2();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
    
    public sample2() {
        setTitle("Leave Application System");
        setSize(900, 450);
        setLocationRelativeTo(null);
        cardPanel = new JPanel();       
        buttonPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        
        
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        panel1.setLayout(null);
        panel1.setLocation(0, 0);
        panel1.setSize(880, 340);
        panel1.setAlignmentX(0);
        
        panel2.setLayout(null);
        panel2.setLocation(0, 0);
        panel2.setSize(880, 340);
        panel2.setAlignmentX(0);
        
        
        //buttonPanel.setLayout(null);
        //buttonPanel.setLocation(700, 340);
        //buttonPanel.setSize(880, 110);
        //buttonPanel.setAlignmentX(0);
        //buttonPanel.setLayout(new BorderLayout(0,0));
        
        // create a table modelStaff and set a Column Identifiers to this modelStaff 
        Object[] columns = {"Staff ID", "Name", "Department", "Supervisor", "AL in This Year"};
        DefaultTableModel modelStaff = new DefaultTableModel();
        modelStaff.setColumnIdentifiers(columns);

        // set the modelStaff to the table
        table.setModel(modelStaff);
        //table.setEnabled(false);
        //table.setCellSelectionEnabled(true);
        //table.setFocusable(false);
        //table.setCellSelectionEnabled(false);
        //table.enableInputMethods(false);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        String[] dataRow0 = {"0", "Administrator", "Admin", "0", "0"};
        modelStaff.addRow(dataRow0);


        
        // Change A JTable Background Color, Font Size, Font Color, Row Height
        //table.setBackground(Color.LIGHT_GRAY);
        //table.setForeground(Color.black);
        //Font font = new Font("",1,22);
        //table.setFont(font);
        //table.setRowHeight(30);
        
        JTextField textId = new JTextField();
        JTextField textFname = new JTextField();
        JTextField textDep = new JTextField();
        JTextField textRight = new JTextField();
        JTextField textJointDate = new JTextField();
        JButton btnStaff = new JButton("Manage Staff");
        JButton btnLeave = new JButton("Apply Leave");
        JButton btnAdd = new JButton("Create");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");    
        JButton btnDemoData = new JButton("Import data");    
        JButton btnCleanList = new JButton("Clean List"); 
        JLabel labId = new JLabel("Staff ID:");
        JLabel labName = new JLabel("Name:");
        JLabel labDepartment = new JLabel("Department:");
        JLabel labRight = new JLabel("Supervisor:");
        JLabel labAL = new JLabel("AL in This Year:");
        
        JLabel labStatus = new JLabel("System Status: Start");
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setLocation(300, 0);
        topPanel.setSize(350, 30);
        topPanel.setAlignmentX(0);
        
        JLabel labHeader = new JLabel("Staff Information Management");
        labHeader.setLocation(0, 0);
        labHeader.setSize(320, 30);
        Font font = new Font("",1,22);
        labHeader.setFont(font);
        labHeader.setHorizontalAlignment(0);
        topPanel.add(labHeader);
        
        labId.setBounds(20, 190, 100, 25);
        labName.setBounds(20, 220, 100, 25);
        labDepartment.setBounds(20, 250, 100, 25);
        labRight.setBounds(20, 280, 100, 25);
        labAL.setBounds(20, 310, 100, 25);
        labStatus.setBounds(365, 340, 250, 25);
        
        textId.setBounds(120, 190, 100, 25);
        textFname.setBounds(120, 220, 100, 25);
        textDep.setBounds(120, 250, 100, 25);
        //textRight.setBounds(120, 280, 100, 25);
        comboBoxSuper.setBounds(120, 280, 100, 25);
        textJointDate.setBounds(120, 310, 100, 25);
        
        btnAdd.setBounds(20, 340, 100, 25);
        btnUpdate.setBounds(135, 340, 100, 25);
        btnDelete.setBounds(250, 340, 100, 25);
        //btnDemoData.setBounds(740, 200, 100, 25);
        //btnCleanList.setBounds(740, 225, 100, 25);
        btnDemoData.setBounds(780, 190, 100, 25);
        btnCleanList.setBounds(780, 215, 100, 25);
        btnStaff.setBounds(600, 0, 120, 25);
        btnLeave.setBounds(740, 0, 120, 25);
        
        
        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 25, 880, 160);

        panel1.add(textId);
        panel1.add(textFname);
        panel1.add(textDep);
        //panel1.add(textRight);
        panel1.add(textJointDate);
        panel1.add(btnAdd);
        panel1.add(btnDelete);
        panel1.add(btnUpdate);
        panel1.add(btnDemoData);
        panel1.add(btnCleanList);
        panel1.add(labId);
        panel1.add(labName);
        panel1.add(labDepartment);
        panel1.add(labRight);
        panel1.add(labAL);
        
        panel1.add(pane);
        panel1.add(topPanel);
        panel1.add(labStatus);
        
        panel1.add(comboBoxSuper);
        
        
        
        JPanel topPanel2 = new JPanel();
        topPanel2.setLayout(null);
        topPanel2.setLocation(300, 0);
        topPanel2.setSize(350, 30);
        topPanel2.setAlignmentX(0);
        
        JLabel labHeader2 = new JLabel("Apply Leave Application");
        labHeader2.setLocation(0, 0);
        labHeader2.setSize(320, 30);
        Font font2 = new Font("",1,22);
        labHeader2.setFont(font2);
        labHeader2.setHorizontalAlignment(0);
        topPanel2.add(labHeader2);

        Object[] columns2 = {"Leave ID", "Staff", "Date From", "Date To", "Status", "Supervisor", "Last Updated By", "Notice Owner", "Notice Superviser"};
        //DefaultTableModel modelLeave = new DefaultTableModel();
        modelLeave.setColumnIdentifiers(columns2);
        tableLeave.setModel(modelLeave);
        tableLeave.setRowSelectionAllowed(true);
        tableLeave.setColumnSelectionAllowed(false);
        
        JScrollPane paneLeave = new JScrollPane(tableLeave);

        paneLeave.setBounds(0, 25, 880, 160);
        comboBoxStaff.setBounds(700, 280, 180, 25);
        //comboBoxSuper.setBounds(120, 280, 100, 25);
        //comboBoxApprover.setBounds(350, 280, 100, 25);
        //comboBoxOwner.setBounds(120, 220, 100, 25);
        comboBoxStatus.setBounds(120, 310, 100, 25);
        labRole.setBounds(700, 320, 250, 25);
        JTextField textLeaveID = new JTextField();
        JTextField textStaffID2 = new JTextField();
        JTextField textDateFrom = new JTextField();
        JTextField textDateTo = new JTextField();
        JTextField textStatus = new JTextField();
        JTextField textSupervisor = new JTextField();
        JTextField textApprovedBy = new JTextField();
        JButton btnCreateLeave = new JButton("New");
        JButton btnDeleteLeave = new JButton("Delete");
        JButton btnEditLeave = new JButton("Update");    
        JButton btnDemoDataLeave = new JButton("Import data");    
        JButton btnCleanListLeave = new JButton("Clean List"); 
        JButton btnEndorse = new JButton("Endorse"); 
        JButton btnDecline = new JButton("Decline"); 
        JLabel labLeaveId = new JLabel("Leave ID:");
        JLabel labStaffID2 = new JLabel("Staff:");
        JLabel labDateFrom = new JLabel("Date From:");
        JLabel labDateTo = new JLabel("Date To:");
        JLabel labStatus2 = new JLabel("Status:");
        JLabel labSupervisor = new JLabel("Supervisor:");
        JLabel labApprovedBy = new JLabel("Approved By:");
        JLabel labSystemStatus = new JLabel("System Status: Start");
        JLabel labDateFromYY = new JLabel("(YYYYMMDD)");
        
        
        JButton btnCheckNotice = new JButton("Notice"); 
        btnCheckNotice.setBounds(250, 190, 80, 25);
        JTextArea textNotice = new JTextArea("");
        //textNotice.setBounds(350, 190, 250, 50);
        JScrollPane areaScrollPane = new JScrollPane(textNotice); 
        areaScrollPane.setBounds(350, 190, 250, 50);
        textNotice.setEditable(false);

        
        labLeaveId.setBounds(20, 190, 100, 25);
        labStaffID2.setBounds(20, 220, 100, 25);
        labDateFrom.setBounds(20, 250, 100, 25);
        labDateTo.setBounds(250, 250, 100, 25);
        labStatus2.setBounds(20, 310, 100, 25);
        labSupervisor.setBounds(20, 280, 100, 25);
        labApprovedBy.setBounds(250, 280, 100, 25);
        labSystemStatus.setBounds(650, 340, 250, 25);
        labDateFromYY.setBounds(450, 250, 100, 25);
        textLeaveID.setBounds(120, 190, 100, 25);
        textLeaveID.enable(false);
        textStaffID2.setBounds(120, 220, 100, 25);
        textStaffID2.enable(false);
        textDateFrom.setBounds(120, 250, 100, 25);
        textDateFrom.enable(false);
        textDateTo.setBounds(350, 250, 100, 25);
        textDateTo.enable(false);
        textStatus.setBounds(120, 310, 100, 25);
        textStatus.enable(false);
        textSupervisor.setBounds(120, 280, 100, 25);
        textSupervisor.enable(false);
        textApprovedBy.setBounds(350, 280, 100, 25);
        textApprovedBy.enable(false);
        btnCreateLeave.setBounds(20, 340, 100, 25);
        btnEditLeave.setBounds(135, 340, 100, 25);
        btnEditLeave.enable(false);
        btnDeleteLeave.setBounds(250, 340, 100, 25);
        btnDeleteLeave.enable(false);
        btnEndorse.setBounds(365, 340, 100, 25);
        btnEndorse.enable(false);
        btnDecline.setBounds(480, 340, 100, 25);
        btnDecline.enable(false);
        btnDemoDataLeave.setBounds(780, 190, 100, 25);
        btnDemoDataLeave.enable(false);
        btnCleanListLeave.setBounds(780, 215, 100, 25);
        btnCleanListLeave.enable(false);
        //comboBoxSuper.enable(false);
        //comboBoxApprover.enable(false);
        //comboBoxOwner.enable(false);
        comboBoxStatus.enable(false);
        
        
        //UtilDateModel model2 = new UtilDateModel();
        //JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, null);
        //JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter();
        //datePicker2.setBounds(120, 250, 100, 25);
        
        
        panel2.add(textLeaveID);
        panel2.add(textStaffID2);
        panel2.add(textDateFrom);
        //panel2.add(datePicker2);
        panel2.add(textDateTo);
        //panel2.add(textStatus);
        panel2.add(textSupervisor);
        panel2.add(textApprovedBy);
        panel2.add(btnCreateLeave);
        panel2.add(btnDeleteLeave);
        panel2.add(btnEditLeave);
        panel2.add(btnDemoDataLeave);
        panel2.add(btnCleanListLeave);
        panel2.add(labLeaveId);
        panel2.add(labStaffID2);
        panel2.add(labDateFrom);
        panel2.add(labDateTo);
        panel2.add(labStatus2);
        //panel2.add(labSystemStatus);
        panel2.add(labSupervisor);
        panel2.add(labApprovedBy);
        panel2.add(labDateFromYY);
        panel2.add(paneLeave);
        panel2.add(topPanel2);
        panel2.add(comboBoxStaff);
        //panel2.add(comboBoxSuper);
        //panel2.add(comboBoxApprover);
        //panel2.add(comboBoxOwner);
        panel2.add(comboBoxStatus);
        panel2.add(labRole);
        panel2.add(btnEndorse);
        panel2.add(btnDecline);
        panel2.add(btnCheckNotice);
        panel2.add(areaScrollPane);
        
        
        comboBoxStatus.removeAllItems();
        comboBoxStatus.addItem("Pending");
        comboBoxStatus.addItem("Endorse");
        comboBoxStatus.addItem("Decline");
        comboBoxStatus.addItem("Success");
        //comboBoxSuper.addItem("");
        //comboBoxApprover.addItem("");
   
        buttonPanel.add(btnStaff);
        buttonPanel.add(btnLeave);
        
        cardPanel.add(panel1, "1");
        cardPanel.add(panel2, "2");
       
        // create an array of objects to set the row data
        Object[] row = new Object[5];
        Object[] rowLeave = new Object[9];
        
        
        // button add row
        btnAdd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                row[0] = textId.getText();
                row[1] = textFname.getText();
                row[2] = textDep.getText();
                //row[3] = textRight.getText();
                row[3] = comboBoxSuper.getSelectedItem().toString();
                row[4] = textJointDate.getText();
                
                // add row to the modelStaff
                modelStaff.addRow(row);
                labStatus.setText("System Status:Success Create (Staff ID:" + textId.getText() +")");
            }
        });
        
        // button remove row
        btnDelete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = table.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                    modelStaff.removeRow(i);
                    labStatus.setText("System Status:Delete success(Staff ID:" + textId.getText() +")");
                }
                else{
                    labStatus.setText("System Status:Delete Error");
                }
            }
        });
        
        // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            textId.setText(modelStaff.getValueAt(i, 0).toString());
            textFname.setText(modelStaff.getValueAt(i, 1).toString());
            textDep.setText(modelStaff.getValueAt(i, 2).toString());
            //textRight.setText(modelStaff.getValueAt(i, 3).toString());
            comboBoxSuper.setSelectedItem(modelStaff.getValueAt(i, 3).toString());
            textJointDate.setText(modelStaff.getValueAt(i, 4).toString());
        }
        });
        
        // button update row
        btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                // i = the index of the selected row
                int i = table.getSelectedRow();
                //boolean bloExist = false;
     
                if(i >= 0) 
                {  
                   modelStaff.setValueAt(textId.getText(), i, 0);
                   modelStaff.setValueAt(textFname.getText(), i, 1);
                   modelStaff.setValueAt(textDep.getText(), i, 2);
                   modelStaff.setValueAt(comboBoxSuper.getSelectedItem().toString(), i, 3);
                   modelStaff.setValueAt(textJointDate.getText(), i, 4);
                   labStatus.setText("System Status:Update success(Staff ID:" + textId.getText() +")");
                }
                else{
                	labStatus.setText("System Status:Please select row to update.");
                }
            }
        });
        
        // button import demo data
        btnDemoData.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
            	while(modelStaff.getRowCount() > 0)
            	{
            		modelStaff.removeRow(0);
            	}
            	
            	String[] dataRow0 = {"0", "Administrator", "Admin", "0", "0"};
                String[] dataRow1 = {"1", "Peter Chan", "Accounting", "Paul Wong", "7"};
                String[] dataRow2 = {"2", "Chris Wong", "Accounting", "Peter Chan", "7"};
                String[] dataRow3 = {"3", "Doris Chow", "Accounting", "Paul Wong", "10"};
                String[] dataRow4 = {"4", "Eric Poon", "Accounting", "Doris Chow", "17"};
                String[] dataRow5 = {"5", "Agnes Choi", "Accounting", "Doris Chow", "18"};
                String[] dataRow6 = {"6", "Kelvin Wong", "Accounting", "Paul Wong", "7"};
                String[] dataRow7 = {"7", "Adam Cheung", "Accounting", "Kelvin Wong", "10"};
                String[] dataRow8 = {"8", "Tom Fung", "Accounting", "Kelvin Wong", "17"};
                String[] dataRow9 = {"9", "Max Pang", "Accounting", "Kelvin Wong", "18"};
                String[] dataRow10 = {"10", "Paul Wong", "Accounting", "Director", "18"};

                modelStaff.addRow(dataRow0);
                modelStaff.addRow(dataRow1);
                modelStaff.addRow(dataRow2);
                modelStaff.addRow(dataRow3);
                modelStaff.addRow(dataRow4);
                modelStaff.addRow(dataRow5);
                modelStaff.addRow(dataRow6);
                modelStaff.addRow(dataRow7);
                modelStaff.addRow(dataRow8);
                modelStaff.addRow(dataRow9);
                modelStaff.addRow(dataRow10);
                

                comboBoxSuper.removeAllItems();
                for(int j = 0; j < modelStaff.getRowCount(); j++)
                	{
                	comboBoxSuper.addItem(modelStaff.getValueAt(j, 1).toString());
                	}


                labStatus.setText("System Status:Success import data.");

            }
        });
        
        // button import demo data Leave
        btnDemoDataLeave.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
            	//{"Leave ID", "Staff ID", "Date From", "Date To", "Status", "Supervisor", "Approved By"};
            	
                String[] dataRow1 = {"1", "Peter Chan", "20160314", "20160315", "Pending", "Paul Wong", "", "", ""};
                String[] dataRow2 = {"2", "Chris Wong", "20160424", "20160427", "Pending", "Peter Chan", "", "", ""};
                String[] dataRow3 = {"3", "Eric Poon", "20160504", "20160507", "Pending", "Doris Chow", "", "", ""};
                String[] dataRow4 = {"4", "Eric Poon", "20160214", "20160218", "Pending", "Doris Chow", "", "", ""};
                String[] dataRow5 = {"5", "Eric Poon", "20160611", "20160611", "Pending", "Doris Chow", "", "", ""};
                String[] dataRow6 = {"6", "Kelvin Wong", "20160722", "20160723", "Pending", "Paul Wong", "", "", ""};
                String[] dataRow7 = {"7", "Kelvin Wong", "20160301", "20160303", "Pending", "Paul Wong", "", "", ""};
                String[] dataRow8 = {"8", "Kelvin Wong", "20160914", "20160917", "Endorse", "Paul Wong", "", "", ""};
                String[] dataRow9 = {"9", "Max Pang", "20160112", "20160113", "Endorse", "Kelvin Wong", "", "", ""};
                String[] dataRow10 = {"10", "Max Pang", "20160815", "20160815", "Decline", "Kelvin Wong", "", "", ""};

                modelLeave.addRow(dataRow1);
                modelLeave.addRow(dataRow2);
                modelLeave.addRow(dataRow3);
                modelLeave.addRow(dataRow4);
                modelLeave.addRow(dataRow5);
                modelLeave.addRow(dataRow6);
                modelLeave.addRow(dataRow7);
                modelLeave.addRow(dataRow8);
                modelLeave.addRow(dataRow9);
                modelLeave.addRow(dataRow10);


                labSystemStatus.setText("System Status:Success import data.");

            }
        });
        
        // button clean list
        btnCleanList.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	while(modelStaff.getRowCount() > 0)
            	{
            		modelStaff.removeRow(0);
            	}
                labStatus.setText("System Status:Success Clean List.");

            }
        });
        
        // Leave button clean list
        btnCleanListLeave.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	while(modelLeave.getRowCount() > 0)
            	{
            		modelLeave.removeRow(0);
            	}
            	labSystemStatus.setText("System Status:Success Clean List.");

            }
        });

        // button apply leave
        btnLeave.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	String strTest = "";
            	cardLayout.show(cardPanel, "2");
                labStatus.setText("System Status:Start apply leave.");
                labRole.setText("Staff Role: ");
                //if (comboBoxStaff.getItemCount() > 0)
                //{
                	//comboBoxStaff.removeAll();
                comboBoxStaff.removeAllItems();
                for(int j = 0; j < modelStaff.getRowCount(); j++)
                	{
                		comboBoxStaff.addItem(modelStaff.getValueAt(j, 1).toString());
                	}
                	
            }
        });
        
        // button manage staff
        btnStaff.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	cardLayout.show(cardPanel, "1");
                labStatus.setText("System Status:Start manage staff.");
            }
        });
        
        
        // comboBox select Staff role
        comboBoxStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (comboBoxStaff.getItemCount() > 0)
            	{
            	labRole.setText("Staff Role: " + comboBoxStaff.getSelectedItem().toString());

            	if (comboBoxStaff.getSelectedItem().toString() != "Administrator")
                {
            		btnEditLeave.setEnabled(false);
                    btnDeleteLeave.setEnabled(false);
                    btnEndorse.setEnabled(false);
                    btnDecline.setEnabled(false);
                    btnDemoDataLeave.setEnabled(false);
                    btnCleanListLeave.setEnabled(false);
                    comboBoxStatus.setEnabled(false);
            	}
            	else
            	{
            		btnEditLeave.setEnabled(true);
                    btnDeleteLeave.setEnabled(true);
                    btnEndorse.setEnabled(true);
                    btnDecline.setEnabled(true);
                    btnDemoDataLeave.setEnabled(true);
                    btnCleanListLeave.setEnabled(true);
                    comboBoxStatus.setEnabled(true);
            	}
            	}
            }
        });
        
        // Leave get selected row data From table to textfields 
        tableLeave.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            // i = the index of the selected row
            int i = tableLeave.getSelectedRow();
            
            String strTest1 = "";
            String strTest2 = "";
            strTest1 = comboBoxStaff.getSelectedItem().toString();
            strTest2 = tableLeave.getValueAt(i, 1).toString();
           
        	
            textLeaveID.setText(tableLeave.getValueAt(i, 0).toString());
            textStaffID2.setText(tableLeave.getValueAt(i, 1).toString());
            textDateFrom.setText(tableLeave.getValueAt(i, 2).toString());
            textDateTo.setText(tableLeave.getValueAt(i, 3).toString());
            //textStatus.setText(tableLeave.getValueAt(i, 4).toString());
            comboBoxStatus.setSelectedItem(tableLeave.getValueAt(i, 4).toString());
            textSupervisor.setText(tableLeave.getValueAt(i, 5).toString());
            textApprovedBy.setText(tableLeave.getValueAt(i, 6).toString());
            if (comboBoxStaff.getSelectedItem().toString() == "Administrator")
            {
            	textStaffID2.enable(false);
            	textLeaveID.enable(true);
                textDateFrom.enable(true);
                textDateTo.enable(true);
                textStatus.enable(true);
                textSupervisor.enable(true);
                textApprovedBy.enable(true);
                
                btnCreateLeave.setEnabled(true);
                btnEditLeave.setEnabled(true);
                btnDeleteLeave.setEnabled(true);
                btnEndorse.setEnabled(true);
                btnDecline.setEnabled(true);
                btnDemoDataLeave.setEnabled(true);
                btnCleanListLeave.setEnabled(true);
                
                
                
                //comboBoxSuper.setEnabled(true);
                //comboBoxApprover.setEnabled(true);
                //comboBoxOwner.setEnabled(true);
                comboBoxStatus.setEnabled(true);
            }
            //else if (comboBoxStaff.getSelectedItem().toString() == tableLeave.getValueAt(i, 1).toString())
            //else if (strTest1 == strTest2)
            else if (strTest1.equals(strTest2))
            {
            	if (tableLeave.getValueAt(i, 4).toString() == "Pending")
                {
            		textDateFrom.enable(true);
            		textDateTo.enable(true);
                    btnEditLeave.setEnabled(true);
                    btnDeleteLeave.setEnabled(true);
                    
                    textLeaveID.enable(false);
                    textStaffID2.enable(false);
                    textSupervisor.enable(false);
                    textApprovedBy.enable(false);
                    //comboBoxSuper.setEnabled(false);
                    //comboBoxApprover.setEnabled(false);
                    //comboBoxOwner.setEnabled(false);
                    btnEditLeave.setEnabled(true);
                    btnDeleteLeave.setEnabled(false);
                    btnEndorse.setEnabled(false);
                    btnDecline.setEnabled(false);
                    btnDemoDataLeave.setEnabled(false);
                    btnCleanListLeave.setEnabled(false);
                    comboBoxStatus.setEnabled(false);
                }
                
            }
            
            else if (comboBoxStaff.getSelectedItem().toString().equals(tableLeave.getValueAt(i, 5).toString()))
            {
            	textStatus.enable(true);
            	btnEditLeave.setEnabled(true);
                btnEndorse.setEnabled(true);
                btnDecline.setEnabled(true);
                
                comboBoxStatus.setEnabled(false);
                textLeaveID.enable(false);
                textStaffID2.enable(false);
                textSupervisor.enable(false);
                textApprovedBy.enable(false);
                //comboBoxSuper.setEnabled(false);
                //comboBoxApprover.setEnabled(false);
                //comboBoxOwner.setEnabled(false);
                btnEditLeave.setEnabled(false);
                btnDeleteLeave.setEnabled(false);
                btnDemoDataLeave.setEnabled(false);
                btnCleanListLeave.setEnabled(false);
            }
            
            //strLastID = String.valueOf(modelLeave.getRowCount()+1);
        	//for (int k =0; k < modelStaff.getRowCount(); k++)
        	//{	if(comboBoxStaff.getSelectedItem().toString() == modelStaff.getValueAt(k, 1).toString())
			//	{	
        	//	strSuper = modelStaff.getValueAt(k, 3).toString();
			//	}
        	//}
            
            
            else
            {
            	textLeaveID.enable(false);
            	textStaffID2.enable(false);
                textDateFrom.enable(false);
                textDateTo.enable(false);
                textStatus.enable(false);
                textSupervisor.enable(false);
                textApprovedBy.enable(false);
                btnEditLeave.setEnabled(false);
                btnDeleteLeave.setEnabled(false);
                btnEndorse.setEnabled(false);
                btnDecline.setEnabled(false);
                btnDemoDataLeave.setEnabled(false);
                btnCleanListLeave.setEnabled(false);
                //comboBoxSuper.setEnabled(false);
                //comboBoxApprover.setEnabled(false);
                //comboBoxOwner.setEnabled(false);
                comboBoxStatus.setEnabled(false);
            }
        }
        });
        
        // Leave button Endorse 
        btnEndorse.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = tableLeave.getSelectedRow();
                if(i >= 0){
                	comboBoxStatus.setSelectedItem("Endorse");
                	String strSuper = "";
                	for (int k =0; k < modelStaff.getRowCount(); k++)
                	{	if(comboBoxStaff.getSelectedItem().toString() == modelStaff.getValueAt(k, 1).toString())
    					{	
                		strSuper = modelStaff.getValueAt(k, 3).toString();
    					}
                	}
                	
                	
                	textApprovedBy.setText(comboBoxStaff.getSelectedItem().toString());
                	int strTest1, strTest2 ;
                	int p = -1;
                	for (int j = 0; j < modelLeave.getRowCount() ; j++)
                	{
                		strTest1 = Integer.parseInt(modelLeave.getValueAt(j, 0).toString().trim());
                		strTest2 = Integer.parseInt(textLeaveID.getText().toString().trim());
                		if (strTest1 == strTest2)
                			{p = j ;}
                	}
                    if(p >= 0) 
                    {  
                    	if (strSuper == "Director")
                    	{
                    		modelLeave.setValueAt("Success", i, 4);
                        	modelLeave.setValueAt("", i, 5);
                        	modelLeave.setValueAt("1", i, 7);
                        	modelLeave.setValueAt("Director", i, 6);
                    	}
                    	else
                    	{
                    		modelLeave.setValueAt("Endorse", i, 4);
                    		modelLeave.setValueAt(strSuper, i, 5);
                    		modelLeave.setValueAt("1", i, 7);
                    		modelLeave.setValueAt("1", i, 8);
                    		modelLeave.setValueAt(comboBoxStaff.getSelectedItem().toString(), i, 6);
                    	}
                    }
                	labSystemStatus.setText("System Status:Leave endorse(Leave ID:" + textLeaveID.getText() +")");
                }
                else{
                	labSystemStatus.setText("System Status:Endorse Error");
                }
            }
        });
        
        // Leave button Decline 
        btnDecline.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = tableLeave.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                	comboBoxStatus.setSelectedItem("Decline");
                	textApprovedBy.setText(comboBoxStaff.getSelectedItem().toString());
                	int strTest1, strTest2 ;
                	int p = -1;
                	for (int j = 0; j < modelLeave.getRowCount() ; j++)
                	{
                		strTest1 = Integer.parseInt(modelLeave.getValueAt(j, 0).toString().trim());
                		strTest2 = Integer.parseInt(textLeaveID.getText().toString().trim());
                		if (strTest1 == strTest2)
                			{p = j ;}
                	}
                    if(p >= 0) 
                    {  
                    	modelLeave.setValueAt("Decline", i, 4);
                    	modelLeave.setValueAt("1", i, 7);
                    	modelLeave.setValueAt(comboBoxStaff.getSelectedItem().toString(), i, 6);
                    }
                    
                	labSystemStatus.setText("System Status:Leave decline(Leave ID:" + textLeaveID.getText() +")");
                }
                else{
                	labSystemStatus.setText("System Status:Decline Error");
                }
            }
        });

        // Leave button add row
        btnCreateLeave.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                String strLastID = "", strTest = "";
                String strSuper = "", strApprover = "";
                if (modelLeave.getRowCount() > 0)
                {	strLastID = String.valueOf(modelLeave.getRowCount()+1);
                	for (int k =0; k < modelStaff.getRowCount(); k++)
                	{	if(comboBoxStaff.getSelectedItem().toString() == modelStaff.getValueAt(k, 1).toString())
    					{	
                		strSuper = modelStaff.getValueAt(k, 3).toString();
    					}
                	}
                }
            	if (btnCreateLeave.getText().toString() == "New")
            	{
            		textLeaveID.enable(false);
            		textLeaveID.setText(strLastID);
            		textStaffID2.enable(false);
            		textStaffID2.setText(comboBoxStaff.getSelectedItem().toString());
            		textDateFrom.enable(true);
            		textDateFrom.setText("");
            		textDateTo.enable(true);
            		textDateTo.setText("");
            		comboBoxStatus.enable(false);
            		comboBoxStatus.setSelectedIndex(0);
            		textSupervisor.enable(false);
            		textSupervisor.setText(strSuper);
            		textApprovedBy.enable(false);
            		textApprovedBy.setText(strApprover);
            		btnCreateLeave.setText("Create");
            		labSystemStatus.setText("System Status: Create a leave");
            	}
            	else
            	{
            		rowLeave[0] = strLastID;
            		rowLeave[1] = textStaffID2.getText().toString().trim();
            		rowLeave[2] = textDateFrom.getText().toString().trim();
            		rowLeave[3] = textDateTo.getText().toString().trim();
            		rowLeave[4] = comboBoxStatus.getSelectedItem().toString().trim();
            		rowLeave[5] = textSupervisor.getText().toString().trim();
            		rowLeave[6] = textApprovedBy.getText().toString().trim();
            		rowLeave[7] = ""; 
            		rowLeave[8] = ""; 
            		btnCreateLeave.setText("New");
                
            		modelLeave.addRow(rowLeave);
            		labSystemStatus.setText("System Status:Success Create (Leave ID:" + textLeaveID.getText() +")");
            	}
            }

			private String ToString(int rowCount) {
				// TODO Auto-generated method stub
				return null;
			}
        });
        
        // Leave button remove row
        btnDeleteLeave.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            
                // i = the index of the selected row
                int i = tableLeave.getSelectedRow();
                if(i >= 0){
                    // remove a row from jtable
                	modelLeave.removeRow(i);
                	labSystemStatus.setText("System Status:Delete success(Leave ID:" + textLeaveID.getText() +")");
                }
                else{
                	labSystemStatus.setText("System Status:Delete Error");
                }
            }
        });
        
        
     // button Check notice
        btnCheckNotice.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	String str_Text = "";
            	textNotice.setText(str_Text);
            	String strUser = "";
            	String strOwner = "";
            	
            	for (int k =0; k < modelLeave.getRowCount(); k++)
            	{	if(modelLeave.getValueAt(k, 7).toString() == "1" && modelLeave.getValueAt(k, 1).toString() == comboBoxStaff.getSelectedItem().toString())
					{	
            			if(modelLeave.getValueAt(k, 4).toString() == "Endorse")
            			{
            				str_Text = str_Text + "Leave ID: " + modelLeave.getValueAt(k, 0).toString() + " Endorsed by " + modelLeave.getValueAt(k, 6).toString();
            			}
            			else if(modelLeave.getValueAt(k, 4).toString() == "Decline")
            			{
            				str_Text = str_Text + "Leave ID: " + modelLeave.getValueAt(k, 0).toString() + " Declined by " + modelLeave.getValueAt(k, 6).toString();
            			}
            			else if(modelLeave.getValueAt(k, 4).toString() == "Success")
            			{
            				str_Text = str_Text + "Leave ID: " + modelLeave.getValueAt(k, 0).toString() + " Endorsed by Director";
            			}
            			modelLeave.setValueAt("", k, 7);
                    	str_Text = str_Text + "\n";
					}
            	
            	strUser=comboBoxStaff.getSelectedItem().toString().trim();
            	strOwner=modelLeave.getValueAt(k, 5).toString().trim();
            		if(modelLeave.getValueAt(k, 8).toString() == "1")
            		{	
            			if (strUser.equals(strOwner) == true && modelLeave.getValueAt(k, 4).toString() != "Decline" && modelLeave.getValueAt(k, 4).toString() != "Success")
            			{
            			if(modelLeave.getValueAt(k, 4).toString() == "Pending")
            			{
            				str_Text = str_Text + "Leave ID: " + modelLeave.getValueAt(k, 0).toString() + " Applied by " + modelLeave.getValueAt(k, 1).toString();
            			}
            			else if(modelLeave.getValueAt(k, 4).toString() == "Endorse")
            			{
            				str_Text = str_Text + "Leave ID: " + modelLeave.getValueAt(k, 0).toString() + " Endorsed by " + modelLeave.getValueAt(k, 6).toString();
            			}
            			modelLeave.setValueAt("", k, 8);
            			str_Text = str_Text + "\n";
            			}
            		}
            	}
            	
            	textNotice.setText(str_Text);
            	
            }
        });
        
        
        // Leave button update row
        btnEditLeave.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             
                // i = the index of the selected row
                //int i = tableLeave.getSelectedRow();
            	int strTest1, strTest2 ;
            	int i = -1;
            	for (int j = 0; j < modelLeave.getRowCount() ; j++)
            	{
            		strTest1 = Integer.parseInt(modelLeave.getValueAt(j, 0).toString().trim());
            		strTest2 = Integer.parseInt(textLeaveID.getText().toString().trim());
            		if (strTest1 == strTest2)
            			{i = j ;}
            	}
                if(i >= 0) 
                {  
                	modelLeave.setValueAt(textLeaveID.getText().toString().trim(), i, 0);
                	modelLeave.setValueAt(textStaffID2.getText().toString().trim(), i, 1);
                	modelLeave.setValueAt(textDateFrom.getText().toString().trim(), i, 2);
                	modelLeave.setValueAt(textDateTo.getText().toString().trim(), i, 3);
                	modelLeave.setValueAt(comboBoxStatus.getSelectedItem().toString().trim(), i, 4);
                	modelLeave.setValueAt(textSupervisor.getText().toString().trim(), i, 5);
                	modelLeave.setValueAt(textApprovedBy.getText().toString().trim(), i, 6);
                	//modelLeave.fireTableDataChanged();
                	//modelLeave.fireTableRowsUpdated(i, i);
        
                	labSystemStatus.setText("System Status:Update success(Leave ID:" + textLeaveID.getText() +")");
                }
                else{
                	labSystemStatus.setText("System Status:Please select row to update.");
                }
            }
        });
        

        
        //add(cardPanel, BorderLayout.NORTH);
        //add(buttonPanel);
        add(cardPanel);
        add(buttonPanel, BorderLayout.PAGE_END);
        
    }

    

}