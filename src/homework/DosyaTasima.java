package homework;

import java.io.File;
import javax.swing.JOptionPane;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

abstract class DosyaTasima {
    public abstract void dosyaTasi(File kaynakDizin, File hedefDizin);

    static class tumDosyalariTasi extends DosyaTasima {
        @Override
        public void dosyaTasi(File kaynakDizin, File hedefDizin) {
            if (!kaynakDizin.exists()) {
                kaynakDizin.mkdirs();
            }
            if (!hedefDizin.exists()) {
                hedefDizin.mkdirs();
            }

            File[] dosyalar = kaynakDizin.listFiles();
            for (File dosya : dosyalar) {
                try {
                    File hedefDosya = new File(hedefDizin, dosya.getName());
                    Files.move(dosya.toPath(), hedefDosya.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(null, "Dosya başarıyla taşındı: " + dosya.getName());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Dosya başarıyla taşındı: " + dosya.getName());
                }
            }
        }
    }

    static class pdfTasi extends DosyaTasima {
        @Override
        public void dosyaTasi(File kaynakDizin, File hedefDizin) {
            if (!kaynakDizin.exists()) {
                kaynakDizin.mkdirs();
            }
            if (!hedefDizin.exists()) {
                hedefDizin.mkdirs();
            }

            File[] dosyalar = kaynakDizin.listFiles();
            for (File dosya : dosyalar) {
                if (dosya.isFile() && dosya.getName().toLowerCase().endsWith(".pdf")) {
                    try {
                        File hedefDosya = new File(hedefDizin, dosya.getName());
                        Files.move(dosya.toPath(), hedefDosya.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        JOptionPane.showMessageDialog(null, "Dosya başarıyla taşındı: " + dosya.getName());
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Dosyayı taşırken hata oluştu: " + dosya.getName());
                    }
                }
            }
        }
    }

    static class txtTasi extends DosyaTasima {
        @Override
        public void dosyaTasi(File kaynakDizin, File hedefDizin) {

            if (!kaynakDizin.exists()) {
                kaynakDizin.mkdirs();
            }
            if (!hedefDizin.exists()) {
                hedefDizin.mkdirs();
            }

            File[] dosyalar = kaynakDizin.listFiles();
            for (File dosya : dosyalar) {
                if (dosya.isFile() && dosya.getName().toLowerCase().endsWith(".txt")) {
                    try {
                        File hedefDosya = new File(hedefDizin, dosya.getName());
                        Files.move(dosya.toPath(), hedefDosya.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        JOptionPane.showMessageDialog(null, "Dosya başarıyla taşındı: " + dosya.getName());
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Dosyayı taşırken hata oluştu: " + dosya.getName());
                    }
                }
            }
        }
    }

    static class docxTasi extends DosyaTasima {
        @Override
        public void dosyaTasi(File kaynakDizin, File hedefDizin) {
            if (!kaynakDizin.exists()) {
                kaynakDizin.mkdirs();
            }
            if (!hedefDizin.exists()) {
                hedefDizin.mkdirs();
            }

            File[] dosyalar = kaynakDizin.listFiles();
            for (File dosya : dosyalar) {
                if (dosya.isFile() && dosya.getName().toLowerCase().endsWith(".docx")) {
                    try {
                        File hedefDosya = new File(hedefDizin, dosya.getName());
                        Files.move(dosya.toPath(), hedefDosya.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        JOptionPane.showMessageDialog(null, "Dosya başarıyla taşındı: " + dosya.getName());
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Dosyayı taşırken hata oluştu: " + dosya.getName());
                    }
                }
            }
        }
    }
}