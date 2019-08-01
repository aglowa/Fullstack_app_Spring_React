package com.example.demo.repository;
import com.example.demo.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/* @Repository — to adnotacja, która mówi Spring Data, że ta klasa odpowiada za dostęp do danych
* Zwróć uwagę na fragment extends Repository<Kot, Long> — ten fragment mówi Springowi, że mamy
* do czynienia z repozytorium zarządzanym przez Spring Data.
* */

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask,Long> {


}
