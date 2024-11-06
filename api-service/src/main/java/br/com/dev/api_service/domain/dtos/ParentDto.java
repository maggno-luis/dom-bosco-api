package br.com.dev.api_service.domain.dtos;

import br.com.dev.api_service.domain.enums.Requested;
import lombok.Data;
@Data
public class ParentDto {

    private String name;
    private String email;
    private String cell;
    private String phone;
    private Requested type;
}
