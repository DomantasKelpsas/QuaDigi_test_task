import tests.kotlin.MeasurementTestData

fun main() {
    val a = MeasurementSampler.sampleMeasurementData(MeasurementTestData.defaultData)
    a.forEach {
        println(it)
    }


}

