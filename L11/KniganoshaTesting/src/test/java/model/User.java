package model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor @EqualsAndHashCode @ToString
public class User {
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;
}
