package kazantseva.test.task.service;

import kazantseva.test.task.model.entity.CsvData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CsvDataService {
    void uploadCsv(MultipartFile file) throws IOException;

    List<CsvData> getCsvData(int page, int size, String sort, String direction);
}
