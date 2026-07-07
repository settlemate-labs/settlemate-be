package io.settlemate.reconcile

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class SettlementRequest(
  @field:NotBlank val merchantId: String,
  @field:Min(1) val grossAmount: Long,
  @field:Min(0) val refundAmount: Long
)

data class SettlementResult(
  val merchantId: String,
  val payableAmount: Long,
  val status: String,
  val riskSignal: String
)

data class DashboardSnapshot(
  val title: String,
  val primaryMetric: String,
  val secondaryMetric: String,
  val alerts: List<String>
)
