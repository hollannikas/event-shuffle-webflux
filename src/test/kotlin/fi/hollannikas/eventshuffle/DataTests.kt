package fi.hollannikas.eventshuffle

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.has
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.Instant.now
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class DataTests {

	@Test
	fun nameIsUniqueInASetOfVotes() {
		val vote1 = Vote("Bob", emptySet())
        val vote2 = Vote("Bob", setOf(Date.from(now())))
        val dateSet = setOf(vote1, vote2)
        val containsOnlyOneVote = has(Set<Vote>::size, equalTo(1))
        assert.that(dateSet, containsOnlyOneVote)
	}

}
