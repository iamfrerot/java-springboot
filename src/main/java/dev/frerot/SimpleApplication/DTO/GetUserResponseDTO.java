package dev.frerot.SimpleApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class GetUserResponseDTO {
    private String email;
    private String location;
    private int age;
}
