

import blog.Author;
import blog.BlogSystem;
import blog.Category;
import blog.Post;


public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Post p = new Post();
		p.title = "A Giant Carsh!!!";
		p.content = "Global investors had to muster the courage to keep calm as news of Cyprus’ proposed partial theft of all bank deposits took Wall Street by surprise, closed the country’s banks and drove the price of gold higher.";
		p.leadParagraph = "Although Cyprus’ government came to its senses and blocked the proposed seizure, the damage has been done.";
		p.author = new Author();
		p.category = new Category();
		p.author.firstName = "Robert";
		p.author.lastName = "Andersson";
		p.category.name = "Politics";
		
		Post r = new Post();
		r.title = "Going South";
		r.content = "En massa text som är blogginläggets innehåll";
		r.leadParagraph = "Ingressen som lockar läsaren.";
		r.author = new Author();
		r.category = new Category();
		r.author.firstName = "Peter";
		r.author.lastName = "Schiff";
		r.category.name = "Economics";
		
		Post w = new Post();
		w.title = "Around the World";
		w.content = "ajlöksdgjlasdföls jasföasldjkfslöakj.";
		w.leadParagraph = "klököldfksdlfk";
		w.author = new Author();
		w.category = new Category();
		w.author.firstName = "David";
		w.author.lastName = "Olsson";
		w.category.name = "Sport";
		
		BlogSystem s = new BlogSystem();
		s.blogPosts.add(r);
		s.blogPosts.add(p);
		s.blogPosts.add(w);
		
		
		s.Print();
	}

}
