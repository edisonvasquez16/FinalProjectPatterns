package observer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogSubscriber implements Subscriber {

    private File log;

    public LogSubscriber(String filename) {
        this.log = new File(filename);
    }

    public void update(Events eventType, Object data) {
        try {
            FileWriter fileWriter = new FileWriter(this.log, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(String.format("Time: %s, Event: %s, Details: %s", LocalDateTime.now(), eventType, data));
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Data written to file: " + this.log);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
