import javax.swing.*;
import java.awt.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BangladeshClockApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bangladesh Clock (BST)");
        JLabel timeLabel = new JLabel("", SwingConstants.CENTER);
        
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        timeLabel.setForeground(new Color(0, 106, 78)); 
        frame.add(timeLabel);
        
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        
        Timer timer = new Timer(1000, e -> {
            ZonedDateTime bstTime = ZonedDateTime.now(ZoneId.of("Asia/Dhaka"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a, dd-MM-yyyy");
            timeLabel.setText(bstTime.format(formatter));
        });
        timer.start();
    }
}
