package br.com.alura.screenmatch.servicos;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TituloConverter {


    public static Titulo converter(String json) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        TituloOmdb tituloOmdb = null;
        try{
            tituloOmdb = gson.fromJson(json,TituloOmdb.class);
            System.out.println(tituloOmdb);
        }
        catch (ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMessage());
        }


        return new Titulo(tituloOmdb);

    }
}
