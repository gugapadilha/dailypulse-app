package com.guga.dailypulse

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform