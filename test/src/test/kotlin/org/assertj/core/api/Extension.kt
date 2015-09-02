package org.assertj.core.api

import kotlin.platform.platformStatic

class Kassertions {
    companion object {
        platformStatic public fun assertThat(actual: Double): AbstractDoubleAssert<*> = DoubleAssert(actual)
    }
}