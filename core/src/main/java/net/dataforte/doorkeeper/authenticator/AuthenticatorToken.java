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
package net.dataforte.doorkeeper.authenticator;

public class AuthenticatorToken {
	
	AuthenticatorState state;
	String principalName;
	
	public AuthenticatorToken(AuthenticatorState state) {
		this.state = state;
	}
	
	public AuthenticatorToken(AuthenticatorState state, String principalName) {
		this.state = state;
		this.principalName = principalName;
	}
	
	public AuthenticatorToken(String principalName) {
		state = AuthenticatorState.NONE;
		this.principalName = principalName;
	}

	public AuthenticatorState getState() {
		return state;
	}

	public void setState(AuthenticatorState state) {
		this.state = state;
	}

	public String getPrincipalName() {
		return principalName;
	}

	@Override
	public String toString() {
		return "AuthenticatorToken [principalName=" + principalName + ", state=" + state + "]";
	}
}