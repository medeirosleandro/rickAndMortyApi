package br.com.leandro.rickandmortyapi;

import java.util.List;

import br.com.leandro.rickandmortyapi.models.RickAndMortyCharacter;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {

    public static final String BASE_URL = "https://rickandmortyapi.com/api/";

    @GET("character/?page=19")

    Call<RickAndMortyCharacter> listAllCharacter();

}
