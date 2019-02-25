package algoritmoaes;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * @author a16alfonsofa
 */
public class AlgoritmoAES {

    public static void main(String[] args) {

        try {

            //Preparando todo para cifrar
            System.out.println("Obteniendo generador de claves con cifrado AES.");

            KeyGenerator keygen = KeyGenerator.getInstance("AES");

            System.out.println("Generando Clave...");

            SecretKey key = keygen.generateKey();

            System.out.println("Obteniendo objeto Cipher con cifrado AES");

            Cipher aesCipher = Cipher.getInstance("AES");

            //-----------------------------------------------
            System.out.println("Configurando Cipher para encriptar");

            aesCipher.init(Cipher.ENCRYPT_MODE, key);

            //-----------------------------------------------
            //Cifrando mensaje
            System.out.println("Preparando mensaje.....");

            String mensaje = "adaada";

            System.out.println("Mensaje Original: " + mensaje);

            System.out.println("Cifrando Mensaje....");

            String mensajeCifrazo = new String(aesCipher.doFinal(mensaje.getBytes()));

            System.out.println("Mensaje Cifrado: " + mensajeCifrazo);

            //-----------------------------------------------
            //DESCifrando mensaje
            System.out.println("Configurando Cipher para descifrar...");

            aesCipher.init(Cipher.DECRYPT_MODE, key);

            //-----------------------------------------------
            System.out.println("Descifrando mensaje...");

            String mensajeDescifrado = new String(aesCipher.doFinal(mensajeCifrazo.getBytes()));

            System.out.println("Mensaje Descifrado: " + mensajeDescifrado);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
