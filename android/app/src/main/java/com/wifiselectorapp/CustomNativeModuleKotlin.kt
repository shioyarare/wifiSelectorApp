// ご自身のパッケージ名
package com.wifiselectorapp;
import android.os.Build
import com.facebook.react.bridge.*

// ReactContextBaseJavaModuleを継承している点がポイント
class CustomNativeModuleKotlin(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    // getNameは必須で、JavaScriptから呼ぶ際のModule名になる
    override fun getName(): String {
        return "CustomNativeModuleKotlin"
    }

    // 出力するだけのメソッド
    @ReactMethod
    fun funcSimple() {
        print("funcSimple")
    }

    // callbackメソッド
    @ReactMethod
    fun funcCallback(callback: Callback) {
        callback.invoke("funcCallback")
    }

    // 引数を取るcallbackメソッド
    @ReactMethod
    fun funcCallbackWithParams(param: String?, callback: Callback) {
        callback.invoke("funcCallbackWithParams", param)
    }

    // Promise resolveパターンのメソッド
    @ReactMethod
    fun funcResolvePromise(promise: Promise) {
        promise.resolve("funcResolvePromise")
    }

    // Promise rejectパターンのメソッド
    @ReactMethod
    fun funcRejectPromise(promise: Promise) {
        promise.reject("error", "funcRejectPromise")
    }

    // 実用例: OSのバージョンを返すメソッド
    @ReactMethod
    fun getOSInfo(callback: Callback) {
        callback.invoke("android", Build.VERSION.RELEASE)
    }
}