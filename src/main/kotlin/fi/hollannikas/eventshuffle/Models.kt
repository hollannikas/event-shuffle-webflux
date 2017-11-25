package fi.hollannikas.eventshuffle

import java.util.*

data class Vote(val name: String, val votes: Set<Date>) {
    // Overriding equals to ensure name is the key
    // TODO this seems unnecessary; is there a better way?
    override fun equals(other: Any?): Boolean {
        if (other is Vote) {
            return name == other.name
        }
        return false
    }
    override fun hashCode(): Int = name.hashCode()
}

data class Event(val _id: String, val name: String, val dates: Set<Date>, var votes: Set<Vote> = emptySet())
