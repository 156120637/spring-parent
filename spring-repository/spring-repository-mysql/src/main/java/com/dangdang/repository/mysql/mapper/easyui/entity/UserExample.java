package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUsidIsNull() {
            addCriterion("usid is null");
            return (Criteria) this;
        }

        public Criteria andUsidIsNotNull() {
            addCriterion("usid is not null");
            return (Criteria) this;
        }

        public Criteria andUsidEqualTo(String value) {
            addCriterion("usid =", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidNotEqualTo(String value) {
            addCriterion("usid <>", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidGreaterThan(String value) {
            addCriterion("usid >", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidGreaterThanOrEqualTo(String value) {
            addCriterion("usid >=", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidLessThan(String value) {
            addCriterion("usid <", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidLessThanOrEqualTo(String value) {
            addCriterion("usid <=", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidLike(String value) {
            addCriterion("usid like", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidNotLike(String value) {
            addCriterion("usid not like", value, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidIn(List<String> values) {
            addCriterion("usid in", values, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidNotIn(List<String> values) {
            addCriterion("usid not in", values, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidBetween(String value1, String value2) {
            addCriterion("usid between", value1, value2, "usid");
            return (Criteria) this;
        }

        public Criteria andUsidNotBetween(String value1, String value2) {
            addCriterion("usid not between", value1, value2, "usid");
            return (Criteria) this;
        }

        public Criteria andUsnameIsNull() {
            addCriterion("usname is null");
            return (Criteria) this;
        }

        public Criteria andUsnameIsNotNull() {
            addCriterion("usname is not null");
            return (Criteria) this;
        }

        public Criteria andUsnameEqualTo(String value) {
            addCriterion("usname =", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameNotEqualTo(String value) {
            addCriterion("usname <>", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameGreaterThan(String value) {
            addCriterion("usname >", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameGreaterThanOrEqualTo(String value) {
            addCriterion("usname >=", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameLessThan(String value) {
            addCriterion("usname <", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameLessThanOrEqualTo(String value) {
            addCriterion("usname <=", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameLike(String value) {
            addCriterion("usname like", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameNotLike(String value) {
            addCriterion("usname not like", value, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameIn(List<String> values) {
            addCriterion("usname in", values, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameNotIn(List<String> values) {
            addCriterion("usname not in", values, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameBetween(String value1, String value2) {
            addCriterion("usname between", value1, value2, "usname");
            return (Criteria) this;
        }

        public Criteria andUsnameNotBetween(String value1, String value2) {
            addCriterion("usname not between", value1, value2, "usname");
            return (Criteria) this;
        }

        public Criteria andUspasswordIsNull() {
            addCriterion("uspassword is null");
            return (Criteria) this;
        }

        public Criteria andUspasswordIsNotNull() {
            addCriterion("uspassword is not null");
            return (Criteria) this;
        }

        public Criteria andUspasswordEqualTo(String value) {
            addCriterion("uspassword =", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordNotEqualTo(String value) {
            addCriterion("uspassword <>", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordGreaterThan(String value) {
            addCriterion("uspassword >", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordGreaterThanOrEqualTo(String value) {
            addCriterion("uspassword >=", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordLessThan(String value) {
            addCriterion("uspassword <", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordLessThanOrEqualTo(String value) {
            addCriterion("uspassword <=", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordLike(String value) {
            addCriterion("uspassword like", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordNotLike(String value) {
            addCriterion("uspassword not like", value, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordIn(List<String> values) {
            addCriterion("uspassword in", values, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordNotIn(List<String> values) {
            addCriterion("uspassword not in", values, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordBetween(String value1, String value2) {
            addCriterion("uspassword between", value1, value2, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUspasswordNotBetween(String value1, String value2) {
            addCriterion("uspassword not between", value1, value2, "uspassword");
            return (Criteria) this;
        }

        public Criteria andUssaltIsNull() {
            addCriterion("ussalt is null");
            return (Criteria) this;
        }

        public Criteria andUssaltIsNotNull() {
            addCriterion("ussalt is not null");
            return (Criteria) this;
        }

        public Criteria andUssaltEqualTo(String value) {
            addCriterion("ussalt =", value, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUssaltNotEqualTo(String value) {
            addCriterion("ussalt <>", value, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUssaltGreaterThan(String value) {
            addCriterion("ussalt >", value, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUssaltGreaterThanOrEqualTo(String value) {
            addCriterion("ussalt >=", value, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUssaltLessThan(String value) {
            addCriterion("ussalt <", value, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUssaltLessThanOrEqualTo(String value) {
            addCriterion("ussalt <=", value, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUssaltLike(String value) {
            addCriterion("ussalt like", value, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUssaltNotLike(String value) {
            addCriterion("ussalt not like", value, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUssaltIn(List<String> values) {
            addCriterion("ussalt in", values, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUssaltNotIn(List<String> values) {
            addCriterion("ussalt not in", values, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUssaltBetween(String value1, String value2) {
            addCriterion("ussalt between", value1, value2, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUssaltNotBetween(String value1, String value2) {
            addCriterion("ussalt not between", value1, value2, "ussalt");
            return (Criteria) this;
        }

        public Criteria andUsphoneIsNull() {
            addCriterion("usphone is null");
            return (Criteria) this;
        }

        public Criteria andUsphoneIsNotNull() {
            addCriterion("usphone is not null");
            return (Criteria) this;
        }

        public Criteria andUsphoneEqualTo(String value) {
            addCriterion("usphone =", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneNotEqualTo(String value) {
            addCriterion("usphone <>", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneGreaterThan(String value) {
            addCriterion("usphone >", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneGreaterThanOrEqualTo(String value) {
            addCriterion("usphone >=", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneLessThan(String value) {
            addCriterion("usphone <", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneLessThanOrEqualTo(String value) {
            addCriterion("usphone <=", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneLike(String value) {
            addCriterion("usphone like", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneNotLike(String value) {
            addCriterion("usphone not like", value, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneIn(List<String> values) {
            addCriterion("usphone in", values, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneNotIn(List<String> values) {
            addCriterion("usphone not in", values, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneBetween(String value1, String value2) {
            addCriterion("usphone between", value1, value2, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsphoneNotBetween(String value1, String value2) {
            addCriterion("usphone not between", value1, value2, "usphone");
            return (Criteria) this;
        }

        public Criteria andUsstatusIsNull() {
            addCriterion("usstatus is null");
            return (Criteria) this;
        }

        public Criteria andUsstatusIsNotNull() {
            addCriterion("usstatus is not null");
            return (Criteria) this;
        }

        public Criteria andUsstatusEqualTo(String value) {
            addCriterion("usstatus =", value, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsstatusNotEqualTo(String value) {
            addCriterion("usstatus <>", value, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsstatusGreaterThan(String value) {
            addCriterion("usstatus >", value, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsstatusGreaterThanOrEqualTo(String value) {
            addCriterion("usstatus >=", value, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsstatusLessThan(String value) {
            addCriterion("usstatus <", value, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsstatusLessThanOrEqualTo(String value) {
            addCriterion("usstatus <=", value, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsstatusLike(String value) {
            addCriterion("usstatus like", value, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsstatusNotLike(String value) {
            addCriterion("usstatus not like", value, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsstatusIn(List<String> values) {
            addCriterion("usstatus in", values, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsstatusNotIn(List<String> values) {
            addCriterion("usstatus not in", values, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsstatusBetween(String value1, String value2) {
            addCriterion("usstatus between", value1, value2, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsstatusNotBetween(String value1, String value2) {
            addCriterion("usstatus not between", value1, value2, "usstatus");
            return (Criteria) this;
        }

        public Criteria andUsroleIsNull() {
            addCriterion("usrole is null");
            return (Criteria) this;
        }

        public Criteria andUsroleIsNotNull() {
            addCriterion("usrole is not null");
            return (Criteria) this;
        }

        public Criteria andUsroleEqualTo(String value) {
            addCriterion("usrole =", value, "usrole");
            return (Criteria) this;
        }

        public Criteria andUsroleNotEqualTo(String value) {
            addCriterion("usrole <>", value, "usrole");
            return (Criteria) this;
        }

        public Criteria andUsroleGreaterThan(String value) {
            addCriterion("usrole >", value, "usrole");
            return (Criteria) this;
        }

        public Criteria andUsroleGreaterThanOrEqualTo(String value) {
            addCriterion("usrole >=", value, "usrole");
            return (Criteria) this;
        }

        public Criteria andUsroleLessThan(String value) {
            addCriterion("usrole <", value, "usrole");
            return (Criteria) this;
        }

        public Criteria andUsroleLessThanOrEqualTo(String value) {
            addCriterion("usrole <=", value, "usrole");
            return (Criteria) this;
        }

        public Criteria andUsroleLike(String value) {
            addCriterion("usrole like", value, "usrole");
            return (Criteria) this;
        }

        public Criteria andUsroleNotLike(String value) {
            addCriterion("usrole not like", value, "usrole");
            return (Criteria) this;
        }

        public Criteria andUsroleIn(List<String> values) {
            addCriterion("usrole in", values, "usrole");
            return (Criteria) this;
        }

        public Criteria andUsroleNotIn(List<String> values) {
            addCriterion("usrole not in", values, "usrole");
            return (Criteria) this;
        }

        public Criteria andUsroleBetween(String value1, String value2) {
            addCriterion("usrole between", value1, value2, "usrole");
            return (Criteria) this;
        }

        public Criteria andUsroleNotBetween(String value1, String value2) {
            addCriterion("usrole not between", value1, value2, "usrole");
            return (Criteria) this;
        }

        public Criteria andUscreateIsNull() {
            addCriterion("uscreate is null");
            return (Criteria) this;
        }

        public Criteria andUscreateIsNotNull() {
            addCriterion("uscreate is not null");
            return (Criteria) this;
        }

        public Criteria andUscreateEqualTo(Date value) {
            addCriterion("uscreate =", value, "uscreate");
            return (Criteria) this;
        }

        public Criteria andUscreateNotEqualTo(Date value) {
            addCriterion("uscreate <>", value, "uscreate");
            return (Criteria) this;
        }

        public Criteria andUscreateGreaterThan(Date value) {
            addCriterion("uscreate >", value, "uscreate");
            return (Criteria) this;
        }

        public Criteria andUscreateGreaterThanOrEqualTo(Date value) {
            addCriterion("uscreate >=", value, "uscreate");
            return (Criteria) this;
        }

        public Criteria andUscreateLessThan(Date value) {
            addCriterion("uscreate <", value, "uscreate");
            return (Criteria) this;
        }

        public Criteria andUscreateLessThanOrEqualTo(Date value) {
            addCriterion("uscreate <=", value, "uscreate");
            return (Criteria) this;
        }

        public Criteria andUscreateIn(List<Date> values) {
            addCriterion("uscreate in", values, "uscreate");
            return (Criteria) this;
        }

        public Criteria andUscreateNotIn(List<Date> values) {
            addCriterion("uscreate not in", values, "uscreate");
            return (Criteria) this;
        }

        public Criteria andUscreateBetween(Date value1, Date value2) {
            addCriterion("uscreate between", value1, value2, "uscreate");
            return (Criteria) this;
        }

        public Criteria andUscreateNotBetween(Date value1, Date value2) {
            addCriterion("uscreate not between", value1, value2, "uscreate");
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