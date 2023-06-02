package main.workers;

import java.util.*;

public class WorkerBook implements Iterable<Worker> {
    private final Set<Worker> list;

    public WorkerBook() {
        this.list = new HashSet<>();
    }

    public void addWorker(Worker worker) {
        this.list.add(worker);
    }

    public void printWorkerSet() {
        this.list.forEach(item -> System.out.println(item.toString()));
    }

    public List<Worker> getSortedList() {
        return new ArrayList<>(this.list).stream().sorted(new Worker.WorkerComparator()).toList();
    }

    @Override
    public Iterator<Worker> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private List<Worker> list1 = getSortedList();

            @Override
            public boolean hasNext() {
                return index < list1.size() && list1.get(index) != null && list1.get(index).getSalary() < 35000;
            }

            @Override
            public Worker next() {
                return list1.get(index++);
            }
        };
    }
}
