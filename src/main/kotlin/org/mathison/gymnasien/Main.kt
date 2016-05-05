package org.mathison.gymnasien

import org.mathison.gymnasien.Hessen.HessenToCsv
import org.mathison.gymnasien.berlin.BerlinToCsv
import org.mathison.gymnasien.hamburg.HHToCsv
import org.mathison.gymnasien.nrw.ScrapeNRW
import org.mathison.gymnasien.rheinlandpfalz.ScrapeRP
import org.mathison.gymnasien.saarland.ScrapeSaarland

fun main(args: Array<String>) {

    if (args.size < 1) {

        throw IllegalArgumentException("Bitte ein Bundesland angeben.")

    }

    when (args.first()) {

        // TODO: Allow storing multiple email addresses for any one school.
        "nrw"       -> ScrapeNRW.apply()
        "saarland"  -> ScrapeSaarland.apply()
        "rp"        -> ScrapeRP.apply()
        // TODO: Insert contents of these csvs into the DB.
        "hh"        -> HHToCsv.apply()
        "berlin"    -> BerlinToCsv.appy()
        "hessen"    -> HessenToCsv.appy()
        else        -> throw IllegalArgumentException("Unbekanntes Bundesland: ${args.first()}")

     }

}
