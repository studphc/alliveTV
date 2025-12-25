package com.hisona.allive;

import android.app.Activity;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import p000.C1294i5;

/* loaded from: classes2.dex */
public abstract class BackgroundTask {
    protected DisposableObserver<ProgressOrResult> mObserver;
    public ResultListener mResultListener;
    protected WeakReference<Activity> mWeakReference;

    /* loaded from: classes2.dex */
    public static class ProgressOrResult {
        public int progress;
        public int result;

        public ProgressOrResult(int i, int i2) {
            this.progress = i;
            this.result = i2;
        }
    }

    public BackgroundTask(Activity activity) {
        this.mWeakReference = new WeakReference<>(activity);
        this.mResultListener = null;
    }

    public void cancel() {
        DisposableObserver<ProgressOrResult> disposableObserver = this.mObserver;
        if (disposableObserver != null && !disposableObserver.isDisposed()) {
            this.mObserver.dispose();
        }
    }

    public void doInBackground(ObservableEmitter<ProgressOrResult> observableEmitter) {
    }

    public void execute() {
        onPreExecute();
        Observable create = Observable.create(new C1294i5(2, this));
        this.mObserver = new C1064a(this);
        create.subscribeOn(Schedulers.m5318io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.mObserver);
    }

    public String getString(int i) {
        return this.mWeakReference.get().getString(i);
    }

    public final boolean isCancelled(ObservableEmitter<ProgressOrResult> observableEmitter) {
        if (observableEmitter != null && !observableEmitter.isDisposed()) {
            return false;
        }
        return true;
    }

    public void onPostExecute(ProgressOrResult progressOrResult) {
    }

    public void onPreExecute() {
    }

    public void onProgressUpdate(Integer num) {
    }

    public BackgroundTask(Activity activity, ResultListener resultListener) {
        this.mWeakReference = new WeakReference<>(activity);
        this.mResultListener = resultListener;
    }
}
