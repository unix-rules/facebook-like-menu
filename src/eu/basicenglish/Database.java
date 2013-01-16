package eu.basicenglish;

import java.util.ArrayList;

import eu.basicenglish.model.Category;

public class Database {
	private final static Database sharedInstance = new Database();
	
	static Database sharedInstance() {
		return sharedInstance;
	}
	
	ArrayList<Category> categories() {
		return new ArrayList<Category> ();
	}
}
