package org.mathison.gymnasien.schleswigholstein

import org.jsoup.nodes.Document
import org.mathison.gymnasien.Gymnasium

object ExtractSHDocument {

    fun apply(document: Document): Gymnasium {

        val name =
            document
                .select("tr:has(td:matches(Name))")
                .select("td")[1]
                .text()

        val email =
            document
                .select("tr:has(td:matches(EMail))")
                .select("td")[1]
                .text()

        return Gymnasium("Schleswig-Holstein", name, email)

    }

}
