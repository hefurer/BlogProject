package blog;

public class Author {
	public int id;
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public String firstName;
	public String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String username;
	public String password;
	public String email;
	public int age;
	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password
				+ ", email=" + email + ", age=" + age + "]";
	}

	
	
}
