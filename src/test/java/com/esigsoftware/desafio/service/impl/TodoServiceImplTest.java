package com.esigsoftware.desafio.service.impl;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.esigsoftware.desafio.domain.dto.TodoDTO;
import com.esigsoftware.desafio.domain.model.Todo;
import com.esigsoftware.desafio.repository.TodoRepository;
import com.esigsoftware.desafio.service.TodoService;
import com.esigsoftware.desafio.service.mapper.TodoMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TodoServiceImplTest {

    @Mock
    private TodoRepository todoRepository;

    @Spy
    private TodoMapper todoMapper = Mappers.getMapper(TodoMapper.class);

    @InjectMocks
    private TodoService todoService = new TodoServiceImpl();

    private static final Long IDL = 1L;
    private static final Long ID2L = 2L;
    private static final String DESCRICAO = "Testando Descrição";
    private static final LocalDate LOCALDATE = LocalDate.now();
    private static final Boolean STATUS_FALSE = false;
    private static final Boolean STATUS_TRUE = true;
    private Todo entidade1;
    private Todo entidade2;
    private TodoDTO dto;
    private List<Todo> todoList;

    @BeforeEach
    public void setUp() {
        entidade1 = new Todo();
        entidade1.setId(IDL);
        entidade1.setDescricao(DESCRICAO);
        entidade1.setDataCriacao(LOCALDATE);
        entidade1.setDataConcluido(LOCALDATE);
        entidade1.setStatus(STATUS_FALSE);

        entidade2 = new Todo();
        entidade2.setId(ID2L);
        entidade2.setDescricao(DESCRICAO);
        entidade2.setDataCriacao(LOCALDATE);
        entidade2.setDataConcluido(LOCALDATE);
        entidade2.setStatus(STATUS_TRUE);

        todoList = new ArrayList<>();
        todoList.addAll(Arrays.asList(entidade1, entidade2));

        dto = new TodoDTO();
        dto.setId(IDL);
        dto.setDescricao(DESCRICAO);
        dto.setStatus(STATUS_FALSE);

//        TodoMapper mapper = Mappers.getMapper(TodoMapper.class);
//        ReflectionTestUtils.setField(todoService, "todoMapper", mapper);

    }
    @AfterEach
    public void before() {
        Mockito.reset(todoRepository);
    }


    @Test
    public void testAddTodo() throws Exception {

        when(todoRepository.save(any(Todo.class))).thenReturn(entidade1);

        when(todoRepository.findById(IDL)).thenReturn(Optional.ofNullable(entidade1));
        todoService.save(dto);
    }

    @Test
    public void testEditTodo() throws Exception {
        when(todoRepository.save(entidade1)).thenReturn(entidade1);
        when(todoRepository.findById(IDL)).thenReturn(Optional.ofNullable(entidade1));
        todoService.save(dto);
    }

    @Test
    public void testChangeStatusTrue() throws Exception {
        when(todoRepository.findById(IDL)).thenReturn(Optional.ofNullable(entidade1));
        Optional<Todo> result = todoRepository.findById(IDL);

        todoService.changeStatus(IDL, STATUS_TRUE);

        assertThat(result.get().getStatus()).isEqualTo(STATUS_TRUE);
    }

    @Test
    public void testChangeStatusFalse() throws Exception {
        when(todoRepository.findById(IDL)).thenReturn(Optional.ofNullable(entidade1));
        Optional<Todo> result = todoRepository.findById(IDL);

        todoService.changeStatus(IDL, STATUS_FALSE);

        assertThat(result.get().getStatus()).isEqualTo(STATUS_FALSE);
    }

    @Test
    public void testListTodo() {
        when(todoRepository.findAll()).thenReturn(todoList);

        List<TodoDTO> resultList = todoService.list();

        assertThat(resultList.size()).isEqualTo(2);
        assertThat(resultList.get(0).getDescricao()).isEqualTo(entidade1.getDescricao());
        assertThat(resultList.get(1).getDescricao()).isEqualTo(entidade2.getDescricao());
    }


}
