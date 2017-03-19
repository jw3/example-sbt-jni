package org.github.jw3


import ch.jodersky.jni.nativeLoader

// By adding this annotation, there is no need to call
// System.load("adder0") before accessing native methods.
@nativeLoader("adder0")
class Adder(val base: Int) {
  @native def plus(term: Int): Int // implemented in libadder0.so
}

// The application feels like a pure Scala app.
object Main extends App {
  println((new Adder(0)).plus(1))
}
