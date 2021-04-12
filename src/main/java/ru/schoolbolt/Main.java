package ru.schoolbolt;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public final class Main {
    public static void main(final String[] args) {
        try {
            final URL url = new URL("https://www.cbr-xml-daily.ru/daily_json.js");

            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");

            final Reader reader = new InputStreamReader(connection.getInputStream());

            final JsonData jsonData = new Gson().fromJson(reader, JsonData.class);

            final Map<String, Float> data = new HashMap<>();
            for (final var entry : jsonData.valutes.entrySet()) {
                data.put(entry.getValue().name, entry.getValue().getDiff());
            }

            data.entrySet().stream().sorted(Map.Entry.<String, Float>comparingByValue().reversed()).limit(5).forEach(System.out::println);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
