import com.company.team.project.dsl.model.enum_.*
import com.company.team.project.dsl.model.extension.*

plugins {
	kotlin("multiplatform")
}

kotlin {
	configureTargetAttributes(ModuleEnum.`application-script-jvm-script`)

//	targets.all {
//			compilations.all {
//				tasks[compileKotlinTaskName].kotlinOptions {
//					allWarningsAsErrors = true
//				}
//			}
//	}

//	jvm(TargetEnum.`application-script-jvm-script@jvm`) {
//		withJava()
//	}

	jvm {
		withJava()
	}

	sourceSets {
		configureSourceSet(SourceSetEnum.`application-script-jvm-script@jvm@main`) {
			kotlin.srcDir("src/main/kotlin")
			resources.srcDir("src/main/resources")

			dependencies {
				implementation(kotlin("stdlib-jdk8"))
			}
		}

		configureSourceSet(SourceSetEnum.`application-script-jvm-script@jvm@test`) {
			kotlin.srcDir("src/test/kotlin")
			resources.srcDir("src/test/resources")

			dependencies {
				implementation(kotlin("test"))
				implementation(kotlin("test-junit"))
			}
		}
	}
}
