package Scheduling.src;

public interface ProcessQueue {

    void add(Process process);

    Process get();

    boolean isEmpty();
}
