package org.mathison.gymnasien.schleswigholstein

import org.jsoup.nodes.Document
import org.mathison.gymnasien.FetchDocument
import java.util.*

class SHInnerDocumentIterator(val outterDocument: Document) : Iterator<Document> {

    private var nextIndex = 0

    private var hasNext = true

    override fun next(): Document {

        if (!hasNext) {
            throw NoSuchElementException("Do not haz next.")
        }

        val tableRows =
            outterDocument
                .select("tbody")
                .select("tr")

        val numRows = tableRows.size

        val nextIntermediateUrl =
            tableRows[nextIndex]
                .select("a")
                .first()
                .attr("abs:href")

        val intermediateDocument = FetchDocument.fromUrl(nextIntermediateUrl, nextIntermediateUrl)

        val nextUrl =
            intermediateDocument
                .select("a:matches(Link)")
                .attr("abs:href")

        val nextDocument = FetchDocument.fromUrl(nextUrl, nextUrl)

        if (nextIndex == numRows - 1) {
            hasNext = false
        }

        nextIndex++

        return nextDocument

    }

    override fun hasNext() = hasNext

}
