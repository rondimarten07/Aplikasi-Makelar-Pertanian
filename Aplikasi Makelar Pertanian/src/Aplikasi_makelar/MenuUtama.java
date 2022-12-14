/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplikasi_makelar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Sherlock
 */
public class MenuUtama extends javax.swing.JFrame {

    /**
     * Creates new form MenuUtama
     */
    
     java.util.Date tglsekarang = new java.util.Date();
    private SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
    //diatas adalah pengaturan format penulisan, bisa diubah sesuai keinginan.
    private String tanggal = smpdtfmt.format(tglsekarang);
    
    
    public final void setJam(){
ActionListener taskPerformer = new ActionListener() {

            @Override
public void actionPerformed(ActionEvent evt) {
String nol_jam = "", nol_menit = "",nol_detik = "";

java.util.Date dateTime = new java.util.Date();
int nilai_jam = dateTime.getHours();
int nilai_menit = dateTime.getMinutes();
int nilai_detik = dateTime.getSeconds();

if(nilai_jam <= 9) nol_jam= "0";
if(nilai_menit <= 9) nol_menit= "0";
if(nilai_detik <= 9) nol_detik= "0";

String jam = nol_jam + Integer.toString(nilai_jam);
String menit = nol_menit + Integer.toString(nilai_menit);
String detik = nol_detik + Integer.toString(nilai_detik);

lblwktu.setText(jam+":"+menit+":"+detik+"");
}
};
new Timer(1000, taskPerformer).start();
}
    public MenuUtama() {
        initComponents();
          tgl.setText(tanggal);
          setJam();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblwktu = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        txtHelp = new javax.swing.JLabel();
        txtAbout = new javax.swing.JLabel();
        txtLogout = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBandar = new javax.swing.JButton();
        txtPetani = new javax.swing.JButton();
        txtPenjualan = new javax.swing.JButton();
        txtPembelian = new javax.swing.JButton();
        txtLaporan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Utama");

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        lblwktu.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lblwktu.setText("Jam");

        tgl.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        tgl.setText("Tanggal");

        txtHelp.setBackground(new java.awt.Color(0, 0, 0));
        txtHelp.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/help.png"))); // NOI18N
        txtHelp.setText("Help");
        txtHelp.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        txtHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHelpMouseClicked(evt);
            }
        });

        txtAbout.setBackground(new java.awt.Color(0, 0, 0));
        txtAbout.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/information.png"))); // NOI18N
        txtAbout.setText("About");
        txtAbout.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        txtAbout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtAboutMouseClicked(evt);
            }
        });

        txtLogout.setBackground(new java.awt.Color(0, 0, 0));
        txtLogout.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/exiticon.png"))); // NOI18N
        txtLogout.setText("Logout");
        txtLogout.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 0, 2, new java.awt.Color(0, 0, 0)));
        txtLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblwktu)
                .addGap(18, 18, 18)
                .addComponent(tgl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 505, Short.MAX_VALUE)
                .addComponent(txtHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgl)
                    .addComponent(lblwktu))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAbout, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 2, 940, 50));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("MAKELAR PERTANIAN");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 280, -1));

        txtBandar.setBackground(new java.awt.Color(204, 204, 204));
        txtBandar.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtBandar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/manager (Custom).png"))); // NOI18N
        txtBandar.setText("Data Bandar");
        txtBandar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBandarActionPerformed(evt);
            }
        });
        jPanel1.add(txtBandar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 140, 40));

        txtPetani.setBackground(new java.awt.Color(204, 204, 204));
        txtPetani.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtPetani.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/10255manfarmerlightskintone_110578 (Custom).png"))); // NOI18N
        txtPetani.setText("Data Petani");
        txtPetani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPetaniActionPerformed(evt);
            }
        });
        jPanel1.add(txtPetani, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 150, 40));

        txtPenjualan.setBackground(new java.awt.Color(204, 204, 204));
        txtPenjualan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/shopping-bag (Custom).png"))); // NOI18N
        txtPenjualan.setText("Transaksi Penjualan");
        txtPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPenjualanActionPerformed(evt);
            }
        });
        jPanel1.add(txtPenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, -1, 40));

        txtPembelian.setBackground(new java.awt.Color(204, 204, 204));
        txtPembelian.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtPembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/money (Custom).png"))); // NOI18N
        txtPembelian.setText("Transaksi Pembelian");
        txtPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPembelianActionPerformed(evt);
            }
        });
        jPanel1.add(txtPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, -1, 40));

        txtLaporan.setBackground(new java.awt.Color(204, 204, 204));
        txtLaporan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/notes (Custom).png"))); // NOI18N
        txtLaporan.setText("Laporan Bulanan");
        txtLaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLaporanActionPerformed(evt);
            }
        });
        jPanel1.add(txtLaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 430, -1, 40));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Makelar Milenial (Custom) (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 400, 290));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/gradienta-DbFgNw3QshA-unsplash (Custom).jpg"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(935, 510));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 935, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPetaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPetaniActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FormPetani().setVisible(true);
    }//GEN-LAST:event_txtPetaniActionPerformed

    private void txtBandarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBandarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FormBandar().setVisible(true);
    }//GEN-LAST:event_txtBandarActionPerformed

    private void txtPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPembelianActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FormPembelian().setVisible(true);
    }//GEN-LAST:event_txtPembelianActionPerformed

    private void txtPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPenjualanActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FormPenjualan().setVisible(true);
    }//GEN-LAST:event_txtPenjualanActionPerformed

    private void txtLaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLaporanActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FormLaporan().setVisible(true);
    }//GEN-LAST:event_txtLaporanActionPerformed

    private void txtHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHelpMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Form Data Bandar"
            + "\n1. Menyimpan"
            + "\n2. Mengedit"
            + "\n3. Menghapus"
            + "\n\nForm Data Petani"
            + "\n1. Menyimpan"
            + "\n2. Mengedit"
            + "\n3. Menghapus"
            + "\n\nForm Pembelian"
            + "\n Menambah Transaksi Baru"
            + "\n\nForm Penjualan"
            + "\n Menambah Transaksi Baru", "Bantuan", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_txtHelpMouseClicked

    private void txtAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAboutMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new About().show();
    }//GEN-LAST:event_txtAboutMouseClicked

    private void txtLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLogoutMouseClicked
        // TODO add your handling code here:
        
        
        if(JOptionPane.showConfirmDialog(null, "Apakah anda yakin akan keluar?",
                "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(this, "Anda Berhasil Logout!!");
            new Login().show();
            this.dispose();
        }
    }//GEN-LAST:event_txtLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblwktu;
    private javax.swing.JLabel tgl;
    private javax.swing.JLabel txtAbout;
    private javax.swing.JButton txtBandar;
    private javax.swing.JLabel txtHelp;
    private javax.swing.JButton txtLaporan;
    private javax.swing.JLabel txtLogout;
    private javax.swing.JButton txtPembelian;
    private javax.swing.JButton txtPenjualan;
    private javax.swing.JButton txtPetani;
    // End of variables declaration//GEN-END:variables
}
