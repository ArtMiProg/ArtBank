package BankOfArt.filter;

import BankOfArt.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_SCHEMA = "Bearer ";
    public static final int BEARER_INDEX = 7;

    private final UserDetailsService userDetailsService;

    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var requestTokenHeader = request.getHeader(AUTHORIZATION_HEADER);
        String username = null;
        String jwtToken = null;
        if(requestTokenHeader != null && requestTokenHeader.startsWith(BEARER_SCHEMA)){
            jwtToken = requestTokenHeader.substring(BEARER_INDEX);
            username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        } else {
            logger.warn("Authorization header doesn't contain bearer string");
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            var userDetails = userDetailsService.loadUserByUsername(username);
            if(jwtTokenUtil.validateToken(jwtToken, userDetails)){
                var userAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                userAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(userAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
