import org.apache.commons.io.FileUtils
import org.apache.commons.io.filefilter.FileFilterUtils

@Grab(group='org.slf4j', module='slf4j-simple', version='1.7.21')
@Grab(group="uk.co.cacoethes", module="groovy-handlebars-engine", version="0.2")
import uk.co.cacoethes.handlebars.HandlebarsTemplateEngine

// Use mustache based engine
registerDefaultEngine new HandlebarsTemplateEngine()

// set binding
def props = [:]
props.groupId = ask("Define value for 'groupId' [default: com.linecorp.sample]: ", "com.linecorp.sample", "groupId")
props.version = ask("Define value for 'version' [default: 1.0.0]: ", "1.0.0", "version")
props.artifactId = ask("Define value for 'artifactId' [default: sample-project]: ", "sample-project", "artifactId")
props.package = ask("Define value for 'package' [default: com.linecorp.sample.common]: ", "com.linecorp.sample.common", "package")

processTemplates "settings.gradle", props
processTemplates "**/*.java", props
processTemplates "**/*.groovy", props
processTemplates "**/*.xml", props
processTemplates "**/*.yml", props
processTemplates "**/*.properties", props
processTemplates "**/*.txt", props
processTemplates "static/package.json", props

// make new project tree
def packageDirectoryStructure = props.package.replace('.', '/')

def targetDir = projectDir.path
def originalMainDir = new File("${targetDir}/src/main/java")
def originalTestDir = new File("${targetDir}/src/test/groovy")
def destMainDir = new File("${targetDir}/src/main/java/${packageDirectoryStructure}")
def destTestDir = new File("${targetDir}/src/test/groovy/${packageDirectoryStructure}")

def moveFiles(File originalDir, File destDir) {
    def iterator = FileUtils.iterateFilesAndDirs(originalDir,
                                                 FileFilterUtils.trueFileFilter(),
                                                 FileFilterUtils.trueFileFilter())
    while (iterator.hasNext()) {
        def f = iterator.next()
        if (f.equals(originalDir)) {
            continue
        }
        if (f.exists()) {
            println("moving: " + f.toString())
            FileUtils.moveToDirectory(f, destDir, true)
        }
    }
}

moveFiles(originalMainDir, destMainDir)
moveFiles(originalTestDir, destTestDir)
