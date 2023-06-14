package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;

public class FileZipper {
    public static void zipDosyaOlustur(String kaynakKlasorYolu, String hedefKlasorYolu) {
        try {
            File kaynakKlasor = new File(kaynakKlasorYolu);
            File hedefKlasor = new File(hedefKlasorYolu);

            // Hedef klasörü oluştur (varsa zaten kullanılır)
            hedefKlasor.mkdirs();

            // Dosyayı zipleyerek hedef klasöre kopyala
            zipDosyayiKopyala(kaynakKlasor, hedefKlasor);

            JOptionPane.showMessageDialog(null, "Dosya başarıyla Zip'lendi. " );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void zipDosyayiKopyala(File kaynakKlasor, File hedefKlasor) throws IOException {
        String hedefDosyaAdi = kaynakKlasor.getName() + ".zip";
        File hedefDosya = new File(hedefKlasor, hedefDosyaAdi);

        FileOutputStream fos = new FileOutputStream(hedefDosya);
        ZipOutputStream zos = new ZipOutputStream(fos);

        zipDosyayiEkle(kaynakKlasor, kaynakKlasor.getName(), zos);

        zos.close();
        fos.close();
    }

    public static void zipDosyayiEkle(File dosya, String parentDizin, ZipOutputStream zos) throws IOException {
        if (dosya.isDirectory()) {
            for (File altDosya : dosya.listFiles()) {
                zipDosyayiEkle(altDosya, parentDizin + "/" + dosya.getName(), zos);
            }
        } else {
            FileInputStream fis = new FileInputStream(dosya);

            String entryName = parentDizin + "/" + dosya.getName();

            ZipEntry zipEntry = new ZipEntry(entryName);
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();
            fis.close();
        }
    }
}

