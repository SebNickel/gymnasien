package org.mathison.gymnasien.saarland

import org.mathison.gymnasien.DatabaseConnection
import org.mathison.gymnasien.Gymnasium
import org.mathison.gymnasien.Repository

object ScrapeSaarland {

    private val sql2o = DatabaseConnection.sql2o

    private val repository = Repository(sql2o)

    private val iterator = SaarlandDocumentIterator()

    fun apply() {

        val gymnasien = arrayListOf<Gymnasium>()

        iterator.forEach { document ->

            val kreisGymnasien = ExtractSaarlandDocument.apply(document)

            gymnasien.addAll(kreisGymnasien)

        }

        gymnasien.forEach { gymnasium ->

            repository.insert(gymnasium)

        }

    }

}

