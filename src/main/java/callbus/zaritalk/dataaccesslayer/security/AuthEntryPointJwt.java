package callbus.zaritalk.dataaccesslayer.security;

import callbus.zaritalk.dataaccesslayer.payload.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        log.error("Unauthorized error : {}", authException.getMessage());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        response.getOutputStream().println(ow.writeValueAsString(new ErrorResponse(HttpStatus.UNAUTHORIZED,
                authException.getMessage(), request.getRequestURI(), HttpStatus.UNAUTHORIZED.value())));
    }
}