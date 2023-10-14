package br.com.antonio.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.antonio.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var servletPath = request.getServletPath();

        if (servletPath.equals("/tasks/")) {
            var authorization = request.getHeader("Authorization");

            if (authorization != null) {
                var authEncoded = authorization.substring("Basic".length()).trim();
                byte[] authDecode = Base64.getDecoder().decode(authEncoded);
                var authString = new String(authDecode);

                String[] credentials = authString.split(":");
                String username = credentials[0];
                String password = credentials[1];

                var user = this.userRepository.findByUsername(username);

                if (user == null || !BCrypt.verifyer().verify(password.toCharArray(), user.getPassword()).verified) {
                    response.sendError(401);
                    return; // Encerrar o filtro
                }
            } else {
                response.sendError(401); // Se não houver credenciais, envie erro 401
                return; // Encerrar o filtro
            }
        }

        filterChain.doFilter(request, response);
    }
}
