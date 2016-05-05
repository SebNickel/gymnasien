package org.mathison.gymnasien.rheinlandpfalz

import org.jsoup.nodes.Document
import org.mathison.gymnasien.FetchDocument
import java.util.*

class RPOutterDocumentIterator : Iterator<Document> {

    private val baseUrl = "http://schulen.bildung-rp.de"

    private var nextUrl = "http://schulen.bildung-rp.de/gehezu/startseite/liste.html?tx_wfqbe_pi1%5BSCHART%5D%5B0%5D=GY&tx_wfqbe_pi1%5Bsubmit%5D=Suchen&tx_wfqbe_pi1%5Bshowpage%5D%5B1%5D=1"

    private var nextPageNumber = 1

    override fun next(): Document {

        if (nextPageNumber > 7) {
            throw NoSuchElementException("Do not haz next.")
        }

        val nextDocument = FetchDocument.fromUrl(nextUrl, baseUrl)

        val newNextUrl = nextDocument.select("a[title=Nächste Seite").attr("abs:href")

        nextUrl = newNextUrl

        nextPageNumber++

        return nextDocument

    }

    override fun hasNext() =

        nextPageNumber < 8

}
