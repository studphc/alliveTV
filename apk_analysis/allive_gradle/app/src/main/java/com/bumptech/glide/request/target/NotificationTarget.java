package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public class NotificationTarget extends CustomTarget<Bitmap> {

    /* renamed from: d */
    public final RemoteViews f9116d;

    /* renamed from: e */
    public final Context f9117e;

    /* renamed from: f */
    public final int f9118f;

    /* renamed from: g */
    public final String f9119g;

    /* renamed from: h */
    public final Notification f9120h;

    /* renamed from: i */
    public final int f9121i;

    public NotificationTarget(Context context, int i, RemoteViews remoteViews, Notification notification, int i2) {
        this(context, i, remoteViews, notification, i2, null);
    }

    /* renamed from: a */
    public final void m2395a(Bitmap bitmap) {
        this.f9116d.setImageViewBitmap(this.f9121i, bitmap);
        ((NotificationManager) Preconditions.checkNotNull((NotificationManager) this.f9117e.getSystemService("notification"))).notify(this.f9119g, this.f9118f, this.f9120h);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
        m2395a(null);
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    public NotificationTarget(Context context, int i, RemoteViews remoteViews, Notification notification, int i2, String str) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, notification, i2, str);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        m2395a(bitmap);
    }

    public NotificationTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, Notification notification, int i4, String str) {
        super(i, i2);
        this.f9117e = (Context) Preconditions.checkNotNull(context, "Context must not be null!");
        this.f9120h = (Notification) Preconditions.checkNotNull(notification, "Notification object can not be null!");
        this.f9116d = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.f9121i = i3;
        this.f9118f = i4;
        this.f9119g = str;
    }
}
