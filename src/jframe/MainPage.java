package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class MainPage extends javax.swing.JFrame {

    DefaultTableModel model;
    
    public MainPage() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        setDataToCards();
        setStudentDetailsToTable();
        setBookDetailsToTable();
        showPieChart();
    }
    
    public void setDataToCards(){
        Statement st = null;
        ResultSet rs = null;
        
        long l = System.currentTimeMillis();
        java.sql.Date todaysDate = new java.sql.Date(l);
        try {
            Connection con = DBConnection.getConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //books placeholder
            rs = st.executeQuery("select * from book_details");
            rs.last();
            lbl_numOfBooks.setText(Integer.toString(rs.getRow()));
            //students placeholder
            rs = st.executeQuery("select * from student_details");
            rs.last();
            lbl_numOfStudents.setText(Integer.toString(rs.getRow()));
            //issued placeholder
            rs = st.executeQuery("select * from issue_book_details where status = '"+"pending"+"'");
            rs.last();
            lbl_issueBooks.setText(Integer.toString(rs.getRow()));
            //defaulter placeholder
            rs = st.executeQuery("select * from issue_book_details where due_date < '"+todaysDate+"' and status = '"+"pending"+"'");
            rs.last();
            lbl_overdueList.setText(Integer.toString(rs.getRow()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    //sets book details to the table
    public void setStudentDetailsToTable(){
        
        model =(DefaultTableModel) tbl_studentDetails.getModel();
        model.setRowCount(0);
        
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
    //sets book details to the table
    public void setBookDetailsToTable(){
        
        model =(DefaultTableModel) tbl_bookDetails.getModel();
        model.setRowCount(0);
        
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from book_details");
            
            while(rs.next()){
                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                String quantity = rs.getString("quantity");
                
                Object[] obj = {bookId,bookName,author,quantity};
                model =(DefaultTableModel) tbl_bookDetails.getModel();
                model.addRow(obj);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    public void showPieChart(){
        
        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset( );
        //7:00:00
        //1:55:00
         try {
            Connection con = DBConnection.getConnection();
            String sql = "select book_name , count(*) as issue_count from issue_book_details group by book_id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                barDataset.setValue(rs.getString("book_name"), new Double(rs.getDouble("issue_count")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Issued Books",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
     
        //changing pie chart blocks colors
        piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.decode("#2C5364"));
//        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new jframe.PanelBorder();
        btn_exit = new javax.swing.JButton();
        booksPanel = new jframe.PanelBorderGradient();
        lbl_numOfBooks = new javax.swing.JLabel();
        book_icon = new javax.swing.JLabel();
        issuedPanel = new jframe.PanelBorderGradient();
        lbl_issueBooks = new javax.swing.JLabel();
        issued_icon = new javax.swing.JLabel();
        studentsPanel = new jframe.PanelBorderGradient();
        lbl_numOfStudents = new javax.swing.JLabel();
        students_icon = new javax.swing.JLabel();
        overDuePanel = new jframe.PanelBorderGradient();
        lbl_overdueList = new javax.swing.JLabel();
        overdue_icon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bookDetails = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new javax.swing.JTable();
        panelPieChart = new jframe.PanelBorderGradient();
        btn_logout = new javax.swing.JButton();
        panelBorderGradient2 = new jframe.PanelBorderGradient();
        panelLogo = new javax.swing.JPanel();
        lbl_Title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_manageBooks = new javax.swing.JButton();
        btn_issueBook = new javax.swing.JButton();
        btn_viewRecords = new javax.swing.JButton();
        btn_viewIssuedBooks = new javax.swing.JButton();
        btn_overDue = new javax.swing.JButton();
        btn_returnBook = new javax.swing.JButton();
        btn_manageStudents = new javax.swing.JButton();
        lbl_overDueCard = new javax.swing.JLabel();
        lbl_booksCard = new javax.swing.JLabel();
        lbl_studentsCard = new javax.swing.JLabel();
        lbl_issuedCard = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(190, 197, 210));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(190, 197, 210));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelBorder1.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1610, 0, 40, 30));

        booksPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                booksPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                booksPanelMouseExited(evt);
            }
        });

        lbl_numOfBooks.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lbl_numOfBooks.setForeground(new java.awt.Color(190, 197, 210));
        lbl_numOfBooks.setText("22");

        book_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/Manage_books.png"))); // NOI18N

        javax.swing.GroupLayout booksPanelLayout = new javax.swing.GroupLayout(booksPanel);
        booksPanel.setLayout(booksPanelLayout);
        booksPanelLayout.setHorizontalGroup(
            booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(booksPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(book_icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_numOfBooks, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );
        booksPanelLayout.setVerticalGroup(
            booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(booksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_numOfBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(book_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelBorder1.add(booksPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 150, 70));

        issuedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                issuedPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                issuedPanelMouseExited(evt);
            }
        });

        lbl_issueBooks.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lbl_issueBooks.setForeground(new java.awt.Color(190, 197, 210));
        lbl_issueBooks.setText("22");

        issued_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/Issue_books.png"))); // NOI18N

        javax.swing.GroupLayout issuedPanelLayout = new javax.swing.GroupLayout(issuedPanel);
        issuedPanel.setLayout(issuedPanelLayout);
        issuedPanelLayout.setHorizontalGroup(
            issuedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(issuedPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(issued_icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_issueBooks, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );
        issuedPanelLayout.setVerticalGroup(
            issuedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(issuedPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(issuedPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(issued_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_issueBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelBorder1.add(issuedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 150, 70));

        studentsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentsPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                studentsPanelMouseExited(evt);
            }
        });

        lbl_numOfStudents.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lbl_numOfStudents.setForeground(new java.awt.Color(190, 197, 210));
        lbl_numOfStudents.setText("22");

        students_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/manage_students.png"))); // NOI18N

        javax.swing.GroupLayout studentsPanelLayout = new javax.swing.GroupLayout(studentsPanel);
        studentsPanel.setLayout(studentsPanelLayout);
        studentsPanelLayout.setHorizontalGroup(
            studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(students_icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_numOfStudents, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );
        studentsPanelLayout.setVerticalGroup(
            studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(students_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_numOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelBorder1.add(studentsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 150, 70));

        overDuePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                overDuePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                overDuePanelMouseExited(evt);
            }
        });

        lbl_overdueList.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lbl_overdueList.setForeground(new java.awt.Color(190, 197, 210));
        lbl_overdueList.setText("22");

        overdue_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/Overdue.png"))); // NOI18N

        javax.swing.GroupLayout overDuePanelLayout = new javax.swing.GroupLayout(overDuePanel);
        overDuePanel.setLayout(overDuePanelLayout);
        overDuePanelLayout.setHorizontalGroup(
            overDuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overDuePanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(overdue_icon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_overdueList, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );
        overDuePanelLayout.setVerticalGroup(
            overDuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overDuePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(overDuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(overdue_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_overdueList, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelBorder1.add(overDuePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 90, 150, 70));

        tbl_bookDetails.setBackground(new java.awt.Color(29, 65, 82));
        tbl_bookDetails.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbl_bookDetails.setForeground(new java.awt.Color(190, 197, 210));
        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book", "Author", "Quantity"
            }
        ));
        tbl_bookDetails.setGridColor(new java.awt.Color(190, 197, 210));
        tbl_bookDetails.setSelectionBackground(new java.awt.Color(190, 197, 210));
        tbl_bookDetails.setSelectionForeground(new java.awt.Color(29, 65, 82));
        jScrollPane1.setViewportView(tbl_bookDetails);

        panelBorder1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 630, 240));

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
        jScrollPane2.setViewportView(tbl_studentDetails);

        panelBorder1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 630, 240));

        panelPieChart.setLayout(new java.awt.BorderLayout());
        panelBorder1.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, 590, 580));

        btn_logout.setBackground(new java.awt.Color(89, 98, 116));
        btn_logout.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(190, 197, 210));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/logout.png"))); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        panelBorder1.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1500, 0, -1, 30));

        panelLogo.setOpaque(false);

        lbl_Title.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lbl_Title.setForeground(new java.awt.Color(190, 197, 210));
        lbl_Title.setText("LIBRARAY MANAGER");

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
                .addContainerGap(20, Short.MAX_VALUE))
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

        btn_manageBooks.setBackground(new java.awt.Color(89, 98, 116));
        btn_manageBooks.setForeground(new java.awt.Color(190, 197, 210));
        btn_manageBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/Manage_books.png"))); // NOI18N
        btn_manageBooks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_manageBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_manageBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_manageBooksMouseExited(evt);
            }
        });
        btn_manageBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageBooksActionPerformed(evt);
            }
        });

        btn_issueBook.setBackground(new java.awt.Color(89, 98, 116));
        btn_issueBook.setForeground(new java.awt.Color(190, 197, 210));
        btn_issueBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/Issue_books.png"))); // NOI18N
        btn_issueBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_issueBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_issueBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_issueBookMouseExited(evt);
            }
        });
        btn_issueBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_issueBookActionPerformed(evt);
            }
        });

        btn_viewRecords.setBackground(new java.awt.Color(89, 98, 116));
        btn_viewRecords.setForeground(new java.awt.Color(190, 197, 210));
        btn_viewRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/View_records.png"))); // NOI18N
        btn_viewRecords.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_viewRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_viewRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_viewRecordsMouseExited(evt);
            }
        });
        btn_viewRecords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewRecordsActionPerformed(evt);
            }
        });

        btn_viewIssuedBooks.setBackground(new java.awt.Color(89, 98, 116));
        btn_viewIssuedBooks.setForeground(new java.awt.Color(190, 197, 210));
        btn_viewIssuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/View_issued_books.png"))); // NOI18N
        btn_viewIssuedBooks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_viewIssuedBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_viewIssuedBooksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_viewIssuedBooksMouseExited(evt);
            }
        });
        btn_viewIssuedBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewIssuedBooksActionPerformed(evt);
            }
        });

        btn_overDue.setBackground(new java.awt.Color(89, 98, 116));
        btn_overDue.setForeground(new java.awt.Color(190, 197, 210));
        btn_overDue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/Overdue.png"))); // NOI18N
        btn_overDue.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_overDue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_overDueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_overDueMouseExited(evt);
            }
        });
        btn_overDue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_overDueActionPerformed(evt);
            }
        });

        btn_returnBook.setBackground(new java.awt.Color(89, 98, 116));
        btn_returnBook.setForeground(new java.awt.Color(190, 197, 210));
        btn_returnBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/return_book.png"))); // NOI18N
        btn_returnBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_returnBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_returnBookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_returnBookMouseExited(evt);
            }
        });
        btn_returnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnBookActionPerformed(evt);
            }
        });

        btn_manageStudents.setBackground(new java.awt.Color(89, 98, 116));
        btn_manageStudents.setForeground(new java.awt.Color(190, 197, 210));
        btn_manageStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myIcons/manage_students.png"))); // NOI18N
        btn_manageStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_manageStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_manageStudentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_manageStudentsMouseExited(evt);
            }
        });
        btn_manageStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manageStudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorderGradient2Layout = new javax.swing.GroupLayout(panelBorderGradient2);
        panelBorderGradient2.setLayout(panelBorderGradient2Layout);
        panelBorderGradient2Layout.setHorizontalGroup(
            panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBorderGradient2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_manageStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_returnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_overDue, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_viewIssuedBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_viewRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_issueBook, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_manageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorderGradient2Layout.setVerticalGroup(
            panelBorderGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorderGradient2Layout.createSequentialGroup()
                .addComponent(panelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_manageBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_issueBook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_viewRecords, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_viewIssuedBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_returnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_overDue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_manageStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 260, Short.MAX_VALUE))
        );

        panelBorder1.add(panelBorderGradient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 780));

        lbl_overDueCard.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lbl_overDueCard.setForeground(new java.awt.Color(29, 65, 82));
        panelBorder1.add(lbl_overDueCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 80, 30));

        lbl_booksCard.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lbl_booksCard.setForeground(new java.awt.Color(29, 65, 82));
        panelBorder1.add(lbl_booksCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 60, 30));

        lbl_studentsCard.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lbl_studentsCard.setForeground(new java.awt.Color(29, 65, 82));
        panelBorder1.add(lbl_studentsCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 80, 30));

        lbl_issuedCard.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lbl_issuedCard.setForeground(new java.awt.Color(29, 65, 82));
        panelBorder1.add(lbl_issuedCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 60, 30));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1650, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        LoginMenu page = new LoginMenu();
                page.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_manageBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageBooksActionPerformed
        BookManagerMenu books = new BookManagerMenu();
        books.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_manageBooksActionPerformed

    private void btn_issueBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issueBookActionPerformed
        IssueBookMenu issue = new IssueBookMenu();
        issue.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_issueBookActionPerformed

    private void btn_viewRecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewRecordsActionPerformed
        RecordsMenu viewRecord = new RecordsMenu();
        viewRecord.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_viewRecordsActionPerformed

    private void btn_viewIssuedBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewIssuedBooksActionPerformed
        IssueDetailsMenu bookdetails = new IssueDetailsMenu();
        bookdetails.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_viewIssuedBooksActionPerformed

    private void btn_overDueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_overDueActionPerformed
        OverdueMenu defaulter = new OverdueMenu();
        defaulter.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_overDueActionPerformed

    private void btn_returnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnBookActionPerformed
        ReturnBookMenu returnBook = new ReturnBookMenu();
        returnBook.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_returnBookActionPerformed

    private void btn_manageStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manageStudentsActionPerformed
        StudentManagerMenu students = new StudentManagerMenu();
        students.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_manageStudentsActionPerformed

    private void booksPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksPanelMouseEntered
        lbl_booksCard.setText("Books");
    }//GEN-LAST:event_booksPanelMouseEntered

    private void booksPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksPanelMouseExited
        lbl_booksCard.setText("");
    }//GEN-LAST:event_booksPanelMouseExited

    private void studentsPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsPanelMouseEntered
        lbl_studentsCard.setText("Students");
    }//GEN-LAST:event_studentsPanelMouseEntered

    private void studentsPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsPanelMouseExited
        lbl_studentsCard.setText("");
    }//GEN-LAST:event_studentsPanelMouseExited

    private void issuedPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuedPanelMouseEntered
        lbl_issuedCard.setText("Issued");
    }//GEN-LAST:event_issuedPanelMouseEntered

    private void issuedPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuedPanelMouseExited
        lbl_issuedCard.setText("");
    }//GEN-LAST:event_issuedPanelMouseExited

    private void overDuePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_overDuePanelMouseEntered
        lbl_overDueCard.setText("Over Due");
    }//GEN-LAST:event_overDuePanelMouseEntered

    private void overDuePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_overDuePanelMouseExited
        lbl_overDueCard.setText("");
    }//GEN-LAST:event_overDuePanelMouseExited

    private void btn_manageBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_manageBooksMouseEntered
        btn_manageBooks.setText("Manage Books");
    }//GEN-LAST:event_btn_manageBooksMouseEntered

    private void btn_manageBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_manageBooksMouseExited
        btn_manageBooks.setText("");
    }//GEN-LAST:event_btn_manageBooksMouseExited

    private void btn_issueBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_issueBookMouseEntered
        btn_issueBook.setText("Issue Books");
    }//GEN-LAST:event_btn_issueBookMouseEntered

    private void btn_issueBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_issueBookMouseExited
        btn_issueBook.setText("");
    }//GEN-LAST:event_btn_issueBookMouseExited

    private void btn_viewRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewRecordsMouseEntered
        btn_viewRecords.setText("View Records");
    }//GEN-LAST:event_btn_viewRecordsMouseEntered

    private void btn_viewRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewRecordsMouseExited
        btn_viewRecords.setText("");
    }//GEN-LAST:event_btn_viewRecordsMouseExited

    private void btn_viewIssuedBooksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewIssuedBooksMouseEntered
        btn_viewIssuedBooks.setText("View Issued Books");
    }//GEN-LAST:event_btn_viewIssuedBooksMouseEntered

    private void btn_viewIssuedBooksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewIssuedBooksMouseExited
        btn_viewIssuedBooks.setText("");
    }//GEN-LAST:event_btn_viewIssuedBooksMouseExited

    private void btn_returnBookMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnBookMouseEntered
        btn_returnBook.setText("Return Books");
    }//GEN-LAST:event_btn_returnBookMouseEntered

    private void btn_returnBookMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_returnBookMouseExited
        btn_returnBook.setText("");
    }//GEN-LAST:event_btn_returnBookMouseExited

    private void btn_overDueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_overDueMouseEntered
        btn_overDue.setText("Over Due Books");
    }//GEN-LAST:event_btn_overDueMouseEntered

    private void btn_overDueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_overDueMouseExited
        btn_overDue.setText("");
    }//GEN-LAST:event_btn_overDueMouseExited

    private void btn_manageStudentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_manageStudentsMouseEntered
        btn_manageStudents.setText("Manage Students");
    }//GEN-LAST:event_btn_manageStudentsMouseEntered

    private void btn_manageStudentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_manageStudentsMouseExited
        btn_manageStudents.setText("");
    }//GEN-LAST:event_btn_manageStudentsMouseExited

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel book_icon;
    private jframe.PanelBorderGradient booksPanel;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_issueBook;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_manageBooks;
    private javax.swing.JButton btn_manageStudents;
    private javax.swing.JButton btn_overDue;
    private javax.swing.JButton btn_returnBook;
    private javax.swing.JButton btn_viewIssuedBooks;
    private javax.swing.JButton btn_viewRecords;
    private jframe.PanelBorderGradient issuedPanel;
    private javax.swing.JLabel issued_icon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JLabel lbl_booksCard;
    private javax.swing.JLabel lbl_issueBooks;
    private javax.swing.JLabel lbl_issuedCard;
    private javax.swing.JLabel lbl_numOfBooks;
    private javax.swing.JLabel lbl_numOfStudents;
    private javax.swing.JLabel lbl_overDueCard;
    private javax.swing.JLabel lbl_overdueList;
    private javax.swing.JLabel lbl_studentsCard;
    private jframe.PanelBorderGradient overDuePanel;
    private javax.swing.JLabel overdue_icon;
    private jframe.PanelBorder panelBorder1;
    private jframe.PanelBorderGradient panelBorderGradient2;
    private javax.swing.JPanel panelLogo;
    private jframe.PanelBorderGradient panelPieChart;
    private jframe.PanelBorderGradient studentsPanel;
    private javax.swing.JLabel students_icon;
    private javax.swing.JTable tbl_bookDetails;
    private javax.swing.JTable tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
