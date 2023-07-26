package com.example.imageapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    String url="https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView = findViewById(R.id.txtview);
        imageView = findViewById(R.id.img1);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ImageApi imageApi = retrofit.create(ImageApi.class);
        Call<List<ImageModel>>call = imageApi.getimagedata();
        call.enqueue(new Callback<List<ImageModel>>() {
            @Override
            public void onResponse(Call<List<ImageModel>> call, Response<List<ImageModel>> response) {
                List<ImageModel> imagedata = response.body();
                Log.e("images", "" + response.body());
                ImageModel imageurl = imagedata.get(0);


//                for (int i = 0; i < imagedata.size(); i++) {
//                    String imageurl = imagedata.get(i).getImageurl();
//                    Log.e("imageurl",""+response.body());
//                    textView.append("id:" + imagedata.get(i).getId() + "\n title:" + imagedata.get(i).getTitle() + "\n");
                    Glide.with(MainActivity.this).load(imageurl.getThumbnailurl()).centerCrop().into(imageView);
//
//
//                }
            }

            @Override
            public void onFailure(Call<List<ImageModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"failed",Toast.LENGTH_SHORT).show();

            }
        });


    }
}