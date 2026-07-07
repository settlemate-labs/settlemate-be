package io.settlemate.reconcile

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReconcileServiceTest {
  @Test
  fun `refund spikes are held`() {
    val result = ReconcileService().settle(SettlementRequest("merchant-1", 10000, 3000))

    assertEquals("held", result.status)
    assertEquals("refund-spike", result.riskSignal)
    assertEquals(7000, result.payableAmount)
  }

  @Test
  fun `normal refund rates are cleared`() {
    val result = ReconcileService().settle(SettlementRequest("merchant-1", 10000, 1000))

    assertEquals("cleared", result.status)
    assertEquals("normal", result.riskSignal)
    assertEquals(9000, result.payableAmount)
  }
}
