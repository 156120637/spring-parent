package com.dangdang.repository.mysql.mapper.easyui.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andAdidIsNull() {
            addCriterion("adid is null");
            return (Criteria) this;
        }

        public Criteria andAdidIsNotNull() {
            addCriterion("adid is not null");
            return (Criteria) this;
        }

        public Criteria andAdidEqualTo(String value) {
            addCriterion("adid =", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidNotEqualTo(String value) {
            addCriterion("adid <>", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidGreaterThan(String value) {
            addCriterion("adid >", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidGreaterThanOrEqualTo(String value) {
            addCriterion("adid >=", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidLessThan(String value) {
            addCriterion("adid <", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidLessThanOrEqualTo(String value) {
            addCriterion("adid <=", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidLike(String value) {
            addCriterion("adid like", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidNotLike(String value) {
            addCriterion("adid not like", value, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidIn(List<String> values) {
            addCriterion("adid in", values, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidNotIn(List<String> values) {
            addCriterion("adid not in", values, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidBetween(String value1, String value2) {
            addCriterion("adid between", value1, value2, "adid");
            return (Criteria) this;
        }

        public Criteria andAdidNotBetween(String value1, String value2) {
            addCriterion("adid not between", value1, value2, "adid");
            return (Criteria) this;
        }

        public Criteria andAdrecnameIsNull() {
            addCriterion("adrecname is null");
            return (Criteria) this;
        }

        public Criteria andAdrecnameIsNotNull() {
            addCriterion("adrecname is not null");
            return (Criteria) this;
        }

        public Criteria andAdrecnameEqualTo(String value) {
            addCriterion("adrecname =", value, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdrecnameNotEqualTo(String value) {
            addCriterion("adrecname <>", value, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdrecnameGreaterThan(String value) {
            addCriterion("adrecname >", value, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdrecnameGreaterThanOrEqualTo(String value) {
            addCriterion("adrecname >=", value, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdrecnameLessThan(String value) {
            addCriterion("adrecname <", value, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdrecnameLessThanOrEqualTo(String value) {
            addCriterion("adrecname <=", value, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdrecnameLike(String value) {
            addCriterion("adrecname like", value, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdrecnameNotLike(String value) {
            addCriterion("adrecname not like", value, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdrecnameIn(List<String> values) {
            addCriterion("adrecname in", values, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdrecnameNotIn(List<String> values) {
            addCriterion("adrecname not in", values, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdrecnameBetween(String value1, String value2) {
            addCriterion("adrecname between", value1, value2, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdrecnameNotBetween(String value1, String value2) {
            addCriterion("adrecname not between", value1, value2, "adrecname");
            return (Criteria) this;
        }

        public Criteria andAdphoneIsNull() {
            addCriterion("adphone is null");
            return (Criteria) this;
        }

        public Criteria andAdphoneIsNotNull() {
            addCriterion("adphone is not null");
            return (Criteria) this;
        }

        public Criteria andAdphoneEqualTo(String value) {
            addCriterion("adphone =", value, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdphoneNotEqualTo(String value) {
            addCriterion("adphone <>", value, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdphoneGreaterThan(String value) {
            addCriterion("adphone >", value, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdphoneGreaterThanOrEqualTo(String value) {
            addCriterion("adphone >=", value, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdphoneLessThan(String value) {
            addCriterion("adphone <", value, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdphoneLessThanOrEqualTo(String value) {
            addCriterion("adphone <=", value, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdphoneLike(String value) {
            addCriterion("adphone like", value, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdphoneNotLike(String value) {
            addCriterion("adphone not like", value, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdphoneIn(List<String> values) {
            addCriterion("adphone in", values, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdphoneNotIn(List<String> values) {
            addCriterion("adphone not in", values, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdphoneBetween(String value1, String value2) {
            addCriterion("adphone between", value1, value2, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdphoneNotBetween(String value1, String value2) {
            addCriterion("adphone not between", value1, value2, "adphone");
            return (Criteria) this;
        }

        public Criteria andAdcodeIsNull() {
            addCriterion("adcode is null");
            return (Criteria) this;
        }

        public Criteria andAdcodeIsNotNull() {
            addCriterion("adcode is not null");
            return (Criteria) this;
        }

        public Criteria andAdcodeEqualTo(String value) {
            addCriterion("adcode =", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeNotEqualTo(String value) {
            addCriterion("adcode <>", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeGreaterThan(String value) {
            addCriterion("adcode >", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeGreaterThanOrEqualTo(String value) {
            addCriterion("adcode >=", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeLessThan(String value) {
            addCriterion("adcode <", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeLessThanOrEqualTo(String value) {
            addCriterion("adcode <=", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeLike(String value) {
            addCriterion("adcode like", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeNotLike(String value) {
            addCriterion("adcode not like", value, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeIn(List<String> values) {
            addCriterion("adcode in", values, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeNotIn(List<String> values) {
            addCriterion("adcode not in", values, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeBetween(String value1, String value2) {
            addCriterion("adcode between", value1, value2, "adcode");
            return (Criteria) this;
        }

        public Criteria andAdcodeNotBetween(String value1, String value2) {
            addCriterion("adcode not between", value1, value2, "adcode");
            return (Criteria) this;
        }

        public Criteria andAddressdetailIsNull() {
            addCriterion("addressdetail is null");
            return (Criteria) this;
        }

        public Criteria andAddressdetailIsNotNull() {
            addCriterion("addressdetail is not null");
            return (Criteria) this;
        }

        public Criteria andAddressdetailEqualTo(String value) {
            addCriterion("addressdetail =", value, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andAddressdetailNotEqualTo(String value) {
            addCriterion("addressdetail <>", value, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andAddressdetailGreaterThan(String value) {
            addCriterion("addressdetail >", value, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andAddressdetailGreaterThanOrEqualTo(String value) {
            addCriterion("addressdetail >=", value, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andAddressdetailLessThan(String value) {
            addCriterion("addressdetail <", value, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andAddressdetailLessThanOrEqualTo(String value) {
            addCriterion("addressdetail <=", value, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andAddressdetailLike(String value) {
            addCriterion("addressdetail like", value, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andAddressdetailNotLike(String value) {
            addCriterion("addressdetail not like", value, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andAddressdetailIn(List<String> values) {
            addCriterion("addressdetail in", values, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andAddressdetailNotIn(List<String> values) {
            addCriterion("addressdetail not in", values, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andAddressdetailBetween(String value1, String value2) {
            addCriterion("addressdetail between", value1, value2, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andAddressdetailNotBetween(String value1, String value2) {
            addCriterion("addressdetail not between", value1, value2, "addressdetail");
            return (Criteria) this;
        }

        public Criteria andCityidIsNull() {
            addCriterion("cityid is null");
            return (Criteria) this;
        }

        public Criteria andCityidIsNotNull() {
            addCriterion("cityid is not null");
            return (Criteria) this;
        }

        public Criteria andCityidEqualTo(String value) {
            addCriterion("cityid =", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotEqualTo(String value) {
            addCriterion("cityid <>", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThan(String value) {
            addCriterion("cityid >", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThanOrEqualTo(String value) {
            addCriterion("cityid >=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThan(String value) {
            addCriterion("cityid <", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThanOrEqualTo(String value) {
            addCriterion("cityid <=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLike(String value) {
            addCriterion("cityid like", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotLike(String value) {
            addCriterion("cityid not like", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidIn(List<String> values) {
            addCriterion("cityid in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotIn(List<String> values) {
            addCriterion("cityid not in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidBetween(String value1, String value2) {
            addCriterion("cityid between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotBetween(String value1, String value2) {
            addCriterion("cityid not between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andAdcreateIsNull() {
            addCriterion("adcreate is null");
            return (Criteria) this;
        }

        public Criteria andAdcreateIsNotNull() {
            addCriterion("adcreate is not null");
            return (Criteria) this;
        }

        public Criteria andAdcreateEqualTo(Date value) {
            addCriterion("adcreate =", value, "adcreate");
            return (Criteria) this;
        }

        public Criteria andAdcreateNotEqualTo(Date value) {
            addCriterion("adcreate <>", value, "adcreate");
            return (Criteria) this;
        }

        public Criteria andAdcreateGreaterThan(Date value) {
            addCriterion("adcreate >", value, "adcreate");
            return (Criteria) this;
        }

        public Criteria andAdcreateGreaterThanOrEqualTo(Date value) {
            addCriterion("adcreate >=", value, "adcreate");
            return (Criteria) this;
        }

        public Criteria andAdcreateLessThan(Date value) {
            addCriterion("adcreate <", value, "adcreate");
            return (Criteria) this;
        }

        public Criteria andAdcreateLessThanOrEqualTo(Date value) {
            addCriterion("adcreate <=", value, "adcreate");
            return (Criteria) this;
        }

        public Criteria andAdcreateIn(List<Date> values) {
            addCriterion("adcreate in", values, "adcreate");
            return (Criteria) this;
        }

        public Criteria andAdcreateNotIn(List<Date> values) {
            addCriterion("adcreate not in", values, "adcreate");
            return (Criteria) this;
        }

        public Criteria andAdcreateBetween(Date value1, Date value2) {
            addCriterion("adcreate between", value1, value2, "adcreate");
            return (Criteria) this;
        }

        public Criteria andAdcreateNotBetween(Date value1, Date value2) {
            addCriterion("adcreate not between", value1, value2, "adcreate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}