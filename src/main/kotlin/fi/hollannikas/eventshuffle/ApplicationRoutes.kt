package fi.hollannikas.eventshuffle

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class ApplicationRoutes(val eventShuffleHandler: EventShuffleHandler) {
    @Bean
    fun routes() = router {
        GET("/event", eventShuffleHandler::listEvents)
        POST("/event", eventShuffleHandler::createEvent)
        POST("/event/{id}/vote", eventShuffleHandler::addVote)
    }
}