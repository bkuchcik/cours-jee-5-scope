rootProject.name = "cours-jee-5-scope"

include("scope-java", "scope-kotlin")
includeIfExists(projectName = "tp-display-quote-v3-java")
includeIfExists(projectName = "tp-display-quote-v3-kotlin")

fun includeIfExists(projectName: String) {
    if (file(projectName).exists()) {
        include(projectName)
    }
}
