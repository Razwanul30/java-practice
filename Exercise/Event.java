class EventRegistration {
    int eventId;
    int studentId;
    String registeredTime;
    boolean checkedIn;

    EventRegistration(int eventId, int studentId,
            String registeredTime, boolean checkedIn) {
        this.eventId = eventId;
        this.studentId = studentId;
        this.registeredTime = registeredTime;
        this.checkedIn = checkedIn;
    }
}

public class Event {
    public static void main(String[] args) {

        EventRegistration[] regs = new EventRegistration[3];

        regs[0] = new EventRegistration(1, 101, "10:00", true);
        regs[1] = new EventRegistration(1, 102, "10:05", false);
        regs[2] = new EventRegistration(1, 103, "10:10", false);

        int checkedCount = 0;

        System.out.println("Registered Students:");
        for (EventRegistration r : regs) {
            System.out.println("Student ID: " + r.studentId);
            if (r.checkedIn)
                checkedCount++;
        }

        System.out.println("Checked-in Count: " + checkedCount);
    }
}