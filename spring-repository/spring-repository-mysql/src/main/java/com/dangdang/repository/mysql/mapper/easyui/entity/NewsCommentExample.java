package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsCommentExample() {
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

        public Criteria andNcoidIsNull() {
            addCriterion("ncoid is null");
            return (Criteria) this;
        }

        public Criteria andNcoidIsNotNull() {
            addCriterion("ncoid is not null");
            return (Criteria) this;
        }

        public Criteria andNcoidEqualTo(String value) {
            addCriterion("ncoid =", value, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcoidNotEqualTo(String value) {
            addCriterion("ncoid <>", value, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcoidGreaterThan(String value) {
            addCriterion("ncoid >", value, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcoidGreaterThanOrEqualTo(String value) {
            addCriterion("ncoid >=", value, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcoidLessThan(String value) {
            addCriterion("ncoid <", value, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcoidLessThanOrEqualTo(String value) {
            addCriterion("ncoid <=", value, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcoidLike(String value) {
            addCriterion("ncoid like", value, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcoidNotLike(String value) {
            addCriterion("ncoid not like", value, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcoidIn(List<String> values) {
            addCriterion("ncoid in", values, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcoidNotIn(List<String> values) {
            addCriterion("ncoid not in", values, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcoidBetween(String value1, String value2) {
            addCriterion("ncoid between", value1, value2, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcoidNotBetween(String value1, String value2) {
            addCriterion("ncoid not between", value1, value2, "ncoid");
            return (Criteria) this;
        }

        public Criteria andNcocontentIsNull() {
            addCriterion("ncocontent is null");
            return (Criteria) this;
        }

        public Criteria andNcocontentIsNotNull() {
            addCriterion("ncocontent is not null");
            return (Criteria) this;
        }

        public Criteria andNcocontentEqualTo(String value) {
            addCriterion("ncocontent =", value, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNcocontentNotEqualTo(String value) {
            addCriterion("ncocontent <>", value, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNcocontentGreaterThan(String value) {
            addCriterion("ncocontent >", value, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNcocontentGreaterThanOrEqualTo(String value) {
            addCriterion("ncocontent >=", value, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNcocontentLessThan(String value) {
            addCriterion("ncocontent <", value, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNcocontentLessThanOrEqualTo(String value) {
            addCriterion("ncocontent <=", value, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNcocontentLike(String value) {
            addCriterion("ncocontent like", value, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNcocontentNotLike(String value) {
            addCriterion("ncocontent not like", value, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNcocontentIn(List<String> values) {
            addCriterion("ncocontent in", values, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNcocontentNotIn(List<String> values) {
            addCriterion("ncocontent not in", values, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNcocontentBetween(String value1, String value2) {
            addCriterion("ncocontent between", value1, value2, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNcocontentNotBetween(String value1, String value2) {
            addCriterion("ncocontent not between", value1, value2, "ncocontent");
            return (Criteria) this;
        }

        public Criteria andNccreateIsNull() {
            addCriterion("nccreate is null");
            return (Criteria) this;
        }

        public Criteria andNccreateIsNotNull() {
            addCriterion("nccreate is not null");
            return (Criteria) this;
        }

        public Criteria andNccreateEqualTo(Date value) {
            addCriterion("nccreate =", value, "nccreate");
            return (Criteria) this;
        }

        public Criteria andNccreateNotEqualTo(Date value) {
            addCriterion("nccreate <>", value, "nccreate");
            return (Criteria) this;
        }

        public Criteria andNccreateGreaterThan(Date value) {
            addCriterion("nccreate >", value, "nccreate");
            return (Criteria) this;
        }

        public Criteria andNccreateGreaterThanOrEqualTo(Date value) {
            addCriterion("nccreate >=", value, "nccreate");
            return (Criteria) this;
        }

        public Criteria andNccreateLessThan(Date value) {
            addCriterion("nccreate <", value, "nccreate");
            return (Criteria) this;
        }

        public Criteria andNccreateLessThanOrEqualTo(Date value) {
            addCriterion("nccreate <=", value, "nccreate");
            return (Criteria) this;
        }

        public Criteria andNccreateIn(List<Date> values) {
            addCriterion("nccreate in", values, "nccreate");
            return (Criteria) this;
        }

        public Criteria andNccreateNotIn(List<Date> values) {
            addCriterion("nccreate not in", values, "nccreate");
            return (Criteria) this;
        }

        public Criteria andNccreateBetween(Date value1, Date value2) {
            addCriterion("nccreate between", value1, value2, "nccreate");
            return (Criteria) this;
        }

        public Criteria andNccreateNotBetween(Date value1, Date value2) {
            addCriterion("nccreate not between", value1, value2, "nccreate");
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

        public Criteria andNewsidIsNull() {
            addCriterion("newsid is null");
            return (Criteria) this;
        }

        public Criteria andNewsidIsNotNull() {
            addCriterion("newsid is not null");
            return (Criteria) this;
        }

        public Criteria andNewsidEqualTo(String value) {
            addCriterion("newsid =", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotEqualTo(String value) {
            addCriterion("newsid <>", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThan(String value) {
            addCriterion("newsid >", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidGreaterThanOrEqualTo(String value) {
            addCriterion("newsid >=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThan(String value) {
            addCriterion("newsid <", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLessThanOrEqualTo(String value) {
            addCriterion("newsid <=", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidLike(String value) {
            addCriterion("newsid like", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotLike(String value) {
            addCriterion("newsid not like", value, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidIn(List<String> values) {
            addCriterion("newsid in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotIn(List<String> values) {
            addCriterion("newsid not in", values, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidBetween(String value1, String value2) {
            addCriterion("newsid between", value1, value2, "newsid");
            return (Criteria) this;
        }

        public Criteria andNewsidNotBetween(String value1, String value2) {
            addCriterion("newsid not between", value1, value2, "newsid");
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