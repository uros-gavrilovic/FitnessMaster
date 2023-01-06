package domain;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface GenericEntity extends Serializable{
     String getTableName();
     ArrayList<String>getColumnNames();
     ArrayList<Object> getColumnValues();
     
     default String getColumnNamesForInsert(){
          StringBuilder sb = new StringBuilder();
          ArrayList<String> columnNames = getColumnNames();
          
          Iterator<String> it = columnNames.iterator();
          while(it.hasNext()){
               String columnName = it.next();
               if(it.hasNext()){
                    sb.append(columnName + ", ");
               } else {
                    sb.append(columnName);
               }
          }
          
          return sb.toString();
     }
     default String getColumnValuesForInsert(){
          StringBuilder sb = new StringBuilder();
          ArrayList<Object> columnValues = getColumnValues();
          
          Iterator<Object> it = columnValues.iterator();
          while(it.hasNext()){
               Object columnValue = it.next();
               String stringValue = columnValue.toString();
               
               if(columnValue instanceof String || columnValue.getClass().isEnum()) {
                    stringValue = "\"" + stringValue+ "\"";
               }
               
               if(it.hasNext()){
                    sb.append(stringValue + ", ");
               } else {
                    sb.append(stringValue);
               }
          }
          
          return sb.toString();
     }
     
     void setId(int id);
}
