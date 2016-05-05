package org.mathison.gymnasien

import java.io.*

object TxtToCsv {

    fun apply(inputPath: String,
              outputPath: String) {

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

}
