package callbus.zaritalk.dataaccesslayer.payload.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunityWriteRequest {
    String title;
    String content;
}
