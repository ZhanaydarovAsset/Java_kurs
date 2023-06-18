//package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.example.Students;

/*
Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder.
Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */
public class Main {
    public static void main(String[] args) {
        String sqlQuery = "select * from students where";
        String filtrParam = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"null\", \"age\":\"45\"}";

        String param = filtrParam.replace("{", "").replace("}", "");

        String [] pairs = param.split(", ");

        Map <String, String> dict = new HashMap<>();

        for (String iPair : pairs) {
            String [] keyValue = iPair.trim().split(":");
            String key = keyValue[0].replace("\"", "").trim();
            String value = keyValue[1].replace("\"", "").trim();
            dict.put(key, value);
        }

        StringBuilder result = new StringBuilder();
        boolean flag = true;

        for (Map.Entry<String, String> elemDict : dict.entrySet() ){
            String key = elemDict.getKey();
            String value = elemDict.getValue();
            if(!value.equals("null")) {
                if (!flag) {
                    result.append(" AND ");
                } else {
                    result.append(" ");
                }

                flag = false;
                result.append(key).append("= '").append(value).append("'");
            }
        }
        sqlQuery += result.toString();
        System.out.println(sqlQuery);
        
        Students.parsJSON();
    }

}