package org.example;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/*
 * Дополнительные задания

Дана json-строка (можно сохранить в файл и читать из файла)
[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
 Студент [фамилия] получил [оценка] по предмету [предмет].
Пример вывода:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
 */
public class Students {
    private String lastname;
    private int grade;
    private String subject;

    public static void parsJSON() {
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}, {\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}, {\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        JSONArray jsonArray = new JSONArray(jsonString);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            String lastname = obj.getString("фамилия");
            String grade = obj.getString("оценка");
            String examp = obj.getString("предмет");

            result.append("Студент ").append(lastname)
                    .append(" получил ").append(grade)
                    .append(" по предмету ").append(examp)
                    .append(".\n");
        }

        System.out.println(result.toString());
    }

}
