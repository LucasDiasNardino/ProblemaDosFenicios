import java.util.*;
import java.io.*;
public class Aplicacao {
/**
 * PROBLEMAS
 * 
 * - construir o grafo a partir do arquivo
 * 
 */
    public static void main(String[] args) {
        /**
         * 1 - transformar entrada em matriz
         * 2 - construir grafo a partir da matriz
         *   
         *   .  .   .   x   1   .
         *   x  .   x   x   x   .
         *   .  .   x   .   .   .
         *   .  .   .   2   x   x
         *  
         *   - Nodo(nodo a, nodo b, boolean caminhavel)
         *   - Nodo0 = new Nodo(matriz[0][0], matriz[0][1], true)
         *   - Nodo1 = new Nodo(matriz[1][0], matriz[0][0], false)
         *   - blablabla
         * 
         *   - problema: como automatizar ligações entre nodos, sabendo que só pode esq dir cim bai?
         *   - operar a matriz para olhar os 4 possíveis vizinhos, e ligar nos existentes.
         */

         //Buffered reader para construir matriz
        try(BufferedReader br = new BufferedReader(new FileReader( "matrizTeste.txt"))){
            String tamanhoMatriz = br.readLine();
            String[] tamanho = tamanhoMatriz.split(" ");
            int linhas = Integer.parseInt(tamanho[0]);
            int colunas = Integer.parseInt(tamanho[1]);


            String[][] matriz = new String[linhas][colunas];

            //preenche a matriz
            String linha;
            int i = 0;

            while((linha = br.readLine()) != null && i < linhas){
                String[] valores = linha.split("  ");
                for(int j = 0; j < colunas; j++){
                    matriz[i][j] = valores[j];
                }
                i++;
            }
            for (String[] linhaMatriz : matriz) {
                for (String valor : linhaMatriz) {
                    System.out.print(valor + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}