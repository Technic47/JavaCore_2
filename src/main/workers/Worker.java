package main.workers;

import java.util.Comparator;
import java.util.Objects;

public abstract class Worker implements Comparable<Worker>, Payable {
    protected String name;
    protected double salary;

    public Worker(double salary) {
        this("noname", salary);
    }

    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    //Абстрактный метод по заданию
    abstract double getSalary();

    //доп метод для реализации интерфейса. Нужен public.
    public double showSalary() {
        return this.getSalary();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                " " + this.getName() +
                " has monthly salary = " + this.getSalary();
    }

    public int compareTo(Worker o) {
        return new WorkerComparator().compare(this, o);
    }

    protected static class WorkerComparator implements Comparator<Worker> {

        @Override
        public int compare(Worker o1, Worker o2) {
            return Double.compare(o1.getSalary(), o2.getSalary());
        }
    }
}
