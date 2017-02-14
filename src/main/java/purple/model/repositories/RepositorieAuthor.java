package purple.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import purple.model.entity.Author;

public interface RepositorieAuthor extends JpaRepository<Author, Long>{

}
