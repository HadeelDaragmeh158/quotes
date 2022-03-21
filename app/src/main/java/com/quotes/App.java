/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.quotes;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;


public class App {

    public static void main(String[] args) throws IOException {
////////////////////////////////////////////////////////////////////////////////////////////////
//                       LAB 08
////////////////////////////////////////////////////////////////////////////////////////////////
        Gson gsonq = new Gson();
        String dataFile1 = readgson("C:\\Users\\Lenovo\\Desktop\\JAVA401\\classcode\\quotes\\app\\src\\main\\resources\\ recentquotes8.json");
        qouteAuthor [] quotAoutherObj = gsonq.fromJson(dataFile1, qouteAuthor[].class);

        int randomElement = randomQoute(quotAoutherObj.length);
        System.out.println(quotAoutherObj[randomElement]);

////////////////////////////////////////////////////////////////////////////////////////////////
//                       LAB 09
////////////////////////////////////////////////////////////////////////////////////////////////

        String gsonDataFile = readgson("C:\\Users\\Lenovo\\Desktop\\JAVA401\\classcode\\quotes\\app\\src\\main\\resources\\recentquotes.json");

        ArrayList authorsAndQouts = qouteGson(gsonDataFile);

            Gson gson = new Gson();
    try {
        URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");

        HttpURLConnection qoutUrl = (HttpURLConnection) url.openConnection();

        qoutUrl.setRequestMethod("GET");

        InputStreamReader dataStram = new InputStreamReader(qoutUrl.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(dataStram);
        String qouteData = bufferedReader.readLine();

        QuotesAPI quotDataObj = gson.fromJson(qouteData, QuotesAPI.class);
        qouteAuthor quotApiCopy = new qouteAuthor(quotDataObj.getQuoteAuthor(),quotDataObj.getQuoteText());

        System.out.println(quotDataObj);

        System.out.println(quotApiCopy);

        String gsonStr =gson.toJson(quotApiCopy);
        authorsAndQouts.add(gsonStr);

    }catch (IOException e){
        System.out.println(authorsAndQouts.get(randomQoute(authorsAndQouts.size())));
        System.out.println(e.getMessage());
    }
            File qoutandAoutherFile = new File("C:\\Users\\Lenovo\\Desktop\\JAVA401\\classcode\\quotes\\app\\src\\main\\resources\\recentquotes.json");
        try (FileWriter qoutandAouthertheFile = new FileWriter(qoutandAoutherFile)) {
            gson.toJson(authorsAndQouts, qoutandAouthertheFile);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

////////////////////////////////////////////////////////////////////////////////////////////////

    public static int randomQoute(int lengthOfQout){
        Random random =new Random();
        int randomQoutNumber=random.nextInt(lengthOfQout);
        return randomQoutNumber;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String readgson(String path) {
        String sumLins = "";
        String newLine = "";
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(path));
            newLine = reader.readLine();


            while (newLine != null) {
                sumLins += newLine + "\n";
                newLine = reader.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return sumLins;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    public static ArrayList qouteGson(String gsonD){
        Gson gson =new Gson ();
        ArrayList qoutandAoutherstr = gson.fromJson(gsonD, ArrayList.class);
        return qoutandAoutherstr;
    }

}

