package org.mathison.gymnasien.niedersachsen

import org.jsoup.nodes.Document
import org.mathison.gymnasien.FetchDocument
import java.util.*

class NiedersachsenDocumentIterator(val outterDocument: Document) : Iterator<Document> {

    private val baseUrl = "http://schulnetz.nibis.de/db/schulen/"

    private var hasNext = true

    private var nextIndex = 1 // Index 0 points to a header cell. We skip it.

    override fun next(): Document {

        if (!hasNext) {
            throw NoSuchElementException("Do not haz next.")
        }

        val schulInfoAnchors = outterDocument.select("A:has(img[title=Schul-Info])") // What's with the uppercase A?

        val numCells = schulInfoAnchors.size

        val nextUrl = schulInfoAnchors[nextIndex].attr("abs:href")

        val nextDocument = FetchDocument.fromUrl(nextUrl, baseUrl)

        if (nextIndex == numCells - 1) {
            hasNext = false
        }

        nextIndex++

        return nextDocument

    }

    override fun hasNext() = hasNext

}
