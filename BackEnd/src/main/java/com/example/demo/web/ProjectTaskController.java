package com.example.demo.web;

import com.example.demo.domain.ProjectTask;
import com.example.demo.service.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/board")
    @CrossOrigin
    public class ProjectTaskController {

        @Autowired
        private ProjectTaskService projectTaskService;

        @PostMapping("")
        public ResponseEntity<?> addPTToBoard(@RequestBody ProjectTask projectTask){

        ProjectTask newPT = projectTaskService.saveOrUpdateProjectTask(projectTask);

        return new ResponseEntity<ProjectTask>(newPT, HttpStatus.CREATED);
        }

        /*
        using GetMapping("/all") we can load all records from database
         */
        @GetMapping("/all")
        public Iterable<ProjectTask> getAllPTs(){
            return projectTaskService.findAll();
        }
        /*
        Using GetMapping("/{pt_id)") we can load single record from database
         */
        @GetMapping("/{pt_id}")
        public ResponseEntity<?> getPTById (@PathVariable Long pt_id)
        {
            ProjectTask projectTask = projectTaskService.findById(pt_id);
            return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
        }
        @DeleteMapping("/{pt_id}")
        public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id)
        {
            projectTaskService.delete(pt_id);
            return new ResponseEntity<String>("Project Task Deleted",HttpStatus.OK);
        }
    }

