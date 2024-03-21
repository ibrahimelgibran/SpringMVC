package iegcode.wevmvc.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

    @NotBlank
    private String firstName;

    private String middleName;

    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    private CreateAddressRequest address;

    private List<String> hobbies;

    private List<CreateSocialMediasRequest> socialMedias;
}
