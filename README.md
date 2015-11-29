# droidtracer-example
A minimal example app showing how to use droidtracer-module.

This is an Android app (in form of an Android Studio project). To run the app:

1) run `make` in `droidtracer/src/main/kernel_module` (but before adapt 
necessary paths in the Makefile, and connect the phone via USB)

2) run `make` in `droidtracer/src/jni/`

3) import the project in Android Studio and run it

In `DroidTracerImpl.java` implement the methof `onEvent()` as you like, and
 change the line with `startInterceptingApp(10051);` to the uid of the app you 
want to intercept.
