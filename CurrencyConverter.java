import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {
    static final String API_KEY = "1ba59aea347e26f4b5ba00b3"; // Your API key
    static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    // Fetch exchange rates from API
    public static double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            URL url = new URL(BASE_URL + fromCurrency);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject json = new JSONObject(response.toString());
            return json.getJSONObject("conversion_rates").getDouble(toCurrency);
        } catch (Exception e) {
            System.out.println("Error fetching exchange rate. Check internet connection or API key.");
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.print("Enter base currency (e.g., USD, EUR, INR): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency (e.g., JPY, GBP, AUD): ");
        String toCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        double rate = getExchangeRate(fromCurrency, toCurrency);

        if (rate != -1) {
            double convertedAmount = amount * rate;
            System.out.printf("%.2f %s = %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } else {
            System.out.println("Conversion failed. Try again later.");
        }

        scanner.close();
    }
}


//javac -cp json-20210307.jar CurrencyConverter.java
//java -cp .;json-20210307.jar CurrencyConverter