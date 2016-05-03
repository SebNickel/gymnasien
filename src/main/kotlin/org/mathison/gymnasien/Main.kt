package org.mathison.gymnasien

import org.mathison.gymnasien.nrw.NRWExtractionStrategy
import org.mathison.gymnasien.nrw.NRWFetchingStrategy

fun main(args: Array<String>) {

    if (args.size < 1) {

        throw IllegalArgumentException("Bitte ein Bundesland angeben.")

    }

    val scraper =

        when (args.first()) {

            "nrw"   -> Scraper({ NRWFetchingStrategy.apply() }, { document -> NRWExtractionStrategy.apply(document) })
            else    -> throw IllegalArgumentException("Unbekanntes Bundesland: ${args.first()}")

         }

    scraper.apply()

}
