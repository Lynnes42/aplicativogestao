package com.example.projeto1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ChamadoDao {
    @Insert
    void insert(Chamado chamado);

    @Update
    void update(Chamado chamado);

    @Query("SELECT * FROM chamados ORDER BY id DESC")
    List<Chamado> getAllChamados();

    @Query("SELECT * FROM chamados WHERE status = :status ORDER BY id DESC")
    List<Chamado> getChamadosByStatus(String status);

    @Query("SELECT * FROM chamados WHERE id = :id LIMIT 1")
    Chamado getChamadoById(int id);

    @Query("SELECT COUNT(*) FROM chamados WHERE status = 'Aberto'")
    int getOpenChamadosCount();
}
