package com.esigsoftware.desafio.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoTest {

    private static final Long IDL = 1L;
    private static final Long ID2L = 2L;
    private static final String DESCRICAO = "Testando Descrição";
    private static final LocalDate LOCALDATE = LocalDate.now();
    private static final Boolean STATUS_FALSE = false;
    private static final Boolean STATUS_TRUE = true;
    private Todo entidade1;
    private Todo entidade2;

    @BeforeEach
    private void init() {
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
    }

    @Test
    public void getId() {
        assertEquals(IDL, entidade1.getId());
        assertEquals(ID2L, entidade2.getId());
    }

    @Test
    public void getDescricao() {
        assertEquals(DESCRICAO, entidade1.getDescricao());
        assertEquals(DESCRICAO, entidade2.getDescricao());
    }

    @Test
    public void getDataCriacao() {
        assertEquals(LOCALDATE, entidade1.getDataCriacao());
        assertEquals(LOCALDATE, entidade2.getDataCriacao());
    }

    @Test
    public void getDataConcluido() {
        assertEquals(LOCALDATE, entidade1.getDataConcluido());
        assertEquals(LOCALDATE, entidade2.getDataConcluido());
    }

    @Test
    public void getStatus() {
        assertEquals(STATUS_FALSE, entidade1.getStatus());
        assertEquals(STATUS_TRUE, entidade2.getStatus());
    }

    @Test
    public void testEquals() {
        assertNotEquals(entidade1.hashCode(), entidade2.hashCode());

        entidade2.setId(IDL);
        assertEquals(entidade1.hashCode(), entidade2.hashCode());
    }

    @Test
    public void testHashCode() {
        assertNotEquals(entidade1.hashCode(), entidade2.hashCode());

        entidade2.setId(IDL);
        assertEquals(entidade1.hashCode(), entidade2.hashCode());
    }
}
