package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.servicos.OmdbClient;
import br.com.alura.screenmatch.servicos.TituloConverter;
import br.com.alura.screenmatch.servicos.TituloListWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();


        while (!busca.equalsIgnoreCase("sair")) {

            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            OmdbClient ombd = new OmdbClient();
            String json = ombd.search(busca);

            titulos.add(TituloConverter.converter(json));


        }
        System.out.println(titulos);

        TituloListWriter.writeToFile(titulos,"filmes");
        System.out.println("O programa finalizou corretamente!");

    }
}