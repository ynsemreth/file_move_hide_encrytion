
package homework;

import javax.swing.*;
import java.io.File;

class DosyaIslem {
    private static File kaynakDizin;
    private static File hedefDizin;

    public static void setKaynakDizin(File dosya) {
        kaynakDizin = dosya;
    }

    public static File getKaynakDizin() {
        return kaynakDizin;
    }

    public static void setHedefizin(File dosya) {
        hedefDizin = dosya;
    }

    public static File getHedefDizin() {
        return hedefDizin;
    }

    // KaynakSec fonksiyonu seçilicek kaynak dosyasındaki tüm dizini seçer içindeki
    // dosyaları seçmesine izin vermez ve dosyayı bulamazsa null değeri döndürür.
    public static void kaynakSec() {
        JFileChooser kaynakFileChooser = new JFileChooser();
        kaynakFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int kaynakResult = kaynakFileChooser.showOpenDialog(null);
        if (kaynakResult == JFileChooser.APPROVE_OPTION) {
            setKaynakDizin(kaynakFileChooser.getSelectedFile());
        } else {
            setKaynakDizin(null);
        }
    }

    // hedefSec fonkiyonu yukardaki gibi kaynakdosyası mantığında çalışan bir
    // fonksiyon
    public static void hedefSec() {
        JFileChooser hedefFileChooser = new JFileChooser();
        hedefFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int hedefResult = hedefFileChooser.showOpenDialog(null);
        if (hedefResult == JFileChooser.APPROVE_OPTION) {
            setHedefizin(hedefFileChooser.getSelectedFile());
        } else {
            setKaynakDizin(null);
        }
    }
}
