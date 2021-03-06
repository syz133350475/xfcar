package com.xfcar.driver.model.bean;

public class IntegralGoodsOrderDTO {
	public int id; // 主键ID
	public String delFlag; // 删除状态：0-正常，1-删除
	public String goodsInfo; // 订单中商品信息
	public String orderSn; // 订单编号，以igo开头
	public String payTime; // 支付时间
	public String pageSize; // 页码（默认10）
	public String paymentType; // 支付方式 1-支付宝 2-微信 3-银行卡
	public int orderStatus; //  订单状态，-1为已经取消，此时不归还用户积分, 0为已提交未付款，20为付款成功，30为已发货，40为已收货完成
	public String pageNumber; // 页数（默认1）
	public int totalIntegral; // 总共消费积分
	public float transFee; // 购物车运费
	public int userId; // 订单用户
	public String createDate; // 创建时间
	public int updateBy; // 修改人
	public String updateDate; // 修改时间
}
