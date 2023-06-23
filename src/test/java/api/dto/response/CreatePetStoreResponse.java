package api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePetStoreResponse {
    private Integer id;
    private Integer petId;
    private Integer quantity;
    private boolean complete;
}
