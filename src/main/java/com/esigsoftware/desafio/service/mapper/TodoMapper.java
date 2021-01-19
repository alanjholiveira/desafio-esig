package com.esigsoftware.desafio.service.mapper;

import com.esigsoftware.desafio.domain.dto.TodoDTO;
import com.esigsoftware.desafio.domain.model.Todo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TodoMapper extends EntityMapper<TodoDTO, Todo> {
}
