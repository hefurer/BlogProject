package blog;

import java.util.ArrayList;
import java.util.List;


public class BlogSystem {
	public List<Post> blogPosts = new ArrayList<Post>();
	public List<Author> authorList = new ArrayList<Author>();
	public List<Category> categoryList = new ArrayList<Category>();
	
	public Author getAuthorById( int id ) {
		for( Author author : authorList ) {
			if ( author.getId() == id) {
		        return author;
		    }
		}
	    	return null;
		} 
	
	public Category getCategoryById( int id ) {
		for( Category category: categoryList ) {
			if ( category.getId() == id) {
		        return category;
		    }
		}
	    	return null;
		} 
	
}
