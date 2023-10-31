# User-Application-using-TOTP-Validation

- This Application has two APIs

  * User Registeration - https://localhost:8080/user/register
    - Request:
      {
        "username": "laksh",
        "password": "secret"
      }

  * User Login - localhost:8080/user/login
     {
        "username":"laksh",
        "password":"secret",
        "otpVal":"1234"
     }
