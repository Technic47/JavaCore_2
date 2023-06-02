package main;

/*1. Построить три класса (базовый и 2 потомка), описывающих некоторых работников с почасовой оплатой (один из потомков) и фиксированной оплатой (второй потомок).
а) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка», для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».
б) Создать на базе абстрактного класса массив сотрудников и заполнить его.
в) ** Реализовать интерфейсы для возможности сортировки массива (обратите ваше внимание на интерфейсы Comparator, Comparable)
г) ** Создать класс, содержащий массив сотрудников, и реализовать возможность вывода данных с использованием foreach.
 */

import main.workers.HourWorker;
import main.workers.MonthWorker;
import main.workers.Worker;
import main.workers.WorkerBook;

import java.util.List;

public class Starter {
    public static void main(String[] args) {
        WorkerBook book = new WorkerBook();
        book.addWorker(new HourWorker("Ivan", 200.0));
        book.addWorker(new HourWorker("Evgeniy", 220.0));
        book.addWorker(new MonthWorker("Serega", 35000.0));
        book.addWorker(new MonthWorker("Kostian", 15000.0));

        //Сортированный лист используя Comparator
        List<Worker> workerSortedList = book.getSortedList();
        workerSortedList.forEach(System.out::println);

        //Вывод содержимого как есть
        System.out.println();
        book.printWorkerSet();

        //Пример Iterator
        System.out.println();
        book.forEach(System.out::println);

        //Результат аналогичный Iterator, но через простое условие.
        System.out.println();
        workerSortedList.forEach(worker -> {
            if (worker.showSalary() < 35000) System.out.println(worker);
        });

        //Результат аналогичный Iterator, но через фильтр.
        System.out.println();
        workerSortedList.stream()
                .filter(worker -> worker.showSalary() < 35000)
                .toList()
                .forEach(System.out::println);
    }
}
