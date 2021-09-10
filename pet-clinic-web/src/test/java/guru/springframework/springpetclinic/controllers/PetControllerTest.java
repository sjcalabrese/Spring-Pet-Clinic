package guru.springframework.springpetclinic.controllers;

import guru.springframework.springpetclinic.model.Owner;
import guru.springframework.springpetclinic.model.PetType;
import guru.springframework.springpetclinic.services.OwnerService;
import guru.springframework.springpetclinic.services.PetService;
import guru.springframework.springpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

class PetControllerTest {

    @Mock
    PetService petService;
    @Mock
    PetTypeService petTypeService;
    @Mock
    OwnerService ownerService;
    @InjectMocks
    PetController petController;

    MockMvc mockMvc;
    Owner owner;
    Set<PetType> petTypeSet;
    @BeforeEach

    void setUp() {
        owner = Owner.builder().id(1L).build();

        petTypeSet = new HashSet<>();
        petTypeSet.add(PetType
                .builder().id(1L).name("Dog").build());
        petTypeSet.add(PetType
                .builder().id(2L).name("Cat").build());

        mockMvc = MockMvcBuilders
                .standaloneSetup(petController)
                .build();
    }
}