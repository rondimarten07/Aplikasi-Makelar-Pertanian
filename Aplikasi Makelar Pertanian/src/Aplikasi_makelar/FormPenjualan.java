/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplikasi_makelar;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Sherlock
 */
public class FormPenjualan extends javax.swing.JFrame {   
    /**
     * Creates new form Penjualan
     */
    public FormPenjualan() {
        initComponents();
        tabeljual();
        tabelbeli();
        tabelbandar();
        txtTotal.setEnabled(false);
        txtKembalian.setEnabled(false);
    }
    
    private void tabeljual() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("ID Penjualan");
        model.addColumn("Waktu/Tanggal");
        model.addColumn("Nama Hasil Tani");
        model.addColumn("Jumlah (kg)");
        model.addColumn("Harga Jual/kg");
        model.addColumn("Total");
        model.addColumn("Nama Bandar");
        
        try {
            int no=1;
            String cari = katakunci.getText();
            String sql = "SELECT penjualan.id_trx, penjualan.tanggal, penjualan.hasil_tani, penjualan.jumlah, penjualan.harga, penjualan.total, bandar.nama_bandar FROM penjualan JOIN bandar ON penjualan.id_bandar=bandar.id_bandar WHERE penjualan.id_trx LIKE '%"+cari+"%' OR penjualan.tanggal LIKE '%"+cari+"%' ORDER BY id_trx DESC";
            Connection conn=(Connection)koneksi.getKoneksi();
            Statement stm=conn.createStatement();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString("id_trx"),res.getString("tanggal"),res.getString("hasil_tani"),res.getString("jumlah"),res.getString("harga"),res.getString("total"),res.getString("nama_bandar")});
            }
            tblJual.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Terjadi Kesalahan\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
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
            tblBeli.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Terjadi Kesalahan\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
}
    
    private void tabelbandar() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No.");
        model.addColumn("ID Bandar");
        model.addColumn("Nama Bandar");
        model.addColumn("No Ponsel");
        
        try {
            int no=1;
            String cari = pencarian.getText();
            String sql = "select * from bandar where nama_bandar like '%"+cari+"%' order by id_bandar desc";
            Connection conn=(Connection)koneksi.getKoneksi();
            Statement stm=conn.createStatement();
            ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3)});
            }
            tblBdr.setModel(model);
        } catch (SQLException e) {
        }
    }

    private void HapusText() {
        txtId.setText(null);
        txtHasilTn.setText(null);
        txtHarga.setText(null);
        txtJumlah.setText(null);
        txtIdBdr.setText(null);
        txtTotal.setText(null);
        txtBayar.setText(null);
        txtKembalian.setText(null);
        katakunci.setText(null);
        pencarian.setText(null);
        keyword.setText(null);
        tabelbeli();
        tabeljual();
        tabelbandar();
        txtId.setEnabled(true);
        txtHasilTn.setEnabled(true);
        txtJumlah.setEnabled(true);
        txtIdBdr.setEnabled(true);
        txtId.requestFocus();
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        inputtransaksipenjualanlb = new javax.swing.JLabel();
        idpembelianlb = new javax.swing.JLabel();
        idbandarlb = new javax.swing.JLabel();
        namahasiltanilb = new javax.swing.JLabel();
        jumlahlb = new javax.swing.JLabel();
        hargajuallb = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtIdBdr = new javax.swing.JTextField();
        btnCtk = new javax.swing.JButton();
        btnKembali = new javax.swing.JButton();
        btnKosong = new javax.swing.JButton();
        datatransaksipenjualanlb = new javax.swing.JLabel();
        totallb = new javax.swing.JLabel();
        bayarlb = new javax.swing.JLabel();
        kembalianlb = new javax.swing.JLabel();
        txtKembalian = new javax.swing.JTextField();
        kallkulatorpembayaranlb = new javax.swing.JLabel();
        katakunci = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtBayar = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHitung = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBdr = new javax.swing.JTable();
        masukkannamabandarlb = new javax.swing.JLabel();
        pencarian = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblJual = new javax.swing.JTable();
        databandarlb = new javax.swing.JLabel();
        datatransaksipembelianlb = new javax.swing.JLabel();
        tanggalbulantahunlb = new javax.swing.JLabel();
        keyword = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBeli = new javax.swing.JTable();
        lblCrJl = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        txtHasilTn = new javax.swing.JTextField();
        btnCtkUlg = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transaksi Penjualan");

        jPanel1.setBackground(new java.awt.Color(46, 191, 188));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 640));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputtransaksipenjualanlb.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        inputtransaksipenjualanlb.setText("INPUT TRANSAKSI PENJUALAN");
        jPanel1.add(inputtransaksipenjualanlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, 30));

        idpembelianlb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        idpembelianlb.setText("ID Pembelian");
        jPanel1.add(idpembelianlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 130, 30));

        idbandarlb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        idbandarlb.setText("ID Bandar");
        jPanel1.add(idbandarlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 130, 30));

        namahasiltanilb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        namahasiltanilb.setText("Nama Hasil Tani");
        jPanel1.add(namahasiltanilb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 130, 30));

        jumlahlb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jumlahlb.setText("Harga Jual/kg");
        jPanel1.add(jumlahlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 130, 30));

        hargajuallb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        hargajuallb.setText("Jumlah (kg)");
        jPanel1.add(hargajuallb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 130, 30));

        txtId.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 183, 30));

        txtHarga.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtHarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHargaKeyTyped(evt);
            }
        });
        jPanel1.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 183, 30));

        txtIdBdr.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(txtIdBdr, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 183, 30));

        btnCtk.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCtk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Print.png"))); // NOI18N
        btnCtk.setText("Cetak Nota");
        btnCtk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCtkActionPerformed(evt);
            }
        });
        jPanel1.add(btnCtk, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 150, 30));

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
        jPanel1.add(btnKosong, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 160, 35));

        datatransaksipenjualanlb.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        datatransaksipenjualanlb.setText("DATA TRANSAKSI PENJUALAN");
        jPanel1.add(datatransaksipenjualanlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 580, -1, 30));

        totallb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        totallb.setText("Total");
        jPanel1.add(totallb, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 80, 30));

        bayarlb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        bayarlb.setText("Bayar");
        jPanel1.add(bayarlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 80, 30));

        kembalianlb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        kembalianlb.setText("Kembalian");
        jPanel1.add(kembalianlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 80, 30));

        txtKembalian.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(txtKembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 150, 30));

        kallkulatorpembayaranlb.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        kallkulatorpembayaranlb.setText("KALKULATOR PEMBAYARAN");
        jPanel1.add(kallkulatorpembayaranlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, -1, 30));

        katakunci.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        katakunci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                katakunciKeyReleased(evt);
            }
        });
        jPanel1.add(katakunci, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 620, 400, 30));

        txtTotal.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, 150, 30));

        txtBayar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBayarKeyTyped(evt);
            }
        });
        jPanel1.add(txtBayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 110, 150, 30));

        btnSimpan.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save.png"))); // NOI18N
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 130, 35));

        btnHitung.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnHitung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hitung (Custom).png"))); // NOI18N
        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });
        jPanel1.add(btnHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 150, 100, 30));

        tblBdr.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblBdr.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBdr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBdrMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBdr);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 110, 510, 200));

        masukkannamabandarlb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        masukkannamabandarlb.setText("Masukkan Nama Bandar");
        jPanel1.add(masukkannamabandarlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, -1, 30));

        pencarian.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        pencarian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pencarianKeyReleased(evt);
            }
        });
        jPanel1.add(pencarian, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 70, 360, 30));

        tblJual.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblJual.setModel(new javax.swing.table.DefaultTableModel(
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
        tblJual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJualMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblJual);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 660, 1130, 100));

        databandarlb.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        databandarlb.setText("DATA BANDAR");
        jPanel1.add(databandarlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, -1, 30));

        datatransaksipembelianlb.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        datatransaksipembelianlb.setText("DATA TRANSAKSI PEMBELIAN");
        jPanel1.add(datatransaksipembelianlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, -1, 30));

        tanggalbulantahunlb.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tanggalbulantahunlb.setText("Masukkan ID Penjualan/Tanggal");
        jPanel1.add(tanggalbulantahunlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 190, 30));

        keyword.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        keyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keywordKeyReleased(evt);
            }
        });
        jPanel1.add(keyword, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 400, 30));

        tblBeli.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tblBeli.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBeli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBeliMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBeli);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 1130, 100));

        lblCrJl.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lblCrJl.setText("Masukkan ID Penjualan/Tanggal");
        jPanel1.add(lblCrJl, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, 190, 30));

        txtJumlah.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtJumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJumlahKeyTyped(evt);
            }
        });
        jPanel1.add(txtJumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 183, 30));

        txtHasilTn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtHasilTn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHasilTnKeyTyped(evt);
            }
        });
        jPanel1.add(txtHasilTn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 183, 30));

        btnCtkUlg.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCtkUlg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Print.png"))); // NOI18N
        btnCtkUlg.setText("Cetak Ulang Nota");
        btnCtkUlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCtkUlgActionPerformed(evt);
            }
        });
        jPanel1.add(btnCtkUlg, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 620, -1, -1));

        btnHelp.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/help.png"))); // NOI18N
        btnHelp.setText("Bantuan");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        jPanel1.add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 590, 160, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel1.setText("Ket : Klik data yang diinginkan");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 620, -1, 30));

        jLabel2.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel2.setText("Ket : Klik data yang diinginkan");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 320, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 2, 14)); // NOI18N
        jLabel3.setText("Ket : Klik data yang diinginkan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 440, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Open (Custom).jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String IdPenjualan= txtId.getText();
        String NamaHasilTani = txtHasilTn.getText();
        String HargaJual = txtHarga.getText();
        String Jumlah = txtJumlah.getText();
        String IdBandar = txtIdBdr.getText();
        int jml = Integer.parseInt(Jumlah);
        int hrg = Integer.parseInt(HargaJual);
        int total = jml*hrg;
        txtTotal.setText(Integer.toString(total));
        
        if(IdPenjualan.isEmpty()){
            JOptionPane.showMessageDialog(null,"ID Penjualan tidak boleh kosong");
            txtId.requestFocus();
        }else if (NamaHasilTani.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nama Hasil Tani tidak boleh kosong");
            txtHasilTn.requestFocus();
        }else if (Jumlah.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Jumlah tidak boleh kosong");
            txtJumlah.requestFocus();
        }else if (HargaJual.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Harga Jual tidak boleh kosong");
            txtHarga.requestFocus();
        }else if (IdBandar.isEmpty()) {
            JOptionPane.showMessageDialog(null,"ID Bandar tidak boleh kosong");
            txtIdBdr.requestFocus();
        }else{
            try{
                Date skrg = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
                String TanggalPenjualan = ft.format(skrg);
                Connection conn=(Connection)koneksi.getKoneksi();
                Statement stm=conn.createStatement();
               
                stm.executeUpdate("insert into penjualan VALUES('"+IdPenjualan+"','"+TanggalPenjualan+"','"+NamaHasilTani+"','"+Jumlah+"','"+HargaJual+"','"+total+"','"+IdBandar+"')");
                
                tabeljual();
       
                 JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        tabeljual();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnKosongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKosongActionPerformed
        // TODO add your handling code here:
        HapusText();
    }//GEN-LAST:event_btnKosongActionPerformed

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        // TODO add your handling code here:
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

    private void katakunciKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_katakunciKeyReleased
        // TODO add your handling code here:
        tabeljual();
    }//GEN-LAST:event_katakunciKeyReleased

    private void pencarianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pencarianKeyReleased
        // TODO add your handling code here:
        tabelbandar();
    }//GEN-LAST:event_pencarianKeyReleased

    private void keywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keywordKeyReleased
        // TODO add your handling code here:
        tabelbeli();
    }//GEN-LAST:event_keywordKeyReleased

    private void txtBayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBayarKeyTyped
        // TODO add your handling code here:
        ValidasiAngka(evt);
    }//GEN-LAST:event_txtBayarKeyTyped

    private void txtJumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJumlahKeyTyped
        // TODO add your handling code here:
        ValidasiAngka(evt);
    }//GEN-LAST:event_txtJumlahKeyTyped

    private void txtHargaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHargaKeyTyped
        // TODO add your handling code here:
        ValidasiAngka(evt);
    }//GEN-LAST:event_txtHargaKeyTyped

    private void txtHasilTnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHasilTnKeyTyped
        // TODO add your handling code here:
        ValidasiHuruf(evt);
    }//GEN-LAST:event_txtHasilTnKeyTyped

    private void tblBdrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBdrMouseClicked
        // TODO add your handling code here:
        int baris = tblBdr.rowAtPoint(evt.getPoint());
        String id_bandar =tblBdr.getValueAt(baris, 1).toString();
        txtIdBdr.setText(id_bandar);
        txtIdBdr.setEnabled(false);
    }//GEN-LAST:event_tblBdrMouseClicked

    private void tblBeliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBeliMouseClicked
        // TODO add your handling code here:
        int baris = tblBeli.rowAtPoint(evt.getPoint());
        String id_beli =tblBeli.getValueAt(baris, 1).toString();
        txtId.setText(id_beli);
        String hasiltn =tblBeli.getValueAt(baris, 3).toString();
        txtHasilTn.setText(hasiltn);
        String jumlah =tblBeli.getValueAt(baris, 4).toString();
        txtJumlah.setText(jumlah);
        txtId.setEnabled(false);
        txtHasilTn.setEnabled(false);
        txtJumlah.setEnabled(false);
    }//GEN-LAST:event_tblBeliMouseClicked

    private void btnCtkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCtkActionPerformed
        // TODO add your handling code here:
        try{
            String NamaFile = "notapenjualan.jasper";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/makelar_tani","root","");
            HashMap param = new HashMap();
            //Mengambil parameter
            param.put("id_trx",txtId.getText());
                   
            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnCtkActionPerformed

    private void btnCtkUlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCtkUlgActionPerformed
        // TODO add your handling code here:
        try{
            String NamaFile = "notapenjualan.jasper";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/makelar_tani","root","");
            HashMap param = new HashMap();
            //Mengambil parameter
            param.put("id_trx",katakunci.getText());
                   
            JasperPrint JPrint = JasperFillManager.fillReport(NamaFile, param, koneksi);
            JasperViewer.viewReport(JPrint);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnCtkUlgActionPerformed

    private void tblJualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJualMouseClicked
        // TODO add your handling code here:
        int baris = tblJual.rowAtPoint(evt.getPoint());
        String id_jual =tblJual.getValueAt(baris, 1).toString();
        katakunci.setText(id_jual);
    }//GEN-LAST:event_tblJualMouseClicked

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Form Penjualan"
            + "\n1. Masukkan ID Pembelian (cari di tabel Data Transaksi Pembelian, klik data yang di inginkan dari tabel Data Transaksi Pembelian)"
            + "\n2. ID Pembelian, Nama Hasil Tani, Jumlah (kg) akan otomatis terisi"
            + "\n3. Masukkan Harga Jual/kg"
            + "\n4. Masukkan ID Bandar (cari di tabel Data Bandar, klik data yang diinginkan dari tabel Data Bandar)"
            + "\n5. Klik Tombol Simpan"
            + "\n6. Masukkan Jumlah Bayar"
            + "\n7. Klik Tombol Hitung"
            + "\n8. Klik Tombol Cetak Nota"
            + "\n\nPencetakan ulang Nota"
            + "\n1. Masukkan ID Penjualan (ketik secara manual ID Penjualan "
            + "\n    atau cari di tabel Data Transaksi Penjualan, klik data yang diinginkan) "
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
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bayarlb;
    private javax.swing.JButton btnCtk;
    private javax.swing.JButton btnCtkUlg;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnKosong;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel databandarlb;
    private javax.swing.JLabel datatransaksipembelianlb;
    private javax.swing.JLabel datatransaksipenjualanlb;
    private javax.swing.JLabel hargajuallb;
    private javax.swing.JLabel idbandarlb;
    private javax.swing.JLabel idpembelianlb;
    private javax.swing.JLabel inputtransaksipenjualanlb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jumlahlb;
    private javax.swing.JLabel kallkulatorpembayaranlb;
    private javax.swing.JTextField katakunci;
    private javax.swing.JLabel kembalianlb;
    private javax.swing.JTextField keyword;
    private javax.swing.JLabel lblCrJl;
    private javax.swing.JLabel masukkannamabandarlb;
    private javax.swing.JLabel namahasiltanilb;
    private javax.swing.JTextField pencarian;
    private javax.swing.JLabel tanggalbulantahunlb;
    private javax.swing.JTable tblBdr;
    private javax.swing.JTable tblBeli;
    private javax.swing.JTable tblJual;
    private javax.swing.JLabel totallb;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtHasilTn;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdBdr;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
