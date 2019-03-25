# chuanglan-sms-operator
 创蓝sms短信封装模块
 
# How To Use

## 通过maven加载依赖



## 说明
        协议：http
        提交方式：post
        编码格式：UTF_8
        Content_Type:application/json
        请求说明：以JSON内容为提交请求格式
        
## 配置文件配置

    配置一个sms-config.yml的配置文件,必须以sms-config.yml命名
    com:
      liumapp:
        sms:
          host: 'https://smssh1.253.com'
          account: 'this is account'
          password: 'this is password'

## 一、普通短信发送

### https地址

https://smssh1.253.com/msg/send/json

### 请求参数
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
         
### 返回参数说明
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
         
         
## 二、变量短信发送

### https地址
https: ：https://smssh1.253.com/msg/variable/json

### 请求参数说明
        {"account":"N6000001",
        "password":"123456",
        "msg":"【葫芦娃】您的验证码是：{$var}",
        "params":"15800000000,1234;13800000000,4321",
        "sendtime":"201704101400",
        "report":"true",
        "extend":"555",
        "uid":"321abc"
        }
        字段说明
        account：创蓝API账号，必填
        password：创蓝API密码，必填
        msg：短信内容。长度不能超过536个字符，其中“【葫芦娃】”是签名。必填
        params：手机号码和变量参数，多组参数使用英文分号;区分，必填
        sendtime：定时发送短信时间。格式为yyyyMMddHHmm，值小于或等于当前时间则立即发送，默认立即发送，选填
        report：是否需要状态报告（默认false），如需状态报告则
        
### 返回参数说明
        {"failNum":"0",
        "time":"20170410103836",
        "successNum":"1",
        "msgId":"17041010383624511",
        "errorMsg":"",
        "code":"0"
        }
        字段说明：
        failNum：失败条数
        time：响应时间
        successNum：成功条数
        msgId：消息id
        errorMsg：状态码说明（成功返回空）
        code：状态码（详细参考提交响应状态码）
        

## 三、查询账号余额

### https地址：
https://smssh1.253.com/msg/balance/json

### 请求参数说明
        {"account":"N6000001",
        "password":"123456"
        }
        字段说明
        account：创蓝API账号，必填
        password：创蓝API密码，必填
        
### 响应参数说明
        成功响应数据格式：
        {"balance":"2530",
        "time":"20170410103836",
        "errorMsg":"",
        "code":0
        }
        字段说明：
        code：状态码（详细参考提交响应状态码）
        balance：剩余可用余额条数
        errorMsg：状态码说明（成功返回空）
        time：响应时间
        
        失败响应数据格式：
        {"time":"20170410103836",
        "msgId":"",
        "errorMsg":"请求参数错误",
        "code":"130"
        }
        
 
## 四、查询上行短信

###  https地址
https://smssh1.253.com/msg/pull/mo

### 请求参数说明
        {"account":"N6000001",
        "password":"123456",
        "count":"20"
        }
        字段说明
        account：用户账号，必填
        password：用户密码，必填
        count：拉取个数（最大100，默认20），选填
### 返回参数说明
        响应数据格式：
        {"ret": 0,
        "result": [{
        "spCode": "1069058419637252493",
        "moTime": "1704151325",
        "messageContent": "短信收到谢谢！",
        "destCode": "1069058419637252493",
        "mobile": "15821842837"
        }]}
        字段说明：
        ret：请求状态。0成功，其他状态为失败
        result：上行明细结果，没结果则返回空数组
        spCode：平台通道码
        moTime：上行时间，格式yyMMddHHmm，其中yy=年份的最后两位（00-99）
        messageContent：上行内容
        descCode：运营商通道码
        mobile：上行手机号码
        
        失败响应数据格式：
        {"ret": 1,
        "error":"账号和密码不能为空"
        }
        error：请求错误描述
        

## 五、查询状态报告

### https地址
https://smssh1.253.com/msg/pull/report

### 请求参数说明
          {"account":"N6000001",
          "password":"123456",
          "count":"20"
          }
          字段说明
          account：用户账号，必填
          password：用户密码，必填
          count：拉取个数（最大100，默认20），选填
      
### 返回参数说明
          响应数据格式：
          {"ret":0,
          "result":[{
          "uid":"125",
          "statusDesc":"被叫挂断、超时未接、关机、停机、欠费、手机号码错误导致失败。",
          "notifyTime":"190117160742",
          "mobile":"15300000000",
          "length":"1",
          "msgId":"19011716074111111",
          "reportTime":"1901171607",
          "status":"UNDELIV"}]}
          字段说明：
          ret：请求状态。0成功，其他状态为失败
          result：状态明细结果，没结果则返回空数组
          uid：用户在提交该短信时提交的uid参数，未提交则无该参数
          reportTime：状态更新时间，格式yyMMddHHmm，其中yy=年份的最后两位（00-99）
          


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



