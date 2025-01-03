package com.fitness_social.common.event_driven.events;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDeleteEvent implements Serializable {
    private String uid;

    @Override
    public String toString() {
        return "UserDeleteEvent{" +
                "uid='" + uid + '\'' +
                '}';
    }
}
