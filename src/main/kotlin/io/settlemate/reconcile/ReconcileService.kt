package io.settlemate.reconcile

import org.springframework.stereotype.Service

@Service
class ReconcileService {
  fun settle(request: SettlementRequest): SettlementResult {
    val payable = request.grossAmount - request.refundAmount
    val risk = if (request.refundAmount * 100 > request.grossAmount * 25) "refund-spike" else "normal"

    return SettlementResult(
      merchantId = request.merchantId,
      payableAmount = payable.coerceAtLeast(0),
      status = if (risk == "normal") "cleared" else "held",
      riskSignal = risk
    )
  }

  fun dashboard() = DashboardSnapshot(
    title = "settlement reconciliation",
    primaryMetric = "99.7%",
    secondaryMetric = "3 anomalies",
    alerts = listOf("refund spike", "payout hold")
  )
}
