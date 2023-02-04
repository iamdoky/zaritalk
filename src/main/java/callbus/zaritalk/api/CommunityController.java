package callbus.zaritalk.api;


import callbus.zaritalk.dataaccesslayer.entity.Community;
import callbus.zaritalk.dataaccesslayer.payload.request.CommunityWriteRequest;
import callbus.zaritalk.dataaccesslayer.payload.response.MessageResponse;
import callbus.zaritalk.service.CommunityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/community")
public class CommunityController {

    private final CommunityService communityService;

    @Operation(summary = "전체 커뮤니티 게시물 가져오기")
    @GetMapping("/")
    public ResponseEntity<List<Community>> list() {
        return ResponseEntity.ok(communityService.getCommunityList());
    }

    @Operation(summary = "커뮤니티 게시물 작성하기")
    @PostMapping("/")
    public ResponseEntity<MessageResponse> save(@RequestBody CommunityWriteRequest request) {
        return ResponseEntity.ok(communityService.save(request));
    }
}
