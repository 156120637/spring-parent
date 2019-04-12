package com.dangdang.common.utils.page;

import com.dangdang.common.exception.BaseException;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * Create by tianjiaqin 2018/11/12
 */
@Data
@SuppressWarnings("rawtypes")
public class PageResult {

    private Integer page;

    private Integer size;

    private Long total;

    private List list = new ArrayList(0);

    private PageResult() {
    }

    public static PageResult create() {
        return new PageResult();
    }

    public PageResult page(Integer page) {
        this.page = page;
        return this;
    }

    public PageResult size(Integer size) {
        this.size = size;
        return this;
    }

    public PageResult total(Long total) {
        this.total = total;
        return this;
    }

    public <T> PageResult data(List<T> list) {
        this.list = list;
        return this;
    }

    /**
     * 自动全属性拷贝
     **/
    public <E> PageResult copy(Class<E> clazz, String... ignores) {
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
    public <O, N> PageResult copy(ParamsCopyHandler<O, N> handler) {
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
    public <O, N> PageResult copy(List<O> data, ParamsCopyHandler<O, N> handler) throws BaseException {
        List<N> result = new ArrayList<>();

        for (O old : data) {
            N e = handler.handle(old);
            result.add(e);
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
    public <O> PageResult fillFields(ParamsFillHandler<O> handler) {
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
    public <T> PageResult add(T obj) {
        if (null == list) {
            list = new ArrayList<T>();
        }
        list.add(obj);
        return this;
    }

    public static PageResult resultEmpty(Integer page, Integer size) {
        PageResult result = new PageResult();
        result.setPage(page);
        result.setSize(size);
        result.setList(new ArrayList<>());
        result.setTotal(0L);
        return result;
    }
}
