package homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("DOSYA GEZGİNLERİ ");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setBackground(Color.DARK_GRAY);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 10, 5, 10);

        JLabel kaynakLabel = new JLabel("Kaynak Dizin:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        frame.add(kaynakLabel, constraints);
        kaynakLabel.setBackground(Color.YELLOW); // Arka plan rengini ayarla
        kaynakLabel.setForeground(Color.BLACK); // Yazı rengini ayarla
        kaynakLabel.setOpaque(true); // Arka plan rengini görünür yap
        
        JTextField kaynakTextField = new JTextField();
        kaynakTextField.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        frame.add(kaynakTextField, constraints);
        kaynakTextField.setBackground(Color.LIGHT_GRAY);
        
        JButton kaynakButton = new JButton("Seç");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0.0;
        kaynakButton.setBackground(Color.WHITE); // Arka plan rengini ayarla
        kaynakButton.setForeground(Color.BLACK); // Yazı rengini ayarla
        frame.add(kaynakButton, constraints);

        JLabel hedefLabel = new JLabel("Hedef Dizin:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        frame.add(hedefLabel, constraints);
        hedefLabel.setBackground(Color.YELLOW); // Arka plan rengini ayarla
        hedefLabel.setForeground(Color.BLACK); // Yazı rengini ayarla
        hedefLabel.setOpaque(true); // Arka plan rengini görünür yap

        JTextField hedefTextField = new JTextField();
        hedefTextField.setEditable(false);
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1.0;
        frame.add(hedefTextField, constraints);
        hedefTextField.setBackground(Color.LIGHT_GRAY);

        JButton hedefButton = new JButton("Seç");
        constraints.gridx = 2;
        constraints.gridy = 3;
        constraints.fill = GridBagConstraints.NONE;
        constraints.weightx = 0.0;
        hedefButton.setBackground(Color.WHITE); // Arka plan rengini ayarla
        hedefButton.setForeground(Color.BLACK); // Yazı rengini ayarla
        frame.add(hedefButton, constraints);

        JButton tumDosyalariTasiButton = new JButton("Tüm Dosyaları Taşı");
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.0;
        tumDosyalariTasiButton.setBackground(Color.WHITE); // Arka plan rengini ayarla
        tumDosyalariTasiButton.setForeground(Color.BLACK); // Yazı rengini ayarla
        frame.add(tumDosyalariTasiButton, constraints);

        JButton pdfDosyalariniTasiButton = new JButton("pdf Dosyalarını Taşı");
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.0;
        pdfDosyalariniTasiButton.setBackground(Color.WHITE); // Arka plan rengini ayarla
        pdfDosyalariniTasiButton.setForeground(Color.BLACK); // Yazı rengini ayarla
        frame.add(pdfDosyalariniTasiButton, constraints);

        JButton docxDosyalariniTasiButton = new JButton("docx Dosyalarını Taşı");
        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.0;
        docxDosyalariniTasiButton.setBackground(Color.WHITE); // Arka plan rengini ayarla
        docxDosyalariniTasiButton.setForeground(Color.BLACK); // Yazı rengini ayarla
        frame.add(docxDosyalariniTasiButton, constraints);

        JButton txtDosyalariniTasiButton = new JButton("txt Dosyalarını Taşı");
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.0;
        txtDosyalariniTasiButton.setBackground(Color.WHITE); // Arka plan rengini ayarla
        txtDosyalariniTasiButton.setForeground(Color.BLACK); // Yazı rengini ayarla
        frame.add(txtDosyalariniTasiButton, constraints);

        JCheckBox dosyaSifreleBox = new JCheckBox("Dosya Şifrele");
        constraints.gridx = 0;
        constraints.gridy = 4;
        dosyaSifreleBox.setBackground(Color.WHITE);
        dosyaSifreleBox.setForeground(Color.BLACK);

        frame.add(dosyaSifreleBox, constraints);

        JCheckBox dosyaZiplemeBox = new JCheckBox("Dosya Zipleme");
        constraints.gridx = 0;
        constraints.gridy = 5;
        dosyaZiplemeBox.setBackground(Color.WHITE);
        dosyaZiplemeBox.setForeground(Color.BLACK);

        frame.add(dosyaZiplemeBox, constraints);
        
        JCheckBox dosyaGizlemeBox = new JCheckBox("Dosya Gizleme");
        constraints.gridx = 0;
        constraints.gridy = 6;
        dosyaGizlemeBox.setBackground(Color.WHITE);
        dosyaGizlemeBox.setForeground(Color.BLACK);

        frame.add(dosyaGizlemeBox, constraints);

        kaynakButton.addActionListener(new ActionListener() { // kaynak secimi
            @Override
            public void actionPerformed(ActionEvent e) {
                DosyaIslem.kaynakSec();
                if (DosyaIslem.getKaynakDizin() != null) {
                    kaynakTextField.setText(DosyaIslem.getKaynakDizin().getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(frame, "KAYNAK DİZİNİ SEÇİMİ YAPILMADI ! ", "UYARI",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        hedefButton.addActionListener(new ActionListener() { // hedef secimi
            @Override
            public void actionPerformed(ActionEvent e) {
                DosyaIslem.hedefSec();
                if (DosyaIslem.getHedefDizin() != null) {
                    hedefTextField.setText(DosyaIslem.getHedefDizin().getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(frame, "HEDEF DİZİNİ SEÇİMİ YAPILMADI ! ", "UYARI",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // tumDosyalariTasiButton ActionListener'ı içindeki kodu değiştirin
        tumDosyalariTasiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dosyaSifreleBox.isSelected()) {
                    File[] dosyalar = DosyaIslem.getHedefDizin().listFiles();
                    for (File dosya : dosyalar) {
                        if (dosya.isFile()) {
                            File sifreliDosya = new File(DosyaIslem.getHedefDizin(), dosya.getName() + ".encrypted");
                            DosyaSifreleme.encryptFile(dosya, sifreliDosya);
                        }
                    }
                }
                else if (dosyaZiplemeBox.isSelected()) {
                        String kaynakDosyaDizini = DosyaIslem.getKaynakDizin().getPath();
                        String hedefDosyaDizini = DosyaIslem.getHedefDizin().getPath();
                        FileZipper.zipDosyaOlustur(kaynakDosyaDizini, hedefDosyaDizini);
                        
                    }
                else {
                    if(dosyaGizlemeBox.isSelected()){
                        DosyaGizleme.dosyaGizle(DosyaIslem.getKaynakDizin().getPath(), DosyaIslem.getHedefDizin().getPath());
                    }
                    else {
                    DosyaTasima.tumDosyalariTasi tasima = new DosyaTasima.tumDosyalariTasi();
                    tasima.dosyaTasi(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                  }
                }
              }   
        });

        pdfDosyalariniTasiButton.addActionListener(new ActionListener() { // pdf dosyalarini tasima ve sifreleme
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dosyaSifreleBox.isSelected()) {
                    DosyaTasima.pdfTasi tasima = new DosyaTasima.pdfTasi();
                    tasima.dosyaTasi(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                    DosyaSifreleme.encryptFile(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                }else if ( dosyaZiplemeBox.isSelected()){
                    DosyaTasima.pdfTasi tasima = new DosyaTasima.pdfTasi();
                    tasima.dosyaTasi(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                    String kaynakDosyaDizini = DosyaIslem.getKaynakDizin().getPath();
                    String hedefDosyaDizini = DosyaIslem.getHedefDizin().getPath();
                    FileZipper.zipDosyaOlustur(kaynakDosyaDizini, hedefDosyaDizini);
                } 
                else {
                    DosyaTasima.pdfTasi tasima = new DosyaTasima.pdfTasi();
                    tasima.dosyaTasi(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                }
            }
        });

        docxDosyalariniTasiButton.addActionListener(new ActionListener() { // docx dosyalarini tasima ve sifreleme
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dosyaSifreleBox.isSelected()) {
                    DosyaTasima.docxTasi tasima = new DosyaTasima.docxTasi();
                    tasima.dosyaTasi(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                    DosyaSifreleme.encryptFile(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                }else if ( dosyaZiplemeBox.isSelected()){
                    DosyaTasima.docxTasi tasima = new DosyaTasima.docxTasi();
                    tasima.dosyaTasi(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                    String kaynakDosyaDizini = DosyaIslem.getKaynakDizin().getPath();
                    String hedefDosyaDizini = DosyaIslem.getHedefDizin().getPath();
                    FileZipper.zipDosyaOlustur(kaynakDosyaDizini, hedefDosyaDizini);
                }  
                else {
                    DosyaTasima.docxTasi tasima = new DosyaTasima.docxTasi();
                    tasima.dosyaTasi(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                }
            }
        });

        txtDosyalariniTasiButton.addActionListener(new ActionListener() { // txt dosyalari tasima ve sifreleme
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dosyaSifreleBox.isSelected()) {
                    DosyaTasima.txtTasi tasima = new DosyaTasima.txtTasi();
                    tasima.dosyaTasi(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                    DosyaSifreleme.encryptFile(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                } else if ( dosyaZiplemeBox.isSelected()){
                    DosyaTasima.txtTasi tasima = new DosyaTasima.txtTasi();
                    tasima.dosyaTasi(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                    String kaynakDosyaDizini = DosyaIslem.getKaynakDizin().getPath();
                    String hedefDosyaDizini = DosyaIslem.getHedefDizin().getPath();
                    FileZipper.zipDosyaOlustur(kaynakDosyaDizini, hedefDosyaDizini);
                }  
                else {
                    DosyaTasima.txtTasi tasima = new DosyaTasima.txtTasi();
                    tasima.dosyaTasi(DosyaIslem.getKaynakDizin(), DosyaIslem.getHedefDizin());
                }
            }
        });

        frame.setVisible(true);
    }
}
