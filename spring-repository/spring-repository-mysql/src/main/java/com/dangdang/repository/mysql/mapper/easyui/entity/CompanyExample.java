package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExample() {
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

        public Criteria andCoidIsNull() {
            addCriterion("coid is null");
            return (Criteria) this;
        }

        public Criteria andCoidIsNotNull() {
            addCriterion("coid is not null");
            return (Criteria) this;
        }

        public Criteria andCoidEqualTo(String value) {
            addCriterion("coid =", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidNotEqualTo(String value) {
            addCriterion("coid <>", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidGreaterThan(String value) {
            addCriterion("coid >", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidGreaterThanOrEqualTo(String value) {
            addCriterion("coid >=", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidLessThan(String value) {
            addCriterion("coid <", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidLessThanOrEqualTo(String value) {
            addCriterion("coid <=", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidLike(String value) {
            addCriterion("coid like", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidNotLike(String value) {
            addCriterion("coid not like", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidIn(List<String> values) {
            addCriterion("coid in", values, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidNotIn(List<String> values) {
            addCriterion("coid not in", values, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidBetween(String value1, String value2) {
            addCriterion("coid between", value1, value2, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidNotBetween(String value1, String value2) {
            addCriterion("coid not between", value1, value2, "coid");
            return (Criteria) this;
        }

        public Criteria andCoaboutIsNull() {
            addCriterion("coabout is null");
            return (Criteria) this;
        }

        public Criteria andCoaboutIsNotNull() {
            addCriterion("coabout is not null");
            return (Criteria) this;
        }

        public Criteria andCoaboutEqualTo(String value) {
            addCriterion("coabout =", value, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoaboutNotEqualTo(String value) {
            addCriterion("coabout <>", value, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoaboutGreaterThan(String value) {
            addCriterion("coabout >", value, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoaboutGreaterThanOrEqualTo(String value) {
            addCriterion("coabout >=", value, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoaboutLessThan(String value) {
            addCriterion("coabout <", value, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoaboutLessThanOrEqualTo(String value) {
            addCriterion("coabout <=", value, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoaboutLike(String value) {
            addCriterion("coabout like", value, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoaboutNotLike(String value) {
            addCriterion("coabout not like", value, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoaboutIn(List<String> values) {
            addCriterion("coabout in", values, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoaboutNotIn(List<String> values) {
            addCriterion("coabout not in", values, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoaboutBetween(String value1, String value2) {
            addCriterion("coabout between", value1, value2, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoaboutNotBetween(String value1, String value2) {
            addCriterion("coabout not between", value1, value2, "coabout");
            return (Criteria) this;
        }

        public Criteria andCoconnectIsNull() {
            addCriterion("coconnect is null");
            return (Criteria) this;
        }

        public Criteria andCoconnectIsNotNull() {
            addCriterion("coconnect is not null");
            return (Criteria) this;
        }

        public Criteria andCoconnectEqualTo(String value) {
            addCriterion("coconnect =", value, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoconnectNotEqualTo(String value) {
            addCriterion("coconnect <>", value, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoconnectGreaterThan(String value) {
            addCriterion("coconnect >", value, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoconnectGreaterThanOrEqualTo(String value) {
            addCriterion("coconnect >=", value, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoconnectLessThan(String value) {
            addCriterion("coconnect <", value, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoconnectLessThanOrEqualTo(String value) {
            addCriterion("coconnect <=", value, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoconnectLike(String value) {
            addCriterion("coconnect like", value, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoconnectNotLike(String value) {
            addCriterion("coconnect not like", value, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoconnectIn(List<String> values) {
            addCriterion("coconnect in", values, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoconnectNotIn(List<String> values) {
            addCriterion("coconnect not in", values, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoconnectBetween(String value1, String value2) {
            addCriterion("coconnect between", value1, value2, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoconnectNotBetween(String value1, String value2) {
            addCriterion("coconnect not between", value1, value2, "coconnect");
            return (Criteria) this;
        }

        public Criteria andCoidentificationIsNull() {
            addCriterion("coidentification is null");
            return (Criteria) this;
        }

        public Criteria andCoidentificationIsNotNull() {
            addCriterion("coidentification is not null");
            return (Criteria) this;
        }

        public Criteria andCoidentificationEqualTo(String value) {
            addCriterion("coidentification =", value, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCoidentificationNotEqualTo(String value) {
            addCriterion("coidentification <>", value, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCoidentificationGreaterThan(String value) {
            addCriterion("coidentification >", value, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCoidentificationGreaterThanOrEqualTo(String value) {
            addCriterion("coidentification >=", value, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCoidentificationLessThan(String value) {
            addCriterion("coidentification <", value, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCoidentificationLessThanOrEqualTo(String value) {
            addCriterion("coidentification <=", value, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCoidentificationLike(String value) {
            addCriterion("coidentification like", value, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCoidentificationNotLike(String value) {
            addCriterion("coidentification not like", value, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCoidentificationIn(List<String> values) {
            addCriterion("coidentification in", values, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCoidentificationNotIn(List<String> values) {
            addCriterion("coidentification not in", values, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCoidentificationBetween(String value1, String value2) {
            addCriterion("coidentification between", value1, value2, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCoidentificationNotBetween(String value1, String value2) {
            addCriterion("coidentification not between", value1, value2, "coidentification");
            return (Criteria) this;
        }

        public Criteria andCootherIsNull() {
            addCriterion("coother is null");
            return (Criteria) this;
        }

        public Criteria andCootherIsNotNull() {
            addCriterion("coother is not null");
            return (Criteria) this;
        }

        public Criteria andCootherEqualTo(String value) {
            addCriterion("coother =", value, "coother");
            return (Criteria) this;
        }

        public Criteria andCootherNotEqualTo(String value) {
            addCriterion("coother <>", value, "coother");
            return (Criteria) this;
        }

        public Criteria andCootherGreaterThan(String value) {
            addCriterion("coother >", value, "coother");
            return (Criteria) this;
        }

        public Criteria andCootherGreaterThanOrEqualTo(String value) {
            addCriterion("coother >=", value, "coother");
            return (Criteria) this;
        }

        public Criteria andCootherLessThan(String value) {
            addCriterion("coother <", value, "coother");
            return (Criteria) this;
        }

        public Criteria andCootherLessThanOrEqualTo(String value) {
            addCriterion("coother <=", value, "coother");
            return (Criteria) this;
        }

        public Criteria andCootherLike(String value) {
            addCriterion("coother like", value, "coother");
            return (Criteria) this;
        }

        public Criteria andCootherNotLike(String value) {
            addCriterion("coother not like", value, "coother");
            return (Criteria) this;
        }

        public Criteria andCootherIn(List<String> values) {
            addCriterion("coother in", values, "coother");
            return (Criteria) this;
        }

        public Criteria andCootherNotIn(List<String> values) {
            addCriterion("coother not in", values, "coother");
            return (Criteria) this;
        }

        public Criteria andCootherBetween(String value1, String value2) {
            addCriterion("coother between", value1, value2, "coother");
            return (Criteria) this;
        }

        public Criteria andCootherNotBetween(String value1, String value2) {
            addCriterion("coother not between", value1, value2, "coother");
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