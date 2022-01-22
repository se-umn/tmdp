package edu.umn.cs.tmdp;

import java.util.ArrayList;
import java.util.List;

public class MockitoExperimentObject {

    private List<String> container;

    public MockitoExperimentObject(){
        container = new ArrayList<String>();
    }

    public boolean add(String item){
        return container.add(item);
    }

}
