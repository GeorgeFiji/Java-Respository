import java.util.LinkedList;
import java.util.Queue;

// Caller class
class Caller {
    private String callerID;
    private long callTime;

    public Caller(String callerID, long callTime) {
        this.callerID = callerID;
        this.callTime = callTime;
    }

    public String getCallerID() {
        return callerID;
    }

    public long getCallTime() {
        return callTime;
    }
}

// CallQueue class
class CallQueue {
    private Queue<Caller> queue;

    public CallQueue() {
        queue = new LinkedList<>();
    }

    public void addCaller(Caller caller) {
        queue.add(caller);
    }

    public Caller getNextCaller() {
        return queue.poll();
    }

    public int getQueueLength() {
        return queue.size();
    }
}

// Consultant class
class Consultant {
    private String consultantID;

    public Consultant(String consultantID) {
        this.consultantID = consultantID;
    }

    public void attendCall(CallQueue callQueue) {
        Caller caller = callQueue.getNextCaller();
        if (caller != null) {
            System.out.println("Consultant " + consultantID + " is attending to caller " + caller.getCallerID());
        } else {
            System.out.println("No callers in the queue.");
        }
    }

    public void viewQueueLength(CallQueue callQueue) {
        System.out.println("Current queue length: " + callQueue.getQueueLength());
    }
}

// Main class
public class App {
    public static void main(String[] args) throws Exception {
        CallQueue callQueue = new CallQueue();

        // Simulate callers
        callQueue.addCaller(new Caller("Caller1", System.currentTimeMillis()));
        callQueue.addCaller(new Caller("Caller2", System.currentTimeMillis()));
        callQueue.addCaller(new Caller("Caller3", System.currentTimeMillis()));

        // Consultants
        Consultant consultant1 = new Consultant("Consultant1");
        Consultant consultant2 = new Consultant("Consultant2");

        // View Queue Length
        consultant1.viewQueueLength(callQueue);

        // Attend to calls
        consultant1.attendCall(callQueue);
        consultant2.attendCall(callQueue);

        // View Queue Length after attending calls
        consultant1.viewQueueLength(callQueue);
    }
}
