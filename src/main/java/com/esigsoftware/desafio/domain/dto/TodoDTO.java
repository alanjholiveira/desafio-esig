package com.esigsoftware.desafio.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TodoDTO {

    private Long id;
    private String descricao;
    private Boolean status;

}
