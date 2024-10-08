package com.fitness_social.common.event_driven.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoutineDeleteEvent implements Serializable {
    private String uid;
    private boolean success;

    @Override
    public String toString() {
        return "RoutineDeleteEvent{" +
                "uid='" + uid + '\'' +
                ", success=" + success +
                '}';
    }
}
