package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedbackExample() {
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

        public Criteria andFeidIsNull() {
            addCriterion("feid is null");
            return (Criteria) this;
        }

        public Criteria andFeidIsNotNull() {
            addCriterion("feid is not null");
            return (Criteria) this;
        }

        public Criteria andFeidEqualTo(String value) {
            addCriterion("feid =", value, "feid");
            return (Criteria) this;
        }

        public Criteria andFeidNotEqualTo(String value) {
            addCriterion("feid <>", value, "feid");
            return (Criteria) this;
        }

        public Criteria andFeidGreaterThan(String value) {
            addCriterion("feid >", value, "feid");
            return (Criteria) this;
        }

        public Criteria andFeidGreaterThanOrEqualTo(String value) {
            addCriterion("feid >=", value, "feid");
            return (Criteria) this;
        }

        public Criteria andFeidLessThan(String value) {
            addCriterion("feid <", value, "feid");
            return (Criteria) this;
        }

        public Criteria andFeidLessThanOrEqualTo(String value) {
            addCriterion("feid <=", value, "feid");
            return (Criteria) this;
        }

        public Criteria andFeidLike(String value) {
            addCriterion("feid like", value, "feid");
            return (Criteria) this;
        }

        public Criteria andFeidNotLike(String value) {
            addCriterion("feid not like", value, "feid");
            return (Criteria) this;
        }

        public Criteria andFeidIn(List<String> values) {
            addCriterion("feid in", values, "feid");
            return (Criteria) this;
        }

        public Criteria andFeidNotIn(List<String> values) {
            addCriterion("feid not in", values, "feid");
            return (Criteria) this;
        }

        public Criteria andFeidBetween(String value1, String value2) {
            addCriterion("feid between", value1, value2, "feid");
            return (Criteria) this;
        }

        public Criteria andFeidNotBetween(String value1, String value2) {
            addCriterion("feid not between", value1, value2, "feid");
            return (Criteria) this;
        }

        public Criteria andFecontentIsNull() {
            addCriterion("fecontent is null");
            return (Criteria) this;
        }

        public Criteria andFecontentIsNotNull() {
            addCriterion("fecontent is not null");
            return (Criteria) this;
        }

        public Criteria andFecontentEqualTo(String value) {
            addCriterion("fecontent =", value, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecontentNotEqualTo(String value) {
            addCriterion("fecontent <>", value, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecontentGreaterThan(String value) {
            addCriterion("fecontent >", value, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecontentGreaterThanOrEqualTo(String value) {
            addCriterion("fecontent >=", value, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecontentLessThan(String value) {
            addCriterion("fecontent <", value, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecontentLessThanOrEqualTo(String value) {
            addCriterion("fecontent <=", value, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecontentLike(String value) {
            addCriterion("fecontent like", value, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecontentNotLike(String value) {
            addCriterion("fecontent not like", value, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecontentIn(List<String> values) {
            addCriterion("fecontent in", values, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecontentNotIn(List<String> values) {
            addCriterion("fecontent not in", values, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecontentBetween(String value1, String value2) {
            addCriterion("fecontent between", value1, value2, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecontentNotBetween(String value1, String value2) {
            addCriterion("fecontent not between", value1, value2, "fecontent");
            return (Criteria) this;
        }

        public Criteria andFecreateIsNull() {
            addCriterion("fecreate is null");
            return (Criteria) this;
        }

        public Criteria andFecreateIsNotNull() {
            addCriterion("fecreate is not null");
            return (Criteria) this;
        }

        public Criteria andFecreateEqualTo(Date value) {
            addCriterion("fecreate =", value, "fecreate");
            return (Criteria) this;
        }

        public Criteria andFecreateNotEqualTo(Date value) {
            addCriterion("fecreate <>", value, "fecreate");
            return (Criteria) this;
        }

        public Criteria andFecreateGreaterThan(Date value) {
            addCriterion("fecreate >", value, "fecreate");
            return (Criteria) this;
        }

        public Criteria andFecreateGreaterThanOrEqualTo(Date value) {
            addCriterion("fecreate >=", value, "fecreate");
            return (Criteria) this;
        }

        public Criteria andFecreateLessThan(Date value) {
            addCriterion("fecreate <", value, "fecreate");
            return (Criteria) this;
        }

        public Criteria andFecreateLessThanOrEqualTo(Date value) {
            addCriterion("fecreate <=", value, "fecreate");
            return (Criteria) this;
        }

        public Criteria andFecreateIn(List<Date> values) {
            addCriterion("fecreate in", values, "fecreate");
            return (Criteria) this;
        }

        public Criteria andFecreateNotIn(List<Date> values) {
            addCriterion("fecreate not in", values, "fecreate");
            return (Criteria) this;
        }

        public Criteria andFecreateBetween(Date value1, Date value2) {
            addCriterion("fecreate between", value1, value2, "fecreate");
            return (Criteria) this;
        }

        public Criteria andFecreateNotBetween(Date value1, Date value2) {
            addCriterion("fecreate not between", value1, value2, "fecreate");
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

        public Criteria andUsenvironmentIsNull() {
            addCriterion("usenvironment is null");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentIsNotNull() {
            addCriterion("usenvironment is not null");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentEqualTo(String value) {
            addCriterion("usenvironment =", value, "usenvironment");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentNotEqualTo(String value) {
            addCriterion("usenvironment <>", value, "usenvironment");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentGreaterThan(String value) {
            addCriterion("usenvironment >", value, "usenvironment");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentGreaterThanOrEqualTo(String value) {
            addCriterion("usenvironment >=", value, "usenvironment");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentLessThan(String value) {
            addCriterion("usenvironment <", value, "usenvironment");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentLessThanOrEqualTo(String value) {
            addCriterion("usenvironment <=", value, "usenvironment");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentLike(String value) {
            addCriterion("usenvironment like", value, "usenvironment");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentNotLike(String value) {
            addCriterion("usenvironment not like", value, "usenvironment");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentIn(List<String> values) {
            addCriterion("usenvironment in", values, "usenvironment");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentNotIn(List<String> values) {
            addCriterion("usenvironment not in", values, "usenvironment");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentBetween(String value1, String value2) {
            addCriterion("usenvironment between", value1, value2, "usenvironment");
            return (Criteria) this;
        }

        public Criteria andUsenvironmentNotBetween(String value1, String value2) {
            addCriterion("usenvironment not between", value1, value2, "usenvironment");
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