package org.mathison.gymnasien.rheinlandpfalz

import org.jsoup.nodes.Document
import org.mathison.gymnasien.FetchDocument
import java.util.*

class RPInnerDocumentIterator(private val outterDocument: Document) : Iterator<Document> {

    private val baseUrl = "http://schulen.bildung-rp.de/"

    private var hasNext = true

    private var nextIndex = 1 // Index 0 is the header row of the table. We skip it.

    override fun next(): Document {

        if (!hasNext) {
            throw NoSuchElementException("Do not haz next.")
        }

        val tableBody = outterDocument.select("tbody")

        val tableRows = tableBody.select("tr")

        val numRows = tableRows.size

        val nextTableRow = tableRows[nextIndex]

        val nextUrl = nextTableRow.select("td a").attr("abs:href")

        val nextDocument = FetchDocument.fromUrl(nextUrl, baseUrl)

        if (nextIndex == numRows - 2) { // I don't understand why Jsoup counts one more table row than I do.
                                        // But anyway, this works throughout.
            hasNext = false

        }

        nextIndex++

        return nextDocument

    }

    override fun hasNext() = hasNext

}
