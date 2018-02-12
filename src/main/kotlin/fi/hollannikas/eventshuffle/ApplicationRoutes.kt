package fi.hollannikas.eventshuffle

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class ApplicationRoutes(val eventShuffleHandler: EventShuffleHandler) {
    @Bean
    fun routes() = router {
        GET("/event", eventShuffleHandler::listEvents)
        GET("/event/{id}", eventShuffleHandler::getEvent)
        GET("/event/{id}/result", eventShuffleHandler::getResult)
        POST("/event", eventShuffleHandler::createEvent)
        POST("/event/{id}/vote", eventShuffleHandler::addVote)
    }
}
