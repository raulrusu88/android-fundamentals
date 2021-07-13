package com.example.tutorial

import java.io.Serializable

// If you want to pass this data class to an intent, it needs to be Serializabe as
// we want to be able to parse this class to activities as Intent
data class Person(
        val name: String,
        val age: Int,
        val country: String
) : Serializable