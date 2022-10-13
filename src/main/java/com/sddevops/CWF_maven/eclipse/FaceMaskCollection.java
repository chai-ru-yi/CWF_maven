package com.sddevops.CWF_maven.eclipse;

import java.util.*;

public class FaceMaskCollection {

	private ArrayList<FaceMask> facemasks = new ArrayList<>();
	private int capacity;

	public FaceMaskCollection() {
		this.capacity = 3;
	}

	public FaceMaskCollection(int capacity) {
		this.capacity = capacity;
	}

	public List<FaceMask> getFaceMasks() {
        return facemasks;
    }
	
	public void addFaceMask(FaceMask facemask) {
    	if(facemasks.size() != capacity) {
    		facemasks.add(facemask);
    	}
    }
	
	public FaceMask findSongsById(String id) {
    	for (FaceMask s : facemasks) { 		      
            if(s.getId().equals(id)) return s;
       }
    	return null;
    }
	
}
