package kazantseva.test.task.service.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import kazantseva.test.task.model.entity.CsvData;
import kazantseva.test.task.repository.CsvDataRepository;
import kazantseva.test.task.service.CsvDataService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CsvDataServiceImpl implements CsvDataService {
    CsvDataRepository csvDataRepository;
    @Override
    public void uploadCsv(MultipartFile file) throws IOException {
        CsvToBean<CsvData> csvDataList = new CsvToBeanBuilder<CsvData>(new InputStreamReader(file.getInputStream()))
                .withType(CsvData.class)
                .withSeparator(';')
                .build();
        csvDataRepository.saveAll(csvDataList.parse());
    }

    @Override
    public List<CsvData> getCsvData(int page, int size, String sort, String direction) {
        Pageable pageable = direction.equals("desc") ?
                PageRequest.of(page, size, Sort.Direction.DESC, sort) :
                PageRequest.of(page, size, Sort.Direction.ASC, sort);
        return csvDataRepository.findAll(pageable).stream().toList();
    }
}
