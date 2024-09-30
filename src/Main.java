import java.io.*;

public class Main {
    public static void main(String[] args) {
        String cadea = "Está en casa";
        String ficheiro = "text6.dat";

        // Mensaje de inicio de escritura
        System.out.println("Iniciando o proceso de escritura... crucemos os dedos");
        try (
                // Crear FileOutputStream, BufferedOutputStream y DataOutputStream
                FileOutputStream fileOutputStream = new FileOutputStream(ficheiro);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream)
        ) {
            // Arrays con los tipos de métodos de escritura a usar
            String[] metodosEscritura = {"writeUTF", "writeChars", "writeUTF"};

            for (int i = 0; i < 3; i++) {
                if (metodosEscritura[i].equals("writeUTF")) {
                    System.out.println("writeUTF escribindo: " + cadea);
                    dataOutputStream.writeUTF(cadea);
                } else {
                    System.out.println("writeChars escribindo: " + cadea);
                    dataOutputStream.writeChars(cadea);
                }
                System.out.println("Bytes totais escritos: " + dataOutputStream.size() + " bytes");
            }

            // Mensaje de confirmación
            System.out.println("Escritura completada con éxito!");

        } catch (IOException e) {
            System.out.println("Produciuse un erro durante a escritura: " + e.getMessage());
        }

        // Mensaje de inicio de lectura
        System.out.println("Iniciando o proceso de lectura... crucemos os dedos");
        try (
                // Crear FileInputStream, BufferedInputStream y DataInputStream
                FileInputStream fileInputStream = new FileInputStream(ficheiro);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)
        ) {
            // Verificar cuantos bytes quedan por leer
            System.out.println("Bytes totais por ler = " + dataInputStream.available() + " bytes");

            // Arrays con los tipos de métodos de lectura a usar
            String[] metodosLectura = {"readUTF", "readChar", "readUTF"};

            for (int i = 0; i < 3; i++) {
                if (metodosLectura[i].equals("readUTF")) {
                    String cadeaLida = dataInputStream.readUTF();
                    System.out.println("Lemos a cadea en UTF: " + cadeaLida);
                } else {
                    System.out.print("Lemos a cadea con readChar() en bucle: ");
                    for (int j = 0; j < cadea.length(); j++) {
                        System.out.print(dataInputStream.readChar());
                    }
                    System.out.println();
                }
                System.out.println("Número de bytes por ler: " + dataInputStream.available() + " bytes.");
            }

            // Mensaje de confirmación
            System.out.println("Lectura completada con éxito!");

        } catch (IOException e) {
            System.out.println("Produciuse un erro durante a lectura: " + e.getMessage());
        }
    }
}
