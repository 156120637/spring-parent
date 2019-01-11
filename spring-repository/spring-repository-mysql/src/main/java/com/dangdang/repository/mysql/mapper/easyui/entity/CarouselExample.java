package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarouselExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CarouselExample() {
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

        public Criteria andCaidIsNull() {
            addCriterion("caid is null");
            return (Criteria) this;
        }

        public Criteria andCaidIsNotNull() {
            addCriterion("caid is not null");
            return (Criteria) this;
        }

        public Criteria andCaidEqualTo(String value) {
            addCriterion("caid =", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidNotEqualTo(String value) {
            addCriterion("caid <>", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidGreaterThan(String value) {
            addCriterion("caid >", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidGreaterThanOrEqualTo(String value) {
            addCriterion("caid >=", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidLessThan(String value) {
            addCriterion("caid <", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidLessThanOrEqualTo(String value) {
            addCriterion("caid <=", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidLike(String value) {
            addCriterion("caid like", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidNotLike(String value) {
            addCriterion("caid not like", value, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidIn(List<String> values) {
            addCriterion("caid in", values, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidNotIn(List<String> values) {
            addCriterion("caid not in", values, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidBetween(String value1, String value2) {
            addCriterion("caid between", value1, value2, "caid");
            return (Criteria) this;
        }

        public Criteria andCaidNotBetween(String value1, String value2) {
            addCriterion("caid not between", value1, value2, "caid");
            return (Criteria) this;
        }

        public Criteria andCacreateIsNull() {
            addCriterion("cacreate is null");
            return (Criteria) this;
        }

        public Criteria andCacreateIsNotNull() {
            addCriterion("cacreate is not null");
            return (Criteria) this;
        }

        public Criteria andCacreateEqualTo(Date value) {
            addCriterion("cacreate =", value, "cacreate");
            return (Criteria) this;
        }

        public Criteria andCacreateNotEqualTo(Date value) {
            addCriterion("cacreate <>", value, "cacreate");
            return (Criteria) this;
        }

        public Criteria andCacreateGreaterThan(Date value) {
            addCriterion("cacreate >", value, "cacreate");
            return (Criteria) this;
        }

        public Criteria andCacreateGreaterThanOrEqualTo(Date value) {
            addCriterion("cacreate >=", value, "cacreate");
            return (Criteria) this;
        }

        public Criteria andCacreateLessThan(Date value) {
            addCriterion("cacreate <", value, "cacreate");
            return (Criteria) this;
        }

        public Criteria andCacreateLessThanOrEqualTo(Date value) {
            addCriterion("cacreate <=", value, "cacreate");
            return (Criteria) this;
        }

        public Criteria andCacreateIn(List<Date> values) {
            addCriterion("cacreate in", values, "cacreate");
            return (Criteria) this;
        }

        public Criteria andCacreateNotIn(List<Date> values) {
            addCriterion("cacreate not in", values, "cacreate");
            return (Criteria) this;
        }

        public Criteria andCacreateBetween(Date value1, Date value2) {
            addCriterion("cacreate between", value1, value2, "cacreate");
            return (Criteria) this;
        }

        public Criteria andCacreateNotBetween(Date value1, Date value2) {
            addCriterion("cacreate not between", value1, value2, "cacreate");
            return (Criteria) this;
        }

        public Criteria andCanameIsNull() {
            addCriterion("caname is null");
            return (Criteria) this;
        }

        public Criteria andCanameIsNotNull() {
            addCriterion("caname is not null");
            return (Criteria) this;
        }

        public Criteria andCanameEqualTo(String value) {
            addCriterion("caname =", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotEqualTo(String value) {
            addCriterion("caname <>", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameGreaterThan(String value) {
            addCriterion("caname >", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameGreaterThanOrEqualTo(String value) {
            addCriterion("caname >=", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLessThan(String value) {
            addCriterion("caname <", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLessThanOrEqualTo(String value) {
            addCriterion("caname <=", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameLike(String value) {
            addCriterion("caname like", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotLike(String value) {
            addCriterion("caname not like", value, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameIn(List<String> values) {
            addCriterion("caname in", values, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotIn(List<String> values) {
            addCriterion("caname not in", values, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameBetween(String value1, String value2) {
            addCriterion("caname between", value1, value2, "caname");
            return (Criteria) this;
        }

        public Criteria andCanameNotBetween(String value1, String value2) {
            addCriterion("caname not between", value1, value2, "caname");
            return (Criteria) this;
        }

        public Criteria andCaimageIsNull() {
            addCriterion("caimage is null");
            return (Criteria) this;
        }

        public Criteria andCaimageIsNotNull() {
            addCriterion("caimage is not null");
            return (Criteria) this;
        }

        public Criteria andCaimageEqualTo(String value) {
            addCriterion("caimage =", value, "caimage");
            return (Criteria) this;
        }

        public Criteria andCaimageNotEqualTo(String value) {
            addCriterion("caimage <>", value, "caimage");
            return (Criteria) this;
        }

        public Criteria andCaimageGreaterThan(String value) {
            addCriterion("caimage >", value, "caimage");
            return (Criteria) this;
        }

        public Criteria andCaimageGreaterThanOrEqualTo(String value) {
            addCriterion("caimage >=", value, "caimage");
            return (Criteria) this;
        }

        public Criteria andCaimageLessThan(String value) {
            addCriterion("caimage <", value, "caimage");
            return (Criteria) this;
        }

        public Criteria andCaimageLessThanOrEqualTo(String value) {
            addCriterion("caimage <=", value, "caimage");
            return (Criteria) this;
        }

        public Criteria andCaimageLike(String value) {
            addCriterion("caimage like", value, "caimage");
            return (Criteria) this;
        }

        public Criteria andCaimageNotLike(String value) {
            addCriterion("caimage not like", value, "caimage");
            return (Criteria) this;
        }

        public Criteria andCaimageIn(List<String> values) {
            addCriterion("caimage in", values, "caimage");
            return (Criteria) this;
        }

        public Criteria andCaimageNotIn(List<String> values) {
            addCriterion("caimage not in", values, "caimage");
            return (Criteria) this;
        }

        public Criteria andCaimageBetween(String value1, String value2) {
            addCriterion("caimage between", value1, value2, "caimage");
            return (Criteria) this;
        }

        public Criteria andCaimageNotBetween(String value1, String value2) {
            addCriterion("caimage not between", value1, value2, "caimage");
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