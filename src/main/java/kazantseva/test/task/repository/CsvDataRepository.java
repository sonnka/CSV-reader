package kazantseva.test.task.repository;

import kazantseva.test.task.model.entity.CsvData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CsvDataRepository extends JpaRepository<CsvData, Long> {

}
