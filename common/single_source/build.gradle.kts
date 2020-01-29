import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*
import com.github.salomonbrys.gradle.kotlin.js.jstests.node.Engine.Companion.mocha
import groovy.util.Node


plugins {
	kotlin("multiplatform")
	id("maven-publish")
	id("signing")

	id("com.github.salomonbrys.gradle.kotlin.js.mpp-tests.node")
}

kotlin {
	configureTargetAttributes(ModuleEnum.`common-multiple_sources`)

//	targets.all {
//			compilations.all {
//				tasks[compileKotlinTaskName].kotlinOptions {
//					allWarningsAsErrors = true
//				}
//			}
//	}

//	android(TargetEnum.`common-single_source@android`) {
//	}

	androidNativeArm32(TargetEnum.`common-single_source@android_native_arm32`) {
	}

	androidNativeArm64(TargetEnum.`common-single_source@android_native_arm64`) {
	}

	iosArm32(TargetEnum.`common-single_source@ios_arm32`) {
		binaries {
			framework {}
		}
	}

	iosArm64(TargetEnum.`common-single_source@ios_arm64`) {
		binaries {
			framework {}
		}
	}

	iosX64(TargetEnum.`common-single_source@ios_x64`) {
		binaries {
			framework {}
		}
	}

	js(TargetEnum.`common-single_source@js`) {
		kotlinJsNodeTests {
			thisTarget {
				engine = mocha
			}
		}

		configure(listOf(compilations[CompilationEnum.main.id!!], compilations[CompilationEnum.test.id!!])) {
			tasks.getByName(compileKotlinTaskName) {
				kotlinOptions {
//					languageVersion = "1.3"
					metaInfo = true
					sourceMap = true
					sourceMapEmbedSources = "always"
					moduleKind = "umd"
				}
			}
		}

		configure(listOf(compilations[CompilationEnum.main.id!!])) {
			tasks.getByName(compileKotlinTaskName) {
				kotlinOptions {
//					outputFile = "${project.buildDir.path}/js/${project.name}.js"
					main = "call"
				}
			}
		}
	}

	jvm(TargetEnum.`common-single_source@jvm`) {
	}

	linuxArm32Hfp(TargetEnum.`common-single_source@linux_arm32_hfp`) {
	}

	linuxMips32(TargetEnum.`common-single_source@linux_mips32`) {
	}

	linuxMipsel32(TargetEnum.`common-single_source@linux_mipsel32`) {
	}

	linuxX64(TargetEnum.`common-single_source@linux_x64`) {
	}

	macosX64(TargetEnum.`common-single_source@macos_x64`) {
	}

	mingwX64(TargetEnum.`common-single_source@mingw_x64`) {
	}

	wasm32(TargetEnum.`common-single_source@wasm32`) {
	}

	sourceSets {
		all {
			val sourceSetEnum =
				when (name) {
					SourceSetEnum.`common-single_source@common@main`.kotlinId -> SourceSetEnum.`common-single_source@common@main`
					SourceSetEnum.`common-single_source@common@test`.kotlinId -> SourceSetEnum.`common-single_source@common@test`
					else -> SourceSetEnum.getByKotlinIdAndModule(name, ModuleEnum.`common-single_source`)!!
				}

			if (CompilationEnum.main == sourceSetEnum.compilation) {
				kotlin.setSrcDirs(listOf(getMainSourcesPath(sourceSetEnum)))
				resources.setSrcDirs(listOf(getMainResourcesPath(sourceSetEnum)))
			} else if (CompilationEnum.test == sourceSetEnum.compilation) {
				kotlin.setSrcDirs(listOf(getTestSourcesPath(sourceSetEnum)))
				resources.setSrcDirs(listOf(getTestResourcesPath(sourceSetEnum)))
			}

			println("${"common-ss".padEnd(20)}${name.padEnd(20)}${sourceSetEnum.name.padEnd(50)}${kotlin.getSrcDirs()}")

//			languageSettings {
//				progressiveMode = true
//			}
		}

		configureSourceSet(SourceSetEnum.`common-single_source@common@main`) {
			kotlin.srcDir("src/main/kotlin/com/company/team/project/common/single_source/js/common")
			resources.srcDir("src/main/kotlin/com/company/team/project/common/single_source/js/common")
			dependencies {
				implementation(kotlin("stdlib-common"))
			}

//			languageSettings {
//				languageVersion = "1.3" // possible values: "1.0", "1.1", "1.2", "1.3"
//				apiVersion = "1.3" // possible values: "1.0", "1.1", "1.2", "1.3"
//				enableLanguageFeature("InlineClasses") // language feature name
//				useExperimentalAnnotation("kotlin.ExperimentalUnsignedTypes") // annotation FQ-name
//				progressiveMode = true // false by default
//			}
		}

		configureSourceSet(SourceSetEnum.`common-single_source@common@test`) {
			dependencies {
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}

//		configureSourceSet(SourceSetEnum.`common-single_source@android@main`) {
//		}
//
//		configureSourceSet(SourceSetEnum.`common-single_source@android@test`) {
//		}

		configureSourceSet(SourceSetEnum.`common-single_source@android_native_arm32@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@android_native_arm32@test`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@android_native_arm64@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@android_native_arm64@test`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@ios_arm32@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@ios_arm32@test`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@ios_arm64@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@ios_arm64@test`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@ios_x64@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@ios_x64@test`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@js@main`) {
			dependencies {
				implementation(kotlin("stdlib-js"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-single_source@js@test`) {
			dependencies {
				implementation(kotlin("test-js"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-single_source@jvm@main`) {
			dependencies {
				implementation(kotlin("stdlib-jdk8"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-single_source@jvm@test`) {
			dependencies {
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}

		configureSourceSet(SourceSetEnum.`common-single_source@linux_arm32_hfp@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@linux_arm32_hfp@test`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@linux_mips32@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@linux_mips32@test`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@linux_mipsel32@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@linux_mipsel32@test`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@linux_x64@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@linux_x64@test`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@macos_x64@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@macos_x64@test`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@mingw_x64@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@mingw_x64@test`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@wasm32@main`) {
		}

		configureSourceSet(SourceSetEnum.`common-single_source@wasm32@test`) {
		}
	}
}

configurations {
	val compileClasspath by creating {
	}
}

fun getPath(sourceTypeEnum: SourceTypeEnum, compilationEnum: CompilationEnum, sourceSetEnum: SourceSetEnum): String {
	var output = "src/${compilationEnum.id!!}/${sourceTypeEnum.id!!}"

	if (SourceTypeEnum.kotlin == sourceTypeEnum) {
		output += "/${project.module.group!!.replace(".", "/")}/${project.module.path}"
	}

	if (sourceSetEnum.target?.preset?.name != null) {
		output += "/" + sourceSetEnum.target?.preset?.name
	}

	output += "/common"

	return output
}

fun getSourcesPath(compilationEnum: CompilationEnum, sourceSetEnum: SourceSetEnum): String {
	return getPath(SourceTypeEnum.kotlin, compilationEnum, sourceSetEnum)
}

fun getResourcesPath(compilationEnum: CompilationEnum, sourceSetEnum: SourceSetEnum): String {
	return getPath(SourceTypeEnum.resources, compilationEnum, sourceSetEnum)
}

fun getMainSourcesPath(sourceSetEnum: SourceSetEnum): String {
	return getSourcesPath(CompilationEnum.main, sourceSetEnum)
}

fun getTestSourcesPath(sourceSetEnum: SourceSetEnum): String {
	return getSourcesPath(CompilationEnum.test, sourceSetEnum)
}

fun getMainResourcesPath(sourceSetEnum: SourceSetEnum): String {
	return getResourcesPath(CompilationEnum.main, sourceSetEnum)
}

fun getTestResourcesPath(sourceSetEnum: SourceSetEnum): String {
	return getResourcesPath(CompilationEnum.test, sourceSetEnum)
}

publishing {
    repositories {
       mavenLocal()
    }
}

// Add a Javadoc JAR to each publication as required by Maven Central

val javadocJar by tasks.creating(Jar::class) {
    archiveClassifier.value("javadoc")
    // TODO: instead of a single empty Javadoc JAR, generate real documentation for each module
}

publishing {
    publications.withType<MavenPublication>().all {
        artifact(javadocJar)
    }
}

//// The root publication also needs a sources JAR as it does not have one by default

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.value("sources")
}

publishing.publications.withType<MavenPublication>().getByName("kotlinMultiplatform").artifact(sourcesJar)

//// Customize the POMs adding the content required by Maven Central

fun customizeForMavenCentral(pom: org.gradle.api.publish.maven.MavenPom) = pom.withXml {
    fun Node.add(key: String, value: String) {
        appendNode(key).setValue(value)
    }

    fun Node.node(key: String, content: Node.() -> Unit) {
        appendNode(key).also(content)
    }

    asNode().run {
        add("description", "Universal Kotlin common using a single source folder.")
        add("name", "Single Source Common - Universal Kotlin")
        add("url", "https://github.com/funttastic/universal_kotlin")
        node("organization") {
            add("name", "com.github.funttastic")
            add("url", "https://github.com/funttastic")
        }
        node("issueManagement") {
            add("system", "github")
            add("url", "https://github.com/funttastic/universal_kotlin/issues")
        }
        node("licenses") {
            node("license") {
                add("name", "MIT")
                add("url", "https://github.com/funttastic/universal_kotlin/blob/master/license.md")
                add("distribution", "repo")
            }
        }
        node("scm") {
            add("url", "https://github.com/funttastic/universal_kotlin")
            add("connection", "scm:git:git://github.com/funttastic/universal_kotlin.git")
            add("developerConnection", "scm:git:ssh://github.com/funttastic/universal_kotlin.git")
        }
        node("developers") {
            node("developer") {
                add("name", "funttastic")
            }
        }
    }
}

publishing {
    publications.withType<MavenPublication>().all {
        customizeForMavenCentral(pom)
    }
}

//// Sign the publications:

////// Also requires that signing.keyId, signing.password, and signing.secretKeyRingFile are provided as Gradle
////// properties.

////// No complex signing configuration is required here, as the signing plugin interoperates with maven-publish
////// and can simply add the signature files directly to the publications:

// publishing {
//     publications.withType<MavenPublication>().all {
//         signing.sign(this@all)
//     }
// }
