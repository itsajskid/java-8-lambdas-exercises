package com.insightfullogic.java8.exercises.chapter4;

import java.util.stream.Stream;

import com.insightfullogic.java8.examples.chapter1.Artist;

/** A Performance by some musicians - eg an Album or Gig. */
public interface PerformanceFixed {

    public String getName();

    public Stream<Artist> getMusicians();

    public default Stream<Artist> getAllMusicians() {
//        return Exercises.replaceThisWithSolution();

    	return Stream.concat(getMusicians(), 
    			getMusicians().filter(artist -> !artist.isSolo())
    				.flatMap(artist -> artist.getMembers()));    	
    }

}
