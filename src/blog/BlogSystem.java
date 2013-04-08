package blog;

import java.util.ArrayList;
import java.util.List;


public class BlogSystem {
	public List<Post> blogPosts = new ArrayList<Post>();
	public List<Author> authorList = new ArrayList<Author>();
	public List<Category> categoryList = new ArrayList<Category>();
	
	
	
	public void Print(){
		for(int i = 0; i < blogPosts.size();i++) {
		System.out.println(blogPosts.get(i).caption + blogPosts.get(i).content + blogPosts.get(i).author.firstName + " " + blogPosts.get(i).author.lastName);
				}
	}
}
