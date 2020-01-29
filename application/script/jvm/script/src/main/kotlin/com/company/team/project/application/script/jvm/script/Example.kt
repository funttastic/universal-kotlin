//// @file:MavenRepository("local", "file:///Users/danilo/.m2/repository/")
////@file:DependsOnMaven("com.company.team.project:library-multiple_sources-jvm:0.0.1")
//DEPS com.company.team.project:library-multiple_sources-jvm:0.0.1
//DEPS com.company.team.project:library-single_source-jvm:0.0.1

package com.company.team.project.application.script.jvm.script

import com.company.team.project.common.single_source.common.formatOutput

/**
 *
 */
fun main() {
	println(exampleValue)
}

/**
 *
 */
// val exampleValue = exampleFunction().toString()
val exampleValue = formatOutput(exampleFunction())

/**
 *
 */
fun exampleFunction(): List<String> {
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
	fun exampleMethod(): List<String> {
		val output = ArrayList<String>()
		output.addAll(com.company.team.project.common.multiple_sources.jvm.exampleFunction())
		output.addAll(com.company.team.project.common.single_source.jvm.common.exampleFunction())
		output.addAll(com.company.team.project.library.multiple_sources.jvm.exampleFunction())
		output.addAll(com.company.team.project.library.single_source.jvm.common.exampleFunction())
		output.add(exampleProperty)

		return output
	}
}
