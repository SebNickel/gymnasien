package org.mathison.gymnasien.hamburg

import org.mathison.gymnasien.TxtToCsv
import java.io.*

object HHToCsv {

    fun apply() {

        val inputPath = "src/main/resources/hamburg_liste.txt"
        val outputPath = "src/main/resources/hamburg.csv"

        TxtToCsv.apply(inputPath, outputPath)

    }

}
