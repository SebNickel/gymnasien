package org.mathison.gymnasien

import org.mathison.gymnasien.badenwuerttemberg.BaWüToCsv
import org.mathison.gymnasien.hessen.HessenToCsv
import org.mathison.gymnasien.berlin.BerlinToCsv
import org.mathison.gymnasien.brandenburg.ScrapeBrandenburg
import org.mathison.gymnasien.hamburg.HHToCsv
import org.mathison.gymnasien.niedersachsen.ScrapeNiedersachsen
import org.mathison.gymnasien.nrw.ScrapeNRW
import org.mathison.gymnasien.rheinlandpfalz.ScrapeRP
import org.mathison.gymnasien.saarland.ScrapeSaarland
import org.mathison.gymnasien.schleswigholstein.ScrapeSH

fun main(args: Array<String>) {

    if (args.size < 1) {

        throw IllegalArgumentException("Bitte ein Bundesland angeben.")

    }

    when (args.first()) {

        // TODO: Allow storing multiple email addresses for any one school.
        "nrw"           -> ScrapeNRW.apply()
        "saarland"      -> ScrapeSaarland.apply()
        "rp"            -> ScrapeRP.apply()
        "brandenburg"   -> ScrapeBrandenburg.apply()
        "niedersachsen" -> ScrapeNiedersachsen.apply()
        "sh"            -> ScrapeSH.apply()
        // TODO: Insert contents of these csvs into the DB.
        "hh"            -> HHToCsv.apply()
        "berlin"        -> BerlinToCsv.appy()
        "hessen"        -> HessenToCsv.appy()
        "bawü"          -> BaWüToCsv.apply()
        else            -> throw IllegalArgumentException("Unbekanntes Bundesland: ${args.first()}")

     }

}
