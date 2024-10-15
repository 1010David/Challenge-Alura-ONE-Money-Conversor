package calculos;



import java.util.ArrayList;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorMoneda extends Conversor {

    private static final String API_KEY = "8d3f2392eff5dc09dd69ec60";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    private ArrayList<String> conversiones = new ArrayList<>();  // Aquí usamos un ArrayList
    private ArrayList<Double> tasas = new ArrayList<>();         // Guardamos las tasas en un ArrayList

    public ConversorMoneda() {
        try {
            obtenerTasasDeAPI();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las tasas de conversión: " + e.getMessage());
        }
    }

    // Método para obtener tasas de la API
    private void obtenerTasasDeAPI() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");

            // Añadimos conversiones y tasas al ArrayList
            conversiones.add("USD_TO_COP");
            tasas.add(rates.get("COP").getAsDouble());

            conversiones.add("USD_TO_BRL");
            tasas.add(rates.get("BRL").getAsDouble());

            conversiones.add("USD_TO_ARS");
            tasas.add(rates.get("ARS").getAsDouble());

            conversiones.add("COP_TO_USD");
            tasas.add(1 / rates.get("COP").getAsDouble());

            conversiones.add("BRL_TO_USD");
            tasas.add(1 / rates.get("BRL").getAsDouble());

            conversiones.add("ARS_TO_USD");
            tasas.add(1 / rates.get("ARS").getAsDouble());
        } else {
            throw new Exception("Error al conectar con la API. Código de respuesta: " + responseCode);
        }
    }

    // Método para convertir usando el ArrayList
    @Override
    public double convertir(double valor, int indiceConversion) {
        if (indiceConversion >= 0 && indiceConversion < conversiones.size()) {
            return valor * tasas.get(indiceConversion);
        } else {
            throw new IllegalArgumentException("Índice de conversión no válido");
        }
    }

    // Método para obtener la lista de conversiones disponibles
    public ArrayList<String> getConversiones() {
        return conversiones;
    }
}
