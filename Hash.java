package Hashing;
import java.nio.file.*;
public class Hash extends Exception{
    private int N = 201; // Tamanho da matriz(Coloquei 201 pra compor a zona de sinonimos também)
    private Node[] vetorHash;

    public Hash() {
        vetorHash = new Node[N];
        for (int i = 0; i < N; i++) {
            vetorHash[i] = new Node();
        }
    }

    // Função de hash simples para strings
    public int hashFunction(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = hash+(((int)key.charAt(i)<<i%8));
        }
        return (hash % N);
    }

    public void inserirCarro(Carro carro) {
        String key = carro.getPlaca();
        int hash = hashFunction(key);
        if(busca(key)!=-1){
            throw new RuntimeException("Placa ja existente");
        }
        // Verifica se a posição está disponível
        if (vetorHash[hash].status == 0) {
            vetorHash[hash].key = key;
            vetorHash[hash].posicao = hash;
            vetorHash[hash].status = 1;
            vetorHash[hash].proximo = -1; // Não tem próximo na zona de sinônimos
        } else {
            // Se a posição estiver ocupada encontra a próxima posição na zona de sinônimos
            int posicaoZonaSinonimo = encontrarProximaPosicaoZonaSinonimo(hash);
            vetorHash[ultimaPosicaoHash(hash)].proximo = posicaoZonaSinonimo;
            // Insere na próxima posição disponível na zona de sinônimos
            vetorHash[posicaoZonaSinonimo].key = key;
            vetorHash[posicaoZonaSinonimo].posicao = posicaoZonaSinonimo;
            vetorHash[posicaoZonaSinonimo].status = 1;
            vetorHash[posicaoZonaSinonimo].proximo = -1;
        }
    }
    public int encontrarProximaPosicaoZonaSinonimo(int hash) {
        int posicaoAtual = hash;
        if(vetorHash[posicaoAtual].proximo==-1){
            return N;
        }else{
            while (vetorHash[posicaoAtual].proximo != -1) {
                posicaoAtual = vetorHash[posicaoAtual].proximo;
            }
            while(vetorHash[posicaoAtual].status !=0){
                posicaoAtual++;
            }
            return posicaoAtual;
        }
    }
    public int ultimaPosicaoHash(int posicaoAtual){
        while(vetorHash[posicaoAtual].proximo !=-1){
            if(vetorHash[posicaoAtual].proximo ==-1){
                return posicaoAtual;
            }
        }
        return posicaoAtual;
    }
    public int busca(String placa){
        int posicaoPlaca = hashFunction(placa);
        while(!vetorHash[posicaoPlaca].key.equals(placa)){
           posicaoPlaca = vetorHash[posicaoPlaca].proximo;
           if(posicaoPlaca==-1){
            return -1;
           }
        }
        return posicaoPlaca;
    }
    public void exibirDados(String placa){
         if(busca(placa)==-1){
            throw new RuntimeException("Placa não existe no cadastro");
        }
    }
}