package org.mathison.gymnasien.saarland

import org.jsoup.nodes.Document
import org.mathison.gymnasien.Gymnasium

object ExtractSaarlandDocument {

    fun apply(document: Document): List<Gymnasium> {

        val boxDivs = document.select("div.boxpadding10")

        val gymnasien = boxDivs.map { boxDiv ->

            val name = boxDiv.select("h2").text()

            val emailAnchors = boxDiv.select("div.link_email a")

            val email =
                if (emailAnchors.isEmpty())

                    "???"

                else {

                    val text = emailAnchors.text()

                    if (!text.contains("@")) {

                        println("$name: $text")

                        "???"

                    }
                    else {

                        text
                            .split(" ")
                            .filter { it.contains("@") }
                            .first()

                    }

                }

            Gymnasium("Saarland", name, email)

        }

        return gymnasien

    }

}
