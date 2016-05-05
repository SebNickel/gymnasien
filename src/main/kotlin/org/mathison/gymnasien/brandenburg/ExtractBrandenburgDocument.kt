package org.mathison.gymnasien.brandenburg

import org.jsoup.nodes.Document
import org.mathison.gymnasien.Gymnasium

object ExtractBrandenburgDocument {

    fun apply(document: Document): Gymnasium {

        val h1 = document.select("h1")

        h1.select("br").prepend("BREAK")

        val name =
            h1
                .text()
                .split(" BREAK")
                .first()

        val emailText =
            document
                .select("a[title=E-Mail]")
                .text()
                .replace("|at|", "@")

        val email =
            if (emailText.isNotBlank())
                emailText
            else
                "???"

        return Gymnasium("Brandenburg", name, email)

    }

}
