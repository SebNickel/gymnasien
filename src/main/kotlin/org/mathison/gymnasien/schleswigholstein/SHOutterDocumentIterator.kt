package org.mathison.gymnasien.schleswigholstein

import org.jsoup.nodes.Document
import org.mathison.gymnasien.FetchDocument
import java.io.File
import java.util.*

class SHOutterDocumentIterator : Iterator<Document> {

    private val baseUrl = "http://schulportraets.schleswig-holstein.de/portal/schule_suchen/"

    private var nextIndex = 1

    private var hasNext = true

    override fun next(): Document {

        if (!hasNext) {
            throw NoSuchElementException("Do not haz next.")
        }

        val nextInputPath = "src/main/resources/schleswig-holstein_outterdocument${nextIndex}.html"

        val nextOutterDocumentFile = File(nextInputPath)

        val nextOutterDocument = FetchDocument.fromFile(nextOutterDocumentFile, baseUrl)

        if (nextIndex == 5) {
            hasNext = false
        }

        nextIndex++

        return nextOutterDocument

    }

    override fun hasNext() = hasNext

}
