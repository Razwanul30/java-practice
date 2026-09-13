import javax.swing.*;
import java.awt.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class BangladeshDesktopClock {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("BANGLADESH STANDART TIME");
        frame.setSize(450, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255)); 

        
        JLabel timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));
        timeLabel.setForeground(new Color(0, 106, 78)); 

        
        JLabel dateLabel = new JLabel("", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        dateLabel.setForeground(new Color(200, 0, 0)); 

        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dateLabel, BorderLayout.SOUTH);
        frame.add(panel);

        // প্রতি ১ সেকেন্ড পর পর সময় ও তারিখ আপডেট করার টাইমার
        Timer timer = new Timer(1000, e -> {
            ZonedDateTime bstTime = ZonedDateTime.now(ZoneId.of("Asia/Dhaka"));
            
            // সময় ও তারিখের ফরম্যাট
            String timeStr = bstTime.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
            String dateStr = bstTime.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy"));
            
            timeLabel.setText(timeStr);
            dateLabel.setText(dateStr);
        });
        timer.start();

        frame.setVisible(true);
    }
}

