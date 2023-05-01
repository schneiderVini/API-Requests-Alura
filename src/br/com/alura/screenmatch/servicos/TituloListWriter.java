package br.com.alura.screenmatch.servicos;

import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TituloListWriter {
     static Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();


    public static void writeToFile(List<Titulo> titulos, String fileName) {
        FileWriter escrita = null;
        try {
            escrita = new FileWriter(fileName.toString()+".json");
            escrita.write(gson.toJson(titulos));
            escrita.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
