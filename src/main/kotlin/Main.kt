fun main() {
    val sampledMeasurementList = MeasurementSampler.sampleMeasurementData(MeasurementTestData.defaultData)

    sampledMeasurementList.forEach {
        println(it)
    }
}

