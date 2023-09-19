package org.example;

import org.example.controller.PersonController;
import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = PersonController.class)
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private PersonController personController;

    @MockBean
    private PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository.deleteAll();
    }

    @Test
    void testCreatePerson() {
        Person person = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .build();

        when(personRepository.save(any())).thenReturn(person);

        personController.createPerson(person);

        verify(personRepository, times(1)).save(any());
    }

    @Test
    void testGetAllPersons() {
        List<Person> personList = Arrays.asList(
                Person.builder()
                        .firstName("John")
                        .lastName("Doe")
                        .build(),
                Person.builder()
                        .firstName("Jane")
                        .lastName("Smith")
                        .build()
        );

        when(personRepository.findAll()).thenReturn(personList);

        personList.forEach(x -> personController.createPerson(x));

        personController.getAllPersons();

        verify(personRepository, times(1)).findAll();
    }

    @Test
    void testGetPersonById() {
        Long personId = 1L;
        Person person = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .build();

        when(personRepository.findById(personId)).thenReturn(Optional.of(person));

        personController.getPersonById(personId);

        verify(personRepository, times(1)).findById(personId);
    }
}
