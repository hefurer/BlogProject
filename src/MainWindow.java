import java.util.ArrayList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Combo;

import blog.Author;
import blog.BlogSystem;
import blog.Category;
import blog.Post;
//Going south
public class MainWindow {

	protected Shell shell;
	private Text content;
	private Text caption;
	private List list;
	private Text text;
	private Label lblList;
	public static java.util.List<Post> blogPosts = new ArrayList<Post>();
	public static BlogSystem v = new BlogSystem();

	public static java.util.List<Author> authorList = new ArrayList<Author>();
	public static java.util.List<Category> categoryList = new ArrayList<Category>();

	private Text authorFirstName;
	private Text text_2;
	private Text authorLastName;
	private Label lblAuthor;
	private Label lblFirstName;
	private Label lblLastName;
	private Label lblEmail;
	private Combo combo_categories;
	private Text create_category;
	private Button btnCreateAuthor;

	private Text createAuthorFirstName;
	private Text createAuthorLastName;
	private Combo combo;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Author a = new Author();
		a.firstName = "Robert";
		a.lastName = "Andersson";
		
		Author b = new Author();
		b.firstName = "Henrik";
		b.lastName = "Andersson";

		v.authorList.add(a);
		v.authorList.add(b);

		Category c = new Category();
		c.name = "Economics";

		Category d = new Category();
		d.name = "Politics";

		Category l = new Category();
		l.name = "History";

		v.categoryList.add(c);
		v.categoryList.add(d);
		v.categoryList.add(l);

		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(724, 446);
		shell.setText("SWT Application");

		content = new Text(shell, SWT.BORDER);
		content.setBounds(10, 182, 213, 203);

		caption = new Text(shell, SWT.BORDER);
		caption.setBounds(10, 31, 213, 21);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				Post k = new Post();
				k.content = content.getText();
				k.caption = caption.getText();
				k.leadParagraph = text.getText();
				k.author = v.authorList.get(combo.getSelectionIndex());

				v.blogPosts.add(k);
				list.add("" + caption.getText());

			}
		});
		btnNewButton.setBounds(623, 382, 75, 25);
		btnNewButton.setText("New Button");

		list = new List(shell, SWT.BORDER);
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				int i = list.getSelectionIndex();

				content.setText(v.blogPosts.get(i).content);
				caption.setText(v.blogPosts.get(i).caption);
				text.setText(v.blogPosts.get(i).leadParagraph);

				authorFirstName.setText(v.blogPosts.get(i).author.firstName);
				authorLastName.setText(v.blogPosts.get(i).author.lastName);

			}
		});
		list.setBounds(515, 30, 183, 160);

		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 81, 213, 75);

		Label lblCaption = new Label(shell, SWT.NONE);
		lblCaption.setBounds(10, 10, 55, 15);
		lblCaption.setText("Caption");

		Label lblLeadParagraph = new Label(shell, SWT.NONE);
		lblLeadParagraph.setBounds(10, 60, 89, 15);
		lblLeadParagraph.setText("Lead Paragraph");

		Label lblContent = new Label(shell, SWT.NONE);
		lblContent.setBounds(10, 161, 55, 15);
		lblContent.setText("Content");

		lblList = new Label(shell, SWT.NONE);
		lblList.setBounds(515, 9, 55, 15);
		lblList.setText("List");

		authorFirstName = new Text(shell, SWT.BORDER);
		authorFirstName.setBounds(298, 81, 203, 21);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(298, 135, 203, 21);

		authorLastName = new Text(shell, SWT.BORDER);
		authorLastName.setBounds(298, 108, 203, 21);

		lblAuthor = new Label(shell, SWT.NONE);
		lblAuthor.setBounds(229, 60, 55, 15);
		lblAuthor.setText("Author");

		lblFirstName = new Label(shell, SWT.NONE);
		lblFirstName.setBounds(229, 84, 55, 15);
		lblFirstName.setText("First name:");

		lblLastName = new Label(shell, SWT.NONE);
		lblLastName.setBounds(229, 111, 55, 15);
		lblLastName.setText("Last name:");

		lblEmail = new Label(shell, SWT.NONE);
		lblEmail.setBounds(229, 138, 55, 15);
		lblEmail.setText("Email:");

		combo = new Combo(shell, SWT.NONE);
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int i = combo.getSelectionIndex();

				authorFirstName.setText(v.authorList.get(i).firstName);

			}
		});
		combo.setBounds(515, 244, 183, 23);

		for (int i = 0; i < v.authorList.size(); i++) {
			Author author = v.authorList.get(i);
			combo.add(author.firstName + " " + author.lastName);
		}

		Label lblAuthors = new Label(shell, SWT.NONE);
		lblAuthors.setBounds(515, 223, 55, 15);
		lblAuthors.setText("Authors:");

		combo_categories = new Combo(shell, SWT.NONE);
		combo_categories.setBounds(515, 305, 183, 23);

		Label lblCategories = new Label(shell, SWT.NONE);
		lblCategories.setBounds(515, 284, 55, 15);
		lblCategories.setText("Categories");

		Button btnCreateCategory = new Button(shell, SWT.NONE);
		btnCreateCategory.setBounds(298, 360, 110, 25);
		btnCreateCategory.setText("Create Category");

		create_category = new Text(shell, SWT.BORDER);
		create_category.setBounds(298, 319, 125, 21);

		btnCreateAuthor = new Button(shell, SWT.NONE);
		btnCreateAuthor.setBounds(298, 273, 96, 25);
		btnCreateAuthor.setText("Create Author");

		createAuthorFirstName = new Text(shell, SWT.BORDER);

		createAuthorFirstName = new Text(shell, SWT.BORDER);
		createAuthorFirstName.setBounds(299, 217, 76, 21);

		createAuthorLastName = new Text(shell, SWT.BORDER);
		createAuthorLastName.setBounds(299, 246, 76, 21);
		createAuthorLastName.setBounds(297, 244, 126, 21);

		btnCreateAuthor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Author l = new Author();
				l.firstName = createAuthorFirstName.getText();
				l.lastName = createAuthorLastName.getText();

				v.authorList.add(l);
				combo.add(l.firstName + " " + l.lastName);

			}
		});

		btnCreateCategory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Category s = new Category();
				s.name = create_category.getText();
				v.categoryList.add(s);
				combo_categories.add(s.name);
				
			}
		});

		for (int i = 0; i < v.categoryList.size(); i++) {
			Category category = v.categoryList.get(i);
			combo_categories.add(category.name);
		}

	}

	public List getList() {
		return list;
	}

	public Combo getCombo() {
		return combo;
	}
}
