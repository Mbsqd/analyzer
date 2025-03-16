package algorithms.lb2;

import algorithms.services.ExperimentService;

public class Main {
    public static void main(String[] args) {
        // mvn clean package
        // java -jar ./target/analyzer-1.0-SNAPSHOT.jar 0 1000 0 1000 100 5

        System.out.println("Please enter parameters: min, max, start, end, step, sampling");
        int min, max, start, end, step, sampling;   // ініцілізація змінних
        ExperimentService service;

        if(args.length == 6) {
            System.out.println("Start program with parametrs: min:" + args[0]
                                                        + ", max: " + args[1]
                                                        + ", start: " + args[2]
                                                        + ", end: " + args[3]
                                                        + ", step: " + args[4]
                                                        + ", sampling: " + args[5]);

            try {   // пробуємо розпарсити вхідні дані
                min = Integer.parseInt(args[0]);
                max = Integer.parseInt(args[1]);
                start = Integer.parseInt(args[2]);
                end = Integer.parseInt(args[3]);
                step = Integer.parseInt(args[4]);
                sampling = Integer.parseInt(args[5]);
            } catch(NumberFormatException e) {
                System.out.println("Failed parse arguments: " + e.getMessage());
                return;
            }

            try {   // створюємо об'єкт класу для проведення експерименту
                service = new ExperimentService(min, max, start, end, step, sampling);
            } catch(IllegalArgumentException e) {
                System.out.println("Failed init experiment service: " + e.getMessage());
                return;
            }

            service.Start();    // запускаемо експеримент
        } else {
            System.out.println("No parameters received.");
        }
    }
}
