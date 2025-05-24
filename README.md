# spring-vote-21st
ceos back-end 21st vote project
___
### git convention

#### commit
- **feat** : 새로운 기능 추가
- **fix** : 기능 수정
- **refactor**: 기능 수정/변화 없음, but 코드 수정 있음
- **docs**: 문서(.md) 추가 및 수정
- **chore**: 환경설정

#### issue template
<img src="https://velog.velcdn.com/images/mirupio/post/aa3ff64e-c0ae-4b22-a85d-2a418ae1be74/image.png" width="400"/><br>
<img src="https://velog.velcdn.com/images/mirupio/post/906d7999-d8fd-47f2-9b1f-a3d178b220ff/image.png" width="350"/>
<img src="https://velog.velcdn.com/images/mirupio/post/4edf17f5-87c5-4eab-b5d9-6fb7212e402d/image.png" width="350"/>
<img src="https://velog.velcdn.com/images/mirupio/post/6f67b51a-b414-4ba0-aab9-7b455701ce16/image.png" width="350"/>

#### pr template
<img src="https://velog.velcdn.com/images/mirupio/post/a55f8057-f4f1-4de3-8977-f9219d2a7d37/image.png" width="350"/>

#### branch 전략
- **main**: 배포 브랜치 (항상 안정 상태 유지)
- **dev**: 통합 개발 브랜치
- **feature/{이슈번호}-{설명}**: 단위 기능 브랜치
___
### 개발 스타일 맞추기
#### 폴더 구조
- 도메인별로 폴더 분리, 계층 분리
- 공통 설정/도구는 global에 정리
#### 파일명, 변수명 convention
- **클래스** : PascalCase
  ex) UserService, OrderDto
- **메서드/변수** : camelCase
  ex) userId, createdAt
- **패키지** : 소문자 단어 연결
  ex) user, order, config
- **DTO** : RequestDto, ResponseDto 접미어
  ex) user, order, config
#### response format, exception 관리 등등


#### 주석 형식
https://creativevista.tistory.com/entry/Java%EC%9E%90%EB%B0%94-%EC%A3%BC%EC%84%9D

<img src="https://velog.velcdn.com/images/mirupio/post/039b2aaf-8e27-4761-a344-c632e238447e/image.png" width="330"/>

