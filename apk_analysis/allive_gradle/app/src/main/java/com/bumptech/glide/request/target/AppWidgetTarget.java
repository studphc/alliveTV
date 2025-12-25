package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public class AppWidgetTarget extends CustomTarget<Bitmap> {

    /* renamed from: d */
    public final int[] f9095d;

    /* renamed from: e */
    public final ComponentName f9096e;

    /* renamed from: f */
    public final RemoteViews f9097f;

    /* renamed from: g */
    public final Context f9098g;

    /* renamed from: h */
    public final int f9099h;

    public AppWidgetTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, int... iArr) {
        super(i, i2);
        if (iArr.length != 0) {
            this.f9098g = (Context) Preconditions.checkNotNull(context, "Context can not be null!");
            this.f9097f = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
            this.f9095d = (int[]) Preconditions.checkNotNull(iArr, "WidgetIds can not be null!");
            this.f9099h = i3;
            this.f9096e = null;
            return;
        }
        throw new IllegalArgumentException("WidgetIds must have length > 0");
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
        RemoteViews remoteViews = this.f9097f;
        remoteViews.setImageViewBitmap(this.f9099h, null);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f9098g);
        ComponentName componentName = this.f9096e;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, remoteViews);
        } else {
            appWidgetManager.updateAppWidget(this.f9095d, remoteViews);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable Transition transition) {
        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
    }

    public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
        RemoteViews remoteViews = this.f9097f;
        remoteViews.setImageViewBitmap(this.f9099h, bitmap);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f9098g);
        ComponentName componentName = this.f9096e;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, remoteViews);
        } else {
            appWidgetManager.updateAppWidget(this.f9095d, remoteViews);
        }
    }

    public AppWidgetTarget(Context context, int i, RemoteViews remoteViews, int... iArr) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, iArr);
    }

    public AppWidgetTarget(Context context, int i, int i2, int i3, RemoteViews remoteViews, ComponentName componentName) {
        super(i, i2);
        this.f9098g = (Context) Preconditions.checkNotNull(context, "Context can not be null!");
        this.f9097f = (RemoteViews) Preconditions.checkNotNull(remoteViews, "RemoteViews object can not be null!");
        this.f9096e = (ComponentName) Preconditions.checkNotNull(componentName, "ComponentName can not be null!");
        this.f9099h = i3;
        this.f9095d = null;
    }

    public AppWidgetTarget(Context context, int i, RemoteViews remoteViews, ComponentName componentName) {
        this(context, Integer.MIN_VALUE, Integer.MIN_VALUE, i, remoteViews, componentName);
    }
}
