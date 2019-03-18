# chuanglan-sms-operator
 创蓝sms短信封装模块
 
# How To Use

## 通过maven加载依赖

## 在springboot启动类上引入ChuanglanSms.class

          @SpringBootTest(classes = {ChuanglanSms.class})

## 配置账号和密码

          chuanglan.sms.enabled=true
          com.liumapp.sms.account=youraccount
          com.liumapp.sms.password=yourpassword
          com.liumapp.sms.url=http://smssh1.253.com/msg/send/json

## 使用

         @Autowired
             private SendSmsService sendSmsService;
             @Test
             public void index() {
                 ArrayList<String> list = new ArrayList<>();
                 list.add("1235646456");
                 list.add("1516515615");
                 String string = "【葫芦娃】你的验证码为1234";
                  
                 sendSmsService.sendMsg(list, string,new Date());
             }

## 说明

* list ：手机号码集合，单个发送传一个，多个发送传多个手机号码，必填

* string ：【葫芦娃】您的验证码是：2530，短信内容。长度不能超过536个字符，其中“【葫芦娃】”是签名。必填

* date : 定时发送短信时间,值小于或等于当前时间则立即发送，默认立即发送，选填

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