/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplikasi_makelar;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Sherlock
 */
public class FormPembelian extends javax.swing.JFrame {

    /**
     * Creates new form FormPembelian
     */
    public FormPembelian() {
        initComponents();
        tabelbeli();
        tabelpetani();
        AutoNumber();
        txtIdPembelian.setEnabled(false);
        txtTotal.setEnabled(false);
        txtKembalian.setEnabled(false);
        txtHasilTani.requestFocus();
    }
    
    private void ValidasiHuruf(KeyEvent a){
        if(Character.isDigit(a.getKeyChar())){
            a.consume();
            JOptionPane.showMessageDialog(null,"Masukan data dalam huruf");
        }
    }
    
    private void ValidasiAngka(KeyEvent b){
        if(Character.isAlphabetic(b.getKeyChar())){
            b.consume();
            JOptionPane.showMessageDialog(null,"Masukan data dalam angka");
        }
    }
    
    private void tabelbeli() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("ID Pembelian");
        model.addColumn("Waktu/Tanggal");
        model.addColumn("Nama Hasil Tani");
        model.addColumn("Jumlah (kg)");
        model.addColumn("Harga Beli/kg");
        model.addColumn("Total");
        model.addColumn("Nama Petani");
        
        try {
            int no=1;
            String cari = keyword.getText();
            String sql = "SELECT pembelian.id_trx, pembelian.tanggal, pembelian.hasil_tani, pembelian.jumlah, pembelian.harga, pembelian.total, petani.nama_petani FROM pembelian JOIN petani ON pembelian.id_petani=petani.id_petani WHERE pembelian.id_trx LIKE '%"+cari+"%' OR pembelian.tanggal LIKE '%"+cari+"%' ORDER BY id_trx DESC";
            Connection conn=(Connection)koneksi.getKoneksi();
            Statement stm=conn.createStatement();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString("id_trx"),res.getString("tanggal"),res.getString("hasil_tani"),res.getString("jumlah"),res.getString("harga"),res.getString("total"),res.getString("nama_petani")});
            }
            tblbeli.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Terjadi Kesalahan\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }

    }
    
    private void tabelpetani() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("ID Petani");
        model.addColumn("Nama Petani");
        model.addColumn("Lokasi Sawah");
        
        try {
            int no=1;
            String cari = katakunci.getText();
            String sql = "select * from petani where nama_petani like '%"+cari+"%' order by id_petani desc";
            Connection conn=(Connection)koneksi.getKoneksi();
            Statement stm=conn.createStatement();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3)});
            }
            tabelTani.setModel(model);
        } catch (SQLException e) {
        }
    }
 
   private void HapusText() {
    txtHasilTani.setText(null);
    txtHarga.setText(null);
    txtJumlah.setText(null);
    txtIdPtn.setText(null);
    txtIdPtn.setEnabled(true);
    txtTotal.setText(null);
    txtBayar.setText(null);
    txtKembalian.setText(null);
    katakunci.setText(null);
    keyword.setText(null);
    tabelpetani();
    tabelbeli();
    AutoNumber();
    txtHasilTani.requestFocus();
}
   
   private void AutoNumber(){
         try{
          String sql = "SELECT MAX(RIGHT(id_trx,3)) AS no_auto FROM pembelian";
          Connection conn = (Connection)koneksi.getKoneksi();
          Statement stm= conn.createStatement(); 
           ResultSet res = stm.executeQuery(sql);
          
           while(res.next()){
               
           
           if (res.first()==false){
               txtIdPembelian.setText("TRX001");
           }else{
               res.last();
               int set_kode = res.getInt(1)+1;
               String no_auto = String.valueOf(set_kode);
               int kode_next = no_auto.length();
               for (int a=0; a<3 - kode_next; a++){
                   no_auto ="0"+no_auto;
               }
               txtIdPembelian.setText("TRX"+no_auto);
           }
           } 
         }catch (SQLException ex){
            Logger.getLogger(FormPetani.class.getName()).log(Level.SEVERE, null, ex);
     }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIdPtn = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtHasilTani = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnKosong = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtIdPembelian = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();
        txtKembalian = new javax.swing.JTextField();
        btnCtk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbeli = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        keyword = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTani = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        katakunci = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        btnCtkUlg = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaksi Pembelian");
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(46, 191, 188));
        jPanel1.setMinimumSize(new java.awt.Dimension(1410, 780));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 640));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("INPUT TRANSAKSI PEMBELIAN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Nama Hasil Tani");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 120, 30));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Jumlah (kg)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 120, 30));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Harga Beli/kg");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 120, 30));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("ID Petani");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, 120, 30));

        txtIdPtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(txtIdPtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 185, 30));

        txtHarga.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargaKeyTyped(evt);
            }
        });
        jPanel1.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 185, 30));

        txtHasilTani.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtHasilTani.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHasilTaniKeyTyped(evt);
            }
        });
        jPanel1.add(txtHasilTani, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 185, 30));

        btnSimpan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 150, 35));

        btnKembali.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/kembali.png"))); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        jPanel1.add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 160, 40));

        btnKosong.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnKosong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/kosong (Custom).png"))); // NOI18N
        btnKosong.setText("Kosongkan Form");
        btnKosong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKosongActionPerformed(evt);
            }
        });
        jPanel1.add(btnKosong, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 160, 35));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("ID Pembelian");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 100, 30));

        txtIdPembelian.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(txtIdPembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 180, 30));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setText("DATA TRANSAKSI PEMBELIAN");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, -1, 30));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setText("KALKULATOR PEMBAYARAN");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Total");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 100, 30));

        txtTotal.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 180, 30));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel11.setText("Bayar");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 100, 30));

        txtBayar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBayarKeyTyped(evt);
            }
        });
        jPanel1.add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 180, 30));

        btnHitung.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnHitung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hitung (Custom).png"))); // NOI18N
        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });
        jPanel1.add(btnHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 160, 100, 30));

        txtKembalian.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(txtKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 180, 30));

        btnCtk.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCtk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Print.png"))); // NOI18N
        btnCtk.setText("Cetak Nota");
        btnCtk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCtkActionPerformed(evt);
            }
        });
        jPanel1.add(btnCtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 310, 180, 30));

        tblbeli.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblbeli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblbeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbeliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbeli);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, 1110, 190));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel13.setText("Masukkan ID Pembelian/Tanggal");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 190, 30));

        keyword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        keyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keywordKeyReleased(evt);
            }
        });
        jPanel1.add(keyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 480, 430, 30));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel14.setText("DETAIL NOTA PEMBAYARAN");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, -1, -1));

        tabelTani.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tabelTani.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelTani.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTaniMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelTani);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 390, 220));

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel15.setText("DATA PETANI");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 50, -1, -1));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel16.setText("Masukkan Nama Petani");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 80, 140, 30));

        katakunci.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        katakunci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                katakunciKeyReleased(evt);
            }
        });
        jPanel1.add(katakunci, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 80, 250, 30));

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel17.setText("Kembalian");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 100, 30));

        txtJumlah.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJumlahKeyTyped(evt);
            }
        });
        jPanel1.add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 185, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel7.setText("Ket : Klik data yang diinginkan");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 490, -1, -1));

        btnHelp.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/help.png"))); // NOI18N
        btnHelp.setText("Bantuan");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        jPanel1.add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 590, 160, -1));

        btnCtkUlg.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCtkUlg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Print.png"))); // NOI18N
        btnCtkUlg.setText("Cetak Ulang Nota");
        btnCtkUlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCtkUlgActionPerformed(evt);
            }
        });
        jPanel1.add(btnCtkUlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 480, -1, 30));

        jLabel12.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel12.setText("Ket : Klik data yang diinginkan");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 350, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Open (Custom).jpg"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKosongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKosongActionPerformed
       // TODO add your handling code here:
       HapusText();
    }//GEN-LAST:event_btnKosongActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String IdPembelian= txtIdPembelian.getText();
        String NamaHasilTani = txtHasilTani.getText();
        String Jumlah = txtJumlah.getText();
        String HargaBeli= txtHarga.getText();
        String IdPetani = txtIdPtn.getText();
        int jml = Integer.parseInt(Jumlah);
        int hrg = Integer.parseInt(HargaBeli);
        int total = jml*hrg;
        txtTotal.setText(Integer.toString(total));
        
            if (NamaHasilTani.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Nama Hasil Tani tidak boleh kosong");
                txtHasilTani.requestFocus();
            }else if (Jumlah.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Jumlah tidak boleh kosong");
                txtJumlah.requestFocus();
            }else if (HargaBeli.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Harga Beli tidak boleh kosong");
                txtHarga.requestFocus();
            }else if (IdPetani.isEmpty()) {
                JOptionPane.showMessageDialog(null,"ID Petani tidak boleh kosong");
                txtIdPtn.requestFocus();
            }else{
                try{
                    Date skrg = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                    String TanggalPembelian = ft.format(skrg);
                    Connection conn=(Connection)koneksi.getKoneksi();
                    Statement stm=conn.createStatement();
                    stm.executeUpdate("insert into pembelian VALUES('"+IdPembelian+"','"+TanggalPembelian+"','"+NamaHasilTani+"','"+Jumlah+"','"+HargaBeli+"','"+total+"','"+IdPetani+"')");  
                    JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }         
            tabelbeli();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        int total = Integer.parseInt (txtTotal.getText());
        int bayar = Integer.parseInt (txtBayar.getText());
        if (bayar < total){
            JOptionPane.showMessageDialog(null,"Maaf uang anda tidak cukup","Error",
            JOptionPane.INFORMATION_MESSAGE);
        }else{
            int kembalian = bayar - total ;
            txtKembalian.setText(Integer.toString(kembalian));
            JOptionPane.showMessageDialog(null,"Pembayaran Anda Berhasil !!","SELAMAT",
            JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnHitungActionPerformed

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new MenuUtama().setVisible(true);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void keywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keywordKeyReleased
        // TODO add your handling code here:
        tabelbeli();
    }//GEN-LAST:event_keywordKeyReleased

    private void katakunciKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_katakunciKeyReleased
        // TODO add your handling code here:
        tabelpetani();
    }//GEN-LAST:event_katakunciKeyReleased

    private void tabelTaniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTaniMouseClicked
        // TODO add your handling code here:
        int baris = tabelTani.rowAtPoint(evt.getPoint());
        String id_petani =tabelTani.getValueAt(baris, 1).toString();
        txtIdPtn.setText(id_petani);
        txtIdPtn.setEnabled(false);
    }//GEN-LAST:event_tabelTaniMouseClicked

    private void txtHasilTaniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHasilTaniKeyTyped
        // TODO add your handling code here:
        ValidasiHuruf(evt);
    }//GEN-LAST:event_txtHasilTaniKeyTyped

    private void txtHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaKeyTyped
        // TODO add your handling code here:
        ValidasiAngka(evt);
    }//GEN-LAST:event_txtHargaKeyTyped

    private void txtJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyTyped
        // TODO add your handling code here:
        ValidasiAngka(evt);
    }//GEN-LAST:event_txtJumlahKeyTyped

    private void txtBayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBayarKeyTyped
        // TODO add your handling code here:
        ValidasiAngka(evt);
    }//GEN-LAST:event_txtBayarKeyTyped

    private void btnCtkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCtkActionPerformed
        // TODO add your handling code here:
        try{
            String NamaFile = "notapembelian.jasper";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/makelar_tani","root","");
            HashMap param = new HashMap();
            //Mengambil parameter
            param.put("id_trx",txtIdPembelian.getText());
                   
            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnCtkActionPerformed

    private void btnCtkUlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCtkUlgActionPerformed
        // TODO add your handling code here:
        try{
            String NamaFile = "notapembelian.jasper";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/makelar_tani","root","");
            HashMap param = new HashMap();
            //Mengambil parameter
            param.put("id_trx",keyword.getText());
                   
            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnCtkUlgActionPerformed

    private void tblbeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbeliMouseClicked
        // TODO add your handling code here:
        int baris = tblbeli.rowAtPoint(evt.getPoint());
        String id_jual =tblbeli.getValueAt(baris, 1).toString();
        keyword.setText(id_jual);
    }//GEN-LAST:event_tblbeliMouseClicked

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Form Pembelian"
            + "\n1. Masukkan Nama Hasil Tani"
            + "\n2. Masukkan Harga Beli/kg"
            + "\n3. Masukkan Jumlah (kg)"
            + "\n4. Masukkan ID Petani (cari di tabel Data Petani, klik data yang diinginkan dari tabel Data Petani)"
            + "\n5. Klik Tombol Simpan"
            + "\n6. Masukkan Jumlah Bayar"
            + "\n7. Klik Tombol Hitung"
            + "\n8. Klik Tombol Cetak Nota"
            + "\n\nPencetakan ulang Nota"
            + "\n1. Masukkan ID Pembelian (ketik secara manual ID Pembelian "
            + "\n    atau cari di tabel Data Transaksi Pembelian, klik data yang diinginkan) "
            + "\n2. Klik Tombol Cetak Ulang Nota", "Bantuan", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnHelpActionPerformed

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
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCtk;
    private javax.swing.JButton btnCtkUlg;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnKosong;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField katakunci;
    private javax.swing.JTextField keyword;
    private javax.swing.JTable tabelTani;
    private javax.swing.JTable tblbeli;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtHasilTani;
    private javax.swing.JTextField txtIdPembelian;
    private javax.swing.JTextField txtIdPtn;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
