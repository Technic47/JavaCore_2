package main.workers;

public class MonthWorker extends Worker {
    public MonthWorker(String name, double salary) {
        super(name, salary);
    }

    @Override
    double getSalary() {
        return this.salary;
    }
}
