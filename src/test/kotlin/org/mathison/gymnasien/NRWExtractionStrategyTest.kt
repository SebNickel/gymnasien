package org.mathison.gymnasien

import org.mathison.gymnasien.nrw.NRWExtractionStrategy
import org.testng.annotations.Test
import java.io.File

class NRWExtractionStrategyTest {

    @Test
    fun test() {

        val file = File("src/main/resources/nrw_liste.html")

        val baseUrl = "http://www.schulministerium.nrw.de/BiPo/SchuleSuchen"

        val document = FetchDocument.fromFile(file, baseUrl)

        val gymnasien = NRWExtractionStrategy.apply(document)

        gymnasien.forEach {

            println(it)

        }

    }

}
