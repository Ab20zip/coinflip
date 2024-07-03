package com.altiran.coinflip

import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertTrue

class CoinFlipTest {
    @Test
    fun `coin flip should return Heads or Tails`() {
        val result = CoinFlip.flip()
        assertTrue(result == "Heads" || result == "Tails")
    }

    @Test
    fun `coin flip should be unbiased`() {
        val flips = (1..10000).map { CoinFlip.flip() }
        val headsCount = flips.count { it == "Heads" }
        val tailsCount = flips.count { it == "Tails" }
        assertTrue(abs(headsCount - tailsCount) < 500, "The coin flip is biased!")
    }
}
