package org.mathison.gymnasien.hamburg

import java.io.*

fun main(args: Array<String>) {

    val inputPath = "src/main/resources/hamburg_liste.txt"
    val outputPath = "src/main/resources/hamburg.csv"

    val reader = BufferedReader(InputStreamReader(FileInputStream(inputPath), "CP1252"))
    val writer = BufferedWriter(FileWriter(outputPath))

    val lines = reader.lineSequence()

    lines.forEach { line ->

        when {
            line.contains("@") || line == "???" ->
                writer.write(",$line")
            line.isBlank() ->
                writer.newLine()
            else ->
                writer.write(line)
        }

    }

    writer.close()
    reader.close()

}
