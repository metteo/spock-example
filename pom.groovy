project {
  modelVersion '4.0.0'

  groupId 'org.spockframework'
  artifactId 'spock-example'
  version '1.0-SNAPSHOT'

  name 'Spock Framework - Example Project'

  distributionManagement {
    repository {
      id 'foo'
      url 'file:///fake.repository.to.make.maven.happy'
    }
    snapshotRepository {
      id 'bar'
      url 'file:///fake.repository.to.make.maven.happy'
    }
  }

  properties {
    'project.reporting.outputEncoding' 'UTF-8'
    'project.build.sourceEncoding' 'UTF-8'
  }

  dependencies {
    dependency {
      groupId 'org.spockframework'
      artifactId 'spock-core'
      version '1.1-groovy-2.4'
      scope 'test'
    }
    dependency {
      groupId 'org.codehaus.groovy'
      artifactId 'groovy-all'
      version '2.4.13'
    }
    dependency {
      groupId 'net.bytebuddy'
      artifactId 'byte-buddy'
      version '1.6.5'
      scope 'test'
    }
    dependency {
      groupId 'org.objenesis'
      artifactId 'objenesis'
      version '2.5.1'
      scope 'test'
    }
    dependency {
      groupId 'org.hamcrest'
      artifactId 'hamcrest-core'
      version '1.3'
      scope 'test'
    }
    dependency {
      groupId 'com.h2database'
      artifactId 'h2'
      version '1.4.185'
    }
  }

  repositories {
    repository {
      snapshots {
        enabled 'true'
      }
      id 'spock-snapshots'
      url 'https://oss.sonatype.org/content/repositories/snapshots/'
    }
  }

  build {
    plugins {
      plugin {
        groupId 'org.codehaus.gmavenplus'
        artifactId 'gmavenplus-plugin'
        version '1.6'
        executions {
          execution {
            goals {
              goal 'compile'
              goal 'compileTests'
            }
          }
        }
      }
      plugin {
        artifactId 'maven-surefire-plugin'
        version '2.20.1'
        configuration {
          useFile 'false'
          includes {
            include '**/*Spec.java'
          }
        }
      }
      plugin {
        artifactId 'maven-deploy-plugin'
        version '2.8.2'
        configuration {
          skip 'true'
        }
      }
    }
  }
}

