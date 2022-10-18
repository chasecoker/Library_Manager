package jframe;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
import javax.swing.SwingUtilities;


public class MenuPanel extends javax.swing.JPanel {


    public MenuPanel() {
        initComponents();
        setOpaque(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogo = new javax.swing.JPanel();
        lbl_Title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_viewIssuedBooks = new javax.swing.JButton();
        btn_manageBooks = new javax.swing.JButton();
        btn_issueBook = new javax.swing.JButton();
        btn_viewRecords = new javax.swing.JButton();
        btn_overDue = new javax.swing.JButton();
        btn_returnBook = new javax.swing.JButton();
        btn_manageStudents = new javax.swing.JButton();

        panelLogo.setOpaque(false);

        lbl_Title.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lbl_Title.setForeground(new java.awt.Color(190, 197, 210));
        lbl_Title.setText("LIBARAY MANAGER");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/Big_Software_Logo.png"))); // NOI18N

        javax.swing.GroupLayout panelLogoLayout = new javax.swing.GroupLayout(panelLogo);
        panelLogo.setLayout(panelLogoLayout);
        panelLogoLayout.setHorizontalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_Title)
                    .addComponent(jLabel2))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelLogoLayout.setVerticalGroup(
            panelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLogoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Title)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        btn_viewIssuedBooks.setBackground(new java.awt.Color(89, 98, 116));
        btn_viewIssuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/View_issued_books.png"))); // NOI18N
        btn_viewIssuedBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewIssuedBooksActionPerformed(evt);
            }
        });

        btn_manageBooks.setBackground(new java.awt.Color(89, 98, 116));
        btn_manageBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/Manage_books.png"))); // NOI18N
        btn_manageBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageBooksActionPerformed(evt);
            }
        });

        btn_issueBook.setBackground(new java.awt.Color(89, 98, 116));
        btn_issueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/Issue_books.png"))); // NOI18N
        btn_issueBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_issueBookActionPerformed(evt);
            }
        });

        btn_viewRecords.setBackground(new java.awt.Color(89, 98, 116));
        btn_viewRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/View_records.png"))); // NOI18N
        btn_viewRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewRecordsActionPerformed(evt);
            }
        });

        btn_overDue.setBackground(new java.awt.Color(89, 98, 116));
        btn_overDue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/Overdue.png"))); // NOI18N
        btn_overDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_overDueActionPerformed(evt);
            }
        });

        btn_returnBook.setBackground(new java.awt.Color(89, 98, 116));
        btn_returnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/return_book.png"))); // NOI18N
        btn_returnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnBookActionPerformed(evt);
            }
        });

        btn_manageStudents.setBackground(new java.awt.Color(89, 98, 116));
        btn_manageStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/manage_students.png"))); // NOI18N
        btn_manageStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageStudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_manageStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_returnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_overDue, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_manageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_issueBook, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_viewRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_viewIssuedBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_manageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_issueBook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_viewRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btn_viewIssuedBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_overDue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_returnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_manageStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_viewIssuedBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewIssuedBooksActionPerformed
        IssueDetailsMenu bookdetails = new IssueDetailsMenu();
        bookdetails.setVisible(true);

    }//GEN-LAST:event_btn_viewIssuedBooksActionPerformed

    private void btn_manageBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageBooksActionPerformed
        BookManagerMenu books = new BookManagerMenu();
        books.setVisible(true);
    }//GEN-LAST:event_btn_manageBooksActionPerformed

    private void btn_issueBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issueBookActionPerformed
        IssueBookMenu issue = new IssueBookMenu();
        issue.setVisible(true);
    }//GEN-LAST:event_btn_issueBookActionPerformed

    private void btn_viewRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewRecordsActionPerformed
        RecordsMenu viewRecord = new RecordsMenu();
        viewRecord.setVisible(true);
    }//GEN-LAST:event_btn_viewRecordsActionPerformed

    private void btn_overDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_overDueActionPerformed
        OverdueMenu defaulter = new OverdueMenu();
        defaulter.setVisible(true);
    }//GEN-LAST:event_btn_overDueActionPerformed

    private void btn_returnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnBookActionPerformed
        ReturnBookMenu returnBook = new ReturnBookMenu();
        returnBook.setVisible(true);
    }//GEN-LAST:event_btn_returnBookActionPerformed

    private void btn_manageStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageStudentsActionPerformed
        StudentManagerMenu students = new StudentManagerMenu();
        students.setVisible(true);
    }//GEN-LAST:event_btn_manageStudentsActionPerformed

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D)grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#0F2027"), 0, getHeight(), Color.decode("#2C5364"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        
        super.paintChildren(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_issueBook;
    private javax.swing.JButton btn_manageBooks;
    private javax.swing.JButton btn_manageStudents;
    private javax.swing.JButton btn_overDue;
    private javax.swing.JButton btn_returnBook;
    private javax.swing.JButton btn_viewIssuedBooks;
    private javax.swing.JButton btn_viewRecords;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JPanel panelLogo;
    // End of variables declaration//GEN-END:variables
}
