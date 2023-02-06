package callbus.zaritalk.dataaccesslayer.payload.response;

import callbus.zaritalk.dataaccesslayer.entity.User;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtResponse {
    private String token;
    private final String type = "Bearer";
    private long id;
    private String email;
    private List<String> roles;
}