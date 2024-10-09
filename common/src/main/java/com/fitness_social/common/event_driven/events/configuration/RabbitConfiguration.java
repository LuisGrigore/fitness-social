package com.fitness_social.common.event_driven.events.configuration;

public class RabbitConfiguration {
    private RabbitConfiguration(){}

    //Exchanges
    public static final String USER_DELETE_EXCHANGE_NAME = "userDeleteExchange";
    //Queues
    public static final String USER_ROUTINE_DELETE_QUEUE_NAME = "userRoutineDeleteQueue";
    public static final String ROUTINE_USER_DELETE_QUEUE_NAME = "routineUserDeleteQueue";
    public static final String ROUTINE_MEASUREMENT_DELETE_QUEUE_NAME = "routineMeasurementDeleteQueue";
    public static final String MEASUREMENT_ROUTINE_DELETE_QUEUE_NAME = "measurementRoutineDeleteQueue";


    //Routingkeys
    public static final String USER_ROUTINE_DELETE_QUEUE_ROUTING_KEY = "userRoutineDeleteQueue";
    public static final String ROUTINE_USER_DELETE_QUEUE_ROUTING_KEY = "routineUserDeleteQueue";
    public static final String ROUTINE_MEASUREMENT_DELETE_QUEUE_ROUTING_KEY = "routineMeasurementDeleteQueue";
    public static final String MEASUREMENT_ROUTINE_DELETE_QUEUE_ROUTING_KEY = "measurementRoutineDeleteQueue";
    //Converters
    public static final String ALLOWED_LIST_OF_PATTERNS = "com.fitness_social.common.*";
}
