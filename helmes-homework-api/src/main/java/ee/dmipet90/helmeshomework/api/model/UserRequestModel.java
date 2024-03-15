package ee.dmipet90.helmeshomework.api.model;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequestModel {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotEmpty(message = "Sector is mandatory")
    private List<String> sectorIds;
    @AssertTrue(message = "Please agree the terms")
    private boolean termsAgreed;
}
