package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import java.util.HashSet;
import p000.d83;

/* renamed from: com.google.android.gms.common.images.a */
/* loaded from: classes.dex */
public final class RunnableC0752a implements Runnable {

    /* renamed from: a */
    public final zag f13358a;

    /* renamed from: b */
    public final /* synthetic */ ImageManager f13359b;

    public RunnableC0752a(ImageManager imageManager, zag zagVar) {
        this.f13359b = imageManager;
        this.f13358a = zagVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f13359b.f13346d.get(this.f13358a);
        if (imageReceiver != null) {
            ImageManager imageManager = this.f13359b;
            imageManager.f13346d.remove(this.f13358a);
            zag zagVar = this.f13358a;
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            imageReceiver.f13350b.remove(zagVar);
        }
        zag zagVar2 = this.f13358a;
        d83 d83Var = zagVar2.f13366a;
        Uri uri = d83Var.f16292a;
        if (uri != null) {
            Long l = (Long) this.f13359b.f13348f.get(uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.f13358a.m3135a(this.f13359b.f13343a, true);
                    return;
                } else {
                    ImageManager imageManager2 = this.f13359b;
                    imageManager2.f13348f.remove(d83Var.f16292a);
                }
            }
            this.f13358a.zaa(null, false, true, false);
            ImageManager imageManager3 = this.f13359b;
            ImageManager.ImageReceiver imageReceiver2 = (ImageManager.ImageReceiver) imageManager3.f13347e.get(d83Var.f16292a);
            if (imageReceiver2 == null) {
                ImageManager.ImageReceiver imageReceiver3 = new ImageManager.ImageReceiver(d83Var.f16292a);
                ImageManager imageManager4 = this.f13359b;
                imageManager4.f13347e.put(d83Var.f16292a, imageReceiver3);
                imageReceiver2 = imageReceiver3;
            }
            zag zagVar3 = this.f13358a;
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            imageReceiver2.f13350b.add(zagVar3);
            zag zagVar4 = this.f13358a;
            if (!(zagVar4 instanceof zaf)) {
                this.f13359b.f13346d.put(zagVar4, imageReceiver2);
            }
            synchronized (ImageManager.f13340g) {
                try {
                    HashSet hashSet = ImageManager.f13341h;
                    if (!hashSet.contains(d83Var.f16292a)) {
                        hashSet.add(d83Var.f16292a);
                        imageReceiver2.m3134a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        zagVar2.m3135a(this.f13359b.f13343a, true);
    }
}
