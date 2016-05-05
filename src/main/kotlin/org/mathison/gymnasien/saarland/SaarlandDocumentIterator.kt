package org.mathison.gymnasien.saarland

import org.jsoup.nodes.Document
import org.mathison.gymnasien.FetchDocument
import java.util.*

class SaarlandDocumentIterator : Iterator<Document> {

    private val baseUrl = "http://www.saarland.de"

    private val urls =
        listOf(
            "http://www.saarland.de/SID-AEF038F8-B14A6AB5/5002.htm",
            "http://www.saarland.de/SID-AEF038F8-B14A6AB5/5197.htm",
            "http://www.saarland.de/SID-AEF038F8-B14A6AB5/5318.htm",
            "http://www.saarland.de/SID-AEF038F8-B14A6AB5/5321.htm",
            "http://www.saarland.de/SID-AEF038F8-B14A6AB5/5323.htm",
            "http://www.saarland.de/SID-AEF038F8-B14A6AB5/5327.htm"
        )

    private var nextIndex = 0

    override fun next(): Document {

        if (nextIndex >= urls.size) {
            throw NoSuchElementException("Do not haz next.")
        }

        val nextUrl = urls[nextIndex]

        val document = FetchDocument.fromUrl(nextUrl, baseUrl)

        nextIndex++

        return document

    }

    override fun hasNext() =

        nextIndex < urls.size


}
