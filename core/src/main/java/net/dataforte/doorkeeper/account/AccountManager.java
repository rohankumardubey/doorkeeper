/**
 * Copyright 2010 Tristan Tarrant
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dataforte.doorkeeper.account;

import java.util.ArrayList;
import java.util.List;

import net.dataforte.doorkeeper.account.provider.AccountProvider;
import net.dataforte.doorkeeper.authenticator.AuthenticatorException;
import net.dataforte.doorkeeper.authenticator.AuthenticatorToken;
import net.dataforte.doorkeeper.authenticator.AuthenticatorUser;

public class AccountManager {
	List<AccountProvider> accountProviders;
	
	public AccountManager(List<AccountProvider> accountProviderChain) {
		this.accountProviders = accountProviderChain;
	}

	public List<AccountProvider> getAccountProviders() {
		return accountProviders;
	}	
	
	public AuthenticatorUser authenticate(AuthenticatorToken token) throws AuthenticatorException {
		// cycle through all providers
		for(AccountProvider accountProvider : accountProviders) {
			AuthenticatorUser user = accountProvider.authenticate(token);
			if(user!=null) {
				return user;
			}
		}
		return null;
	}

	public AuthenticatorUser load(AuthenticatorToken token) throws AuthenticatorException {
		for(AccountProvider accountProvider : accountProviders) {
			
			AuthenticatorUser user = accountProvider.load(token);
			if(user!=null) {
				return user;
			}			
		}
		// None of the account providers was able to load the user
		throw new AuthenticatorException("No account providers for %s", token);
	}
	
	public List<AuthenticatorUser> getUsersInGroup(String groupName) {
		List<AuthenticatorUser> users = new ArrayList<AuthenticatorUser>();
		
		return users;
	}

}
