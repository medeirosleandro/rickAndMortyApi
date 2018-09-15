package br.com.leandro.rickandmortyapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import br.com.leandro.rickandmortyapi.models.CharacterRM;
import br.com.leandro.rickandmortyapi.models.RickAndMortyCharacter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //Tag usada para verficar a resposta da API no LOGCAT
    private static final String TAG = "LOG" ;

    RecyclerView recyclerView;
    CardView cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recyclerview_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Service.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        final Call <RickAndMortyCharacter> resquestCharacter = service.listAllCharacter();

        resquestCharacter.enqueue(new Callback<RickAndMortyCharacter>() {
            @Override
            public void onResponse(Call<RickAndMortyCharacter> call, Response<RickAndMortyCharacter> response) {

                RickAndMortyCharacter catalogRickMorty = response.body();


                //O FOR abaixo exibe os itens da Resposta da API

                for(CharacterRM c : catalogRickMorty.results) {

                    Log.i(TAG, String.format("Nome: %s ",c.getName()));
                    Log.i(TAG, String.format("ID: %s ",c.getId()));
                    Log.i(TAG, String.format("Especie: %s ",c.getSpecies()));
                    Log.i(TAG, String.format("Criado em : %s ",c.getCreated()));
                    Log.i(TAG, String.format("Genero: %s ",c.getGender()));
                    Log.i(TAG, String.format("Imagem: %s ",c.getImage()));
                    Log.i(TAG, String.format("Origem: %s ",c.getOrigin()));
                    Log.i(TAG, String.format("Episodio: %s ",c.getEpisode()));
                    Log.i(TAG, String.format("Status: %s ",c.getStatus()));
                    Log.i(TAG, String.format("URL: %s ",c.getUrl()));
                    Log.i(TAG, String.format("------------------------------------------"));

                }

            }

            @Override
            public void onFailure(Call<RickAndMortyCharacter> call, Throwable t) {

            }
        });
    }
}
