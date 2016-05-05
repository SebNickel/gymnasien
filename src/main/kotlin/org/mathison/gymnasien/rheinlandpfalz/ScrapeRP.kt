package org.mathison.gymnasien.rheinlandpfalz

import org.mathison.gymnasien.DatabaseConnection
import org.mathison.gymnasien.Repository

object ScrapeRP {

    private val sql2o = DatabaseConnection.sql2o

    private val repository = Repository(sql2o)

    fun apply() {

        val outterIterator = RPOutterDocumentIterator()

        outterIterator.forEach { outterDocument ->

            val innerIterator = RPInnerDocumentIterator(outterDocument)

            innerIterator.forEach { innerDocument ->

                val gymnasium = ExtractRPInnerDocument.apply(innerDocument)

                println(gymnasium)

                repository.insert(gymnasium)

            }
        }

    }

}