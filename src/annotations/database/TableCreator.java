package annotations.database;

import java.util.*;
import java.lang.reflect.*;
import java.lang.annotation.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class TableCreator {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Arguments: annotated classes");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No annotation in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {
                String columnName = null;
                Annotation[] ans = field.getDeclaredAnnotations();
                if (ans.length < 1) {
                    continue;
                }
                if (ans[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger)ans[0];
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    columnDefs.add(columnName + " INT" + getConstrains(sInt.constrains()));
                }
                if (ans[0] instanceof SQLString) {
                    SQLString sString = (SQLString)ans[0];
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstrains(sString.constrains()));
                }
                StringBuilder createCommand = new StringBuilder(
                        "CREATE TABLE " + tableName + "("
                );
                for (String columnDef : columnDefs) {
                    createCommand.append("\n      " + columnDef + ",");
                }
                String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
                System.out.println("Table creation SQL for " + className + " is :\n" + tableCreate);
            }
        }
    }
    private static String getConstrains(Constrains con) {
        String constrains = " ";
        if (!con.allowNull()) {
            constrains += " Not Null";
        }
        if (con.primaryKey()) {
            constrains += " Primary Key";
        }
        if (con.unique()) {
            constrains += " Unique";
        }
        return constrains;
    }
}
