package org.mathison.gymnasien.berlin

import org.mathison.gymnasien.TxtToCsv

object BerlinToCsv {

    private val inputPath = "src/main/resources/berlin_liste.txt"
    private val outputPath = "src/main/resources/berlin.csv"

    fun appy() {

        TxtToCsv.apply(inputPath, outputPath)

    }

}
