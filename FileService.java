import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class FileService {

    public File createAndWriteToFile(String text) throws IOException {
        File file = new File("example.txt");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text);
        }
        return file;
    }
}
