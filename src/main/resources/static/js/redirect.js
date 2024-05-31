// 假设你的后端接口地址是 "/api/redirect"
const apiUrl = "/cloak/redirect";

// 函数用于解析URL查询参数
function getQueryParams() {
    const params = {};
    const queryString = window.location.search.substring(1);
    const regex = /([^&=]+)=([^&]*)/g;
    let m;

    while (m = regex.exec(queryString)) {
        params[decodeURIComponent(m[1])] = decodeURIComponent(m[2]);
    }

    return params;
}

// 获取当前页面的URL查询参数
const queryParams = getQueryParams();

// 配置请求参数，包括headers和body
const fetchOptions = {
    method: 'POST', // 修改为适合你后端接口的请求方法
    headers: {
        'Content-Type': 'application/json',
        // 添加其他需要的headers
    },
    body: JSON.stringify({
        queryParams: queryParams, // 将URL查询参数作为请求体的一部分发送
        // 添加其他需要通过body发送的信息
    })
};

// 使用 Fetch API 从后端获取重定向地址
fetch(apiUrl, fetchOptions).then(response => {
    if (response.ok) {
        return response.json();
    }
    throw new Error('Network response was not ok.');
}).then(data => {
    // 假设后端返回的JSON对象中包含重定向的URL
    window.location.href = data.data.url;
}).catch(error => {
    console.error('There has been a problem with your fetch operation:', error);
});