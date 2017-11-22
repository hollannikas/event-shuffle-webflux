package fi.hollannikas.eventshuffle

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import java.util.*

data class Vote(val name: String, val votes: Set<Date>)
@Document
data class Event(val name: String, val dates: Set<Date>, var votes: Set<Vote>)

interface EventRepository : ReactiveCrudRepository<Event, Long>
