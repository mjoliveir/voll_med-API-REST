package med.voll.api.infra.exceptions.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import med.voll.api.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}") // Corrigido aqui
    private String secret;

    public String getSubject(String token) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algoritmo).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getSubject(); // Retorna o subject do token
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token inválido", exception);
        }
    }

    // Método para gerar o token JWT para um usuário
    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Voll.med") // Define o emissor do token
                    .withSubject(usuario.getLogin()) // Define o sujeito do token
                    .withExpiresAt(dataExpiracao()) // Define a data de expiração do token
                    .sign(algoritmo); // Assina o token
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar token JWT", exception); // Considere criar uma exceção personalizada
        }
    }

    // Método para calcular a data de expiração do token
    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")); // Define a expiração para 2 horas a partir de agora
    }
}