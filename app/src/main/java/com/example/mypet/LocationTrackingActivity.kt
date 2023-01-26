package com.example.mypet

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.util.FusedLocationSource
import com.naver.maps.map.util.MarkerIcons

open class LocationTrackingActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var locationSource: FusedLocationSource // 위치 반환
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
        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)
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
        naverMap.maxZoom = 18.0 // zoom max/min 제한
        naverMap.minZoom = 10.0
        naverMap.locationTrackingMode = LocationTrackingMode.Follow
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
            else{ // 권한이 허용되었다면
                naverMap.locationTrackingMode = LocationTrackingMode.Follow
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    // 네이버 지도에 마커를 표시
    fun createMarkerOnMap(lat : Double, log : Double, label : String) {
        val marker = Marker()
        marker.position = LatLng(lat, log) // 마커의 좌표 설정
        // 마커의 색상 설정
        marker.icon = MarkerIcons.BLACK
        marker.iconTintColor = Color.RED
        marker.map = naverMap
        // 마커의 라벨 설정
        marker.captionText = label
    }
}