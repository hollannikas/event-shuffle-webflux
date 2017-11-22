package fi.hollannikas.eventshuffle

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body

@Component
class EventShuffleHandler(val eventRepository: EventRepository) {
    fun listEvents(req: ServerRequest) =
            ServerResponse
                    .ok()
                    .body(eventRepository.findAll())
}