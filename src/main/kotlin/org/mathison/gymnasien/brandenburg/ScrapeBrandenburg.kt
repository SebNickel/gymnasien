package org.mathison.gymnasien.brandenburg

import org.mathison.gymnasien.DatabaseConnection
import org.mathison.gymnasien.FetchDocument
import org.mathison.gymnasien.Repository

object ScrapeBrandenburg {

    private val sql2o = DatabaseConnection.sql2o

    private val repository = Repository(sql2o)

    private val url = "https://www.bildung-brandenburg.de/schulportraets/index.php?id=3&schuljahr=2015&kreis&plz&schulform=4&jahrgangsstufe=0&traeger=0&submit=Suchen"

    private val baseUrl = "https://www.bildung-brandenburg.de/schulportraets/"

    fun apply() {

        System.setProperty("javax.net.ssl.trustStore", "src/main/resources/bildung-brandenburg.de.jks")

        val outterDocument = FetchDocument.fromUrl(url, baseUrl)

        val iterator = BrandenburgDocumentIterator(outterDocument)

        iterator.forEach { document ->

            val gymnasium = ExtractBrandenburgDocument.apply(document)

            println(gymnasium)

            repository.insert(gymnasium)

        }

    }

}
