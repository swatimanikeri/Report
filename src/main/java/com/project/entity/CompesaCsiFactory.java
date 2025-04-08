package com.project.entity;

import java.util.ArrayList;
import java.util.List;

public class CompesaCsiFactory {
	 public static List<CompesaCsi> getData() {
	        List<CompesaCsi> list = new ArrayList<>();
	        list.add(new CompesaCsi(1, "2025-04-05", "Water Supply", null, null)); // dummy data
	        return list;
	    }
}
