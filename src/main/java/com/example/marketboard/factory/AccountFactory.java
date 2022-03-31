package com.example.marketboard.factory;

import com.example.marketboard.model.Account;
import org.springframework.stereotype.Component;
import java.security.InvalidParameterException;

@Component
public class AccountFactory {

    public Account get(final String type){
        if ("Base".equals(type)){
            return Account.builder().build();
        }
        throw new InvalidParameterException("An invalid parameter exception has occurred.");
    }
}
////Hello world