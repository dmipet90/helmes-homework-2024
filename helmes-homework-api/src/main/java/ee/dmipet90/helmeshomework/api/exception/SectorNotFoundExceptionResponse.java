package ee.dmipet90.helmeshomework.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SectorNotFoundExceptionResponse {
    String sectors;
}