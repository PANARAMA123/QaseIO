package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Case {
    String title;
    String status;
    String description;
    String severity;
    String suite;
    String priority;
    boolean toBeAutomated;

}