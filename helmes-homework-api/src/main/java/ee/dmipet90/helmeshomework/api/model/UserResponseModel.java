package ee.dmipet90.helmeshomework.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserResponseModel {
    private String userId;
    private String name;
    private Set<UserSectorReponseModel> sectors;
    private boolean termsAgreed;
}
