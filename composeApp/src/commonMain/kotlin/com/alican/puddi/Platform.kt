package com.alican.puddi

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform