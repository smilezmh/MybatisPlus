package jm.mes.api.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public class JsonResultPage<T> {
    public Page<T> page;
    public String msg;
    public Boolean isSuccess;
    public String httpCode;
    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(String httpCode) {
        this.httpCode = httpCode;
    }


}
