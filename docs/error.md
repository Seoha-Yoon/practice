# 에러 모음
### Post 할 때 에러 발생
1. 
```
cannot deserialize from object value 
(no delegate- or property-based creator)
```
* jackson library가 빈 생성자가 없는 모델을 생성하는 법을 모름
* Item 클래스에 NoArgsCostructor 생성


2. 
```
Circular view path [items]: would dispatch back to the current handler URL
```
* Annotation을 @Controller에서 @RestController로 바꿈
* 아니면 @Controller에 @ResponseBody 어노테이션을 추가해도 똑같이 동작한다.
* @Conroller는 View를 반환해주기 위한 어노테이션이다.
* @RestConroller나 (@Controller + @ResponseBody)는 데이터를 반환한다.