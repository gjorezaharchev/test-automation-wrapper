package com.taw.objects.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCreateWithList {

    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus;
}
