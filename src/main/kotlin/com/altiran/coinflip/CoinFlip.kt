package com.altiran.coinflip

import org.apache.commons.rng.core.source32.PcgXshRr32
import org.apache.commons.rng.simple.RandomSource

object CoinFlip {
    private val rng: PcgXshRr32 = RandomSource.create(RandomSource.PCG_XSH_RR_32) as PcgXshRr32

    fun flip(): String {
        val result = rng.nextInt(2)
        return if (result == 0) "Heads" else "Tails"
    }
}
