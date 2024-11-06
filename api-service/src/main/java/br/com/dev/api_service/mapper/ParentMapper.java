package br.com.dev.api_service.mapper;

import br.com.dev.api_service.domain.Parent;
import br.com.dev.api_service.domain.dtos.CreateCallRequestDto;
import br.com.dev.api_service.domain.dtos.ParentDto;
import org.springframework.stereotype.Component;

@Component
public class ParentMapper {
    public Parent toParent(CreateCallRequestDto requestDto){
        return new Parent(
                requestDto.getNameParent(),
                requestDto.getEmailParent(),
                requestDto.getCellParent(),
                requestDto.getPhoneParent(),
                requestDto.getType()
        );
    }
}
