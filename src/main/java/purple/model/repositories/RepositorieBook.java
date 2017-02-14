package purple.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import purple.model.entity.Book;

public interface RepositorieBook extends JpaRepository<Book, Long> {

}
