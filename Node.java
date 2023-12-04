package Hashing;

import java.io.Serializable;

public class Node implements Serializable {
        String key;
        int posicao;
        int status; // 0 se estiver disponível, 1 se estiver ocupado
        int proximo; // -1 se não houver próximo

        public Node() {
            this.key = null;
            this.posicao = -1;
            this.status = 0;
            this.proximo = -1;
        }
    }