package api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePetStoreRequest {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private boolean complete;

}
