package homework;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;

abstract class DosyaGizleme {
    public static void dosyaGizle(String kaynakKlasorYolu, String hedefKlasorYolu) {
        try {

            // Kaynak dosyanın yolunu ve adını al
            Path kaynakDosya = Path.of(kaynakKlasorYolu);
            String dosyaAdi = kaynakDosya.getFileName().toString();

            // Hedef klasör yolunu ve adını al
            Path hedefKlasor = Path.of(hedefKlasorYolu);

            // Gizlenmiş dosyanın adını oluştur
            String gizliDosyaAdi = "." + dosyaAdi;

            // Dosyayı hedef klasöre taşıyarak gizle
            Path gizliDosya = hedefKlasor.resolve(gizliDosyaAdi);
            Files.move(kaynakDosya, gizliDosya, StandardCopyOption.REPLACE_EXISTING);

            JOptionPane.showMessageDialog(null, "Dosya başarıyla Gizlendi. " );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
