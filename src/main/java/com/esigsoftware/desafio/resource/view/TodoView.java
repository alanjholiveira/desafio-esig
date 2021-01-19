package com.esigsoftware.desafio.resource.view;

import com.esigsoftware.desafio.domain.dto.TodoDTO;
import com.esigsoftware.desafio.service.TodoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Scope("session")
@Component("viewTodo")
@RequiredArgsConstructor
@Getter
public class TodoView {

    @Autowired
    TodoService todoService;

    private TodoDTO todoDTO = new TodoDTO();
    private Boolean edit = false;

    public List<TodoDTO> getTodos() {
        return todoService.list();
    }

    public void addTodo() throws Exception {
        if (todoDTO.getDescricao() != "") {
            todoService.save(todoDTO);
            todoDTO = new TodoDTO();
        }

        this.edit = false;
    }

    public void updateTodo(TodoDTO todoDTO) {
        this.todoDTO = todoDTO;
        this.edit = true;
    }

    public void cancelEdit(){
        this.todoDTO = new TodoDTO();
        this.edit = false;
    }

    public void changeStatus(Long id, Boolean status) throws Exception {
        todoService.changeStatus(id, !status);
    }

    public void deleteTodo(Long id) throws Exception {
        todoService.delete(id);
    }

}
