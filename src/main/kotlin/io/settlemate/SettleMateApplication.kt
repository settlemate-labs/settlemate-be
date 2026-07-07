package io.settlemate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SettleMateApplication

fun main(args: Array<String>) {
  runApplication<SettleMateApplication>(*args)
}
