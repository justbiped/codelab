plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "codelab"
include("automator")
include("automator:processor")
findProject(":automator:processor")?.name = "processor"
include("automator:core")
findProject(":automator:core")?.name = "core"
