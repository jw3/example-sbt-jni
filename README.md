example from `Canonical Use` instructions from https://github.com/jodersky/sbt-jni#canonical-use

### run
1. sbt javah
2. sbt nativeCompile
3. sbt core/run

### notes
- the nativeInit command didnt want to run from the command line as `sbt nativeInit cmake`
  - had to sbt cli, change project to native, `nativeInit cmake`
