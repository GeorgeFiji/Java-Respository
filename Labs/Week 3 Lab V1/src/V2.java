import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Student other) {
        // Priority based on GPA in descending order
        return Double.compare(other.gpa, this.gpa);
    }

    @Override
    public String toString() {
        return name + " with GPA: " + gpa;
    }
}

public class V2 {
    public static void main(String[] args) {
        // Create a priority queue for Student using natural ordering
        PriorityQueue<Student> studentQueue = new PriorityQueue<>();

        // Adding some students to the queue
        studentQueue.add(new Student("Alice", 4.5));
        studentQueue.add(new Student("Bob", 4.7));
        studentQueue.add(new Student("Charlie", 4.2));
        studentQueue.add(new Student("Daisy", 4.8));
        studentQueue.add(new Student("Eve", 4.1));
        studentQueue.add(new Student("Frank", 4.9)); // This should not be awarded as it exceeds max recipients

        System.out.println("Awarded Students:");

        // Maximum recipients cannot be more than five
        for (int i = 0; i < 5 && !studentQueue.isEmpty(); i++) {
            Student student = studentQueue.poll();
            if (student.getGpa() > 4.0) {
                System.out.println(student);
            }
        }
    }
}
