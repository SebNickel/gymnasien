package org.mathison.gymnasien.nrw

import org.mathison.gymnasien.FetchDocument
import java.io.File

object FetchNRW {

    private val file = File("src/main/resources/nrw_liste.html")

    private val baseUrl = "http://www.schulministerium.nrw.de/BiPo/SchuleSuchen"

    fun apply() = FetchDocument.fromFile(file, baseUrl)

}
