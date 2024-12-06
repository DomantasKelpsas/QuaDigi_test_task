object MeasurementSampler {
    fun sampleMeasurementData(measurementDatalist: List<Measurement>): List<Measurement> {
        val sampledMeasurementList = mutableListOf<Measurement>()

        measurementDatalist
            .sortedBy { measurement -> measurement.measurementTime }
            .groupBy { measurement -> measurement.measurementType }
            .toSortedMap()
            .forEach {
                val measurementGroup = it.value

                val initialMeasurementTime = measurementGroup
                    .first().measurementTime
                    .let { measurementTime ->
                        measurementTime.withSecond(0).withNano(0).minusMinutes((measurementTime.minute % 5).toLong())
                    }
                val lastMeasurementTime = measurementGroup
                    .last().measurementTime
                var measurementTimeOffset = initialMeasurementTime

                while (measurementTimeOffset <= lastMeasurementTime) {
                    val measurementsInInterval = measurementGroup.filter { measurementOfType ->
                        measurementOfType.measurementTime in measurementTimeOffset..measurementTimeOffset.plusMinutes(5)
                    }
                    measurementTimeOffset = measurementTimeOffset.plusMinutes(5)

                    sampledMeasurementList.add(
                        measurementsInInterval
                            .last()
                            .copy(measurementTime = measurementTimeOffset)
                    )
                }
            }

        return sampledMeasurementList
    }
}