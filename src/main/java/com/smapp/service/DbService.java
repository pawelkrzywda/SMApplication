package com.smapp.service;

import com.smapp.domain.Task;
import com.smapp.exception.TaskNotFoundException;
import com.smapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTask(final Long taskId) throws TaskNotFoundException{
        return taskRepository.findById(taskId).orElseThrow(TaskNotFoundException::new);
    }

    public Task saveTask(final Task task){
        return taskRepository.save(task);
    }

    public void deleteTask(final Long taskId){
        taskRepository.deleteById(taskId);
    }
}
