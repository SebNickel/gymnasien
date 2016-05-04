package org.mathison.gymnasien

import org.mathison.gymnasien.nrw.ScrapeNRW

fun main(args: Array<String>) {

    if (args.size < 1) {

        throw IllegalArgumentException("Bitte ein Bundesland angeben.")

    }

    when (args.first()) {

        "nrw"   -> ScrapeNRW.apply()
        else    -> throw IllegalArgumentException("Unbekanntes Bundesland: ${args.first()}")

     }

}
