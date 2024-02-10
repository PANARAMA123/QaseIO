package adapters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import dto.Suite;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuiteApiResponse {
    Suite result;
}
