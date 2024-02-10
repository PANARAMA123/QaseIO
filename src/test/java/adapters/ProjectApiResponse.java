package adapters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import dto.Project;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectApiResponse {
    Project result;
}