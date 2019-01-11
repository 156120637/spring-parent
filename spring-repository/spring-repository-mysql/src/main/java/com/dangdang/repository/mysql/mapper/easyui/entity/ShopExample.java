package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopExample() {
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

        public Criteria andShidIsNull() {
            addCriterion("shid is null");
            return (Criteria) this;
        }

        public Criteria andShidIsNotNull() {
            addCriterion("shid is not null");
            return (Criteria) this;
        }

        public Criteria andShidEqualTo(String value) {
            addCriterion("shid =", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotEqualTo(String value) {
            addCriterion("shid <>", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidGreaterThan(String value) {
            addCriterion("shid >", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidGreaterThanOrEqualTo(String value) {
            addCriterion("shid >=", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLessThan(String value) {
            addCriterion("shid <", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLessThanOrEqualTo(String value) {
            addCriterion("shid <=", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidLike(String value) {
            addCriterion("shid like", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotLike(String value) {
            addCriterion("shid not like", value, "shid");
            return (Criteria) this;
        }

        public Criteria andShidIn(List<String> values) {
            addCriterion("shid in", values, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotIn(List<String> values) {
            addCriterion("shid not in", values, "shid");
            return (Criteria) this;
        }

        public Criteria andShidBetween(String value1, String value2) {
            addCriterion("shid between", value1, value2, "shid");
            return (Criteria) this;
        }

        public Criteria andShidNotBetween(String value1, String value2) {
            addCriterion("shid not between", value1, value2, "shid");
            return (Criteria) this;
        }

        public Criteria andShnameIsNull() {
            addCriterion("shname is null");
            return (Criteria) this;
        }

        public Criteria andShnameIsNotNull() {
            addCriterion("shname is not null");
            return (Criteria) this;
        }

        public Criteria andShnameEqualTo(String value) {
            addCriterion("shname =", value, "shname");
            return (Criteria) this;
        }

        public Criteria andShnameNotEqualTo(String value) {
            addCriterion("shname <>", value, "shname");
            return (Criteria) this;
        }

        public Criteria andShnameGreaterThan(String value) {
            addCriterion("shname >", value, "shname");
            return (Criteria) this;
        }

        public Criteria andShnameGreaterThanOrEqualTo(String value) {
            addCriterion("shname >=", value, "shname");
            return (Criteria) this;
        }

        public Criteria andShnameLessThan(String value) {
            addCriterion("shname <", value, "shname");
            return (Criteria) this;
        }

        public Criteria andShnameLessThanOrEqualTo(String value) {
            addCriterion("shname <=", value, "shname");
            return (Criteria) this;
        }

        public Criteria andShnameLike(String value) {
            addCriterion("shname like", value, "shname");
            return (Criteria) this;
        }

        public Criteria andShnameNotLike(String value) {
            addCriterion("shname not like", value, "shname");
            return (Criteria) this;
        }

        public Criteria andShnameIn(List<String> values) {
            addCriterion("shname in", values, "shname");
            return (Criteria) this;
        }

        public Criteria andShnameNotIn(List<String> values) {
            addCriterion("shname not in", values, "shname");
            return (Criteria) this;
        }

        public Criteria andShnameBetween(String value1, String value2) {
            addCriterion("shname between", value1, value2, "shname");
            return (Criteria) this;
        }

        public Criteria andShnameNotBetween(String value1, String value2) {
            addCriterion("shname not between", value1, value2, "shname");
            return (Criteria) this;
        }

        public Criteria andShcreateIsNull() {
            addCriterion("shcreate is null");
            return (Criteria) this;
        }

        public Criteria andShcreateIsNotNull() {
            addCriterion("shcreate is not null");
            return (Criteria) this;
        }

        public Criteria andShcreateEqualTo(Date value) {
            addCriterion("shcreate =", value, "shcreate");
            return (Criteria) this;
        }

        public Criteria andShcreateNotEqualTo(Date value) {
            addCriterion("shcreate <>", value, "shcreate");
            return (Criteria) this;
        }

        public Criteria andShcreateGreaterThan(Date value) {
            addCriterion("shcreate >", value, "shcreate");
            return (Criteria) this;
        }

        public Criteria andShcreateGreaterThanOrEqualTo(Date value) {
            addCriterion("shcreate >=", value, "shcreate");
            return (Criteria) this;
        }

        public Criteria andShcreateLessThan(Date value) {
            addCriterion("shcreate <", value, "shcreate");
            return (Criteria) this;
        }

        public Criteria andShcreateLessThanOrEqualTo(Date value) {
            addCriterion("shcreate <=", value, "shcreate");
            return (Criteria) this;
        }

        public Criteria andShcreateIn(List<Date> values) {
            addCriterion("shcreate in", values, "shcreate");
            return (Criteria) this;
        }

        public Criteria andShcreateNotIn(List<Date> values) {
            addCriterion("shcreate not in", values, "shcreate");
            return (Criteria) this;
        }

        public Criteria andShcreateBetween(Date value1, Date value2) {
            addCriterion("shcreate between", value1, value2, "shcreate");
            return (Criteria) this;
        }

        public Criteria andShcreateNotBetween(Date value1, Date value2) {
            addCriterion("shcreate not between", value1, value2, "shcreate");
            return (Criteria) this;
        }

        public Criteria andShimageIsNull() {
            addCriterion("shimage is null");
            return (Criteria) this;
        }

        public Criteria andShimageIsNotNull() {
            addCriterion("shimage is not null");
            return (Criteria) this;
        }

        public Criteria andShimageEqualTo(String value) {
            addCriterion("shimage =", value, "shimage");
            return (Criteria) this;
        }

        public Criteria andShimageNotEqualTo(String value) {
            addCriterion("shimage <>", value, "shimage");
            return (Criteria) this;
        }

        public Criteria andShimageGreaterThan(String value) {
            addCriterion("shimage >", value, "shimage");
            return (Criteria) this;
        }

        public Criteria andShimageGreaterThanOrEqualTo(String value) {
            addCriterion("shimage >=", value, "shimage");
            return (Criteria) this;
        }

        public Criteria andShimageLessThan(String value) {
            addCriterion("shimage <", value, "shimage");
            return (Criteria) this;
        }

        public Criteria andShimageLessThanOrEqualTo(String value) {
            addCriterion("shimage <=", value, "shimage");
            return (Criteria) this;
        }

        public Criteria andShimageLike(String value) {
            addCriterion("shimage like", value, "shimage");
            return (Criteria) this;
        }

        public Criteria andShimageNotLike(String value) {
            addCriterion("shimage not like", value, "shimage");
            return (Criteria) this;
        }

        public Criteria andShimageIn(List<String> values) {
            addCriterion("shimage in", values, "shimage");
            return (Criteria) this;
        }

        public Criteria andShimageNotIn(List<String> values) {
            addCriterion("shimage not in", values, "shimage");
            return (Criteria) this;
        }

        public Criteria andShimageBetween(String value1, String value2) {
            addCriterion("shimage between", value1, value2, "shimage");
            return (Criteria) this;
        }

        public Criteria andShimageNotBetween(String value1, String value2) {
            addCriterion("shimage not between", value1, value2, "shimage");
            return (Criteria) this;
        }

        public Criteria andShdescribesIsNull() {
            addCriterion("shdescribes is null");
            return (Criteria) this;
        }

        public Criteria andShdescribesIsNotNull() {
            addCriterion("shdescribes is not null");
            return (Criteria) this;
        }

        public Criteria andShdescribesEqualTo(String value) {
            addCriterion("shdescribes =", value, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShdescribesNotEqualTo(String value) {
            addCriterion("shdescribes <>", value, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShdescribesGreaterThan(String value) {
            addCriterion("shdescribes >", value, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShdescribesGreaterThanOrEqualTo(String value) {
            addCriterion("shdescribes >=", value, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShdescribesLessThan(String value) {
            addCriterion("shdescribes <", value, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShdescribesLessThanOrEqualTo(String value) {
            addCriterion("shdescribes <=", value, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShdescribesLike(String value) {
            addCriterion("shdescribes like", value, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShdescribesNotLike(String value) {
            addCriterion("shdescribes not like", value, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShdescribesIn(List<String> values) {
            addCriterion("shdescribes in", values, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShdescribesNotIn(List<String> values) {
            addCriterion("shdescribes not in", values, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShdescribesBetween(String value1, String value2) {
            addCriterion("shdescribes between", value1, value2, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShdescribesNotBetween(String value1, String value2) {
            addCriterion("shdescribes not between", value1, value2, "shdescribes");
            return (Criteria) this;
        }

        public Criteria andShcontactIsNull() {
            addCriterion("shcontact is null");
            return (Criteria) this;
        }

        public Criteria andShcontactIsNotNull() {
            addCriterion("shcontact is not null");
            return (Criteria) this;
        }

        public Criteria andShcontactEqualTo(String value) {
            addCriterion("shcontact =", value, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShcontactNotEqualTo(String value) {
            addCriterion("shcontact <>", value, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShcontactGreaterThan(String value) {
            addCriterion("shcontact >", value, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShcontactGreaterThanOrEqualTo(String value) {
            addCriterion("shcontact >=", value, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShcontactLessThan(String value) {
            addCriterion("shcontact <", value, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShcontactLessThanOrEqualTo(String value) {
            addCriterion("shcontact <=", value, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShcontactLike(String value) {
            addCriterion("shcontact like", value, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShcontactNotLike(String value) {
            addCriterion("shcontact not like", value, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShcontactIn(List<String> values) {
            addCriterion("shcontact in", values, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShcontactNotIn(List<String> values) {
            addCriterion("shcontact not in", values, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShcontactBetween(String value1, String value2) {
            addCriterion("shcontact between", value1, value2, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShcontactNotBetween(String value1, String value2) {
            addCriterion("shcontact not between", value1, value2, "shcontact");
            return (Criteria) this;
        }

        public Criteria andShroleIsNull() {
            addCriterion("shrole is null");
            return (Criteria) this;
        }

        public Criteria andShroleIsNotNull() {
            addCriterion("shrole is not null");
            return (Criteria) this;
        }

        public Criteria andShroleEqualTo(String value) {
            addCriterion("shrole =", value, "shrole");
            return (Criteria) this;
        }

        public Criteria andShroleNotEqualTo(String value) {
            addCriterion("shrole <>", value, "shrole");
            return (Criteria) this;
        }

        public Criteria andShroleGreaterThan(String value) {
            addCriterion("shrole >", value, "shrole");
            return (Criteria) this;
        }

        public Criteria andShroleGreaterThanOrEqualTo(String value) {
            addCriterion("shrole >=", value, "shrole");
            return (Criteria) this;
        }

        public Criteria andShroleLessThan(String value) {
            addCriterion("shrole <", value, "shrole");
            return (Criteria) this;
        }

        public Criteria andShroleLessThanOrEqualTo(String value) {
            addCriterion("shrole <=", value, "shrole");
            return (Criteria) this;
        }

        public Criteria andShroleLike(String value) {
            addCriterion("shrole like", value, "shrole");
            return (Criteria) this;
        }

        public Criteria andShroleNotLike(String value) {
            addCriterion("shrole not like", value, "shrole");
            return (Criteria) this;
        }

        public Criteria andShroleIn(List<String> values) {
            addCriterion("shrole in", values, "shrole");
            return (Criteria) this;
        }

        public Criteria andShroleNotIn(List<String> values) {
            addCriterion("shrole not in", values, "shrole");
            return (Criteria) this;
        }

        public Criteria andShroleBetween(String value1, String value2) {
            addCriterion("shrole between", value1, value2, "shrole");
            return (Criteria) this;
        }

        public Criteria andShroleNotBetween(String value1, String value2) {
            addCriterion("shrole not between", value1, value2, "shrole");
            return (Criteria) this;
        }

        public Criteria andShaddressIsNull() {
            addCriterion("shaddress is null");
            return (Criteria) this;
        }

        public Criteria andShaddressIsNotNull() {
            addCriterion("shaddress is not null");
            return (Criteria) this;
        }

        public Criteria andShaddressEqualTo(String value) {
            addCriterion("shaddress =", value, "shaddress");
            return (Criteria) this;
        }

        public Criteria andShaddressNotEqualTo(String value) {
            addCriterion("shaddress <>", value, "shaddress");
            return (Criteria) this;
        }

        public Criteria andShaddressGreaterThan(String value) {
            addCriterion("shaddress >", value, "shaddress");
            return (Criteria) this;
        }

        public Criteria andShaddressGreaterThanOrEqualTo(String value) {
            addCriterion("shaddress >=", value, "shaddress");
            return (Criteria) this;
        }

        public Criteria andShaddressLessThan(String value) {
            addCriterion("shaddress <", value, "shaddress");
            return (Criteria) this;
        }

        public Criteria andShaddressLessThanOrEqualTo(String value) {
            addCriterion("shaddress <=", value, "shaddress");
            return (Criteria) this;
        }

        public Criteria andShaddressLike(String value) {
            addCriterion("shaddress like", value, "shaddress");
            return (Criteria) this;
        }

        public Criteria andShaddressNotLike(String value) {
            addCriterion("shaddress not like", value, "shaddress");
            return (Criteria) this;
        }

        public Criteria andShaddressIn(List<String> values) {
            addCriterion("shaddress in", values, "shaddress");
            return (Criteria) this;
        }

        public Criteria andShaddressNotIn(List<String> values) {
            addCriterion("shaddress not in", values, "shaddress");
            return (Criteria) this;
        }

        public Criteria andShaddressBetween(String value1, String value2) {
            addCriterion("shaddress between", value1, value2, "shaddress");
            return (Criteria) this;
        }

        public Criteria andShaddressNotBetween(String value1, String value2) {
            addCriterion("shaddress not between", value1, value2, "shaddress");
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