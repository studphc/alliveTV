package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes.dex */
public final class DrawableDecoderCompat {

    /* renamed from: a */
    public static volatile boolean f8930a = true;

    /* renamed from: a */
    public static Drawable m2360a(Context context, Context context2, int i, Resources.Theme theme) {
        Context context3;
        try {
            if (f8930a) {
                if (theme != null) {
                    context3 = new ContextThemeWrapper(context2, theme);
                } else {
                    context3 = context2;
                }
                return AppCompatResources.getDrawable(context3, i);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i);
            }
            throw e;
        } catch (NoClassDefFoundError unused2) {
            f8930a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return ResourcesCompat.getDrawable(context2.getResources(), i, theme);
    }

    public static Drawable getDrawable(Context context, Context context2, @DrawableRes int i) {
        return m2360a(context, context2, i, null);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i, @Nullable Resources.Theme theme) {
        return m2360a(context, context, i, theme);
    }
}
