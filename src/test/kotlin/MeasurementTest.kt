package tests.kotlin

import Measurement
import MeasurementSampler
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import MeasurementTestData
import java.time.LocalDateTime

class MeasurementTest {

    @Test
    fun `MeasurementSampler returns 4 values`() {
        val measurementTestData = MeasurementTestData.defaultData
        val expectedResult = listOf(
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:05"),
                measurementType = MeasurementType.TEMP,
                35.79
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:10"),
                measurementType = MeasurementType.TEMP,
                35.01
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:05"),
                measurementType = MeasurementType.SPO2,
                97.17
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:10"),
                measurementType = MeasurementType.SPO2,
                95.08
            ),
        )

        val result = MeasurementSampler.sampleMeasurementData(measurementTestData)

        assertEquals(result, expectedResult)
    }
}