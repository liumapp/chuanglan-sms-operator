# chuanglan-sms-operator
 创蓝sms短信封装模块
 
# How To Use



响应数据格式：
{"time":"20170410103836",
"msgId":"17041010383624511",
"errorMsg":"",
"code":"0"
}
字段说明：
time：响应时间
msgId：消息id
errorMsg：状态码说明（成功返回空）
code：状态码（详细参考提交响应状态码）

## code状态码说明

* 0 ：发送成功

* 101 ： 无此用户

* 107 ： 包含错误的手机号码