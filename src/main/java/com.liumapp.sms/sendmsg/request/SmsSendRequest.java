package com.liumapp.sms.sendmsg.request;
/**
 *
 * @Description:普通短信发送实体类
 */
public class SmsSendRequest {
	/**
	 * 创蓝API账号，必填
	 */
	private String account;
	/**
	 * 创蓝API密码，必填
	 */
	private String password;
	/**
	 * 短信内容。长度不能超过536个字符，必填
	 */
	private String msg;
	/**
	 * 手机号码。多个手机号码使用英文逗号分隔，必填
	 */
	private String phone;
	
	
	/**
	 * 定时发送短信时间。格式为yyyyMMddHHmm，值小于或等于当前时间则立即发送，默认立即发送，选填
	 */
	private String sendtime;
	/**
	 * 是否需要状态报告（默认false），选填
	 */
	private String report;
	/**
	 * 下发短信号码扩展码，纯数字，建议1-3位，选填
	 */
	private String extend;
	/**
	 * 该条短信在您业务系统内的ID，如订单号或者短信发送记录流水号，选填
	 */
	private String uid;
	
	public SmsSendRequest() {
		
	}
	

	public SmsSendRequest(String account, String password, String msg, String phone, String sendtime,String report,String uid) {
		super();
		this.account = account;
		this.password = password;
		this.msg = msg;
		this.phone = phone;
		this.sendtime=sendtime;
		this.report=report;
		this.uid=uid;
	}
	public String getAccount() {
		return account;
	}
	public SmsSendRequest setAccount(String account) {
		this.account = account;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public SmsSendRequest setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getMsg() {
		return msg;
	}
	public SmsSendRequest setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public String getPhone() {
		return phone;
	}
	public SmsSendRequest setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public String getSendtime() {
		return sendtime;
	}
	public SmsSendRequest setSendtime(String sendtime) {
		this.sendtime = sendtime;
		return this;
	}
	public String getReport() {
		return report;
	}
	public SmsSendRequest setReport(String report) {
		this.report = report;
		return this;
	}
	public String getExtend() {
		return extend;
	}
	public SmsSendRequest setExtend(String extend) {
		this.extend = extend;
		return this;
	}
	public String getUid() {
		return uid;
	}
	public SmsSendRequest setUid(String uid) {
		this.uid = uid;
		return this;
	}
	
	
}
