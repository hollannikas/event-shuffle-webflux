package fi.hollannikas.eventshuffle

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class ApplicationRoutes(val eventShuffleHandler: EventShuffleHandler) {
    @Bean
    fun routes() = router {
        GET("/list", eventShuffleHandler::listEvents)
        "api/v1/event".nest {
            GET("/list", eventShuffleHandler::listEvents)
        }
    }
}