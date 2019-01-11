package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOridIsNull() {
            addCriterion("orid is null");
            return (Criteria) this;
        }

        public Criteria andOridIsNotNull() {
            addCriterion("orid is not null");
            return (Criteria) this;
        }

        public Criteria andOridEqualTo(String value) {
            addCriterion("orid =", value, "orid");
            return (Criteria) this;
        }

        public Criteria andOridNotEqualTo(String value) {
            addCriterion("orid <>", value, "orid");
            return (Criteria) this;
        }

        public Criteria andOridGreaterThan(String value) {
            addCriterion("orid >", value, "orid");
            return (Criteria) this;
        }

        public Criteria andOridGreaterThanOrEqualTo(String value) {
            addCriterion("orid >=", value, "orid");
            return (Criteria) this;
        }

        public Criteria andOridLessThan(String value) {
            addCriterion("orid <", value, "orid");
            return (Criteria) this;
        }

        public Criteria andOridLessThanOrEqualTo(String value) {
            addCriterion("orid <=", value, "orid");
            return (Criteria) this;
        }

        public Criteria andOridLike(String value) {
            addCriterion("orid like", value, "orid");
            return (Criteria) this;
        }

        public Criteria andOridNotLike(String value) {
            addCriterion("orid not like", value, "orid");
            return (Criteria) this;
        }

        public Criteria andOridIn(List<String> values) {
            addCriterion("orid in", values, "orid");
            return (Criteria) this;
        }

        public Criteria andOridNotIn(List<String> values) {
            addCriterion("orid not in", values, "orid");
            return (Criteria) this;
        }

        public Criteria andOridBetween(String value1, String value2) {
            addCriterion("orid between", value1, value2, "orid");
            return (Criteria) this;
        }

        public Criteria andOridNotBetween(String value1, String value2) {
            addCriterion("orid not between", value1, value2, "orid");
            return (Criteria) this;
        }

        public Criteria andOrnumberIsNull() {
            addCriterion("ornumber is null");
            return (Criteria) this;
        }

        public Criteria andOrnumberIsNotNull() {
            addCriterion("ornumber is not null");
            return (Criteria) this;
        }

        public Criteria andOrnumberEqualTo(Integer value) {
            addCriterion("ornumber =", value, "ornumber");
            return (Criteria) this;
        }

        public Criteria andOrnumberNotEqualTo(Integer value) {
            addCriterion("ornumber <>", value, "ornumber");
            return (Criteria) this;
        }

        public Criteria andOrnumberGreaterThan(Integer value) {
            addCriterion("ornumber >", value, "ornumber");
            return (Criteria) this;
        }

        public Criteria andOrnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("ornumber >=", value, "ornumber");
            return (Criteria) this;
        }

        public Criteria andOrnumberLessThan(Integer value) {
            addCriterion("ornumber <", value, "ornumber");
            return (Criteria) this;
        }

        public Criteria andOrnumberLessThanOrEqualTo(Integer value) {
            addCriterion("ornumber <=", value, "ornumber");
            return (Criteria) this;
        }

        public Criteria andOrnumberIn(List<Integer> values) {
            addCriterion("ornumber in", values, "ornumber");
            return (Criteria) this;
        }

        public Criteria andOrnumberNotIn(List<Integer> values) {
            addCriterion("ornumber not in", values, "ornumber");
            return (Criteria) this;
        }

        public Criteria andOrnumberBetween(Integer value1, Integer value2) {
            addCriterion("ornumber between", value1, value2, "ornumber");
            return (Criteria) this;
        }

        public Criteria andOrnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("ornumber not between", value1, value2, "ornumber");
            return (Criteria) this;
        }

        public Criteria andOrcreateIsNull() {
            addCriterion("orcreate is null");
            return (Criteria) this;
        }

        public Criteria andOrcreateIsNotNull() {
            addCriterion("orcreate is not null");
            return (Criteria) this;
        }

        public Criteria andOrcreateEqualTo(Date value) {
            addCriterion("orcreate =", value, "orcreate");
            return (Criteria) this;
        }

        public Criteria andOrcreateNotEqualTo(Date value) {
            addCriterion("orcreate <>", value, "orcreate");
            return (Criteria) this;
        }

        public Criteria andOrcreateGreaterThan(Date value) {
            addCriterion("orcreate >", value, "orcreate");
            return (Criteria) this;
        }

        public Criteria andOrcreateGreaterThanOrEqualTo(Date value) {
            addCriterion("orcreate >=", value, "orcreate");
            return (Criteria) this;
        }

        public Criteria andOrcreateLessThan(Date value) {
            addCriterion("orcreate <", value, "orcreate");
            return (Criteria) this;
        }

        public Criteria andOrcreateLessThanOrEqualTo(Date value) {
            addCriterion("orcreate <=", value, "orcreate");
            return (Criteria) this;
        }

        public Criteria andOrcreateIn(List<Date> values) {
            addCriterion("orcreate in", values, "orcreate");
            return (Criteria) this;
        }

        public Criteria andOrcreateNotIn(List<Date> values) {
            addCriterion("orcreate not in", values, "orcreate");
            return (Criteria) this;
        }

        public Criteria andOrcreateBetween(Date value1, Date value2) {
            addCriterion("orcreate between", value1, value2, "orcreate");
            return (Criteria) this;
        }

        public Criteria andOrcreateNotBetween(Date value1, Date value2) {
            addCriterion("orcreate not between", value1, value2, "orcreate");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusIsNull() {
            addCriterion("orpaystatus is null");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusIsNotNull() {
            addCriterion("orpaystatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusEqualTo(Integer value) {
            addCriterion("orpaystatus =", value, "orpaystatus");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusNotEqualTo(Integer value) {
            addCriterion("orpaystatus <>", value, "orpaystatus");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusGreaterThan(Integer value) {
            addCriterion("orpaystatus >", value, "orpaystatus");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("orpaystatus >=", value, "orpaystatus");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusLessThan(Integer value) {
            addCriterion("orpaystatus <", value, "orpaystatus");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusLessThanOrEqualTo(Integer value) {
            addCriterion("orpaystatus <=", value, "orpaystatus");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusIn(List<Integer> values) {
            addCriterion("orpaystatus in", values, "orpaystatus");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusNotIn(List<Integer> values) {
            addCriterion("orpaystatus not in", values, "orpaystatus");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusBetween(Integer value1, Integer value2) {
            addCriterion("orpaystatus between", value1, value2, "orpaystatus");
            return (Criteria) this;
        }

        public Criteria andOrpaystatusNotBetween(Integer value1, Integer value2) {
            addCriterion("orpaystatus not between", value1, value2, "orpaystatus");
            return (Criteria) this;
        }

        public Criteria andAddressidIsNull() {
            addCriterion("addressid is null");
            return (Criteria) this;
        }

        public Criteria andAddressidIsNotNull() {
            addCriterion("addressid is not null");
            return (Criteria) this;
        }

        public Criteria andAddressidEqualTo(String value) {
            addCriterion("addressid =", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotEqualTo(String value) {
            addCriterion("addressid <>", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidGreaterThan(String value) {
            addCriterion("addressid >", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidGreaterThanOrEqualTo(String value) {
            addCriterion("addressid >=", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidLessThan(String value) {
            addCriterion("addressid <", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidLessThanOrEqualTo(String value) {
            addCriterion("addressid <=", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidLike(String value) {
            addCriterion("addressid like", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotLike(String value) {
            addCriterion("addressid not like", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidIn(List<String> values) {
            addCriterion("addressid in", values, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotIn(List<String> values) {
            addCriterion("addressid not in", values, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidBetween(String value1, String value2) {
            addCriterion("addressid between", value1, value2, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotBetween(String value1, String value2) {
            addCriterion("addressid not between", value1, value2, "addressid");
            return (Criteria) this;
        }

        public Criteria andOrmessageIsNull() {
            addCriterion("ormessage is null");
            return (Criteria) this;
        }

        public Criteria andOrmessageIsNotNull() {
            addCriterion("ormessage is not null");
            return (Criteria) this;
        }

        public Criteria andOrmessageEqualTo(String value) {
            addCriterion("ormessage =", value, "ormessage");
            return (Criteria) this;
        }

        public Criteria andOrmessageNotEqualTo(String value) {
            addCriterion("ormessage <>", value, "ormessage");
            return (Criteria) this;
        }

        public Criteria andOrmessageGreaterThan(String value) {
            addCriterion("ormessage >", value, "ormessage");
            return (Criteria) this;
        }

        public Criteria andOrmessageGreaterThanOrEqualTo(String value) {
            addCriterion("ormessage >=", value, "ormessage");
            return (Criteria) this;
        }

        public Criteria andOrmessageLessThan(String value) {
            addCriterion("ormessage <", value, "ormessage");
            return (Criteria) this;
        }

        public Criteria andOrmessageLessThanOrEqualTo(String value) {
            addCriterion("ormessage <=", value, "ormessage");
            return (Criteria) this;
        }

        public Criteria andOrmessageLike(String value) {
            addCriterion("ormessage like", value, "ormessage");
            return (Criteria) this;
        }

        public Criteria andOrmessageNotLike(String value) {
            addCriterion("ormessage not like", value, "ormessage");
            return (Criteria) this;
        }

        public Criteria andOrmessageIn(List<String> values) {
            addCriterion("ormessage in", values, "ormessage");
            return (Criteria) this;
        }

        public Criteria andOrmessageNotIn(List<String> values) {
            addCriterion("ormessage not in", values, "ormessage");
            return (Criteria) this;
        }

        public Criteria andOrmessageBetween(String value1, String value2) {
            addCriterion("ormessage between", value1, value2, "ormessage");
            return (Criteria) this;
        }

        public Criteria andOrmessageNotBetween(String value1, String value2) {
            addCriterion("ormessage not between", value1, value2, "ormessage");
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