import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class MeasurementTest {

    @Test
    fun `MeasurementSampler returns 4 values`() {
        val measurementTestData = MeasurementTestData.defaultData
        val expectedResult = listOf(
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:05:00"),
                measurementType = MeasurementType.TEMP,
                35.79
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:10:00"),
                measurementType = MeasurementType.TEMP,
                35.01
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:05:00"),
                measurementType = MeasurementType.SPO2,
                97.17
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:10:00"),
                measurementType = MeasurementType.SPO2,
                95.08
            ),
        )

        val result = MeasurementSampler.sampleMeasurementData(measurementTestData)

        assertEquals(result.size, 4)
        assertEquals(result, expectedResult)
    }

    @Test
    fun `MeasurementSampler returns 3 values`() {
        val measurementTestData = listOf(
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:04:45"),
                measurementType = MeasurementType.TEMP,
                35.79
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:01:18"),
                measurementType = MeasurementType.SPO2,
                98.78
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:09:07"),
                measurementType = MeasurementType.TEMP,
                35.01
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:03:34"),
                measurementType = MeasurementType.SPO2,
                96.49
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:02:01"),
                measurementType = MeasurementType.TEMP,
                35.82
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:04:49"),
                measurementType = MeasurementType.SPO2,
                97.17
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:05:00"),
                measurementType = MeasurementType.SPO2,
                95.08
            ),
        )

        val expectedResult = listOf(
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:05:00"),
                measurementType = MeasurementType.TEMP,
                35.79
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:10:00"),
                measurementType = MeasurementType.TEMP,
                35.01
            ),

            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:05:00"),
                measurementType = MeasurementType.SPO2,
                95.08
            ),
        )

        val result = MeasurementSampler.sampleMeasurementData(measurementTestData)

        assertEquals(result.size, 3)
        assertEquals(result, expectedResult)
    }

    @Test
    fun `MeasurementSampler returns all values`() {
        val measurementTestData = listOf(
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:04:45"),
                measurementType = MeasurementType.TEMP,
                35.79
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:01:18"),
                measurementType = MeasurementType.SPO2,
                98.78
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:15:07"),
                measurementType = MeasurementType.TEMP,
                35.01
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:07:34"),
                measurementType = MeasurementType.SPO2,
                96.49
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T11:02:01"),
                measurementType = MeasurementType.TEMP,
                35.82
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:24:49"),
                measurementType = MeasurementType.SPO2,
                97.17
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T11:05:51"),
                measurementType = MeasurementType.SPO2,
                95.08
            ),
        )

        val expectedResult = listOf(
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:05:00"),
                measurementType = MeasurementType.TEMP,
                35.79
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:20:00"),
                measurementType = MeasurementType.TEMP,
                35.01
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T11:05:00"),
                measurementType = MeasurementType.TEMP,
                35.82
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:05:00"),
                measurementType = MeasurementType.SPO2,
                98.78
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:10:00"),
                measurementType = MeasurementType.SPO2,
                96.49
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:25:00"),
                measurementType = MeasurementType.SPO2,
                97.17
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T11:10:00"),
                measurementType = MeasurementType.SPO2,
                95.08
            ),
        )

        val result = MeasurementSampler.sampleMeasurementData(measurementTestData)

        assertEquals(result.size, measurementTestData.size)
        assertEquals(result, expectedResult)
    }

    @Test
    fun `MeasurementSampler returns no values`() {
        val measurementTestData = emptyList<Measurement>()
        val expectedResult = emptyList<Measurement>()

        val result = MeasurementSampler.sampleMeasurementData(measurementTestData)

        assertEquals(result.size, 0)
        assertEquals(result, expectedResult)
    }
}