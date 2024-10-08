package com.fitness_social.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDeleteEvent implements Serializable {
    private String uid;

    @Override
    public String toString() {
        return "UserDeleteEvent{" +
                "uid='" + uid + '\'' +
                '}';
    }
}
