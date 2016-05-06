package org.mathison.gymnasien.niedersachsen

import org.mathison.gymnasien.DatabaseConnection
import org.mathison.gymnasien.FetchDocument
import org.mathison.gymnasien.Repository
import java.io.File

object ScrapeNiedersachsen {

    private val sql2o = DatabaseConnection.sql2o

    private val repository = Repository(sql2o)

    private val baseUrl = "http://schulnetz.nibis.de/db/schulen/"

    fun apply() {

        val outterDocumentFile = File("src/main/resources/niedersachsen_outterdocument.html")

        val outterDocument = FetchDocument.fromFile(outterDocumentFile, baseUrl)

        println(outterDocument)

        val iterator = NiedersachsenDocumentIterator(outterDocument)

        iterator.forEach { document ->

            val gymnasium = ExtractNiedersachsenDocument.apply(document)

            println(gymnasium)

            repository.insert(gymnasium)

        }
    }

}
