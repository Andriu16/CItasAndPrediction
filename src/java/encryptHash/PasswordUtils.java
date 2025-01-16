package encryptHash;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtils {

    // Configuración de PBKDF2
    private static final int ITERATIONS = 65536; // Iteraciones (recomendado >= 100,000)
    private static final int KEY_LENGTH = 256;  // Longitud de la clave en bits
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256"; // Algoritmo

    // Generar un hash de contraseña con sal aleatoria
    public static String generatePasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Generar una sal aleatoria
        byte[] salt = generateSalt();
        // Crear el hash de la contraseña
        byte[] hash = hashPassword(password.toCharArray(), salt);

        // Combinar sal y hash en una sola cadena (Base64 para almacenamiento)
        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hash);
    }

    // Verificar una contraseña
    public static boolean verifyPassword(String password, String storedHash) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Dividir sal y hash almacenado
        String[] parts = storedHash.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] hash = Base64.getDecoder().decode(parts[1]);

        // Generar el hash de la contraseña ingresada
        byte[] testHash = hashPassword(password.toCharArray(), salt);

        // Comparar los hashes
        return java.util.Arrays.equals(hash, testHash);
    }

    // Método para generar una sal aleatoria
    private static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // 16 bytes = 128 bits de sal
        random.nextBytes(salt);
        return salt;
    }

    // Método para generar un hash con PBKDF2
    private static byte[] hashPassword(char[] password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        return factory.generateSecret(spec).getEncoded();
    }
}

