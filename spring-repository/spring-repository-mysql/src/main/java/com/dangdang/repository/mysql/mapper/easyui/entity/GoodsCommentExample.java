package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsCommentExample() {
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

        public Criteria andGcoidIsNull() {
            addCriterion("gcoid is null");
            return (Criteria) this;
        }

        public Criteria andGcoidIsNotNull() {
            addCriterion("gcoid is not null");
            return (Criteria) this;
        }

        public Criteria andGcoidEqualTo(String value) {
            addCriterion("gcoid =", value, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcoidNotEqualTo(String value) {
            addCriterion("gcoid <>", value, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcoidGreaterThan(String value) {
            addCriterion("gcoid >", value, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcoidGreaterThanOrEqualTo(String value) {
            addCriterion("gcoid >=", value, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcoidLessThan(String value) {
            addCriterion("gcoid <", value, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcoidLessThanOrEqualTo(String value) {
            addCriterion("gcoid <=", value, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcoidLike(String value) {
            addCriterion("gcoid like", value, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcoidNotLike(String value) {
            addCriterion("gcoid not like", value, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcoidIn(List<String> values) {
            addCriterion("gcoid in", values, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcoidNotIn(List<String> values) {
            addCriterion("gcoid not in", values, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcoidBetween(String value1, String value2) {
            addCriterion("gcoid between", value1, value2, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcoidNotBetween(String value1, String value2) {
            addCriterion("gcoid not between", value1, value2, "gcoid");
            return (Criteria) this;
        }

        public Criteria andGcocontentIsNull() {
            addCriterion("gcocontent is null");
            return (Criteria) this;
        }

        public Criteria andGcocontentIsNotNull() {
            addCriterion("gcocontent is not null");
            return (Criteria) this;
        }

        public Criteria andGcocontentEqualTo(String value) {
            addCriterion("gcocontent =", value, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGcocontentNotEqualTo(String value) {
            addCriterion("gcocontent <>", value, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGcocontentGreaterThan(String value) {
            addCriterion("gcocontent >", value, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGcocontentGreaterThanOrEqualTo(String value) {
            addCriterion("gcocontent >=", value, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGcocontentLessThan(String value) {
            addCriterion("gcocontent <", value, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGcocontentLessThanOrEqualTo(String value) {
            addCriterion("gcocontent <=", value, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGcocontentLike(String value) {
            addCriterion("gcocontent like", value, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGcocontentNotLike(String value) {
            addCriterion("gcocontent not like", value, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGcocontentIn(List<String> values) {
            addCriterion("gcocontent in", values, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGcocontentNotIn(List<String> values) {
            addCriterion("gcocontent not in", values, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGcocontentBetween(String value1, String value2) {
            addCriterion("gcocontent between", value1, value2, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGcocontentNotBetween(String value1, String value2) {
            addCriterion("gcocontent not between", value1, value2, "gcocontent");
            return (Criteria) this;
        }

        public Criteria andGccreateIsNull() {
            addCriterion("gccreate is null");
            return (Criteria) this;
        }

        public Criteria andGccreateIsNotNull() {
            addCriterion("gccreate is not null");
            return (Criteria) this;
        }

        public Criteria andGccreateEqualTo(Date value) {
            addCriterion("gccreate =", value, "gccreate");
            return (Criteria) this;
        }

        public Criteria andGccreateNotEqualTo(Date value) {
            addCriterion("gccreate <>", value, "gccreate");
            return (Criteria) this;
        }

        public Criteria andGccreateGreaterThan(Date value) {
            addCriterion("gccreate >", value, "gccreate");
            return (Criteria) this;
        }

        public Criteria andGccreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gccreate >=", value, "gccreate");
            return (Criteria) this;
        }

        public Criteria andGccreateLessThan(Date value) {
            addCriterion("gccreate <", value, "gccreate");
            return (Criteria) this;
        }

        public Criteria andGccreateLessThanOrEqualTo(Date value) {
            addCriterion("gccreate <=", value, "gccreate");
            return (Criteria) this;
        }

        public Criteria andGccreateIn(List<Date> values) {
            addCriterion("gccreate in", values, "gccreate");
            return (Criteria) this;
        }

        public Criteria andGccreateNotIn(List<Date> values) {
            addCriterion("gccreate not in", values, "gccreate");
            return (Criteria) this;
        }

        public Criteria andGccreateBetween(Date value1, Date value2) {
            addCriterion("gccreate between", value1, value2, "gccreate");
            return (Criteria) this;
        }

        public Criteria andGccreateNotBetween(Date value1, Date value2) {
            addCriterion("gccreate not between", value1, value2, "gccreate");
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

        public Criteria andGoodsidIsNull() {
            addCriterion("goodsid is null");
            return (Criteria) this;
        }

        public Criteria andGoodsidIsNotNull() {
            addCriterion("goodsid is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsidEqualTo(String value) {
            addCriterion("goodsid =", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotEqualTo(String value) {
            addCriterion("goodsid <>", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThan(String value) {
            addCriterion("goodsid >", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidGreaterThanOrEqualTo(String value) {
            addCriterion("goodsid >=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThan(String value) {
            addCriterion("goodsid <", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLessThanOrEqualTo(String value) {
            addCriterion("goodsid <=", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidLike(String value) {
            addCriterion("goodsid like", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotLike(String value) {
            addCriterion("goodsid not like", value, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidIn(List<String> values) {
            addCriterion("goodsid in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotIn(List<String> values) {
            addCriterion("goodsid not in", values, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidBetween(String value1, String value2) {
            addCriterion("goodsid between", value1, value2, "goodsid");
            return (Criteria) this;
        }

        public Criteria andGoodsidNotBetween(String value1, String value2) {
            addCriterion("goodsid not between", value1, value2, "goodsid");
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