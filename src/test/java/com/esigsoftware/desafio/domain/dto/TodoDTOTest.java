package com.esigsoftware.desafio.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TodoDTOTest {

    private static final Long IDL = 1L;
    private static final Long ID2L = 2L;
    private static final String DESCRICAO = "Testando Descrição";
    private static final LocalDate LOCALDATE = LocalDate.now();
    private static final Boolean STATUS_FALSE = false;
    private static final Boolean STATUS_TRUE = true;
    private TodoDTO dto1;
    private TodoDTO dto2;

    @BeforeEach
    private void init() {
        dto1 = new TodoDTO();
        dto1.setId(IDL);
        dto1.setDescricao(DESCRICAO);
        dto1.setStatus(STATUS_FALSE);

        dto2 = new TodoDTO();
        dto2.setId(ID2L);
        dto2.setDescricao(DESCRICAO);
        dto2.setStatus(STATUS_TRUE);
    }

    @Test
    public void getId() {
        assertEquals(IDL, dto1.getId());
        assertEquals(ID2L, dto2.getId());
    }

    @Test
    public void getDescricao() {
        assertEquals(DESCRICAO, dto1.getDescricao());
        assertEquals(DESCRICAO, dto2.getDescricao());
    }

    @Test
    public void getStatus() {
        assertEquals(STATUS_FALSE, dto1.getStatus());
        assertEquals(STATUS_TRUE, dto2.getStatus());
    }

    @Test
    public void testEquals() {
        assertNotEquals(dto1.hashCode(), dto2.hashCode());

        dto2.setId(IDL);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }

    @Test
    public void testHashCode() {
        assertNotEquals(dto1.hashCode(), dto2.hashCode());

        dto2.setId(IDL);
        assertEquals(dto1.hashCode(), dto2.hashCode());
    }
}
