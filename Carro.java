package Hashing;
import java.io.Serializable;
public class Carro implements Serializable{
    private String placa;
    private String marca;
    private String cor;
    private String matricula;
    public Carro(String placa,String marca, String cor, String matricula){
        this.cor=cor;
        this.placa=placa;
        this.matricula=matricula;
        this.marca=marca;
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
