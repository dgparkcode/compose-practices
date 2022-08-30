package com.dgparkcode.firebase.remoteconfig

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

class MainActivity : AppCompatActivity() {

    private lateinit var remoteConfig: FirebaseRemoteConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        remoteConfig = Firebase.remoteConfig

        // 새로운 매개변수를 갱신하기 위한 텀 조절
        val configSettings = remoteConfigSettings {
            // 기본 3600초(1시간)
            // 개발시에만 0
            minimumFetchIntervalInSeconds = 0
        }
        // 원격 구성 싱글톤 객체 가져오기
        remoteConfig.setConfigSettingsAsync(configSettings)

        // 인앱 매개변수 기본값 설정
        // remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)

        // 가져오기, 활성화 별도 메소드 존재함
        // remoteConfig.fetch()
        // remoteConfig.activate()

        // 가져오기 후 활성화
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // task.result: 최초, 매개변수 변경시에만 true
                    Toast.makeText(
                        this,
                        "updated:${task.result}, data:${remoteConfig.getString("text")}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                }
            }
    }

}