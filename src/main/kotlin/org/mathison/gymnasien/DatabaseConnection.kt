package org.mathison.gymnasien

import org.sql2o.Sql2o

object DatabaseConnection {

    val url = "jdbc:postgresql://localhost:5432/gymnasien"
    val username = "postgres"
    val password = System.getenv("db_password")

    val sql2o = Sql2o(url, username, password)

}
