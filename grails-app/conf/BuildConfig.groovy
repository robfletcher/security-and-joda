grails.servlet.version = "2.5"
grails.project.work.dir = 'target'
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolution = {
    inherits "global"
    log "error" 
    checksums true 

    repositories {
        inherits true
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()
    }
    dependencies {
        compile "org.jadira.usertype:usertype.jodatime:1.9"
    }

    plugins {
        runtime ':fields:latest.release'
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"

        compile ':joda-time:latest.release'
        compile ':spring-security-core:latest.release'

        build ":tomcat:$grailsVersion"
        build ':cloud-foundry:latest.release'
    }
}
