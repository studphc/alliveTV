package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Queue;
import java.util.TreeMap;
import p000.AbstractC1726qj;
import p000.C1540m9;
import p000.kk2;
import p000.le1;
import p000.lk2;
import p000.n62;
import p000.ne1;

@RequiresApi(19)
/* loaded from: classes.dex */
public class SizeConfigStrategy implements ne1 {

    /* renamed from: d */
    public static final Bitmap.Config[] f8708d;

    /* renamed from: e */
    public static final Bitmap.Config[] f8709e;

    /* renamed from: f */
    public static final Bitmap.Config[] f8710f;

    /* renamed from: g */
    public static final Bitmap.Config[] f8711g;

    /* renamed from: h */
    public static final Bitmap.Config[] f8712h;

    /* renamed from: a */
    public final le1 f8713a = new le1(1);

    /* renamed from: b */
    public final C1540m9 f8714b = new C1540m9(14);

    /* renamed from: c */
    public final HashMap f8715c = new HashMap();

    static {
        Bitmap.Config config;
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            int length = configArr.length - 1;
            config = Bitmap.Config.RGBA_F16;
            configArr[length] = config;
        }
        f8708d = configArr;
        f8709e = configArr;
        f8710f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f8711g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f8712h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    /* renamed from: b */
    public static String m2329b(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    /* renamed from: a */
    public final void m2330a(Integer num, Bitmap bitmap) {
        NavigableMap m2331c = m2331c(bitmap.getConfig());
        Integer num2 = (Integer) m2331c.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                m2331c.remove(num);
                return;
            } else {
                m2331c.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + logBitmap(bitmap) + ", this: " + this);
    }

    /* renamed from: c */
    public final NavigableMap m2331c(Bitmap.Config config) {
        HashMap hashMap = this.f8715c;
        NavigableMap navigableMap = (NavigableMap) hashMap.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            hashMap.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3 A[EDGE_INSN: B:34:0x00a3->B:20:0x00a3 BREAK  A[LOOP:0: B:10:0x0055->B:32:0x00a1], SYNTHETIC] */
    @Override // p000.ne1
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap get(int i, int i2, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int length;
        Bitmap bitmap;
        Bitmap.Config config2;
        int i3 = 0;
        int bitmapByteSize = Util.getBitmapByteSize(i, i2, config);
        le1 le1Var = this.f8713a;
        n62 n62Var = (n62) ((Queue) le1Var.f17677a).poll();
        if (n62Var == null) {
            n62Var = le1Var.m5922q();
        }
        lk2 lk2Var = (lk2) n62Var;
        lk2Var.f22550b = bitmapByteSize;
        lk2Var.f22551c = config;
        if (Build.VERSION.SDK_INT >= 26) {
            config2 = Bitmap.Config.RGBA_F16;
            if (config2.equals(config)) {
                configArr = f8709e;
                length = configArr.length;
                while (true) {
                    if (i3 < length) {
                        break;
                    }
                    Bitmap.Config config3 = configArr[i3];
                    Integer num = (Integer) m2331c(config3).ceilingKey(Integer.valueOf(bitmapByteSize));
                    if (num != null && num.intValue() <= bitmapByteSize * 8) {
                        if (num.intValue() != bitmapByteSize || (config3 != null ? !config3.equals(config) : config != null)) {
                            le1Var.m4942b(lk2Var);
                            int intValue = num.intValue();
                            Object obj = (n62) ((Queue) le1Var.f17677a).poll();
                            if (obj == null) {
                                obj = le1Var.m5922q();
                            }
                            lk2Var = (lk2) obj;
                            lk2Var.f22550b = intValue;
                            lk2Var.f22551c = config3;
                        }
                    } else {
                        i3++;
                    }
                }
                bitmap = (Bitmap) this.f8714b.m6094d(lk2Var);
                if (bitmap != null) {
                    m2330a(Integer.valueOf(lk2Var.f22550b), bitmap);
                    bitmap.reconfigure(i, i2, config);
                }
                return bitmap;
            }
        }
        int i4 = kk2.f20887a[config.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        configArr = new Bitmap.Config[]{config};
                    } else {
                        configArr = f8712h;
                    }
                } else {
                    configArr = f8711g;
                }
            } else {
                configArr = f8710f;
            }
        } else {
            configArr = f8708d;
        }
        length = configArr.length;
        while (true) {
            if (i3 < length) {
            }
            i3++;
        }
        bitmap = (Bitmap) this.f8714b.m6094d(lk2Var);
        if (bitmap != null) {
        }
        return bitmap;
    }

    @Override // p000.ne1
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    @Override // p000.ne1
    public String logBitmap(Bitmap bitmap) {
        return m2329b(Util.getBitmapByteSize(bitmap), bitmap.getConfig());
    }

    @Override // p000.ne1
    public void put(Bitmap bitmap) {
        int bitmapByteSize = Util.getBitmapByteSize(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        le1 le1Var = this.f8713a;
        n62 n62Var = (n62) ((Queue) le1Var.f17677a).poll();
        if (n62Var == null) {
            n62Var = le1Var.m5922q();
        }
        lk2 lk2Var = (lk2) n62Var;
        lk2Var.f22550b = bitmapByteSize;
        lk2Var.f22551c = config;
        this.f8714b.m6101k(lk2Var, bitmap);
        NavigableMap m2331c = m2331c(bitmap.getConfig());
        Integer num = (Integer) m2331c.get(Integer.valueOf(lk2Var.f22550b));
        Integer valueOf = Integer.valueOf(lk2Var.f22550b);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        m2331c.put(valueOf, Integer.valueOf(i));
    }

    @Override // p000.ne1
    @Nullable
    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.f8714b.m6105o();
        if (bitmap != null) {
            m2330a(Integer.valueOf(Util.getBitmapByteSize(bitmap)), bitmap);
        }
        return bitmap;
    }

    public String toString() {
        StringBuilder m7064t = AbstractC1726qj.m7064t("SizeConfigStrategy{groupedMap=");
        m7064t.append(this.f8714b);
        m7064t.append(", sortedSizes=(");
        HashMap hashMap = this.f8715c;
        for (Map.Entry entry : hashMap.entrySet()) {
            m7064t.append(entry.getKey());
            m7064t.append('[');
            m7064t.append(entry.getValue());
            m7064t.append("], ");
        }
        if (!hashMap.isEmpty()) {
            m7064t.replace(m7064t.length() - 2, m7064t.length(), "");
        }
        m7064t.append(")}");
        return m7064t.toString();
    }

    @Override // p000.ne1
    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return m2329b(Util.getBitmapByteSize(i, i2, config), config);
    }
}
