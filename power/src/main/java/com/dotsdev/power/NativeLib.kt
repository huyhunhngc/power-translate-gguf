package com.dotsdev.power

class NativeLib {

    /**
     * A native method that is implemented by the 'power' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'power' library on application startup.
        init {
            System.loadLibrary("power")
        }
    }
}