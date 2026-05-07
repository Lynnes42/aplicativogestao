package com.example.projeto1;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ChamadoDao_Impl implements ChamadoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Chamado> __insertionAdapterOfChamado;

  private final EntityDeletionOrUpdateAdapter<Chamado> __updateAdapterOfChamado;

  public ChamadoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfChamado = new EntityInsertionAdapter<Chamado>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `chamados` (`id`,`titulo`,`data`,`descricao`,`local`,`tipo`,`status`,`solucao`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Chamado entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitulo() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitulo());
        }
        if (entity.getData() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getData());
        }
        if (entity.getDescricao() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescricao());
        }
        if (entity.getLocal() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLocal());
        }
        if (entity.getTipo() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getTipo());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getStatus());
        }
        if (entity.getSolucao() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getSolucao());
        }
      }
    };
    this.__updateAdapterOfChamado = new EntityDeletionOrUpdateAdapter<Chamado>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `chamados` SET `id` = ?,`titulo` = ?,`data` = ?,`descricao` = ?,`local` = ?,`tipo` = ?,`status` = ?,`solucao` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Chamado entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitulo() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitulo());
        }
        if (entity.getData() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getData());
        }
        if (entity.getDescricao() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDescricao());
        }
        if (entity.getLocal() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLocal());
        }
        if (entity.getTipo() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getTipo());
        }
        if (entity.getStatus() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getStatus());
        }
        if (entity.getSolucao() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getSolucao());
        }
        statement.bindLong(9, entity.getId());
      }
    };
  }

  @Override
  public void insert(final Chamado chamado) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChamado.insert(chamado);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Chamado chamado) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfChamado.handle(chamado);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Chamado> getAllChamados() {
    final String _sql = "SELECT * FROM chamados ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitulo = CursorUtil.getColumnIndexOrThrow(_cursor, "titulo");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "descricao");
      final int _cursorIndexOfLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "local");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfSolucao = CursorUtil.getColumnIndexOrThrow(_cursor, "solucao");
      final List<Chamado> _result = new ArrayList<Chamado>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Chamado _item;
        final String _tmpTitulo;
        if (_cursor.isNull(_cursorIndexOfTitulo)) {
          _tmpTitulo = null;
        } else {
          _tmpTitulo = _cursor.getString(_cursorIndexOfTitulo);
        }
        final String _tmpData;
        if (_cursor.isNull(_cursorIndexOfData)) {
          _tmpData = null;
        } else {
          _tmpData = _cursor.getString(_cursorIndexOfData);
        }
        final String _tmpDescricao;
        if (_cursor.isNull(_cursorIndexOfDescricao)) {
          _tmpDescricao = null;
        } else {
          _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        }
        final String _tmpLocal;
        if (_cursor.isNull(_cursorIndexOfLocal)) {
          _tmpLocal = null;
        } else {
          _tmpLocal = _cursor.getString(_cursorIndexOfLocal);
        }
        final String _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item = new Chamado(_tmpTitulo,_tmpData,_tmpDescricao,_tmpLocal,_tmpTipo,_tmpStatus);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpSolucao;
        if (_cursor.isNull(_cursorIndexOfSolucao)) {
          _tmpSolucao = null;
        } else {
          _tmpSolucao = _cursor.getString(_cursorIndexOfSolucao);
        }
        _item.setSolucao(_tmpSolucao);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Chamado> getChamadosByStatus(final String status) {
    final String _sql = "SELECT * FROM chamados WHERE status = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitulo = CursorUtil.getColumnIndexOrThrow(_cursor, "titulo");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "descricao");
      final int _cursorIndexOfLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "local");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfSolucao = CursorUtil.getColumnIndexOrThrow(_cursor, "solucao");
      final List<Chamado> _result = new ArrayList<Chamado>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Chamado _item;
        final String _tmpTitulo;
        if (_cursor.isNull(_cursorIndexOfTitulo)) {
          _tmpTitulo = null;
        } else {
          _tmpTitulo = _cursor.getString(_cursorIndexOfTitulo);
        }
        final String _tmpData;
        if (_cursor.isNull(_cursorIndexOfData)) {
          _tmpData = null;
        } else {
          _tmpData = _cursor.getString(_cursorIndexOfData);
        }
        final String _tmpDescricao;
        if (_cursor.isNull(_cursorIndexOfDescricao)) {
          _tmpDescricao = null;
        } else {
          _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        }
        final String _tmpLocal;
        if (_cursor.isNull(_cursorIndexOfLocal)) {
          _tmpLocal = null;
        } else {
          _tmpLocal = _cursor.getString(_cursorIndexOfLocal);
        }
        final String _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _item = new Chamado(_tmpTitulo,_tmpData,_tmpDescricao,_tmpLocal,_tmpTipo,_tmpStatus);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpSolucao;
        if (_cursor.isNull(_cursorIndexOfSolucao)) {
          _tmpSolucao = null;
        } else {
          _tmpSolucao = _cursor.getString(_cursorIndexOfSolucao);
        }
        _item.setSolucao(_tmpSolucao);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Chamado getChamadoById(final int id) {
    final String _sql = "SELECT * FROM chamados WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitulo = CursorUtil.getColumnIndexOrThrow(_cursor, "titulo");
      final int _cursorIndexOfData = CursorUtil.getColumnIndexOrThrow(_cursor, "data");
      final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "descricao");
      final int _cursorIndexOfLocal = CursorUtil.getColumnIndexOrThrow(_cursor, "local");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfSolucao = CursorUtil.getColumnIndexOrThrow(_cursor, "solucao");
      final Chamado _result;
      if (_cursor.moveToFirst()) {
        final String _tmpTitulo;
        if (_cursor.isNull(_cursorIndexOfTitulo)) {
          _tmpTitulo = null;
        } else {
          _tmpTitulo = _cursor.getString(_cursorIndexOfTitulo);
        }
        final String _tmpData;
        if (_cursor.isNull(_cursorIndexOfData)) {
          _tmpData = null;
        } else {
          _tmpData = _cursor.getString(_cursorIndexOfData);
        }
        final String _tmpDescricao;
        if (_cursor.isNull(_cursorIndexOfDescricao)) {
          _tmpDescricao = null;
        } else {
          _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
        }
        final String _tmpLocal;
        if (_cursor.isNull(_cursorIndexOfLocal)) {
          _tmpLocal = null;
        } else {
          _tmpLocal = _cursor.getString(_cursorIndexOfLocal);
        }
        final String _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        }
        final String _tmpStatus;
        if (_cursor.isNull(_cursorIndexOfStatus)) {
          _tmpStatus = null;
        } else {
          _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        }
        _result = new Chamado(_tmpTitulo,_tmpData,_tmpDescricao,_tmpLocal,_tmpTipo,_tmpStatus);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpSolucao;
        if (_cursor.isNull(_cursorIndexOfSolucao)) {
          _tmpSolucao = null;
        } else {
          _tmpSolucao = _cursor.getString(_cursorIndexOfSolucao);
        }
        _result.setSolucao(_tmpSolucao);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getOpenChamadosCount() {
    final String _sql = "SELECT COUNT(*) FROM chamados WHERE status = 'Aberto'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
