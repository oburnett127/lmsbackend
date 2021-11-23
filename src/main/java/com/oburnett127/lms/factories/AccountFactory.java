package com.oburnett127.lms.factories;

import com.oburnett127.lms.models.Account;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Component
public class AccountFactory {

    public Account get(final String type){
        if ("Base".equals(type)){
            return Account.builder().build();
        }
        throw new InvalidParameterException("Invalid Parameter Exception has occurred in AccountFactory.java");
    }
}




