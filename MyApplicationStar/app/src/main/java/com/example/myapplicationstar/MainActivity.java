package com.example.myapplicationstar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        String nameString = "Андрей, Алексей, Павел, Роман, Михаил";
//        String[] names = nameString.split(", ");
//        for (String name : names) {
//            Log.i("My name", name);
//
//        }
//        String geometry = "Геометри";
//        String metr = geometry.substring(3, 7);
//        Log.i("metr", metr);

        String url = "<div class=\"channelListEntry\">\n" +
                "\t\t\t\t<a href=\"/chrissy_teigen\">\n" +
                "\t\t\t\t\t<div class=\"image\">\n" +
                "\t\t\t\t\t\t<img src=\"http://cdn.posh24.se/images/:profile/13a9f2da7b5eb1e43460acbe7daa0b5a9\" alt=\"Chrissy Teigen\"/>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t \n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"info\">\n" +
                "\t\t\t\t\t\t<div class=\"status-container\">\n" +
                "\t\t\t\t\t\t\t<div class=\"position\">3</div>\n" +
                "\t\t\t\t\t\t\t \n" +
                "\t\t\t\t\t\t\t\t<div class=\"img pos\"></div>\n" +
                "\t\t\t\t\t\t\t\t<div class=\"value\">+23</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"name\">\n" +
                "\t\t\t\t\t\t\tChrissy Teigen\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</a>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"channelListEntry\">\n" +
                "\t\t\t\t<a href=\"/marie_fredriksson\">\n" +
                "\t\t\t\t\t<div class=\"image\">\n" +
                "\t\t\t\t\t\t<img src=\"http://cdn.posh24.se/images/:profile/c/165326\" alt=\"Marie Fredriksson\"/>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t \n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"info\">\n" +
                "\t\t\t\t\t\t<div class=\"status-container\">\n" +
                "\t\t\t\t\t\t\t<div class=\"position\">4</div>\n" +
                "\t\t\t\t\t\t\t \n" +
                "\t\t\t\t\t\t\t\t<div class=\"img neg\"></div>\n" +
                "\t\t\t\t\t\t\t\t<div class=\"value\">-2</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div class=\"name\">\n" +
                "\t\t\t\t\t\t\tMarie Fredriksson\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</a>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"channelListEntry\">\n" +
                "\t\t\t\t<a href=\"/beyonce\">\n" +
                "\t\t\t\t\t<div class=\"image\">\n" +
                "\t\t\t\t\t\t<img src=\"http://cdn.posh24.se/images/:profile/0b17fa7e4e9dbbed7430a38e4750fd21d\" alt=\"Beyonce\"/>\n" +
                "\t\t\t\t\t</div>";
        Pattern patternImage = Pattern.compile("img src=\"(.*?)\" alt");
        Matcher matcherImage = patternImage.matcher(url);
        Pattern patternName = Pattern.compile("alt=\"(.*?)\"/");
        Matcher matcherName = patternName.matcher(url);
        while (matcherImage.find()) {
            Log.i("metr", matcherImage.group(1));
        }
        while (matcherName.find()){
            Log.i("metr",matcherName.group(1));
        }

    }
}
