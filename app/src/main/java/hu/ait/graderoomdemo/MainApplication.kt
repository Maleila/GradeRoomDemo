package hu.ait.graderoomdemo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Application class needs to be registered in Manifest

@HiltAndroidApp
class MainApplication: Application() {
}