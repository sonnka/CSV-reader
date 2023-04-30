package kazantseva.test.task.controller;

import kazantseva.test.task.model.entity.CsvData;
import kazantseva.test.task.service.CsvDataService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@Validated
@AllArgsConstructor
public class CsvDataController {
    CsvDataService csvDataService;

    @PostMapping("/csv/upload")
    public void uploadCsv(@RequestParam("file") MultipartFile file) throws IOException {
       csvDataService.uploadCsv(file);
    }

    @GetMapping("/csv")
    public List<CsvData> getCsvData(@RequestParam(required = false, defaultValue = "0") int page,
                                    @RequestParam(required = false, defaultValue = "10") int size,
                                    @RequestParam(required = false, defaultValue = "id") String sort,
                                    @RequestParam(required = false, defaultValue = "asc") String direction) {
        return csvDataService.getCsvData(page,size,sort,direction);
    }
}
