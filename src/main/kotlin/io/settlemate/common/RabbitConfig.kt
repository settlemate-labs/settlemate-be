package io.settlemate.common

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {
  @Bean
  fun settlementEventsQueue() = Queue("settlemate.settlement.events", true)
}
