package org.mgukitschedule.imsavella;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApiClient {
    public static LocalDate DATE = LocalDate.now();
    public static DateTimeFormatter TARGET_DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static int TOTAL_TIME;
    public static final List<String> DAYS_OF_WEEK = Arrays.asList(
            "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"
    );
    public static final List<String> INPUT_WORDS = Arrays.asList(
            "Завтра", "Вчера", "Послезавтра", "Позавчера"
    );

    public static String getDateRus(LocalDate date) {
        return date.format(TARGET_DATE_FORMAT);
    }

    private static void printSchedule(List<Schedule> schedules, Map<String, List<Schedule>> sortedByDayOfWeek) {
        int maxLengthDiscipline = getMaxLength(schedules, Schedule::getДисциплина);
        int maxLengthPrepod = getMaxLength(schedules, Schedule::getПреподаватель);

        for (Schedule schedule : schedules) {
            try {
                System.out.format("(%-1s) (%-5s - %-5s) (Ауд. %-5s) %-" + maxLengthDiscipline + "s | %-11s %-" + maxLengthPrepod + "s%n",
                        schedule.getНомерЗанятия(),
                        schedule.getНачало(),
                        schedule.getКонец(),
                        schedule.getАудитория().substring(3),
                        schedule.getДисциплина(),
                        schedule.getДолжность(),
                        schedule.getПреподаватель());

            } catch (MissingFormatWidthException e) {
                System.out.println("Ошибка вывода");
            }
        }
    }

    private static int getMaxLength(List<Schedule> schedules, Function<Schedule, String> field) {
        return schedules.stream()
                .map(field)
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату: ");
        String input = scanner.nextLine().trim();
        System.out.print("Вы желаете выполнить настройку? (+ или -): ");

        String inputSettings = scanner.nextLine().trim();
        String[] words = input.split("\\s+");

        boolean isInputSettings = false;
        boolean isDateParsed = false;

        if (inputSettings.equals("+")) {
            isInputSettings = true;
        } else {
            isInputSettings = false;
        }

        if(isInputSettings) {
            boolean inputCompleted = false;
            int attempts = 4;

            while (!inputCompleted && attempts > 0) {
                try {
                    System.out.print("Сколько по времени занимает ваш путь на общественном транспорте до колледжа (укажите число в минутах): ");
                    int timeMinutesGoCollege = scanner.nextInt();
                    System.out.print("Сколько по времени занимает ваш путь до места, где вы садитесь на общественный транспорт: ");
                    int timeMinutesGoTransport = scanner.nextInt();
                    System.out.print("Сколько по времени занимает ваш путь от места высадки, до колледжа: ");
                    int timeMinutesGoCollegeFromTransport = scanner.nextInt();
                    TOTAL_TIME = timeMinutesGoCollege + timeMinutesGoTransport + timeMinutesGoCollegeFromTransport;
                    System.out.print("Общее время в пути: " + TOTAL_TIME + " минут\n");
                    System.out.print("Ваши настройки будут учтены при выводе расписания\n\n");

                    inputCompleted = true;
                } catch (InputMismatchException e) {
                    attempts--;
                    System.out.print("Ошибка, повторите попытку (Осталось попыток: " + attempts + ")\n");
                    scanner.nextLine();
                }
            }
        }

        // Проверяем, является ли ввод датой в формате yyyy-MM-dd
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            DATE = LocalDate.parse(input, formatter);
            isDateParsed = true;
        } catch (DateTimeParseException e) {
            // Если не удалось распарсить, проверяем ключевые слова
            isDateParsed = false;
        }

        if (!isDateParsed) {
            for (String word : words) {
                String filterWord = word.trim();
                if (INPUT_WORDS.contains(filterWord)) {
                    if (filterWord.equalsIgnoreCase("Завтра")) {
                        DATE = LocalDate.now().plusDays(1);
                        break;
                    } else if (filterWord.equalsIgnoreCase("Вчера")) {
                        DATE = LocalDate.now().minusDays(1);
                        break;
                    } else if (filterWord.equalsIgnoreCase("Послезавтра")) {
                        DATE = LocalDate.now().plusDays(2);
                        break;
                    } else if (filterWord.equalsIgnoreCase("Позавчера")) {
                        DATE = LocalDate.now().minusDays(2);
                        break;
                    } else {
                        DATE = LocalDate.now();
                        break;
                    }
                }
            }
        }

            System.out.println("Текущая дата: " + getDateRus(DATE));
            try {
                URL url = new URL("https://dec.mgutm.ru/api/Rasp?idGroup=30409&sdate=" + DATE);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                int responseCode = conn.getResponseCode();
                if (responseCode != 200) {
                    throw new RuntimeException("HttpResponseCode: " + responseCode);
                } else {
                    StringBuilder inline = new StringBuilder();
                    Scanner scannerURL = new Scanner(url.openStream());

                    while (scannerURL.hasNext()) {
                        inline.append(scannerURL.nextLine());
                    }

                    scannerURL.close();

                    ObjectMapper mapper = new ObjectMapper();
                    ApiResponse response = mapper.readValue(inline.toString(), ApiResponse.class);

                    // Получаем массив расписаний
                    List<Schedule> schedules = response.getData().getRasp();

                    // Выводим дисциплины
//                for (Schedule schedule : schedules) {
//                    System.out.println(schedule.getДень_недели());
//                    System.out.println(schedule.getДисциплина());
//                }

                    Map<String, List<Schedule>> groupedByDay = schedules.stream()
                            .collect(Collectors.groupingBy(Schedule::getДень_недели));

                    Map<String, List<Schedule>> sortedByDayOfWeek = new LinkedHashMap<>();
                    for (String day : DAYS_OF_WEEK) {
                        if (groupedByDay.containsKey(day)) {
                            sortedByDayOfWeek.put(day, groupedByDay.get(day));
                        }
                    }

                    for (Map.Entry<String, List<Schedule>> entry : sortedByDayOfWeek.entrySet()) {
                        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
                        String dateString = entry.getValue().get(0).getДата().substring(0, 10);
                        LocalDate date = LocalDate.parse(dateString);

                        if (DATE.isBefore(date) || DATE.equals(date)) {
                            System.out.println("\nДень недели: " + entry.getKey() + " (Количество пар: " + entry.getValue().size() + ")");
                            System.out.println("Дата: " + getDateRus(date));
                            System.out.println("Ехать к: " + entry.getValue().get(0).getНомерЗанятия() + " паре");
                            if (isInputSettings) {
                                LocalTime time = LocalTime.parse(entry.getValue().get(0).getНачало(), formatterTime);
                                LocalTime timeRemaining = time.minusMinutes(TOTAL_TIME);
                                System.out.print("Выйти из дома в: " + timeRemaining + "\n\n");
                            } else System.out.print("\n");

                            printSchedule(entry.getValue(), sortedByDayOfWeek);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }