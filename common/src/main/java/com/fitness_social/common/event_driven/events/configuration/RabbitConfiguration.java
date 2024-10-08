package com.fitness_social.common.event_driven.events.configuration;

public class RabbitConfiguration {
    private RabbitConfiguration(){}

    //Exchanges
    public static final String USER_DELETE_EXCHANGE_NAME = "userDeleteExchange";
    //Queues
    public static final String USER_DELETE_QUEUE_NAME = "userDeleteQueue";
    public static final String ROUTINE_DELETE_QUEUE_NAME = "routineDeleteQueue";
    //Routingkeys
    public static final String USER_DELETE_QUEUE_ROUTING_KEY = "userDeleteQueue";
    public static final String ROUTINE_DELETE_QUEUE_ROUTING_KEY = "routineDeleteQueue";
    //Converters
    public static final String ALLOWED_LIST_OF_PATTERNS = "com.fitness_social.common.*";
}
