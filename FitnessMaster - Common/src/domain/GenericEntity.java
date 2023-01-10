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
     ArrayList<String> getIdNames();
     ArrayList<Object> getIdValues();
     
     default String getInsertColumnNames(){
          // Used for SQL queries to concatenate string into format:
          // columnAName, columnBName, columnCName
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
     default String getInsertColumnValues(){
          // Used for SQL queries to concatenate string into format:
          // columnAValue, columnBValue, columnCValue
          
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
     
     default String getUpdateSet(){
          ArrayList<String> columnNames = getColumnNames();
          ArrayList<Object> columnValues = getColumnValues();
          StringBuilder sb = new StringBuilder();
          
          Iterator<String> itNames = columnNames.iterator();
          Iterator<Object> itValues = columnValues.iterator();
          
          while(itNames.hasNext()){
               String columnName = itNames.next();
               
               Object columnValue = itValues.next();
               String stringValue = columnValue.toString();
               if (columnValue instanceof String || columnValue.getClass().isEnum()) {
                    stringValue = "\"" + stringValue + "\"";
               }

               if(itNames.hasNext()){
                    sb.append(String.format("%s = %s, ", columnName, stringValue));
               } else {
                    sb.append(String.format("%s = %s", columnName, stringValue));
               }
          }
          
          return sb.toString();
     }
     default String getUpdateWhere(){
          ArrayList<String> columnNames = getIdNames();
          ArrayList<Object> columnValues = getIdValues();
          StringBuilder sb = new StringBuilder();
          
          Iterator<String> itNames = columnNames.iterator();
          Iterator<Object> itValues = columnValues.iterator();
          
          while(itNames.hasNext()){
               String columnName = itNames.next();
               
               Object columnValue = itValues.next();
               String stringValue = columnValue.toString();
               if (columnValue instanceof String || columnValue.getClass().isEnum()) {
                    stringValue = "\"" + stringValue + "\"";
               }

               if(itNames.hasNext()){
                    sb.append(String.format("%s = %s AND ", columnName, stringValue));
               } else {
                    sb.append(String.format("%s = %s", columnName, stringValue));
               }
          }
          
          return sb.toString();
     } // naci bolji naziv za metodu
      
     void setId(int id);
}