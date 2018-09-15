package br.com.leandro.rickandmortyapi.models;

import java.util.List;

public class RickAndMortyCharacter {

    public List<CharacterRM> results;

    public List<CharacterRM> getResults() {
        return results;
    }

    public void setResults(List<CharacterRM> results) {
        this.results = results;
    }
}
