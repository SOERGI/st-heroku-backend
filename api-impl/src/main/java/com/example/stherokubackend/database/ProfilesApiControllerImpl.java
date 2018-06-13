package com.example.stherokubackend.database;

import io.swagger.annotations.ApiParam;
import io.swagger.api.external.api.ProfilesApiController;
import io.swagger.api.external.model.Profile;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

import static com.example.stherokubackend.database.Tables.PROFILE;

@Controller
public class ProfilesApiControllerImpl extends ProfilesApiController {

    private DSLContext dslContext;

    @Autowired
    public ProfilesApiControllerImpl(DSLContext dslContext){
        this.dslContext = dslContext;
    }

    @Override
    public ResponseEntity<Void> addProfile(@ApiParam(value = "Profile objects that needs to be added" ,required=true )  @Valid @RequestBody Profile profile) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Profile>> getProfiles() {
        // do some magic!
        com.example.stherokubackend.database.tables.Profile p = PROFILE.as("profile");

        return new ResponseEntity<List<Profile>>(HttpStatus.OK);
    }
}
