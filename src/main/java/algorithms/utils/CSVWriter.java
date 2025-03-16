package algorithms.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import algorithms.services.SortingService;

public class CSVWriter {
    public static void SaveToDefaultCSV(ArrayList<ArrayList<SortingService>> result_arrays, String filename) {
        try(FileWriter defWriter = new FileWriter(filename + "_default.csv")) {
            defWriter.append("Sort Name, Input Data, Operation Amount, Time Elapsed\n");

            for(ArrayList<SortingService> results : result_arrays) {
                for(SortingService result : results) {
                    defWriter.append(result.getSortTittle()).append(",").append(String.valueOf(result.getInputDataAmount())).append(",").append(String.valueOf(result.getOperationAmount())).append(",").append(String.valueOf(result.getTimeElapsed())).append("\n");
                }
            }
            System.out.println("Success write data to : " + filename + "default_.csv");
        } catch(IOException e) {
            System.err.println("Error write to CSV file: " + e.getMessage());
        }
    }

    public static void SaveToCSV(ArrayList<ArrayList<SortingService>> result_arrays, String filename) {
        // Створюємо дві хеш-мапи для збереження кількості операцій та часу виконання для кожного розміру вхідних даних
        Map<Integer, Map<String, Long>> operationMap = new HashMap<>();
        Map<Integer, Map<String, Long>> timeMap = new HashMap<>();

        // Обробляємо всі результати сортувань, розподіляючи їх за розміром вхідних даних
        for(ArrayList<SortingService> results : result_arrays) {
            for(SortingService result : results) {
                String sortName = result.getSortTittle();
                int inputData = result.getInputDataAmount();
                long operations = result.getOperationAmount();
                long timeElapsed = result.getTimeElapsed();

                // Додаємо кількість операцій у відповідну мапу
                operationMap.putIfAbsent(inputData, new HashMap<>());
                operationMap.get(inputData).put(sortName, operations);

                // Додаємо час виконання у відповідну мапу
                timeMap.putIfAbsent(inputData, new HashMap<>());
                timeMap.get(inputData).put(sortName, timeElapsed);
            }
        }

        try (FileWriter writer = new FileWriter(filename + ".csv")) {
            // Записуємо заголовок таблиці у файл
            writer.append("Input Data, Bubble Op, Comb Op, Quick Op, Bubble Time, Comb Time, Quick Time \n");

            // Сортуємо ключі (розміри вхідних даних) для збереження впорядкованого виходу
            ArrayList<Integer> sortedKeys = new ArrayList<>(operationMap.keySet());
            Collections.sort(sortedKeys);

            for(int inputData : sortedKeys) {
                Map<String, Long> ops = operationMap.get(inputData);
                Map<String, Long> times = timeMap.get(inputData);

                writer.append(inputData + "," +
                        ops.getOrDefault("Bubble", 0L) + "," +
                        ops.getOrDefault("Quick", 0L) + "," +
                        ops.getOrDefault("Comb", 0L) + "," +
                        times.getOrDefault("Bubble", 0L) + "," +
                        times.getOrDefault("Quick", 0L) + "," +
                        times.getOrDefault("Comb", 0L) + "\n");
            }

            System.out.println("Success write data to: " + filename + ".csv");
        } catch (IOException e) {
            System.err.println("Error write to CSV file: " + e.getMessage());
        }
    }
}
