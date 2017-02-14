package purple.model.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@NotEmpty
	private String name;
	
	@NotNull
	@NotEmpty
	private String isbn;
	
	private String description;
	
	private String cover;
	
	@OneToMany
	private Set<Copy> copies;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Author author;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Set<Copy> getCopies() {
		return copies;
	}

	public void setCopies(Set<Copy> copies) {
		this.copies = copies;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((copies == null) ? 0 : copies.hashCode());
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (copies == null) {
			if (other.copies != null)
				return false;
		} else if (!copies.equals(other.copies))
			return false;
		if (cover == null) {
			if (other.cover != null)
				return false;
		} else if (!cover.equals(other.cover))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public Book() {
		super();
	}
	

	public Book(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

	public Book(long id, String name, String isbn) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
	}

	
	public Book(long id, String name, String isbn, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.author = author;
	}

	public Book(long id, String name, String isbn, String description, String cover) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.description = description;
		this.cover = cover;
	}
	
	
	
}
