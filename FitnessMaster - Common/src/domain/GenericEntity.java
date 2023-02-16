package domain;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;

public interface GenericEntity extends Serializable{
    default String getTableName() {
        return this.getClass().getSimpleName();
    }
    default HashMap<String, Object> getClassData() {
        HashMap<String, Object> classData = new HashMap<>();
        for (Field f : this.getClass().getDeclaredFields()) {
            try {
                f.setAccessible(true);
                classData.put(f.getName(), f.get(this));
            } catch (IllegalAccessException ex) {
                ex.getMessage();
            }
        }

        return classData;
    }
    HashSet<String> getIdNames();
    default HashMap<String, Object> getIdData(){
         HashSet<String> idNames = getIdNames();
         HashMap<String, Object> idData = new HashMap<>();
         for (String columnName : idNames) {
             try {
                 Field field = this.getClass().getDeclaredField(columnName);
                 field.setAccessible(true);
                 Object value = field.get(this);
                 idData.put(columnName, field.get(this));
             } catch (Exception ex) {
                 ex.getMessage();
             }
         }
         return idValues;
     }
     
    default Set<String> getColumnNames(){
        return getClassData().keySet();
    }
    default Set<Object> getColumnValues(){
        return getClassData().values().stream().collect(Collectors.toSet());
    }
    
     default String getInsertColumnNames(){
          // Used for SQL queries to concatenate string into format:
          // columnAName, columnBName, columnCName

         return String.join(",", getColumnNames());
     }
     default String getInsertColumnValues(){
          // Used for SQL queries to concatenate string into format:
          // columnAValue, columnBValue, columnCValue

          StringBuilder sb = new StringBuilder();
          Set<Object> columnValues = getColumnValues();
          
          Iterator<Object> it = columnValues.iterator();
          while(it.hasNext()){
               Object columnValue = it.next();
               
//               if(columnValue == null){
//                   if(it.hasNext()){
//                       sb.append("null"+ ", ");
//                   } else {
//                       sb.append("null");
//                   }
//                   continue;
//               }

             if (columnValue instanceof String || columnValue.getClass().isEnum() || columnValue instanceof LocalDate) {
                 columnValue = "\"" + columnValue.toString() + "\"";
             }
             if (it.hasNext()) {
                 sb.append(columnValue + ", ");
             } else {
                 sb.append(columnValue);
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
               String stringValue;
               if(columnValue != null){
                   stringValue = columnValue.toString();
                   if (columnValue instanceof String || columnValue.getClass().isEnum() || columnValue instanceof LocalDate) {
                       stringValue = "\"" + stringValue + "\"";
                   }
               } else {
                   stringValue = null;
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