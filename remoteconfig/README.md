# RemoteConfig

## 원격 구성

간단한 플래그 등으로 배포 없이 UI 등을 제어하려 하거나,   
A/B 테스트 등에 이용할 수 있음   

## 제한사항

- SDK 17 이전에는 60분당 5회 제한이었지만 최신버전에선 조금 더 허용함
- 개발단계에서는 최솟값을 낮게 설정할 수 있음
- 기본 최솟값은 12시간
* 최솟값 우선순위: 
    * fetch(long) 매개변수
    * FirebaseConfigSettings.minimumFetchIntervalInSeconds 설정 값
    * 기본값 12시간

https://firebase.google.com/docs/remote-config/get-started?platform=android&authuser=0&hl=ko#throttling

## 구성 로딩 전략

- 로드시 가져와 활성화
- 로딩 화면 뒤에서 활성화
- 다음 시작시 새 값 로드

***사용자가 화면을 보고 있을때 UI를 변경하지 않는게 중요함***

https://firebase.google.com/docs/remote-config/loading?authuser=0&hl=ko