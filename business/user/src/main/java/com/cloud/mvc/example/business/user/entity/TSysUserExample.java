package com.cloud.mvc.example.business.user.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TSysUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int start = -1;

    protected int limit = -1;

    public TSysUserExample() {
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
        this.start = -1;
        this.limit = -1;
    }

    public TSysUserExample start(int start) {
        this.start=start;
        return this;
    }

    public int getStart() {
        return start;
    }

    public TSysUserExample limit(int limit) {
        this.limit=limit;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public Criteria getCriteria() {
        if (oredCriteria.size() != 0) {return oredCriteria.get(0);}
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public static TSysUserExample create() {
        return new TSysUserExample();
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

        public Criteria andFidIsNull() {
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Long value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Long value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Long value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Long value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Long value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Long value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Long> values) {
            addCriterion("fid in", values, "fid");
            if (values.size() > 2000){
                  throw new RuntimeException("values size to long ,please change batch method");
            }
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Long> values) {
            addCriterion("fid not in", values, "fid");
            if (values.size() > 2000){
                  throw new RuntimeException("values size to long ,please change batch method");
            }
            return (Criteria) this;
        }

        public Criteria andFidBetween(Long value1, Long value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Long value1, Long value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFusernameIsNull() {
            addCriterion("fusername is null");
            return (Criteria) this;
        }

        public Criteria andFusernameIsNotNull() {
            addCriterion("fusername is not null");
            return (Criteria) this;
        }

        public Criteria andFusernameEqualTo(String value) {
            addCriterion("fusername =", value, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameNotEqualTo(String value) {
            addCriterion("fusername <>", value, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameGreaterThan(String value) {
            addCriterion("fusername >", value, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameGreaterThanOrEqualTo(String value) {
            addCriterion("fusername >=", value, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameLessThan(String value) {
            addCriterion("fusername <", value, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameLessThanOrEqualTo(String value) {
            addCriterion("fusername <=", value, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameLike(String value) {
            addCriterion("fusername like", value, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameNotLike(String value) {
            addCriterion("fusername not like", value, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameIn(List<String> values) {
            addCriterion("fusername in", values, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameNotIn(List<String> values) {
            addCriterion("fusername not in", values, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameBetween(String value1, String value2) {
            addCriterion("fusername between", value1, value2, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameNotBetween(String value1, String value2) {
            addCriterion("fusername not between", value1, value2, "fusername");
            return (Criteria) this;
        }

        public Criteria andFpasswordIsNull() {
            addCriterion("fpassword is null");
            return (Criteria) this;
        }

        public Criteria andFpasswordIsNotNull() {
            addCriterion("fpassword is not null");
            return (Criteria) this;
        }

        public Criteria andFpasswordEqualTo(String value) {
            addCriterion("fpassword =", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordNotEqualTo(String value) {
            addCriterion("fpassword <>", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordGreaterThan(String value) {
            addCriterion("fpassword >", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("fpassword >=", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordLessThan(String value) {
            addCriterion("fpassword <", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordLessThanOrEqualTo(String value) {
            addCriterion("fpassword <=", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordLike(String value) {
            addCriterion("fpassword like", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordNotLike(String value) {
            addCriterion("fpassword not like", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordIn(List<String> values) {
            addCriterion("fpassword in", values, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordNotIn(List<String> values) {
            addCriterion("fpassword not in", values, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordBetween(String value1, String value2) {
            addCriterion("fpassword between", value1, value2, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordNotBetween(String value1, String value2) {
            addCriterion("fpassword not between", value1, value2, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFemailIsNull() {
            addCriterion("femail is null");
            return (Criteria) this;
        }

        public Criteria andFemailIsNotNull() {
            addCriterion("femail is not null");
            return (Criteria) this;
        }

        public Criteria andFemailEqualTo(String value) {
            addCriterion("femail =", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailNotEqualTo(String value) {
            addCriterion("femail <>", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailGreaterThan(String value) {
            addCriterion("femail >", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailGreaterThanOrEqualTo(String value) {
            addCriterion("femail >=", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailLessThan(String value) {
            addCriterion("femail <", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailLessThanOrEqualTo(String value) {
            addCriterion("femail <=", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailLike(String value) {
            addCriterion("femail like", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailNotLike(String value) {
            addCriterion("femail not like", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailIn(List<String> values) {
            addCriterion("femail in", values, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailNotIn(List<String> values) {
            addCriterion("femail not in", values, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailBetween(String value1, String value2) {
            addCriterion("femail between", value1, value2, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailNotBetween(String value1, String value2) {
            addCriterion("femail not between", value1, value2, "femail");
            return (Criteria) this;
        }

        public Criteria andForgpathIsNull() {
            addCriterion("forgpath is null");
            return (Criteria) this;
        }

        public Criteria andForgpathIsNotNull() {
            addCriterion("forgpath is not null");
            return (Criteria) this;
        }

        public Criteria andForgpathEqualTo(String value) {
            addCriterion("forgpath =", value, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathNotEqualTo(String value) {
            addCriterion("forgpath <>", value, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathGreaterThan(String value) {
            addCriterion("forgpath >", value, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathGreaterThanOrEqualTo(String value) {
            addCriterion("forgpath >=", value, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathLessThan(String value) {
            addCriterion("forgpath <", value, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathLessThanOrEqualTo(String value) {
            addCriterion("forgpath <=", value, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathLike(String value) {
            addCriterion("forgpath like", value, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathNotLike(String value) {
            addCriterion("forgpath not like", value, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathIn(List<String> values) {
            addCriterion("forgpath in", values, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathNotIn(List<String> values) {
            addCriterion("forgpath not in", values, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathBetween(String value1, String value2) {
            addCriterion("forgpath between", value1, value2, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathNotBetween(String value1, String value2) {
            addCriterion("forgpath not between", value1, value2, "forgpath");
            return (Criteria) this;
        }

        public Criteria andFkorgidIsNull() {
            addCriterion("fkorgid is null");
            return (Criteria) this;
        }

        public Criteria andFkorgidIsNotNull() {
            addCriterion("fkorgid is not null");
            return (Criteria) this;
        }

        public Criteria andFkorgidEqualTo(Long value) {
            addCriterion("fkorgid =", value, "fkorgid");
            return (Criteria) this;
        }

        public Criteria andFkorgidNotEqualTo(Long value) {
            addCriterion("fkorgid <>", value, "fkorgid");
            return (Criteria) this;
        }

        public Criteria andFkorgidGreaterThan(Long value) {
            addCriterion("fkorgid >", value, "fkorgid");
            return (Criteria) this;
        }

        public Criteria andFkorgidGreaterThanOrEqualTo(Long value) {
            addCriterion("fkorgid >=", value, "fkorgid");
            return (Criteria) this;
        }

        public Criteria andFkorgidLessThan(Long value) {
            addCriterion("fkorgid <", value, "fkorgid");
            return (Criteria) this;
        }

        public Criteria andFkorgidLessThanOrEqualTo(Long value) {
            addCriterion("fkorgid <=", value, "fkorgid");
            return (Criteria) this;
        }

        public Criteria andFkorgidIn(List<Long> values) {
            addCriterion("fkorgid in", values, "fkorgid");
            if (values.size() > 2000){
                  throw new RuntimeException("values size to long ,please change batch method");
            }
            return (Criteria) this;
        }

        public Criteria andFkorgidNotIn(List<Long> values) {
            addCriterion("fkorgid not in", values, "fkorgid");
            if (values.size() > 2000){
                  throw new RuntimeException("values size to long ,please change batch method");
            }
            return (Criteria) this;
        }

        public Criteria andFkorgidBetween(Long value1, Long value2) {
            addCriterion("fkorgid between", value1, value2, "fkorgid");
            return (Criteria) this;
        }

        public Criteria andFkorgidNotBetween(Long value1, Long value2) {
            addCriterion("fkorgid not between", value1, value2, "fkorgid");
            return (Criteria) this;
        }

        public Criteria andFnameIsNull() {
            addCriterion("fname is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("fname is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("fname =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("fname <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("fname >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("fname >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("fname <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("fname <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("fname like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("fname not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("fname in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("fname not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("fname between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("fname not between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFidcardIsNull() {
            addCriterion("fidcard is null");
            return (Criteria) this;
        }

        public Criteria andFidcardIsNotNull() {
            addCriterion("fidcard is not null");
            return (Criteria) this;
        }

        public Criteria andFidcardEqualTo(String value) {
            addCriterion("fidcard =", value, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFidcardNotEqualTo(String value) {
            addCriterion("fidcard <>", value, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFidcardGreaterThan(String value) {
            addCriterion("fidcard >", value, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFidcardGreaterThanOrEqualTo(String value) {
            addCriterion("fidcard >=", value, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFidcardLessThan(String value) {
            addCriterion("fidcard <", value, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFidcardLessThanOrEqualTo(String value) {
            addCriterion("fidcard <=", value, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFidcardLike(String value) {
            addCriterion("fidcard like", value, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFidcardNotLike(String value) {
            addCriterion("fidcard not like", value, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFidcardIn(List<String> values) {
            addCriterion("fidcard in", values, "fidcard");
            if (values.size() > 2000){
                  throw new RuntimeException("values size to long ,please change batch method");
            }
            return (Criteria) this;
        }

        public Criteria andFidcardNotIn(List<String> values) {
            addCriterion("fidcard not in", values, "fidcard");
            if (values.size() > 2000){
                  throw new RuntimeException("values size to long ,please change batch method");
            }
            return (Criteria) this;
        }

        public Criteria andFidcardBetween(String value1, String value2) {
            addCriterion("fidcard between", value1, value2, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFidcardNotBetween(String value1, String value2) {
            addCriterion("fidcard not between", value1, value2, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFphonenoIsNull() {
            addCriterion("fphoneno is null");
            return (Criteria) this;
        }

        public Criteria andFphonenoIsNotNull() {
            addCriterion("fphoneno is not null");
            return (Criteria) this;
        }

        public Criteria andFphonenoEqualTo(String value) {
            addCriterion("fphoneno =", value, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoNotEqualTo(String value) {
            addCriterion("fphoneno <>", value, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoGreaterThan(String value) {
            addCriterion("fphoneno >", value, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoGreaterThanOrEqualTo(String value) {
            addCriterion("fphoneno >=", value, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoLessThan(String value) {
            addCriterion("fphoneno <", value, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoLessThanOrEqualTo(String value) {
            addCriterion("fphoneno <=", value, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoLike(String value) {
            addCriterion("fphoneno like", value, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoNotLike(String value) {
            addCriterion("fphoneno not like", value, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoIn(List<String> values) {
            addCriterion("fphoneno in", values, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoNotIn(List<String> values) {
            addCriterion("fphoneno not in", values, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoBetween(String value1, String value2) {
            addCriterion("fphoneno between", value1, value2, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoNotBetween(String value1, String value2) {
            addCriterion("fphoneno not between", value1, value2, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFctimeIsNull() {
            addCriterion("fctime is null");
            return (Criteria) this;
        }

        public Criteria andFctimeIsNotNull() {
            addCriterion("fctime is not null");
            return (Criteria) this;
        }

        public Criteria andFctimeEqualTo(LocalDateTime value) {
            addCriterion("fctime =", value, "fctime");
            return (Criteria) this;
        }

        public Criteria andFctimeNotEqualTo(LocalDateTime value) {
            addCriterion("fctime <>", value, "fctime");
            return (Criteria) this;
        }

        public Criteria andFctimeGreaterThan(LocalDateTime value) {
            addCriterion("fctime >", value, "fctime");
            return (Criteria) this;
        }

        public Criteria andFctimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("fctime >=", value, "fctime");
            return (Criteria) this;
        }

        public Criteria andFctimeLessThan(LocalDateTime value) {
            addCriterion("fctime <", value, "fctime");
            return (Criteria) this;
        }

        public Criteria andFctimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("fctime <=", value, "fctime");
            return (Criteria) this;
        }

        public Criteria andFctimeIn(List<LocalDateTime> values) {
            addCriterion("fctime in", values, "fctime");
            return (Criteria) this;
        }

        public Criteria andFctimeNotIn(List<LocalDateTime> values) {
            addCriterion("fctime not in", values, "fctime");
            return (Criteria) this;
        }

        public Criteria andFctimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("fctime between", value1, value2, "fctime");
            return (Criteria) this;
        }

        public Criteria andFctimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("fctime not between", value1, value2, "fctime");
            return (Criteria) this;
        }

        public Criteria andFkuseridIsNull() {
            addCriterion("fkuserid is null");
            return (Criteria) this;
        }

        public Criteria andFkuseridIsNotNull() {
            addCriterion("fkuserid is not null");
            return (Criteria) this;
        }

        public Criteria andFkuseridEqualTo(Long value) {
            addCriterion("fkuserid =", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridNotEqualTo(Long value) {
            addCriterion("fkuserid <>", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridGreaterThan(Long value) {
            addCriterion("fkuserid >", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridGreaterThanOrEqualTo(Long value) {
            addCriterion("fkuserid >=", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridLessThan(Long value) {
            addCriterion("fkuserid <", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridLessThanOrEqualTo(Long value) {
            addCriterion("fkuserid <=", value, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridIn(List<Long> values) {
            addCriterion("fkuserid in", values, "fkuserid");
            if (values.size() > 2000){
                  throw new RuntimeException("values size to long ,please change batch method");
            }
            return (Criteria) this;
        }

        public Criteria andFkuseridNotIn(List<Long> values) {
            addCriterion("fkuserid not in", values, "fkuserid");
            if (values.size() > 2000){
                  throw new RuntimeException("values size to long ,please change batch method");
            }
            return (Criteria) this;
        }

        public Criteria andFkuseridBetween(Long value1, Long value2) {
            addCriterion("fkuserid between", value1, value2, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFkuseridNotBetween(Long value1, Long value2) {
            addCriterion("fkuserid not between", value1, value2, "fkuserid");
            return (Criteria) this;
        }

        public Criteria andFisdeleteIsNull() {
            addCriterion("fisdelete is null");
            return (Criteria) this;
        }

        public Criteria andFisdeleteIsNotNull() {
            addCriterion("fisdelete is not null");
            return (Criteria) this;
        }

        public Criteria andFisdeleteEqualTo(Short value) {
            addCriterion("fisdelete =", value, "fisdelete");
            return (Criteria) this;
        }

        public Criteria andFisdeleteNotEqualTo(Short value) {
            addCriterion("fisdelete <>", value, "fisdelete");
            return (Criteria) this;
        }

        public Criteria andFisdeleteGreaterThan(Short value) {
            addCriterion("fisdelete >", value, "fisdelete");
            return (Criteria) this;
        }

        public Criteria andFisdeleteGreaterThanOrEqualTo(Short value) {
            addCriterion("fisdelete >=", value, "fisdelete");
            return (Criteria) this;
        }

        public Criteria andFisdeleteLessThan(Short value) {
            addCriterion("fisdelete <", value, "fisdelete");
            return (Criteria) this;
        }

        public Criteria andFisdeleteLessThanOrEqualTo(Short value) {
            addCriterion("fisdelete <=", value, "fisdelete");
            return (Criteria) this;
        }

        public Criteria andFisdeleteIn(List<Short> values) {
            addCriterion("fisdelete in", values, "fisdelete");
            return (Criteria) this;
        }

        public Criteria andFisdeleteNotIn(List<Short> values) {
            addCriterion("fisdelete not in", values, "fisdelete");
            return (Criteria) this;
        }

        public Criteria andFisdeleteBetween(Short value1, Short value2) {
            addCriterion("fisdelete between", value1, value2, "fisdelete");
            return (Criteria) this;
        }

        public Criteria andFisdeleteNotBetween(Short value1, Short value2) {
            addCriterion("fisdelete not between", value1, value2, "fisdelete");
            return (Criteria) this;
        }

        public Criteria andFutimeIsNull() {
            addCriterion("futime is null");
            return (Criteria) this;
        }

        public Criteria andFutimeIsNotNull() {
            addCriterion("futime is not null");
            return (Criteria) this;
        }

        public Criteria andFutimeEqualTo(LocalDateTime value) {
            addCriterion("futime =", value, "futime");
            return (Criteria) this;
        }

        public Criteria andFutimeNotEqualTo(LocalDateTime value) {
            addCriterion("futime <>", value, "futime");
            return (Criteria) this;
        }

        public Criteria andFutimeGreaterThan(LocalDateTime value) {
            addCriterion("futime >", value, "futime");
            return (Criteria) this;
        }

        public Criteria andFutimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("futime >=", value, "futime");
            return (Criteria) this;
        }

        public Criteria andFutimeLessThan(LocalDateTime value) {
            addCriterion("futime <", value, "futime");
            return (Criteria) this;
        }

        public Criteria andFutimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("futime <=", value, "futime");
            return (Criteria) this;
        }

        public Criteria andFutimeIn(List<LocalDateTime> values) {
            addCriterion("futime in", values, "futime");
            return (Criteria) this;
        }

        public Criteria andFutimeNotIn(List<LocalDateTime> values) {
            addCriterion("futime not in", values, "futime");
            return (Criteria) this;
        }

        public Criteria andFutimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("futime between", value1, value2, "futime");
            return (Criteria) this;
        }

        public Criteria andFutimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("futime not between", value1, value2, "futime");
            return (Criteria) this;
        }

        public Criteria andFappkeyIsNull() {
            addCriterion("fappkey is null");
            return (Criteria) this;
        }

        public Criteria andFappkeyIsNotNull() {
            addCriterion("fappkey is not null");
            return (Criteria) this;
        }

        public Criteria andFappkeyEqualTo(String value) {
            addCriterion("fappkey =", value, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyNotEqualTo(String value) {
            addCriterion("fappkey <>", value, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyGreaterThan(String value) {
            addCriterion("fappkey >", value, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyGreaterThanOrEqualTo(String value) {
            addCriterion("fappkey >=", value, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyLessThan(String value) {
            addCriterion("fappkey <", value, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyLessThanOrEqualTo(String value) {
            addCriterion("fappkey <=", value, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyLike(String value) {
            addCriterion("fappkey like", value, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyNotLike(String value) {
            addCriterion("fappkey not like", value, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyIn(List<String> values) {
            addCriterion("fappkey in", values, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyNotIn(List<String> values) {
            addCriterion("fappkey not in", values, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyBetween(String value1, String value2) {
            addCriterion("fappkey between", value1, value2, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyNotBetween(String value1, String value2) {
            addCriterion("fappkey not between", value1, value2, "fappkey");
            return (Criteria) this;
        }

        public Criteria andOldidIsNull() {
            addCriterion("oldId is null");
            return (Criteria) this;
        }

        public Criteria andOldidIsNotNull() {
            addCriterion("oldId is not null");
            return (Criteria) this;
        }

        public Criteria andOldidEqualTo(Integer value) {
            addCriterion("oldId =", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidNotEqualTo(Integer value) {
            addCriterion("oldId <>", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidGreaterThan(Integer value) {
            addCriterion("oldId >", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oldId >=", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidLessThan(Integer value) {
            addCriterion("oldId <", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidLessThanOrEqualTo(Integer value) {
            addCriterion("oldId <=", value, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidIn(List<Integer> values) {
            addCriterion("oldId in", values, "oldid");
            if (values.size() > 2000){
                  throw new RuntimeException("values size to long ,please change batch method");
            }
            return (Criteria) this;
        }

        public Criteria andOldidNotIn(List<Integer> values) {
            addCriterion("oldId not in", values, "oldid");
            if (values.size() > 2000){
                  throw new RuntimeException("values size to long ,please change batch method");
            }
            return (Criteria) this;
        }

        public Criteria andOldidBetween(Integer value1, Integer value2) {
            addCriterion("oldId between", value1, value2, "oldid");
            return (Criteria) this;
        }

        public Criteria andOldidNotBetween(Integer value1, Integer value2) {
            addCriterion("oldId not between", value1, value2, "oldid");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityIsNull() {
            addCriterion("fgardenAuthority is null");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityIsNotNull() {
            addCriterion("fgardenAuthority is not null");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityEqualTo(String value) {
            addCriterion("fgardenAuthority =", value, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityNotEqualTo(String value) {
            addCriterion("fgardenAuthority <>", value, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityGreaterThan(String value) {
            addCriterion("fgardenAuthority >", value, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityGreaterThanOrEqualTo(String value) {
            addCriterion("fgardenAuthority >=", value, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityLessThan(String value) {
            addCriterion("fgardenAuthority <", value, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityLessThanOrEqualTo(String value) {
            addCriterion("fgardenAuthority <=", value, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityLike(String value) {
            addCriterion("fgardenAuthority like", value, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityNotLike(String value) {
            addCriterion("fgardenAuthority not like", value, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityIn(List<String> values) {
            addCriterion("fgardenAuthority in", values, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityNotIn(List<String> values) {
            addCriterion("fgardenAuthority not in", values, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityBetween(String value1, String value2) {
            addCriterion("fgardenAuthority between", value1, value2, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityNotBetween(String value1, String value2) {
            addCriterion("fgardenAuthority not between", value1, value2, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFusernameLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fusername like", value, "fusername");
            return (Criteria) this;
        }

        public Criteria andFusernameNotLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fusername not like", value, "fusername");
            return (Criteria) this;
        }

        public Criteria andFpasswordLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fpassword like", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFpasswordNotLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fpassword not like", value, "fpassword");
            return (Criteria) this;
        }

        public Criteria andFemailLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("femail like", value, "femail");
            return (Criteria) this;
        }

        public Criteria andFemailNotLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("femail not like", value, "femail");
            return (Criteria) this;
        }

        public Criteria andForgpathLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("forgpath like", value, "forgpath");
            return (Criteria) this;
        }

        public Criteria andForgpathNotLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("forgpath not like", value, "forgpath");
            return (Criteria) this;
        }

        public Criteria andFnameLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fname like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fname not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFidcardLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fidcard like", value, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFidcardNotLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fidcard not like", value, "fidcard");
            return (Criteria) this;
        }

        public Criteria andFphonenoLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fphoneno like", value, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFphonenoNotLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fphoneno not like", value, "fphoneno");
            return (Criteria) this;
        }

        public Criteria andFappkeyLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fappkey like", value, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFappkeyNotLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fappkey not like", value, "fappkey");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fgardenAuthority like", value, "fgardenauthority");
            return (Criteria) this;
        }

        public Criteria andFgardenauthorityNotLikeBoth(String value) {
            if(value != null){
                value = "%" + value + "%";
            }
            addCriterion("fgardenAuthority not like", value, "fgardenauthority");
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