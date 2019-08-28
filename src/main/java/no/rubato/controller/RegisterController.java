package no.rubato.controller;

import no.rubato.model.Persons;
import no.rubato.payload.JWTLoginSuccessResponse;
import no.rubato.payload.LoginRequest;
import no.rubato.repository.PersonsRepository;
import no.rubato.security.JwtTokenProvider;
import no.rubato.service.MapValidationErrorService;
import no.rubato.service.PersonsService;
import no.rubato.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static no.rubato.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
    public RegisterController() {
    }

    //@Autowired
    //public PersonsRepository personsRepository;//personsRepository Object
    @Autowired
    public PersonsService personsService;//personsService Object
    @Autowired
    private MapValidationErrorService mapValidationErrorService;
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;

    ////Register Person
    @CrossOrigin
    @PostMapping("/signUp")
    public ResponseEntity<?> registerPerson(@Valid @RequestBody Persons persons, BindingResult result) {
        //Validate passwords match
        personValidator.validate(persons, result);
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
        Persons newPersons = personsService.savePerson(persons);
        return new ResponseEntity<Persons>(newPersons, HttpStatus.CREATED);
    }

    ////Login Person
    @CrossOrigin
    @PostMapping("/signIn")
    public ResponseEntity<?> authenticatePerson(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Collection<? extends GrantedAuthority> role = authentication.getAuthorities();
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt));
    }
}