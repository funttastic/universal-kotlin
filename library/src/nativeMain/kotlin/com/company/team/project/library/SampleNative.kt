package com.company.team.project.library

actual class Sample {
    actual fun checkMe() = 7
}

actual object Platform {
    actual val name: String = "Native"
}
