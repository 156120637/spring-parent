package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CartExample() {
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

        public Criteria andCacountIsNull() {
            addCriterion("cacount is null");
            return (Criteria) this;
        }

        public Criteria andCacountIsNotNull() {
            addCriterion("cacount is not null");
            return (Criteria) this;
        }

        public Criteria andCacountEqualTo(Integer value) {
            addCriterion("cacount =", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountNotEqualTo(Integer value) {
            addCriterion("cacount <>", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountGreaterThan(Integer value) {
            addCriterion("cacount >", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountGreaterThanOrEqualTo(Integer value) {
            addCriterion("cacount >=", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountLessThan(Integer value) {
            addCriterion("cacount <", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountLessThanOrEqualTo(Integer value) {
            addCriterion("cacount <=", value, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountIn(List<Integer> values) {
            addCriterion("cacount in", values, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountNotIn(List<Integer> values) {
            addCriterion("cacount not in", values, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountBetween(Integer value1, Integer value2) {
            addCriterion("cacount between", value1, value2, "cacount");
            return (Criteria) this;
        }

        public Criteria andCacountNotBetween(Integer value1, Integer value2) {
            addCriterion("cacount not between", value1, value2, "cacount");
            return (Criteria) this;
        }

        public Criteria andGoidIsNull() {
            addCriterion("goid is null");
            return (Criteria) this;
        }

        public Criteria andGoidIsNotNull() {
            addCriterion("goid is not null");
            return (Criteria) this;
        }

        public Criteria andGoidEqualTo(String value) {
            addCriterion("goid =", value, "goid");
            return (Criteria) this;
        }

        public Criteria andGoidNotEqualTo(String value) {
            addCriterion("goid <>", value, "goid");
            return (Criteria) this;
        }

        public Criteria andGoidGreaterThan(String value) {
            addCriterion("goid >", value, "goid");
            return (Criteria) this;
        }

        public Criteria andGoidGreaterThanOrEqualTo(String value) {
            addCriterion("goid >=", value, "goid");
            return (Criteria) this;
        }

        public Criteria andGoidLessThan(String value) {
            addCriterion("goid <", value, "goid");
            return (Criteria) this;
        }

        public Criteria andGoidLessThanOrEqualTo(String value) {
            addCriterion("goid <=", value, "goid");
            return (Criteria) this;
        }

        public Criteria andGoidLike(String value) {
            addCriterion("goid like", value, "goid");
            return (Criteria) this;
        }

        public Criteria andGoidNotLike(String value) {
            addCriterion("goid not like", value, "goid");
            return (Criteria) this;
        }

        public Criteria andGoidIn(List<String> values) {
            addCriterion("goid in", values, "goid");
            return (Criteria) this;
        }

        public Criteria andGoidNotIn(List<String> values) {
            addCriterion("goid not in", values, "goid");
            return (Criteria) this;
        }

        public Criteria andGoidBetween(String value1, String value2) {
            addCriterion("goid between", value1, value2, "goid");
            return (Criteria) this;
        }

        public Criteria andGoidNotBetween(String value1, String value2) {
            addCriterion("goid not between", value1, value2, "goid");
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderid like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderid not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNull() {
            addCriterion("orderstatus is null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIsNotNull() {
            addCriterion("orderstatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrderstatusEqualTo(Byte value) {
            addCriterion("orderstatus =", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotEqualTo(Byte value) {
            addCriterion("orderstatus <>", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThan(Byte value) {
            addCriterion("orderstatus >", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("orderstatus >=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThan(Byte value) {
            addCriterion("orderstatus <", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusLessThanOrEqualTo(Byte value) {
            addCriterion("orderstatus <=", value, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusIn(List<Byte> values) {
            addCriterion("orderstatus in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotIn(List<Byte> values) {
            addCriterion("orderstatus not in", values, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusBetween(Byte value1, Byte value2) {
            addCriterion("orderstatus between", value1, value2, "orderstatus");
            return (Criteria) this;
        }

        public Criteria andOrderstatusNotBetween(Byte value1, Byte value2) {
            addCriterion("orderstatus not between", value1, value2, "orderstatus");
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