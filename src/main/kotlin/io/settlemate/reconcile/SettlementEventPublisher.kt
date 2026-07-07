package io.settlemate.reconcile

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class SettlementEventPublisher(private val rabbitTemplate: RabbitTemplate) {
  fun publishSettlement(result: SettlementResult) {
    rabbitTemplate.convertAndSend("settlemate.settlement.events", result)
  }
}
