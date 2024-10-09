package com.fitness_social.common.event_driven.events;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MeasurementDeleteEvent implements Serializable {
    private String uid;
    private boolean success;

    @Override
    public String toString() {
        return "MeasurementDeleteEvent{" +
                "uid='" + uid + '\'' +
                ", success=" + success +
                '}';
    }
}
