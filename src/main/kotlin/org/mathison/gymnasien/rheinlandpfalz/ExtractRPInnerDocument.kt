package org.mathison.gymnasien.rheinlandpfalz

import org.jsoup.nodes.Document
import org.mathison.gymnasien.Gymnasium

object ExtractRPInnerDocument {

    fun apply(innerDocument: Document): Gymnasium {

        val div = innerDocument.select("div#wfqbeResults")

        val name = div.select("h2").text()

        val email =
            div
                .select("td a:matches(\\(at\\))")
                .text()
                .replace("(at)das-hier-loeschen.", "@")

        return Gymnasium("Rheinland Pfalz", name, email)

    }

}
