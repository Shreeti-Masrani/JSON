package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;

    /*ArrayList<String> name = new ArrayList<> ();
    ArrayList<String> email= new ArrayList<> ();
    ArrayList<String> mobile= new ArrayList<> ();*/

    ArrayList<Integer> id = new ArrayList<> ();
    ArrayList<String> title= new ArrayList<> ();
    ArrayList<String> image= new ArrayList<> ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        viewPager2 = findViewById ( R.id.viewpager );

        //Getting JSON
        try {
            JSONObject jsonObject = new JSONObject (loadAsset());
            JSONObject data = jsonObject.getJSONObject ( "data" );
            JSONArray banner = data.getJSONArray ( "banners" );

            for (int i=0; i<banner.length ();i++){
                JSONObject detail = banner.getJSONObject ( i );
                id.add ( detail.getInt ( "id" ) );
                title.add ( detail.getString ( "title" ) );
                image.add ( detail.getString ( "banner_image" ) );
            }
       /*     JSONArray data = jsonObject.getJSONArray ( "users" );
            for(int i=0; i<data.length ();i++){
                JSONObject detail = data.getJSONObject ( i );
                name.add ( detail.getString ( "name" ) );
                email.add ( detail.getString ( "email" ) );

                JSONObject cont = detail.getJSONObject ( "contact" );
                mobile.add ( cont.getString ( "mobile" ) );
            }*/


        } catch (JSONException e) {
            e.printStackTrace ();
        }

     /*   String text1[]={"1", "2", "3"};
        String text2[]={"hello", "hi", "hru"};
        String text3[]={"DATA", "DATA", "DATA"};

        viewtext = new ArrayList<> ();

        for(int i=0; i<text1.length; i++){
            ViewText viewText1 =new ViewText ( text1[i], text2[i], text3[i] );
            viewtext.add ( viewText1 );
        }*/
        Adapter adapter = new Adapter (id, title, image, MainActivity.this);
        viewPager2.setAdapter ( adapter );


    }

    private String loadAsset() {
        String json;

        try {

            InputStream inputStream = getAssets ().open ( "test.json" );
            int size= inputStream.available ();

            byte[] bytes = new byte[size];
            inputStream.read (bytes);
            inputStream.close ();

            json = new String(bytes, "UTF-8");
        }
        catch (IOException e) {
            e.printStackTrace ();
            return null;
        }
        return json;
    }
}