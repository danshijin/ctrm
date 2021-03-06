
package com.smm.ctrm.domain.Physical;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smm.ctrm.domain.HibernateEntity;
import com.smm.ctrm.domain.Basis.Broker;
import com.smm.ctrm.domain.Basis.Commodity;
import com.smm.ctrm.domain.Basis.Market;
import com.smm.ctrm.domain.Basis.User;

@Entity
@Table(name = "Margin", schema = "Physical")

public class Margin extends HibernateEntity {
	private static final long serialVersionUID = 1461832991343L;
	/**
	 * 保证金计算基准, 按金额的百分比 on amount = A, 按每吨多少钱 on quantity = Q (Dict)
	 */
	@Column(name = "Basis", length = 1)
	@JsonProperty(value = "Basis")
	private String Basis;
	/**
	 * 保证金计算费率
	 */
	@Column(name = "Rate")
	@JsonProperty(value = "Rate")
	private BigDecimal Rate;
	/**
	 * IM授信额度
	 */
	@Column(name = "IMCredit")
	@JsonProperty(value = "IMCredit")
	private BigDecimal IMCredit;
	/**
	 * VM授信额度
	 */
	@Column(name = "VMCredit")
	@JsonProperty(value = "VMCredit")
	private BigDecimal VMCredit;
	/**
	 * 备注
	 */
	@Column(name = "Comments", length = 2000)
	@JsonProperty(value = "Comments")
	private String Comments;
	/**
	 * 经纪商标识
	 */
	@Column(name = "BrokerId")
	@JsonProperty(value = "BrokerId")
	private String BrokerId;
	// @JsonBackReference("Margin_Broker")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Broker.class)
	@JoinColumn(name = "BrokerId", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonProperty(value = "Broker")
	private Broker Broker;
	/**
	 * 商品品种
	 */
	@Column(name = "CommodityId")
	@JsonProperty(value = "CommodityId")
	private String CommodityId;
	// @JsonBackReference("Margin_Commodity")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Commodity.class)
	@JoinColumn(name = "CommodityId", insertable = false, updatable = false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonProperty(value = "Commodity")
	private Commodity Commodity;
	/**
	 * 交易市场
	 */
	@Column(name = "MarketId")
	@JsonProperty(value = "MarketId")
	private String MarketId;
	// @JsonBackReference("Margin_Market")
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Market.class)
	@JoinColumn(name = "MarketId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "none"))
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonProperty(value = "Market")
	private Market Market;
	/**
	 * 创建者Id
	 */
	@Column(name = "CreatedId")
	@JsonProperty(value = "CreatedId")
	private String CreatedId;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "CreatedId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "none"))
	@Fetch(FetchMode.SELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonProperty(value = "Created")
	private User Created;
	/**
	 * 更新者Id
	 */
	@Column(name = "UpdatedId")
	@JsonProperty(value = "UpdatedId")
	private String UpdatedId;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "UpdatedId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "none"))
	@Fetch(FetchMode.SELECT)
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonProperty(value = "Updated")
	private User Updated;

	public String getBasis() {
		return Basis;
	}

	public void setBasis(String Basis) {
		this.Basis = Basis;
	}

	public BigDecimal getRate() {
		return Rate;
	}

	public void setRate(BigDecimal Rate) {
		this.Rate = Rate;
	}

	public BigDecimal getIMCredit() {
		return IMCredit;
	}

	public void setIMCredit(BigDecimal IMCredit) {
		this.IMCredit = IMCredit;
	}

	public BigDecimal getVMCredit() {
		return VMCredit;
	}

	public void setVMCredit(BigDecimal VMCredit) {
		this.VMCredit = VMCredit;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String Comments) {
		this.Comments = Comments;
	}

	public String getBrokerId() {
		return BrokerId;
	}

	public void setBrokerId(String BrokerId) {
		this.BrokerId = BrokerId;
	}

	public Broker getBroker() {
		return Broker;
	}

	public void setBroker(Broker Broker) {
		this.Broker = Broker;
	}

	public String getCommodityId() {
		return CommodityId;
	}

	public void setCommodityId(String CommodityId) {
		this.CommodityId = CommodityId;
	}

	public Commodity getCommodity() {
		return Commodity;
	}

	public void setCommodity(Commodity Commodity) {
		this.Commodity = Commodity;
	}

	public String getMarketId() {
		return MarketId;
	}

	public void setMarketId(String MarketId) {
		this.MarketId = MarketId;
	}

	public Market getMarket() {
		return Market;
	}

	public void setMarket(Market Market) {
		this.Market = Market;
	}

	public String getCreatedId() {
		return CreatedId;
	}

	public void setCreatedId(String CreatedId) {
		this.CreatedId = CreatedId;
	}

	public User getCreated() {
		return Created;
	}

	public void setCreated(User Created) {
		this.Created = Created;
	}

	public String getUpdatedId() {
		return UpdatedId;
	}

	public void setUpdatedId(String UpdatedId) {
		this.UpdatedId = UpdatedId;
	}

	public User getUpdated() {
		return Updated;
	}

	public void setUpdated(User Updated) {
		this.Updated = Updated;
	}

}