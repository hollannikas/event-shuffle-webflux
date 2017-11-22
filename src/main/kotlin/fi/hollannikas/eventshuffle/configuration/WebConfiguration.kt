package fi.hollannikas.eventshuffle.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.WebFluxConfigurationSupport

@Configuration
class WebConfiguration : WebFluxConfigurationSupport() {
    override fun addCorsMappings(registry: CorsRegistry?) {
        registry!!.addMapping("/**").allowedOrigins("*")
    }
}