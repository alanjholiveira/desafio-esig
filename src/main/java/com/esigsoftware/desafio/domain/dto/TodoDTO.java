package com.esigsoftware.desafio.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
public class TodoDTO {

    private Long id;
    private String descricao;
    private Boolean status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoDTO todoDTO = (TodoDTO) o;
        return Objects.equals(id, todoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
