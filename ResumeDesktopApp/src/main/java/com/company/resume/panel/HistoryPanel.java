package com.company.resume.panel;

import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.main.Context;
import com.company.resume.config.Config;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eminov
 */
public class HistoryPanel extends javax.swing.JPanel {
    
    EmploymentHistoryDaoInter historyDao = Context.instanceEmploymentHistoryDao();
    EmploymentHistory  h = historyDao.getAllEmploymentHistoryByUserId(Config.loggedInUser.getId());
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//    private void fillWindow() {
//        
//    }
    public void fillUserComponents() {
       
            HeaderArea.setText(h.getHeader());
            txtBegindate.setText(h.getBeginDate().toString());
            txtEnddate.setText(h.getEndDate().toString());
            JobDescriptionArea.setText(h.getJobDescription());
    }

    public void fillUser(EmploymentHistory history) {
        try {
            String header = HeaderArea.getText();
            String begindate = txtBegindate.getText();
            String enddate = txtEnddate.getText();
            String jobDescription = JobDescriptionArea.getText();
            
            history.setHeader(header);
            Date begin = new Date(sdf.parse(begindate).getTime());
            history.setBeginDate(begin);
            Date end = new Date(sdf.parse(enddate).getTime());
            history.setEndDate(end);
            history.setJobDescription(jobDescription);
            history.getUser().setId(Config.loggedInUser.getId());
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public HistoryPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlDetails = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        lblJobDescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HeaderArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        JobDescriptionArea = new javax.swing.JTextArea();
        txtEnddate = new javax.swing.JTextField();
        lblEnddate = new javax.swing.JLabel();
        lblBegindate = new javax.swing.JLabel();
        txtBegindate = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );

        lblHeader.setText("Header");

        lblJobDescription.setText("Job Description");

        HeaderArea.setColumns(20);
        HeaderArea.setRows(5);
        jScrollPane1.setViewportView(HeaderArea);

        JobDescriptionArea.setColumns(20);
        JobDescriptionArea.setRows(5);
        jScrollPane2.setViewportView(JobDescriptionArea);

        lblEnddate.setText("enddate");

        lblBegindate.setText("begindate");

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lblJobDescription)))
                .addContainerGap(281, Short.MAX_VALUE))
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addComponent(lblBegindate, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBegindate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEnddate, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEnddate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBegindate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBegindate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEnddate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnddate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(lblJobDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDetails, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea HeaderArea;
    private javax.swing.JTextArea JobDescriptionArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBegindate;
    private javax.swing.JLabel lblEnddate;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblJobDescription;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JTextField txtBegindate;
    private javax.swing.JTextField txtEnddate;
    // End of variables declaration//GEN-END:variables
}
