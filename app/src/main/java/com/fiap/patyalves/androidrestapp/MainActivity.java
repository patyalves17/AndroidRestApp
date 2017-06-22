package com.fiap.patyalves.androidrestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fiap.patyalves.androidrestapp.adapter.AndroidAdapter;
import com.fiap.patyalves.androidrestapp.api.APIUtils;
import com.fiap.patyalves.androidrestapp.api.AndroidAPI;
import com.fiap.patyalves.androidrestapp.modelo.Android;
import com.fiap.patyalves.androidrestapp.modelo.ResponseAndroid;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvAndroids;
    private AndroidAdapter androdAdapter;
    private AndroidAPI androidAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvAndroids=(RecyclerView)findViewById(R.id.rvAndroids);

        androdAdapter=new AndroidAdapter(new ArrayList<Android>());

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        rvAndroids.setLayoutManager(layoutManager);
        rvAndroids.setAdapter(androdAdapter);
        rvAndroids.setHasFixedSize(true);
//        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        rvAndroids.addItemDecoration(itemDecoration);

        carregaDados();

    }

    private void carregaDados(){
        androidAPI= APIUtils.getAndroidAPIVersion();
        androidAPI.getVersoes().enqueue(new Callback<ResponseAndroid>() {
            @Override
            public void onResponse(Call<ResponseAndroid> call, Response<ResponseAndroid> response) {
                if(response.isSuccessful()){
                    androdAdapter.update(response.body().getAndroids());
                }
            }

            @Override
            public void onFailure(Call<ResponseAndroid> call, Throwable t) {

            }
        });
    }
}
