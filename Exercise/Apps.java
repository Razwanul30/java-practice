class AppSession {
  int sessionId;
  int userId;
  int startTime;
  int endTime;
  double dataUsedMB;

  AppSession(int sessionId, int userId,
      int startTime, int endTime, double dataUsedMB) {
    this.sessionId = sessionId;
    this.userId = userId;
    this.startTime = startTime;
    this.endTime = endTime;
    this.dataUsedMB = dataUsedMB;
  }

  int duration() {
    return endTime - startTime;
  }
}

public class Apps {
  public static void main(String[] args) {

    AppSession[] sessions = new AppSession[3];

    sessions[0] = new AppSession(1, 101, 10, 20, 300);
    sessions[1] = new AppSession(2, 102, 15, 40, 800);
    sessions[2] = new AppSession(3, 103, 5, 25, 1200);

    AppSession longest = sessions[0];

    for (AppSession s : sessions) {
      if (s.duration() > longest.duration())
        longest = s;

      if (s.dataUsedMB > 500)
        System.out.println("High Data Usage Session: " + s.sessionId);
    }

    System.out.println("Longest Session: " + longest.sessionId);
  }
}