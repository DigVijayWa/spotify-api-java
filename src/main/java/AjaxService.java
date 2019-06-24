import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

public class AjaxService implements ApiInterface {


  private static final String USER_AGENT = "Mozilla/5.0";

  public static JSONObject callSearch(String query, String accessToken, String tokenType) {
    System.out.print("\n Access Token : " + accessToken + "\n");
    String url = apiSearch + query;
    String response = getAjaxCall(url, accessToken, tokenType);

    JSONObject jsonObject = null;

    try {
      jsonObject = new JSONObject(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return jsonObject;
  }

  public static String getAjaxCall(String url, String accessToken, String tokenType) {
    StringBuffer response = null;
    try {

      URL obj = new URL(url);
      HttpURLConnection con = (HttpURLConnection) obj.openConnection();

      // optional default is GET
      con.setRequestMethod("GET");

      //add request header
      con.setRequestProperty("User-Agent", USER_AGENT);
      con.setRequestProperty("Authorization", tokenType + " " + accessToken);

      int responseCode = con.getResponseCode();
      System.out.println("\nSending 'GET' request to URL : " + url);
      System.out.println("Response Code : " + responseCode);

      BufferedReader in = new BufferedReader(
          new InputStreamReader(con.getInputStream()));
      String inputLine;
      response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    //print result
    //System.out.println(response.toString());
    return response.toString();
  }

  public static String postAjaxCall(String url, String urlParameters, String accessToken,
      String jsonString) {
    StringBuffer response = null;
    try {

      URL obj = new URL(url);
      HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

      //add reuqest header
      con.setRequestMethod("POST");
      con.setRequestProperty("User-Agent", USER_AGENT);
      con.setRequestProperty("Accept", "application/json");

      // Send post request
      con.setDoOutput(true);
      try (OutputStream os = con.getOutputStream()) {
        byte[] input = jsonString.getBytes("utf-8");
        os.write(input, 0, input.length);

        os.close();
        os.flush();
      }

      int responseCode = con.getResponseCode();
      System.out.println("\nSending 'POST' request to URL : " + url);
      System.out.println("Post parameters : " + urlParameters);
      System.out.println("Response Code : " + responseCode);

      BufferedReader in = new BufferedReader(
          new InputStreamReader(con.getInputStream()));
      String inputLine;
      response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    //print result
    //System.out.println(response.toString());

    return response.toString();
  }


}
