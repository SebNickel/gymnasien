package org.mathison.gymnasien.schleswigholstein

import org.mathison.gymnasien.DatabaseConnection
import org.mathison.gymnasien.FetchDocument
import org.mathison.gymnasien.Repository
import java.io.File

object ScrapeSH {

    private val sql2o = DatabaseConnection.sql2o

    private val repository = Repository(sql2o)

    fun apply() {

        val outterIterator = SHOutterDocumentIterator()

        outterIterator.forEach { outterDocument ->

            val innerIterator = SHInnerDocumentIterator(outterDocument)

            innerIterator.forEach { innerDocument ->

                val gymnasium = ExtractSHDocument.apply(innerDocument)

                println(gymnasium)

                repository.insert(gymnasium)

            }

        }

    }

}
