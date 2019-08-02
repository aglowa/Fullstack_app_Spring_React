package com.example.demo.service;

import com.example.demo.domain.ProjectTask;
import com.example.demo.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* Service method is used for declaring Java classes as Spring beans which are managed and
used for dependency injection inside a Spring based application.
 */
@Service
public class ProjectTaskService {

    /*
    Taki obiekt używamy jak każdy inny w Springu — dodajemy go jako pole naszej
    klasy (np. kontrolera) i oznaczamy adnotacją @Autowired
     */

    @Autowired
private ProjectTaskRepository projectTaskRepository;


    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask)
    {
        if(projectTask.getStatus()== null || projectTask.getStatus() == "") {
            projectTask.setStatus("TO_DO");
        }
            return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findAll() {
        return  projectTaskRepository.findAll();
    }
}
