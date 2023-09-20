pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs"){
            library("core","androidx.core:core-ktx:1.9.0")
            library("appcompat","androidx.appcompat:appcompat:1.6.1")
            library("material","com.google.android.material:material:1.9.0")
            library("constraintlayout","androidx.constraintlayout:constraintlayout:2.1.4")
            library("volley","com.android.volley:volley:1.2.1")
            library("picasso","com.squareup.picasso:picasso:2.8")
        }
    }
}

rootProject.name = "My Application"
include(":app")
include(":newlibrary")
include(":characterdetails")
