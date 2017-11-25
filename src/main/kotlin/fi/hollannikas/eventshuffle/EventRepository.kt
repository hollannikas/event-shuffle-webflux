package fi.hollannikas.eventshuffle

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EventRepository : ReactiveCrudRepository<Event, String>

