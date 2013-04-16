package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB {

	static public Statement dbConnection() {
		Connection con = null;
		Statement st = null;

		String url = "jdbc:mysql://localhost:3306/blog";
		String user = "root";
		String password = "";

		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return st;

	}
	static public Connection dbCon() {
		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/blog";
		String user = "root";
		String password = "";

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;

	}

	static public Post getPost(int id) {
		ResultSet rs = null;
		try {
			rs = dbConnection().executeQuery(
					"SELECT * FROM posts WHERE id =" + id);

			if (rs.next()) {
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setCaption(rs.getString("caption"));
				post.setLeadParagraph(rs.getString("leadParagraph"));
				post.setContent(rs.getString("content"));

				return post;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	static public List<Post> getPosts() {
		
		List<Post> ret = new ArrayList<Post>();

		try {
			ResultSet rs = null;
			rs = dbConnection().executeQuery("SELECT * FROM posts");

			while (rs.next()) {
				Post post = new Post();
				post.setId(rs.getInt("id"));
				post.setCaption(rs.getString("title"));
				post.setLeadParagraph(rs.getString("leadParagraph"));
				post.setContent(rs.getString("title"));

				ret.add(post);

				System.out.println(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
	
	static public Post createPost(String title, String leadParagraph, String content, int categoryId, int authorId) {
		try {
			PreparedStatement stmt = null;

			stmt = dbCon().prepareStatement(
					"INSERT INTO posts (title, leadParagraph, content, category_id, author_id) VALUES(?, ?, ?, ?, ?)");
			
			stmt.setString(1, title);
			stmt.setString(2, leadParagraph);
			stmt.setString(3, content);
			stmt.setInt(4, categoryId);
			stmt.setInt(5, authorId);
			
			stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	static public Author getAuthor(int id) {
		ResultSet rs = null;
		try {
			rs = dbConnection().executeQuery(
					"SELECT * FROM authors WHERE id =" + id);

			if (rs.next()) {
				Author author = new Author();
				author.setId(rs.getInt("id"));
				author.setFirstName(rs.getString("firstName"));
				author.setLastName(rs.getString("lastName"));

				return author;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	static public List<Author> getAuthors() {
		List<Author> ret = new ArrayList<Author>();

		try {
			ResultSet rs = null;
			rs = dbConnection().executeQuery("SELECT * FROM authors");

			while (rs.next()) {
				Author author = new Author();
				author.setId(rs.getInt("id"));
				author.setFirstName(rs.getString("firstName"));
				author.setLastName(rs.getString("lastName"));

				ret.add(author);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	static public Author createAuthor(String firstName, String lastName) {
		try {
			PreparedStatement stmt = null;

			stmt = dbCon().prepareStatement(
					"INSERT INTO authors (firstName, lastName) VALUES(?,?)");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
