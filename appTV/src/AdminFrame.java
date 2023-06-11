/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Yha
 */
import java.sql.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class AdminFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminFrame
     */
    CardLayout clays;
    int posisi = 1, idBarEdit;
    boolean kondisi, btnEditKah;
    static ArrayList<barang> dataBarang = new ArrayList<>();
    static ArrayList<transaksi> dataTransaksi = new ArrayList<>();
    
    void readDB(){
        try{
            dataBarang.clear();
            dataTransaksi.clear();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtv", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from tbbarang");
            if(!rs.next()){
                System.out.println("No Data Yet");
            }else{
                do{
                    String nama = rs.getString("nama");
                    String ukuran = rs.getString("ukuran");
                    String tipe = rs.getString("tipe");
                    int stok = rs.getInt("stok");
                    int harga = rs.getInt("harga");
                    int id = rs.getInt("id");
                    barang fillBarang = new barang(nama, ukuran, tipe, harga, stok, id);
                    dataBarang.add(fillBarang);
                }while(rs.next());
            }
            rs.close();
            rs = stmt.executeQuery("Select nama, item, alamat, tbtransaksi.status as 'status', qty, harga, tbtransaksi.id as 'id' from tbtransaksi join akun on tbtransaksi.iduser=akun.id");
            if(!rs.next()){
                System.out.println("No Data Yet");
            }else{
                do{
                    String nama = rs.getString("nama");
                    String item = rs.getString("item");
                    String alamat = rs.getString("alamat");
                    String status = rs.getString("status");
                    int qty = rs.getInt("qty");
                    int harga = rs.getInt("harga");
                    int id = rs.getInt("id");
                    transaksi fillTransaksi = new transaksi(nama, item, alamat, status, qty, harga, id);
                    dataTransaksi.add(fillTransaksi);
                }while(rs.next());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        db2Tb();
    }
    
    void db2Tb(){
        ((DefaultTableModel)tbData.getModel()).setRowCount(0);
        ((DefaultTableModel)tbTransaksi.getModel()).setRowCount(0);
        for(int i = 0; i<dataBarang.size();i++){        
            String nama = dataBarang.get(i).getNama();
            String tipe = dataBarang.get(i).getTipe();
            String ukuran = dataBarang.get(i).getUkuran();
            int stok = dataBarang.get(i).getStok();
            int harga = dataBarang.get(i).getHarga();
            int id = dataBarang.get(i).getId();

            Object[] data = {id, nama, stok, tipe, ukuran,"Rp. " +harga};
            ((DefaultTableModel)tbData.getModel()).addRow(data);
        }
        for(int i = 0; i<dataTransaksi.size();i++){        
            String nama = dataTransaksi.get(i).getNama();
            String alamat = dataTransaksi.get(i).getAlamat();
            String item = dataTransaksi.get(i).getItem();
            String status = dataTransaksi.get(i).getStatus();
            int qty = dataTransaksi.get(i).getQty();
            int harga = dataTransaksi.get(i).getHarga();
            int total = dataTransaksi.get(i).getTotal();
            int id = dataTransaksi.get(i).getId();

            Object[] data = {nama, alamat, item, qty, "Rp. "+total, status};
            ((DefaultTableModel)tbTransaksi.getModel()).addRow(data);
        }
    }
    
    public AdminFrame() {
        initComponents();
        clays = (CardLayout)(CardPanel.getLayout());
        btnTV.setBackground(new Color(0,153,255));
        readDB();
        ccUkuran.add("24 Inch");
        ccUkuran.add("32 Inch");
        ccUkuran.add("40 Inch");
        ccUkuran.add("42 Inch");
        ccUkuran.add("46 Inch");
    }
    
    void bersihForm(){
        txtNama.setText("");
        txtStok.setText("");
        txtHarga.setText("");
        btnGroupTipe.clearSelection();
    }
    void cekAngka(){
        if(kondisi){
            if(Integer.parseInt(txtHarga.getText()) < 0 || Integer.parseInt(txtStok.getText()) < 0){
                kondisi = false;
            }
        }
    }
    
    void cekFormBar(){
        kondisi = true;
        try{
            Integer.parseInt(txtHarga.getText());
            Integer.parseInt(txtStok.getText());
        }catch(NumberFormatException e){
            kondisi = false;
        }
        if(txtNama.getText().isEmpty()){
            kondisi = false;
        }else if(txtStok.getText().isEmpty()){
            kondisi = false;
        }else if(txtHarga.getText().isEmpty()){
            kondisi = false;
        }
        cekAngka();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupTipe = new javax.swing.ButtonGroup();
        topBar = new javax.swing.JPanel();
        btnTV = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTrans = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnProfile = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        CardPanel = new javax.swing.JPanel();
        barangPanel = new javax.swing.JPanel();
        btnAddBarang = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        transaksiPanel = new javax.swing.JPanel();
        btnSimpanProfile1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        tbTrans = new javax.swing.JScrollPane();
        tbTransaksi = new javax.swing.JTable();
        profilePanel = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel19 = new javax.swing.JLabel();
        btnSimpanProfile = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        InputPanel = new javax.swing.JPanel();
        txtHarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ccUkuran = new java.awt.Choice();
        rdLCD = new javax.swing.JRadioButton();
        rdCRT = new javax.swing.JRadioButton();
        rdPlasma = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtStok = new javax.swing.JTextField();
        btnSaveBarang = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1000, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topBar.setBackground(new java.awt.Color(0, 51, 255));
        topBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTV.setBackground(new java.awt.Color(0, 51, 255));
        btnTV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTV.setPreferredSize(new java.awt.Dimension(50, 50));
        btnTV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTVMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-tv-40.png"))); // NOI18N

        javax.swing.GroupLayout btnTVLayout = new javax.swing.GroupLayout(btnTV);
        btnTV.setLayout(btnTVLayout);
        btnTVLayout.setHorizontalGroup(
            btnTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTVLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        btnTVLayout.setVerticalGroup(
            btnTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTVLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        topBar.add(btnTV, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 60, 70, -1));

        btnTrans.setBackground(new java.awt.Color(0, 51, 255));
        btnTrans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTrans.setPreferredSize(new java.awt.Dimension(50, 50));
        btnTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-cart-40.png"))); // NOI18N

        javax.swing.GroupLayout btnTransLayout = new javax.swing.GroupLayout(btnTrans);
        btnTrans.setLayout(btnTransLayout);
        btnTransLayout.setHorizontalGroup(
            btnTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTransLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        btnTransLayout.setVerticalGroup(
            btnTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTransLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        topBar.add(btnTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 60, 70, -1));

        btnProfile.setBackground(new java.awt.Color(0, 51, 255));
        btnProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProfile.setPreferredSize(new java.awt.Dimension(50, 50));
        btnProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProfileMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-user-40.png"))); // NOI18N

        javax.swing.GroupLayout btnProfileLayout = new javax.swing.GroupLayout(btnProfile);
        btnProfile.setLayout(btnProfileLayout);
        btnProfileLayout.setHorizontalGroup(
            btnProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProfileLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        btnProfileLayout.setVerticalGroup(
            btnProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnProfileLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        topBar.add(btnProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 70, -1));
        topBar.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 20, 344, 28));

        getContentPane().add(topBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 110));

        CardPanel.setLayout(new java.awt.CardLayout());

        barangPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddBarang.setBackground(new java.awt.Color(51, 51, 255));
        btnAddBarang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnAddBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddBarangMouseClicked(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tambah");

        javax.swing.GroupLayout btnAddBarangLayout = new javax.swing.GroupLayout(btnAddBarang);
        btnAddBarang.setLayout(btnAddBarangLayout);
        btnAddBarangLayout.setHorizontalGroup(
            btnAddBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddBarangLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel11)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        btnAddBarangLayout.setVerticalGroup(
            btnAddBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAddBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        barangPanel.add(btnAddBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 140, 40));

        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nama", "Stok", "Tipe", "Ukuran", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbData);

        barangPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 69, 730, 220));

        jPanel4.setBackground(new java.awt.Color(51, 51, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Edit");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(56, 56, 56))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        barangPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, 40));

        jPanel5.setBackground(new java.awt.Color(51, 51, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel5.setPreferredSize(new java.awt.Dimension(142, 42));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Hapus");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(56, 56, 56))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        barangPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 40));

        CardPanel.add(barangPanel, "card2");

        transaksiPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSimpanProfile1.setBackground(new java.awt.Color(51, 51, 255));
        btnSimpanProfile1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Selesaikan");

        javax.swing.GroupLayout btnSimpanProfile1Layout = new javax.swing.GroupLayout(btnSimpanProfile1);
        btnSimpanProfile1.setLayout(btnSimpanProfile1Layout);
        btnSimpanProfile1Layout.setHorizontalGroup(
            btnSimpanProfile1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSimpanProfile1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(35, 35, 35))
        );
        btnSimpanProfile1Layout.setVerticalGroup(
            btnSimpanProfile1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSimpanProfile1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        transaksiPanel.add(btnSimpanProfile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 130, -1));

        tbTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Alamat", "Item", "Qty", "Total", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTrans.setViewportView(tbTransaksi);

        transaksiPanel.add(tbTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 740, 210));

        CardPanel.add(transaksiPanel, "card4");

        profilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogOut.setBackground(new java.awt.Color(255, 255, 255));
        btnLogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Log Out");

        javax.swing.GroupLayout btnLogOutLayout = new javax.swing.GroupLayout(btnLogOut);
        btnLogOut.setLayout(btnLogOutLayout);
        btnLogOutLayout.setHorizontalGroup(
            btnLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLogOutLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel5)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        btnLogOutLayout.setVerticalGroup(
            btnLogOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLogOutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        profilePanel.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 130, -1));

        jLabel15.setText("Nama");
        profilePanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));
        profilePanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 240, 30));

        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel16.setText("Profile.");
        profilePanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 90, 40));

        jLabel17.setText("Password");
        profilePanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));
        profilePanel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 240, 30));
        profilePanel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 240, 30));

        jLabel18.setText("E-mail");
        profilePanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));
        profilePanel.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 240, 30));

        jLabel19.setText("Alamat");
        profilePanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        btnSimpanProfile.setBackground(new java.awt.Color(51, 51, 255));
        btnSimpanProfile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Simpan");

        javax.swing.GroupLayout btnSimpanProfileLayout = new javax.swing.GroupLayout(btnSimpanProfile);
        btnSimpanProfile.setLayout(btnSimpanProfileLayout);
        btnSimpanProfileLayout.setHorizontalGroup(
            btnSimpanProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSimpanProfileLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel20)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        btnSimpanProfileLayout.setVerticalGroup(
            btnSimpanProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSimpanProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        profilePanel.add(btnSimpanProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 130, -1));

        CardPanel.add(profilePanel, "card5");

        InputPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        InputPanel.add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 250, -1));

        jLabel4.setText("Tipe");
        InputPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));
        InputPanel.add(ccUkuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 250, 40));

        btnGroupTipe.add(rdLCD);
        rdLCD.setText("CRT");
        rdLCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdLCDActionPerformed(evt);
            }
        });
        InputPanel.add(rdLCD, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        btnGroupTipe.add(rdCRT);
        rdCRT.setText("LCD");
        rdCRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdCRTActionPerformed(evt);
            }
        });
        InputPanel.add(rdCRT, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        btnGroupTipe.add(rdPlasma);
        rdPlasma.setText("PLASMA");
        rdPlasma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdPlasmaActionPerformed(evt);
            }
        });
        InputPanel.add(rdPlasma, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        jLabel6.setText("Ukuran");
        InputPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));
        InputPanel.add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 250, -1));

        jLabel7.setText("Nama");
        InputPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, -1, -1));

        jLabel8.setText("Stok");
        InputPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));
        InputPanel.add(txtStok, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 250, -1));

        btnSaveBarang.setBackground(new java.awt.Color(255, 255, 255));
        btnSaveBarang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        btnSaveBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveBarangMouseClicked(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(51, 51, 255));
        jLabel9.setText("Simpan");

        javax.swing.GroupLayout btnSaveBarangLayout = new javax.swing.GroupLayout(btnSaveBarang);
        btnSaveBarang.setLayout(btnSaveBarangLayout);
        btnSaveBarangLayout.setHorizontalGroup(
            btnSaveBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSaveBarangLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel9)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        btnSaveBarangLayout.setVerticalGroup(
            btnSaveBarangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSaveBarangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        InputPanel.add(btnSaveBarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 140, 40));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Batal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        InputPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 140, -1));

        jLabel12.setText("Harga");
        InputPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        CardPanel.add(InputPanel, "card3");

        getContentPane().add(CardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 780, 310));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdLCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdLCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdLCDActionPerformed

    private void rdCRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdCRTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdCRTActionPerformed

    private void rdPlasmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdPlasmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdPlasmaActionPerformed

    private void btnTVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTVMouseClicked
        clays.first(CardPanel);
        posisi = 1;
        btnTV.setBackground(new Color(0,153,255));
        btnTrans.setBackground(new Color(0,51,255));
        btnProfile.setBackground(new Color(0,51,255));
    }//GEN-LAST:event_btnTVMouseClicked

    private void btnTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransMouseClicked
        if(posisi==1){
            clays.next(CardPanel);
        }else if(posisi==2){
        }else if(posisi==3){
            clays.previous(CardPanel);
        }else if(posisi==4){
            clays.previous(CardPanel);
            clays.previous(CardPanel);
        }
        posisi = 2;
        btnTV.setBackground(new Color(0,51,255));
        btnTrans.setBackground(new Color(0,153,255));
        btnProfile.setBackground(new Color(0,51,255));
    }//GEN-LAST:event_btnTransMouseClicked

    private void btnProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProfileMouseClicked
        if(posisi==1){
            clays.next(CardPanel);
            clays.next(CardPanel);
        }else if(posisi==2){
            clays.next(CardPanel);
        }else if(posisi==3){
        }else if(posisi==4){
            clays.previous(CardPanel);
        }
        posisi = 3;
        btnTV.setBackground(new Color(0,51,255));
        btnTrans.setBackground(new Color(0,51,255));
        btnProfile.setBackground(new Color(0,153,255));
    }//GEN-LAST:event_btnProfileMouseClicked

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
        this.dispose();
        JOptionPane.showMessageDialog(null , "Log Out");
        main mn = new main();
        mn.setVisible(true);
    }//GEN-LAST:event_btnLogOutMouseClicked

    private void btnAddBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddBarangMouseClicked
        bersihForm();
        clays.last(CardPanel);
        posisi = 4;
    }//GEN-LAST:event_btnAddBarangMouseClicked

    private void btnSaveBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveBarangMouseClicked
        cekFormBar();
        if(kondisi){
            try{
                String tipe =null;
                if(rdCRT.isSelected()){
                    tipe = "CRT";
                }else if(rdLCD.isSelected()){
                    tipe = "LCD";
                }else if(rdPlasma.isSelected()){
                    tipe = "Plasma";
                }
                String nama = txtNama.getText();
                int harga = Integer.parseInt(txtHarga.getText());
                int stok = Integer.parseInt(txtStok.getText());
                String ukuran = ccUkuran.getSelectedItem();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtv", "root", "");
                Statement stmt = conn.createStatement();
                if(btnEditKah){
                    
                }else if(!btnEditKah){
                    stmt.executeUpdate("insert into tbbarang(id, nama, harga, ukuran, stok, tipe) values('0', '"+nama+"', '"+harga+"', '"+ukuran+"', '"+stok+"', '"+tipe+"')");
                    JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah");
                    bersihForm();
                    clays.first(CardPanel);
                    posisi = 1;
                    btnTV.setBackground(new Color(0,153,255));
                    btnTrans.setBackground(new Color(0,51,255));
                    btnProfile.setBackground(new Color(0,51,255));
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error save");
            }
        }
        readDB();
    }//GEN-LAST:event_btnSaveBarangMouseClicked

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
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardPanel;
    private javax.swing.JPanel InputPanel;
    private javax.swing.JPanel barangPanel;
    private javax.swing.JPanel btnAddBarang;
    private javax.swing.ButtonGroup btnGroupTipe;
    private javax.swing.JPanel btnLogOut;
    private javax.swing.JPanel btnProfile;
    private javax.swing.JPanel btnSaveBarang;
    private javax.swing.JPanel btnSimpanProfile;
    private javax.swing.JPanel btnSimpanProfile1;
    private javax.swing.JPanel btnTV;
    private javax.swing.JPanel btnTrans;
    private java.awt.Choice ccUkuran;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JRadioButton rdCRT;
    private javax.swing.JRadioButton rdLCD;
    private javax.swing.JRadioButton rdPlasma;
    private javax.swing.JTable tbData;
    private javax.swing.JScrollPane tbTrans;
    private javax.swing.JTable tbTransaksi;
    private javax.swing.JPanel topBar;
    private javax.swing.JPanel transaksiPanel;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables
}
