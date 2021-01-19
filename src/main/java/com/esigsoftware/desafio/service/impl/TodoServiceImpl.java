package com.esigsoftware.desafio.service.impl;

import com.esigsoftware.desafio.domain.dto.TodoDTO;
import com.esigsoftware.desafio.domain.model.Todo;
import com.esigsoftware.desafio.repository.TodoRepository;
import com.esigsoftware.desafio.service.TodoService;
import com.esigsoftware.desafio.service.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    @Autowired TodoRepository todoRepository;
    @Autowired TodoMapper todoMapper;

    @Override
    public void save(TodoDTO dto) throws Exception {
        log.debug("Requisição para salvar Todo : {}", dto);

        try {
            Todo todo = todoMapper.toEntity(dto);
            todo.setStatus(false);
            todo.setDataCriacao(LocalDate.now());
            todoRepository.save(todo);
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<TodoDTO> list() {
        log.debug("Requisição para listar todo");
        List<Todo> listTodo = todoRepository.findAll();

        return todoMapper.toDto(listTodo);
    }

    @Override
    public void delete(Long id) throws Exception {
        log.debug("Requisição para deletar todo ID: {}", id);

        try {
            todoRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void changeStatus(Long id, Boolean status) throws Exception {
        log.debug("Requisição para alterar status Todo ID: {}", id);
        Optional<Todo> result = Optional.ofNullable(todoRepository.findById(id)
                .orElseThrow(() -> new Exception("Registro não encontrado!")));

        if (result.isPresent()) {
            Todo todo = result.get();
            todo.setStatus(status);
            todo.setDataConcluido(status ? LocalDate.now() : null);

            todoRepository.save(todo);
        }

    }
}
