package api.endpoints;

// This is to specify all the api urls of the project
//this project is based on this swagger https://petstore.swagger.io/
public class routes {

    //Base url
    public static String base_url= "https://petstore.swagger.io/v2";

    //User Module urls
    public static String createUserURL= base_url+"/user";
    public static String readUserURL= base_url+"/user/{username}";
    public static String updateUserURL= base_url+"/user/{username}";
    public static String deleteUserURL= base_url+"/user/{username}";
}
