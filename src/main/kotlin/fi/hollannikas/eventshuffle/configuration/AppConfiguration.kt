package fi.hollannikas.eventshuffle.configuration


import com.mongodb.reactivestreams.client.MongoClient
import com.mongodb.reactivestreams.client.MongoClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration
import org.springframework.data.mongodb.core.ReactiveMongoClientFactoryBean
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories
import java.util.logging.Logger



@EnableReactiveMongoRepositories
@Configuration
class AppConfiguration : AbstractReactiveMongoConfiguration() {
    companion object {
        val LOG = Logger.getLogger(AppConfiguration::class.java.name)!!
    }

    @Value("\${mongo.host:localhost}") lateinit var mongoHost : String
    @Value("\${mongo.port:27017}") lateinit var mongoPort : String

    @Bean
    override fun reactiveMongoClient(): MongoClient {
        val mongoUrl = "mongodb://$mongoHost:$mongoPort"
        LOG.info("reactive $mongoUrl")
        return MongoClients.create(mongoUrl)
    }

    @Bean
    fun mongoClient() : ReactiveMongoClientFactoryBean {
        val mongoUrl = "mongodb://$mongoHost:$mongoPort"
        LOG.info(mongoUrl)
        val clientFactory = ReactiveMongoClientFactoryBean()
        clientFactory.setHost(mongoHost)
        clientFactory.setPort(mongoPort.toInt())

        return clientFactory
    }

    override fun getDatabaseName(): String = "reactive"
}