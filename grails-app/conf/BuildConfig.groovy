grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.target.level = 1.6
//grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]
if (System.getProperty('grails.env') == 'development'){
    server.port=9900
}
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    //legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        mavenRepo 'http://alm-build:8080/nexus/content/groups/public'
        mavenRepo 'http://alm-build:8080/nexus/content/groups/public-snapshots'

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        compile 'org.codehaus.groovy.modules.http-builder:http-builder:0.6', { excludes 'groovy'}
        test "org.spockframework:spock-grails-support:0.7-groovy-2.0"

        // runtime 'mysql:mysql-connector-java:5.1.22'
    }

    plugins {
        build ":tomcat:$grailsVersion"

        runtime ":hibernate:$grailsVersion"
        runtime ":resources:1.1.6"

        //runtime ":database-migration:1.3.2"

        //runtime ":jquery:1.8.3"
        //runtime ":resources:1.2"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        runtime ":zipped-resources:1.0"
        runtime ":cached-resources:1.0"
        runtime ":yui-minify-resources:0.1.5"


        test ':code-coverage:1.2.5'
        test ':codenarc:0.17'
        test ':gmetrics:0.3.1'

        test ':spock:0.7'
        //test    'com.rallydev.plugins.grails:orca-test-support:1.0'

        compile 'org.grails.plugins:cors:1.0.3.1'

        //compile ':cache:1.0.1'
        compile ':functional-spock:0.6', { transitive = false }
        //compile 'com.rallydev.plugins.grails:orca-service-framework:1.6.3-SNAPSHOT'

        compile 'com.rallydev.plugins.grails:rally-rest-json-api:1.6'
        //compile 'com.rallydev.plugins.grails:deployr:2.5.1'
        //compile 'com.rallydev.plugins.grails:grails-rally-metrics-plugin:1.2'
        compile 'com.rallydev.plugins.grails:rally-mongo-query-plugin:1.3'
        compile 'com.rallydev.plugins.grails:grails-json-render-support-plugin:0.4'
        compile 'com.rallydev.plugins.grails:mongo-migrations:1.1'

    }
}

coverage {
    enabledByDefault = false
    xml = true
}

