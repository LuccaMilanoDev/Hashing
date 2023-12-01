package Hashing;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ArquivoBinario {
    private ObjectInputStream input;
    private ObjectOutputStream output;
    
    public void openToWrite (String nomeArq) {
        try {
            File arq = new File(nomeArq);
            FileOutputStream fileOut = new FileOutputStream(arq);
            output = new ObjectOutputStream(fileOut);
            System.out.println("Arquivo criado");
        }
        catch (IOException ioException){
            System.err.println("Erro ao tentar criar o arquivo para gravação");
            System.exit(1);
        }
    }
    
    public boolean openToRead (String nomeArq) {
        try {
             File arq = new File(nomeArq);
             if (arq.exists() == false) {
                return false;
            } else {
                FileInputStream fileIn = new FileInputStream(arq);
                input = new ObjectInputStream(fileIn);
                return true;
            }
        }
        catch (IOException ioException){
            System.err.println("Erro ao tentar abrir o arquivo para leitura");
            return false;
        }
    }
    
    public void closeWriteFile() {
        try {
            if (output != null) {
                output.flush();
                output.close();
                output = null;
                System.out.println("Arquivo fechado após gravação");
             }
        }
        catch (IOException ioException){
            System.err.println("Erro ao tentar fechar o arquivo após gravação");
            System.exit(1);
        } 
    }
    
    public void closeReadFile() {
        try {
            if (input != null) {
                input.close();
                input = null;
                System.out.println("Arquivo fechado após leitura");
             }
        }
        catch (IOException ioException){
            System.err.println("Erro ao tentar fechar o arquivo após leitura");
            System.exit(1);
        } 
    }
    
    public void gravarDados (Carro al) {
        try {
             output.writeObject (al);
        }
        catch (IOException ioException){
            System.err.println("Erro de gravação");
            System.exit(1);
        }
    }
}
