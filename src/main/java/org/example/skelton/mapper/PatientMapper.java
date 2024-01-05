package org.example.skelton.mapper;

import org.example.skelton.entity.Patient;
import org.example.skelton.model.PatientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(PatientDTO dto);

    PatientDTO toDTO(Patient patient);

}
