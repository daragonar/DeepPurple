package purple.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import purple.model.entity.Author;
import purple.model.entity.Book;
import purple.model.entity.Copy;
import purple.model.entity.Shop;
import purple.model.repositories.RepositorieAuthor;
import purple.model.repositories.RepositorieBook;
import purple.model.repositories.RepositorieCopy;
import purple.model.repositories.RepositorieShop;

@Controller
public class ControllerHome {
	
	@Autowired
	private RepositorieAuthor repoAu;
	@Autowired
	private RepositorieCopy repoCo;
	@Autowired
	private RepositorieBook repoBo;
	@Autowired
	private RepositorieShop repoSh;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
		Author pepe= new Author(1, "pepe", "pepito");
		repoAu.save(pepe);
		Book libro1= new Book(1, "El poder del amor", "Esto es ISBN", pepe);
		repoBo.save(libro1);
		libro1= new Book(2, "El poder del amor 2", "Esto es ISBN", pepe);
		repoBo.save(libro1);
		libro1= new Book(3, "El poder del amor 3", "Esto es ISBN", pepe);
		repoBo.save(libro1);
		pepe= new Author(2, "perico", "el de los palotes");
		repoAu.save(pepe);
		libro1= new Book(4, "El poder del amor", "Esto es ISBN", pepe);
		repoBo.save(libro1);
		libro1= new Book(5, "El poder del amor 2", "Esto es ISBN", pepe);
		repoBo.save(libro1);
		libro1= new Book(6, "El poder del amor 3", "Esto es ISBN", pepe);
		repoBo.save(libro1);
		Copy copy1= new Copy(1, Date.from(Instant.now()), libro1);
		repoCo.save(copy1);
		Shop shop1= new Shop(1, "Luis");
		repoSh.save(shop1);
		
		return "index";
    }
}
