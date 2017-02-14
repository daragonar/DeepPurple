package purple.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Copy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date printdate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Book book;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Shop shop;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getPrintdate() {
		return printdate;
	}

	public void setPrintdate(Date printdate) {
		this.printdate = printdate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((printdate == null) ? 0 : printdate.hashCode());
		result = prime * result + ((shop == null) ? 0 : shop.hashCode());
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
		Copy other = (Copy) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (id != other.id)
			return false;
		if (printdate == null) {
			if (other.printdate != null)
				return false;
		} else if (!printdate.equals(other.printdate))
			return false;
		if (shop == null) {
			if (other.shop != null)
				return false;
		} else if (!shop.equals(other.shop))
			return false;
		return true;
	}

	public Copy() {
		super();
	}

	public Copy(long id, Date printdate) {
		super();
		this.id = id;
		this.printdate = printdate;
	}

	public Copy(long id, Date printdate, Book book) {
		super();
		this.id = id;
		this.printdate = printdate;
		this.book = book;
	}

	public Copy(long id, Date printdate, Book book, Shop shop) {
		super();
		this.id = id;
		this.printdate = printdate;
		this.book = book;
		this.shop = shop;
	}
	
}
