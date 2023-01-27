package domain;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface GenericEntity extends Serializable{
    default String getTableName(){
          return this.getClass().getSimpleName();
    }
    default ArrayList<String>getColumnNames(){
        ArrayList<String> columnNames = new ArrayList();
        for (Field f : this.getClass().getDeclaredFields()) {
            columnNames.add(f.getName());
        }
        return columnNames;
    }
     default ArrayList<Object> getColumnValues(){
         ArrayList<Object> columnValues = new ArrayList<>();
         ArrayList<String> columnNames = getColumnNames();
         for (String columnName : columnNames) {
             try {
                 Field field = this.getClass().getDeclaredField(columnName);
                 field.setAccessible(true);
                 Object value = field.get(this);
                 columnValues.add(value);
             } catch (Exception ex) {
                 ex.getMessage();
             }
         }
         return columnValues;
     }
     ArrayList<String> getIdNames();
     default ArrayList<Object> getIdValues(){
         ArrayList<Object> idValues = new ArrayList<>();
         ArrayList<String> idNames = getIdNames();
         for (String columnName : idNames) {
             try {
                 Field field = this.getClass().getDeclaredField(columnName);
                 field.setAccessible(true);
                 Object value = field.get(this);
                 idValues.add(value);
             } catch (Exception ex) {
                 ex.getMessage();
             }
         }
         return idValues;
     }
     
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
               if(columnValue == null){
                   if(it.hasNext()){
                       sb.append("null"+ ", ");
                   } else {
                       sb.append("null");
                   }
                   continue;
               }
               
               String stringValue = columnValue.toString();
               
               if(columnValue instanceof String || columnValue.getClass().isEnum() || columnValue instanceof LocalDate) {
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
         // Used for SQL queries to concatenate string into format:
         // columnAName = columnAValue, columnAName = columnBValue, columnAName = columnCValue
         
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
         // Used for SQL queries to concatenate string into format:
         // columnAName = columnAValue AND columnAName = columnBValue AND columnAName = columnCValue
         
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