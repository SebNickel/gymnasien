package org.mathison.gymnasien

import org.jsoup.nodes.Document

class Scraper(val fetchingStrategy: () -> Document,
              val extractionStrategy: (Document) -> List<Gymnasium>) {

    private val sql2o = DatabaseConnection.sql2o

    private val repository = Repository(sql2o)

    fun apply() {

        val document = fetchingStrategy()

        val gymnasien = extractionStrategy(document)

        gymnasien.forEach { gymnasium ->

            repository.insert(gymnasium)

        }

    }

}
