package com.hattrick.nrapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gastonkosut on 4/5/16.
 */
public class CollectionPeople {


    private int count;
    private List<People> results = new ArrayList<People>();

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public List<People> getResults() {
        return results;
    }

    public void setResults(List<People> results) {
        this.results = results;
    }
}