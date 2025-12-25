package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.google.android.gms.common.images.b */
/* loaded from: classes.dex */
public final class RunnableC0753b implements Runnable {

    /* renamed from: a */
    public final Uri f13360a;

    /* renamed from: b */
    public final Bitmap f13361b;

    /* renamed from: c */
    public final CountDownLatch f13362c;

    /* renamed from: d */
    public final /* synthetic */ ImageManager f13363d;

    public RunnableC0753b(ImageManager imageManager, Uri uri, Bitmap bitmap, CountDownLatch countDownLatch) {
        this.f13363d = imageManager;
        this.f13360a = uri;
        this.f13361b = bitmap;
        this.f13362c = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f13363d.f13347e.remove(this.f13360a);
        if (imageReceiver != null) {
            ArrayList arrayList = imageReceiver.f13350b;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zag zagVar = (zag) arrayList.get(i);
                Bitmap bitmap = this.f13361b;
                if (bitmap != null) {
                    Context context = this.f13363d.f13343a;
                    zagVar.getClass();
                    Asserts.checkNotNull(bitmap);
                    zagVar.zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
                } else {
                    this.f13363d.f13348f.put(this.f13360a, Long.valueOf(SystemClock.elapsedRealtime()));
                    zagVar.m3135a(this.f13363d.f13343a, false);
                }
                if (!(zagVar instanceof zaf)) {
                    this.f13363d.f13346d.remove(zagVar);
                }
            }
        }
        this.f13362c.countDown();
        synchronized (ImageManager.f13340g) {
            ImageManager.f13341h.remove(this.f13360a);
        }
    }
}
