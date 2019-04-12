package com.dangdang.common.utils.page;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Create by tianjiaqin 2018/11/12
 */
@SuppressWarnings("rawtypes")
public class PageTimeResult {

    private PageTimeResult() {
    }

    public static PageTimeResult create() {
        return new PageTimeResult();
    }

    public PageTimeResult page(Integer page) {
        this.page = page;
        return this;
    }

    public PageTimeResult size(Integer size) {
        this.size = size;
        return this;
    }

    public PageTimeResult total(Long total) {
        this.total = total;
        return this;
    }

    public PageTimeResult synTime(Long synTime) {
        this.synTime = synTime;
        return this;
    }

    public <T> PageTimeResult data(List<T> list) {
        this.list = list;
        return this;
    }

    /**
     * 自动全属性拷贝
     **/
    public <E> PageTimeResult copy(Class<E> clazz, String... ignores) {
        List<E> result = new ArrayList<>();
        try {
            if (null == this.list || this.list.isEmpty()) {
                return this;
            }
            for (Object object : this.list) {
                E e = clazz.newInstance();
                BeanUtils.copyProperties(object, e, ignores);
                result.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result.size() == this.list.size()) {
            this.list = result;
        }
        return this;
    }

    @Deprecated
    @SuppressWarnings("unchecked")
    public <O, N> PageTimeResult copy(ParamsCopyHandler<O, N> handler) {
        List<N> result = new ArrayList<>();
        try {
            if (null == this.list || this.list.isEmpty()) {
                return this;
            }
//            Class<N> clazz = getGenericityClass(handler);
            for (Object object : this.list) {
                N e = handler.handle((O) object);
                result.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result.size() == this.list.size()) {
            this.list = result;
        }
        return this;
    }

    /**
     * 自定义属性拷贝
     **/
    public <O, N> PageTimeResult copy(List<O> data, ParamsCopyHandler<O, N> handler) {
        List<N> result = new ArrayList<>();
        try {
            for (O old : data) {
                N e = handler.handle(old);
                result.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result.size() == data.size()) {
            this.list = result;
        }
        return this;
    }

    /**
     * 填充字段
     **/
    @SuppressWarnings("unchecked")
    public <O> PageTimeResult fillFields(ParamsFillHandler<O> handler) {
        List<O> result = new ArrayList<>();
        try {
            for (Object old : list) {
                O o = handler.handle((O) old);
                result.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result.size() == list.size()) {
            this.list = result;
        }

        return this;
    }

    @SuppressWarnings("unchecked")
    private <N, O> Class<N> getGenericityClass(ParamsCopyHandler<O, N> handler) {
        Type[] types = handler.getClass().getGenericInterfaces();
        ParameterizedType type = (ParameterizedType) types[0];
        return (Class<N>) type.getActualTypeArguments()[1];
    }

    @SuppressWarnings("unchecked")
    public <T> PageTimeResult add(T obj) {
        if (null == list) {
            list = new ArrayList<T>();
        }
        list.add(obj);
        return this;
    }

    Integer page;

    Integer size;

    Long total;
    Long synTime;

    List list = new ArrayList(0);

    public Long getSynTime() {
        return synTime;
    }

    public void setSynTime(Long synTime) {
        this.synTime = synTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

}
