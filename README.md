# lazybones-sample

This is the sample project for [Lazybones](https://github.com/pledbrook/lazybones).
It consists of Java + Spring Boot + react-redux.

## publish template to Nexus

After fulfilling nexus repos URL and some authorization settings with build.gradle,

```bash
$ ./gradlew publishToNexusAdventCalenderSample
```

That's it.

## create project from template


```bash
$ lazybones create http://{your nexus repo url}/advent-calender-sample-template-{version}.zip {directory name}
```

You need to install lazybones globally in advance.
That's it.
