package jframe;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class RecordsMenu extends javax.swing.JFrame {

    DefaultTableModel model;
    
    public RecordsMenu() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setIssueBookDetailsToTable();
    }
    
    //method to set data into table from issue_book_details in the database
    public void setIssueBookDetailsToTable(){
        
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details");
            
            while(rs.next()){
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                
                Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
                model =(DefaultTableModel) tbl_issueBookDetails.getModel();
                model.addRow(obj);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    //method to clear the data from table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_issueBookDetails.getModel();
        model.setRowCount(0);
    }
    
    //tp fetch the record using datefields 
    public void search(){
        Date uFromDate = date_fromDate.getCalendar().getTime();
        Date uToDate = date_toDate.getCalendar().getTime();
        
        long l1 = uFromDate.getTime();
        long l2 = uToDate.getTime();
        
        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where issue_date between ? and ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);
            
            ResultSet rs = pst.executeQuery();
            if (rs.next() == false){
                JOptionPane.showMessageDialog(this, "no records found");
            } else {
                while(rs.next()){
                    String id = rs.getString("id");
                    String bookName = rs.getString("book_name");
                    String studentName = rs.getString("student_name");
                    String issueDate = rs.getString("issue_date");
                    String dueDate = rs.getString("due_date");
                    String status = rs.getString("status");
                
                    Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
                    model =(DefaultTableModel) tbl_issueBookDetails.getModel();
                    model.addRow(obj);
                }
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorderGradient1 = new jframe.PanelBorderGradient();
        btn_exit = new javax.swing.JButton();
        date_toDate = new com.toedter.calendar.JDateChooser();
        date_fromDate = new com.toedter.calendar.JDateChooser();
        btn_search = new javax.swing.JButton();
        btn_showAll = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btn_exit.setBackground(new java.awt.Color(89, 98, 116));
        btn_exit.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(190, 197, 210));
        btn_exit.setText("X");
        btn_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        date_toDate.setBackground(new java.awt.Color(89, 98, 116));
        date_toDate.setForeground(new java.awt.Color(190, 197, 210));
        date_toDate.setDateFormatString("yyyy/MM/dd");

        date_fromDate.setBackground(new java.awt.Color(89, 98, 116));
        date_fromDate.setForeground(new java.awt.Color(190, 197, 210));
        date_fromDate.setDateFormatString("yyyy/MM/dd");

        btn_search.setBackground(new java.awt.Color(89, 98, 116));
        btn_search.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        btn_search.setForeground(new java.awt.Color(190, 197, 210));
        btn_search.setText("Search");
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        btn_showAll.setBackground(new java.awt.Color(89, 98, 116));
        btn_showAll.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        btn_showAll.setForeground(new java.awt.Color(190, 197, 210));
        btn_showAll.setText("Show All");
        btn_showAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_showAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showAllActionPerformed(evt);
            }
        });

        tbl_issueBookDetails.setBackground(new java.awt.Color(29, 65, 82));
        tbl_issueBookDetails.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl_issueBookDetails.setForeground(new java.awt.Color(190, 197, 210));
        tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book", "Student", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issueBookDetails.setGridColor(new java.awt.Color(190, 197, 210));
        tbl_issueBookDetails.setSelectionBackground(new java.awt.Color(190, 197, 210));
        tbl_issueBookDetails.setSelectionForeground(new java.awt.Color(29, 65, 82));
        jScrollPane2.setViewportView(tbl_issueBookDetails);

        btn_back.setBackground(new java.awt.Color(89, 98, 116));
        btn_back.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btn_back.setForeground(new java.awt.Color(190, 197, 210));
        btn_back.setText("Back");
        btn_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(190, 197, 210));
        jLabel4.setText("BOOK RECORDS");

        javax.swing.GroupLayout panelBorderGradient1Layout = new javax.swing.GroupLayout(panelBorderGradient1);
        panelBorderGradient1.setLayout(panelBorderGradient1Layout);
        panelBorderGradient1Layout.setHorizontalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderGradient1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                        .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(date_fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date_toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn_showAll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderGradient1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addGap(59, 59, 59)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 102, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorderGradient1Layout.setVerticalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_exit)
                    .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                        .addComponent(btn_back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGap(19, 19, 19)
                .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(date_fromDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(date_toDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_showAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorderGradient1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        if (date_fromDate.getCalendar().getTime() != null && date_toDate.getCalendar().getTime() != null){
            clearTable();
            search(); 
        } else {
            JOptionPane.showMessageDialog(this, "please select start and due date");
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_showAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_showAllActionPerformed
        clearTable();
        setIssueBookDetailsToTable();
    }//GEN-LAST:event_btn_showAllActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        MainPage books = new MainPage();
        books.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed


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
            java.util.logging.Logger.getLogger(RecordsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecordsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecordsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecordsMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecordsMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_showAll;
    private com.toedter.calendar.JDateChooser date_fromDate;
    private com.toedter.calendar.JDateChooser date_toDate;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private jframe.PanelBorderGradient panelBorderGradient1;
    private javax.swing.JTable tbl_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}
