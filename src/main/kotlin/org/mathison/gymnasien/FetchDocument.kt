package org.mathison.gymnasien

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File

object FetchDocument {

    fun fromUrl(url: String,
                baseUrl: String,
                timeout: Int = 3000): Document {

        val connection = Jsoup.connect(url).timeout(timeout)

        val html = connection.get().html()

        val document = Jsoup.parse(html, baseUrl)

        return document

    }

    fun fromFile(file: File,
                 baseUrl: String): Document {

        val document = Jsoup.parse(file, "CP1252", baseUrl)

        return document

    }

}
