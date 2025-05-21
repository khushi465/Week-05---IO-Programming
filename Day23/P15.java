import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class P15 {
    private static final String KEY = "1234567890123456"; // 16-byte key

    public static void main(String[] args) {
        String inputFile = "sensitive_data.csv";
        String outputFile = "encrypted_data.csv";

        try {
            // Encryption
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            String line;
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);

            while ((line = br.readLine()) != null) {
                byte[] encrypted = cipher.doFinal(line.getBytes());
                bw.write(new String(encrypted));
                bw.newLine();
            }
            br.close();
            bw.close();

            // Decryption
            BufferedReader encryptedReader = new BufferedReader(new FileReader(outputFile));
            BufferedWriter decryptedWriter = new BufferedWriter(new FileWriter("decrypted_data.csv"));
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

            while ((line = encryptedReader.readLine()) != null) {
                byte[] decrypted = cipher.doFinal(line.getBytes());
                decryptedWriter.write(new String(decrypted));
                decryptedWriter.newLine();
            }
            encryptedReader.close();
            decryptedWriter.close();

            System.out.println("Data encrypted and decrypted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}