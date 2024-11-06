package br.com.dev.api_service.mapper;

import br.com.dev.api_service.domain.Called;
import br.com.dev.api_service.domain.dtos.CalledResponseDto;
import br.com.dev.api_service.domain.dtos.ParentResponseDto;
import br.com.dev.api_service.domain.dtos.StudentResponseDto;

public class MapToDto {

    public static CalledResponseDto toDto(Called called){
        ParentResponseDto parentDto = new ParentResponseDto(
                called.getStudent().getParent().getId(),
                called.getStudent().getParent().getName(),
                called.getStudent().getParent().getEmail(),
                called.getStudent().getParent().getCell(),
                called.getStudent().getParent().getPhone(),
                called.getStudent().getParent().getType()
        );

        StudentResponseDto studentDto = new StudentResponseDto(
                called.getStudent().getId(),
                called.getStudent().getName(),
                called.getStudent().getDateOfBirth(),
                called.getStudent().getClassNumber(),
                called.getStudent().getGrade(),
                called.getStudent().getParent()
        );

        return new CalledResponseDto(
                called.getId(),
                called.getQuestions(),
                called.getObservationForSchool(),
                called.getProvisions(),
                called.getFinalObservations(),
                called.getDateOfAttendance(),
                called.getStudent(),
                called.getUser(),
                called.getStatus()
        );
    }

}
