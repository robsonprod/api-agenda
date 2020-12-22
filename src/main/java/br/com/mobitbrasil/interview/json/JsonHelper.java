package br.com.mobitbrasil.interview.json;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonHelper {

    public static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .disableHtmlEscaping()
            .serializeNulls()
            .create();

}
