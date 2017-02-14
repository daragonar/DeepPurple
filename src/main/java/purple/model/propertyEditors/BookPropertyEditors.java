package purple.model.propertyEditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import purple.model.entity.Book;
import purple.model.repositories.RepositorieBook;

@Component
public class BookPropertyEditors extends PropertyEditorSupport {
	@Autowired
	private RepositorieBook repoBo;
	
	@Override
	public void setAsText(String text) 
	{
		long idBook = Long.parseLong(text);
		Book book= repoBo.findOne(idBook);
		setValue(book);
	}
}
