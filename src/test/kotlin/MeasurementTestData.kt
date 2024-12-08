import java.time.LocalDateTime

class MeasurementTestData {
    companion object {
        val defaultData = listOf(
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
                measurementTime = LocalDateTime.parse("2017-01-03T10:05:00"),
                measurementType = MeasurementType.SPO2,
                97.17
            ),
            Measurement(
                measurementTime = LocalDateTime.parse("2017-01-03T10:05:01"),
                measurementType = MeasurementType.SPO2,
                95.08
            ),
        )
    }
}