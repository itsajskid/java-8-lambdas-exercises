package com.insightfullogic.java8.exercises.chapter4;

import java.util.List;
import java.util.Optional;

import com.insightfullogic.java8.examples.chapter1.Artist;

public class Artists {

    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            indexException(index);
        }
        
        return Optional.ofNullable(artists.get(index));
    	
    }

    private void indexException(int index) {
        throw new IllegalArgumentException(index + 
                                           " doesn't correspond to an Artist");
    }

    public String getArtistName(int index) {
        try {
            Optional<Artist> artist = getArtist(index);
            
            return artist.get().getName();
        } catch (IllegalArgumentException e) {
            return "unknown";
        }
    }

}
