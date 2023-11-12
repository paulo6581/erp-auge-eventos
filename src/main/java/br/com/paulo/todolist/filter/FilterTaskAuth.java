package br.com.paulo.todolist.filter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.paulo.todolist.user.IUserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Component // classe de gerenciamento genérica do Spring
public class FilterTaskAuth  extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override // o compilador verificará se há um método correspondente na superclasse
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    throws ServletException, IOException {

        // Pegar a autenticação (usuário e senha)
        var authorization = request.getHeader("Authorization");

        // Remoção da palavra "Basic" - Basic Authorization
        var authEncoded =  authorization.substring("Basic".length()).trim();

        // decodificar base64
        byte[] authDecode =  Base64.getDecoder().decode(authEncoded);

        // converter array byte para array string
        var authString = new String(authDecode);
        String[] credentials = authString.split(":"); // [username, password]
        String username = credentials[0];
        String password = credentials[1];

        // Validar usuário
        var user =  this.userRepository.findByUsername(username);
        if(user == null) {
            response.sendError(401);
        } else {
            // Validar Senha
            var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
            if(passwordVerify.verified) {
                filterChain.doFilter(request, response);
            } else {
                response.sendError(401);
            }

            //Seguir em frente
        }
    }
}
