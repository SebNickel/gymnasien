package org.mathison.gymnasien.nrw

import org.mathison.gymnasien.DatabaseConnection
import org.mathison.gymnasien.Repository

object ScrapeNRW {

    private val sql2o = DatabaseConnection.sql2o

    private val repository = Repository(sql2o)

    fun apply() {

        val document = FetchNRW.apply()

        val gymnasien = ExtractNRW.apply(document)

        gymnasien.forEach { gymnasium ->

            repository.insert(gymnasium)

        }

    }

}
