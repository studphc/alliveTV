package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class DisplayCompat {
    /* renamed from: a */
    public static Point m903a(Context context, Display display) {
        Point m904b;
        if (Build.VERSION.SDK_INT < 28) {
            m904b = m904b("sys.display-size", display);
        } else {
            m904b = m904b("vendor.display-size", display);
        }
        if (m904b != null) {
            return m904b;
        }
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager == null || uiModeManager.getCurrentModeType() != 4 || !"Sony".equals(Build.MANUFACTURER) || !Build.MODEL.startsWith("BRAVIA") || !context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
            return null;
        }
        Display.Mode mode = display.getMode();
        for (Display.Mode mode2 : display.getSupportedModes()) {
            if (mode.getPhysicalHeight() < mode2.getPhysicalHeight() || mode.getPhysicalWidth() < mode2.getPhysicalWidth()) {
                return null;
            }
        }
        return new Point(3840, 2160);
    }

    /* renamed from: b */
    public static Point m904b(String str, Display display) {
        String str2;
        if (display.getDisplayId() != 0) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Exception unused) {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && str2 != null) {
            try {
                String[] split = str2.trim().split("x", -1);
                if (split.length == 2) {
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    if (parseInt > 0 && parseInt2 > 0) {
                        return new Point(parseInt, parseInt2);
                    }
                }
                throw new NumberFormatException();
            } catch (NumberFormatException unused2) {
            }
        }
        return null;
    }

    @NonNull
    public static ModeCompat getMode(@NonNull Context context, @NonNull Display display) {
        Display.Mode mode = display.getMode();
        Point m903a = m903a(context, display);
        if (m903a != null && !AbstractC0199a.m920a(mode, m903a)) {
            return new ModeCompat(mode, m903a);
        }
        return new ModeCompat(mode, true);
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        boolean z;
        ModeCompat modeCompat;
        Display.Mode[] supportedModes = display.getSupportedModes();
        ModeCompat[] modeCompatArr = new ModeCompat[supportedModes.length];
        Display.Mode mode = display.getMode();
        Point m903a = m903a(context, display);
        if (m903a != null && !AbstractC0199a.m920a(mode, m903a)) {
            for (int i = 0; i < supportedModes.length; i++) {
                Display.Mode mode2 = supportedModes[i];
                if (mode2.getPhysicalWidth() == mode.getPhysicalWidth() && mode2.getPhysicalHeight() == mode.getPhysicalHeight()) {
                    modeCompat = new ModeCompat(supportedModes[i], m903a);
                } else {
                    modeCompat = new ModeCompat(supportedModes[i], false);
                }
                modeCompatArr[i] = modeCompat;
            }
        } else {
            for (int i2 = 0; i2 < supportedModes.length; i2++) {
                Display.Mode mode3 = supportedModes[i2];
                if (mode3.getPhysicalWidth() == mode.getPhysicalWidth() && mode3.getPhysicalHeight() == mode.getPhysicalHeight()) {
                    z = true;
                } else {
                    z = false;
                }
                modeCompatArr[i2] = new ModeCompat(supportedModes[i2], z);
            }
        }
        return modeCompatArr;
    }

    /* loaded from: classes.dex */
    public static final class ModeCompat {

        /* renamed from: a */
        public final Display.Mode f3869a;

        /* renamed from: b */
        public final Point f3870b;

        /* renamed from: c */
        public final boolean f3871c;

        public ModeCompat(Display.Mode mode, boolean z) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            this.f3870b = new Point(AbstractC0204b.m938b(mode), AbstractC0204b.m937a(mode));
            this.f3869a = mode;
            this.f3871c = z;
        }

        public int getPhysicalHeight() {
            return this.f3870b.y;
        }

        public int getPhysicalWidth() {
            return this.f3870b.x;
        }

        @Deprecated
        public boolean isNative() {
            return this.f3871c;
        }

        @Nullable
        @RequiresApi(23)
        public Display.Mode toMode() {
            return this.f3869a;
        }

        public ModeCompat(Display.Mode mode, Point point) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.f3870b = point;
            this.f3869a = mode;
            this.f3871c = true;
        }
    }
}
