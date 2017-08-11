package example;

import annotations.database.SQLInteger;

import java.util.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class TableCreator_1 {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: annotated classes");
        }
        for (String strClass : args) {
            Class<?> cl = Class.forName(strClass);
            DBTable_1 dbTable = cl.getAnnotation(DBTable_1.class);
            if (dbTable == null) {
                System.out.println("No DBTable_1 annotation for this class " + strClass);
                continue;
            }
            String dbTableName = dbTable.name();
            if (dbTableName.length() < 1) {
                dbTableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] ans = field.getDeclaredAnnotations();
                if (ans.length < 1) {
                    continue;
                }
                if (ans[0] instanceof SQLInteger_1) {
                    SQLInteger_1 sInt = (SQLInteger_1)ans[0];
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT " + getConstrains(sInt.constrains()));
                }
                if (ans[0] instanceof SQLString_1) {
                    SQLString_1 sString = (SQLString_1)ans[0];
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ") " + getConstrains(sString.constrains()));
                }
                if (ans[0] instanceof SQLBoolean) {
                    SQLBoolean sbl = (SQLBoolean)ans[0];
                    if (sbl.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sbl.name();
                    }
                    columnDefs.add(columnName + " BOOLEAN " + getConstrains(sbl.constrains()));
                }
                if (ans[0] instanceof SQLVarchar) {
                    SQLVarchar svc = (SQLVarchar)ans[0];
                    if (svc.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = svc.name();
                    }
                    columnDefs.add(columnName + "VARCHAR " + getConstrains(svc.constrains()));
                }
                StringBuilder createCommand = new StringBuilder("" +
                        "CREATE TABLE " + dbTableName + "(");
                for (String columnDef : columnDefs) {
                    createCommand.append("\n     " + columnDef + ", ");
                }
                String createTable = createCommand.substring(0,createCommand.length() - 2) + ");";
                System.out.println("Table creation SQL for: " + cl.getName() + createTable + "\n");
            }
        }
    }
    private static String getConstrains(Constrains_1 cons) {
        String constrains = " ";
        if (cons.primaryKey()) {
            constrains += " PRIMARY KEY";
        }
        if (!cons.allowNull()) {
            constrains += " NOT NULL";
        }
        if (cons.unique()) {
            constrains += " UNIQUE";
        }
        return constrains;
    }
}
