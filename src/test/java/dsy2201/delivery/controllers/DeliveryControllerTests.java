package dsy2201.delivery.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import dsy2201.delivery.models.UserModel;
import dsy2201.delivery.services.UserModelService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

@WebMvcTest(DeliveryController.class)
public class DeliveryControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserModelService userServiceMock;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void ControllerPostUserTest() throws Exception {
        // Crea usuario para probar de manera automatica
        String userJson = "{\"name\":\"Usuario\",\"lastName\":\"Testin\",\"mail\":\"test@sumativa3.duocuc.cl\",\"phoneContact\":\"1232456789\",\"roles\":[{\"id\":1,\"name\":\"Admin\"},{\"id\":2,\"name\":\"Usuario\"}],\"addresses\":[{\"address\":\"calle alta 2324\"},{\"address\":\"calle baja 13567\"}]}";

        // Asignamos instancia  de modelo para el json
        UserModel newUser = objectMapper.readValue(userJson, UserModel.class);

        // revisamos comportamiento de respuesta
        when(userServiceMock.postUser(any())).thenReturn(newUser);

        // Validando respuesta 200
        mockMvc.perform(post("/delivery")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isOk());
    }
    @Test
    public void ControllerGetUsersByIdTest() throws Exception {
    //asignando usuario para testing
    UserModel user = new UserModel();
    user.setId(1); 
    user.setName("Usuario");
    user.setLastName("Testin");
    user.setMail("test@sumativa3.duocuc.cl");
    user.setPhoneContact("1232456789");
    // revisamos comportamiento de respuesta
    when(userServiceMock.getUserById(1)).thenReturn(Optional.of(user));

    // PValidando respuesta 200 y data que debe venir
    mockMvc.perform(get("/delivery/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Usuario"))
            .andExpect(jsonPath("$.lastName").value("Testin"))
            .andExpect(jsonPath("$.mail").value("test@sumativa3.duocuc.cl"))
            .andExpect(jsonPath("$.phoneContact").value("1232456789"));
    }   
}