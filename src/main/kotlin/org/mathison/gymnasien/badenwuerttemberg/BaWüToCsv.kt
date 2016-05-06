package org.mathison.gymnasien.badenwuerttemberg

import org.mathison.gymnasien.TxtToCsv

object BaWüToCsv {

    private val inputPath = "src/main/resources/baden_württemberg_liste.txt"
    private val outputPath = "src/main/resources/baden_württemberg.csv"

    fun apply() {

        TxtToCsv.apply(inputPath, outputPath)

    }

}
