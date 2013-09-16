dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=false
               validationQuery="SELECT 1"
               jdbcInterceptors="ConnectionState"
            }
        }
    }
}
dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}


//def mongoPort = 27017
//def mongoHost = System.getProperty("ORCA_MONGODB_HOST") ? System.getProperty("ORCA_MONGODB_HOST") : (System.getenv("ORCA_MONGODB_HOST") ? System.getenv("ORCA_MONGODB_HOST") : "localhost")
//def mongoDBName = "imemorize-data-service"
//
//// environment specific settings
//environments {
//    development {
//        dataSource {
//            dbCreate = "create-drop"
//            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
//        }
//    }
//    test {
//        grails {
//            mongo {
//                port = mongoPort
//                host = mongoHost
//                databaseName = mongoDBName
//            }
//        }
//        dataSource {
//            dbCreate = "create-drop"
//        }
//    }
////    ci {
////        grails {
////            mongo {
////                host = "bld-testmdb-01"
////                databaseName = "navigation_service_test_ci"
////            }
////        }
////        dataSource {
////            dbCreate = "create-drop"
////        }
////    }
//
//    production {
//        grails {
//            mongo {
//                port = mongoPort
//                host = mongoHost
//                databaseName = mongoDBName
//            }
//        }
//        dataSource {
//            dbCreate = "update"
//        }
//    }
//}