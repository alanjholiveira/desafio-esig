package com.esigsoftware.desafio.service;

import com.esigsoftware.desafio.domain.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void save(TodoDTO dto) throws Exception;
    List<TodoDTO> list();
    void delete(Long id) throws Exception;
    void changeStatus(Long id, Boolean status) throws Exception;

}
