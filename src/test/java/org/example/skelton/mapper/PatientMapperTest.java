package org.example.skelton.mapper;

import lombok.Getter;
import lombok.Setter;
import org.example.skelton.entity.Patient;
import org.example.skelton.model.PatientDTO;
import org.instancio.Instancio;
import org.instancio.Model;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.instancio.Select.all;
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
        assertFalse(mappedDTO.getAddress()
                .isEmpty());
        assertEquals(mockPatient.getId(), mappedDTO.getId());
        assertEquals(mockPatient.getName(), mappedDTO.getName());
    }

    @Test
    void test() {
        Model<Person> simpsons = Instancio.of(Person.class)
                .set(field(Person::getLastName), "Simpson")
                .set(field(Address::getCity), "Springfield")
                .generate(field(Person::getAge), gen -> gen.ints()
                        .range(40, 50))
                .toModel();

        Person homer = Instancio.of(simpsons)
                .set(field(Person::getFirstName), "Homer")
                .create();

        Person marge = Instancio.of(simpsons)
                .set(field(Person::getFirstName), "Marge")
                .create();
//        Person person = Instancio.of(Person.class)
//                .generate(field(Person::getDateOfBirth), gen -> gen.temporal().localDate().past())
//                .generate(field(Phone::getAreaCode), gen -> gen.oneOf("604", "778"))
//                .generate(field(Phone::getNumber), gen -> gen.text().pattern("#d#d#d-#d#d-#d#d"))
//                .subtype(all(AbstractAddress.class), AddressImpl.class)
//                .supply(all(LocalDateTime.class), () -> LocalDateTime.now())
//                .onComplete(all(Person.class), (Person p) -> p.setName(p.getGender() == Gender.MALE ? "John" : "Jane"))
//                .create();
        List<Patient> patient = Instancio.ofList(Patient.class)
                .size(10)
                .generate(field(Patient::getId), gen -> gen.intSeq())
                .generate(field(Patient::getPhone), gen -> gen.text()
                        .pattern(("#d#d#d-#d#d-#d#d")))
                .create();
//
//        Instancio.ofList(simpsons)
//                .size(10)
//                .set(field(Person::))

    }
}

@Getter
@Setter
class Person {

    String firstName;
    String lastName;
    Integer age;
    Address address;


}

@Setter
@Getter
class Address {
    String city;

}