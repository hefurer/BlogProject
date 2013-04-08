package blog;

import java.util.Date;

public class Comment {
	public String content;
	public String writer;
	public Date date;
	public String email;
	
	public String getComment(){
		return content + " " + writer + " " + date + " " + email;
		
	}
}
