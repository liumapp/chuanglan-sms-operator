# chuanglan-sms-operator
 创蓝sms短信封装模块
 
# How To Use

## 通过maven加载依赖

## 请求参数
         {"account":"N6000001",
         "password":"123456",
         "msg":"【葫芦娃】您的验证码是：2530",
         "phone":"15800000000",
         "sendtime":"201704101400",
         "report":"true",
         "extend":"555",
         "uid":"321abc"
         }
         字段说明
         account：创蓝API账号，必填
         password：创蓝API密码，必填
         msg：短信内容。长度不能超过536个字符，其中“【葫芦娃】”是签名。必填
         phone：手机号码。多个手机号码使用英文逗号分隔，必填
         sendtime：定时发送短信时间。格式为yyyyMMddHHmm，值小于或等于当前时间则立即发送，默认立即发送，选填
         report：是否需要状态报告（默认false），如需状态报告则传true，选填
         extend：下发短信号码扩展码，纯数字，建议1-3位，选填
         uid：该条短信在您业务系统内的ID，如订单号或者短信发送记录流水号，选填
         
## 具体使用

* 调用请求类 SmsSendRequest smsSingleRequest = new SmsSendRequest(account, password, msg, phone,report,extend);

* 将请求参数转换成JSON格式 String requestJson = JSON.toJSONString(smsSingleRequest);

* 调用短信发送的方法  String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

* 再将返回值转成String SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

## 注意事项 

* 请求参数需要以JSON的格式提交

* 调用短信发送方法的时候需要传两个参数，一个是请求地址，一个是封装成JSON格式的参数

* 请求参数msg需要传入你的签名

## 响应数据格式：
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