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

* 请求参数： SmsSendRequest smsSingleRequest = new SmsSendRequest(account, password, msg, phone,report,extend);

* 将请求参数转换成JSON格式： String requestJson = JSON.toJSONString(smsSingleRequest);

* 调用短信发送的方法：  String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

* 获取返回数据： SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

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

* 0	提交成功
* 101:无此用户
* 102:密码错
* 103:提交过快（提交速度超过流速限制）
* 104:系统忙（因平台侧原因，暂时无法处理提交的短信）
* 105:敏感短信（短信内容包含敏感词）
* 106:消息长度错（>536或<=0）
* 107:包含错误的手机号码
* 108:手机号码个数错（群发>1000或<=0）
* 109:无发送额度（该用户可用短信数已使用完）
* 110:不在发送时间内
* 113:扩展码格式错（非数字或者长度不对）
* 114:可用参数组个数错误（小于最小设定值或者大于1000）;变量参数组大于20个
* 116:签名不合法或未带签名（在更换自己的签名需要在平台上报备后方可使用该签名）
* 117:IP地址认证错,请求调用的IP地址不是系统登记的IP地址
* 118:用户没有相应的发送权限（账号被禁止发送）
* 119:用户已过期
* 120:违反防盗用策略(日发送限制)
* 123"发送类型错误
* 124:白模板匹配错误
* 125:匹配驳回模板，提交失败
* 127:定时发送时间格式错误
* 128:内容编码失败
* 129:JSON格式错误
* 130:请求参数错误（缺少必填参数）