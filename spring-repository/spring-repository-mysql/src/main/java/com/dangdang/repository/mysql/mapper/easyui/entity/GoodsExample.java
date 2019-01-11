package com.dangdang.repository.mysql.mapper.easyui.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGonameIsNull() {
            addCriterion("goname is null");
            return (Criteria) this;
        }

        public Criteria andGonameIsNotNull() {
            addCriterion("goname is not null");
            return (Criteria) this;
        }

        public Criteria andGonameEqualTo(String value) {
            addCriterion("goname =", value, "goname");
            return (Criteria) this;
        }

        public Criteria andGonameNotEqualTo(String value) {
            addCriterion("goname <>", value, "goname");
            return (Criteria) this;
        }

        public Criteria andGonameGreaterThan(String value) {
            addCriterion("goname >", value, "goname");
            return (Criteria) this;
        }

        public Criteria andGonameGreaterThanOrEqualTo(String value) {
            addCriterion("goname >=", value, "goname");
            return (Criteria) this;
        }

        public Criteria andGonameLessThan(String value) {
            addCriterion("goname <", value, "goname");
            return (Criteria) this;
        }

        public Criteria andGonameLessThanOrEqualTo(String value) {
            addCriterion("goname <=", value, "goname");
            return (Criteria) this;
        }

        public Criteria andGonameLike(String value) {
            addCriterion("goname like", value, "goname");
            return (Criteria) this;
        }

        public Criteria andGonameNotLike(String value) {
            addCriterion("goname not like", value, "goname");
            return (Criteria) this;
        }

        public Criteria andGonameIn(List<String> values) {
            addCriterion("goname in", values, "goname");
            return (Criteria) this;
        }

        public Criteria andGonameNotIn(List<String> values) {
            addCriterion("goname not in", values, "goname");
            return (Criteria) this;
        }

        public Criteria andGonameBetween(String value1, String value2) {
            addCriterion("goname between", value1, value2, "goname");
            return (Criteria) this;
        }

        public Criteria andGonameNotBetween(String value1, String value2) {
            addCriterion("goname not between", value1, value2, "goname");
            return (Criteria) this;
        }

        public Criteria andGopriceIsNull() {
            addCriterion("goprice is null");
            return (Criteria) this;
        }

        public Criteria andGopriceIsNotNull() {
            addCriterion("goprice is not null");
            return (Criteria) this;
        }

        public Criteria andGopriceEqualTo(Long value) {
            addCriterion("goprice =", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceNotEqualTo(Long value) {
            addCriterion("goprice <>", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceGreaterThan(Long value) {
            addCriterion("goprice >", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceGreaterThanOrEqualTo(Long value) {
            addCriterion("goprice >=", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceLessThan(Long value) {
            addCriterion("goprice <", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceLessThanOrEqualTo(Long value) {
            addCriterion("goprice <=", value, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceIn(List<Long> values) {
            addCriterion("goprice in", values, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceNotIn(List<Long> values) {
            addCriterion("goprice not in", values, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceBetween(Long value1, Long value2) {
            addCriterion("goprice between", value1, value2, "goprice");
            return (Criteria) this;
        }

        public Criteria andGopriceNotBetween(Long value1, Long value2) {
            addCriterion("goprice not between", value1, value2, "goprice");
            return (Criteria) this;
        }

        public Criteria andGoshupriceIsNull() {
            addCriterion("goshuprice is null");
            return (Criteria) this;
        }

        public Criteria andGoshupriceIsNotNull() {
            addCriterion("goshuprice is not null");
            return (Criteria) this;
        }

        public Criteria andGoshupriceEqualTo(Long value) {
            addCriterion("goshuprice =", value, "goshuprice");
            return (Criteria) this;
        }

        public Criteria andGoshupriceNotEqualTo(Long value) {
            addCriterion("goshuprice <>", value, "goshuprice");
            return (Criteria) this;
        }

        public Criteria andGoshupriceGreaterThan(Long value) {
            addCriterion("goshuprice >", value, "goshuprice");
            return (Criteria) this;
        }

        public Criteria andGoshupriceGreaterThanOrEqualTo(Long value) {
            addCriterion("goshuprice >=", value, "goshuprice");
            return (Criteria) this;
        }

        public Criteria andGoshupriceLessThan(Long value) {
            addCriterion("goshuprice <", value, "goshuprice");
            return (Criteria) this;
        }

        public Criteria andGoshupriceLessThanOrEqualTo(Long value) {
            addCriterion("goshuprice <=", value, "goshuprice");
            return (Criteria) this;
        }

        public Criteria andGoshupriceIn(List<Long> values) {
            addCriterion("goshuprice in", values, "goshuprice");
            return (Criteria) this;
        }

        public Criteria andGoshupriceNotIn(List<Long> values) {
            addCriterion("goshuprice not in", values, "goshuprice");
            return (Criteria) this;
        }

        public Criteria andGoshupriceBetween(Long value1, Long value2) {
            addCriterion("goshuprice between", value1, value2, "goshuprice");
            return (Criteria) this;
        }

        public Criteria andGoshupriceNotBetween(Long value1, Long value2) {
            addCriterion("goshuprice not between", value1, value2, "goshuprice");
            return (Criteria) this;
        }

        public Criteria andGosalescountIsNull() {
            addCriterion("gosalescount is null");
            return (Criteria) this;
        }

        public Criteria andGosalescountIsNotNull() {
            addCriterion("gosalescount is not null");
            return (Criteria) this;
        }

        public Criteria andGosalescountEqualTo(Integer value) {
            addCriterion("gosalescount =", value, "gosalescount");
            return (Criteria) this;
        }

        public Criteria andGosalescountNotEqualTo(Integer value) {
            addCriterion("gosalescount <>", value, "gosalescount");
            return (Criteria) this;
        }

        public Criteria andGosalescountGreaterThan(Integer value) {
            addCriterion("gosalescount >", value, "gosalescount");
            return (Criteria) this;
        }

        public Criteria andGosalescountGreaterThanOrEqualTo(Integer value) {
            addCriterion("gosalescount >=", value, "gosalescount");
            return (Criteria) this;
        }

        public Criteria andGosalescountLessThan(Integer value) {
            addCriterion("gosalescount <", value, "gosalescount");
            return (Criteria) this;
        }

        public Criteria andGosalescountLessThanOrEqualTo(Integer value) {
            addCriterion("gosalescount <=", value, "gosalescount");
            return (Criteria) this;
        }

        public Criteria andGosalescountIn(List<Integer> values) {
            addCriterion("gosalescount in", values, "gosalescount");
            return (Criteria) this;
        }

        public Criteria andGosalescountNotIn(List<Integer> values) {
            addCriterion("gosalescount not in", values, "gosalescount");
            return (Criteria) this;
        }

        public Criteria andGosalescountBetween(Integer value1, Integer value2) {
            addCriterion("gosalescount between", value1, value2, "gosalescount");
            return (Criteria) this;
        }

        public Criteria andGosalescountNotBetween(Integer value1, Integer value2) {
            addCriterion("gosalescount not between", value1, value2, "gosalescount");
            return (Criteria) this;
        }

        public Criteria andGoimageIsNull() {
            addCriterion("goimage is null");
            return (Criteria) this;
        }

        public Criteria andGoimageIsNotNull() {
            addCriterion("goimage is not null");
            return (Criteria) this;
        }

        public Criteria andGoimageEqualTo(String value) {
            addCriterion("goimage =", value, "goimage");
            return (Criteria) this;
        }

        public Criteria andGoimageNotEqualTo(String value) {
            addCriterion("goimage <>", value, "goimage");
            return (Criteria) this;
        }

        public Criteria andGoimageGreaterThan(String value) {
            addCriterion("goimage >", value, "goimage");
            return (Criteria) this;
        }

        public Criteria andGoimageGreaterThanOrEqualTo(String value) {
            addCriterion("goimage >=", value, "goimage");
            return (Criteria) this;
        }

        public Criteria andGoimageLessThan(String value) {
            addCriterion("goimage <", value, "goimage");
            return (Criteria) this;
        }

        public Criteria andGoimageLessThanOrEqualTo(String value) {
            addCriterion("goimage <=", value, "goimage");
            return (Criteria) this;
        }

        public Criteria andGoimageLike(String value) {
            addCriterion("goimage like", value, "goimage");
            return (Criteria) this;
        }

        public Criteria andGoimageNotLike(String value) {
            addCriterion("goimage not like", value, "goimage");
            return (Criteria) this;
        }

        public Criteria andGoimageIn(List<String> values) {
            addCriterion("goimage in", values, "goimage");
            return (Criteria) this;
        }

        public Criteria andGoimageNotIn(List<String> values) {
            addCriterion("goimage not in", values, "goimage");
            return (Criteria) this;
        }

        public Criteria andGoimageBetween(String value1, String value2) {
            addCriterion("goimage between", value1, value2, "goimage");
            return (Criteria) this;
        }

        public Criteria andGoimageNotBetween(String value1, String value2) {
            addCriterion("goimage not between", value1, value2, "goimage");
            return (Criteria) this;
        }

        public Criteria andGostockIsNull() {
            addCriterion("gostock is null");
            return (Criteria) this;
        }

        public Criteria andGostockIsNotNull() {
            addCriterion("gostock is not null");
            return (Criteria) this;
        }

        public Criteria andGostockEqualTo(Integer value) {
            addCriterion("gostock =", value, "gostock");
            return (Criteria) this;
        }

        public Criteria andGostockNotEqualTo(Integer value) {
            addCriterion("gostock <>", value, "gostock");
            return (Criteria) this;
        }

        public Criteria andGostockGreaterThan(Integer value) {
            addCriterion("gostock >", value, "gostock");
            return (Criteria) this;
        }

        public Criteria andGostockGreaterThanOrEqualTo(Integer value) {
            addCriterion("gostock >=", value, "gostock");
            return (Criteria) this;
        }

        public Criteria andGostockLessThan(Integer value) {
            addCriterion("gostock <", value, "gostock");
            return (Criteria) this;
        }

        public Criteria andGostockLessThanOrEqualTo(Integer value) {
            addCriterion("gostock <=", value, "gostock");
            return (Criteria) this;
        }

        public Criteria andGostockIn(List<Integer> values) {
            addCriterion("gostock in", values, "gostock");
            return (Criteria) this;
        }

        public Criteria andGostockNotIn(List<Integer> values) {
            addCriterion("gostock not in", values, "gostock");
            return (Criteria) this;
        }

        public Criteria andGostockBetween(Integer value1, Integer value2) {
            addCriterion("gostock between", value1, value2, "gostock");
            return (Criteria) this;
        }

        public Criteria andGostockNotBetween(Integer value1, Integer value2) {
            addCriterion("gostock not between", value1, value2, "gostock");
            return (Criteria) this;
        }

        public Criteria andGoviewcountIsNull() {
            addCriterion("goviewcount is null");
            return (Criteria) this;
        }

        public Criteria andGoviewcountIsNotNull() {
            addCriterion("goviewcount is not null");
            return (Criteria) this;
        }

        public Criteria andGoviewcountEqualTo(Integer value) {
            addCriterion("goviewcount =", value, "goviewcount");
            return (Criteria) this;
        }

        public Criteria andGoviewcountNotEqualTo(Integer value) {
            addCriterion("goviewcount <>", value, "goviewcount");
            return (Criteria) this;
        }

        public Criteria andGoviewcountGreaterThan(Integer value) {
            addCriterion("goviewcount >", value, "goviewcount");
            return (Criteria) this;
        }

        public Criteria andGoviewcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goviewcount >=", value, "goviewcount");
            return (Criteria) this;
        }

        public Criteria andGoviewcountLessThan(Integer value) {
            addCriterion("goviewcount <", value, "goviewcount");
            return (Criteria) this;
        }

        public Criteria andGoviewcountLessThanOrEqualTo(Integer value) {
            addCriterion("goviewcount <=", value, "goviewcount");
            return (Criteria) this;
        }

        public Criteria andGoviewcountIn(List<Integer> values) {
            addCriterion("goviewcount in", values, "goviewcount");
            return (Criteria) this;
        }

        public Criteria andGoviewcountNotIn(List<Integer> values) {
            addCriterion("goviewcount not in", values, "goviewcount");
            return (Criteria) this;
        }

        public Criteria andGoviewcountBetween(Integer value1, Integer value2) {
            addCriterion("goviewcount between", value1, value2, "goviewcount");
            return (Criteria) this;
        }

        public Criteria andGoviewcountNotBetween(Integer value1, Integer value2) {
            addCriterion("goviewcount not between", value1, value2, "goviewcount");
            return (Criteria) this;
        }

        public Criteria andGonumberIsNull() {
            addCriterion("gonumber is null");
            return (Criteria) this;
        }

        public Criteria andGonumberIsNotNull() {
            addCriterion("gonumber is not null");
            return (Criteria) this;
        }

        public Criteria andGonumberEqualTo(String value) {
            addCriterion("gonumber =", value, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGonumberNotEqualTo(String value) {
            addCriterion("gonumber <>", value, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGonumberGreaterThan(String value) {
            addCriterion("gonumber >", value, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGonumberGreaterThanOrEqualTo(String value) {
            addCriterion("gonumber >=", value, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGonumberLessThan(String value) {
            addCriterion("gonumber <", value, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGonumberLessThanOrEqualTo(String value) {
            addCriterion("gonumber <=", value, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGonumberLike(String value) {
            addCriterion("gonumber like", value, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGonumberNotLike(String value) {
            addCriterion("gonumber not like", value, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGonumberIn(List<String> values) {
            addCriterion("gonumber in", values, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGonumberNotIn(List<String> values) {
            addCriterion("gonumber not in", values, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGonumberBetween(String value1, String value2) {
            addCriterion("gonumber between", value1, value2, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGonumberNotBetween(String value1, String value2) {
            addCriterion("gonumber not between", value1, value2, "gonumber");
            return (Criteria) this;
        }

        public Criteria andGoaddressIsNull() {
            addCriterion("goaddress is null");
            return (Criteria) this;
        }

        public Criteria andGoaddressIsNotNull() {
            addCriterion("goaddress is not null");
            return (Criteria) this;
        }

        public Criteria andGoaddressEqualTo(String value) {
            addCriterion("goaddress =", value, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGoaddressNotEqualTo(String value) {
            addCriterion("goaddress <>", value, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGoaddressGreaterThan(String value) {
            addCriterion("goaddress >", value, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGoaddressGreaterThanOrEqualTo(String value) {
            addCriterion("goaddress >=", value, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGoaddressLessThan(String value) {
            addCriterion("goaddress <", value, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGoaddressLessThanOrEqualTo(String value) {
            addCriterion("goaddress <=", value, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGoaddressLike(String value) {
            addCriterion("goaddress like", value, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGoaddressNotLike(String value) {
            addCriterion("goaddress not like", value, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGoaddressIn(List<String> values) {
            addCriterion("goaddress in", values, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGoaddressNotIn(List<String> values) {
            addCriterion("goaddress not in", values, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGoaddressBetween(String value1, String value2) {
            addCriterion("goaddress between", value1, value2, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGoaddressNotBetween(String value1, String value2) {
            addCriterion("goaddress not between", value1, value2, "goaddress");
            return (Criteria) this;
        }

        public Criteria andGosizeIsNull() {
            addCriterion("gosize is null");
            return (Criteria) this;
        }

        public Criteria andGosizeIsNotNull() {
            addCriterion("gosize is not null");
            return (Criteria) this;
        }

        public Criteria andGosizeEqualTo(String value) {
            addCriterion("gosize =", value, "gosize");
            return (Criteria) this;
        }

        public Criteria andGosizeNotEqualTo(String value) {
            addCriterion("gosize <>", value, "gosize");
            return (Criteria) this;
        }

        public Criteria andGosizeGreaterThan(String value) {
            addCriterion("gosize >", value, "gosize");
            return (Criteria) this;
        }

        public Criteria andGosizeGreaterThanOrEqualTo(String value) {
            addCriterion("gosize >=", value, "gosize");
            return (Criteria) this;
        }

        public Criteria andGosizeLessThan(String value) {
            addCriterion("gosize <", value, "gosize");
            return (Criteria) this;
        }

        public Criteria andGosizeLessThanOrEqualTo(String value) {
            addCriterion("gosize <=", value, "gosize");
            return (Criteria) this;
        }

        public Criteria andGosizeLike(String value) {
            addCriterion("gosize like", value, "gosize");
            return (Criteria) this;
        }

        public Criteria andGosizeNotLike(String value) {
            addCriterion("gosize not like", value, "gosize");
            return (Criteria) this;
        }

        public Criteria andGosizeIn(List<String> values) {
            addCriterion("gosize in", values, "gosize");
            return (Criteria) this;
        }

        public Criteria andGosizeNotIn(List<String> values) {
            addCriterion("gosize not in", values, "gosize");
            return (Criteria) this;
        }

        public Criteria andGosizeBetween(String value1, String value2) {
            addCriterion("gosize between", value1, value2, "gosize");
            return (Criteria) this;
        }

        public Criteria andGosizeNotBetween(String value1, String value2) {
            addCriterion("gosize not between", value1, value2, "gosize");
            return (Criteria) this;
        }

        public Criteria andGodescriptIsNull() {
            addCriterion("godescript is null");
            return (Criteria) this;
        }

        public Criteria andGodescriptIsNotNull() {
            addCriterion("godescript is not null");
            return (Criteria) this;
        }

        public Criteria andGodescriptEqualTo(String value) {
            addCriterion("godescript =", value, "godescript");
            return (Criteria) this;
        }

        public Criteria andGodescriptNotEqualTo(String value) {
            addCriterion("godescript <>", value, "godescript");
            return (Criteria) this;
        }

        public Criteria andGodescriptGreaterThan(String value) {
            addCriterion("godescript >", value, "godescript");
            return (Criteria) this;
        }

        public Criteria andGodescriptGreaterThanOrEqualTo(String value) {
            addCriterion("godescript >=", value, "godescript");
            return (Criteria) this;
        }

        public Criteria andGodescriptLessThan(String value) {
            addCriterion("godescript <", value, "godescript");
            return (Criteria) this;
        }

        public Criteria andGodescriptLessThanOrEqualTo(String value) {
            addCriterion("godescript <=", value, "godescript");
            return (Criteria) this;
        }

        public Criteria andGodescriptLike(String value) {
            addCriterion("godescript like", value, "godescript");
            return (Criteria) this;
        }

        public Criteria andGodescriptNotLike(String value) {
            addCriterion("godescript not like", value, "godescript");
            return (Criteria) this;
        }

        public Criteria andGodescriptIn(List<String> values) {
            addCriterion("godescript in", values, "godescript");
            return (Criteria) this;
        }

        public Criteria andGodescriptNotIn(List<String> values) {
            addCriterion("godescript not in", values, "godescript");
            return (Criteria) this;
        }

        public Criteria andGodescriptBetween(String value1, String value2) {
            addCriterion("godescript between", value1, value2, "godescript");
            return (Criteria) this;
        }

        public Criteria andGodescriptNotBetween(String value1, String value2) {
            addCriterion("godescript not between", value1, value2, "godescript");
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

        public Criteria andShopidIsNull() {
            addCriterion("shopid is null");
            return (Criteria) this;
        }

        public Criteria andShopidIsNotNull() {
            addCriterion("shopid is not null");
            return (Criteria) this;
        }

        public Criteria andShopidEqualTo(String value) {
            addCriterion("shopid =", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotEqualTo(String value) {
            addCriterion("shopid <>", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThan(String value) {
            addCriterion("shopid >", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidGreaterThanOrEqualTo(String value) {
            addCriterion("shopid >=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThan(String value) {
            addCriterion("shopid <", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLessThanOrEqualTo(String value) {
            addCriterion("shopid <=", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidLike(String value) {
            addCriterion("shopid like", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotLike(String value) {
            addCriterion("shopid not like", value, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidIn(List<String> values) {
            addCriterion("shopid in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotIn(List<String> values) {
            addCriterion("shopid not in", values, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidBetween(String value1, String value2) {
            addCriterion("shopid between", value1, value2, "shopid");
            return (Criteria) this;
        }

        public Criteria andShopidNotBetween(String value1, String value2) {
            addCriterion("shopid not between", value1, value2, "shopid");
            return (Criteria) this;
        }

        public Criteria andGocreateIsNull() {
            addCriterion("gocreate is null");
            return (Criteria) this;
        }

        public Criteria andGocreateIsNotNull() {
            addCriterion("gocreate is not null");
            return (Criteria) this;
        }

        public Criteria andGocreateEqualTo(Date value) {
            addCriterion("gocreate =", value, "gocreate");
            return (Criteria) this;
        }

        public Criteria andGocreateNotEqualTo(Date value) {
            addCriterion("gocreate <>", value, "gocreate");
            return (Criteria) this;
        }

        public Criteria andGocreateGreaterThan(Date value) {
            addCriterion("gocreate >", value, "gocreate");
            return (Criteria) this;
        }

        public Criteria andGocreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gocreate >=", value, "gocreate");
            return (Criteria) this;
        }

        public Criteria andGocreateLessThan(Date value) {
            addCriterion("gocreate <", value, "gocreate");
            return (Criteria) this;
        }

        public Criteria andGocreateLessThanOrEqualTo(Date value) {
            addCriterion("gocreate <=", value, "gocreate");
            return (Criteria) this;
        }

        public Criteria andGocreateIn(List<Date> values) {
            addCriterion("gocreate in", values, "gocreate");
            return (Criteria) this;
        }

        public Criteria andGocreateNotIn(List<Date> values) {
            addCriterion("gocreate not in", values, "gocreate");
            return (Criteria) this;
        }

        public Criteria andGocreateBetween(Date value1, Date value2) {
            addCriterion("gocreate between", value1, value2, "gocreate");
            return (Criteria) this;
        }

        public Criteria andGocreateNotBetween(Date value1, Date value2) {
            addCriterion("gocreate not between", value1, value2, "gocreate");
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