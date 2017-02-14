package purple.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import purple.model.entity.Book;
import purple.model.entity.Copy;
import purple.model.propertyEditors.BookPropertyEditors;
import purple.model.repositories.RepositorieBook;
import purple.model.repositories.RepositorieCopy;

@Controller
@RequestMapping("/copies")
public class ControllerCopy {
	@Autowired
	private RepositorieBook repoBo;
	@Autowired
	private RepositorieCopy repoCo;
	@Autowired
	private BookPropertyEditors bookPropEdit;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listCopies(Model model)
	{
		model.addAttribute("copies",repoCo.findAll());
		model.addAttribute("books",repoBo.findAll());
		return "pages/copies";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addCopy(Model model,@Valid @ModelAttribute Copy cop, BindingResult bindingResult)
	{
		repoCo.save(cop);
		model.addAttribute("copies",repoCo.findAll());
		model.addAttribute("books",repoBo.findAll());
		return "pages/copies";
	}	
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Book.class, bookPropEdit);
	}
}
