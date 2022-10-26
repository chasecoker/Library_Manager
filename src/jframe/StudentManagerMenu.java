package jframe;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class StudentManagerMenu extends javax.swing.JFrame {

    String studentName, course, branch;
    int studentId;
    DefaultTableModel model;

    public StudentManagerMenu() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setStudentDetailsToTable();
    }
    
    
    //sets book details to the table
    public void setStudentDetailsToTable(){
        
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            
            while(rs.next()){
                String StudentId = rs.getString("student_id");
                String StudentName = rs.getString("name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
                
                Object[] obj = {StudentId,StudentName,course,branch};
                model =(DefaultTableModel) tbl_studentDetails.getModel();
                model.addRow(obj);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
    //add student details to student_details table
    public boolean addStudent(){
        boolean isAdded = false;
        
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into student_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                isAdded = true;
            } else {
                isAdded = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    //method to update student details
    public boolean updateStudent(){
        boolean isUpdated = false;
        
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update student_details set name = ?,course = ?,branch = ? where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentName);
            pst.setString(2, course);
            pst.setString(3, branch);
            pst.setInt(4, studentId);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                isUpdated = true;
            } else {
                isUpdated = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }
    
    //method to delete book details
    public boolean deleteStudent(){
        boolean isDeleted = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from student_details where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isDeleted = true;
            } else {
                isDeleted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    
    //method to clear table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
        model.setRowCount(0);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorderGradient1 = new jframe.PanelBorderGradient();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new javax.swing.JTable();
        panelBorderGradient2 = new jframe.PanelBorderGradient();
        btn_add = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_studentName = new app.bolivia.swing.JCTextField();
        btn_exit = new javax.swing.JButton();
        combo_CourseName = new javax.swing.JComboBox<>();
        combo_branch = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tbl_studentDetails.setBackground(new java.awt.Color(29, 65, 82));
        tbl_studentDetails.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl_studentDetails.setForeground(new java.awt.Color(190, 197, 210));
        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setGridColor(new java.awt.Color(190, 197, 210));
        tbl_studentDetails.setSelectionBackground(new java.awt.Color(190, 197, 210));
        tbl_studentDetails.setSelectionForeground(new java.awt.Color(29, 65, 82));
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        btn_add.setBackground(new java.awt.Color(89, 98, 116));
        btn_add.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        btn_add.setForeground(new java.awt.Color(190, 197, 210));
        btn_add.setText("Add");
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_update.setBackground(new java.awt.Color(89, 98, 116));
        btn_update.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        btn_update.setForeground(new java.awt.Color(190, 197, 210));
        btn_update.setText("Update");
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setBackground(new java.awt.Color(89, 98, 116));
        btn_delete.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(190, 197, 210));
        btn_delete.setText("Delete");
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        txt_studentId.setBackground(new java.awt.Color(89, 98, 116));
        txt_studentId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_studentId.setForeground(new java.awt.Color(190, 197, 210));
        txt_studentId.setPhColor(new java.awt.Color(190, 197, 210));
        txt_studentId.setPlaceholder("Enter Student Id");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });

        txt_studentName.setBackground(new java.awt.Color(89, 98, 116));
        txt_studentName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_studentName.setForeground(new java.awt.Color(190, 197, 210));
        txt_studentName.setPhColor(new java.awt.Color(190, 197, 210));
        txt_studentName.setPlaceholder("Enter Student Name");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });

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

        combo_CourseName.setBackground(new java.awt.Color(89, 98, 116));
        combo_CourseName.setForeground(new java.awt.Color(190, 197, 210));
        combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC", "PHD", "Java" }));
        combo_CourseName.setName(""); // NOI18N
        combo_CourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CourseNameActionPerformed(evt);
            }
        });

        combo_branch.setBackground(new java.awt.Color(89, 98, 116));
        combo_branch.setForeground(new java.awt.Color(190, 197, 210));
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CS", "PLAIN", "ELECTRONICS", "" }));
        combo_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_branchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(190, 197, 210));
        jLabel4.setText("STUDENT MANAGER");

        javax.swing.GroupLayout panelBorderGradient2Layout = new javax.swing.GroupLayout(panelBorderGradient2);
        panelBorderGradient2.setLayout(panelBorderGradient2Layout);
        panelBorderGradient2Layout.setHorizontalGroup(
            panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderGradient2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderGradient2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderGradient2Layout.createSequentialGroup()
                        .addGroup(panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBorderGradient2Layout.createSequentialGroup()
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(combo_CourseName, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_studentName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                                .addComponent(txt_studentId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combo_branch, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorderGradient2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35))))
        );
        panelBorderGradient2Layout.setVerticalGroup(
            panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient2Layout.createSequentialGroup()
                .addComponent(btn_exit)
                .addGap(41, 41, 41)
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addComponent(txt_studentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_studentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(combo_CourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(combo_branch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(161, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout panelBorderGradient1Layout = new javax.swing.GroupLayout(panelBorderGradient1);
        panelBorderGradient1.setLayout(panelBorderGradient1Layout);
        panelBorderGradient1Layout.setHorizontalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(panelBorderGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBorderGradient1Layout.setVerticalGroup(
            panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorderGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                        .addComponent(panelBorderGradient2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelBorderGradient1Layout.createSequentialGroup()
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (addStudent() == true) {
            JOptionPane.showMessageDialog(this, "student added"); 
            clearTable();
            setStudentDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "failed to student"); 
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if (updateStudent() == true) {
            JOptionPane.showMessageDialog(this, "student updated"); 
            clearTable();
            setStudentDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "failed to update"); 
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if (deleteStudent() == true) {
            JOptionPane.showMessageDialog(this, "student deleted"); 
            clearTable();
            setStudentDetailsToTable();
        } else {
            JOptionPane.showMessageDialog(this, "failed to delete"); 
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameFocusLost

    private void combo_CourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_CourseNameActionPerformed

    private void combo_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_branchActionPerformed

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNum = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        
        txt_studentId.setText(model.getValueAt(rowNum, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNum, 1).toString());
        combo_CourseName.setSelectedItem(model.getValueAt(rowNum, 2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNum, 3).toString());
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(StudentManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentManagerMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentManagerMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combo_CourseName;
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private jframe.PanelBorderGradient panelBorderGradient1;
    private jframe.PanelBorderGradient panelBorderGradient2;
    private javax.swing.JTable tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
