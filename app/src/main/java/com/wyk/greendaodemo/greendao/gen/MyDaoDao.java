package com.wyk.greendaodemo.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import liuhao.baway.com.mybreakpointresume.MyDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MY_DAO".
*/
public class MyDaoDao extends AbstractDao<MyDao, Long> {

    public static final String TABLENAME = "MY_DAO";

    /**
     * Properties of entity MyDao.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property CurrPosition = new Property(1, int.class, "currPosition", false, "CURR_POSITION");
        public final static Property CurrLength = new Property(2, int.class, "currLength", false, "CURR_LENGTH");
    };


    public MyDaoDao(DaoConfig config) {
        super(config);
    }
    
    public MyDaoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MY_DAO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"CURR_POSITION\" INTEGER NOT NULL ," + // 1: currPosition
                "\"CURR_LENGTH\" INTEGER NOT NULL );"); // 2: currLength
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MY_DAO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MyDao entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getCurrPosition());
        stmt.bindLong(3, entity.getCurrLength());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MyDao entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getCurrPosition());
        stmt.bindLong(3, entity.getCurrLength());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public MyDao readEntity(Cursor cursor, int offset) {
        MyDao entity = new MyDao( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // currPosition
            cursor.getInt(offset + 2) // currLength
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MyDao entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCurrPosition(cursor.getInt(offset + 1));
        entity.setCurrLength(cursor.getInt(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(MyDao entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(MyDao entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
