package io.settlemate.reconcile

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReconcileServiceTest {
  @Test
  fun `refund spikes are held`() {
    val result = ReconcileService().settle(SettlementRequest("merchant-1", 10000, 3000))

    assertEquals("held", result.status)
  }
}
