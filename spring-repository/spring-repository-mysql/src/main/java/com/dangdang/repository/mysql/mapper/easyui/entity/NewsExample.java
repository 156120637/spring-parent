package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsExample() {
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

        public Criteria andNeidIsNull() {
            addCriterion("neid is null");
            return (Criteria) this;
        }

        public Criteria andNeidIsNotNull() {
            addCriterion("neid is not null");
            return (Criteria) this;
        }

        public Criteria andNeidEqualTo(String value) {
            addCriterion("neid =", value, "neid");
            return (Criteria) this;
        }

        public Criteria andNeidNotEqualTo(String value) {
            addCriterion("neid <>", value, "neid");
            return (Criteria) this;
        }

        public Criteria andNeidGreaterThan(String value) {
            addCriterion("neid >", value, "neid");
            return (Criteria) this;
        }

        public Criteria andNeidGreaterThanOrEqualTo(String value) {
            addCriterion("neid >=", value, "neid");
            return (Criteria) this;
        }

        public Criteria andNeidLessThan(String value) {
            addCriterion("neid <", value, "neid");
            return (Criteria) this;
        }

        public Criteria andNeidLessThanOrEqualTo(String value) {
            addCriterion("neid <=", value, "neid");
            return (Criteria) this;
        }

        public Criteria andNeidLike(String value) {
            addCriterion("neid like", value, "neid");
            return (Criteria) this;
        }

        public Criteria andNeidNotLike(String value) {
            addCriterion("neid not like", value, "neid");
            return (Criteria) this;
        }

        public Criteria andNeidIn(List<String> values) {
            addCriterion("neid in", values, "neid");
            return (Criteria) this;
        }

        public Criteria andNeidNotIn(List<String> values) {
            addCriterion("neid not in", values, "neid");
            return (Criteria) this;
        }

        public Criteria andNeidBetween(String value1, String value2) {
            addCriterion("neid between", value1, value2, "neid");
            return (Criteria) this;
        }

        public Criteria andNeidNotBetween(String value1, String value2) {
            addCriterion("neid not between", value1, value2, "neid");
            return (Criteria) this;
        }

        public Criteria andNetitleIsNull() {
            addCriterion("netitle is null");
            return (Criteria) this;
        }

        public Criteria andNetitleIsNotNull() {
            addCriterion("netitle is not null");
            return (Criteria) this;
        }

        public Criteria andNetitleEqualTo(String value) {
            addCriterion("netitle =", value, "netitle");
            return (Criteria) this;
        }

        public Criteria andNetitleNotEqualTo(String value) {
            addCriterion("netitle <>", value, "netitle");
            return (Criteria) this;
        }

        public Criteria andNetitleGreaterThan(String value) {
            addCriterion("netitle >", value, "netitle");
            return (Criteria) this;
        }

        public Criteria andNetitleGreaterThanOrEqualTo(String value) {
            addCriterion("netitle >=", value, "netitle");
            return (Criteria) this;
        }

        public Criteria andNetitleLessThan(String value) {
            addCriterion("netitle <", value, "netitle");
            return (Criteria) this;
        }

        public Criteria andNetitleLessThanOrEqualTo(String value) {
            addCriterion("netitle <=", value, "netitle");
            return (Criteria) this;
        }

        public Criteria andNetitleLike(String value) {
            addCriterion("netitle like", value, "netitle");
            return (Criteria) this;
        }

        public Criteria andNetitleNotLike(String value) {
            addCriterion("netitle not like", value, "netitle");
            return (Criteria) this;
        }

        public Criteria andNetitleIn(List<String> values) {
            addCriterion("netitle in", values, "netitle");
            return (Criteria) this;
        }

        public Criteria andNetitleNotIn(List<String> values) {
            addCriterion("netitle not in", values, "netitle");
            return (Criteria) this;
        }

        public Criteria andNetitleBetween(String value1, String value2) {
            addCriterion("netitle between", value1, value2, "netitle");
            return (Criteria) this;
        }

        public Criteria andNetitleNotBetween(String value1, String value2) {
            addCriterion("netitle not between", value1, value2, "netitle");
            return (Criteria) this;
        }

        public Criteria andNecontentIsNull() {
            addCriterion("necontent is null");
            return (Criteria) this;
        }

        public Criteria andNecontentIsNotNull() {
            addCriterion("necontent is not null");
            return (Criteria) this;
        }

        public Criteria andNecontentEqualTo(String value) {
            addCriterion("necontent =", value, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecontentNotEqualTo(String value) {
            addCriterion("necontent <>", value, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecontentGreaterThan(String value) {
            addCriterion("necontent >", value, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecontentGreaterThanOrEqualTo(String value) {
            addCriterion("necontent >=", value, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecontentLessThan(String value) {
            addCriterion("necontent <", value, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecontentLessThanOrEqualTo(String value) {
            addCriterion("necontent <=", value, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecontentLike(String value) {
            addCriterion("necontent like", value, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecontentNotLike(String value) {
            addCriterion("necontent not like", value, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecontentIn(List<String> values) {
            addCriterion("necontent in", values, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecontentNotIn(List<String> values) {
            addCriterion("necontent not in", values, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecontentBetween(String value1, String value2) {
            addCriterion("necontent between", value1, value2, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecontentNotBetween(String value1, String value2) {
            addCriterion("necontent not between", value1, value2, "necontent");
            return (Criteria) this;
        }

        public Criteria andNecreateIsNull() {
            addCriterion("necreate is null");
            return (Criteria) this;
        }

        public Criteria andNecreateIsNotNull() {
            addCriterion("necreate is not null");
            return (Criteria) this;
        }

        public Criteria andNecreateEqualTo(Date value) {
            addCriterion("necreate =", value, "necreate");
            return (Criteria) this;
        }

        public Criteria andNecreateNotEqualTo(Date value) {
            addCriterion("necreate <>", value, "necreate");
            return (Criteria) this;
        }

        public Criteria andNecreateGreaterThan(Date value) {
            addCriterion("necreate >", value, "necreate");
            return (Criteria) this;
        }

        public Criteria andNecreateGreaterThanOrEqualTo(Date value) {
            addCriterion("necreate >=", value, "necreate");
            return (Criteria) this;
        }

        public Criteria andNecreateLessThan(Date value) {
            addCriterion("necreate <", value, "necreate");
            return (Criteria) this;
        }

        public Criteria andNecreateLessThanOrEqualTo(Date value) {
            addCriterion("necreate <=", value, "necreate");
            return (Criteria) this;
        }

        public Criteria andNecreateIn(List<Date> values) {
            addCriterion("necreate in", values, "necreate");
            return (Criteria) this;
        }

        public Criteria andNecreateNotIn(List<Date> values) {
            addCriterion("necreate not in", values, "necreate");
            return (Criteria) this;
        }

        public Criteria andNecreateBetween(Date value1, Date value2) {
            addCriterion("necreate between", value1, value2, "necreate");
            return (Criteria) this;
        }

        public Criteria andNecreateNotBetween(Date value1, Date value2) {
            addCriterion("necreate not between", value1, value2, "necreate");
            return (Criteria) this;
        }

        public Criteria andNeimageIsNull() {
            addCriterion("neimage is null");
            return (Criteria) this;
        }

        public Criteria andNeimageIsNotNull() {
            addCriterion("neimage is not null");
            return (Criteria) this;
        }

        public Criteria andNeimageEqualTo(String value) {
            addCriterion("neimage =", value, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeimageNotEqualTo(String value) {
            addCriterion("neimage <>", value, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeimageGreaterThan(String value) {
            addCriterion("neimage >", value, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeimageGreaterThanOrEqualTo(String value) {
            addCriterion("neimage >=", value, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeimageLessThan(String value) {
            addCriterion("neimage <", value, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeimageLessThanOrEqualTo(String value) {
            addCriterion("neimage <=", value, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeimageLike(String value) {
            addCriterion("neimage like", value, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeimageNotLike(String value) {
            addCriterion("neimage not like", value, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeimageIn(List<String> values) {
            addCriterion("neimage in", values, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeimageNotIn(List<String> values) {
            addCriterion("neimage not in", values, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeimageBetween(String value1, String value2) {
            addCriterion("neimage between", value1, value2, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeimageNotBetween(String value1, String value2) {
            addCriterion("neimage not between", value1, value2, "neimage");
            return (Criteria) this;
        }

        public Criteria andNeintroIsNull() {
            addCriterion("neintro is null");
            return (Criteria) this;
        }

        public Criteria andNeintroIsNotNull() {
            addCriterion("neintro is not null");
            return (Criteria) this;
        }

        public Criteria andNeintroEqualTo(String value) {
            addCriterion("neintro =", value, "neintro");
            return (Criteria) this;
        }

        public Criteria andNeintroNotEqualTo(String value) {
            addCriterion("neintro <>", value, "neintro");
            return (Criteria) this;
        }

        public Criteria andNeintroGreaterThan(String value) {
            addCriterion("neintro >", value, "neintro");
            return (Criteria) this;
        }

        public Criteria andNeintroGreaterThanOrEqualTo(String value) {
            addCriterion("neintro >=", value, "neintro");
            return (Criteria) this;
        }

        public Criteria andNeintroLessThan(String value) {
            addCriterion("neintro <", value, "neintro");
            return (Criteria) this;
        }

        public Criteria andNeintroLessThanOrEqualTo(String value) {
            addCriterion("neintro <=", value, "neintro");
            return (Criteria) this;
        }

        public Criteria andNeintroLike(String value) {
            addCriterion("neintro like", value, "neintro");
            return (Criteria) this;
        }

        public Criteria andNeintroNotLike(String value) {
            addCriterion("neintro not like", value, "neintro");
            return (Criteria) this;
        }

        public Criteria andNeintroIn(List<String> values) {
            addCriterion("neintro in", values, "neintro");
            return (Criteria) this;
        }

        public Criteria andNeintroNotIn(List<String> values) {
            addCriterion("neintro not in", values, "neintro");
            return (Criteria) this;
        }

        public Criteria andNeintroBetween(String value1, String value2) {
            addCriterion("neintro between", value1, value2, "neintro");
            return (Criteria) this;
        }

        public Criteria andNeintroNotBetween(String value1, String value2) {
            addCriterion("neintro not between", value1, value2, "neintro");
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

        public Criteria andCategoryidIsNull() {
            addCriterion("categoryid is null");
            return (Criteria) this;
        }

        public Criteria andCategoryidIsNotNull() {
            addCriterion("categoryid is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryidEqualTo(String value) {
            addCriterion("categoryid =", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotEqualTo(String value) {
            addCriterion("categoryid <>", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThan(String value) {
            addCriterion("categoryid >", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidGreaterThanOrEqualTo(String value) {
            addCriterion("categoryid >=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThan(String value) {
            addCriterion("categoryid <", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLessThanOrEqualTo(String value) {
            addCriterion("categoryid <=", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidLike(String value) {
            addCriterion("categoryid like", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotLike(String value) {
            addCriterion("categoryid not like", value, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidIn(List<String> values) {
            addCriterion("categoryid in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotIn(List<String> values) {
            addCriterion("categoryid not in", values, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidBetween(String value1, String value2) {
            addCriterion("categoryid between", value1, value2, "categoryid");
            return (Criteria) this;
        }

        public Criteria andCategoryidNotBetween(String value1, String value2) {
            addCriterion("categoryid not between", value1, value2, "categoryid");
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