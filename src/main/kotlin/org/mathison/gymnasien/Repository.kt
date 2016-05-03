package org.mathison.gymnasien

import org.sql2o.Sql2o

class Repository(private val sql2o: Sql2o) {

    fun insert(gymnasium: Gymnasium) {

        val conn = sql2o.open()

        val query = conn.createQuery("""
            INSERT INTO gymnasien (bundesland, name, email)
            VALUES (:bundesland, :name, :email)
        """)
            .bind(gymnasium)

        query.executeUpdate()

        conn.close()

    }

    fun delete(gymnasium: Gymnasium) {

        val conn = sql2o.open()

        val query = conn.createQuery("""
            DELETE FROM gymnasien
            WHERE bundesland = :bundesland
            AND name = :name
            AND email = :email
        """)
            .bind(gymnasium)

        query.executeUpdate()

        conn.close()

    }

}