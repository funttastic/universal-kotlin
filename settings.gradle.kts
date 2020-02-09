rootProject.name = "universal_kotlin"

pluginManagement {
	repositories {
		// TODO Fix
		flatDir {
			dirs("plugin")
		}
		mavenLocal()
		gradlePluginPortal()
		mavenCentral()
		jcenter()
		google()
		maven( url = "https://plugins.gradle.org/m2" )
		maven( url = "https://repo.gradle.org/gradle/libs-releases-local" )
		maven( url = "https://dl.bintray.com/kotlin/kotlin-eap" )
		maven( url = "https://dl.bintray.com/kotlin/kotlin-dev" )

		maven( url = "https://dl.bintray.com/salomonbrys/gradle-plugins" )
	}

	resolutionStrategy {
		eachPlugin {
			if (requested.id.id == "kotlin-multiplatform") {
				useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
			}

			if (requested.id.id.startsWith("com.github.salomonbrys.gradle.kotlin.js.")) {
				useModule("com.github.salomonbrys.gradle.kotlin.js:kotlin-js-gradle-utils:1.2.0")
			}
		}
	}
}

enableFeaturePreview("GRADLE_METADATA")

//include("common")
//include("common-multiple_modules")
//include("common-multiple_sources")
//include("common-single_source")
//include("library")
//include("library-multiple_modules")
//include("library-multiple_sources")
//include("library-single_source")
//include("application")
//include("application-backend")
//include("application-backend-js")
//include("application-backend-js-express")
//include("application-backend-jvm")
//include("application-backend-jvm-spring_boot")
//include("application-browser")
//include("application-browser-js")
//include("application-browser-js-spa")
//include("application-browser-js-spa-react")
////include("application-browser-js-vanilla")
//include("application-browser-native")
////include("application-browser-native-wasm32")
//include("application-desktop")
//include("application-desktop-jvm")
//include("application-desktop-jvm-tornado_fx")
//include("application-mobile")
//include("application-mobile-jvm")
////include("application-mobile-jvm-android")
//include("application-mobile-native")
//include("application-mobile-native-apple")
//include("application-mobile-native-apple-ios")
//include("application-mobile-native-apple-ios-ios_x64_without_framework")
//include("application-mobile-native-apple-ios-ios_x64_copying_framework")
//include("application-mobile-native-apple-ios-ios_x64_framework")
//include("application-mobile-native-apple-ios-ios_x64_with_framework")
//include("application-script")
//include("application-script-jvm")
//include("application-script-jvm-script")
//include("application-television")
//include("application-television-native")
//include("application-television-native-apple")
//include("application-television-native-apple-tvos")
//include("application-television-native-apple-tvos-tvos_x64")
//include("application-terminal")
//include("application-terminal-jvm")
//include("application-terminal-jvm-terminal")
//include("application-watch")
//include("application-watch-native")
//include("application-watch-native-apple")
//include("application-watch-native-apple-watchos")
//include("application-watch-native-apple-watchos-watchos_x64")
//include("plugin")
//include("plugin-jvm")
//include("plugin-jvm-gradle")

//project(":common").projectDir = File(rootDir, "common")
//project(":common-multiple_modules").projectDir = File(rootDir, "common/multiple_modules")
//project(":common-multiple_sources").projectDir = File(rootDir, "common/multiple_sources")
//project(":common-single_source").projectDir = File(rootDir, "common/single_source")
//project(":library").projectDir = File(rootDir, "library")
//project(":library-multiple_modules").projectDir = File(rootDir, "library/multiple_modules")
//project(":library-multiple_sources").projectDir = File(rootDir, "library/multiple_sources")
//project(":library-single_source").projectDir = File(rootDir, "library/single_source")
//project(":application").projectDir = File(rootDir, "application")
//project(":application-backend").projectDir = File(rootDir, "application/backend")
//project(":application-backend-js").projectDir = File(rootDir, "application/backend/js")
//project(":application-backend-js-express").projectDir = File(rootDir, "application/backend/js/express")
//project(":application-backend-jvm").projectDir = File(rootDir, "application/backend/jvm")
//project(":application-backend-jvm-spring_boot").projectDir = File(rootDir, "application/backend/jvm/spring_boot")
//project(":application-browser").projectDir = File(rootDir, "application/browser")
//project(":application-browser-js").projectDir = File(rootDir, "application/browser/js")
//project(":application-browser-js-spa").projectDir = File(rootDir, "application/browser/js/spa")
//project(":application-browser-js-spa-react").projectDir = File(rootDir, "application/browser/js/spa/react")
////project(":application-browser-js-vanilla").projectDir = File(rootDir, "application/browser/js/vanilla")
//project(":application-browser-native").projectDir = File(rootDir, "application/browser/native")
////project(":application-browser-native-wasm32").projectDir = File(rootDir, "application/browser/native/wasm32")
//project(":application-desktop").projectDir = File(rootDir, "application/desktop")
//project(":application-desktop-jvm").projectDir = File(rootDir, "application/desktop/jvm")
//project(":application-desktop-jvm-tornado_fx").projectDir = File(rootDir, "application/desktop/jvm/tornado_fx")
//project(":application-mobile").projectDir = File(rootDir, "application/mobile")
//project(":application-mobile-jvm").projectDir = File(rootDir, "application/mobile/jvm")
////project(":application-mobile-jvm-android").projectDir = File(rootDir, "application/mobile/jvm/android")
//project(":application-mobile-native").projectDir = File(rootDir, "application/mobile/native")
//project(":application-mobile-native-apple").projectDir = File(rootDir, "application/mobile/native/apple")
//project(":application-mobile-native-apple-ios").projectDir = File(rootDir, "application/mobile/native/apple/ios")
//project(":application-mobile-native-apple-ios-ios_x64_without_framework").projectDir = File(rootDir, "application/mobile/native/apple/ios/ios_x64_without_framework/WithoutFramework")
//project(":application-mobile-native-apple-ios-ios_x64_copying_framework").projectDir = File(rootDir, "application/mobile/native/apple/ios/ios_x64_copying_framework")
//project(":application-mobile-native-apple-ios-ios_x64_framework").projectDir = File(rootDir, "application/mobile/native/apple/ios/ios_x64_framework/Framework")
//project(":application-mobile-native-apple-ios-ios_x64_with_framework").projectDir = File(rootDir, "application/mobile/native/apple/ios/ios_x64_with_framework/UniversalKotlin")
//project(":application-script").projectDir = File(rootDir, "application/script")
//project(":application-script-jvm").projectDir = File(rootDir, "application/script/jvm")
//project(":application-script-jvm-script").projectDir = File(rootDir, "application/script/jvm/script")
//project(":application-television").projectDir = File(rootDir, "application/television")
//project(":application-television-native").projectDir = File(rootDir, "application/television/native")
//project(":application-television-native-apple").projectDir = File(rootDir, "application/television/native/apple")
//project(":application-television-native-apple-tvos").projectDir = File(rootDir, "application/television/native/apple/tvos")
//project(":application-television-native-apple-tvos-tvos_x64").projectDir = File(rootDir, "application/television/native/apple/tvos/tvos_x64/application")
//project(":application-terminal").projectDir = File(rootDir, "application/terminal")
//project(":application-terminal-jvm").projectDir = File(rootDir, "application/terminal/jvm")
//project(":application-terminal-jvm-terminal").projectDir = File(rootDir, "application/terminal/jvm/terminal")
//project(":application-watch").projectDir = File(rootDir, "application/watch")
//project(":application-watch-native").projectDir = File(rootDir, "application/watch/native")
//project(":application-watch-native-apple").projectDir = File(rootDir, "application/watch/native/apple")
//project(":application-watch-native-apple-watchos").projectDir = File(rootDir, "application/watch/native/apple/watchos")
//project(":application-watch-native-apple-watchos-watchos_x64").projectDir = File(rootDir, "application/television/native/apple/watchos/watchos_x64/application")
//project(":plugin").projectDir = File(rootDir, "plugin")
//project(":plugin-jvm").projectDir = File(rootDir, "plugin/jvm")
//project(":plugin-jvm-gradle").projectDir = File(rootDir, "plugin/jvm/gradle")

include("temporary")
project(":temporary").projectDir = File(rootDir, "temporary")
include("temporary-react")
project(":temporary-react").projectDir = File(rootDir, "temporary/react")
