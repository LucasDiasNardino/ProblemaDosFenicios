import java.io.*;

public class Leitor {
    public static String[][] criaMatriz(String arquivo){
        //Buffered reader para construir matriz
        int linhas = 0;
        int colunas = 0;
        String[][] matriz = new String[linhas][colunas];
        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
            String tamanhoMatriz = br.readLine();
            String[] tamanho = tamanhoMatriz.split(" ");
            linhas = Integer.parseInt(tamanho[0]);
            colunas = Integer.parseInt(tamanho[1]);

            matriz = new String[linhas][colunas];

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
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return matriz;
    }

    public static void printaMatriz(String[][] matriz){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                System.out.printf("%s ", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
