package com.application.catsgo.util

import java.util.regex.Pattern

class EmailValidator {
    fun isEmailValid(email: String): Boolean {
        val emailPattern = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")
        val emailMatcher = emailPattern.matcher(email)
        return emailMatcher.find()
    }
}