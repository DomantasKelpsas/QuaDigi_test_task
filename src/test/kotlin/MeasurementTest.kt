package tests.kotlin

import MeasurementSampler
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import tests.kotlin.MeasurementTestData

class MeasurementTest {

    @Test
    fun `MeasurementSampler returns 4 values`(){
        val measurementTestData = MeasurementTestData.defaultData

        val result = MeasurementSampler.sampleMeasurementData(measurementTestData)

        assertEquals(measurementTestData, result)
    }
}