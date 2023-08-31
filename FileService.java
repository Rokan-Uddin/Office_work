import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class FileService {

    public byte[] createFileContent(String text) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(text.getBytes());
        return byteArrayOutputStream.toByteArray();
    }
}
