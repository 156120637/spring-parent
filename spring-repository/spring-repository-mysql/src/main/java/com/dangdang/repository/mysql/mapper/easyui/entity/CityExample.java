package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.List;

public class CityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CityExample() {
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

        public Criteria andCiidIsNull() {
            addCriterion("ciid is null");
            return (Criteria) this;
        }

        public Criteria andCiidIsNotNull() {
            addCriterion("ciid is not null");
            return (Criteria) this;
        }

        public Criteria andCiidEqualTo(String value) {
            addCriterion("ciid =", value, "ciid");
            return (Criteria) this;
        }

        public Criteria andCiidNotEqualTo(String value) {
            addCriterion("ciid <>", value, "ciid");
            return (Criteria) this;
        }

        public Criteria andCiidGreaterThan(String value) {
            addCriterion("ciid >", value, "ciid");
            return (Criteria) this;
        }

        public Criteria andCiidGreaterThanOrEqualTo(String value) {
            addCriterion("ciid >=", value, "ciid");
            return (Criteria) this;
        }

        public Criteria andCiidLessThan(String value) {
            addCriterion("ciid <", value, "ciid");
            return (Criteria) this;
        }

        public Criteria andCiidLessThanOrEqualTo(String value) {
            addCriterion("ciid <=", value, "ciid");
            return (Criteria) this;
        }

        public Criteria andCiidLike(String value) {
            addCriterion("ciid like", value, "ciid");
            return (Criteria) this;
        }

        public Criteria andCiidNotLike(String value) {
            addCriterion("ciid not like", value, "ciid");
            return (Criteria) this;
        }

        public Criteria andCiidIn(List<String> values) {
            addCriterion("ciid in", values, "ciid");
            return (Criteria) this;
        }

        public Criteria andCiidNotIn(List<String> values) {
            addCriterion("ciid not in", values, "ciid");
            return (Criteria) this;
        }

        public Criteria andCiidBetween(String value1, String value2) {
            addCriterion("ciid between", value1, value2, "ciid");
            return (Criteria) this;
        }

        public Criteria andCiidNotBetween(String value1, String value2) {
            addCriterion("ciid not between", value1, value2, "ciid");
            return (Criteria) this;
        }

        public Criteria andCinameIsNull() {
            addCriterion("ciname is null");
            return (Criteria) this;
        }

        public Criteria andCinameIsNotNull() {
            addCriterion("ciname is not null");
            return (Criteria) this;
        }

        public Criteria andCinameEqualTo(String value) {
            addCriterion("ciname =", value, "ciname");
            return (Criteria) this;
        }

        public Criteria andCinameNotEqualTo(String value) {
            addCriterion("ciname <>", value, "ciname");
            return (Criteria) this;
        }

        public Criteria andCinameGreaterThan(String value) {
            addCriterion("ciname >", value, "ciname");
            return (Criteria) this;
        }

        public Criteria andCinameGreaterThanOrEqualTo(String value) {
            addCriterion("ciname >=", value, "ciname");
            return (Criteria) this;
        }

        public Criteria andCinameLessThan(String value) {
            addCriterion("ciname <", value, "ciname");
            return (Criteria) this;
        }

        public Criteria andCinameLessThanOrEqualTo(String value) {
            addCriterion("ciname <=", value, "ciname");
            return (Criteria) this;
        }

        public Criteria andCinameLike(String value) {
            addCriterion("ciname like", value, "ciname");
            return (Criteria) this;
        }

        public Criteria andCinameNotLike(String value) {
            addCriterion("ciname not like", value, "ciname");
            return (Criteria) this;
        }

        public Criteria andCinameIn(List<String> values) {
            addCriterion("ciname in", values, "ciname");
            return (Criteria) this;
        }

        public Criteria andCinameNotIn(List<String> values) {
            addCriterion("ciname not in", values, "ciname");
            return (Criteria) this;
        }

        public Criteria andCinameBetween(String value1, String value2) {
            addCriterion("ciname between", value1, value2, "ciname");
            return (Criteria) this;
        }

        public Criteria andCinameNotBetween(String value1, String value2) {
            addCriterion("ciname not between", value1, value2, "ciname");
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