package com.example.mypet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.naver.maps.map.*
import com.naver.maps.map.util.FusedLocationSource

open class LocationTrackingActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
        private val PERMISSIONS : Array<String> = arrayOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* 네이버 지도 API 관련 */
        val mapFragment = displayMapOnScreen(supportFragmentManager) // 네이버 지도를 화면에 표시
        mapFragment.getMapAsync(this) // 인터페이스 역할을 하는 naverMap 객체를 얻어옴

        // 지도에 현재 위치 추가
        locationSource =
            FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)
    }

    // 네이버 지도 뷰를 생성
    fun displayMapOnScreen(fm : FragmentManager) : MapFragment{
        return fm.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map, it).commit()
            }
    }

    // naverMap 객체가 준비되면 실행 됨
    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        naverMap.locationSource = locationSource
        requestPermissions(PERMISSIONS, LOCATION_PERMISSION_REQUEST_CODE) // 사용자에게 권한을 요청함
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        if (locationSource.onRequestPermissionsResult(requestCode, permissions,
                grantResults)) {
            if (!locationSource.isActivated) { // 권한이 거부 되었다면
                naverMap.locationTrackingMode = LocationTrackingMode.None
                return
            }
            else{ // 권한이 인가되었다면
                naverMap.locationTrackingMode = LocationTrackingMode.Follow
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}