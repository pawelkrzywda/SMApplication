package com.smapp.controller;

import com.smapp.counter.RequestCounter;
import com.smapp.domain.Task;
import com.smapp.exception.TaskNotFoundException;
import com.smapp.service.DbService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TaskController {

    private final DbService dbService;
    private final RequestCounter requestCounter;

    @GetMapping("/tasks")
    public ModelAndView getTasks() {
        requestCounter.add();
        ModelAndView mav = new ModelAndView("tasks");
        mav.addObject("tasks", dbService.getAllTasks());
        mav.addObject("counter", requestCounter);
        return mav;
    }

    @GetMapping("/createTaskForm")
    public ModelAndView createTask(){
        requestCounter.add();
        ModelAndView mav = new ModelAndView("createTaskForm");
        Task newTask = new Task();
        mav.addObject("task", newTask);
        return mav;
    }
    @PostMapping("/saveTask")
    public ModelAndView saveTask(@ModelAttribute("task") @Valid Task task, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView("/createTaskForm");
        }
        requestCounter.add();
        dbService.saveTask(task);
        return new ModelAndView("redirect:/tasks");
    }

    @GetMapping("/updateTaskForm")
    public ModelAndView showUpdateForm(@RequestParam Long taskId) {
        requestCounter.add();
        ModelAndView mav = new ModelAndView("updateTaskForm");

        try {
            Task task = dbService.getTask(taskId);
            mav.addObject("task", task);
        } catch (TaskNotFoundException e){
            System.out.println("Task not found");
        }

        return mav;
    }

    @PostMapping("/updateTask")
    public ModelAndView updateTask(@ModelAttribute("task") @Valid Task task, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView("/updateTaskForm");
        }
        requestCounter.add();
        dbService.saveTask(task);
        return new ModelAndView("redirect:/tasks");
    }

    @GetMapping("/deleteTask")
    public ModelAndView deleteTask(@RequestParam Long taskId) {
        requestCounter.add();
        dbService.deleteTask(taskId);
        return new ModelAndView("redirect:/tasks");
    }
}
