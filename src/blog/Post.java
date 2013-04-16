package blog;

/**
 * @author Robert
 *
 */
public class Post {
	public int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String title;
	public String content;
	public String leadParagraph;
	public Author author;
	public Category category;
	
	public String getPost(){
		return title + " " + content + " " + leadParagraph + " " + author + " " + category;
	}

	public String getCaption() {
		return title;
	}

	/**
	 * @param caption
	 */
	public void setCaption(String caption) {
		this.title = caption;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLeadParagraph() {
		return leadParagraph;
	}

	public void setLeadParagraph(String leadParagraph) {
		this.leadParagraph = leadParagraph;
	}

	/**
	 * @return
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param author
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Post [caption=" + title + ", content=" + content
				+ ", leadParagraph=" + leadParagraph + ", author=" + author
				+ ", category=" + category + "]";
	}
	
	
}
