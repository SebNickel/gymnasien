package org.mathison.gymnasien.niedersachsen

import org.jsoup.nodes.Document
import org.mathison.gymnasien.Gymnasium

object ExtractNiedersachsenDocument {

    fun apply(document: Document): Gymnasium {

        val name =
            document
                .select("tr:has(td:matches(Schule:))")
                .select("td")[1].text()

        val emailRow =
            document
                .select("tr:has(td:matches(E-Mail:))")

        val email =
            if (emailRow.isEmpty()) {
                "???"
            }
            else {
                emailRow
                    .select("td")[1].text()
            }

        return Gymnasium("Niedersachsen", name, email)

    }

}
