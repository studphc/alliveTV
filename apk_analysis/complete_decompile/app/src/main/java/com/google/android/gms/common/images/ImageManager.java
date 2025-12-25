package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.google.android.gms.internal.base.zam;
import com.google.android.gms.internal.base.zat;
import com.google.android.gms.internal.base.zau;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import p000.sk1;

/* loaded from: classes.dex */
public final class ImageManager {

    /* renamed from: g */
    public static final Object f13340g = new Object();

    /* renamed from: h */
    public static final HashSet f13341h = new HashSet();

    /* renamed from: i */
    public static ImageManager f13342i;

    /* renamed from: a */
    public final Context f13343a;

    /* renamed from: b */
    public final zau f13344b = new zau(Looper.getMainLooper());

    /* renamed from: c */
    public final ExecutorService f13345c = zat.zaa().zab(4, 2);

    /* renamed from: d */
    public final HashMap f13346d;

    /* renamed from: e */
    public final HashMap f13347e;

    /* renamed from: f */
    public final HashMap f13348f;

    @KeepName
    /* loaded from: classes.dex */
    public final class ImageReceiver extends ResultReceiver {

        /* renamed from: a */
        public final Uri f13349a;

        /* renamed from: b */
        public final ArrayList f13350b;

        public ImageReceiver(Uri uri) {
            super(new zau(Looper.getMainLooper()));
            this.f13349a = uri;
            this.f13350b = new ArrayList();
        }

        /* renamed from: a */
        public final void m3134a() {
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.setPackage("com.google.android.gms");
            intent.putExtra(Constants.EXTRA_URI, this.f13349a);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            ImageManager.this.f13343a.sendBroadcast(intent);
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i, Bundle bundle) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager imageManager = ImageManager.this;
            imageManager.f13345c.execute(new sk1(imageManager, this.f13349a, parcelFileDescriptor, 2));
        }
    }

    /* loaded from: classes.dex */
    public interface OnImageLoadedListener {
        void onImageLoaded(@NonNull Uri uri, @Nullable Drawable drawable, boolean z);
    }

    public ImageManager(Context context) {
        this.f13343a = context.getApplicationContext();
        new zam();
        this.f13346d = new HashMap();
        this.f13347e = new HashMap();
        this.f13348f = new HashMap();
    }

    @NonNull
    public static ImageManager create(@NonNull Context context) {
        if (f13342i == null) {
            f13342i = new ImageManager(context);
        }
        return f13342i;
    }

    public void loadImage(@NonNull ImageView imageView, int i) {
        zaj(new zae(imageView, i));
    }

    public final void zaj(zag zagVar) {
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new RunnableC0752a(this, zagVar).run();
    }

    public void loadImage(@NonNull ImageView imageView, @NonNull Uri uri) {
        zaj(new zae(imageView, uri));
    }

    public void loadImage(@NonNull ImageView imageView, @NonNull Uri uri, int i) {
        zae zaeVar = new zae(imageView, uri);
        zaeVar.zab = i;
        zaj(zaeVar);
    }

    public void loadImage(@NonNull OnImageLoadedListener onImageLoadedListener, @NonNull Uri uri) {
        zaj(new zaf(onImageLoadedListener, uri));
    }

    public void loadImage(@NonNull OnImageLoadedListener onImageLoadedListener, @NonNull Uri uri, int i) {
        zaf zafVar = new zaf(onImageLoadedListener, uri);
        zafVar.zab = i;
        zaj(zafVar);
    }
}
