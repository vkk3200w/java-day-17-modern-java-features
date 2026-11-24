
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;
import java.time.LocalDateTime;
import com.fasterxml.jackson.databind.ObjectMapper;

public class q1{

    record FileSummary(String fileName, long sizeInBytes, String copiedAt) {}

    public static void main(String[] args) {

        try {
            Path source = Paths.get("source.txt");
            Path destination = Paths.get("backup/source.txt");

            Files.createDirectories(destination.getParent());

            Files.copy(source, destination,
                    StandardCopyOption.REPLACE_EXISTING);

            FileSummary summary = new FileSummary(
                    destination.getFileName().toString(),
                    Files.size(destination),
                    LocalDateTime.now().toString()
            );

            ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writeValueAsString(summary);

            Files.writeString(Paths.get("summary.json"), json);

            System.out.println("File copied successfully");
            System.out.println(json);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
