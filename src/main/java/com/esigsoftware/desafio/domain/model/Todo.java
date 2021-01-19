package com.esigsoftware.desafio.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_todo")
@Getter
@Setter
@NoArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTodo", nullable = false)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "dataCriacao")
    private LocalDate dataCriacao;

    @Column(name = "dataConcluido")
    private LocalDate dataConcluido;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
