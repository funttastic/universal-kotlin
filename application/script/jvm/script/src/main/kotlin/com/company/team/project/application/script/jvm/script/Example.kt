@file:DependsOnMaven("org.jline:jline-terminal:3.13.3")
@file:DependsOnMaven("com.company.team.project:library-multiple_sources-jvm:0.0.1")
@file:DependsOnMaven("com.company.team.project:library-single_source-jvm:0.0.1")

// Avoid the error "... is compiled by a pre-release version of Kotlin and cannot be loaded by this version of the compiler"
@file:CompilerOpts("-Xskip-metadata-version-check")

package com.company.team.project.application.script.jvm.script

import DependsOnMaven
import CompilerOpts
import com.company.team.project.common.single_source.common.OutputType.TERMINAL
import com.company.team.project.common.single_source.common.formatOutput
import org.jline.terminal.TerminalBuilder

/**
 *
 */
fun main() {
	println(exampleValue)
}

/**
 *
 */
val exampleValue = formatOutput(exampleFunction(), TERMINAL, TerminalBuilder.terminal().width)

/**
 *
 */
fun exampleFunction(): Set<String> {
	return ExampleObject.exampleMethod()
}

/**
 *
 */
object ExampleObject {

	/**
	 *
	 */
	private val exampleProperty = ExampleObject::class.java.`package`.name

	/**
	 *
	 */
	fun exampleMethod(): Set<String> {
		val output = mutableSetOf<String>()

		output.addAll(com.company.team.project.common.multiple_sources.jvm.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.jvm.common.exampleFunction())
		output.addAll(com.company.team.project.library.multiple_sources.jvm.exampleFunction())
		output.addAll(com.company.team.project.library.single_source.jvm.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
