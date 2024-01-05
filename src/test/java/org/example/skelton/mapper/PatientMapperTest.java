package org.example.skelton.mapper;

import org.example.skelton.entity.Patient;
import org.example.skelton.model.PatientDTO;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientMapperTest {

    @Autowired
    private PatientMapper patientMapper;

    @Test
    void toEntity() {
        PatientDTO dto = Instancio.create(PatientDTO.class);
        Patient entity = patientMapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getName(), entity.getName());
    }

    @Test
    void toDTO() {
        Patient mockPatient = Instancio.create(Patient.class);

        PatientDTO mappedDTO = patientMapper.toDTO(mockPatient);

        assertNotNull(mappedDTO);
        assertEquals(mockPatient.getId(), mappedDTO.getId());
        assertEquals(mockPatient.getName(), mappedDTO.getName());
    }
}