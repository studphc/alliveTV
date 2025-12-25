package com.hisona.allive;

import com.hisona.allive.BackgroundTask;
import io.reactivex.rxjava3.observers.DisposableObserver;

/* loaded from: classes2.dex */
public final class a extends DisposableObserver {
    public final /* synthetic */ BackgroundTask b;

    public a(BackgroundTask backgroundTask) {
        this.b = backgroundTask;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.b.mObserver = null;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.b.onPostExecute(new BackgroundTask.ProgressOrResult(-1, -1));
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        BackgroundTask.ProgressOrResult progressOrResult = (BackgroundTask.ProgressOrResult) obj;
        int i = progressOrResult.progress;
        BackgroundTask backgroundTask = this.b;
        if (i >= 0) {
            backgroundTask.onProgressUpdate(Integer.valueOf(i));
        } else {
            backgroundTask.onPostExecute(progressOrResult);
        }
    }
}
