package com.nextnepal.nextNepalPatro.util.values;

import com.nextnepal.nextNepalPatro.util.mvp.view.BaseView;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public abstract class CallbackWrapper<T extends BaseResponse> extends DisposableObserver<T> {
    private WeakReference<BaseView> weakReference;

    public CallbackWrapper(WeakReference<BaseView> weakReference) {
        this.weakReference = weakReference;
    }

    protected abstract void onSucess(T t);

    @Override
    public void onNext(T t) {
        onSucess(t);
    }

    @Override
    public void onError(Throwable e) {
//        BaseView view = weakReference.get();
//        if (e instanceof HttpException) {
//            ResponseBody responseBody = ((HttpException) e).response().errorBody();
//            view.onUnknownError(getErrorMessage(responseBody));
//        } else if (e instanceof SocketTimeoutException) {
//            view.onTimeout();
//        } else if (e instanceof IOException) {
//            view.onNetworkError();
//        } else if (e instanceof OnErrorNotImplementedException) {
//            view.onErrorNotImplementedException();
//        } else {
//            view.onUnknownError(e.getMessage());
//        }

    }

    private String getErrorMessage(ResponseBody responseBody) {
        try {
            JSONObject jsonObject = new JSONObject(responseBody.string());
            return jsonObject.getString("message");
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
