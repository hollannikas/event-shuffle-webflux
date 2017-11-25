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

    fun createEvent(req: ServerRequest) =
         ServerResponse
                .ok()
                .body(req.bodyToMono(Event::class.java)
                .flatMap {
                    eventRepository.save(it)
                })

    fun addVote(req: ServerRequest) = ServerResponse
                .ok()
                .body(
                    req.bodyToMono(Vote::class.java).flatMap { vote ->
                        eventRepository.findById(req.pathVariable("id"))
                                .flatMap {
                                    val newVotes = mutableSetOf(vote)
                                    newVotes.addAll(it.votes)
                                    it.votes = newVotes
                                    eventRepository.save(it)
                                }
                    }
                )

    fun getEvent(req: ServerRequest) = ServerResponse
            .ok()
            .body(eventRepository.findById(req.pathVariable("id")))

}