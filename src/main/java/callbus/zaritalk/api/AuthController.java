package callbus.zaritalk.api;

import callbus.zaritalk.dataaccesslayer.payload.request.SignInRequest;
import callbus.zaritalk.dataaccesslayer.payload.response.JwtResponse;
import callbus.zaritalk.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Validated
@Slf4j
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity<JwtResponse> signIn(@RequestBody SignInRequest request) throws ResourceNotFoundException {
        return ResponseEntity.ok(authService.signIn(request));
    }
}