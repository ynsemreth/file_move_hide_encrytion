package homework;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;
import javax.swing.JOptionPane;

public abstract class DosyaSifreleme {
    public static void encryptFile(File kaynakYolu, File hedefYolu) {
        try {
            String kaynakDosyaYolu = kaynakYolu.toString();
            String hedefDosyaYolu = hedefYolu.toString();

            // Kullanıcıdan şifre al
            String kullaniciSifresi = JOptionPane.showInputDialog("Şifrenizi girin:");

            // Şifreleme için kullanılacak salt değerini oluştur
            byte[] salt = generateSalt();

            // Şifreleme için anahtar oluştur
            SecretKey anahtar = generateKey(kullaniciSifresi, salt);

            // Şifreleme algoritması ve modu
            String sifreAlgoritmasi = "AES";
            String sifrelemeModu = "AES/ECB/PKCS5Padding";

            // Kaynak dosyayı oku
            FileInputStream kaynakDosyaGirdisi = new FileInputStream(kaynakDosyaYolu);

            // Hedef dosyaya yaz
            FileOutputStream hedefDosyaCikisi = new FileOutputStream(hedefDosyaYolu);

            // Salt değerini salt dosyasına yaz
            FileOutputStream saltDosyaCikisi = new FileOutputStream(hedefDosyaYolu + ".salt");
            saltDosyaCikisi.write(salt);
            saltDosyaCikisi.close();

            // Şifreleme işlemi için şifreleme nesnesi oluştur
            Cipher cipher = Cipher.getInstance(sifrelemeModu);
            cipher.init(Cipher.ENCRYPT_MODE, anahtar);

            // Şifreli dosyaya yaz
            CipherOutputStream cipherOutputStream = new CipherOutputStream(hedefDosyaCikisi, cipher);

            // Kaynak dosyayı şifreli dosyaya kopyala
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = kaynakDosyaGirdisi.read(buffer)) != -1) {
                cipherOutputStream.write(buffer, 0, bytesRead);
            }

            // Kaynak dosya akışını kapat
            kaynakDosyaGirdisi.close();

            // Şifreli dosyayı kapat
            cipherOutputStream.close();

            JOptionPane.showMessageDialog(null, "Dosya başarıyla şifrelendi. ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SecretKey generateKey(String kullaniciSifresi, byte[] salt) {
        try {
            int iterations = 10000;
            int keyLength = 256;
            char[] passwordChars = kullaniciSifresi.toCharArray();

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            PBEKeySpec spec = new PBEKeySpec(passwordChars, salt, iterations, keyLength);
            SecretKey secretKey = factory.generateSecret(spec);

            return new SecretKeySpec(secretKey.getEncoded(), "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] generateSalt() {
        byte[] salt = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);
        return salt;
    }
}
