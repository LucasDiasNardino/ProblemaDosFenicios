import java.io.*;
import java.util.*;

public class Leitor {
    public static List<List<String>> criaMatriz(String arquivo) {
        List<List<String>> matriz = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String tamanhoMatriz = br.readLine();
            String[] tamanho = tamanhoMatriz.split(" ");
            int linhas = Integer.parseInt(tamanho[0]);
            int colunas = Integer.parseInt(tamanho[1]);

            String linha;
            int i = 0;
            while ((linha = br.readLine()) != null && i < linhas) {
                List<String> linhaMatriz = new ArrayList<>();
                for (int j = 0; j < linha.length(); j += 1) {
                    String elemento = linha.substring(j, j + 1);
                    linhaMatriz.add(elemento);
                }
                matriz.add(linhaMatriz);
                i++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return matriz;
    }

    public static String[][] converterParaMatrizDeVetores(List<List<String>> matrizLista) {
        int linhas = matrizLista.size();
        String[][] matrizVetores = new String[linhas][];

        for (int i = 0; i < linhas; i++) {
            List<String> linhaLista = matrizLista.get(i);
            int colunas = linhaLista.size();
            matrizVetores[i] = linhaLista.toArray(new String[colunas]);
        }

        return matrizVetores;
    }

    public static void printaMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.printf("%s ", matriz[i][j]);
            }
            System.out.println();
        }
    }

}
