import java.time.LocalDateTime

data class Measurement(
    val measurementTime: LocalDateTime,
    val measurementType: MeasurementType,
    val measurementValue: Double,
)

enum class MeasurementType {
    TEMP, SPO2
}