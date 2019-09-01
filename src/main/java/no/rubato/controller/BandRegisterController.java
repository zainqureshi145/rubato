package no.rubato.controller;

import no.rubato.model.Bands;
import no.rubato.payload.JWTLoginSuccessResponse;
import no.rubato.payload.LoginRequest;
import no.rubato.payload.LoginRequestBand;
import no.rubato.repository.BandsRepository;
import no.rubato.security.JwtTokenProviderBands;
import no.rubato.service.MapValidationErrorService;
import no.rubato.service.BandsService;
import no.rubato.validator.BandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

import static no.rubato.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/api2/registerBand")
public class BandRegisterController {
    public BandRegisterController() {
    }

    //@Autowired
    //public PersonsRepository personsRepository;//personsRepository Object
    @Autowired
    public BandsService bandsService;//personsService Object
    @Autowired
    private MapValidationErrorService mapValidationErrorService;
    @Autowired
    private BandValidator bandValidator;
    @Autowired
    private JwtTokenProviderBands jwtTokenProviderBands;
    @Autowired
    private AuthenticationManager authenticationManager;

    ////Register Person
    @CrossOrigin
    @PostMapping("/signUp")
    public ResponseEntity<?> registerBand(@Valid @RequestBody Bands bands, BindingResult result) {
        //Validate passwords match
        bandValidator.validate(bands, result);
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;
        Bands newBands = bandsService.saveBand(bands);
        return new ResponseEntity<Bands>(newBands, HttpStatus.CREATED);
    }

    ////Login Person
    @CrossOrigin
    @PostMapping("/signIn")
    public ResponseEntity<?> authenticateBand(@Valid @RequestBody LoginRequestBand loginRequestBand, BindingResult result) {
        //bandValidator.validate(bands, result);
       ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) return errorMap;

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestBand.getUsername(),
                        loginRequestBand.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + jwtTokenProviderBands.generateToken(authentication);
        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt));
    }
}