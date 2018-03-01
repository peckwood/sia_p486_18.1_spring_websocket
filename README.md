### How to Run

Just run and homepage will guide you

### How to use WebJars as static resources

1. download the jar, for jQuery, it is `<groupId>org.webjars.bower</groupId><artifactId>jquery</artifactId>`

2. map paths to jars, in Spring, in method `addResourceHandlers` of `WebConfig`
```java
registry
	.addResourceHandler("/webjars/**")
	.addResourceLocations("classpath:/META-INF/resources/webjars/");
```

3. This is because `jquery.min.js`'s path inside jquery-2.0.3.jar is `/META-INF/resources/webjars/jquery/2.0.3/jquery.min.js`
4. In Thymeleaf, import the JS file: `<script th:src="@{/webjars/jquery/2.0.3/jquery.min.js}"></script>`

### How to add SockJS for supporting older browser of WebSocket
1. In Spring, add `.withSockJS()` to WebSocketHandler
2. in html, import `sockjs.min.js`
3. In Thymeleaf, change from
```javascript
var contextPath = [[@{/}]];
var url = 'ws://' + window.location.host + contextPath +'macro';
var sock = new WebSocket(url);
```
to
```javascript
var contextPath = [[@{/}]];
var sock = new SockJS(contextPath +'macro');
```
