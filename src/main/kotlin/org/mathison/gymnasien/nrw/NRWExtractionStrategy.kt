package org.mathison.gymnasien.nrw

import org.jsoup.nodes.Document
import org.mathison.gymnasien.Gymnasium

object NRWExtractionStrategy {

    fun apply(document: Document): List<Gymnasium> {

        document.select("br").prepend("BREAK")

        val ergebnisTabs = document.select("table.bp_ergebnis_tab")

        val gymnasien = ergebnisTabs.map { ergebnisTab ->

            val name =
                ergebnisTab
                    .select("td.bp_ergebnis")[1]
                    .text()
                    .split(" BREAK")
                    .first()

            val email =
                ergebnisTab
                    .select("a")[1]
                    .attr("href")
                    .split("mailto:")
                    .last()

            Gymnasium("NRW", name, email)

        }

        return gymnasien

    }

}
