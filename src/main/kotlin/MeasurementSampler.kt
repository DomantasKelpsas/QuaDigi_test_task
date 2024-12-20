object MeasurementSampler {
    const val INTERVAL_IN_MINUTES = 5L

    fun sampleMeasurementData(measurementDataList: List<Measurement>): List<Measurement> {
        val sampledMeasurementList = mutableListOf<Measurement>()

        try {
            measurementDataList
                .sortedBy { measurement -> measurement.measurementTime }
                .groupBy { measurement -> measurement.measurementType }
                .toSortedMap()
                .forEach {
                    val measurementGroup = it.value

                    val initialMeasurementTime = measurementGroup
                        .first().measurementTime
                        .let { measurementTime ->
                            measurementTime.withSecond(0).withNano(0)
                                .minusMinutes((measurementTime.minute % INTERVAL_IN_MINUTES).toLong())
                        }
                    val lastMeasurementTime = measurementGroup
                        .last().measurementTime
                    var measurementTimeOffset = initialMeasurementTime

                    while (measurementTimeOffset < lastMeasurementTime) {
                        val measurementsInInterval = measurementGroup.filter { measurementOfType ->
                            measurementOfType.measurementTime in measurementTimeOffset..measurementTimeOffset.plusMinutes(
                                INTERVAL_IN_MINUTES
                            )
                        }
                        measurementTimeOffset =
                            measurementTimeOffset.plusMinutes(INTERVAL_IN_MINUTES)

                        if (measurementsInInterval.isNotEmpty()) {
                            sampledMeasurementList.add(
                                measurementsInInterval
                                    .last()
                                    .copy(measurementTime = measurementTimeOffset)
                            )
                        }
                    }
                }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return sampledMeasurementList
    }
}