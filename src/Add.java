import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Add {
    String name;
    String id;
    String no;
    String date;
    String time;

    public Add() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String dateStr = now.format(dateFormatter);
        String timeStr = now.format(timeFormatter);
        this.name = "unknown";
        this.no = "0";
        this.date = dateStr;
        this.time = timeStr;
        this.id = generateID(this.no, this.date, this.time);
    }

    public String[] showDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String dateStr = now.format(dateFormatter);
        String timeStr = now.format(timeFormatter);
        System.out.println("Date: " + dateStr);
        System.out.println("Time: " + timeStr);
        return new String[]{dateStr, timeStr};
    }

    String generateID(String no, String d, String t) {
        LocalDateTime n = LocalDateTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("ss");
        String formattedTime = n.format(f);
        d = d.replaceAll("/", "");
        t = t.replace(":", "");
        return "#" + no + d + t + formattedTime;
    }
}