package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class r11 {
    /* renamed from: a */
    public static IconCompat m7163a(Icon icon) {
        Preconditions.checkNotNull(icon);
        int m7166d = m7166d(icon);
        if (m7166d != 2) {
            if (m7166d != 4) {
                if (m7166d != 6) {
                    IconCompat iconCompat = new IconCompat(-1);
                    iconCompat.f3650a = icon;
                    return iconCompat;
                }
                return IconCompat.createWithAdaptiveBitmapContentUri(m7167e(icon));
            }
            return IconCompat.createWithContentUri(m7167e(icon));
        }
        return IconCompat.createWithResource(null, m7165c(icon), m7164b(icon));
    }

    /* renamed from: b */
    public static int m7164b(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return t11.m7433a(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    /* renamed from: c */
    public static String m7165c(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return t11.m7434b(obj);
        }
        try {
            return (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon package", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon package", e3);
            return null;
        }
    }

    /* renamed from: d */
    public static int m7166d(Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return t11.m7435c(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e);
            return -1;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e2);
            return -1;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e3);
            return -1;
        }
    }

    @Nullable
    @DoNotInline
    /* renamed from: e */
    public static Uri m7167e(@NonNull Object obj) {
        if (Build.VERSION.SDK_INT >= 28) {
            return t11.m7436d(obj);
        }
        try {
            return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon uri", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        }
    }

    @DoNotInline
    /* renamed from: f */
    public static Drawable m7168f(Icon icon, Context context) {
        return icon.loadDrawable(context);
    }

    @DoNotInline
    /* renamed from: g */
    public static Icon m7169g(IconCompat iconCompat, Context context) {
        Icon createWithBitmap;
        switch (iconCompat.mType) {
            case -1:
                return (Icon) iconCompat.f3650a;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f3650a);
                break;
            case 2:
                createWithBitmap = Icon.createWithResource(iconCompat.getResPackage(), iconCompat.mInt1);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) iconCompat.f3650a, iconCompat.mInt1, iconCompat.mInt2);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) iconCompat.f3650a);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 26) {
                    createWithBitmap = s11.m7317b((Bitmap) iconCompat.f3650a);
                    break;
                } else {
                    createWithBitmap = Icon.createWithBitmap(IconCompat.m846a((Bitmap) iconCompat.f3650a, false));
                    break;
                }
            case 6:
                int i = Build.VERSION.SDK_INT;
                if (i >= 30) {
                    createWithBitmap = u11.m7519a(iconCompat.getUri());
                    break;
                } else if (context != null) {
                    InputStream uriInputStream = iconCompat.getUriInputStream(context);
                    if (uriInputStream != null) {
                        if (i >= 26) {
                            createWithBitmap = s11.m7317b(BitmapFactory.decodeStream(uriInputStream));
                            break;
                        } else {
                            createWithBitmap = Icon.createWithBitmap(IconCompat.m846a(BitmapFactory.decodeStream(uriInputStream), false));
                            break;
                        }
                    } else {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.getUri());
                    }
                } else {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.getUri());
                }
        }
        ColorStateList colorStateList = iconCompat.mTintList;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = iconCompat.f3651b;
        if (mode != IconCompat.f3649c) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }
}
