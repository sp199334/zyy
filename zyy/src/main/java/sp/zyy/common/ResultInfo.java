package sp.zyy.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
  * 类名：Result.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年6月26日
  * @version    1.0
*/

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultInfo<T> {
    private String status;
    private String msg;
    private T result;
    private List<T> resultList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

}
