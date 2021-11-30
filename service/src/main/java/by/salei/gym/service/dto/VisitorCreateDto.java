package by.salei.gym.service.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitorCreateDto extends AbstractCreateDto {
    private String name;
}
