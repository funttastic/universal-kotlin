package com.company.team.project.common

import kotlin.test.Test
import kotlin.test.assertEquals

class CommonJvmGreetingTests {

	@Test
	fun testCommonJsMain() {
		assertEquals("${common()}|commonJvm", commonJvm())
	}
}
