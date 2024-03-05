package com.example.login;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
public class daoProveedor {
    Context c;
    SQLiteDatabase sql;
    String bd = "BDUsuarios";
    String tablaProveedores = "proveedores";

    public daoProveedor(Context c) {
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        crearTablaProveedores();
    }

    private void crearTablaProveedores() {
        String tabla = "CREATE TABLE IF NOT EXISTS " + tablaProveedores +
                "(id_usuario INTEGER, " +
                "rubro TEXT, " +
                "proyecto TEXT, " +
                "cantidad INTEGER, " +
                "producto TEXT, " +
                "FOREIGN KEY(id_usuario) REFERENCES usuario(id))";
        sql.execSQL(tabla);
    }

    public boolean insertProveedor(Proveedor proveedor) {
        ContentValues cv = new ContentValues();
        cv.put("id_usuario", proveedor.getIdUsuario());
        cv.put("rubro", proveedor.getRubro());
        cv.put("proyecto", proveedor.getProyecto());
        cv.put("cantidad", proveedor.getCantidad());
        cv.put("producto", proveedor.getProducto());

        return (sql.insert(tablaProveedores, null, cv) > 0);
    }


    public ArrayList<Proveedor> selectProveedores(int idUsuario) {
        ArrayList<Proveedor> listaProveedores = new ArrayList<>();
        Cursor cx = sql.rawQuery("SELECT * FROM " + tablaProveedores + " WHERE id_usuario=?", new String[]{String.valueOf(idUsuario)});

        if (cx != null && cx.moveToFirst()) {
            do {
                Proveedor p = new Proveedor(
                        cx.getInt(0),
                        cx.getString(1),
                        cx.getString(2),
                        cx.getInt(3),
                        cx.getString(4)
                );
                listaProveedores.add(p);
            } while (cx.moveToNext());

        }

        return listaProveedores;
    }

    public boolean updateProveedor(Proveedor proveedor) {
        ContentValues cv = new ContentValues();
        cv.put("rubro", proveedor.getRubro());
        cv.put("proyecto", proveedor.getProyecto());
        cv.put("cantidad", proveedor.getCantidad());
        cv.put("producto", proveedor.getProducto());

        return (sql.update(tablaProveedores, cv, "id_usuario=?", new String[]{String.valueOf(proveedor.getIdUsuario())}) > 0);
    }

    public boolean deleteProveedor(int idUsuario) {
        return (sql.delete(tablaProveedores, "id_usuario=?", new String[]{String.valueOf(idUsuario)}) > 0);
    }
}

