package org.mathison.gymnasien.Hessen

import org.mathison.gymnasien.TxtToCsv

object HessenToCsv {

    private val inputPath = "src/main/resources/hessen_liste.txt"
    private val outputPath = "src/main/resources/hessen.csv"

    fun appy() {

        TxtToCsv.apply(inputPath, outputPath)

    }

}
