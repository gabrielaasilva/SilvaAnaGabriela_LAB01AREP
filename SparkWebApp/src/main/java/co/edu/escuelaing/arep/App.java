package co.edu.escuelaing.arep;

import static spark.Spark.*;
import spark.Request;
import spark.Response;

public class App {

    public static void main(String[] args) {
        port(getPort());
        init();
        get("/calculate", "application/json", (req, res) -> temperatureConverter(req,res));
    }

    static double temperatureConverter(Request request, Response response){
        String identifier = request.queryParams("degrees");
        System.out.println("identifier"+identifier);
        double ans = ((Double.parseDouble(identifier))*1.8)+32;
        return ans;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
