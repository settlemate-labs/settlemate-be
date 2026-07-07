package io.settlemate.reconcile

import java.time.Duration
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class MerchantCache(private val redisTemplate: StringRedisTemplate) {
  fun rememberRiskSignal(merchantId: String, riskSignal: String) {
    redisTemplate.opsForValue().set("merchant-risk:$merchantId", riskSignal, Duration.ofMinutes(30))
  }
}
