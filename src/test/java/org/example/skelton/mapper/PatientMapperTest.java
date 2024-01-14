package org.example.skelton.mapper;

import org.example.skelton.entity.Patient;
import org.example.skelton.entity.PatientAddress;
import org.example.skelton.model.PatientDTO;
import org.instancio.Instancio;
import org.instancio.Model;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.instancio.Select.field;
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
        List<Patient> list = Instancio.ofList(Patient.class)
                .size(5)
                .create();

        PatientDTO mappedDTO = patientMapper.toDTO(mockPatient);

        assertNotNull(mappedDTO);
        assertFalse(mappedDTO.getAddress().isEmpty());
        assertEquals(mockPatient.getId(), mappedDTO.getId());
        assertEquals(mockPatient.getName(), mappedDTO.getName());
    }


    public Model<Patient> getPatientModel() {
        Set<PatientAddress> addressModel = Instancio.ofSet(PatientAddress.class).size(3).set(field(PatientAddress::getCity), "Cairo").create();

        return Instancio.of(Patient.class)
                .generate(field(Patient::getPhone), gen -> gen.text().pattern("+#d#d#d-#d#d-#d#d#d"))
                .generate(field(Patient::getAge), gen -> gen.ints().range(40, 50))
                .set(field(Patient::getAddress), addressModel)
                .toModel();
    }

    @Test
    public void testPatientEntityToDTO() {
        Patient patient = Instancio.create(getPatientModel());
        PatientDTO dto = patientMapper.toDTO(patient);
        assertNotNull(dto);
        assertEquals(patient.getName(), dto.getName());
        assertEquals(patient.getName(), dto.getName());
        assertFalse(dto.getAddress().isEmpty());
        assertEquals(patient.getAddress().size(), dto.getAddress().size());
    }
}