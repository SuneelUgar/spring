* TO Get end point from auth server:
http://localhost:8180/realms/eazybankdev/.well-known/openid-configuration
* -------------------------------------------------------------------------*
"authorization_endpoint": "http://localhost:8180/realms/bankdev/protocol/openid-connect/auth",
"token_endpoint": "http://localhost:8180/realms/bankdev/protocol/openid-connect/token",
* *------------------------------------------------------------------------------*

Grant Types
1) Authorization code (user login involved)
2) client credential (direct client app talks to auth server)
3) PKCE (Proof key for code exchange)