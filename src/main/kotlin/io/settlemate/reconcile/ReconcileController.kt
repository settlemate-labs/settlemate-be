package io.settlemate.reconcile

import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ReconcileController(private val reconcileService: ReconcileService) {
  @GetMapping("/dashboard")
  fun dashboard() = reconcileService.dashboard()

  @PostMapping("/settlements")
  fun settle(@Valid @RequestBody request: SettlementRequest) = reconcileService.settle(request)
}
