package com.hisona.allive;

import com.hisona.allive.BackgroundTask;
import io.reactivex.rxjava3.observers.DisposableObserver;

/* renamed from: com.hisona.allive.a */
/* loaded from: classes2.dex */
public final class C1064a extends DisposableObserver {

    /* renamed from: b */
    public final /* synthetic */ BackgroundTask f15970b;

    public C1064a(BackgroundTask backgroundTask) {
        this.f15970b = backgroundTask;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onComplete() {
        this.f15970b.mObserver = null;
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onError(Throwable th) {
        this.f15970b.onPostExecute(new BackgroundTask.ProgressOrResult(-1, -1));
    }

    @Override // io.reactivex.rxjava3.core.Observer
    public final void onNext(Object obj) {
        BackgroundTask.ProgressOrResult progressOrResult = (BackgroundTask.ProgressOrResult) obj;
        int i = progressOrResult.progress;
        BackgroundTask backgroundTask = this.f15970b;
        if (i >= 0) {
            backgroundTask.onProgressUpdate(Integer.valueOf(i));
        } else {
            backgroundTask.onPostExecute(progressOrResult);
        }
    }
}
