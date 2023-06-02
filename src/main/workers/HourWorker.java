package main.workers;

import java.util.Iterator;

public class HourWorker extends Worker {
    public HourWorker(String name, double salary) {
        super(name, salary);
    }

    @Override
    double getSalary() {
        return this.salary * 20.8 * 8;
    }
}
