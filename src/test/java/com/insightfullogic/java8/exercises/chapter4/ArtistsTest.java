package com.insightfullogic.java8.exercises.chapter4;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.examples.chapter1.SampleData;

public class ArtistsTest {

    private final Artists optionalExamples = new Artists(SampleData.getThreeArtists());

    @Test
    public void indexWithinRange() {
        Optional<Artist> artist = optionalExamples.getArtist(0);
        Assert.assertNotNull(artist.get());
    }

    @Test(expected = IllegalArgumentException.class)
    public void indexOutsideRange() {
        optionalExamples.getArtist(4);
    }

    @Test
    public void nameIndexInsideRange() {
        String artist = optionalExamples.getArtistName(0);
        Assert.assertEquals("John Coltrane", artist);
    }

    @Test
    public void nameIndexOutsideRange() {
        String artist = optionalExamples.getArtistName(4);
        Assert.assertEquals("unknown", artist);
    }

}
