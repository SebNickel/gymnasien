package org.mathison.gymnasien.brandenburg

import org.jsoup.nodes.Document
import org.mathison.gymnasien.FetchDocument
import java.util.*

class BrandenburgDocumentIterator(val outterDocument: Document) : Iterator<Document> {

    private val baseUrl = "https://www.bildung-brandenburg.de/schulportraets/"

    private var nextIndex = 0

    private var hasNext = true

    override fun next(): Document {

        if (!hasNext) {
            throw NoSuchElementException("Do not haz next.")
        }

        val tableBody = outterDocument.select("tbody")

        val tableRows = tableBody.select("tr")

        val numRows = tableRows.size

        val nextUrl = tableRows[nextIndex].select("a").attr("abs:href")

        val nextDocument = FetchDocument.fromUrl(nextUrl, baseUrl, 10000)

        if (nextIndex == numRows - 1) {
            hasNext = false
        }

        nextIndex++

        return nextDocument

    }

    override fun hasNext() = hasNext

}
